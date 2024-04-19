package com.sinovoice.hcicloudsdk.api.asr;

import com.sinovoice.hcicloudsdk.api.HciLibPath;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.asr.AsrGrammarId;
import com.sinovoice.hcicloudsdk.common.asr.AsrRecogResult;
import com.sinovoice.hcicloudsdk.common.utils.HciConst;
import com.sinovoice.hcicloudsdk.common.utils.PlatformUtil;
/* loaded from: classes.dex */
public class HciCloudAsr {
    static {
        try {
            if (HciLibPath.getAsrLibPath() != null) {
                PlatformUtil.loadLibraryArrayIfExist(HciLibPath.getAsrLibPath());
            } else {
                System.loadLibrary("stlport_shared");
                System.loadLibrary(HciConst.Library.SYS.CURL);
                System.loadLibrary(HciConst.Library.SYS.HCI_SYS);
                System.loadLibrary(HciConst.Library.ASR.HCI_ASR);
                System.loadLibrary(HciConst.Library.ASR.HCI_ASR_JNI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PlatformUtil.loadLibraryIfExist(HciConst.Library.SYS.JTOPUS);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.SYS.JTSPEEX);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.ASR.HCI_ASR_CLOUD_RECOG);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.ASR.ISPEAKDNNLITE);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.ASR.ISPEAKGRMDNNLITE);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.ASR.HCI_ASR_LOCAL_RECOG);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.ASR.HCI_ASR_LOCAL_V4_RECOG);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.ASR.HCI_ASR_LOCAL_FT_RECOG);
    }

    public static final native int hciAsrConfirm(Session session, String str);

    public static final native int hciAsrInit(String str);

    public static final native int hciAsrLoadGrammar(String str, String str2, AsrGrammarId asrGrammarId);

    public static final native int hciAsrRecog(Session session, byte[] bArr, String str, String str2, AsrRecogResult asrRecogResult);

    public static final native int hciAsrRelease();

    public static final native int hciAsrSaveCompiledGrammar(AsrGrammarId asrGrammarId, String str);

    public static final native int hciAsrSessionStart(String str, Session session);

    public static final native int hciAsrSessionStop(Session session);

    public static final native int hciAsrUnloadGrammar(AsrGrammarId asrGrammarId);
}
