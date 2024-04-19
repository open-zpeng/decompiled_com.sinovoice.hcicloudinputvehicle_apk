package com.sinovoice.hcicloudsdk.common.ocr;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class OcrRecogLayoutAnalysisResult {
    public static final int LINE_TYPE_DASHED = 2;
    public static final int LINE_TYPE_DOTTED = 3;
    public static final int LINE_TYPE_EMPTY = 256;
    public static final int LINE_TYPE_REAL = 1;
    public static final int LINE_TYPE_UNKNOWN = 0;
    public static final int LINE_TYPE_VIRTUAL = 4;
    public static final int OCR_RECOG_LANG_DEFAULT = 0;
    public static final int OCR_RECOG_LANG_EN = 4;
    public static final int OCR_RECOG_LANG_ZH_CN = 1;
    public static final int OCR_RECOG_LANG_ZH_HK = 2;
    public static final int OCR_RECOG_LANG_ZH_TW = 3;
    public static final int OCR_RECOG_RGNTYPE_AUTOTEXT = 4;
    public static final int OCR_RECOG_RGNTYPE_GRAPH = 3;
    public static final int OCR_RECOG_RGNTYPE_HORZTEXT = 0;
    public static final int OCR_RECOG_RGNTYPE_TABLE = 2;
    public static final int OCR_RECOG_RGNTYPE_VERTTEXT = 1;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<OcrRecogRegion> f403a;

    public ArrayList<OcrRecogRegion> getRecogRegionList() {
        return this.f403a;
    }

    public void setRecogRegionList(ArrayList<OcrRecogRegion> arrayList) {
        this.f403a = arrayList;
    }
}
