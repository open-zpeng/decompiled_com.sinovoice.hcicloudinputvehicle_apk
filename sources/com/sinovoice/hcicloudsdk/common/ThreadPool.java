package com.sinovoice.hcicloudsdk.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class ThreadPool {
    public static final ExecutorService pool = Executors.newCachedThreadPool();
}
