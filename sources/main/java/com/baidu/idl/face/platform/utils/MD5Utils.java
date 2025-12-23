package com.baidu.idl.face.platform.utils;

import com.baidu.mobads.sdk.internal.by;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MD5Utils {
    public static String encryption(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance(by.f10823a).digest(bArr);
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b6 : digest) {
                int i6 = b6 & 255;
                if (i6 < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(i6));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e6) {
            e6.printStackTrace();
            return "";
        } catch (Exception e7) {
            e7.printStackTrace();
            return "";
        }
    }
}
