package com.sinovoice.hcicloudinputvehicle.ui.CandidateView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudinputvehicle.tools.f;
import com.sinovoice.hcicloudinputvehicle.ui.UITheme;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CandidateView extends View implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f237a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f238b = {16842919};
    private int A;
    private OnCandidateActionListener B;
    private Context C;
    private int D;
    private int E;
    private int F;
    private int G;
    private GestureDetector H;
    private int I;
    private final String c;
    private Paint d;
    private int e;
    private int f;
    private Drawable g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private b l;
    private b m;
    private b n;
    private b o;
    private b p;
    private b q;
    private b r;
    private int s;
    private Drawable t;
    private List<String> u;
    private final List<d> v;
    private int w;
    private int x;
    private int y;
    private Drawable z;

    /* loaded from: classes.dex */
    private class c extends GestureDetector.SimpleOnGestureListener {
        private c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            b.b.a.b.a.c(CandidateView.this.c, "onDoubleTap");
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            b.b.a.b.a.c(CandidateView.this.c, "onDoubleTapEvent");
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            b.b.a.b.a.c(CandidateView.this.c, "onDown");
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            b.b.a.b.a.c(CandidateView.this.c, "onLongPress");
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            String str = CandidateView.this.c;
            b.b.a.b.a.c(str, "onScroll distanceX = " + f);
            if (motionEvent == null || motionEvent2 == null) {
                return false;
            }
            if (motionEvent.getX() < CandidateView.this.w || motionEvent.getX() > CandidateView.this.G - 16) {
                return true;
            }
            int x = (int) motionEvent.getX();
            int x2 = (int) motionEvent2.getX();
            String str2 = CandidateView.this.c;
            b.b.a.b.a.c(str2, "onScroll downX" + x);
            String str3 = CandidateView.this.c;
            b.b.a.b.a.c(str3, "onScroll currX" + x2);
            int i = x2 - x;
            if (i > 0) {
                b.b.a.b.a.c(CandidateView.this.c, "右滑");
                if (CandidateView.this.v == null || CandidateView.this.v.size() <= 0 || ((d) CandidateView.this.v.get(0)).c - f >= CandidateView.this.w) {
                    b.b.a.b.a.c(CandidateView.this.c, "不能向右滑了");
                    return false;
                }
                String str4 = CandidateView.this.c;
                b.b.a.b.a.c(str4, "右滑 offX: " + CandidateView.this.I);
                String str5 = CandidateView.this.c;
                b.b.a.b.a.c(str5, "右滑 mDataWithPosition.getBoolean(0).x: " + ((d) CandidateView.this.v.get(0)).c);
                CandidateView.i(CandidateView.this, f);
                CandidateView candidateView = CandidateView.this;
                candidateView.setListWithPosition(candidateView.u);
                CandidateView.this.C();
                CandidateView.this.invalidate();
                return true;
            } else if (i < 0) {
                b.b.a.b.a.c(CandidateView.this.c, "左滑");
                if (CandidateView.this.v != null && CandidateView.this.v.size() > 0) {
                    CandidateView.i(CandidateView.this, f);
                    String str6 = CandidateView.this.c;
                    b.b.a.b.a.c(str6, "左滑 offX: " + CandidateView.this.I);
                    CandidateView candidateView2 = CandidateView.this;
                    candidateView2.setListWithPosition(candidateView2.u);
                    CandidateView.this.C();
                    int size = CandidateView.this.v.size();
                    if (size >= 1 && ((d) CandidateView.this.v.get(size - 1)).c <= CandidateView.this.e / 2) {
                        b.b.a.b.a.c(CandidateView.this.c, "左滑到头了");
                        CandidateView.h(CandidateView.this, f);
                        String str7 = CandidateView.this.c;
                        b.b.a.b.a.c(str7, "左滑 offX: " + CandidateView.this.I);
                        CandidateView candidateView3 = CandidateView.this;
                        candidateView3.setListWithPosition(candidateView3.u);
                        CandidateView.this.C();
                    }
                    CandidateView.this.invalidate();
                }
                return true;
            } else {
                return false;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            b.b.a.b.a.c(CandidateView.this.c, "onShowPress");
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            b.b.a.b.a.c(CandidateView.this.c, "onSingleTapConfirmed");
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            b.b.a.b.a.c(CandidateView.this.c, "onSingleTapUp");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public String f242a;

        /* renamed from: b  reason: collision with root package name */
        public String f243b;
        public int c;
        public int d;
        public int e;
        public boolean f;

        private d() {
            this.f243b = "";
        }

        public Rect a(Rect rect) {
            int i = this.c;
            rect.set(i, 11, this.e + i + (CandidateView.this.y * 2), CandidateView.this.f - 19);
            return rect;
        }
    }

    public CandidateView(Context context) {
        super(context);
        this.c = CandidateView.class.getSimpleName();
        this.h = 1;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.y = 40;
        this.A = -1;
        this.G = 913;
        this.C = context;
    }

    private void A(int i, int i2) {
        List<String> list = this.u;
        if (list != null && list.size() > 0) {
            if (this.i == 1 && w(i, i2)) {
                OnCandidateActionListener onCandidateActionListener = this.B;
                if (onCandidateActionListener != null) {
                    onCandidateActionListener.onMoreIconClick();
                }
            } else if (this.i == 2 && m(i, i2)) {
                OnCandidateActionListener onCandidateActionListener2 = this.B;
                if (onCandidateActionListener2 != null) {
                    onCandidateActionListener2.onClearIconClick();
                }
            } else {
                y(i, i2);
            }
        } else if (l(i, i2) && this.k) {
            OnCandidateActionListener onCandidateActionListener3 = this.B;
            if (onCandidateActionListener3 != null && !this.l.h) {
                onCandidateActionListener3.onKBIconClick();
            }
            this.l.c(true);
            this.m.c(false);
        } else if (r(i, i2) && this.k) {
            OnCandidateActionListener onCandidateActionListener4 = this.B;
            if (onCandidateActionListener4 != null && !this.m.h) {
                onCandidateActionListener4.onHWIconClick();
            }
            this.l.c(false);
            this.m.c(true);
        } else if (!n(i, i2)) {
            return;
        } else {
            OnCandidateActionListener onCandidateActionListener5 = this.B;
            if (onCandidateActionListener5 != null) {
                onCandidateActionListener5.onCloseIconClick();
            }
        }
        B();
    }

    private void B() {
        com.sinovoice.hcicloudinputvehicle.service.a.a().d(0);
    }

    static /* synthetic */ int h(CandidateView candidateView, float f) {
        int i = (int) (candidateView.I + f);
        candidateView.I = i;
        return i;
    }

    static /* synthetic */ int i(CandidateView candidateView, float f) {
        int i = (int) (candidateView.I - f);
        candidateView.I = i;
        return i;
    }

    private boolean l(int i, int i2) {
        return this.l.a(i, i2);
    }

    private boolean m(int i, int i2) {
        return this.o.a(i, i2);
    }

    private boolean n(int i, int i2) {
        return this.p.a(i, i2);
    }

    private void o(Canvas canvas) {
        canvas.save();
        canvas.clipRect(this.w, 0, this.G, this.f);
        Rect rect = new Rect();
        for (int i = 0; i < this.v.size(); i++) {
            d dVar = this.v.get(i);
            dVar.a(rect);
            this.z.setBounds(rect);
            int i2 = this.A;
            if (i2 == -1 && i == 0) {
                this.d.setColor(this.E);
            } else if (i2 != -1 && i2 == i) {
                this.d.setColor(this.E);
            } else {
                this.d.setColor(this.D);
            }
            if (dVar.f) {
                this.d.setColor(this.F);
            }
            this.z.setBounds(rect);
            this.z.setState(p(dVar));
            this.z.draw(canvas);
            canvas.drawText(dVar.f243b, dVar.c + this.y, dVar.d - 6, this.d);
        }
        canvas.restore();
        canvas.restore();
    }

    private int[] p(d dVar) {
        return dVar.f ? f238b : f237a;
    }

    private boolean r(int i, int i2) {
        return this.m.a(i, i2);
    }

    private void t() {
        try {
            if (this.v.isEmpty()) {
                return;
            }
            this.v.get(this.A).f = false;
            invalidate();
        } catch (Exception e) {
            String str = this.c;
            Log.e(str, "invalidateSelectDrawable: e" + e.toString());
        }
    }

    private int u(int i) {
        return View.MeasureSpec.getMode(i) == 1073741824 ? View.MeasureSpec.getSize(i) : this.f;
    }

    private int v(int i) {
        return View.MeasureSpec.getSize(i);
    }

    private boolean w(int i, int i2) {
        return this.n.a(i, i2);
    }

    private void x(int i, int i2) {
        List<d> list = this.v;
        if (list != null) {
            int size = list.size();
            if (w(i, i2)) {
                return;
            }
            Rect rect = new Rect();
            if (i < this.w || i > this.G) {
                return;
            }
            for (int i3 = 0; i3 < size; i3++) {
                d dVar = this.v.get(i3);
                dVar.a(rect);
                if (rect.contains(i, i2)) {
                    this.A = i3;
                    dVar.f = true;
                    this.z.setBounds(rect);
                } else {
                    dVar.f = false;
                }
            }
        }
    }

    private void y(int i, int i2) {
        OnCandidateActionListener onCandidateActionListener;
        String str = this.c;
        Log.d(str, "onListTouchUp: y=" + i2);
        if (this.v != null) {
            Rect rect = new Rect();
            int size = this.v.size();
            if (i < this.w || i > this.G) {
                return;
            }
            for (int i3 = 0; i3 < size; i3++) {
                d dVar = this.v.get(i3);
                dVar.a(rect);
                if (rect.contains(i, 40) && (onCandidateActionListener = this.B) != null && this.A == i3) {
                    this.I = 0;
                    onCandidateActionListener.onCandidateSelected(i3);
                }
                dVar.f = false;
            }
        }
    }

    private void z(int i, int i2) {
        List<String> list = this.u;
        if (list != null && list.size() > 0) {
            x(i, i2);
        }
        invalidate();
    }

    public void C() {
        if (this.v != null) {
            for (int i = 0; i < this.v.size(); i++) {
                this.v.get(i).c += this.I;
            }
        }
    }

    public void D() {
        this.k = true;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public List<String> getmData() {
        return this.u;
    }

    public int getmSelectedIndex() {
        return this.A;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        b bVar;
        b bVar2;
        this.g.setBounds(0, 0, this.e, this.f);
        List<String> list = this.u;
        if (list != null && list.size() > 0) {
            this.g.draw(canvas);
            o(canvas);
            b bVar3 = this.r;
            if (bVar3 != null) {
                bVar3.b(canvas);
            }
            int i = this.i;
            if (i == 1 && (bVar2 = this.n) != null) {
                bVar2.b(canvas);
                return;
            } else if (i != 2 || (bVar = this.o) == null) {
                return;
            } else {
                bVar.b(canvas);
                return;
            }
        }
        if (this.k) {
            b bVar4 = this.l;
            if (bVar4 != null) {
                bVar4.b(canvas);
            }
            b bVar5 = this.q;
            if (bVar5 != null) {
                bVar5.b(canvas);
            }
            b bVar6 = this.m;
            if (bVar6 != null) {
                bVar6.b(canvas);
            }
        }
        b bVar7 = this.p;
        if (bVar7 != null) {
            bVar7.b(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(v(i), u(i2));
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.H.onTouchEvent(motionEvent)) {
            this.j = true;
            return true;
        }
        Log.d(this.c, "onTouch: ");
        if (motionEvent.getAction() == 0) {
            this.j = false;
            z((int) motionEvent.getX(), (int) motionEvent.getY());
        } else if (!this.j && motionEvent.getAction() == 1) {
            t();
            A((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return true;
    }

    public void q() {
        this.k = false;
    }

    public void s(UITheme uITheme) {
        this.g = uITheme.e(getResources().getResourceName(R.drawable.bg_default_candidate));
        this.t = uITheme.e(getResources().getResourceName(R.drawable.candidate_close));
        this.z = uITheme.e(getResources().getResourceName(R.drawable.candidate_key_bg_selector));
        this.D = uITheme.b("colorCandidateText");
        this.E = uITheme.b("colorCandidateTxtSelect");
        this.F = uITheme.b("colorCandidateTxtPress");
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.d.setTextSize(getResources().getDimensionPixelSize(R.dimen.candidate_data_font_size));
        this.d.setColor(this.D);
        this.d.setTypeface(f.a());
        this.e = getContext().getResources().getDisplayMetrics().widthPixels;
        this.f = (int) uITheme.d("candidate_height");
        this.p = new b(30, 0, 78, this.f, uITheme.e(getResources().getResourceName(R.drawable.candidate_close)));
        this.q = new b(98, 0, 101, this.f, uITheme.e(getResources().getResourceName(R.drawable.candidate_div)));
        this.l = new b(this, 130, 0, 178, this.f, uITheme.e(getResources().getResourceName(R.drawable.icon_bigkeyboard)), uITheme.e(getResources().getResourceName(R.drawable.icon_bigkeyboard_pressed)));
        this.m = new b(this, 198, 0, 246, this.f, uITheme.e(getResources().getResourceName(R.drawable.candidate_hw)), uITheme.e(getResources().getResourceName(R.drawable.candidate_hw_pressed)));
        Drawable e = uITheme.e(getResources().getResourceName(R.drawable.symbol_page_down));
        int i = this.G;
        this.n = new b(i, 0, i + 48, 72, e);
        Drawable e2 = uITheme.e(getResources().getResourceName(R.drawable.icon_mid_default_closure));
        int i2 = this.G;
        this.o = new b(i2, 0, i2 + 48, 72, e2);
        Drawable e3 = uITheme.e(getResources().getResourceName(R.drawable.img_default_leftslide));
        this.r = new b(this.G - e3.getIntrinsicWidth(), 10, this.G, 62, e3);
        this.w = (int) uITheme.d("candidate_data_margin_left");
        this.s = (int) uITheme.d("candidate_data_margin_more_right");
        this.x = (int) uITheme.d("candidate_data_gap");
        setOnTouchListener(this);
        this.H = new GestureDetector(this.C, new c());
        invalidate();
    }

    public void setAssociateData(List<String> list) {
        this.i = 2;
        ArrayList arrayList = new ArrayList(list);
        this.u = arrayList;
        this.A = -1;
        setListWithPosition(arrayList);
        invalidate();
    }

    public void setCandidateData(List<String> list) {
        this.i = 1;
        ArrayList arrayList = new ArrayList(list);
        this.u = arrayList;
        this.A = -1;
        setListWithPosition(arrayList);
        invalidate();
    }

    public void setDataPadding(boolean z) {
        this.y = z ? 30 : 40;
    }

    public void setDisplayMode(int i) {
        this.h = i;
        this.u.clear();
        this.v.clear();
        this.l.c(i == 2);
        this.m.c(i == 3);
        String str = this.c;
        Log.d(str, "setDisplayMode: " + i);
        invalidate();
    }

    public void setListWithPosition(List<String> list) {
        this.v.clear();
        if (list != null && list.size() != 0) {
            int i = this.w;
            int textSize = ((int) (((this.f - this.d.getTextSize()) / 2.0f) - this.d.ascent())) - 3;
            for (int i2 = 0; i2 < list.size(); i2++) {
                d dVar = new d();
                String str = new String(list.get(i2));
                dVar.f242a = str;
                dVar.f243b = str;
                int measureText = (int) this.d.measureText(str);
                dVar.c = i;
                dVar.d = textSize;
                dVar.e = measureText;
                this.v.add(dVar);
                i = i + this.x + (this.y * 2) + measureText;
            }
            return;
        }
        this.I = 0;
        this.A = 0;
    }

    public void setOnCandidateActionListener(OnCandidateActionListener onCandidateActionListener) {
        this.B = onCandidateActionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        Rect f239a;

        /* renamed from: b  reason: collision with root package name */
        Drawable f240b;
        Drawable c;
        int d;
        int e;
        int f;
        int g;
        boolean h;

        b(int i, int i2, int i3, int i4, Drawable drawable) {
            this.h = false;
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.f239a = new Rect(i, i2, i3, i4);
            this.f240b = drawable;
        }

        boolean a(int i, int i2) {
            b.b.a.a.a.a("iconAreaRect should not be null", this.f239a != null);
            Rect rect = new Rect();
            Rect rect2 = this.f239a;
            rect.set(rect2.left - 16, rect2.top, rect2.right + 16, rect2.bottom);
            return rect.contains(i, i2);
        }

        void b(Canvas canvas) {
            int i = this.f - this.d;
            int i2 = this.g - this.e;
            int intrinsicHeight = this.f240b.getIntrinsicHeight();
            int intrinsicWidth = this.f240b.getIntrinsicWidth();
            Log.d("IconArea", "iconIntrinsicWidth:" + intrinsicWidth);
            int i3 = (i - intrinsicWidth) / 2;
            int i4 = (i2 - intrinsicHeight) / 2;
            int i5 = this.d;
            int i6 = this.e;
            Rect rect = new Rect(i5 + i3, i6 + i4, i5 + i3 + intrinsicWidth, i6 + i4 + intrinsicHeight);
            if (!this.h) {
                this.f240b.setBounds(rect);
                this.f240b.draw(canvas);
                return;
            }
            this.c.setBounds(rect);
            this.c.draw(canvas);
        }

        void c(boolean z) {
            this.h = z;
        }

        b(CandidateView candidateView, int i, int i2, int i3, int i4, Drawable drawable, Drawable drawable2) {
            this(i, i2, i3, i4, drawable);
            this.c = drawable2;
        }
    }

    public CandidateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = CandidateView.class.getSimpleName();
        this.h = 1;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.y = 40;
        this.A = -1;
        this.G = 913;
        this.C = context;
    }

    public CandidateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = CandidateView.class.getSimpleName();
        this.h = 1;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.y = 40;
        this.A = -1;
        this.G = 913;
        this.C = context;
    }
}
