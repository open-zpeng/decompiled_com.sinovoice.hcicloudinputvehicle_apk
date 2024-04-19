package com.sinovoice.hcicloudsdk.api;

import com.sinovoice.hcicloudsdk.common.utils.HciConst;
import com.sinovoice.hcicloudsdk.common.utils.PlatformUtil;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class HciCloudUser {
    public static final int kHciGroupTypeExclusive = 1;
    public static final int kHciGroupTypeShare = 0;
    public static final int kHciModelSubTypeIndex1 = 1;
    public static final int kHciModelSubTypeIndex10 = 10;
    public static final int kHciModelSubTypeIndex2 = 2;
    public static final int kHciModelSubTypeIndex3 = 3;
    public static final int kHciModelSubTypeIndex4 = 4;
    public static final int kHciModelSubTypeIndex5 = 5;
    public static final int kHciModelSubTypeIndex6 = 6;
    public static final int kHciModelSubTypeIndex7 = 7;
    public static final int kHciModelSubTypeIndex8 = 8;
    public static final int kHciModelSubTypeIndex9 = 9;
    public static final int kHciModelSubTypeUnknown = 0;
    public static final int kHciModelTypeAfr = 3;
    public static final int kHciModelTypeFpr = 2;
    public static final int kHciModelTypeVpr = 1;

    static {
        try {
            if (HciLibPath.getSysLibPath() != null) {
                PlatformUtil.loadLibraryArrayIfExist(HciLibPath.getSysLibPath());
                return;
            }
            System.loadLibrary(HciConst.Library.SYS.CURL);
            System.loadLibrary(HciConst.Library.SYS.HCI_SYS);
            System.loadLibrary(HciConst.Library.SYS.HCI_SYS_JNI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final native int hciAddUser(String str, String str2);

    public static final native int hciCreateGroup(String str, int i);

    public static final native int hciDeleteGroup(String str);

    public static final native int hciDeleteModel(String str, int i, int i2);

    public static final native int hciDeleteUser(String str);

    public static final native int hciGetGrouplist(ArrayList<String> arrayList);

    public static final native int hciGetUserlist(String str, ArrayList<String> arrayList);

    public static final native int hciRemoveUser(String str, String str2);

    public static final native int hciSetCurrentUser(String str);
}
