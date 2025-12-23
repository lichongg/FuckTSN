package com.beizi.ad.internal.h;

import com.baidu.mobads.sdk.internal.by;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class f {
    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b6 : bArr) {
            int i6 = (b6 >>> 4) & 15;
            int i7 = 0;
            while (true) {
                sb.append((char) ((i6 < 0 || i6 > 9) ? i6 + 87 : i6 + 48));
                i6 = b6 & 15;
                int i8 = i7 + 1;
                if (i7 >= 1) {
                    break;
                }
                i7 = i8;
            }
        }
        return sb.toString();
    }
}
