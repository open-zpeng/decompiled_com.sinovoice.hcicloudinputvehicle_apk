package com.sinovoice.hcicloudsdk.api.tts;

import com.sinovoice.hcicloudsdk.api.HciLibPath;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.tts.ITtsSynthCallback;
import com.sinovoice.hcicloudsdk.common.utils.HciConst;
import com.sinovoice.hcicloudsdk.common.utils.PlatformUtil;
/* loaded from: classes.dex */
public class HciCloudTts {
    static {
        try {
            if (HciLibPath.getTtsLibPath() != null) {
                PlatformUtil.loadLibraryArrayIfExist(HciLibPath.getTtsLibPath());
            } else {
                System.loadLibrary("stlport_shared");
                System.loadLibrary(HciConst.Library.SYS.CURL);
                System.loadLibrary(HciConst.Library.SYS.HCI_SYS);
                System.loadLibrary(HciConst.Library.TTS.HCI_TTS);
                System.loadLibrary(HciConst.Library.TTS.HCI_TTS_JNI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PlatformUtil.loadLibraryIfExist(HciConst.Library.SYS.JTOPUS);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.SYS.JTSPEEX);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.TTS.HCI_TTS_CLOUD_SYNTH);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.TTS.HCI_TTS_LOCAL_SYNTH);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.TTS.HCI_TTS_LOCAL_N4_SYNTH);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.TTS.HCI_TTS_LOCAL_N6_SYNTH);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.TTS.HCI_TTS_LOCAL_N6_V5_SYNTH);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.TTS.HCI_TTS_LOCAL_V6_SYNTH);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.TTS.HCI_TTS_LOCAL_V6_V5_SYNTH);
        PlatformUtil.loadLibraryIfExist(HciConst.Library.TTS.HCI_TTS_LOCAL_V7_SYNTH);
    }

    public static final native int hciTtsInit(String str);

    public static final native int hciTtsRelease();

    public static final native int hciTtsSessionStart(String str, Session session);

    public static final native int hciTtsSessionStop(Session session);

    public static final native int hciTtsSynth(Session session, String str, String str2, ITtsSynthCallback iTtsSynthCallback);

    public static final native int hciTtsSynthEx(Session session, byte[] bArr, String str, ITtsSynthCallback iTtsSynthCallback);
}
