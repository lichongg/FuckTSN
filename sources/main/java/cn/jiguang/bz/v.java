package cn.jiguang.bz;

import android.util.Base64;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\Downloads\app\classes2.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2786a = l.b(new byte[]{91, 85, 5});

    /* renamed from: b, reason: collision with root package name */
    public static final String f2787b = l.b(new byte[]{99, 104, 88, 37, 39});

    /* renamed from: c, reason: collision with root package name */
    public static final String f2788c = l.b(new byte[]{74, SignedBytes.MAX_POWER_OF_TWO, 87, 60, 2, 21, 47});

    /* renamed from: d, reason: collision with root package name */
    private static final String f2789d = l.b(new byte[]{87, 84, 99});

    /* renamed from: e, reason: collision with root package name */
    private static final String f2790e = l.b(new byte[]{73, 83, 66, Ascii.US, 99, 91, 75, 57, 65, 123, 99, 74, 61, 70, 112, 84, 68, 112, 102, 113});

    public static int a() {
        return Math.abs(new SecureRandom().nextInt()) & 16777215;
    }

    public static String b(String str, String str2) {
        try {
            return new String(a(str, str2, str2));
        } catch (Exception unused) {
            cn.jiguang.bb.f.i("", "Unexpected - failed to AES decrypt.");
            return "";
        }
    }

    private static <T> T a(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static String b(String str, String str2, String str3) {
        return new String(Base64.encode(a(str, a(str2), str3), 2), "UTF-8");
    }

    public static String a(long j6) {
        long j7;
        long j8;
        switch ((int) (j6 % 10)) {
            case 1:
                j7 = 5 * j6;
                j8 = 88;
                break;
            case 2:
                j7 = 23 * j6;
                j8 = 15;
                break;
            case 3:
                j7 = 3 * j6;
                j8 = 73;
                break;
            case 4:
                j7 = 13 * j6;
                j8 = 96;
                break;
            case 5:
                j7 = 17 * j6;
                j8 = 49;
                break;
            case 6:
                j7 = 7 * j6;
                j8 = 68;
                break;
            case 7:
                j7 = 31 * j6;
                j8 = 39;
                break;
            case 8:
                j7 = 29 * j6;
                j8 = 41;
                break;
            case 9:
                j7 = 37 * j6;
                j8 = 91;
                break;
            default:
                j7 = 8 * j6;
                j8 = 74;
                break;
        }
        return w.d("JCKP" + (j7 + (j6 % j8)));
    }

    private static byte[] c(String str, String str2) {
        byte[] bArr = new byte[str.length()];
        byte[] bytes = str.substring(0, str.length() / 2).getBytes(str2);
        byte[] bytes2 = str.substring(str.length() / 2).getBytes(str2);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
        return bArr;
    }

    public static String a(String str, String str2) {
        try {
            return a(str.getBytes(), str2, str2);
        } catch (Exception unused) {
            cn.jiguang.bb.f.i("", "Unexpected - failed to AES encrypt.");
            return "";
        }
    }

    public static String a(byte[] bArr, String str, String str2) {
        return Base64.encodeToString(a(bArr, str, str2, true), 2);
    }

    private static RSAPublicKey a(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Throwable unused) {
            return null;
        }
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
        byte[] doFinal;
        synchronized (v.class) {
            Cipher cipher = Cipher.getInstance(str2);
            cipher.init(1, rSAPublicKey);
            doFinal = cipher.doFinal(str.getBytes());
        }
        return doFinal;
    }

    public static synchronized byte[] a(byte[] bArr, String str, String str2, boolean z5) {
        synchronized (v.class) {
            if (str == null) {
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(c(str, "UTF-8"), f2789d);
            IvParameterSpec a6 = a(str2.getBytes("UTF-8"));
            Cipher cipher = Cipher.getInstance(f2790e);
            cipher.init(z5 ? 1 : 2, secretKeySpec, a6);
            return cipher.doFinal(bArr);
        }
    }
}
