package xyz.adscope.amps.adapter.gdt.util;

import android.os.Build;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

/* loaded from: D:\Downloads\app\classes9.dex */
public class RSAEncryptUtil {
    private static final String transformationCode = "RSA/ECB/PKCS1Padding";

    public static PublicKey getPublicKey(String str) {
        X509EncodedKeySpec x509EncodedKeySpec;
        Base64.Decoder mimeDecoder;
        byte[] decode;
        if (Build.VERSION.SDK_INT >= 26) {
            mimeDecoder = Base64.getMimeDecoder();
            decode = mimeDecoder.decode(str.getBytes(StandardCharsets.UTF_8));
            x509EncodedKeySpec = new X509EncodedKeySpec(decode);
        } else {
            x509EncodedKeySpec = new X509EncodedKeySpec(android.util.Base64.decode(str, 0));
        }
        try {
            return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String str, String str2) {
        String encodeToString;
        Base64.Encoder encoder;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                PublicKey publicKey = getPublicKey(str2);
                Cipher cipher = Cipher.getInstance(transformationCode);
                cipher.init(1, publicKey);
                byte[] doFinal = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
                if (Build.VERSION.SDK_INT >= 26) {
                    encoder = Base64.getEncoder();
                    encodeToString = encoder.encodeToString(doFinal);
                } else {
                    encodeToString = android.util.Base64.encodeToString(doFinal, 0);
                }
                return URLEncoder.encode(encodeToString, "UTF-8");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str;
    }
}
