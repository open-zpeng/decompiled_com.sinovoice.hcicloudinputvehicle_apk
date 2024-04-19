package com.sinovoice.hcicloudinputvehicle.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.sinovoice.hcicloudinputvehicle.R;
/* compiled from: SettingsValues.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public boolean f226a;
    private boolean g;
    private String i;
    private String j;
    private String k;
    private boolean m;
    private boolean n;
    public boolean d = false;
    public boolean e = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f227b = false;
    public boolean c = false;
    private final boolean f = false;
    private boolean h = false;
    private boolean l = false;

    public h(Context context, SharedPreferences sharedPreferences, Resources resources) {
        this.f226a = sharedPreferences.getBoolean("sound_on", true);
        this.m = sharedPreferences.getBoolean("auto_space", true);
        this.n = sharedPreferences.getBoolean("night_mode", false);
        this.j = sharedPreferences.getString("setting_daymode_start_time", resources.getString(R.string.default_daymode_start_time));
        this.k = sharedPreferences.getString("setting_nightmode_start_time", resources.getString(R.string.default_nightmode_start_time));
        this.i = sharedPreferences.getString("split_mode", "line");
    }

    public String a() {
        return this.i;
    }

    public boolean b() {
        return this.f;
    }

    public boolean c() {
        return this.m;
    }

    public boolean d() {
        return this.f227b;
    }

    public boolean e() {
        return this.l;
    }

    public boolean f() {
        return this.f226a;
    }

    public boolean g() {
        return this.h;
    }

    public String toString() {
        return "SettingsValues{mSoundOn=" + this.f226a + ", mFussyOn=" + this.f227b + ", mShowsVoiceKey=" + this.c + ", mRectify=" + this.d + ", mRecogRangeGBK=" + this.e + ", mAutoCaps=" + this.f + ", mDayNightTheme=" + this.g + ", mSwipeSwitch=" + this.h + ", splitMode='" + this.i + "', dayModeStartTime='" + this.j + "', nightModeStartTime='" + this.k + "', mPopOn=" + this.l + ", mAutoSpace=" + this.m + '}';
    }
}
