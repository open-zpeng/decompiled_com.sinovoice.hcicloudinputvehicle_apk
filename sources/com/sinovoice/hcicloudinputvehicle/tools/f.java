package com.sinovoice.hcicloudinputvehicle.tools;

import android.graphics.Typeface;
import android.util.Log;
import java.io.File;
/* compiled from: TextTypeFaceUtils.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static Typeface f233a;

    public static Typeface a() {
        return f233a;
    }

    public static void b() {
        try {
            f233a = Typeface.createFromFile(new File("/system/fonts/Xpeng-Medium.ttf"));
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("sinovoice", "输入法无法获取 /system/fonts/Xpeng-Medium.ttf 该路径 ");
            f233a = Typeface.DEFAULT;
        }
    }
}
