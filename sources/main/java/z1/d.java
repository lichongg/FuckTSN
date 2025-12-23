package z1;

import android.text.TextUtils;
import d2.g;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f56806a = "SHA";

    /* renamed from: c, reason: collision with root package name */
    private static final String f56808c = "";

    /* renamed from: b, reason: collision with root package name */
    private static final String f56807b = "SHA-256";

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f56809d = {f56807b, "SHA-384", "SHA-512"};

    public static byte[] d(byte[] bArr, String str) {
        if (bArr == null || TextUtils.isEmpty(str)) {
            g.d(f56806a, "content or algorithm is null.");
            return new byte[0];
        }
        if (!a(str)) {
            g.d(f56806a, "algorithm is not safe or legal");
            return new byte[0];
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            g.d(f56806a, "Error in generate SHA NoSuchAlgorithmException");
            return new byte[0];
        }
    }

    private static boolean a(String str) {
        for (String str2 : f56809d) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String b(String str) {
        return c(str, f56807b);
    }

    private d() {
    }

    public static String c(String str, String str2) {
        byte[] bArr;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!a(str2)) {
                g.d(f56806a, "algorithm is not safe or legal");
                return "";
            }
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                bArr = new byte[0];
                g.d(f56806a, "Error in generate SHA UnsupportedEncodingException");
            }
            return d2.c.b(d(bArr, str2));
        }
        g.d(f56806a, "content or algorithm is null.");
        return "";
    }

    public static boolean e(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return str2.equals(c(str, str3));
        }
        return false;
    }

    public static boolean f(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return str2.equals(b(str));
        }
        return false;
    }
}
