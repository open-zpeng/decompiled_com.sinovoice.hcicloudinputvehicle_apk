package com.sinovoice.hcicloudsdk.api.mt;

import com.sinovoice.hcicloudsdk.api.HciLibPath;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.mt.MtTransResult;
import com.sinovoice.hcicloudsdk.common.utils.HciConst;
import com.sinovoice.hcicloudsdk.common.utils.PlatformUtil;
/* loaded from: classes.dex */
public class HciCloudMt {
    static {
        try {
            if (HciLibPath.getMtLibPath() != null) {
                PlatformUtil.loadLibraryArrayIfExist(HciLibPath.getMtLibPath());
            } else {
                System.loadLibrary("stlport_shared");
                System.loadLibrary(HciConst.Library.SYS.CURL);
                System.loadLibrary(HciConst.Library.SYS.HCI_SYS);
                System.loadLibrary(HciConst.Library.MT.HCI_MT);
                System.loadLibrary(HciConst.Library.MT.HCI_MT_JNI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PlatformUtil.loadLibraryIfExist(HciConst.Library.MT.HCI_MT_CLOUD_TRANS);
    }

    public static final native int hciMtInit(String str);

    public static final native int hciMtRelease();

    public static final native int hciMtSessionStart(String str, Session session);

    public static final native int hciMtSessionStop(Session session);

    public static final native int hciMtTrans(Session session, String str, String str2, MtTransResult mtTransResult);
}
