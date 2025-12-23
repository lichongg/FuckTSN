package c2;

import android.text.TextUtils;
import android.util.Base64;
import d2.g;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1044a = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /* renamed from: b, reason: collision with root package name */
    private static final String f1045b = "RSAEncrypt";

    /* renamed from: c, reason: collision with root package name */
    private static final String f1046c = "UTF-8";

    /* renamed from: d, reason: collision with root package name */
    private static final String f1047d = "";

    /* renamed from: e, reason: collision with root package name */
    private static final int f1048e = 2048;

    /* renamed from: f, reason: collision with root package name */
    private static final String f1049f = "RSA";

    public static byte[] c(byte[] bArr, PrivateKey privateKey) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || privateKey == null || !h((RSAPrivateKey) privateKey)) {
            g.d(f1045b, "content or privateKey is null , or length is too short");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance(f1044a);
            cipher.init(2, privateKey);
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e6) {
            g.d(f1045b, "RSA decrypt exception : " + e6.getMessage());
            return bArr2;
        }
    }

    public static byte[] f(byte[] bArr, PublicKey publicKey) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || publicKey == null || !i((RSAPublicKey) publicKey)) {
            g.d(f1045b, "content or PublicKey is null , or length is too short");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance(f1044a);
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e6) {
            g.d(f1045b, "RSA encrypt exception : " + e6.getMessage());
            return bArr2;
        }
    }

    public static boolean h(RSAPrivateKey rSAPrivateKey) {
        return rSAPrivateKey != null && rSAPrivateKey.getModulus().bitLength() >= 2048;
    }

    public static boolean i(RSAPublicKey rSAPublicKey) {
        return rSAPublicKey != null && rSAPublicKey.getModulus().bitLength() >= 2048;
    }

    public static Map<String, Key> g(int i6) throws NoSuchAlgorithmException {
        HashMap hashMap = new HashMap(2);
        if (i6 < 2048) {
            g.d(f1045b, "generateRSAKeyPair: key length is too short");
            return hashMap;
        }
        SecureRandom c6 = d2.b.c();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(f1049f);
        keyPairGenerator.initialize(i6, c6);
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = generateKeyPair.getPublic();
        PrivateKey privateKey = generateKeyPair.getPrivate();
        hashMap.put("publicKey", publicKey);
        hashMap.put("privateKey", privateKey);
        return hashMap;
    }

    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return b(str, d2.b.f(str2));
        }
        g.d(f1045b, "content or private key is null");
        return "";
    }

    public static String b(String str, PrivateKey privateKey) {
        if (!TextUtils.isEmpty(str) && privateKey != null && h((RSAPrivateKey) privateKey)) {
            try {
                return new String(c(Base64.decode(str, 0), privateKey), "UTF-8");
            } catch (UnsupportedEncodingException e6) {
                g.d(f1045b, "RSA decrypt exception : " + e6.getMessage());
                return "";
            } catch (Exception e7) {
                g.d(f1045b, "exception : " + e7.getMessage());
                return "";
            }
        }
        g.d(f1045b, "content or privateKey is null , or length is too short");
        return "";
    }

    public static String d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return e(str, d2.b.g(str2));
        }
        g.d(f1045b, "content or public key is null");
        return "";
    }

    public static String e(String str, PublicKey publicKey) {
        if (!TextUtils.isEmpty(str) && publicKey != null && i((RSAPublicKey) publicKey)) {
            try {
                return Base64.encodeToString(f(str.getBytes("UTF-8"), publicKey), 0);
            } catch (UnsupportedEncodingException unused) {
                g.d(f1045b, "encrypt: UnsupportedEncodingException");
                return "";
            } catch (Exception e6) {
                g.d(f1045b, "exception : " + e6.getMessage());
                return "";
            }
        }
        g.d(f1045b, "content or PublicKey is null , or length is too short");
        return "";
    }
}
