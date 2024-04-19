package com.sinovoice.hcicloudsdk.common.afr;
/* loaded from: classes.dex */
public class AfrVerifyResult {
    public static final int AFR_VERIFY_STATUS_MATCH = 0;
    public static final int AFR_VERIFY_STATUS_NOT_MATCH = 1;

    /* renamed from: a  reason: collision with root package name */
    private int f340a;

    /* renamed from: b  reason: collision with root package name */
    private int f341b;

    public int getScore() {
        return this.f341b;
    }

    public int getStatus() {
        return this.f340a;
    }

    public void setScore(int i) {
        this.f341b = i;
    }

    public void setStatus(int i) {
        this.f340a = i;
    }
}
