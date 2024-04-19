package com.sinovoice.hcicloudsdk.common.afr;
/* loaded from: classes.dex */
public class AfrDetectGenderAttribute extends AfrDetectFaceAttribute {
    public static final int Female = 1;
    public static final int Male = 0;
    public static final int Other = 2;

    /* renamed from: a  reason: collision with root package name */
    private int f324a;

    public int getGender() {
        return this.f324a;
    }

    public void setGender(int i) {
        this.f324a = i;
    }
}
