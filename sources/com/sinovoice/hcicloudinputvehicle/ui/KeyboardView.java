package com.sinovoice.hcicloudinputvehicle.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudinputvehicle.R$styleable;
import com.sinovoice.hcicloudinputvehicle.service.f;
import com.sinovoice.hcicloudinputvehicle.ui.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class KeyboardView extends View implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f253a = {-5};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f254b = {R.attr.state_long_pressable};
    private static int c = 12;
    private OnKeyboardActionListener A;
    private boolean A0;
    private int B;
    private Rect B0;
    private int C;
    private Bitmap C0;
    private boolean D;
    private boolean D0;
    private boolean E;
    private Canvas E0;
    private boolean F;
    private AccessibilityManager F0;
    private int G;
    private AudioManager G0;
    private int H;
    Handler H0;
    private int I;
    private int I0;
    private int J;
    private int J0;
    private int K;
    private int K0;
    private int L;
    private Typeface L0;
    private boolean M;
    private UITheme M0;
    private Paint N;
    private Rect O;
    private long P;
    private long Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private long W;
    private long a0;
    private int[] b0;
    private GestureDetector c0;
    private com.sinovoice.hcicloudinputvehicle.ui.a d;
    private int d0;
    private int e;
    private int e0;
    private int f;
    private boolean f0;
    private int g;
    private a.C0015a g0;
    private int h;
    private Rect h0;
    private int i;
    private boolean i0;
    private float j;
    private c j0;
    private int k;
    private int k0;
    private float l;
    private boolean l0;
    private TextView m;
    private int m0;
    private PopupWindow n;
    private float n0;
    private int o;
    private float o0;
    private int p;
    private Drawable p0;
    private int q;
    private Drawable q0;
    private final int[] r;
    private Drawable r0;
    private PopupWindow s;
    private Drawable s0;
    private MiniKeyboardView t;
    private int t0;
    private boolean u;
    private int[] u0;
    private View v;
    private int v0;
    private int w;
    private int w0;
    private int x;
    private long x0;
    private Map<a.C0015a, View> y;
    private boolean y0;
    private a.C0015a[] z;
    private StringBuilder z0;

    /* loaded from: classes.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                KeyboardView.this.P(message.arg1);
            } else if (i == 2) {
                KeyboardView.this.m.setVisibility(4);
            } else if (i != 3) {
                if (i != 4) {
                    return;
                }
                KeyboardView.this.K((MotionEvent) message.obj);
            } else if (KeyboardView.this.M()) {
                sendMessageDelayed(Message.obtain(this, 3), 50L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (KeyboardView.this.u) {
                return false;
            }
            float abs = Math.abs(f);
            float abs2 = Math.abs(f2);
            float x = motionEvent2.getX() - motionEvent.getX();
            float y = motionEvent2.getY() - motionEvent.getY();
            Log.d("Keyboard", "onFling: velocitY :" + f2 + "deltaY " + y);
            int width = KeyboardView.this.getWidth() / 2;
            int height = KeyboardView.this.getHeight() / 2;
            KeyboardView.this.j0.d(1000);
            float f3 = KeyboardView.this.j0.f();
            KeyboardView.this.j0.g();
            if (motionEvent.getY() <= motionEvent2.getY() || y >= (-height) / 5) {
                boolean z = true;
                if (f <= KeyboardView.this.k0 || abs2 >= abs || x <= width) {
                    if (f >= (-KeyboardView.this.k0) || abs2 >= abs || x >= (-width)) {
                        z = false;
                    } else if (!KeyboardView.this.l0 || f3 <= f / 4.0f) {
                        KeyboardView.this.R();
                        return true;
                    }
                } else if (!KeyboardView.this.l0 || f3 >= f / 4.0f) {
                    KeyboardView.this.S();
                    return true;
                }
                if (z) {
                    KeyboardView keyboardView = KeyboardView.this;
                    keyboardView.s(keyboardView.V, KeyboardView.this.K, KeyboardView.this.L, motionEvent.getEventTime());
                }
                return false;
            }
            KeyboardView keyboardView2 = KeyboardView.this;
            return keyboardView2.t(keyboardView2.V, KeyboardView.this.K, KeyboardView.this.L, motionEvent.getEventTime());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            float x = motionEvent2.getX() - motionEvent.getX();
            float y = motionEvent2.getY() - motionEvent.getY();
            float abs = Math.abs(x);
            float abs2 = Math.abs(y);
            if (!KeyboardView.this.u || KeyboardView.this.t == null || abs <= abs2) {
                return false;
            }
            KeyboardView.this.t.b(Math.round(x / (((KeyboardView.this.t.getWidth() / 9) * 5) / KeyboardView.this.t.getChildCount())));
            return true;
        }
    }

    public KeyboardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.keyboardViewStyle);
    }

    private boolean D(a.C0015a c0015a) {
        if (c0015a.D != 1) {
            return true;
        }
        int[] iArr = c0015a.k;
        return iArr[0] == -11 || iArr[0] == -6 || iArr[0] == -2 || iArr[0] == -10 || iArr[0] == -9 || iArr[0] == -60 || iArr[0] == -5 || iArr[0] == -13 || iArr[0] == -14 || iArr[0] == -4 || iArr[0] == -3;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0263  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void H() {
        /*
            Method dump skipped, instructions count: 647
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sinovoice.hcicloudinputvehicle.ui.KeyboardView.H():void");
    }

    private boolean J(MotionEvent motionEvent, boolean z) {
        int i;
        int i2;
        int i3;
        int x = ((int) motionEvent.getX()) - getPaddingLeft();
        int y = ((int) motionEvent.getY()) - getPaddingTop();
        int i4 = this.B;
        if (y >= (-i4)) {
            y += i4;
        }
        int action = motionEvent.getAction();
        long eventTime = motionEvent.getEventTime();
        int v = v(x, y, null);
        this.i0 = z;
        if (action == 0) {
            this.j0.c();
        }
        this.j0.a(motionEvent);
        if (this.c0.onTouchEvent(motionEvent)) {
            Q(-1);
            this.H0.removeMessages(3);
            this.H0.removeMessages(4);
            return true;
        } else if (!this.f0 || action == 0 || action == 3 || action == 1) {
            if (this.u && action == 1) {
                OnKeyboardActionListener onKeyboardActionListener = this.A;
                if (onKeyboardActionListener != null) {
                    onKeyboardActionListener.onKey(this.t.getCurrentLongPressChar(), null);
                }
                u();
                return true;
            }
            if (action == 0) {
                this.f0 = false;
                this.K = x;
                this.L = y;
                this.S = x;
                this.T = y;
                this.W = 0L;
                this.a0 = 0L;
                this.R = -1;
                this.U = v;
                this.V = v;
                long eventTime2 = motionEvent.getEventTime();
                this.P = eventTime2;
                this.Q = eventTime2;
                p(eventTime, v);
                this.A.onPress(v != -1 ? this.z[v].k[0] : 0);
                int i5 = this.U;
                if (i5 >= 0 && this.z[i5].I) {
                    this.d0 = i5;
                    this.H0.sendMessageDelayed(this.H0.obtainMessage(3), 400L);
                    M();
                    if (this.f0) {
                        this.d0 = -1;
                    }
                }
                if (this.U != -1) {
                    this.H0.sendMessageDelayed(this.H0.obtainMessage(4, motionEvent), 500L);
                }
                Q(v);
            } else if (action == 1) {
                L();
                if (v == this.U) {
                    this.a0 += eventTime - this.Q;
                } else {
                    N();
                    this.R = this.U;
                    this.W = (this.a0 + eventTime) - this.Q;
                    this.U = v;
                    this.a0 = 0L;
                }
                long j = this.a0;
                if (j >= this.W || j >= 70) {
                    i = -1;
                } else {
                    int i6 = this.R;
                    i = -1;
                    if (i6 != -1) {
                        this.U = i6;
                        i2 = this.S;
                        i3 = this.T;
                        Q(i);
                        Arrays.fill(this.b0, i);
                        if (this.d0 == i && !this.u && !this.f0) {
                            s(this.U, i2, i3, eventTime);
                        }
                        B(v);
                        this.d0 = -1;
                        x = i2;
                        y = i3;
                    }
                }
                i2 = x;
                i3 = y;
                Q(i);
                Arrays.fill(this.b0, i);
                if (this.d0 == i) {
                    s(this.U, i2, i3, eventTime);
                }
                B(v);
                this.d0 = -1;
                x = i2;
                y = i3;
            } else if (action == 2) {
                if (v != -1) {
                    int i7 = this.U;
                    if (i7 == -1) {
                        this.U = v;
                        this.a0 = eventTime - this.P;
                    } else if (v == i7) {
                        this.a0 += eventTime - this.Q;
                        r7 = 1;
                    } else if (this.d0 == -1) {
                        N();
                        this.R = this.U;
                        this.S = this.I;
                        this.T = this.J;
                        this.W = (this.a0 + eventTime) - this.Q;
                        this.U = v;
                        this.a0 = 0L;
                    }
                }
                if (r7 == 0) {
                    this.H0.removeMessages(4);
                    if (v != -1) {
                        this.H0.sendMessageDelayed(this.H0.obtainMessage(4, motionEvent), 500L);
                    }
                }
                Q(this.U);
                this.Q = eventTime;
            } else if (action == 3) {
                L();
                u();
                this.f0 = true;
                Q(-1);
                B(this.U);
            }
            this.I = x;
            this.J = y;
            return true;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K(MotionEvent motionEvent) {
        int i;
        if (this.e0 != 0 && (i = this.U) >= 0) {
            a.C0015a[] c0015aArr = this.z;
            if (i < c0015aArr.length) {
                boolean I = I(c0015aArr[i]);
                if (I) {
                    this.f0 = true;
                    Q(-1);
                }
                return I;
            }
        }
        return false;
    }

    private void L() {
        Handler handler = this.H0;
        if (handler != null) {
            handler.removeMessages(3);
            this.H0.removeMessages(4);
            this.H0.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M() {
        a.C0015a c0015a = this.z[this.d0];
        s(this.U, c0015a.x, c0015a.y, this.x0);
        return true;
    }

    private void N() {
        this.v0 = -1;
        this.w0 = 0;
        this.x0 = -1L;
        this.y0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i) {
        if (f.b().a().e()) {
            PopupWindow popupWindow = this.n;
            a.C0015a[] c0015aArr = this.z;
            if (i < 0 || i >= c0015aArr.length) {
                return;
            }
            a.C0015a c0015a = c0015aArr[i];
            if (D(c0015a)) {
                return;
            }
            Drawable drawable = c0015a.n;
            if (drawable != null) {
                TextView textView = this.m;
                Drawable drawable2 = c0015a.o;
                if (drawable2 != null) {
                    drawable = drawable2;
                }
                textView.setCompoundDrawables(null, null, null, drawable);
                this.m.setText((CharSequence) null);
            } else {
                this.m.setCompoundDrawables(null, null, null, null);
                this.m.setText(w(c0015a));
                if (c0015a.l.length() > 1 && c0015a.k.length < 2) {
                    this.m.setTextSize(0, this.g);
                    this.m.setTypeface(Typeface.DEFAULT_BOLD);
                } else {
                    this.m.setTextSize(0, this.o);
                    this.m.setTypeface(Typeface.DEFAULT);
                }
            }
            this.m.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int max = Math.max(this.m.getMeasuredWidth(), c0015a.q + this.m.getPaddingLeft() + this.m.getPaddingRight());
            int i2 = this.q;
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = max;
                layoutParams.height = i2;
            }
            if (!this.D) {
                this.G = (c0015a.x - this.m.getPaddingLeft()) + getPaddingLeft();
                this.H = (c0015a.y - i2) + this.p;
            } else {
                this.G = 160 - (this.m.getMeasuredWidth() / 2);
                this.H = -this.m.getMeasuredHeight();
            }
            this.H0.removeMessages(2);
            getLocationInWindow(this.r);
            int[] iArr = this.r;
            iArr[0] = iArr[0] + this.w;
            iArr[1] = iArr[1] + this.x;
            this.m.getBackground().setState(c0015a.H != 0 ? f254b : View.EMPTY_STATE_SET);
            int i3 = this.G;
            int[] iArr2 = this.r;
            this.G = i3 + iArr2[0];
            this.H += iArr2[1];
            getLocationOnScreen(iArr2);
            if (this.H + this.r[1] < 0) {
                if (c0015a.x + c0015a.q <= getWidth() / 2) {
                    int i4 = this.G;
                    double d = c0015a.q;
                    Double.isNaN(d);
                    this.G = i4 + ((int) (d * 2.5d));
                } else {
                    int i5 = this.G;
                    double d2 = c0015a.q;
                    Double.isNaN(d2);
                    this.G = i5 - ((int) (d2 * 2.5d));
                }
                this.H += i2;
            }
            if (popupWindow.isShowing()) {
                popupWindow.update(this.G, this.H, max, i2);
            } else {
                popupWindow.setWidth(max);
                popupWindow.setHeight(i2);
                popupWindow.showAtLocation(this.v, 0, this.G, this.H);
            }
            this.m.setVisibility(0);
        }
    }

    private void Q(int i) {
        int i2 = this.e;
        PopupWindow popupWindow = this.n;
        this.e = i;
        a.C0015a[] c0015aArr = this.z;
        if (i2 != i) {
            if (i2 != -1 && c0015aArr.length > i2) {
                a.C0015a c0015a = c0015aArr[i2];
                c0015a.i(i == -1);
                B(i2);
                int i3 = c0015a.k[0];
            }
            int i4 = this.e;
            if (i4 != -1 && c0015aArr.length > i4) {
                a.C0015a c0015a2 = c0015aArr[i4];
                c0015a2.h();
                B(this.e);
                int i5 = c0015a2.k[0];
            }
        }
        if (i2 == this.e || !this.E) {
            return;
        }
        this.H0.removeMessages(1);
        if (popupWindow.isShowing() && i == -1) {
            Handler handler = this.H0;
            handler.sendMessageDelayed(handler.obtainMessage(2), 70L);
        }
        if (i != -1) {
            if (popupWindow.isShowing() && this.m.getVisibility() == 0) {
                P(i);
                return;
            }
            Handler handler2 = this.H0;
            handler2.sendMessageDelayed(handler2.obtainMessage(1, i, 0), 0L);
        }
    }

    private CharSequence o(CharSequence charSequence) {
        return (!this.d.t() || charSequence == null || charSequence.length() >= 3 || !Character.isLowerCase(charSequence.charAt(0))) ? charSequence : charSequence.toString().toUpperCase();
    }

    private void p(long j, int i) {
        if (i == -1) {
            return;
        }
        a.C0015a c0015a = this.z[i];
        if (c0015a.k.length > 1) {
            this.y0 = true;
            if (j < this.x0 + 200 && i == this.v0 && !c0015a.g()) {
                this.w0 = (this.w0 + 1) % c0015a.k.length;
            } else {
                this.w0 = -1;
            }
        } else if (j > this.x0 + 200 || i != this.v0) {
            N();
        }
    }

    private void r(com.sinovoice.hcicloudinputvehicle.ui.a aVar) {
        a.C0015a[] c0015aArr;
        if (aVar == null || (c0015aArr = this.z) == null) {
            return;
        }
        int length = c0015aArr.length;
        int i = 0;
        for (a.C0015a c0015a : c0015aArr) {
            i += Math.min(c0015a.q, c0015a.r) + c0015a.s;
        }
        if (i < 0 || length == 0) {
            return;
        }
        int i2 = (int) ((i * 1.4f) / length);
        this.C = i2;
        this.C = i2 * i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i, int i2, int i3, long j) {
        if (i != -1) {
            a.C0015a[] c0015aArr = this.z;
            if (i < c0015aArr.length) {
                a.C0015a c0015a = c0015aArr[i];
                CharSequence charSequence = c0015a.B;
                if (charSequence != null) {
                    this.A.onText(o(charSequence).toString());
                    this.A.onRelease(-1);
                } else {
                    int i4 = c0015a.k[0];
                    int[] iArr = new int[c];
                    Arrays.fill(iArr, -1);
                    v(i2, i3, iArr);
                    if (this.y0) {
                        if (this.w0 == -1) {
                            this.w0 = 0;
                        }
                        i4 = c0015a.k[this.w0];
                    }
                    this.A.onKey(i4, iArr);
                    this.A.onRelease(i4);
                }
                this.v0 = i;
                this.x0 = j;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(int i, int i2, int i3, long j) {
        CharSequence charSequence;
        if (i != -1) {
            a.C0015a[] c0015aArr = this.z;
            if (i < c0015aArr.length) {
                a.C0015a c0015a = c0015aArr[i];
                this.v0 = i;
                this.x0 = j;
                if (c0015a.B != null && (charSequence = c0015a.m) != null) {
                    this.A.onKey(o(charSequence).toString().charAt(0), c0015a.k);
                    this.A.onRelease(-1);
                    return true;
                }
            }
        }
        return false;
    }

    private void u() {
        if (this.s.isShowing()) {
            this.s.dismiss();
            this.u = false;
            this.t.a();
            A();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
        if (r15 >= r16.C) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int v(int r17, int r18, int[] r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            com.sinovoice.hcicloudinputvehicle.ui.a$a[] r4 = r0.z
            int r5 = r0.C
            int r5 = r5 + 1
            int[] r6 = r0.u0
            r7 = 2147483647(0x7fffffff, float:NaN)
            java.util.Arrays.fill(r6, r7)
            com.sinovoice.hcicloudinputvehicle.ui.a r6 = r0.d
            int[] r6 = r6.q(r1, r2)
            int r7 = r6.length
            r10 = 0
            r11 = -1
            r12 = -1
        L20:
            if (r10 >= r7) goto L81
            r13 = r6[r10]
            r13 = r4[r13]
            boolean r14 = r13.f(r1, r2)
            if (r14 == 0) goto L2e
            r11 = r6[r10]
        L2e:
            boolean r15 = r0.M
            if (r15 == 0) goto L3b
            int r15 = r13.k(r1, r2)
            int r9 = r0.C
            if (r15 < r9) goto L3e
            goto L3c
        L3b:
            r15 = 0
        L3c:
            if (r14 == 0) goto L7a
        L3e:
            int[] r9 = r13.k
            int r9 = r9.length
            if (r15 >= r5) goto L46
            r12 = r6[r10]
            r5 = r15
        L46:
            if (r3 != 0) goto L49
            goto L7a
        L49:
            r14 = 0
        L4a:
            int[] r8 = r0.u0
            int r1 = r8.length
            if (r14 >= r1) goto L7a
            r1 = r8[r14]
            if (r1 <= r15) goto L73
            int r1 = r14 + r9
            int r2 = r8.length
            int r2 = r2 - r14
            int r2 = r2 - r9
            java.lang.System.arraycopy(r8, r14, r8, r1, r2)
            int r2 = r3.length
            int r2 = r2 - r14
            int r2 = r2 - r9
            java.lang.System.arraycopy(r3, r14, r3, r1, r2)
            r1 = 0
        L62:
            if (r1 >= r9) goto L7a
            int r2 = r14 + r1
            int[] r8 = r13.k
            r8 = r8[r1]
            r3[r2] = r8
            int[] r8 = r0.u0
            r8[r2] = r15
            int r1 = r1 + 1
            goto L62
        L73:
            int r14 = r14 + 1
            r1 = r17
            r2 = r18
            goto L4a
        L7a:
            int r10 = r10 + 1
            r1 = r17
            r2 = r18
            goto L20
        L81:
            r1 = -1
            if (r11 != r1) goto L85
            r11 = r12
        L85:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sinovoice.hcicloudinputvehicle.ui.KeyboardView.v(int, int, int[]):int");
    }

    private CharSequence w(a.C0015a c0015a) {
        if (this.y0) {
            this.z0.setLength(0);
            StringBuilder sb = this.z0;
            int[] iArr = c0015a.k;
            int i = this.w0;
            sb.append((char) iArr[i >= 0 ? i : 0]);
            return o(this.z0);
        }
        return o(c0015a.l);
    }

    private void y() {
        if (this.c0 == null) {
            GestureDetector gestureDetector = new GestureDetector(getContext(), new b());
            this.c0 = gestureDetector;
            gestureDetector.setIsLongpressEnabled(false);
        }
    }

    private void z() {
        this.m.setTextColor(this.M0.b("key_preview_text_color"));
        this.m.setBackground(this.M0.e("key_float"));
    }

    public void A() {
        this.B0.union(0, 0, getWidth(), getHeight());
        this.A0 = true;
        invalidate();
    }

    public void B(int i) {
        a.C0015a[] c0015aArr = this.z;
        if (c0015aArr != null && i >= 0 && i < c0015aArr.length) {
            a.C0015a c0015a = c0015aArr[i];
            this.g0 = c0015a;
            this.B0.union(c0015a.x + getPaddingLeft(), c0015a.y + getPaddingTop(), c0015a.x + c0015a.q + getPaddingLeft(), c0015a.y + c0015a.r + getPaddingTop());
            H();
            invalidate(c0015a.x + getPaddingLeft(), c0015a.y + getPaddingTop(), c0015a.x + c0015a.q + getPaddingLeft(), c0015a.y + c0015a.r + getPaddingTop());
        }
    }

    public void C(a.C0015a c0015a) {
        if (this.z == null) {
            return;
        }
        this.g0 = c0015a;
        this.B0.union(c0015a.x + getPaddingLeft(), c0015a.y + getPaddingTop(), c0015a.x + c0015a.q + getPaddingLeft(), c0015a.y + c0015a.r + getPaddingTop());
        H();
        invalidate(c0015a.x + getPaddingLeft(), c0015a.y + getPaddingTop(), c0015a.x + c0015a.q + getPaddingLeft(), c0015a.y + c0015a.r + getPaddingTop());
    }

    public boolean E() {
        return this.d.s();
    }

    public boolean F() {
        com.sinovoice.hcicloudinputvehicle.ui.a aVar = this.d;
        if (aVar != null) {
            return aVar.t();
        }
        return false;
    }

    public void G() {
        this.d.v();
        A();
    }

    protected boolean I(a.C0015a c0015a) {
        return false;
    }

    public boolean O(boolean z) {
        com.sinovoice.hcicloudinputvehicle.ui.a aVar = this.d;
        if (aVar == null || !aVar.A(z)) {
            return false;
        }
        A();
        return true;
    }

    protected void R() {
        this.A.swipeLeft();
    }

    protected void S() {
        this.A.swipeRight();
    }

    public com.sinovoice.hcicloudinputvehicle.ui.a getKeyboard() {
        return this.d;
    }

    protected OnKeyboardActionListener getOnKeyboardActionListener() {
        return this.A;
    }

    public int getShiftMode() {
        com.sinovoice.hcicloudinputvehicle.ui.a aVar = this.d;
        if (aVar != null) {
            return aVar.r();
        }
        return 0;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        y();
        if (this.H0 == null) {
            this.H0 = new a();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.A0 || this.C0 == null || this.D0) {
            H();
        }
        canvas.drawBitmap(this.C0, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (this.F0.isTouchExplorationEnabled() && motionEvent.getPointerCount() == 1) {
            int action = motionEvent.getAction();
            if (action == 7) {
                motionEvent.setAction(2);
            } else if (action == 9) {
                motionEvent.setAction(0);
            } else if (action == 10) {
                motionEvent.setAction(1);
            }
            return onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        com.sinovoice.hcicloudinputvehicle.ui.a aVar = this.d;
        if (aVar == null) {
            setMeasuredDimension(getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
            return;
        }
        int p = aVar.p() + getPaddingLeft() + getPaddingRight();
        if (View.MeasureSpec.getSize(i) < p + 10) {
            p = View.MeasureSpec.getSize(i);
        }
        setMeasuredDimension(p, this.d.n() + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.C0 = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction();
        long eventTime = motionEvent.getEventTime();
        boolean z = true;
        if (pointerCount != this.m0) {
            if (pointerCount == 1) {
                MotionEvent obtain = MotionEvent.obtain(eventTime, eventTime, 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
                boolean J = J(obtain, false);
                obtain.recycle();
                z = action == 1 ? J(motionEvent, true) : J;
            } else {
                MotionEvent obtain2 = MotionEvent.obtain(eventTime, eventTime, 1, this.n0, this.o0, motionEvent.getMetaState());
                z = J(obtain2, true);
                obtain2.recycle();
            }
        } else if (pointerCount == 1) {
            z = J(motionEvent, false);
            this.n0 = motionEvent.getX();
            this.o0 = motionEvent.getY();
        }
        this.m0 = pointerCount;
        return z;
    }

    public void q() {
        if (this.n.isShowing()) {
            this.n.dismiss();
        }
        L();
        u();
        this.C0 = null;
        this.E0 = null;
        this.y.clear();
    }

    public void setAltKey(boolean z) {
        com.sinovoice.hcicloudinputvehicle.ui.a aVar = this.d;
        if (aVar != null) {
            aVar.x(z);
            A();
        }
    }

    public void setEnterActionMode(int i) {
        if (i <= 0) {
            i = 0;
        }
        this.K0 = i;
        a.C0015a m = this.d.m();
        m.n = getResources().getDrawable(m.d(this.K0));
        C(m);
    }

    public void setKeyboard(com.sinovoice.hcicloudinputvehicle.ui.a aVar) {
        if (this.d != null) {
            Q(-1);
        }
        L();
        this.d = aVar;
        List<a.C0015a> o = aVar.o();
        this.z = (a.C0015a[]) o.toArray(new a.C0015a[o.size()]);
        requestLayout();
        this.D0 = true;
        A();
        r(aVar);
        this.y.clear();
        this.f0 = true;
    }

    public void setOnKeyboardActionListener(OnKeyboardActionListener onKeyboardActionListener) {
        this.A = onKeyboardActionListener;
    }

    public void setPopupParent(View view) {
        this.v = view;
    }

    public void setPreviewEnabled(boolean z) {
        this.E = z;
    }

    public void setProximityCorrectionEnabled(boolean z) {
        this.M = z;
    }

    public void setVerticalCorrection(int i) {
    }

    public void x(UITheme uITheme) {
        this.M0 = uITheme;
        this.h = uITheme.b("key_text_color");
        this.i = this.M0.b("fun_key_text_color");
        this.p0 = this.M0.e("keyboard_normal_key");
        this.q0 = this.M0.e("keyboard_function_key");
        this.r0 = this.M0.e("keyboard_enter_key");
        this.s0 = this.M0.e("icon_confirm_pressed");
        this.t0 = this.M0.b("key_text_color_pressed");
        this.I0 = this.M0.b("small_key_text_color");
        this.J0 = (int) this.M0.d("small_key_font_size");
        z();
        A();
        this.L0 = com.sinovoice.hcicloudinputvehicle.tools.f.a();
    }

    public KeyboardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = -1;
        this.r = new int[2];
        this.D = false;
        this.E = true;
        this.F = true;
        this.M = true;
        this.U = -1;
        this.V = -1;
        this.b0 = new int[12];
        this.d0 = -1;
        this.h0 = new Rect(0, 0, 0, 0);
        this.j0 = new c(null);
        this.m0 = 1;
        this.u0 = new int[c];
        this.z0 = new StringBuilder(1);
        this.B0 = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.KeyboardView, i, 0);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i2 = 0;
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            switch (index) {
                case 0:
                    this.q0 = obtainStyledAttributes.getDrawable(index);
                    break;
                case 1:
                    Drawable drawable = obtainStyledAttributes.getDrawable(index);
                    this.p0 = drawable;
                    if (this.q0 == null) {
                        this.q0 = drawable;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    this.q = obtainStyledAttributes.getDimensionPixelSize(index, 80);
                    break;
                case 3:
                    i2 = obtainStyledAttributes.getResourceId(index, 0);
                    break;
                case 4:
                    this.p = obtainStyledAttributes.getDimensionPixelOffset(index, 0);
                    break;
                case 5:
                    this.h = obtainStyledAttributes.getColor(index, ViewCompat.MEASURED_STATE_MASK);
                    break;
                case 6:
                    this.g = obtainStyledAttributes.getDimensionPixelSize(index, 18);
                    break;
                case 8:
                    this.f = obtainStyledAttributes.getDimensionPixelSize(index, 14);
                    break;
                case 9:
                    this.e0 = obtainStyledAttributes.getResourceId(index, 0);
                    break;
                case 10:
                    this.k = obtainStyledAttributes.getColor(index, 0);
                    break;
                case 11:
                    this.j = obtainStyledAttributes.getFloat(index, 0.0f);
                    break;
                case 12:
                    this.B = obtainStyledAttributes.getDimensionPixelOffset(index, 0);
                    break;
            }
        }
        this.n = new PopupWindow(context);
        if (i2 != 0) {
            TextView textView = (TextView) layoutInflater.inflate(i2, (ViewGroup) null);
            this.m = textView;
            this.o = (int) textView.getTextSize();
            this.n.setContentView(this.m);
            this.n.setBackgroundDrawable(null);
            this.n.setClippingEnabled(false);
        } else {
            this.E = false;
        }
        this.n.setTouchable(false);
        PopupWindow popupWindow = new PopupWindow(context);
        this.s = popupWindow;
        popupWindow.setBackgroundDrawable(null);
        this.v = this;
        Paint paint = new Paint();
        this.N = paint;
        paint.setAntiAlias(true);
        this.N.setTextSize(0);
        this.N.setTextAlign(Paint.Align.CENTER);
        this.N.setAlpha(255);
        this.O = new Rect(0, 0, 0, 0);
        this.y = new HashMap();
        this.p0.getPadding(this.O);
        this.k0 = (int) (getResources().getDisplayMetrics().density * 500.0f);
        this.l0 = true;
        this.F0 = (AccessibilityManager) context.getSystemService("accessibility");
        this.G0 = (AudioManager) context.getSystemService("audio");
        this.A = OnKeyboardActionListener.EMPTY_LISTENER;
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final float[] f257a;

        /* renamed from: b  reason: collision with root package name */
        final float[] f258b;
        final long[] c;
        float d;
        float e;

        private c() {
            this.f257a = new float[4];
            this.f258b = new float[4];
            this.c = new long[4];
        }

        private void b(float f, float f2, long j) {
            long[] jArr = this.c;
            int i = -1;
            int i2 = 0;
            while (i2 < 4 && jArr[i2] != 0) {
                if (jArr[i2] < j - 200) {
                    i = i2;
                }
                i2++;
            }
            if (i2 == 4 && i < 0) {
                i = 0;
            }
            if (i == i2) {
                i--;
            }
            float[] fArr = this.f257a;
            float[] fArr2 = this.f258b;
            if (i >= 0) {
                int i3 = i + 1;
                int i4 = (4 - i) - 1;
                System.arraycopy(fArr, i3, fArr, 0, i4);
                System.arraycopy(fArr2, i3, fArr2, 0, i4);
                System.arraycopy(jArr, i3, jArr, 0, i4);
                i2 -= i3;
            }
            fArr[i2] = f;
            fArr2[i2] = f2;
            jArr[i2] = j;
            int i5 = i2 + 1;
            if (i5 < 4) {
                jArr[i5] = 0;
            }
        }

        public void a(MotionEvent motionEvent) {
            long eventTime = motionEvent.getEventTime();
            int historySize = motionEvent.getHistorySize();
            for (int i = 0; i < historySize; i++) {
                b(motionEvent.getHistoricalX(i), motionEvent.getHistoricalY(i), motionEvent.getHistoricalEventTime(i));
            }
            b(motionEvent.getX(), motionEvent.getY(), eventTime);
        }

        public void c() {
            this.c[0] = 0;
        }

        public void d(int i) {
            e(i, Float.MAX_VALUE);
        }

        public void e(int i, float f) {
            float min;
            float min2;
            float[] fArr;
            float[] fArr2 = this.f257a;
            float[] fArr3 = this.f258b;
            long[] jArr = this.c;
            int i2 = 0;
            float f2 = fArr2[0];
            float f3 = fArr3[0];
            long j = jArr[0];
            while (i2 < 4 && jArr[i2] != 0) {
                i2++;
            }
            int i3 = 1;
            float f4 = 0.0f;
            float f5 = 0.0f;
            while (i3 < i2) {
                int i4 = (int) (jArr[i3] - j);
                if (i4 == 0) {
                    fArr = fArr2;
                } else {
                    float f6 = i4;
                    fArr = fArr2;
                    float f7 = i;
                    float f8 = ((fArr2[i3] - f2) / f6) * f7;
                    f4 = f4 == 0.0f ? f8 : (f4 + f8) * 0.5f;
                    float f9 = ((fArr3[i3] - f3) / f6) * f7;
                    f5 = f5 == 0.0f ? f9 : (f5 + f9) * 0.5f;
                }
                i3++;
                fArr2 = fArr;
            }
            if (f4 < 0.0f) {
                min = Math.max(f4, -f);
            } else {
                min = Math.min(f4, f);
            }
            this.e = min;
            if (f5 < 0.0f) {
                min2 = Math.max(f5, -f);
            } else {
                min2 = Math.min(f5, f);
            }
            this.d = min2;
        }

        public float f() {
            return this.e;
        }

        public float g() {
            return this.d;
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }
}
