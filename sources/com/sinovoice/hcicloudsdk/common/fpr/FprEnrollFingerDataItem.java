package com.sinovoice.hcicloudsdk.common.fpr;
/* loaded from: classes.dex */
public class FprEnrollFingerDataItem {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f351a;

    /* renamed from: b  reason: collision with root package name */
    private int f352b;

    public byte[] getFingerData() {
        return this.f351a;
    }

    public int getFingerDataLen() {
        return this.f352b;
    }

    public void setFingerData(byte[] bArr) {
        this.f351a = bArr;
    }

    public void setFingerDataLen(int i) {
        this.f352b = i;
    }
}
