package com.sinovoice.hcicloudsdk.common.ocr;
/* loaded from: classes.dex */
public class OcrImage {

    /* renamed from: a  reason: collision with root package name */
    private int f395a;

    /* renamed from: b  reason: collision with root package name */
    private int f396b;
    private int c;
    private int d;
    private byte[] e;
    private int f;
    private int g;

    public int getBitsPerPixel() {
        return this.c;
    }

    public byte[] getData() {
        return this.e;
    }

    public int getHeight() {
        return this.f396b;
    }

    public int getWidth() {
        return this.f395a;
    }

    public int getWidthBytes() {
        return this.d;
    }

    public int getXResolution() {
        return this.f;
    }

    public int getYResolution() {
        return this.g;
    }

    public void setBitsPerPixel(int i) {
        this.c = i;
    }

    public void setData(byte[] bArr) {
        this.e = bArr;
    }

    public void setHeight(int i) {
        this.f396b = i;
    }

    public void setWidth(int i) {
        this.f395a = i;
    }

    public void setWidthBytes(int i) {
        this.d = i;
    }

    public void setXResolution(int i) {
        this.f = i;
    }

    public void setYResolution(int i) {
        this.g = i;
    }
}
