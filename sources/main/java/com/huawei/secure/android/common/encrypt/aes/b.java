package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import d2.g;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35096a = "security:";

    /* renamed from: b, reason: collision with root package name */
    private static final String f35097b = "AES/GCM/NoPadding";

    /* renamed from: c, reason: collision with root package name */
    private static final String f35098c = "AES";

    /* renamed from: d, reason: collision with root package name */
    private static final String f35099d = "GCM";

    /* renamed from: e, reason: collision with root package name */
    private static final String f35100e = "";

    /* renamed from: f, reason: collision with root package name */
    private static final int f35101f = 16;

    /* renamed from: g, reason: collision with root package name */
    private static final int f35102g = 12;

    /* renamed from: h, reason: collision with root package name */
    private static final int f35103h = 2;

    private static byte[] d(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static byte[] f(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 12];
        System.arraycopy(bArr, 12, bArr2, 0, bArr.length - 12);
        return bArr2;
    }

    public static byte[] m(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            g.d(f35099d, "decrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            g.d(f35099d, "decrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            g.d(f35099d, "decrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            g.d(f35099d, "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            g.d(f35099d, "decrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 12) {
            g.d(f35099d, "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!x()) {
            g.d(f35099d, "decrypt 6 build version not higher than 19");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f35098c);
            Cipher cipher = Cipher.getInstance(f35097b);
            cipher.init(2, secretKeySpec, w(bArr3));
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e6) {
            g.d(f35099d, "GCM decrypt data exception: " + e6.getMessage());
            return new byte[0];
        }
    }

    public static byte[] p(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] j6 = a.j(bArr);
        if (j6.length == 0) {
            return new byte[0];
        }
        int a6 = a(j6);
        if (a6 < 0) {
            g.d(f35099d, " gcm cipherText data missing colon");
            return new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(j6, a6);
        int length = (j6.length - copyOf.length) - 1;
        byte[] bArr3 = new byte[length];
        System.arraycopy(j6, a6 + 1, bArr3, 0, length);
        return m(bArr3, bArr2, copyOf);
    }

    public static boolean x() {
        return true;
    }

    private static int a(byte[] bArr) {
        return bArr[12] == 58 ? 12 : -1;
    }

    private static byte[] g(byte[] bArr) {
        byte[] bArr2 = new byte[12];
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        return bArr2;
    }

    public static String o(byte[] bArr, byte[] bArr2) {
        try {
            return new String(p(bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            g.d(f35099d, "UnsupportedEncodingException");
            return "";
        }
    }

    public static byte[] u(byte[] bArr, byte[] bArr2) {
        byte[] d6 = d2.b.d(12);
        return d(d6, v(bArr, bArr2, d6));
    }

    public static byte[] v(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            g.d(f35099d, "encrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            g.d(f35099d, "encrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            g.d(f35099d, "encrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            g.d(f35099d, "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            g.d(f35099d, "encrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 12) {
            g.d(f35099d, "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!x()) {
            g.d(f35099d, "encrypt 6 build version not higher than 19");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f35098c);
            Cipher cipher = Cipher.getInstance(f35097b);
            cipher.init(1, secretKeySpec, w(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e6) {
            g.d(f35099d, "GCM encrypt data error" + e6.getMessage());
            return new byte[0];
        } catch (GeneralSecurityException e7) {
            g.d(f35099d, "GCM encrypt data error" + e7.getMessage());
            return new byte[0];
        }
    }

    public static AlgorithmParameterSpec w(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }

    private b() {
    }

    private static String b(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(24);
        }
        return "";
    }

    private static byte[] c(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35099d, "encrypt 5 content is null");
            return new byte[0];
        }
        if (bArr == null) {
            g.d(f35099d, "encrypt 5 key is null");
            return new byte[0];
        }
        if (bArr.length < 16) {
            g.d(f35099d, "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr2 == null) {
            g.d(f35099d, "encrypt 5 iv is null");
            return new byte[0];
        }
        if (bArr2.length < 12) {
            g.d(f35099d, "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!x()) {
            g.d(f35099d, "encrypt 5 build version not higher than 19");
            return new byte[0];
        }
        try {
            return v(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (UnsupportedEncodingException e6) {
            g.d(f35099d, "GCM encrypt data error" + e6.getMessage());
            return new byte[0];
        }
    }

    private static String e(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        g.d(f35099d, "IV is invalid.");
        return "";
    }

    public static String h(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35099d, "decrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            g.d(f35099d, "decrypt 1 key is null");
            return "";
        }
        if (!x()) {
            g.d(f35099d, "decrypt 1 build version not higher than 19");
            return "";
        }
        byte[] c6 = d2.c.c(str2);
        if (c6.length < 16) {
            g.d(f35099d, "decrypt 1 key error: 1 key length less than 16 bytes.");
            return "";
        }
        return j(str, c6);
    }

    public static String i(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35099d, "decrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            g.d(f35099d, "decrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            g.d(f35099d, "decrypt 3 iv is null");
            return "";
        }
        if (!x()) {
            g.d(f35099d, "decrypt 3 build version not higher than 19");
            return "";
        }
        byte[] c6 = d2.c.c(str2);
        byte[] c7 = d2.c.c(str3);
        if (c6.length < 16) {
            g.d(f35099d, "decrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (c7.length < 12) {
            g.d(f35099d, "decrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return k(str, c6, c7);
    }

    public static String j(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35099d, "decrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            g.d(f35099d, "decrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            g.d(f35099d, "decrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        if (!x()) {
            g.d(f35099d, "decrypt 2 build version not higher than 19");
            return "";
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f35098c);
            Cipher cipher = Cipher.getInstance(f35097b);
            String e6 = e(str);
            String b6 = b(str);
            if (TextUtils.isEmpty(e6)) {
                g.d(f35099d, "decrypt 2 iv is null");
                return "";
            }
            if (TextUtils.isEmpty(b6)) {
                g.d(f35099d, "decrypt 2 encrypt content is null");
                return "";
            }
            cipher.init(2, secretKeySpec, w(d2.c.c(e6)));
            return new String(cipher.doFinal(d2.c.c(b6)), "UTF-8");
        } catch (UnsupportedEncodingException e7) {
            e = e7;
            g.d(f35099d, "GCM decrypt data exception: " + e.getMessage());
            return "";
        } catch (NullPointerException e8) {
            e = e8;
            g.d(f35099d, "GCM decrypt data exception: " + e.getMessage());
            return "";
        } catch (GeneralSecurityException e9) {
            e = e9;
            g.d(f35099d, "GCM decrypt data exception: " + e.getMessage());
            return "";
        }
    }

    public static String k(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35099d, "decrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            g.d(f35099d, "decrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            g.d(f35099d, "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            g.d(f35099d, "decrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 12) {
            g.d(f35099d, "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        if (!x()) {
            g.d(f35099d, "decrypt 4 build version not higher than 19");
            return "";
        }
        try {
            return new String(m(d2.c.c(str), bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException e6) {
            g.d(f35099d, "GCM decrypt data exception: " + e6.getMessage());
            return "";
        }
    }

    public static byte[] l(byte[] bArr, byte[] bArr2) {
        return m(f(bArr), bArr2, g(bArr));
    }

    public static String n(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String h6 = a.h(str);
            if ("".equals(h6)) {
                return "";
            }
            int indexOf = h6.indexOf(58);
            if (indexOf >= 0) {
                return k(d2.c.b(d2.c.c(h6.substring(indexOf + 1))), bArr, d2.c.c(h6.substring(0, indexOf)));
            }
            g.d(f35099d, " gcm cipherText data missing colon");
        }
        return "";
    }

    public static String q(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35099d, "encrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            g.d(f35099d, "encrypt 1 key is null");
            return "";
        }
        if (!x()) {
            g.d(f35099d, "encrypt 1 build version not higher than 19");
            return "";
        }
        byte[] c6 = d2.c.c(str2);
        if (c6.length < 16) {
            g.d(f35099d, "encrypt key error: key length less than 16 bytes.");
            return "";
        }
        return s(str, c6);
    }

    public static String r(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35099d, "encrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            g.d(f35099d, "encrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            g.d(f35099d, "encrypt 3 iv is null");
            return "";
        }
        if (!x()) {
            g.d(f35099d, "encrypt 3 build version not higher than 19");
            return "";
        }
        byte[] c6 = d2.c.c(str2);
        byte[] c7 = d2.c.c(str3);
        if (c6.length < 16) {
            g.d(f35099d, "encrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (c7.length < 12) {
            g.d(f35099d, "encrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return t(str, c6, c7);
    }

    public static String s(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35099d, "encrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            g.d(f35099d, "encrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            g.d(f35099d, "encrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        if (!x()) {
            g.d(f35099d, "encrypt 2 build version not higher than 19");
            return "";
        }
        byte[] d6 = d2.b.d(12);
        byte[] c6 = c(str, bArr, d6);
        if (c6 == null || c6.length == 0) {
            return "";
        }
        return d2.c.b(d6) + d2.c.b(c6);
    }

    public static String t(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35099d, "encrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            g.d(f35099d, "encrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            g.d(f35099d, "encrypt 4 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            g.d(f35099d, "encrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 12) {
            g.d(f35099d, "encrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        if (!x()) {
            g.d(f35099d, "encrypt 4 build version not higher than 19");
            return "";
        }
        return d2.c.b(c(str, bArr, bArr2));
    }
}
