package com.sinovoice.hcicloudsdk.common.kb;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class KbConvResult {

    /* renamed from: b  reason: collision with root package name */
    private int f372b = 0;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<KbConvResultItem> f371a = null;

    public final int getConvItemCount() {
        return this.f372b;
    }

    public final ArrayList<KbConvResultItem> getConvResultItemList() {
        return this.f371a;
    }

    public final void setConvItemCount(int i) {
        this.f372b = i;
    }

    public final void setConvResultItemList(ArrayList<KbConvResultItem> arrayList) {
        this.f371a = arrayList;
    }
}
