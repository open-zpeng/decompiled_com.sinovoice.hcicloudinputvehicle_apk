package com.sinovoice.hcicloudsdk.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
/* loaded from: classes.dex */
public class HttpPostUtil {
    public static final String UTF_8 = "UTF-8";

    /* renamed from: a  reason: collision with root package name */
    private static final String f437a = "HttpPostUtil";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public static final String Post(String str, String str2, Map<String, String> map) {
        InputStream inputStream;
        String str3;
        InputStream inputStream2 = 0;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setDoOutput(true);
                a(httpURLConnection, map);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(str2.getBytes(UTF_8));
                outputStream.close();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        str3 = new String(byteArrayOutputStream.toByteArray(), UTF_8);
                        inputStream2 = inputStream;
                    } catch (IllegalArgumentException unused) {
                        CloudLog.e(f437a, "IllegalArgumentException");
                        a(inputStream);
                        return null;
                    } catch (MalformedURLException unused2) {
                        CloudLog.e(f437a, "MalformedURLException");
                        a(inputStream);
                        return null;
                    } catch (IOException unused3) {
                        CloudLog.e(f437a, "IOException");
                        a(inputStream);
                        return null;
                    }
                } else {
                    str3 = null;
                }
                a(inputStream2);
                return str3;
            } catch (Throwable th) {
                th = th;
                inputStream2 = str;
                a(inputStream2);
                throw th;
            }
        } catch (IOException unused4) {
            inputStream = null;
        } catch (IllegalArgumentException unused5) {
            inputStream = null;
        } catch (MalformedURLException unused6) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            a(inputStream2);
            throw th;
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (httpURLConnection == null || map == null || map.size() == 0) {
            return;
        }
        for (String str : map.keySet()) {
            httpURLConnection.setRequestProperty(str, map.get(str));
        }
    }

    private static final void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static final String Post(String str, String str2) {
        return Post(str, str2, null);
    }
}
