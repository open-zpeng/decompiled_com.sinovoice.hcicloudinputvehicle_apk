package com.sinovoice.hcicloudsdk.common.kb;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class KbRecogResultItem {
    private int c = 0;
    private ArrayList<KbResultMatchItem> d = null;

    /* renamed from: b  reason: collision with root package name */
    private String f383b = "";

    /* renamed from: a  reason: collision with root package name */
    private String f382a = "";

    public int getMatchItemCount() {
        return this.c;
    }

    public ArrayList<KbResultMatchItem> getMatchItemList() {
        return this.d;
    }

    public String getResult() {
        return this.f382a;
    }

    public String getSymbols() {
        return this.f383b;
    }

    public void setMatchItemCount(int i) {
        this.c = i;
    }

    public void setMatchItemList(ArrayList<KbResultMatchItem> arrayList) {
        this.d = arrayList;
    }

    public void setResult(String str) {
        this.f382a = str;
    }

    public void setSymbols(String str) {
        this.f383b = str;
    }
}
