package com.sinovoice.hcicloudsdk.common.kb;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class KbRecogResult {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<KbRecogResultItem> f380a = null;
    private ArrayList<KbSyllableResultItem> c = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f381b = false;

    public final boolean getBmore() {
        return this.f381b;
    }

    public final ArrayList<KbRecogResultItem> getRecogResultItemList() {
        return this.f380a;
    }

    public final ArrayList<KbSyllableResultItem> getSyllableResultItemList() {
        return this.c;
    }

    public final void setBmore(boolean z) {
        this.f381b = z;
    }

    public final void setRecogResultItemList(ArrayList<KbRecogResultItem> arrayList) {
        this.f380a = arrayList;
    }

    public final void setSyllableResultItemList(ArrayList<KbSyllableResultItem> arrayList) {
        this.c = arrayList;
    }
}
