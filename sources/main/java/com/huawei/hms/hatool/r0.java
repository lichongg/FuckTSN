package com.huawei.hms.hatool;

import android.util.Pair;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class r0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f33636a = Charset.forName("UTF-8");

    public static Pair<byte[], String> a(String str, int i6) {
        if (str == null || str.length() < i6) {
            return new Pair<>(new byte[0], str);
        }
        String substring = str.substring(0, i6);
        return new Pair<>(d2.c.c(substring), str.substring(i6));
    }

    public static String b(String str, String str2) {
        Pair<byte[], String> a6 = a(str, 32);
        return new String(com.huawei.secure.android.common.encrypt.aes.a.p(d2.c.c((String) a6.second), d2.c.c(str2), (byte[]) a6.first), f33636a);
    }

    public static String c(byte[] bArr, String str) {
        String str2;
        if (bArr == null || bArr.length == 0 || str == null) {
            str2 = "cbc encrypt(byte) param is not right";
        } else {
            byte[] c6 = d2.c.c(str);
            if (c6.length >= 16) {
                return d2.c.b(com.huawei.secure.android.common.encrypt.aes.b.u(bArr, c6));
            }
            str2 = "key length is not right";
        }
        j1.e("AesCipher", str2);
        return "";
    }

    public static String d(String str, String str2) {
        return d2.c.b(com.huawei.secure.android.common.encrypt.aes.a.x(str.getBytes(f33636a), d2.c.c(str2)));
    }
}
