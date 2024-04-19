package com.sinovoice.hcicloudsdk.api.fpr;

import com.sinovoice.hcicloudsdk.api.HciLibPath;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.fpr.FprEnrollFingerData;
import com.sinovoice.hcicloudsdk.common.fpr.FprEnrollResult;
import com.sinovoice.hcicloudsdk.common.fpr.FprIdentifyResult;
import com.sinovoice.hcicloudsdk.common.fpr.FprVerifyResult;
import com.sinovoice.hcicloudsdk.common.utils.HciConst;
import com.sinovoice.hcicloudsdk.common.utils.PlatformUtil;
/* loaded from: classes.dex */
public class HciCloudFpr {
    static {
        try {
            if (HciLibPath.getFprLibPath() != null) {
                PlatformUtil.loadLibraryArrayIfExist(HciLibPath.getFprLibPath());
            } else {
                System.loadLibrary("stlport_shared");
                System.loadLibrary(HciConst.Library.SYS.CURL);
                System.loadLibrary(HciConst.Library.SYS.HCI_SYS);
                System.loadLibrary(HciConst.Library.FPR.HCI_FPR);
                System.loadLibrary(HciConst.Library.FPR.HCI_FPR_JNI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PlatformUtil.loadLibraryIfExist(HciConst.Library.FPR.HCI_FPR_CLOUD_RECOG);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.FPR.HCI_FPR_LOCAL_RECOG);
    }

    public static final native int hciFprEnroll(Session session, FprEnrollFingerData fprEnrollFingerData, String str, FprEnrollResult fprEnrollResult);

    public static final native int hciFprIdentify(Session session, byte[] bArr, String str, FprIdentifyResult fprIdentifyResult);

    public static final native int hciFprInit(String str);

    public static final native int hciFprRelease();

    public static final native int hciFprSessionStart(String str, Session session);

    public static final native int hciFprSessionStop(Session session);

    public static final native int hciFprVerify(Session session, byte[] bArr, String str, FprVerifyResult fprVerifyResult);
}
