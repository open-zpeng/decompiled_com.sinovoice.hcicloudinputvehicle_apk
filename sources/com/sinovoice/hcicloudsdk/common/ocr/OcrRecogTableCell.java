package com.sinovoice.hcicloudsdk.common.ocr;
/* loaded from: classes.dex */
public class OcrRecogTableCell {

    /* renamed from: a  reason: collision with root package name */
    private OcrRecogPoint f420a;

    /* renamed from: b  reason: collision with root package name */
    private OcrRecogPoint f421b;
    private OcrRecogPoint c;
    private OcrRecogPoint d;
    private int e;

    public int getCellNo() {
        return this.e;
    }

    public OcrRecogPoint getLeftBottomPoint() {
        return this.f421b;
    }

    public OcrRecogPoint getLeftTopPoint() {
        return this.f420a;
    }

    public OcrRecogPoint getRightBottomPoint() {
        return this.d;
    }

    public OcrRecogPoint getRightTopPoint() {
        return this.c;
    }

    public void setCellNo(int i) {
        this.e = i;
    }

    public void setLeftBottomPoint(OcrRecogPoint ocrRecogPoint) {
        this.f421b = ocrRecogPoint;
    }

    public void setLeftTopPoint(OcrRecogPoint ocrRecogPoint) {
        this.f420a = ocrRecogPoint;
    }

    public void setRightBottomPoint(OcrRecogPoint ocrRecogPoint) {
        this.d = ocrRecogPoint;
    }

    public void setRightTopPoint(OcrRecogPoint ocrRecogPoint) {
        this.c = ocrRecogPoint;
    }
}
