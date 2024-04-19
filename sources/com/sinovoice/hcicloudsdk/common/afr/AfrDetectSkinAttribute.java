package com.sinovoice.hcicloudsdk.common.afr;
/* loaded from: classes.dex */
public class AfrDetectSkinAttribute extends AfrDetectFaceAttribute {
    public static final int Black = 2;
    public static final int Other = 3;
    public static final int White = 1;
    public static final int Yellow = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f335a;

    public int getSkin() {
        return this.f335a;
    }

    public void setSkin(int i) {
        this.f335a = i;
    }
}
