package com.sinovoice.hcicloudsdk.common.ocr;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class OcrRecogResult {
    public static final int OCR_RECOG_NODE_CELL = 2;
    public static final int OCR_RECOG_NODE_CHAR = 4;
    public static final int OCR_RECOG_NODE_LINE = 3;
    public static final int OCR_RECOG_NODE_PAGE = 0;
    public static final int OCR_RECOG_NODE_REGION = 1;

    /* renamed from: a  reason: collision with root package name */
    private String f416a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<OcrRecogNode> f417b;
    private byte[] c;

    public byte[] getExportFileBuf() {
        return this.c;
    }

    public ArrayList<OcrRecogNode> getNodeList() {
        return this.f417b;
    }

    public String getResultText() {
        return this.f416a;
    }

    public void setExportFileBuf(byte[] bArr) {
        this.c = bArr;
    }

    public void setNodeList(ArrayList<OcrRecogNode> arrayList) {
        this.f417b = arrayList;
    }

    public void setResultText(String str) {
        this.f416a = str;
    }
}
