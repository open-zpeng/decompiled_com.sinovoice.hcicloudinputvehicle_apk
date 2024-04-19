package com.sinovoice.hcicloudsdk.common.tts;

import java.util.ArrayList;
/* loaded from: classes.dex */
public interface ITtsSynthHandler {
    void onSynthAudioData(byte[] bArr);

    void onSynthError(int i);

    void onSynthFinish(boolean z);

    void onSynthStart();

    void onSynthSyllables(String str, ArrayList<TtsSynthSyllable> arrayList);
}
