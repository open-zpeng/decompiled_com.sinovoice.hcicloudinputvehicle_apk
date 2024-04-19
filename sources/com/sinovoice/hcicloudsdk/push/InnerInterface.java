package com.sinovoice.hcicloudsdk.push;
/* loaded from: classes.dex */
public class InnerInterface {
    public static final String UI_CONTROL_TYPE_ASR = "asr";
    public static final String UI_CONTROL_TYPE_HWR = "hwr";
    public static final String UI_CONTROL_TYPE_NONE = "none";
    public static final String UI_CONTROL_TYPE_OCR = "ocr";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final native int hciAppendUserHisItem(byte[] bArr);

    public static final native int hciRegisterApp(String str);
}
