package com.sinovoice.hcicloudsdk.common.ocr;
/* loaded from: classes.dex */
public class OcrRecogRegion {

    /* renamed from: a  reason: collision with root package name */
    private OcrRecogRect f412a;

    /* renamed from: b  reason: collision with root package name */
    private int f413b;
    private int c;
    private OcrRecogTable d;

    public OcrRecogTable getOutRecogTable() {
        return this.d;
    }

    public int getRegionLang() {
        return this.c;
    }

    public OcrRecogRect getRegionRect() {
        return this.f412a;
    }

    public int getRegionType() {
        return this.f413b;
    }

    public void setOutRecogTable(OcrRecogTable ocrRecogTable) {
        this.d = ocrRecogTable;
    }

    public void setRegionLang(int i) {
        this.c = i;
    }

    public void setRegionRect(OcrRecogRect ocrRecogRect) {
        this.f412a = ocrRecogRect;
    }

    public void setRegionType(int i) {
        this.f413b = i;
    }
}
