package com.sinovoice.hcicloudsdk.common.ocr;
/* loaded from: classes.dex */
public class OcrRecogLineNode {

    /* renamed from: a  reason: collision with root package name */
    private int f404a;

    /* renamed from: b  reason: collision with root package name */
    private int f405b;
    private int c;
    private int d;

    public int getBaseLine() {
        return this.f404a;
    }

    public int getLineSize() {
        return this.f405b;
    }

    public int getXChar() {
        return this.c;
    }

    public int getYChar() {
        return this.d;
    }

    public void setBaseLine(int i) {
        this.f404a = i;
    }

    public void setLineSize(int i) {
        this.f405b = i;
    }

    public void setXChar(int i) {
        this.c = i;
    }

    public void setYChar(int i) {
        this.d = i;
    }
}
