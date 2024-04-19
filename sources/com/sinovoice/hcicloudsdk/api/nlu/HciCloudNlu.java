package com.sinovoice.hcicloudsdk.api.nlu;

import com.sinovoice.hcicloudsdk.api.HciLibPath;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.nlu.NluRecogResult;
import com.sinovoice.hcicloudsdk.common.utils.HciConst;
import com.sinovoice.hcicloudsdk.common.utils.PlatformUtil;
/* loaded from: classes.dex */
public class HciCloudNlu {
    static {
        try {
            if (HciLibPath.getNluLibPath() != null) {
                PlatformUtil.loadLibraryArrayIfExist(HciLibPath.getNluLibPath());
            } else {
                System.loadLibrary("stlport_shared");
                System.loadLibrary(HciConst.Library.SYS.CURL);
                System.loadLibrary(HciConst.Library.SYS.HCI_SYS);
                System.loadLibrary(HciConst.Library.NLU.HCI_NLU);
                System.loadLibrary(HciConst.Library.NLU.HCI_NLU_JNI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PlatformUtil.loadLibraryIfExist(HciConst.Library.NLU.HCI_NLU_CLOUD_RECOG);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.NLU.HCI_NLU_LOCAL_RECOG);
    }

    public static final native int hciNluInit(String str);

    public static final native int hciNluRecog(Session session, String str, String str2, NluRecogResult nluRecogResult);

    public static final native int hciNluRelease();

    public static final native int hciNluSessionStart(String str, Session session);

    public static final native int hciNluSessionStop(Session session);
}
