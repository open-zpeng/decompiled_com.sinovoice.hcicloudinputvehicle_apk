package com.sinovoice.hcicloudinputvehicle.engine.keyboard;

import java.util.ArrayList;
/* compiled from: RecogResult.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<e> f172a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f173b = false;
    private ArrayList<String> c = new ArrayList<>();

    public ArrayList<e> a() {
        return this.f172a;
    }

    public ArrayList<String> b() {
        return this.c;
    }

    public void c(boolean z) {
        this.f173b = z;
    }

    public void d(ArrayList<e> arrayList) {
        this.f172a = arrayList;
    }

    public void e(ArrayList<String> arrayList) {
        this.c = arrayList;
    }
}
