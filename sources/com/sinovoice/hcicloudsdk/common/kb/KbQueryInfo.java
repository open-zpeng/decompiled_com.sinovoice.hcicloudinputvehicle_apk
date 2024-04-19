package com.sinovoice.hcicloudsdk.common.kb;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class KbQueryInfo {

    /* renamed from: a  reason: collision with root package name */
    private String f376a = "";

    /* renamed from: b  reason: collision with root package name */
    private int f377b = 0;
    private ArrayList<KbQuerySelectedItem> c = null;
    private int d = 0;
    private ArrayList<KbSlideInfoItem> e = null;

    public final String getQuery() {
        return this.f376a;
    }

    public final ArrayList<KbQuerySelectedItem> getQuerySelectedItemList() {
        return this.c;
    }

    public final int getSelectedItemCount() {
        return this.f377b;
    }

    public final int getSlideInfoItemCount() {
        return this.d;
    }

    public final ArrayList<KbSlideInfoItem> getSlideInfoItemList() {
        return this.e;
    }

    public final void setQuery(String str) {
        this.f376a = str;
    }

    public final void setQuerySelectedItemList(ArrayList<KbQuerySelectedItem> arrayList) {
        this.c = arrayList;
    }

    public final void setSelectedItemCount(int i) {
        this.f377b = i;
    }

    public final void setSlideInfoItemCount(int i) {
        this.d = i;
    }

    public final void setSlideInfoItemList(ArrayList<KbSlideInfoItem> arrayList) {
        this.e = arrayList;
    }
}
