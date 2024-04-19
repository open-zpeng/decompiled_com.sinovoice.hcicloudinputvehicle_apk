package com.sinovoice.hcicloudsdk.common.asr;
/* loaded from: classes.dex */
public class AsrRecogItem {

    /* renamed from: a  reason: collision with root package name */
    private String f346a;

    /* renamed from: b  reason: collision with root package name */
    private int f347b;

    public String getRecogResult() {
        return this.f346a;
    }

    public int getScore() {
        return this.f347b;
    }

    public void setRecogResult(String str) {
        this.f346a = str;
    }

    public void setScore(int i) {
        this.f347b = i;
    }

    public String toString() {
        return this.f346a + ";" + this.f347b;
    }
}
