package com.sinovoice.hcicloudsdk.common.kb;
/* loaded from: classes.dex */
public final class KbFuzzySyllable {
    public static final int KB_FUZZY_SYLLABLE_TYPE_DEFUALT = 0;
    public static final int KB_FUZZY_SYLLABLE_TYPE_FINAL = 2;
    public static final int KB_FUZZY_SYLLABLE_TYPE_FULL = 3;
    public static final int KB_FUZZY_SYLLABLE_TYPE_INITIAL = 1;

    /* renamed from: a  reason: collision with root package name */
    private int f374a = 0;

    /* renamed from: b  reason: collision with root package name */
    private String f375b = "";
    private String c = "";

    public final int getFuzzySyllableType() {
        return this.f374a;
    }

    public final String getSyllableOne() {
        return this.f375b;
    }

    public final String getSyllableTwo() {
        return this.c;
    }

    public final void setFuzzySyllableType(int i) {
        this.f374a = i;
    }

    public final void setSyllableOne(String str) {
        this.f375b = str;
    }

    public final void setSyllableTwo(String str) {
        this.c = str;
    }
}
