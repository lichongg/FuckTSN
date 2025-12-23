package com.bytedance.msdk.tl;

import android.text.TextUtils;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    public static String j(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(com.acse.ottn.f.f4513a);
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    public static String xt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(com.acse.ottn.f.f4513a);
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(decode));
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    public static String j(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(bArr), 0);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    public static String j() {
        String up = rn.up();
        if (up == null || up.length() != 16) {
            return null;
        }
        return up;
    }

    public static String j(String str) {
        if (str == null || str.length() != 16) {
            return null;
        }
        return str.concat(str).substring(8, 24);
    }

    public static String j(String str, String str2, String str3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
        } catch (Throwable th) {
            com.bytedance.msdk.j.up.cw.cw(th.getMessage());
            return null;
        }
    }
}
