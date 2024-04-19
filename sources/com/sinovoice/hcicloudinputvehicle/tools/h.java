package com.sinovoice.hcicloudinputvehicle.tools;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
/* compiled from: ViewLayoutUtils.java */
/* loaded from: classes.dex */
public final class h {
    public static void a(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (layoutParams2.gravity != i) {
                layoutParams2.gravity = i;
                view.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
            if (layoutParams3.gravity != i) {
                layoutParams3.gravity = i;
                view.setLayoutParams(layoutParams3);
            }
        } else {
            throw new IllegalArgumentException("Layout parameter doesn't have gravity: " + layoutParams.getClass().getName());
        }
    }

    public static void b(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || layoutParams.height == i) {
            return;
        }
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public static void c(Window window, int i) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes == null || attributes.height == i) {
            return;
        }
        attributes.height = i;
        window.setAttributes(attributes);
    }
}
