package com.sinovoice.hcicloudsdk.common.vpr;
/* loaded from: classes.dex */
public class VprVerifyResult {
    public static final int VPR_VERIFY_STATUS_MATCH = 0;
    public static final int VPR_VERIFY_STATUS_NOT_MATCH = 1;

    /* renamed from: a  reason: collision with root package name */
    private int f453a;

    /* renamed from: b  reason: collision with root package name */
    private int f454b;

    public int getScore() {
        return this.f454b;
    }

    public int getStatus() {
        return this.f453a;
    }

    public void setScore(int i) {
        this.f454b = i;
    }

    public void setStatus(int i) {
        this.f453a = i;
    }
}
