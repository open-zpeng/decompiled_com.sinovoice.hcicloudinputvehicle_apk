package com.sinovoice.hcicloudsdk.api.ocr;

import android.graphics.Bitmap;
import com.sinovoice.hcicloudsdk.api.HciLibPath;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.ocr.OcrAndroidBitmap;
import com.sinovoice.hcicloudsdk.common.ocr.OcrImage;
import com.sinovoice.hcicloudsdk.common.ocr.OcrImageClearScore;
import com.sinovoice.hcicloudsdk.common.ocr.OcrRecogDeskewResult;
import com.sinovoice.hcicloudsdk.common.ocr.OcrRecogLayoutAnalysisResult;
import com.sinovoice.hcicloudsdk.common.ocr.OcrRecogRegion;
import com.sinovoice.hcicloudsdk.common.ocr.OcrRecogResult;
import com.sinovoice.hcicloudsdk.common.ocr.OcrTemplateId;
import com.sinovoice.hcicloudsdk.common.utils.HciConst;
import com.sinovoice.hcicloudsdk.common.utils.PlatformUtil;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class HciCloudOcr {
    static {
        try {
            if (HciLibPath.getOcrLibPath() != null) {
                PlatformUtil.loadLibraryArrayIfExist(HciLibPath.getOcrLibPath());
            } else {
                System.loadLibrary("stlport_shared");
                System.loadLibrary(HciConst.Library.SYS.CURL);
                System.loadLibrary(HciConst.Library.SYS.JTZ);
                System.loadLibrary(HciConst.Library.SYS.HCI_SYS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PlatformUtil.loadLibraryIfExist(HciConst.Library.OCR.OPENCV_CORE);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.OCR.OPENCV_IMGPROC);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.OCR.IREAD_FUNCTION);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.OCR.IREAD_BANKCARD);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.OCR.IREAD_BIZCARD);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.OCR.IREAD_TEMPLATE);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.OCR.HCI_OCR);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.OCR.HCI_OCR_JNI);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.OCR.HCI_OCR_LOCAL_RECOG);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.OCR.HCI_OCR_CLOUD_RECOG);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.OCR.HCI_OCR_LOCAL_RECOG_BIZCARD);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.OCR.HCI_OCR_LOCAL_RECOG_TEMPLATE);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.OCR.HCI_OCR_LOCAL_RECOG_BANKCARD);
    }

    public static final native int hciOcrDeskew(Session session, String str, OcrRecogDeskewResult ocrRecogDeskewResult);

    public static final native int hciOcrGetAndroidBitmap(Session session, OcrAndroidBitmap ocrAndroidBitmap);

    public static final native int hciOcrGetImage(Session session, OcrImage ocrImage);

    public static final native int hciOcrGetSharpnessScore(Session session, OcrImageClearScore ocrImageClearScore);

    public static final native int hciOcrInit(String str);

    public static final native int hciOcrIsEdgeExist(Session session, int i, int i2, int i3, int i4);

    public static final native int hciOcrLayoutAnalysis(Session session, String str, OcrRecogLayoutAnalysisResult ocrRecogLayoutAnalysisResult);

    public static final native int hciOcrLoadTemplate(String str, String str2, OcrTemplateId ocrTemplateId);

    public static final native int hciOcrRecog(Session session, String str, ArrayList<OcrRecogRegion> arrayList, OcrRecogResult ocrRecogResult);

    public static final native int hciOcrRelease();

    public static final native int hciOcrSaveImageFile(String str, OcrImage ocrImage);

    public static final native int hciOcrSessionStart(String str, Session session);

    public static final native int hciOcrSessionStop(Session session);

    public static final native int hciOcrSetImageBuffer(Session session, byte[] bArr);

    public static final native int hciOcrSetImageBufferEx(Session session, byte[] bArr, int i, int i2, int i3);

    public static final native int hciOcrSetImageByAndroidBitmap(Session session, Bitmap bitmap);

    public static final native int hciOcrSetImageFile(Session session, String str);

    public static final native int hciOcrUnloadTemplate(OcrTemplateId ocrTemplateId);
}
