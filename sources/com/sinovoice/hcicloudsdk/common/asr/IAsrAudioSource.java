package com.sinovoice.hcicloudsdk.common.asr;
/* loaded from: classes.dex */
public interface IAsrAudioSource {
    int bytesAvailable();

    int read(byte[] bArr, int i, int i2);
}
