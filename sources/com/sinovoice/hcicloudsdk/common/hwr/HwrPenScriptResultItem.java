package com.sinovoice.hcicloudsdk.common.hwr;
/* loaded from: classes.dex */
public class HwrPenScriptResultItem {

    /* renamed from: a  reason: collision with root package name */
    private short[] f363a;

    /* renamed from: b  reason: collision with root package name */
    private int f364b;
    private int c;
    private int d;
    private int e;
    private long f;

    public int getHeight() {
        return this.e;
    }

    public short[] getPageImg() {
        return this.f363a;
    }

    public long getPenColor() {
        return this.f;
    }

    public int getWidth() {
        return this.d;
    }

    public int getX() {
        return this.f364b;
    }

    public int getY() {
        return this.c;
    }

    public void setHeight(int i) {
        this.e = i;
    }

    public void setPageImg(short[] sArr) {
        this.f363a = sArr;
    }

    public void setPenColor(long j) {
        this.f = j;
    }

    public void setWidth(int i) {
        this.d = i;
    }

    public void setX(int i) {
        this.f364b = i;
    }

    public void setY(int i) {
        this.c = i;
    }
}
