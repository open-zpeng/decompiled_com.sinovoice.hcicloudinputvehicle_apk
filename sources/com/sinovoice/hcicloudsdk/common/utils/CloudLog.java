package com.sinovoice.hcicloudsdk.common.utils;

import java.io.PrintStream;
/* loaded from: classes.dex */
public class CloudLog {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f434a = false;

    public static void d(String str, String str2) {
        hLog(a.e, str, str2);
        if (f434a) {
            PrintStream printStream = System.out;
            printStream.println("Debug: [" + str + "] " + str2);
        }
    }

    @Deprecated
    public static void debugMode() {
        f434a = true;
    }

    public static void e(String str, String str2) {
        hLog(a.f442a, str, str2);
        if (f434a) {
            PrintStream printStream = System.out;
            printStream.println("Error: [" + str + "] " + str2);
        }
    }

    public static void hLog(int i, String str, String str2) {
        try {
            hciLog(i, str, "", str2);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public static final native void hciLog(int i, String str, String str2, String str3);

    public static void i(String str, String str2) {
        hLog(a.c, str, str2);
        if (f434a) {
            PrintStream printStream = System.out;
            printStream.println("Infomation: [" + str + "] " + str2);
        }
    }

    public static void t(String str, String str2) {
    }

    public static void v(String str, String str2) {
        hLog(a.d, str, str2);
        if (f434a) {
            PrintStream printStream = System.out;
            printStream.println("Verbose: [" + str + "] " + str2);
        }
    }

    public static void w(String str, String str2) {
        hLog(a.f443b, str, str2);
        if (f434a) {
            PrintStream printStream = System.out;
            printStream.println("Warning: [" + str + "] " + str2);
        }
    }
}
