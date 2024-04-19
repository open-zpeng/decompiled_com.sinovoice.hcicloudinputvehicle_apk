package com.sinovoice.hcicloudsdk.common.ocr;
/* loaded from: classes.dex */
public class OcrTemplateId {

    /* renamed from: a  reason: collision with root package name */
    private int f422a;

    public OcrTemplateId() {
        this.f422a = -1;
        this.f422a = -1;
    }

    public int getTemplateId() {
        return this.f422a;
    }

    public boolean isValid() {
        return this.f422a != -1;
    }

    public void setTemplateId(int i) {
        this.f422a = i;
    }

    public String toString() {
        return String.valueOf(this.f422a);
    }
}
