package com.sinovoice.hcicloudsdk.common.ocr;
/* loaded from: classes.dex */
public class OcrRecogDeskewResult {

    /* renamed from: a  reason: collision with root package name */
    private int f400a;

    /* renamed from: b  reason: collision with root package name */
    private int f401b;
    private byte[] c;
    private OcrImage d;

    public int getDeskewAngle() {
        return this.f400a;
    }

    @Deprecated
    public byte[] getImageData() {
        return this.c;
    }

    @Deprecated
    public int getImageFormat() {
        return this.f401b;
    }

    public OcrImage getOcrImage() {
        return this.d;
    }

    public void setDeskewAngle(int i) {
        this.f400a = i;
    }

    @Deprecated
    public void setImageData(byte[] bArr) {
        this.c = bArr;
    }

    @Deprecated
    public void setImageFormat(int i) {
        this.f401b = i;
    }

    public void setOcrImage(OcrImage ocrImage) {
        this.d = ocrImage;
    }
}
