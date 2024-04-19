package com.sinovoice.hcicloudinputvehicle.ui;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudinputvehicle.service.HciCloudIME;
/* compiled from: StrokeViewContainer.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f304a = "c";

    /* renamed from: b  reason: collision with root package name */
    private final StrokeView f305b;
    private final KeyboardView c;
    private final LinearLayout d;
    private View e;
    private View f;
    private View g;
    private HciCloudIME h;
    private PopupWindow i;
    private int j;
    private boolean l;
    private boolean k = false;
    private boolean n = true;
    private Rect m = new Rect();

    public c(View view, HciCloudIME hciCloudIME) {
        this.d = (LinearLayout) view.findViewById(R.id.stroke_container);
        this.f305b = (StrokeView) view.findViewById(R.id.stroke_board);
        this.c = (KeyboardView) view.findViewById(R.id.input_keyboard);
        this.f = view;
        this.g = view.findViewById(R.id.input_area);
        this.h = hciCloudIME;
        this.e = hciCloudIME.getWindow().getWindow().getDecorView();
        d();
    }

    private void d() {
        if (this.i == null) {
            PopupWindow popupWindow = new PopupWindow(this.h);
            this.i = popupWindow;
            popupWindow.setClippingEnabled(false);
            this.i.setFocusable(false);
            this.i.setOutsideTouchable(false);
            this.i.setBackgroundDrawable(new ColorDrawable(1476395008));
        }
    }

    public void a() {
        if (this.i == null) {
            return;
        }
        String str = f304a;
        Log.d(str, "mDefaultRect:" + this.m);
        this.l = false;
        this.i.setOutsideTouchable(false);
        this.i.update(this.f, 0, 0, this.m.width(), this.m.height() - this.f.getHeight());
    }

    public void b() {
        c();
    }

    public void c() {
        LinearLayout linearLayout = this.d;
        if (linearLayout == null || this.f305b == null) {
            return;
        }
        linearLayout.setVisibility(8);
        this.f305b.d();
    }

    public void e() {
        this.i.setOutsideTouchable(true);
        this.i.update(0, 0, 0, 0);
        this.k = true;
    }

    public void f() {
        StrokeView strokeView = this.f305b;
        if (strokeView != null) {
            strokeView.j();
        }
        b();
        if (this.h != null) {
            this.h = null;
        }
        if (this.i != null) {
            this.i = null;
        }
    }

    public void g(int i) {
        this.j = 1;
        this.d.setVisibility(0);
        this.f305b.k(i, this.c);
        this.f305b.setListener(this.h);
    }
}
