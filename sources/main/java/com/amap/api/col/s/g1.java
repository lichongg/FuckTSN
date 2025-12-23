package com.amap.api.col.s;

import com.baidu.mobads.sdk.internal.by;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class g1 {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return j1.A(e(str));
    }

    public static String b(byte[] bArr) {
        return j1.A(c(bArr, j1.t("ETUQ1")));
    }

    private static byte[] g(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(j1.t("ETUQ1"));
        messageDigest.update(j1.o(str));
        return messageDigest.digest();
    }

    private static byte[] c(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            d2.e(th, by.f10823a, "gmb");
            return null;
        }
    }

    public static String d(String str) {
        return j1.B(f(str));
    }

    private static byte[] e(String str) {
        try {
            return g(str);
        } catch (Throwable th) {
            d2.e(th, by.f10823a, "gmb");
            return new byte[0];
        }
    }

    private static byte[] f(String str) {
        try {
            return g(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }
}
