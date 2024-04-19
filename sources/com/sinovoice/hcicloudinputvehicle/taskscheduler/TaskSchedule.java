package com.sinovoice.hcicloudinputvehicle.taskscheduler;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
public class TaskSchedule {
    private static HandlerThread child;
    private static Handler childHandler;
    private static Handler handler;

    /* loaded from: classes.dex */
    static abstract class SyncRunnable implements Runnable {
        public CountDownLatch mLatch;

        public SyncRunnable(CountDownLatch countDownLatch) {
            this.mLatch = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static void clearTask() {
        Handler handler2 = childHandler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    public static void finish() {
        if (Build.VERSION.SDK_INT >= 18) {
            child.quitSafely();
            child = null;
        }
    }

    public static void init() {
        if (child == null) {
            handler = new Handler(Looper.getMainLooper());
            HandlerThread handlerThread = new HandlerThread("child-thread");
            child = handlerThread;
            handlerThread.start();
            childHandler = new Handler(child.getLooper());
        }
    }

    public static void runOnChildThread(Runnable runnable) {
        Handler handler2 = childHandler;
        if (handler2 != null) {
            handler2.post(runnable);
        }
    }

    public static void runOnChildThreadSync(final Runnable runnable) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Handler handler2 = childHandler;
        if (handler2 != null) {
            handler2.post(new SyncRunnable(countDownLatch) { // from class: com.sinovoice.hcicloudinputvehicle.taskscheduler.TaskSchedule.1
                @Override // com.sinovoice.hcicloudinputvehicle.taskscheduler.TaskSchedule.SyncRunnable, java.lang.Runnable
                public void run() {
                    runnable.run();
                    Log.d("TaskSchedule", "run: runOnChildThreadSync ");
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void runOnMainThread(Runnable runnable) {
        handler.post(runnable);
    }
}
