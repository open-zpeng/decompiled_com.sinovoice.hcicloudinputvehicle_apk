package com.sinovoice.hcicloudsdk.common.afr;
/* loaded from: classes.dex */
public class AfrDetectMouthAttribute extends AfrDetectFaceAttribute {
    public static final int Close = 1;
    public static final int Open = 0;
    public static final int Other = 2;

    /* renamed from: a  reason: collision with root package name */
    private int f329a;

    public int getMouth() {
        return this.f329a;
    }

    public void setMouth(int i) {
        this.f329a = i;
    }
}
