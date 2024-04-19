package com.sinovoice.hcicloudsdk.common.asr;

import com.sinovoice.hcicloudsdk.common.Session;
import com.sinovoice.hcicloudsdk.common.tts.TtsConfig;
import java.util.HashMap;
import java.util.Objects;
/* loaded from: classes.dex */
public abstract class AsrCommon {
    public static final int DIALOG = 2;
    public static final int FREETALK = 0;
    public static final int GRAMMAR = 1;
    public static final int NO = 0;
    public static final int RT = 2;
    public static final int YES = 1;
    private static final String c = "AsrCommon";

    /* renamed from: a  reason: collision with root package name */
    protected final IAsrHandler f342a;
    private int g;
    private int h;
    private int i;

    /* renamed from: b  reason: collision with root package name */
    protected String f343b = null;
    private IAsrAudioSource d = null;
    private String e = null;
    private boolean f = false;
    private Thread j = null;
    private HashMap<String, String> k = null;

    public AsrCommon(IAsrHandler iAsrHandler) {
        this.f342a = iAsrHandler;
    }

    private int b(Session session) {
        int a2;
        byte[] bArr = new byte[320000];
        int i = (((this.g / 8) * this.h) * 200) / 1000;
        a();
        do {
            boolean z = this.f;
            if (z) {
                if (z) {
                    return 1;
                }
                throw new RuntimeException("上面的 while 中不要用 break");
            }
            a2 = a(bArr, i);
            if (a2 < 0) {
                this.f342a.onError(this, "readAudioData", a2);
                return 2;
            } else if (this.f) {
                return 1;
            } else {
                if (a2 > 0) {
                    int a3 = a(session, bArr, a2);
                    if (a3 == 3) {
                        return a3;
                    }
                    if (a3 == 4) {
                        this.f342a.onVoiceEnd(this);
                        int a4 = a(session);
                        if (a4 != 0) {
                            return a4;
                        }
                        return 4;
                    } else if (a3 != 0) {
                        return a3;
                    }
                }
            }
        } while (a2 >= i);
        int a5 = a(session);
        if (a5 != 0) {
            return a5;
        }
        return 0;
    }

    public static HashMap<String, String> parseConfig(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : str.split(",")) {
            String trim = str2.trim();
            if (!trim.isEmpty()) {
                String[] split = trim.split("=", 2);
                if (split.length >= 2 && !split[0].isEmpty() && !split[1].isEmpty()) {
                    hashMap.put(split[0].toLowerCase(), split[1]);
                }
            }
        }
        return hashMap;
    }

    protected abstract int a();

    protected abstract int a(Session session);

    protected abstract int a(Session session, byte[] bArr);

    protected abstract int a(Session session, byte[] bArr, int i);

    public boolean cancel() {
        synchronized (this) {
            Thread thread = this.j;
            if (thread == null) {
                return true;
            }
            this.f = true;
            if (thread.getId() == Thread.currentThread().getId()) {
                return false;
            }
            while (true) {
                try {
                    thread.join();
                    return true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void cancelAsync() {
        if (this.j != null && !this.f) {
            this.f = true;
        }
    }

    public void start(IAsrAudioSource iAsrAudioSource, String str, String str2) {
        synchronized (this) {
            if (this.j == null) {
                a(str);
                this.j = Thread.currentThread();
                this.e = str2;
                this.f343b = str;
                this.d = iAsrAudioSource;
            } else {
                throw new IllegalStateException();
            }
        }
        b();
    }

    public void startAsync(IAsrAudioSource iAsrAudioSource, String str, String str2) {
        Thread thread;
        Objects.requireNonNull(str, "config");
        synchronized (this) {
            if (this.j == null) {
                a(str);
                this.e = str2;
                this.f343b = str;
                this.d = iAsrAudioSource;
                thread = new Thread(new Runnable() { // from class: com.sinovoice.hcicloudsdk.common.asr.AsrCommon.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AsrCommon.this.b();
                    }
                });
                this.j = thread;
            } else {
                throw new IllegalStateException();
            }
        }
        thread.start();
    }

    private int a(byte[] bArr, int i) {
        if (i <= bArr.length) {
            int i2 = 0;
            while (i2 < i && !this.f) {
                int read = this.d.read(bArr, i2, bArr.length - i2);
                if (read < 0) {
                    return read;
                }
                if (read == 0) {
                    return i2;
                }
                i2 += read;
            }
            return i2;
        }
        throw new IllegalArgumentException();
    }

    private void a(String str) {
        HashMap<String, String> parseConfig = parseConfig(str);
        this.k = parseConfig;
        String str2 = parseConfig.get("capkey");
        if (str2 != null) {
            if (!str2.startsWith("asr.local.") && !str2.startsWith("asr.cloud.")) {
                throw new IllegalArgumentException("invalid config.capkey");
            }
            String substring = str2.substring(10);
            if (!substring.equals("freetalk") && !substring.startsWith("freetalk.") && !substring.equals("grammar") && !substring.startsWith("grammar.") && !substring.equals("dialog") && !substring.startsWith("dialog.")) {
                throw new IllegalArgumentException("invalid config.capkey");
            }
            String str3 = this.k.get("realtime");
            if (str3 != null && !str3.equals("no")) {
                if (str3.equals("yes")) {
                    this.i = 1;
                } else if (str3.equals("rt")) {
                    this.i = 2;
                } else {
                    throw new IllegalArgumentException("invalid config.realtime");
                }
            } else {
                this.i = 0;
            }
            String str4 = this.k.get("audioFormat");
            if (str4 != null && !str4.equals("") && !str4.equals("pcm16k16bit")) {
                if (str4.equals(TtsConfig.BasicConfig.VALUE_OF_PARAM_AUDIO_FORMAT_PCM_16K8BIT)) {
                    this.g = 8;
                    this.h = 16000;
                    return;
                } else if (str4.equals("pcm8k16bit")) {
                    this.g = 16;
                    this.h = 8000;
                    return;
                } else if (str4.equals(TtsConfig.BasicConfig.VALUE_OF_PARAM_AUDIO_FORMAT_PCM_8K8BIT)) {
                    this.g = 8;
                    this.h = 8000;
                    return;
                } else if (str4.equals(TtsConfig.BasicConfig.VALUE_OF_PARAM_AUDIO_FORMAT_PCM_11K16BIT)) {
                    this.g = 16;
                    this.h = 11025;
                    return;
                } else if (str4.equals(TtsConfig.BasicConfig.VALUE_OF_PARAM_AUDIO_FORMAT_PCM_11K8BIT)) {
                    this.g = 8;
                    this.h = 11025;
                    return;
                } else if (str4.equals("pcm22k16bit")) {
                    this.g = 16;
                    this.h = 22050;
                    return;
                } else if (str4.equals("pcm22k8bit")) {
                    this.g = 8;
                    this.h = 22050;
                    return;
                } else if (str4.equals("pcm44k16bit")) {
                    this.g = 16;
                    this.h = 44100;
                    return;
                } else if (str4.equals("pcm44k8bit")) {
                    this.g = 8;
                    this.h = 44100;
                    return;
                } else {
                    throw new IllegalArgumentException("audioFormat");
                }
            }
            this.g = 16;
            this.h = 16000;
            return;
        }
        throw new IllegalArgumentException("missing config.capkey");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r1 != 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
        r11.f342a.onError(r11, "ASR 能力反初始化", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
        if (r1 != 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sinovoice.hcicloudsdk.common.asr.AsrCommon.b():void");
    }
}
