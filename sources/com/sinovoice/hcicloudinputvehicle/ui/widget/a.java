package com.sinovoice.hcicloudinputvehicle.ui.widget;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudinputvehicle.ui.UITheme;
/* compiled from: ComposingViewContainer.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f308a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static int f309b;
    private ComposingView c;
    private LinearLayout d;
    private View e;
    private PopupWindow f;
    private boolean g = true;

    /* compiled from: ComposingViewContainer.java */
    /* renamed from: com.sinovoice.hcicloudinputvehicle.ui.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0016a implements Runnable {
        RunnableC0016a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int dimension = (int) a.this.e.getContext().getResources().getDimension(R.dimen.composing_height);
            int i = a.this.e.getContext().getResources().getDisplayMetrics().widthPixels;
            String str = a.f308a;
            b.b.a.b.a.a(str, "width = " + i);
            if (a.this.f != null) {
                a.this.f.setHeight(dimension);
                a.this.f.setWidth(i);
                if (a.this.g) {
                    a.this.f.showAtLocation(a.this.e, 8388691, 0, 520);
                } else {
                    a.this.f.showAtLocation(a.this.e, 8388691, a.f309b, 520);
                }
            }
        }
    }

    public a(View view) {
        this.e = view;
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) view.getContext().getSystemService("layout_inflater")).inflate(R.layout.composing_view, (ViewGroup) null);
        this.d = linearLayout;
        this.c = (ComposingView) linearLayout.findViewById(R.id.composing);
    }

    public void f() {
        ComposingView composingView = this.c;
        if (composingView != null) {
            composingView.a();
        }
        PopupWindow popupWindow = this.f;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public void g(UITheme uITheme) {
        this.c.b(uITheme);
    }

    public void h() {
        ComposingView composingView = this.c;
        if (composingView != null) {
            composingView.a();
        }
        f();
        if (this.f != null) {
            this.f = null;
        }
    }

    public void i(String str) {
        this.c.setComposingInfo(str);
    }

    public void j(String str, String str2) {
        this.c.c(str, str2);
    }

    public void k() {
        if (this.f == null) {
            PopupWindow popupWindow = new PopupWindow(this.e.getContext());
            this.f = popupWindow;
            popupWindow.setContentView(this.d);
            this.f.setBackgroundDrawable(new ColorDrawable(0));
            this.f.setOutsideTouchable(false);
            this.f.setTouchable(false);
            this.f.setClippingEnabled(false);
            this.f.setAnimationStyle(0);
        }
        this.e.post(new RunnableC0016a());
    }
}
