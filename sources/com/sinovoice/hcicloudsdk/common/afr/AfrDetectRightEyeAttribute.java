package com.sinovoice.hcicloudsdk.common.afr;
/* loaded from: classes.dex */
public class AfrDetectRightEyeAttribute extends AfrDetectFaceAttribute {
    public static final int Close = 1;
    public static final int Open = 0;
    public static final int Other = 2;

    /* renamed from: a  reason: collision with root package name */
    private int f334a;

    public int getRightEye() {
        return this.f334a;
    }

    public void setRightEye(int i) {
        this.f334a = i;
    }
}
