package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import d2.g;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35089a = "security:";

    /* renamed from: b, reason: collision with root package name */
    private static final String f35090b = "AES/CBC/PKCS5Padding";

    /* renamed from: c, reason: collision with root package name */
    private static final String f35091c = "AES";

    /* renamed from: d, reason: collision with root package name */
    private static final String f35092d = "CBC";

    /* renamed from: e, reason: collision with root package name */
    private static final String f35093e = "";

    /* renamed from: f, reason: collision with root package name */
    private static final int f35094f = 16;

    /* renamed from: g, reason: collision with root package name */
    private static final int f35095g = 16;

    private static byte[] e(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static byte[] g(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 16];
        System.arraycopy(bArr, 16, bArr2, 0, bArr.length - 16);
        return bArr2;
    }

    public static byte[] p(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            g.d(f35092d, "decrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            g.d(f35092d, "decrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            g.d(f35092d, "decrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            g.d(f35092d, "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            g.d(f35092d, "decrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            g.d(f35092d, "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f35091c);
        try {
            Cipher cipher = Cipher.getInstance(f35090b);
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e6) {
            g.d(f35092d, "NullPointerException: " + e6.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e7) {
            g.d(f35092d, "InvalidAlgorithmParameterException: " + e7.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e8) {
            g.d(f35092d, "InvalidKeyException: " + e8.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e9) {
            g.d(f35092d, "NoSuchAlgorithmException: " + e9.getMessage());
            return new byte[0];
        } catch (BadPaddingException e10) {
            g.d(f35092d, "BadPaddingException: " + e10.getMessage());
            g.d(f35092d, "key is not right");
            return new byte[0];
        } catch (IllegalBlockSizeException e11) {
            g.d(f35092d, "IllegalBlockSizeException: " + e11.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e12) {
            g.d(f35092d, "NoSuchPaddingException: " + e12.getMessage());
            return new byte[0];
        }
    }

    public static byte[] s(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] j6 = j(bArr);
        if (j6.length == 0) {
            return new byte[0];
        }
        int a6 = a(j6);
        if (a6 < 0) {
            g.d(f35092d, " cbc cipherText data missing colon");
            return new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(j6, a6);
        int length = (j6.length - copyOf.length) - 1;
        byte[] bArr3 = new byte[length];
        System.arraycopy(j6, a6 + 1, bArr3, 0, length);
        return p(bArr3, bArr2, copyOf);
    }

    public static byte[] y(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            g.d(f35092d, "encrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            g.d(f35092d, "encrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            g.d(f35092d, "encrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            g.d(f35092d, "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            g.d(f35092d, "encrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            g.d(f35092d, "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f35091c);
        try {
            Cipher cipher = Cipher.getInstance(f35090b);
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e6) {
            g.d(f35092d, "NullPointerException: " + e6.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e7) {
            g.d(f35092d, "InvalidAlgorithmParameterException: " + e7.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e8) {
            g.d(f35092d, "InvalidKeyException: " + e8.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e9) {
            g.d(f35092d, "NoSuchAlgorithmException: " + e9.getMessage());
            return new byte[0];
        } catch (BadPaddingException e10) {
            g.d(f35092d, "BadPaddingException: " + e10.getMessage());
            return new byte[0];
        } catch (IllegalBlockSizeException e11) {
            g.d(f35092d, "IllegalBlockSizeException: " + e11.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e12) {
            g.d(f35092d, "NoSuchPaddingException: " + e12.getMessage());
            return new byte[0];
        }
    }

    private static int a(byte[] bArr) {
        return bArr[16] == 58 ? 16 : -1;
    }

    private static byte[] i(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        return bArr2;
    }

    static byte[] j(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e6) {
            g.d(f35092d, "stripCryptHead: exception : " + e6.getMessage());
            str = "";
        }
        if (!str.startsWith(f35089a)) {
            return new byte[0];
        }
        if (bArr.length <= 9) {
            return new byte[0];
        }
        int length = bArr.length - 9;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 9, bArr2, 0, length);
        return bArr2;
    }

    public static String r(byte[] bArr, byte[] bArr2) {
        try {
            return new String(s(bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            g.d(f35092d, "decryptWithCryptHead UnsupportedEncodingException ");
            return "";
        }
    }

    public static byte[] x(byte[] bArr, byte[] bArr2) {
        byte[] d6 = d2.b.d(16);
        return e(d6, y(bArr, bArr2, d6));
    }

    private a() {
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (Exception e6) {
            g.d(f35092d, "get encryptword exception : " + e6.getMessage());
            return "";
        }
    }

    private static String c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (Exception e6) {
                g.d(f35092d, "mix exception: " + e6.getMessage());
            }
        }
        return "";
    }

    private static byte[] d(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35092d, "encrypt 5 content is null");
            return new byte[0];
        }
        if (bArr == null) {
            g.d(f35092d, "encrypt 5 key is null");
            return new byte[0];
        }
        if (bArr.length < 16) {
            g.d(f35092d, "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr2 == null) {
            g.d(f35092d, "encrypt 5 iv is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            g.d(f35092d, "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        }
        try {
            return y(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (UnsupportedEncodingException e6) {
            g.d(f35092d, " cbc encrypt data error" + e6.getMessage());
            return new byte[0];
        }
    }

    private static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (Exception e6) {
            g.d(f35092d, "getIv exception : " + e6.getMessage());
            return "";
        }
    }

    static String h(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf(f35089a) == -1) {
            return "";
        }
        return str.substring(9);
    }

    public static String k(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35092d, "decrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            g.d(f35092d, "decrypt 1 key is null");
            return "";
        }
        byte[] c6 = d2.c.c(str2);
        if (c6.length < 16) {
            g.d(f35092d, "decrypt 1 key error: 1 key length less than 16 bytes.");
            return "";
        }
        return m(str, c6);
    }

    public static String l(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35092d, "decrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            g.d(f35092d, "decrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            g.d(f35092d, "decrypt 3 iv is null");
            return "";
        }
        byte[] c6 = d2.c.c(str2);
        byte[] c7 = d2.c.c(str3);
        if (c6.length < 16) {
            g.d(f35092d, "decrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (c7.length < 16) {
            g.d(f35092d, "decrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return n(str, c6, c7);
    }

    public static String m(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35092d, "decrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            g.d(f35092d, "decrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            g.d(f35092d, "decrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        String f6 = f(str);
        String b6 = b(str);
        if (TextUtils.isEmpty(f6)) {
            g.d(f35092d, "decrypt 2 iv is null");
            return "";
        }
        if (TextUtils.isEmpty(b6)) {
            g.d(f35092d, "decrypt 2 encrypt content is null");
            return "";
        }
        return n(b6, bArr, d2.c.c(f6));
    }

    public static String n(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35092d, "decrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            g.d(f35092d, "decrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            g.d(f35092d, "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            g.d(f35092d, "decrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 16) {
            g.d(f35092d, "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        try {
            return new String(p(d2.c.c(str), bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException e6) {
            g.d(f35092d, " cbc decrypt data error" + e6.getMessage());
            return "";
        }
    }

    public static byte[] o(byte[] bArr, byte[] bArr2) {
        return p(g(bArr), bArr2, i(bArr));
    }

    public static String q(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String h6 = h(str);
            if ("".equals(h6)) {
                return "";
            }
            int indexOf = h6.indexOf(58);
            if (indexOf >= 0) {
                return n(d2.c.b(d2.c.c(h6.substring(indexOf + 1))), bArr, d2.c.c(h6.substring(0, indexOf)));
            }
            g.d(f35092d, " cbc cipherText data missing colon");
        }
        return "";
    }

    public static String t(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35092d, "encrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            g.d(f35092d, "encrypt 1 key is null");
            return "";
        }
        byte[] c6 = d2.c.c(str2);
        if (c6.length < 16) {
            g.d(f35092d, "encrypt 1 key error: 1 key length less than 16 bytes.");
            return "";
        }
        return v(str, c6);
    }

    public static String u(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35092d, "encrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            g.d(f35092d, "encrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            g.d(f35092d, "encrypt 3 iv is null");
            return "";
        }
        byte[] c6 = d2.c.c(str2);
        byte[] c7 = d2.c.c(str3);
        if (c6.length < 16) {
            g.d(f35092d, "encrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (c7.length < 16) {
            g.d(f35092d, "encrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return w(str, c6, c7);
    }

    public static String v(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35092d, "encrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            g.d(f35092d, "encrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            g.d(f35092d, "encrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        byte[] d6 = d2.b.d(16);
        byte[] d7 = d(str, bArr, d6);
        if (d7 == null || d7.length == 0) {
            return "";
        }
        return c(d2.c.b(d6), d2.c.b(d7));
    }

    public static String w(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f35092d, "encrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            g.d(f35092d, "encrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            g.d(f35092d, "encrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            g.d(f35092d, "encrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 16) {
            g.d(f35092d, "encrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        return d2.c.b(d(str, bArr, bArr2));
    }
}
