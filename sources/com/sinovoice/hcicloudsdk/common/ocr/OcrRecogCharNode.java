package com.sinovoice.hcicloudsdk.common.ocr;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class OcrRecogCharNode {
    public static final int CANDIDATE_NUM = 5;

    /* renamed from: a  reason: collision with root package name */
    private String f398a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f399b;
    private short c;
    private boolean d;
    private OcrRecogRect e;

    public ArrayList<String> getCandidateWords() {
        return this.f399b;
    }

    public String getChar() {
        return this.f398a;
    }

    public OcrRecogRect getImageRect() {
        return this.e;
    }

    public short getSpaceBefore() {
        return this.c;
    }

    public boolean isAccept() {
        return this.d;
    }

    public void setAccept(boolean z) {
        this.d = z;
    }

    public void setCandidateWords(ArrayList<String> arrayList) {
        this.f399b = arrayList;
    }

    public void setChar(String str) {
        this.f398a = str;
    }

    public void setImageRect(OcrRecogRect ocrRecogRect) {
        this.e = ocrRecogRect;
    }

    public void setSpaceBefore(short s) {
        this.c = s;
    }
}
