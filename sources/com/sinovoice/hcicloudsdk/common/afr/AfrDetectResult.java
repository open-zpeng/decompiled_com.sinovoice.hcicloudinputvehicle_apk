package com.sinovoice.hcicloudsdk.common.afr;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AfrDetectResult {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<AfrDetectFace> f332a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private long f333b = 0;

    protected final void finalize() {
        super.finalize();
    }

    public final long getExtra() {
        return this.f333b;
    }

    public final ArrayList<AfrDetectFace> getFaceList() {
        return this.f332a;
    }

    public final void setExtra(long j) {
        this.f333b = j;
    }

    public final void setFaceList(ArrayList<AfrDetectFace> arrayList) {
        this.f332a = arrayList;
    }
}
