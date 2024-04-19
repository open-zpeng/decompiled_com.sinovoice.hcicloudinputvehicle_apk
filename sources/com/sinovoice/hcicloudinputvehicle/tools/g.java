package com.sinovoice.hcicloudinputvehicle.tools;

import android.content.Context;
import android.widget.Toast;
/* compiled from: ToastUtil.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f234a;

    public static void a(Context context, String str) {
        Toast toast = f234a;
        if (toast != null) {
            toast.cancel();
            f234a = Toast.makeText(context, str, 0);
        } else {
            f234a = Toast.makeText(context, str, 0);
        }
        f234a.show();
    }
}
