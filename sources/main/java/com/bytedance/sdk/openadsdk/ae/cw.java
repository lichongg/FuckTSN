package com.bytedance.sdk.openadsdk.ae;

import android.util.Base64;
import com.bytedance.sdk.component.utils.vl;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    public static String j() {
        return j(16);
    }

    public static String j(int i6) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i7 = 0; i7 < i6; i7++) {
            stringBuffer.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    public static String j(String str, String str2, String str3) {
        try {
            Charset charset = StandardCharsets.UTF_8;
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(charset));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(charset), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(str3.getBytes()), 2);
        } catch (Exception e6) {
            vl.cw("safetyUtil", "AESEncrypt ", e6);
            return null;
        }
    }
}
