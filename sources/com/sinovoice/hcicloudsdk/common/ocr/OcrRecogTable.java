package com.sinovoice.hcicloudsdk.common.ocr;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class OcrRecogTable {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<OcrRecogFrameLine> f418a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<OcrRecogFrameLine> f419b;
    private ArrayList<OcrRecogTableCell> c;

    public ArrayList<OcrRecogFrameLine> getHLineList() {
        return this.f418a;
    }

    public ArrayList<OcrRecogTableCell> getTableCellList() {
        return this.c;
    }

    public ArrayList<OcrRecogFrameLine> getVLineList() {
        return this.f419b;
    }

    public void setHLineList(ArrayList<OcrRecogFrameLine> arrayList) {
        this.f418a = arrayList;
    }

    public void setTableCellList(ArrayList<OcrRecogTableCell> arrayList) {
        this.c = arrayList;
    }

    public void setVLineList(ArrayList<OcrRecogFrameLine> arrayList) {
        this.f419b = arrayList;
    }
}
