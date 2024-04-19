package com.sinovoice.hcicloudsdk.common.ocr;
/* loaded from: classes.dex */
public class OcrRecogRegionNode {

    /* renamed from: a  reason: collision with root package name */
    private OcrRecogRect f414a;

    /* renamed from: b  reason: collision with root package name */
    private int f415b;
    private int c;

    public int getRegionLang() {
        return this.c;
    }

    public OcrRecogRect getRegionRect() {
        return this.f414a;
    }

    public int getRegionType() {
        return this.f415b;
    }

    public void setRegionLang(int i) {
        this.c = i;
    }

    public void setRegionRect(OcrRecogRect ocrRecogRect) {
        this.f414a = ocrRecogRect;
    }

    public void setRegionType(int i) {
        this.f415b = i;
    }
}
