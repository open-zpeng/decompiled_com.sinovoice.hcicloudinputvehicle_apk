package com.sinovoice.hcicloudsdk.common.hwr;
/* loaded from: classes.dex */
public class Script {

    /* renamed from: a  reason: collision with root package name */
    private ColorPoint[] f369a = new ColorPoint[4096];

    /* renamed from: b  reason: collision with root package name */
    private int f370b;

    public ColorPoint[] getArrayPoints() {
        return this.f369a;
    }

    public int getPointsCount() {
        return this.f370b;
    }

    public void setArrayPoints(ColorPoint[] colorPointArr) {
        this.f369a = colorPointArr;
    }

    public void setPointsCount(int i) {
        this.f370b = i;
    }
}
