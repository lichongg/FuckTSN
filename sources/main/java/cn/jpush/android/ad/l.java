package cn.jpush.android.ad;

import android.util.Base64;
import cn.jpush.android.helper.Logger;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.http.cookie.CookieHeaderNames;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes2.dex */
public class l {

    /* renamed from: f, reason: collision with root package name */
    private static final String f3485f = d.b(new byte[]{87, 84, 99});

    /* renamed from: g, reason: collision with root package name */
    private static final String f3486g = d.b(new byte[]{73, 83, 66, Ascii.US, 99, 91, 75, 57, 65, 123, 99, 74, 61, 70, 112, 84, 68, 112, 102, 113});

    /* renamed from: a, reason: collision with root package name */
    public static final String f3480a = d.b(new byte[]{91, 85, 5});

    /* renamed from: b, reason: collision with root package name */
    public static final String f3481b = d.b(new byte[]{99, 104, 88, 37, 39});

    /* renamed from: c, reason: collision with root package name */
    public static final String f3482c = d.b(new byte[]{74, SignedBytes.MAX_POWER_OF_TWO, 87, 60, 2, 21, 47});

    /* renamed from: d, reason: collision with root package name */
    public static final String f3483d = d.b(new byte[]{87, 69, 109, 65, 120, 98, 68, 65, 119, 107, 115});

    /* renamed from: e, reason: collision with root package name */
    public static final String f3484e = d.b(new byte[]{124, 112, 70, 65, 55, 123, 115, 114, 69, 82, 112, 124, 111, Utf8.REPLACEMENT_BYTE, 125, 69, 106, 123, 119, 118, 85, 100, 112, 111, 115, 98, 68});

    /* renamed from: h, reason: collision with root package name */
    private static HashMap<String, MessageDigest> f3487h = new HashMap<>();

    private static <T> T a(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static String b(String str, String str2) {
        try {
            return new String(a(str, str2, str2));
        } catch (Exception unused) {
            Logger.w("", "Unexpected - failed to AES decrypt.");
            return "";
        }
    }

    public static String a(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(f3482c).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i6 = 0; i6 < digest.length; i6++) {
                String upperCase = Integer.toHexString(digest[i6] & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
                if (i6 < digest.length - 1) {
                    sb.append(":");
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            Logger.w(CookieHeaderNames.SECURE, " fail, error is " + th.getMessage());
            return "";
        }
    }

    public static String b(String str, String str2, String str3) {
        return new String(Base64.encode(a(str, b(str2), str3), 2), "UTF-8");
    }

    public static String a(String str, String str2) {
        try {
            return a(str.getBytes(), str2, str2);
        } catch (Exception unused) {
            Logger.w("", "Unexpected - failed to AES encrypt.");
            return "";
        }
    }

    private static RSAPublicKey b(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Throwable th) {
            th.toString();
            return null;
        }
    }

    private static byte[] c(String str, String str2) {
        byte[] bArr = new byte[str.length()];
        byte[] bytes = str.substring(0, str.length() / 2).getBytes(str2);
        byte[] bytes2 = str.substring(str.length() / 2).getBytes(str2);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
        return bArr;
    }

    public static String a(byte[] bArr, String str, String str2) {
        return Base64.encodeToString(a(bArr, str, str2, true), 2);
    }

    private static IvParameterSpec a(byte[] bArr) {
        try {
            return (IvParameterSpec) a(IvParameterSpec.class, new Object[]{bArr}, (Class<?>[]) new Class[]{byte[].class});
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3) {
        return a(Base64.decode(str, 2), str2, str3, false);
    }

    private static synchronized byte[] a(String str, RSAPublicKey rSAPublicKey, String str2) {
        byte[] decode;
        synchronized (l.class) {
            byte[] decode2 = Base64.decode(str, 2);
            Cipher cipher = Cipher.getInstance(str2);
            cipher.init(2, rSAPublicKey);
            decode = Base64.decode(cipher.doFinal(decode2), 2);
        }
        return decode;
    }

    public static synchronized byte[] a(byte[] bArr, String str, String str2, boolean z5) {
        synchronized (l.class) {
            if (str == null) {
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(c(str, "UTF-8"), f3485f);
            IvParameterSpec a6 = a(str2.getBytes("UTF-8"));
            Cipher cipher = Cipher.getInstance(f3486g);
            cipher.init(z5 ? 1 : 2, secretKeySpec, a6);
            return cipher.doFinal(bArr);
        }
    }
}
