package com.sinovoice.hcicloudsdk.common.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class Md5Util {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f438a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String MD5(String str) {
        return MD5(str, Charset.defaultCharset().name());
    }

    public static String MD5(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                int length = digest.length;
                char[] cArr = new char[length << 1];
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i + 1;
                    char[] cArr2 = f438a;
                    cArr[i] = cArr2[(digest[i2] >>> 4) & 15];
                    i = i3 + 1;
                    cArr[i3] = cArr2[digest[i2] & 15];
                }
                return new String(cArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String MD5(String str, String str2) {
        if (str != null && str.length() != 0) {
            try {
                return MD5(str.getBytes(str2));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
