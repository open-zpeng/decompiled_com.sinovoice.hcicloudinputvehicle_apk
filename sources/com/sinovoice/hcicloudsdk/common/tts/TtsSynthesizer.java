package com.sinovoice.hcicloudsdk.common.tts;

import com.sinovoice.hcicloudsdk.api.tts.HciCloudTts;
import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.ThreadPool;
import com.sinovoice.hcicloudsdk.common.utils.CloudLog;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public final class TtsSynthesizer {

    /* renamed from: a  reason: collision with root package name */
    private static final String f429a = "TtsSynthesizer";

    /* renamed from: b  reason: collision with root package name */
    private boolean f430b = false;
    private final ReentrantLock c;
    private final Condition d;
    private final ITtsSynthHandler e;
    private long f;

    public TtsSynthesizer(ITtsSynthHandler iTtsSynthHandler) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.c = reentrantLock;
        this.d = reentrantLock.newCondition();
        this.f = 0L;
        this.e = iTtsSynthHandler;
    }

    public final boolean isRunning() {
        return this.f > 0;
    }

    public final void start(final String str, final String str2) {
        ThreadPool.pool.submit(new Runnable() { // from class: com.sinovoice.hcicloudsdk.common.tts.TtsSynthesizer.1
            @Override // java.lang.Runnable
            public final void run() {
                TtsSynthesizer.this.c.lock();
                TtsSynthesizer.this.f = Thread.currentThread().getId();
                TtsSynthesizer.this.d.signalAll();
                TtsSynthesizer.this.c.unlock();
                try {
                    TtsSynthesizer.this.e.onSynthStart();
                    CloudLog.i(TtsSynthesizer.f429a, "synth thread started");
                    Session session = new Session();
                    int hciTtsSessionStart = HciCloudTts.hciTtsSessionStart(str2, session);
                    if (hciTtsSessionStart != 0) {
                        TtsSynthesizer.this.e.onSynthError(hciTtsSessionStart);
                        String str3 = TtsSynthesizer.f429a;
                        CloudLog.e(str3, "synth thread start session error: " + hciTtsSessionStart);
                    } else {
                        int hciTtsSynth = HciCloudTts.hciTtsSynth(session, str, str2, new ITtsSynthCallback() { // from class: com.sinovoice.hcicloudsdk.common.tts.TtsSynthesizer.1.1
                            @Override // com.sinovoice.hcicloudsdk.common.tts.ITtsSynthCallback
                            public final boolean onSynthFinish(int i, TtsSynthResult ttsSynthResult) {
                                if (TtsSynthesizer.this.f430b) {
                                    return false;
                                }
                                String str4 = TtsSynthesizer.f429a;
                                CloudLog.i(str4, "onSynthFinish: " + i);
                                if (i != 0) {
                                    TtsSynthesizer.this.e.onSynthError(i);
                                    return false;
                                }
                                if (ttsSynthResult.getSentence() != null) {
                                    TtsSynthesizer.this.e.onSynthSyllables(ttsSynthResult.getSentence(), ttsSynthResult.getTtsSyllables());
                                }
                                byte[] voiceData = ttsSynthResult.getVoiceData();
                                if (voiceData != null && voiceData.length > 0) {
                                    TtsSynthesizer.this.e.onSynthAudioData(voiceData);
                                }
                                if (ttsSynthResult.isHasMoreData()) {
                                    CloudLog.i(TtsSynthesizer.f429a, "onSynthFinish() end");
                                    return !TtsSynthesizer.this.f430b;
                                }
                                return false;
                            }
                        });
                        String str4 = TtsSynthesizer.f429a;
                        CloudLog.i(str4, "HciCloudTts.hciTtsSynth = " + hciTtsSynth);
                        int hciTtsSessionStop = HciCloudTts.hciTtsSessionStop(session);
                        String str5 = TtsSynthesizer.f429a;
                        CloudLog.i(str5, "HciCloudTts.hciTtsSessionStop = " + hciTtsSessionStop);
                        TtsSynthesizer.this.e.onSynthFinish(TtsSynthesizer.this.f430b);
                    }
                } finally {
                    TtsSynthesizer.this.c.lock();
                    TtsSynthesizer.this.f = 0L;
                    TtsSynthesizer.this.d.signalAll();
                    TtsSynthesizer.this.c.unlock();
                }
            }
        });
        this.c.lock();
        if (this.f <= 0) {
            try {
                this.d.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.c.unlock();
    }

    public final void stop() {
        this.c.lock();
        if (this.f > 0) {
            if (!this.f430b) {
                this.f430b = true;
            }
            if (Thread.currentThread().getId() != this.f) {
                try {
                    this.d.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        this.c.unlock();
    }
}
