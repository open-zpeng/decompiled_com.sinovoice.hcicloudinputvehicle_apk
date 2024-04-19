package com.xiaopeng.libtheme;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
/* compiled from: ThemeManager.java */
/* loaded from: classes.dex */
public class a {

    /* compiled from: ThemeManager.java */
    /* renamed from: com.xiaopeng.libtheme.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0018a {

        /* renamed from: a  reason: collision with root package name */
        public static final ArrayList<String> f457a;

        static {
            ArrayList<String> arrayList = new ArrayList<>();
            f457a = arrayList;
            arrayList.clear();
            arrayList.add("theme");
            arrayList.add("style");
            arrayList.add("alpha");
            arrayList.add("foreground");
            arrayList.add("background");
            arrayList.add("src");
            arrayList.add("textColor");
            arrayList.add("textColorHint");
            arrayList.add("drawableLeft");
            arrayList.add("drawableTop");
            arrayList.add("drawableRight");
            arrayList.add("drawableBottom");
            arrayList.add("progressDrawable");
            arrayList.add("thumb");
            arrayList.add("button");
            arrayList.add("divider");
        }

        public static boolean a(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return f457a.contains(str);
        }

        public static boolean b(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return "theme".equals(str) || "style".equals(str);
        }
    }

    public static boolean a(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        return configuration != null && (configuration.uiMode & 48) == 32;
    }

    public static boolean b(Configuration configuration) {
        return configuration != null && (configuration.uiMode & 192) == 128;
    }

    public static HashMap<String, Integer> c(Context context, AttributeSet attributeSet) {
        return b.c(context, attributeSet);
    }

    public static void d(View view, HashMap<String, Integer> hashMap) {
        b.f(view, hashMap);
    }
}
