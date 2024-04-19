package com.sinovoice.hcicloudsdk.common.fpr;
/* loaded from: classes.dex */
public class FprIdentifyResultItem {

    /* renamed from: a  reason: collision with root package name */
    private String f355a;

    /* renamed from: b  reason: collision with root package name */
    private int f356b;

    public int getScore() {
        return this.f356b;
    }

    public String getUserId() {
        return this.f355a;
    }

    public void setScore(int i) {
        this.f356b = i;
    }

    public void setUserId(String str) {
        this.f355a = str;
    }

    public String toString() {
        return this.f355a + ";" + this.f356b;
    }
}
