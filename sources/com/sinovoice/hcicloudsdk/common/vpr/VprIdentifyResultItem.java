package com.sinovoice.hcicloudsdk.common.vpr;
/* loaded from: classes.dex */
public class VprIdentifyResultItem {

    /* renamed from: a  reason: collision with root package name */
    private String f451a;

    /* renamed from: b  reason: collision with root package name */
    private int f452b;

    public int getScore() {
        return this.f452b;
    }

    public String getUserId() {
        return this.f451a;
    }

    public void setScore(int i) {
        this.f452b = i;
    }

    public void setUserId(String str) {
        this.f451a = str;
    }

    public String toString() {
        return this.f451a + ";" + this.f452b;
    }
}
