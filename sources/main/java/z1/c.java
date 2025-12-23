package z1;

import android.os.Build;
import android.text.TextUtils;
import d2.g;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f56797a = "PBKDF2";

    /* renamed from: b, reason: collision with root package name */
    private static final String f56798b = "PBKDF2WithHmacSHA1";

    /* renamed from: c, reason: collision with root package name */
    private static final String f56799c = "PBKDF2WithHmacSHA256";

    /* renamed from: d, reason: collision with root package name */
    private static final String f56800d = "";

    /* renamed from: e, reason: collision with root package name */
    private static final int f56801e = 8;

    /* renamed from: f, reason: collision with root package name */
    private static final int f56802f = 16;

    /* renamed from: g, reason: collision with root package name */
    private static final int f56803g = 32;

    /* renamed from: h, reason: collision with root package name */
    private static final int f56804h = 10000;

    /* renamed from: i, reason: collision with root package name */
    private static final int f56805i = 1000;

    private static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            int length = bArr.length ^ bArr2.length;
            for (int i6 = 0; i6 < bArr.length && i6 < bArr2.length; i6++) {
                length |= bArr[i6] ^ bArr2[i6];
            }
            if (length == 0) {
                return true;
            }
        }
        return false;
    }

    public static byte[] c(char[] cArr, byte[] bArr, int i6, int i7) {
        return b(cArr, bArr, i6, i7, false);
    }

    public static byte[] j(char[] cArr, byte[] bArr, int i6, int i7) {
        byte[] bArr2 = new byte[0];
        if (Build.VERSION.SDK_INT >= 26) {
            return b(cArr, bArr, i6, i7, true);
        }
        g.d(f56797a, "system version not high than 26");
        return bArr2;
    }

    private static byte[] b(char[] cArr, byte[] bArr, int i6, int i7, boolean z5) {
        try {
            return (z5 ? SecretKeyFactory.getInstance(f56799c) : SecretKeyFactory.getInstance(f56798b)).generateSecret(new PBEKeySpec(cArr, bArr, i6, i7)).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e6) {
            g.d(f56797a, "pbkdf exception : " + e6.getMessage());
            return new byte[0];
        }
    }

    @Deprecated
    public static String d(String str) {
        return e(str, 10000);
    }

    @Deprecated
    public static String e(String str, int i6) {
        return f(str, d2.b.d(8), i6, 32);
    }

    public static String g(String str) {
        return h(str, 10000);
    }

    public static String h(String str, int i6) {
        return i(str, d2.b.d(16), i6, 32);
    }

    @Deprecated
    public static boolean k(String str, String str2) {
        return l(str, str2, 10000);
    }

    public static boolean m(String str, String str2) {
        return n(str, str2, 10000);
    }

    @Deprecated
    public static String f(String str, byte[] bArr, int i6, int i7) {
        if (TextUtils.isEmpty(str)) {
            g.d(f56797a, "pwd is null.");
            return "";
        }
        if (i6 < 1000) {
            g.d(f56797a, "iterations times is not enough.");
            return "";
        }
        if (bArr != null && bArr.length >= 8) {
            if (i7 < 32) {
                g.d(f56797a, "cipherLen length is not enough");
                return "";
            }
            return d2.c.b(bArr) + d2.c.b(c(str.toCharArray(), bArr, i6, i7 * 8));
        }
        g.d(f56797a, "salt parameter is null or length is not enough");
        return "";
    }

    public static String i(String str, byte[] bArr, int i6, int i7) {
        byte[] j6;
        if (TextUtils.isEmpty(str)) {
            g.d(f56797a, "pwd is null.");
            return "";
        }
        if (i6 < 1000) {
            g.d(f56797a, "iterations times is not enough.");
            return "";
        }
        if (bArr != null && bArr.length >= 16) {
            if (i7 < 32) {
                g.d(f56797a, "cipherLen length is not enough");
                return "";
            }
            if (Build.VERSION.SDK_INT < 26) {
                g.e(f56797a, "sha 1");
                j6 = c(str.toCharArray(), bArr, i6, i7 * 8);
            } else {
                g.e(f56797a, "sha 256");
                j6 = j(str.toCharArray(), bArr, i6, i7 * 8);
            }
            return d2.c.b(bArr) + d2.c.b(j6);
        }
        g.d(f56797a, "salt parameter is null or length is not enough");
        return "";
    }

    @Deprecated
    public static boolean l(String str, String str2, int i6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 16) {
            return false;
        }
        return a(c(str.toCharArray(), d2.c.c(str2.substring(0, 16)), i6, 256), d2.c.c(str2.substring(16)));
    }

    public static boolean n(String str, String str2, int i6) {
        byte[] j6;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 32) {
            return false;
        }
        String substring = str2.substring(0, 32);
        String substring2 = str2.substring(32);
        if (Build.VERSION.SDK_INT < 26) {
            j6 = c(str.toCharArray(), d2.c.c(substring), i6, 256);
        } else {
            j6 = j(str.toCharArray(), d2.c.c(substring), i6, 256);
        }
        return a(j6, d2.c.c(substring2));
    }
}
