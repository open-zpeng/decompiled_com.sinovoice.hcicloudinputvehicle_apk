package com.sinovoice.hcicloudsdk.common.ocr;
/* loaded from: classes.dex */
public class OcrCornersResult {
    public int angle;
    public OcrRecogPoint leftBottom;
    public OcrRecogPoint leftTop;
    public OcrRecogPoint rightBottom;
    public OcrRecogPoint rightTop;

    public int getAngle() {
        return this.angle;
    }

    public OcrRecogPoint getLeftBottomPoint() {
        return this.leftBottom;
    }

    public OcrRecogPoint getLeftTop() {
        return this.leftTop;
    }

    public OcrRecogPoint getRightBottomPoint() {
        return this.rightBottom;
    }

    public OcrRecogPoint getRightTopPoint() {
        return this.rightTop;
    }

    public void setAngle(int i) {
        this.angle = i;
    }

    public void setLeftBottomPoint(OcrRecogPoint ocrRecogPoint) {
        this.leftBottom = ocrRecogPoint;
    }

    public void setLeftTopPoint(OcrRecogPoint ocrRecogPoint) {
        this.leftTop = ocrRecogPoint;
    }

    public void setRightBottomPoint(OcrRecogPoint ocrRecogPoint) {
        this.rightBottom = ocrRecogPoint;
    }

    public void setRightTopPoint(OcrRecogPoint ocrRecogPoint) {
        this.rightTop = ocrRecogPoint;
    }
}
