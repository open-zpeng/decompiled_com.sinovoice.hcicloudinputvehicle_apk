package com.sinovoice.hcicloudinputvehicle.ui;
/* compiled from: StrokeMgr.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f302a;

    /* renamed from: b  reason: collision with root package name */
    private short[] f303b;
    private int c = 0;
    private int d;
    private int e;

    private b() {
        this.f303b = null;
        this.f303b = new short[40960];
    }

    public static b f() {
        if (f302a == null) {
            f302a = new b();
        }
        return f302a;
    }

    public synchronized void a() {
        short[] sArr = this.f303b;
        int i = this.c;
        sArr[i] = -1;
        int i2 = i + 1;
        this.c = i2;
        sArr[i2] = -1;
        this.c = i2 + 1;
    }

    public synchronized boolean b(short s, short s2) {
        if (s < 0 || s2 < 0) {
            return false;
        }
        if (s == this.d && s2 == this.e) {
            return false;
        }
        int i = this.c;
        if (i / 2 < 20478) {
            short[] sArr = this.f303b;
            sArr[i] = s;
            this.d = s;
            int i2 = i + 1;
            this.c = i2;
            sArr[i2] = s2;
            this.e = s2;
            this.c = i2 + 1;
            return true;
        }
        return false;
    }

    public synchronized void c() {
        short[] sArr = this.f303b;
        int i = this.c;
        sArr[i] = -1;
        int i2 = i + 1;
        this.c = i2;
        sArr[i2] = 0;
        this.c = i2 + 1;
    }

    public synchronized short[] d() {
        short[] sArr;
        int i = this.c;
        sArr = new short[i];
        System.arraycopy(this.f303b, 0, sArr, 0, i);
        return sArr;
    }

    public synchronized int e() {
        short[] sArr = this.f303b;
        short s = sArr[0];
        short s2 = sArr[1];
        int abs = Math.abs(this.d - s);
        int abs2 = Math.abs(this.e - s2);
        return abs > abs2 ? abs : abs2;
    }

    public synchronized void g() {
        this.c = 0;
    }
}
