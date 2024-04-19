package com.sinovoice.hcicloudsdk.common.vpr;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class VprEnrollVoiceData {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<VprEnrollVoiceDataItem> f446a;

    /* renamed from: b  reason: collision with root package name */
    private int f447b;

    public final int getEnrollVoiceDataCount() {
        return this.f447b;
    }

    public final ArrayList<VprEnrollVoiceDataItem> getEnrollVoiceDataList() {
        return this.f446a;
    }

    public final void setEnrollVoiceDataCount(int i) {
        this.f447b = i;
    }

    public final void setEnrollVoiceDataList(ArrayList<VprEnrollVoiceDataItem> arrayList) {
        this.f446a = arrayList;
    }
}
