package com.sinovoice.hcicloudsdk.common.hwr;
/* loaded from: classes.dex */
public class ColorPoint {

    /* renamed from: a  reason: collision with root package name */
    private int f359a;

    /* renamed from: b  reason: collision with root package name */
    private int f360b;
    private int c;

    public ColorPoint() {
    }

    public int getPointColor() {
        return this.c;
    }

    public int getXpos() {
        return this.f359a;
    }

    public int getYpos() {
        return this.f360b;
    }

    public void setPointColor(int i) {
        this.c = i;
    }

    public void setXpos(int i) {
        this.f359a = i;
    }

    public void setYpos(int i) {
        this.f360b = i;
    }

    public ColorPoint(int i, int i2, int i3) {
        this.f359a = i;
        this.f360b = i2;
        this.c = i3;
    }
}
