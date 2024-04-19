package b.b.a.b;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* compiled from: LogConfig.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f149a = "b";

    /* renamed from: b  reason: collision with root package name */
    private final c f150b;
    private final HandlerThread c;
    private Handler d;
    private SimpleDateFormat e;
    private SimpleDateFormat f;
    private File g;
    private String h;
    private File i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogConfig.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                b.this.d();
            } else if (i != 1) {
            } else {
                b.this.k((Bundle) message.obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogConfig.java */
    /* renamed from: b.b.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0012b implements FileFilter {
        C0012b() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().matches("[0-9]{8}");
        }
    }

    /* compiled from: LogConfig.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        String f153a;

        /* renamed from: b  reason: collision with root package name */
        boolean f154b;
        long c;
        int d;

        /* synthetic */ c(a aVar) {
            this();
        }

        public b a() {
            return new b(this, null);
        }

        public c b(int i) {
            this.d = i;
            return this;
        }

        private c() {
            this.f154b = false;
            this.c = 30L;
            this.d = 0;
        }
    }

    /* synthetic */ b(c cVar, a aVar) {
        this(cVar);
    }

    public static c c() {
        return new c(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        File[] listFiles;
        if (TextUtils.isEmpty(this.f150b.f153a)) {
            return;
        }
        File file = new File(this.f150b.f153a);
        if (file.exists()) {
            for (File file2 : file.listFiles(new C0012b())) {
                String name = file2.getName();
                if (h(name) > this.f150b.c) {
                    boolean delete = file2.delete();
                    Log.d(f149a, "log file delete result is " + delete + ", name = " + name);
                }
            }
        }
    }

    private void e() {
        this.d = new a(this.c.getLooper());
    }

    private int h(String str) {
        try {
            return (int) ((System.currentTimeMillis() - this.e.parse(str).getTime()) / 86400000);
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private synchronized void j(long j, String str, String str2, String str3) {
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        obtain.what = 1;
        bundle.putLong("key_time", j);
        bundle.putString("key_level", str);
        bundle.putString("key_tag", str2);
        bundle.putString("key_msg", str3);
        obtain.obj = bundle;
        this.d.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Bundle bundle) {
        PrintWriter printWriter;
        long j = bundle.getLong("key_time");
        String string = bundle.getString("key_level");
        String string2 = bundle.getString("key_msg");
        String string3 = bundle.getString("key_tag");
        if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted")) {
            Log.e(f149a, "SDCard未加载，无法把日志写入文件。");
            return;
        }
        String str = this.f.format(new Date(j)) + ": " + string + "/" + string3 + ": " + string2;
        if (this.g == null) {
            File file = new File(this.f150b.f153a);
            this.g = file;
            if (!file.exists() && !this.g.mkdirs()) {
                Log.e(f149a, "saveLogToFile: create log dir failed");
                return;
            }
        }
        String format = this.e.format(new Date());
        if (!format.equals(this.h)) {
            File file2 = new File(this.f150b.f153a + File.separator + format);
            this.i = file2;
            if (!file2.exists()) {
                try {
                    if (this.i.createNewFile()) {
                        Log.e(f149a, "saveLogToFile: create log file failed");
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.h = format;
        }
        PrintWriter printWriter2 = null;
        try {
            try {
                printWriter = new PrintWriter(new FileWriter(this.i, true));
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            printWriter.println(str);
            printWriter.flush();
            printWriter.close();
        } catch (Exception e3) {
            e = e3;
            printWriter2 = printWriter;
            e.printStackTrace();
            if (printWriter2 != null) {
                printWriter2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                printWriter2.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, String str2) {
        if (this.f150b.d <= 1) {
            Log.d(str, str2);
            if (this.f150b.f154b) {
                j(System.currentTimeMillis(), "D", str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str, String str2) {
        if (this.f150b.d <= 4) {
            Log.e(str, str2);
            if (this.f150b.f154b) {
                j(System.currentTimeMillis(), "E", str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, String str2) {
        if (this.f150b.d <= 2) {
            Log.i(str, str2);
            if (this.f150b.f154b) {
                j(System.currentTimeMillis(), "I", str, str2);
            }
        }
    }

    private b(c cVar) {
        this.e = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        this.f = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
        this.f150b = cVar;
        HandlerThread handlerThread = new HandlerThread("JTLog_thread");
        this.c = handlerThread;
        handlerThread.start();
        e();
    }
}
