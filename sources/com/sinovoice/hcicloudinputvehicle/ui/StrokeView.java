package com.sinovoice.hcicloudinputvehicle.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudsdk.common.HciErrorCode;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class StrokeView extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final String f263a = StrokeView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private List<c> f264b;
    private Path c;
    private Paint d;
    private float e;
    private int f;
    private int[] g;
    private int[] h;
    private OnStrokeActionListener i;
    private ArrayList<Point> j;
    private float k;
    private float l;
    private int m;
    private View n;
    private Rect o;
    private int p;
    private int q;
    private com.sinovoice.hcicloudinputvehicle.ui.c r;
    private int s;
    private int t;
    private Handler u;
    private List<Integer> v;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StrokeView.this.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            com.sinovoice.hcicloudinputvehicle.ui.b.f().a();
            StrokeView.this.i.onWriteEnd(com.sinovoice.hcicloudinputvehicle.ui.b.f().d());
            if (StrokeView.this.m == 0) {
                StrokeView.this.r.a();
            }
            StrokeView.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        private Path f267a;

        public c(Path path) {
            this.f267a = path;
        }

        public Path a() {
            return this.f267a;
        }
    }

    public StrokeView(Context context) {
        this(context, null);
    }

    private void e(Canvas canvas) {
        if (this.h != null) {
            int i = 0;
            for (int size = this.f264b.size() - 1; size >= 0; size--) {
                this.d.setColor(this.h[i]);
                canvas.drawPath(this.f264b.get(size).a(), this.d);
                if (i < this.g.length - 1) {
                    i++;
                }
                if (this.v.contains(Integer.valueOf(size)) && size < this.j.size()) {
                    Point point = this.j.get(size);
                    canvas.drawPoint(point.x, point.y, this.d);
                }
            }
        }
        this.d.setColor(this.f);
        canvas.drawPath(this.c, this.d);
    }

    private void f(MotionEvent motionEvent) {
        b.b.a.b.a.a(f263a, "handleTouchDown");
        m();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int i = (int) x;
        int i2 = (int) y;
        com.sinovoice.hcicloudinputvehicle.ui.b.f().b((short) i, (short) i2);
        this.k = x;
        this.l = y;
        this.c.moveTo(x, y);
        this.s = i;
        this.t = i2;
        this.j.add(new Point(this.s, this.t));
        invalidate();
    }

    private void g(MotionEvent motionEvent) {
        b.b.a.b.a.a(f263a, "handleTouchMove");
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        com.sinovoice.hcicloudinputvehicle.ui.b.f().b((short) x, (short) y);
        float abs = Math.abs(x - this.k);
        float abs2 = Math.abs(y - this.l);
        if (abs >= 4.0f || abs2 >= 4.0f) {
            Path path = this.c;
            float f = this.k;
            float f2 = this.l;
            path.quadTo(f, f2, (x + f) / 2.0f, (y + f2) / 2.0f);
            this.k = x;
            this.l = y;
        }
        invalidate();
    }

    private void h(MotionEvent motionEvent) {
        b.b.a.b.a.a(f263a, "handleTouchUp");
        com.sinovoice.hcicloudinputvehicle.ui.b.f().c();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (x == this.s && y == this.t) {
            this.v.add(Integer.valueOf(this.j.size() - 1));
        }
        this.f264b.add(new c(this.c));
        this.c = new Path();
        invalidate();
        if (com.sinovoice.hcicloudinputvehicle.ui.b.f().e() < 12 && this.m == 0) {
            com.sinovoice.hcicloudinputvehicle.ui.b.f().a();
            this.i.onPointTouch();
            d();
            return;
        }
        l();
    }

    private void i() {
        this.c = new Path();
        this.d = new Paint();
        this.f264b = new ArrayList();
        this.d.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeCap(Paint.Cap.ROUND);
        this.d.setStrokeJoin(Paint.Join.ROUND);
        this.d.setStrokeWidth(this.e);
        this.d.setColor(this.f);
        this.j = new ArrayList<>();
        setStrokeColor(getResources().getColor(R.color.strokeColor));
    }

    private void l() {
        this.u.removeMessages(1);
        Handler handler = this.u;
        handler.sendMessageDelayed(handler.obtainMessage(1), 500L);
    }

    private void m() {
        this.u.removeMessages(1);
    }

    private void setColorAlpha(int i) {
        int i2 = i & ViewCompat.MEASURED_SIZE_MASK;
        this.h = new int[this.g.length];
        int i3 = 0;
        while (true) {
            int[] iArr = this.g;
            if (i3 >= iArr.length) {
                return;
            }
            this.h[i3] = (iArr[i3] << 24) | i2;
            i3++;
        }
    }

    public void d() {
        this.j.clear();
        this.c.reset();
        this.f264b.clear();
        com.sinovoice.hcicloudinputvehicle.ui.b.f().g();
        invalidate();
    }

    public void j() {
        d();
        this.n = null;
        this.o = null;
    }

    public void k(int i, View view) {
        this.m = i;
        this.n = view;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.o != null) {
            this.n.post(new a());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        e(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.m;
        if (i3 == 1) {
            this.p = 1080;
            this.q = 440;
            setMeasuredDimension(1080, 440);
        } else if (i3 == 0) {
            Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
            this.p = defaultDisplay.getWidth();
            int height = defaultDisplay.getHeight();
            this.q = height;
            setMeasuredDimension(this.p, height);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.o == null) {
            this.o = new Rect();
            if (this.m == 1) {
                this.o = new Rect(this.o.left + getResources().getDimensionPixelOffset(R.dimen.keyboard_margin_left) + getResources().getDimensionPixelOffset(R.dimen.keyboard_key_hw_width), 0, (1080 - getResources().getDimensionPixelOffset(R.dimen.keyboard_key_hw_width)) - getResources().getDimensionPixelOffset(R.dimen.keyboard_margin_left), getResources().getDimensionPixelOffset(R.dimen.stroke_height));
            }
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                h(motionEvent);
            } else if (action == 2) {
                g(motionEvent);
            }
        } else if (this.m == 1 && !this.o.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        } else {
            f(motionEvent);
        }
        return true;
    }

    public void setContainer(com.sinovoice.hcicloudinputvehicle.ui.c cVar) {
        this.r = cVar;
    }

    public void setListener(OnStrokeActionListener onStrokeActionListener) {
        this.i = onStrokeActionListener;
    }

    public void setScriptWidth(float f) {
        this.e = f;
        this.d.setStrokeWidth(f);
    }

    public void setStrokeColor(int i) {
        this.f = i;
        setColorAlpha(i);
        this.d.setColor(this.f);
    }

    public StrokeView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StrokeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 8.0f;
        this.f = -15301639;
        this.g = new int[]{HciErrorCode.HCI_ERR_ASR_GRAMMAR_DATA_TOO_LARGE, 166, 128, 102, 89, 74, 61, 51, 41, 33, 28, 23, 18, 13, 8, 3, 0};
        this.u = new b();
        this.v = new ArrayList();
        i();
    }
}
