package com.sinovoice.hcicloudinputvehicle.tools;

import android.os.Environment;
/* compiled from: JTFileUtil.java */
/* loaded from: classes.dex */
public class d {
    public static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
