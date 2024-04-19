package com.sinovoice.hcicloudsdk.api.hwr;

import com.sinovoice.hcicloudsdk.api.HciLibPath;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.hwr.HwrAssociateWordsResult;
import com.sinovoice.hcicloudsdk.common.hwr.HwrPenScriptResult;
import com.sinovoice.hcicloudsdk.common.hwr.HwrPinYinResult;
import com.sinovoice.hcicloudsdk.common.hwr.HwrRecogResult;
import com.sinovoice.hcicloudsdk.common.utils.HciConst;
import com.sinovoice.hcicloudsdk.common.utils.PlatformUtil;
/* loaded from: classes.dex */
public class HciCloudHwr {
    static {
        try {
            if (HciLibPath.getHwrLibPath() != null) {
                PlatformUtil.loadLibraryArrayIfExist(HciLibPath.getHwrLibPath());
            } else {
                System.loadLibrary("stlport_shared");
                System.loadLibrary(HciConst.Library.SYS.CURL);
                System.loadLibrary(HciConst.Library.SYS.HCI_SYS);
                System.loadLibrary(HciConst.Library.HWR.HCI_HWR);
                System.loadLibrary(HciConst.Library.HWR.HCI_HWR_JNI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PlatformUtil.loadLibraryIfExist(HciConst.Library.HWR.HCI_HWR_ASSOCIATE);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.HWR.HCI_HWR_CLOUD_RECOG);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.HWR.HCI_HWR_LOCAL_RECOG);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.HWR.HCI_HWR_PENSCRIPT);
    }

    public static final native int hciHwrAssociateWords(Session session, String str, String str2, HwrAssociateWordsResult hwrAssociateWordsResult);

    public static final native int hciHwrAssociateWordsAdjust(Session session, String str, String str2);

    public static final native int hciHwrConfirm(Session session, String str);

    public static final native int hciHwrInit(String str);

    public static final native int hciHwrPenScript(Session session, String str, int i, int i2, HwrPenScriptResult hwrPenScriptResult);

    public static final native int hciHwrPinyin(Session session, String str, String str2, HwrPinYinResult hwrPinYinResult);

    public static final native int hciHwrRecog(Session session, short[] sArr, String str, HwrRecogResult hwrRecogResult);

    public static final native int hciHwrRelease();

    public static final native int hciHwrSessionStart(String str, Session session);

    public static final native int hciHwrSessionStop(Session session);
}
