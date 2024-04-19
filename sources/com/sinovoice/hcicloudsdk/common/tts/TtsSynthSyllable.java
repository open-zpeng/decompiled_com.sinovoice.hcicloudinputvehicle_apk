package com.sinovoice.hcicloudsdk.common.tts;
/* loaded from: classes.dex */
public class TtsSynthSyllable {

    /* renamed from: a  reason: collision with root package name */
    private final String f427a;

    /* renamed from: b  reason: collision with root package name */
    private final String f428b;
    private final int c;

    public TtsSynthSyllable(String str, String str2, int i) {
        this.f427a = str;
        this.f428b = str2;
        this.c = i;
    }

    public int getBytes() {
        return this.c;
    }

    public String getPronounciationText() {
        return this.f428b;
    }

    public String getText() {
        return this.f427a;
    }

    public String toStirng() {
        return "text: " + this.f427a + "; pronounciationText: " + this.f428b + "; bytes: " + this.c;
    }
}
