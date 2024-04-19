package com.sinovoice.hcicloudsdk.common.mt;
/* loaded from: classes.dex */
public final class MtTransResult {

    /* renamed from: a  reason: collision with root package name */
    private String f390a;

    /* renamed from: b  reason: collision with root package name */
    private int f391b;

    public final int getScore() {
        return this.f391b;
    }

    public final String getTransResult() {
        return this.f390a;
    }

    public final void setScore(int i) {
        this.f391b = i;
    }

    public final void setTransResult(String str) {
        this.f390a = str;
    }

    public final String toString() {
        return this.f390a + ";" + this.f391b;
    }
}
