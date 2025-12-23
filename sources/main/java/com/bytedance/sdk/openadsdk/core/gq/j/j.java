package com.bytedance.sdk.openadsdk.core.gq.j;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static final byte[] f29114j = "0000000000000000".getBytes();

    public static String j(String str, String str2) {
        try {
            Charset charset = StandardCharsets.UTF_8;
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(charset), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            return com.bytedance.sdk.component.utils.up.j(mac.doFinal(str.getBytes(charset)));
        } catch (InvalidKeyException | NoSuchAlgorithmException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static String j(byte[] bArr, String str) {
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
            cipher.init(1, rSAPublicKey);
            return com.bytedance.sdk.component.utils.up.j(cipher.doFinal(bArr));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String j(boolean z5, byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f29114j);
            if (z5) {
                cipher.init(1, secretKeySpec, ivParameterSpec);
            } else {
                cipher.init(2, secretKeySpec, ivParameterSpec);
            }
            byte[] doFinal = cipher.doFinal(bArr);
            if (z5) {
                return com.bytedance.sdk.component.utils.up.j(doFinal);
            }
            return new String(doFinal);
        } catch (Exception unused) {
            return "";
        }
    }
}
