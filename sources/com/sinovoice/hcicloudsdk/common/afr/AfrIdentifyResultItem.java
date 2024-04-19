package com.sinovoice.hcicloudsdk.common.afr;
/* loaded from: classes.dex */
public class AfrIdentifyResultItem {

    /* renamed from: a  reason: collision with root package name */
    private String f338a;

    /* renamed from: b  reason: collision with root package name */
    private int f339b;

    public int getScore() {
        return this.f339b;
    }

    public String getUserId() {
        return this.f338a;
    }

    public void setScore(int i) {
        this.f339b = i;
    }

    public void setUserId(String str) {
        this.f338a = str;
    }

    public String toString() {
        return this.f338a + ";" + this.f339b;
    }
}
