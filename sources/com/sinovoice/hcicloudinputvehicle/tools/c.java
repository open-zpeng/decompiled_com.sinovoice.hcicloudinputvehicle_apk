package com.sinovoice.hcicloudinputvehicle.tools;

import android.content.Context;
import android.content.pm.PackageManager;
/* compiled from: HciCloudUtils.java */
/* loaded from: classes.dex */
public class c {
    public static String a(Context context) {
        String str;
        try {
            str = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str = "";
        }
        return "V" + str;
    }
}
