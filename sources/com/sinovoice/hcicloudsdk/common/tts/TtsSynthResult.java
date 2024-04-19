package com.sinovoice.hcicloudsdk.common.tts;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class TtsSynthResult {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f425a;

    /* renamed from: b  reason: collision with root package name */
    private String f426b;
    private boolean c;
    private ArrayList<TtsSynthMarkItem> d;
    private ArrayList<TtsSynthSyllable> e;
    private String f;
    private String g;

    public String getConfig() {
        return this.g;
    }

    public String getCurrentSynthText() {
        return this.f426b;
    }

    public String getSentence() {
        return this.f;
    }

    public ArrayList<TtsSynthSyllable> getTtsSyllables() {
        return this.e;
    }

    public ArrayList<TtsSynthMarkItem> getTtsSynthMark() {
        return this.d;
    }

    public byte[] getVoiceData() {
        return this.f425a;
    }

    public boolean isHasMoreData() {
        return this.c;
    }

    public void setConfig(String str) {
        this.g = str;
    }

    public void setCurrentSynthText(String str) {
        this.f426b = str;
    }

    public void setHasMoreData(boolean z) {
        this.c = z;
    }

    public void setSentence(String str) {
        this.f = str;
    }

    public void setTtsSyllables(ArrayList<TtsSynthSyllable> arrayList) {
        this.e = arrayList;
    }

    public void setTtsSynthMark(ArrayList<TtsSynthMarkItem> arrayList) {
        this.d = arrayList;
    }

    public void setVoiceData(byte[] bArr) {
        this.f425a = bArr;
    }
}
