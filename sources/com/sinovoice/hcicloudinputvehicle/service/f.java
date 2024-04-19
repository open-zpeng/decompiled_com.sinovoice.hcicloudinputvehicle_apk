package com.sinovoice.hcicloudinputvehicle.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.Log;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: Settings.java */
/* loaded from: classes.dex */
public final class f implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f223a = f.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final f f224b = new f();
    private Context c;
    private SharedPreferences d;
    private h e;
    private final ReentrantLock f = new ReentrantLock();
    private Resources g;

    private f() {
    }

    public static f b() {
        return f224b;
    }

    public static void c(Context context) {
        f224b.e(context);
    }

    private void e(Context context) {
        this.c = context;
        this.d = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public h a() {
        return this.e;
    }

    public void d(Context context) {
        this.f.lock();
        this.c = context;
        this.g = context.getResources();
        this.e = new h(context, this.d, this.g);
        this.f.unlock();
        String str = f223a;
        Log.d(str, "loadSettings: currentsettings=" + this.e.toString());
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        String str2 = f223a;
        b.b.a.b.a.a(str2, "onSharedPreferenceChanged: " + str);
        this.f.lock();
        try {
            if (this.e == null) {
                return;
            }
            d(this.c);
        } finally {
            this.f.unlock();
        }
    }
}
