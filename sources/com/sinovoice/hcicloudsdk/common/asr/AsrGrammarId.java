package com.sinovoice.hcicloudsdk.common.asr;
/* loaded from: classes.dex */
public class AsrGrammarId {

    /* renamed from: a  reason: collision with root package name */
    private int f345a = -1;

    public int getGrammarId() {
        return this.f345a;
    }

    public boolean isValid() {
        return this.f345a != -1;
    }

    public void setGrammarId(int i) {
        this.f345a = i;
    }

    public String toString() {
        return String.valueOf(this.f345a);
    }
}
