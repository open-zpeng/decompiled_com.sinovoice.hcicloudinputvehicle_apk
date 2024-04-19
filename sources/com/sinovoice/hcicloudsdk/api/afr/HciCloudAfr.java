package com.sinovoice.hcicloudsdk.api.afr;

import com.sinovoice.hcicloudsdk.api.HciLibPath;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.afr.AfrDetectResult;
import com.sinovoice.hcicloudsdk.common.afr.AfrEnrollResult;
import com.sinovoice.hcicloudsdk.common.afr.AfrIdentifyResult;
import com.sinovoice.hcicloudsdk.common.afr.AfrVerifyResult;
import com.sinovoice.hcicloudsdk.common.utils.HciConst;
import com.sinovoice.hcicloudsdk.common.utils.PlatformUtil;
/* loaded from: classes.dex */
public class HciCloudAfr {
    static {
        try {
            if (HciLibPath.getAfrLibPath() != null) {
                PlatformUtil.loadLibraryArrayIfExist(HciLibPath.getAfrLibPath());
            } else {
                System.loadLibrary("stlport_shared");
                System.loadLibrary(HciConst.Library.SYS.CURL);
                System.loadLibrary(HciConst.Library.SYS.HCI_SYS);
                System.loadLibrary(HciConst.Library.AFR.HCI_AFR);
                System.loadLibrary(HciConst.Library.AFR.HCI_AFR_JNI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PlatformUtil.loadLibraryIfExist(HciConst.Library.AFR.HCI_AFR_CLOUD_RECOG);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.AFR.HCI_AFR_LOCAL_RECOG);
    }

    public static final native int hciAfrDetect(Session session, String str, AfrDetectResult afrDetectResult);

    public static final native int hciAfrEnroll(Session session, String str, AfrEnrollResult afrEnrollResult);

    public static final native int hciAfrFreeDetectResult(AfrDetectResult afrDetectResult);

    public static final native int hciAfrIdentify(Session session, String str, AfrIdentifyResult afrIdentifyResult);

    public static final native int hciAfrInit(String str);

    public static final native int hciAfrRelease();

    public static final native int hciAfrSessionStart(String str, Session session);

    public static final native int hciAfrSessionStop(Session session);

    public static final native int hciAfrSetImageBuffer(Session session, byte[] bArr);

    public static final native int hciAfrSetImageFile(Session session, String str);

    public static final native int hciAfrVerify(Session session, String str, AfrVerifyResult afrVerifyResult);
}
