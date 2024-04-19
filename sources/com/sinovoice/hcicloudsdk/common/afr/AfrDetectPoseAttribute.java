package com.sinovoice.hcicloudsdk.common.afr;
/* loaded from: classes.dex */
public class AfrDetectPoseAttribute extends AfrDetectFaceAttribute {
    public static final int PitchDown = 2;
    public static final int PitchNormal = 0;
    public static final int PitchNotSet = 3;
    public static final int PitchUp = 1;
    public static final int YawLeft = 5;
    public static final int YawNormal = 4;
    public static final int YawNotSet = 7;
    public static final int YawRight = 6;

    /* renamed from: a  reason: collision with root package name */
    private int f330a;

    /* renamed from: b  reason: collision with root package name */
    private int f331b;
    private int c;

    public int getPitchPose() {
        return this.f330a;
    }

    public int getPose() {
        return this.c;
    }

    public int getYawPose() {
        return this.f331b;
    }

    public void setPitchPose(int i) {
        this.f330a = i;
    }

    public void setPose(int i) {
        this.c = i;
    }

    public void setYawPose(int i) {
        this.f331b = i;
    }
}
