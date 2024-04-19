package com.sinovoice.hcicloudsdk.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
/* loaded from: classes.dex */
public class PlatformUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f439a = "PlatformUtil";

    /* loaded from: classes.dex */
    public static final class DeviceNetWorkState {
        public static final int NET_INFO_AVAILABLE_MOBILE = 2;
        public static final int NET_INFO_AVAILABLE_WIFI = 1;
        public static final int NET_INFO_INAVAILABLE = 0;
    }

    public static int getNetWorkState(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return 0;
        }
        if (activeNetworkInfo.getType() == 1 && activeNetworkInfo.isConnected()) {
            return 1;
        }
        return (activeNetworkInfo.getType() == 0 && activeNetworkInfo.isConnected()) ? 2 : 0;
    }

    public static int getSDKVersionNumber() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static boolean isAndroid() {
        try {
            return Build.VERSION.SDK_INT > 0;
        } catch (Error unused) {
            return false;
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static void loadLibraryArrayIfExist(String[] strArr) {
        for (String str : strArr) {
            try {
                System.load(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void loadLibraryIfExist(String str) {
        try {
            System.loadLibrary(str);
        } catch (Throwable unused) {
            String str2 = f439a;
            CloudLog.w(str2, str + " library not exist");
        }
    }

    public static String randomString() {
        return Md5Util.MD5(Long.toString(System.currentTimeMillis()));
    }
}
