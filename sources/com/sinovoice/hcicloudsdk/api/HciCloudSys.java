package com.sinovoice.hcicloudsdk.api;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import com.sinovoice.hcicloudsdk.common.AuthExpireTime;
import com.sinovoice.hcicloudsdk.common.CapabilityResult;
import com.sinovoice.hcicloudsdk.common.InitParam;
import com.sinovoice.hcicloudsdk.common.NetworkChangeReceiver;
import com.sinovoice.hcicloudsdk.common.utils.CloudLog;
import com.sinovoice.hcicloudsdk.common.utils.HciConst;
import com.sinovoice.hcicloudsdk.common.utils.PlatformUtil;
import com.sinovoice.hcicloudsdk.push.CrashUncaughtExceptionHandler;
import java.net.InetAddress;
/* loaded from: classes.dex */
public class HciCloudSys {

    /* renamed from: a  reason: collision with root package name */
    private static final String f311a = "HciCloudSys";

    /* renamed from: b  reason: collision with root package name */
    private static Context f312b;
    private static CrashUncaughtExceptionHandler c;

    static {
        try {
            if (HciLibPath.getSysLibPath() != null) {
                PlatformUtil.loadLibraryArrayIfExist(HciLibPath.getSysLibPath());
                return;
            }
            System.loadLibrary("stlport_shared");
            System.loadLibrary(HciConst.Library.SYS.CURL);
            System.loadLibrary(HciConst.Library.SYS.HCI_SYS);
            System.loadLibrary(HciConst.Library.SYS.HCI_SYS_JNI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDnsServers() {
        if (Build.VERSION.SDK_INT <= 25) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) f312b.getApplicationContext().getSystemService("connectivity");
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                CloudLog.e(f311a, "Network not connected!");
                return null;
            }
            String str = "";
            for (InetAddress inetAddress : connectivityManager.getLinkProperties(activeNetwork).getDnsServers()) {
                str = str + inetAddress.getHostAddress() + ",";
            }
            if (str.isEmpty()) {
                return null;
            }
            return str.substring(0, str.length() - 1);
        } catch (Exception e) {
            CloudLog.e(f311a, "getDnsServers got exception: " + e.getMessage());
            return null;
        }
    }

    public static final int hciCheckAuth() {
        return hciCheckAuthInternal();
    }

    static final native int hciCheckAuthInternal();

    public static final native int hciGetAuthExpireTime(AuthExpireTime authExpireTime);

    public static final native int hciGetCapabilityList(String str, CapabilityResult capabilityResult);

    public static final native String hciGetErrorInfo(int i);

    public static final native String hciGetSdkVersion();

    public static final int hciInit(String str, Object obj) {
        int hciInitInternal;
        Context context = (Context) obj;
        f312b = context;
        if (PlatformUtil.isAndroid()) {
            if (Build.VERSION.SDK_INT >= 25) {
                NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(networkChangeReceiver, intentFilter);
            }
            InitParam initParam = new InitParam();
            initParam.parseStringConfig(str);
            initParam.addParam("autoupload", "no");
            hciInitInternal = hciInitInternal(initParam.getStringConfig(), obj);
        } else {
            hciInitInternal = hciInitInternal(str, obj);
        }
        if (c == null) {
            CrashUncaughtExceptionHandler crashUncaughtExceptionHandler = new CrashUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
            c = crashUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(crashUncaughtExceptionHandler);
        }
        return hciInitInternal;
    }

    static final native int hciInitInternal(String str, Object obj);

    public static final int hciRelease() {
        return hciReleaseInternal();
    }

    static final native int hciReleaseInternal();

    public static final native int hciUploadUserHistory();
}
