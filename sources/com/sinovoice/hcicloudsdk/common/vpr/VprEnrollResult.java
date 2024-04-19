package com.sinovoice.hcicloudsdk.common.vpr;
/* loaded from: classes.dex */
public final class VprEnrollResult {

    /* renamed from: a  reason: collision with root package name */
    private String f444a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f445b;

    public final byte[] getModelData() {
        return this.f445b;
    }

    public final String getUserId() {
        return this.f444a;
    }

    public final void setModelData(byte[] bArr) {
        this.f445b = bArr;
    }

    public final void setUserId(String str) {
        this.f444a = str;
    }
}
