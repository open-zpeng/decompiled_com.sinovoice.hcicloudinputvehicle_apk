package com.sinovoice.hcicloudsdk.api.vpr;

import com.sinovoice.hcicloudsdk.api.HciLibPath;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.utils.HciConst;
import com.sinovoice.hcicloudsdk.common.utils.PlatformUtil;
import com.sinovoice.hcicloudsdk.common.vpr.VprEnrollResult;
import com.sinovoice.hcicloudsdk.common.vpr.VprEnrollVoiceData;
import com.sinovoice.hcicloudsdk.common.vpr.VprIdentifyResult;
import com.sinovoice.hcicloudsdk.common.vpr.VprVerifyResult;
/* loaded from: classes.dex */
public class HciCloudVpr {
    static {
        try {
            if (HciLibPath.getVprLibPath() != null) {
                PlatformUtil.loadLibraryArrayIfExist(HciLibPath.getVprLibPath());
            } else {
                System.loadLibrary("stlport_shared");
                System.loadLibrary(HciConst.Library.SYS.CURL);
                System.loadLibrary(HciConst.Library.SYS.HCI_SYS);
                System.loadLibrary(HciConst.Library.VPR.HCI_VPR);
                System.loadLibrary(HciConst.Library.VPR.HCI_VPR_JNI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PlatformUtil.loadLibraryIfExist(HciConst.Library.SYS.JTOPUS);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.SYS.JTSPEEX);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.VPR.HCI_VPR_CLOUD_RECOG);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.VPR.HCI_VPR_LOCAL_RECOG);
    }

    public static final native int hciVprEnroll(Session session, VprEnrollVoiceData vprEnrollVoiceData, String str, VprEnrollResult vprEnrollResult);

    public static final native int hciVprEnrollEx(Session session, VprEnrollVoiceData vprEnrollVoiceData, VprEnrollResult vprEnrollResult);

    public static final native int hciVprIdentify(Session session, byte[] bArr, String str, VprIdentifyResult vprIdentifyResult);

    public static final native int hciVprInit(String str);

    public static final native int hciVprRelease();

    public static final native int hciVprSessionStart(String str, Session session);

    public static final native int hciVprSessionStop(Session session);

    public static final native int hciVprVerify(Session session, byte[] bArr, String str, VprVerifyResult vprVerifyResult);

    public static final native int hciVprVerifyEx(Session session, byte[] bArr, byte[] bArr2, VprVerifyResult vprVerifyResult);
}
