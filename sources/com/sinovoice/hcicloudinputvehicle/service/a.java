package com.sinovoice.hcicloudinputvehicle.service;

import android.content.Context;
import android.media.AudioManager;
import android.os.Vibrator;
/* compiled from: AudioAndHapticFeedbackManager.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f189a = new a();

    /* renamed from: b  reason: collision with root package name */
    private AudioManager f190b;
    private Vibrator c;
    private boolean d = true;

    private a() {
    }

    public static a a() {
        return f189a;
    }

    public static void b(Context context) {
        f189a.c(context);
    }

    private void c(Context context) {
        this.f190b = (AudioManager) context.getSystemService("audio");
        this.c = (Vibrator) context.getSystemService("vibrator");
    }

    public void d(int i) {
        if (this.f190b == null) {
            return;
        }
        boolean f = f.b().a().f();
        this.d = f;
        if (f) {
            this.f190b.playSoundEffect(i != -4 ? i != -3 ? i != -2 ? 5 : 8 : 6 : 7);
        }
    }
}
