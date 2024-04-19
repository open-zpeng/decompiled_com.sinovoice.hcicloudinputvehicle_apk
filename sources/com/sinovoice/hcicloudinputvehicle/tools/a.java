package com.sinovoice.hcicloudinputvehicle.tools;

import android.os.Build;
/* compiled from: BuildCompatUtils.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f229a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f230b;

    static {
        int i;
        boolean equals = Build.VERSION.CODENAME.equals("REL");
        f229a = equals;
        if (equals) {
            i = Build.VERSION.SDK_INT;
        } else {
            i = Build.VERSION.SDK_INT + 1;
        }
        f230b = i;
    }
}
