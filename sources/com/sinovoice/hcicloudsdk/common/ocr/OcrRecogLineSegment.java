package com.sinovoice.hcicloudsdk.common.ocr;
/* loaded from: classes.dex */
public class OcrRecogLineSegment {

    /* renamed from: a  reason: collision with root package name */
    private int f406a;

    /* renamed from: b  reason: collision with root package name */
    private int f407b;
    private int c;
    private int d;
    private int e;
    private int f;

    public int getEndX() {
        return this.c;
    }

    public int getEndY() {
        return this.d;
    }

    public int getStartX() {
        return this.f406a;
    }

    public int getStartY() {
        return this.f407b;
    }

    public int getThickness() {
        return this.e;
    }

    public int getType() {
        return this.f;
    }

    public void setEndX(int i) {
        this.c = i;
    }

    public void setEndY(int i) {
        this.d = i;
    }

    public void setStartX(int i) {
        this.f406a = i;
    }

    public void setStartY(int i) {
        this.f407b = i;
    }

    public void setThickness(int i) {
        this.e = i;
    }

    public void setType(int i) {
        this.f = i;
    }
}
