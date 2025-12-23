package z1;

import android.text.TextUtils;
import d2.g;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f56793a = "HMACSHA256";

    /* renamed from: b, reason: collision with root package name */
    private static final String f56794b = "HmacSHA256";

    /* renamed from: c, reason: collision with root package name */
    private static final String f56795c = "";

    /* renamed from: d, reason: collision with root package name */
    private static final int f56796d = 32;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            g.d(f56793a, "content or key is null.");
            return new byte[0];
        }
        if (bArr2.length < 32) {
            g.d(f56793a, "hmac key length is not right");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f56794b);
            Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
            mac.init(secretKeySpec);
            return mac.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException e6) {
            g.d(f56793a, "hmacsha256 encrypt exception" + e6.getMessage());
            return new byte[0];
        }
    }

    public static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return c(str, d2.c.c(str2));
        }
        return "";
    }

    public static String c(String str, byte[] bArr) {
        byte[] bArr2;
        if (TextUtils.isEmpty(str) || bArr == null) {
            return "";
        }
        if (bArr.length < 32) {
            g.d(f56793a, "hmac key length is not right");
            return "";
        }
        try {
            bArr2 = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e6) {
            g.d(f56793a, "hmacsha256 encrypt exception" + e6.getMessage());
            bArr2 = new byte[0];
        }
        return d2.c.b(a(bArr2, bArr));
    }
}
