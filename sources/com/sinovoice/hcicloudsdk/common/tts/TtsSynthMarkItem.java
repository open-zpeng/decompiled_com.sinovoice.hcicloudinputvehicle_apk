package com.sinovoice.hcicloudsdk.common.tts;
/* loaded from: classes.dex */
public class TtsSynthMarkItem {

    /* renamed from: a  reason: collision with root package name */
    private String f423a;

    /* renamed from: b  reason: collision with root package name */
    private int f424b;

    public String getMarkName() {
        return this.f423a;
    }

    public int getMarkTime() {
        return this.f424b;
    }

    public void setMarkName(String str) {
        this.f423a = str;
    }

    public void setMarkTime(int i) {
        this.f424b = i;
    }

    public String toStirng() {
        return "markName:" + this.f423a + ";markTime:" + this.f424b;
    }
}
