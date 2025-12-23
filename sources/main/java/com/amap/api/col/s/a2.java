package com.amap.api.col.s;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a2 {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f7859a;

    /* renamed from: b, reason: collision with root package name */
    private static String[] f7860b = {"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};

    /* renamed from: c, reason: collision with root package name */
    private static int[] f7861c = null;

    private static int a(int i6, int i7) {
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            i8 = (i8 >> 1) | Integer.MIN_VALUE;
        }
        return (i6 << i7) | ((i6 & i8) >>> (32 - i7));
    }

    private static String c(int i6) {
        char[] cArr = new char[4];
        for (int i7 = 0; i7 < 4; i7++) {
            char c6 = (char) ((i6 >>> (i7 * 8)) & 255);
            cArr[3 - i7] = c6;
            String str = " ";
            for (int i8 = 0; i8 < 32; i8++) {
                str = str + (((Integer.MIN_VALUE >>> i8) & c6) >>> (31 - i8));
            }
        }
        return new String(cArr);
    }

    private static int g(int i6) {
        int i7 = 1;
        for (int i8 = 0; i8 < 15; i8++) {
            i7 = (i7 << 2) | 1;
        }
        return ((i6 & i7) << 1) | (((i7 << 1) & i6) >>> 1);
    }

    public static String b() {
        SecureRandom secureRandom = new SecureRandom();
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(j1.t("EQUVT"));
            keyGenerator.init(128, secureRandom);
            return v1.a(keyGenerator.generateKey().getEncoded());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String e(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        if (iArr != null) {
            for (int i6 = 0; i6 < iArr.length; i6++) {
                sb.append(c(a(g(iArr[i6]), i6)));
            }
        }
        return sb.toString();
    }

    private static byte[] f(byte[] bArr) {
        try {
            if (f7859a == null) {
                f7859a = j1.t("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f7859a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(e(i()).getBytes("UTF-8"), j1.t("EQUVT"));
            Cipher cipher = Cipher.getInstance(j1.t("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static String h(String str) {
        try {
            return v1.a(f(str.getBytes("UTF-8")));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static int[] i() {
        int[] iArr = f7861c;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[8];
        int i6 = 0;
        while (true) {
            String[] strArr = f7860b;
            if (i6 >= strArr.length) {
                return iArr2;
            }
            byte[] g6 = d1.g(strArr[i6]);
            iArr2[i6] = ((g6[0] & 255) << 24) | (g6[3] & 255) | ((g6[2] & 255) << 8) | ((g6[1] & 255) << 16);
            i6++;
        }
    }

    public static String d(String str) {
        return g1.a(str);
    }
}
