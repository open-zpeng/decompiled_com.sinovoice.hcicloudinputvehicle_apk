package com.sinovoice.hcicloudsdk.common.afr;
/* loaded from: classes.dex */
public class AfrDetectGlassesAttribute extends AfrDetectFaceAttribute {
    public static final int Black = 2;
    public static final int None = 0;
    public static final int Normal = 1;
    public static final int NotSet = 2;

    /* renamed from: a  reason: collision with root package name */
    private int f325a;

    public int getGlasses() {
        return this.f325a;
    }

    public void setGlasses(int i) {
        this.f325a = i;
    }
}
