package com.sinovoice.hcicloudsdk.common.asr;
/* loaded from: classes.dex */
public class AsrResult {
    public final String answer;
    public final int endTime;
    public final int score;
    public final int startTime;
    public final String text;

    public AsrResult(String str, int i, int i2, int i3, String str2) {
        this.startTime = i2;
        this.endTime = i3;
        this.score = i;
        this.text = str;
        this.answer = str2;
    }

    public AsrResult(String str, int i, int i2, int i3) {
        this(str, i, i2, i3, null);
    }

    public AsrResult(String str, int i) {
        this(str, i, -1, -1, null);
    }
}
