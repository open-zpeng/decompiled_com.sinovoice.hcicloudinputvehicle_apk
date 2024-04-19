package com.sinovoice.hcicloudsdk.push;

import com.sinovoice.hcicloudsdk.common.utils.CloudLog;
import com.sinovoice.hcicloudsdk.common.utils.HttpPostUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
/* loaded from: classes.dex */
public class CrashUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f455a;

    public CrashUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f455a = uncaughtExceptionHandler;
    }

    public static void onNativeCrashed() {
        CloudLog.e("CRASH MESSAGE", "onNativeCrashed");
        try {
            StringWriter stringWriter = new StringWriter();
            new RuntimeException("crashed here (native trace should follow after the Java trace)").printStackTrace(new PrintWriter(stringWriter));
            InnerInterface.hciAppendUserHisItem(stringWriter.toString().getBytes(HttpPostUtil.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CloudLog.e("CRASH MESSAGE", "onNativeCrashedEnd");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            InnerInterface.hciAppendUserHisItem(stringWriter.toString().getBytes(HttpPostUtil.UTF_8));
            CloudLog.e("CRASH MESSAGE", "uncaughtException");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f455a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        th.printStackTrace(System.err);
        System.exit(0);
    }
}
