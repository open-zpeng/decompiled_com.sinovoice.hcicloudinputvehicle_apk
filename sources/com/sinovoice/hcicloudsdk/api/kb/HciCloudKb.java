package com.sinovoice.hcicloudsdk.api.kb;

import com.sinovoice.hcicloudsdk.api.HciLibPath;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.kb.KbConvResult;
import com.sinovoice.hcicloudsdk.common.kb.KbFuzzySyllable;
import com.sinovoice.hcicloudsdk.common.kb.KbQueryInfo;
import com.sinovoice.hcicloudsdk.common.kb.KbRecogResult;
import com.sinovoice.hcicloudsdk.common.kb.KbUdbItemInfo;
import com.sinovoice.hcicloudsdk.common.kb.KbUdbIterateCallback;
import com.sinovoice.hcicloudsdk.common.utils.HciConst;
import com.sinovoice.hcicloudsdk.common.utils.PlatformUtil;
/* loaded from: classes.dex */
public class HciCloudKb {
    public static final String HCI_KB_FILE_FLAG_ANDROID_SO = "android_so";
    public static final String HCI_KB_FILE_FLAG_NONE = "none";
    public static final String KB_CONFIG_RECOG_CONV_MODE = "convmode";
    public static final String KB_CONFIG_RECOG_FAULT_TOLERANT_LEVEL = "faultTolerantLevel";
    public static final String KB_CONFIG_RECOG_INPUT_MODE = "inputmode";
    public static final String KB_CONFIG_RECOG_INPUT_TYPE = "inputtype";
    public static final String KB_CONFIG_RECOG_INPUT_TYPE_PRESS = "press";
    public static final String KB_CONFIG_RECOG_INPUT_TYPE_SLIDE = "slide";
    public static final String KB_CONFIG_RECOG_KEY_BOARD = "keyboard";
    public static final String KB_CONFIG_RECOG_PAGE_COUNT = "pagecount";
    public static final String KB_PROPERTY_RECOG_ENTRY_MODE = "entrymode";
    public static final String KB_PROPERTY_RECOG_LANG = "lang";

    static {
        try {
            if (HciLibPath.getKbLibPath() != null) {
                PlatformUtil.loadLibraryArrayIfExist(HciLibPath.getKbLibPath());
            } else {
                System.loadLibrary("stlport_shared");
                System.loadLibrary(HciConst.Library.SYS.CURL);
                System.loadLibrary(HciConst.Library.SYS.HCI_SYS);
                System.loadLibrary(HciConst.Library.KB.HCI_KB);
                System.loadLibrary(HciConst.Library.KB.HCI_KB_JNI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PlatformUtil.loadLibraryIfExist(HciConst.Library.KB.HCI_KB_LOCAL_RECOG);
    }

    public static final native int hciKbConfirm(Session session, String str);

    public static final native int hciKbConv(Session session, String str, String str2, KbConvResult kbConvResult);

    public static final native int hciKbFuzzySyllable(Session session, KbFuzzySyllable[] kbFuzzySyllableArr);

    public static final native int hciKbInit(String str);

    public static final native int hciKbRecog(Session session, String str, KbQueryInfo kbQueryInfo, KbRecogResult kbRecogResult);

    public static final native int hciKbRelease();

    public static final native int hciKbSessionStart(String str, Session session);

    public static final native int hciKbSessionStop(Session session);

    public static final native int hciKbUdbCommit(Session session, String str, KbUdbItemInfo kbUdbItemInfo);

    public static final native int hciKbUdbDelete(Session session, String str, KbUdbItemInfo kbUdbItemInfo);

    public static final native int hciKbUdbIterate(Session session, KbUdbIterateCallback kbUdbIterateCallback);
}
