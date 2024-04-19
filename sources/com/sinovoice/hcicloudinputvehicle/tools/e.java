package com.sinovoice.hcicloudinputvehicle.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.util.SimpleArrayMap;
/* compiled from: SharedPreferenceUtils.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleArrayMap<String, e> f231a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f232b;

    private e(String str, Context context) {
        this.f232b = context.getSharedPreferences(str, 0);
    }

    public static e a(Context context) {
        return b("", context);
    }

    public static e b(String str, Context context) {
        if (f(str)) {
            str = "spUtils";
        }
        e eVar = f231a.get(str);
        if (eVar == null) {
            e eVar2 = new e(str, context);
            f231a.put(str, eVar2);
            return eVar2;
        }
        return eVar;
    }

    private static boolean f(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public int c(@NonNull String str) {
        return d(str, -1);
    }

    public int d(@NonNull String str, int i) {
        return this.f232b.getInt(str, i);
    }

    public String e(@NonNull String str, @NonNull String str2) {
        return this.f232b.getString(str, str2);
    }

    public void g(@NonNull String str, int i) {
        this.f232b.edit().putInt(str, i).apply();
    }

    public void h(@NonNull String str, @NonNull String str2) {
        this.f232b.edit().putString(str, str2).apply();
    }
}
