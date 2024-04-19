package com.sinovoice.hcicloudsdk.common.fpr;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class FprEnrollFingerData {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<FprEnrollFingerDataItem> f349a;

    /* renamed from: b  reason: collision with root package name */
    private int f350b;

    public final int getEnrollFingerDataCount() {
        return this.f350b;
    }

    public final ArrayList<FprEnrollFingerDataItem> getEnrollFingerDataList() {
        return this.f349a;
    }

    public final void setEnrollFingerDataCount(int i) {
        this.f350b = i;
    }

    public final void setEnrollFingerDataList(ArrayList<FprEnrollFingerDataItem> arrayList) {
        this.f349a = arrayList;
    }
}
