package c2;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import d2.g;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1050a = "SHA256WithRSA";

    /* renamed from: b, reason: collision with root package name */
    private static final String f1051b = "SHA256WithRSA/PSS";

    /* renamed from: c, reason: collision with root package name */
    private static final String f1052c = "RSASign";

    /* renamed from: d, reason: collision with root package name */
    private static final String f1053d = "UTF-8";

    /* renamed from: e, reason: collision with root package name */
    private static final String f1054e = "";

    private static boolean d(String str, String str2, PublicKey publicKey, boolean z5) {
        try {
            return q(str.getBytes("UTF-8"), Base64.decode(str2, 0), publicKey, z5);
        } catch (UnsupportedEncodingException e6) {
            g.d(f1052c, "verifySign UnsupportedEncodingException: " + e6.getMessage());
            return false;
        } catch (Exception e7) {
            g.d(f1052c, "base64 decode Exception : " + e7.getMessage());
            return false;
        }
    }

    @Deprecated
    public static String j(String str, String str2) {
        return a(str, str2, false);
    }

    @Deprecated
    public static String k(String str, PrivateKey privateKey) {
        return b(str, privateKey, false);
    }

    public static byte[] l(ByteBuffer byteBuffer, PrivateKey privateKey, boolean z5) {
        Signature signature;
        byte[] bArr = new byte[0];
        if (byteBuffer == null || privateKey == null || !a.h((RSAPrivateKey) privateKey)) {
            g.d(f1052c, "content or privateKey is null , or length is too short");
            return bArr;
        }
        try {
            if (z5) {
                signature = Signature.getInstance(f1051b);
                signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } else {
                signature = Signature.getInstance(f1050a);
            }
            signature.initSign(privateKey);
            signature.update(byteBuffer);
            bArr = signature.sign();
            g.e(f1052c, "result is : " + Arrays.toString(bArr));
            return bArr;
        } catch (InvalidAlgorithmParameterException e6) {
            g.d(f1052c, "sign InvalidAlgorithmParameterException: " + e6.getMessage());
            return bArr;
        } catch (InvalidKeyException e7) {
            g.d(f1052c, "sign InvalidKeyException: " + e7.getMessage());
            return bArr;
        } catch (NoSuchAlgorithmException e8) {
            g.d(f1052c, "sign NoSuchAlgorithmException: " + e8.getMessage());
            return bArr;
        } catch (SignatureException e9) {
            g.d(f1052c, "sign SignatureException: " + e9.getMessage());
            return bArr;
        } catch (Exception e10) {
            g.d(f1052c, "sign Exception: " + e10.getMessage());
            return bArr;
        }
    }

    public static byte[] m(byte[] bArr, PrivateKey privateKey, boolean z5) {
        Signature signature;
        byte[] bArr2 = new byte[0];
        if (bArr == null || privateKey == null || !a.h((RSAPrivateKey) privateKey)) {
            g.d(f1052c, "content or privateKey is null , or length is too short");
            return bArr2;
        }
        try {
            if (z5) {
                signature = Signature.getInstance(f1051b);
                signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } else {
                signature = Signature.getInstance(f1050a);
            }
            signature.initSign(privateKey);
            signature.update(bArr);
            return signature.sign();
        } catch (InvalidAlgorithmParameterException e6) {
            g.d(f1052c, "sign InvalidAlgorithmParameterException: " + e6.getMessage());
            return bArr2;
        } catch (InvalidKeyException e7) {
            g.d(f1052c, "sign InvalidKeyException: " + e7.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e8) {
            g.d(f1052c, "sign NoSuchAlgorithmException: " + e8.getMessage());
            return bArr2;
        } catch (SignatureException e9) {
            g.d(f1052c, "sign SignatureException: " + e9.getMessage());
            return bArr2;
        } catch (Exception e10) {
            g.d(f1052c, "sign Exception: " + e10.getMessage());
            return bArr2;
        }
    }

    @Deprecated
    public static boolean n(String str, String str2, String str3) {
        return c(str, str2, str3, false);
    }

    @Deprecated
    public static boolean o(String str, String str2, PublicKey publicKey) {
        return d(str, str2, publicKey, false);
    }

    public static boolean p(ByteBuffer byteBuffer, byte[] bArr, PublicKey publicKey, boolean z5) {
        Signature signature;
        if (byteBuffer == null || publicKey == null || bArr == null || !a.i((RSAPublicKey) publicKey)) {
            g.d(f1052c, "content or publicKey is null , or length is too short");
            return false;
        }
        try {
            if (z5) {
                signature = Signature.getInstance(f1051b);
                signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } else {
                signature = Signature.getInstance(f1050a);
            }
            signature.initVerify(publicKey);
            signature.update(byteBuffer);
            return signature.verify(bArr);
        } catch (GeneralSecurityException e6) {
            g.d(f1052c, "check sign exception: " + e6.getMessage());
            return false;
        } catch (Exception e7) {
            g.d(f1052c, "exception : " + e7.getMessage());
            return false;
        }
    }

    public static boolean q(byte[] bArr, byte[] bArr2, PublicKey publicKey, boolean z5) {
        Signature signature;
        if (bArr == null || publicKey == null || bArr2 == null || !a.i((RSAPublicKey) publicKey)) {
            g.d(f1052c, "content or publicKey is null , or length is too short");
            return false;
        }
        try {
            if (z5) {
                signature = Signature.getInstance(f1051b);
                signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } else {
                signature = Signature.getInstance(f1050a);
            }
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (GeneralSecurityException e6) {
            g.d(f1052c, "check sign exception: " + e6.getMessage());
            return false;
        } catch (Exception e7) {
            g.d(f1052c, "exception : " + e7.getMessage());
            return false;
        }
    }

    private static String b(String str, PrivateKey privateKey, boolean z5) {
        try {
            return Base64.encodeToString(m(str.getBytes("UTF-8"), privateKey, z5), 0);
        } catch (UnsupportedEncodingException e6) {
            g.d(f1052c, "sign UnsupportedEncodingException: " + e6.getMessage());
            return "";
        }
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT > 23;
    }

    private static String a(String str, String str2, boolean z5) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            PrivateKey f6 = d2.b.f(str2);
            if (z5) {
                return g(str, f6);
            }
            return k(str, f6);
        }
        g.d(f1052c, "sign content or key is null");
        return "";
    }

    private static boolean c(String str, String str2, String str3, boolean z5) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            RSAPublicKey g6 = d2.b.g(str3);
            if (z5) {
                return i(str, str2, g6);
            }
            return o(str, str2, g6);
        }
        g.d(f1052c, "content or public key or sign value is null");
        return false;
    }

    public static String f(String str, String str2) {
        if (!e()) {
            g.d(f1052c, "sdk version is too low");
            return "";
        }
        return a(str, str2, true);
    }

    public static String g(String str, PrivateKey privateKey) {
        if (!e()) {
            g.d(f1052c, "sdk version is too low");
            return "";
        }
        return b(str, privateKey, true);
    }

    public static boolean h(String str, String str2, String str3) {
        if (!e()) {
            g.d(f1052c, "sdk version is too low");
            return false;
        }
        return c(str, str2, str3, true);
    }

    public static boolean i(String str, String str2, PublicKey publicKey) {
        if (!e()) {
            g.d(f1052c, "sdk version is too low");
            return false;
        }
        return d(str, str2, publicKey, true);
    }
}
