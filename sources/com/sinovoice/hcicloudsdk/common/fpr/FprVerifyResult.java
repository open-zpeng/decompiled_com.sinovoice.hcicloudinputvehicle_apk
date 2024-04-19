package com.sinovoice.hcicloudsdk.common.fpr;
/* loaded from: classes.dex */
public class FprVerifyResult {
    public static final int FPR_VERIFY_STATUS_MATCH = 0;
    public static final int FPR_VERIFY_STATUS_NOT_MATCH = 1;

    /* renamed from: a  reason: collision with root package name */
    private int f357a;

    /* renamed from: b  reason: collision with root package name */
    private int f358b;

    public int getScore() {
        return this.f358b;
    }

    public int getStatus() {
        return this.f357a;
    }

    public void setScore(int i) {
        this.f358b = i;
    }

    public void setStatus(int i) {
        this.f357a = i;
    }
}
