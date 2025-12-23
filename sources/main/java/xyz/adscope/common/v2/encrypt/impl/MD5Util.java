package xyz.adscope.common.v2.encrypt.impl;

import com.baidu.mobads.sdk.internal.by;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class MD5Util {
    public static String md5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(by.f10823a).digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b6 : digest) {
                int i6 = b6 & 255;
                if (i6 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i6));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
