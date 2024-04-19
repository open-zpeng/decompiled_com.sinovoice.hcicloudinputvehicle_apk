package com.sinovoice.hcicloudsdk.common.afr;
/* loaded from: classes.dex */
public class AfrDetectLeftEyeAttribute extends AfrDetectFaceAttribute {
    public static final int Close = 1;
    public static final int Open = 0;
    public static final int Other = 2;

    /* renamed from: a  reason: collision with root package name */
    private int f328a;

    public int getLeftEye() {
        return this.f328a;
    }

    public void setLeftEye(int i) {
        this.f328a = i;
    }
}
