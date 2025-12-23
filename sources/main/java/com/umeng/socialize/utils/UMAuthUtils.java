package com.umeng.socialize.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMAuthUtils {
    public static String decrypt(String str, String str2) throws Exception {
        int i6;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bytes = str2.getBytes();
            if (bytes.length < 16) {
                bytes = new byte[16];
                Arrays.fill(bytes, (byte) 1);
                System.arraycopy(bytes, 0, str2.getBytes(), 0, str2.length());
                i6 = 16;
            } else {
                i6 = 32;
                if (bytes.length <= 32) {
                    if (bytes.length % 8 != 0) {
                        i6 = bytes.length - (bytes.length % 8);
                    } else {
                        i6 = bytes.length;
                    }
                }
            }
            cipher.init(2, new SecretKeySpec(bytes, 0, i6, "AES"), new IvParameterSpec(Arrays.copyOfRange(bytes, 0, 16)));
            return new String(cipher.doFinal(Base64.decode(str, 0)));
        }
        return "";
    }

    public static String encrypt(String str, String str2) throws Exception {
        int i6;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bytes = str2.getBytes();
            if (bytes.length < 16) {
                bytes = new byte[16];
                Arrays.fill(bytes, (byte) 1);
                System.arraycopy(bytes, 0, str2.getBytes(), 0, str2.length());
                i6 = 16;
            } else {
                i6 = 32;
                if (bytes.length <= 32) {
                    if (bytes.length % 8 != 0) {
                        i6 = bytes.length - (bytes.length % 8);
                    } else {
                        i6 = bytes.length;
                    }
                }
            }
            cipher.init(1, new SecretKeySpec(bytes, 0, i6, "AES"), new IvParameterSpec(Arrays.copyOfRange(bytes, 0, 16)));
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        }
        return "";
    }
}
