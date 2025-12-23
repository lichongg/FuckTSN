package cn.jiguang.az;

import android.util.Base64;
import com.google.common.base.Ascii;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\Downloads\app\classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1867a = cn.jiguang.ax.a.b(new byte[]{87, 84, 99});

    /* renamed from: b, reason: collision with root package name */
    public static final String f1868b = cn.jiguang.ax.a.b(new byte[]{73, 83, 66, Ascii.US, 99, 91, 75, 57, 65, 123, 99, 74, 61, 70, 112, 84, 68, 112, 102, 113});

    /* renamed from: c, reason: collision with root package name */
    public static final String f1869c = cn.jiguang.ax.a.b(new byte[]{91, 85, 5});

    /* renamed from: d, reason: collision with root package name */
    public static final String f1870d = cn.jiguang.ax.a.b(new byte[]{99, 104, 88, 37, 39});

    private static <T> T a(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static String a(String str, String str2) {
        try {
            return new String(a(str, str2, str2));
        } catch (Throwable unused) {
            cn.jiguang.ay.b.e("", "Unexpected - failed to AES decrypt.");
            return "";
        }
    }

    public static String a(byte[] bArr, String str, String str2) {
        return Base64.encodeToString(a(bArr, str, str2, true), 2);
    }

    private static byte[] b(String str, String str2) {
        byte[] bArr = new byte[str.length()];
        byte[] bytes = str.substring(0, str.length() / 2).getBytes(str2);
        byte[] bytes2 = str.substring(str.length() / 2).getBytes(str2);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
        return bArr;
    }

    private static IvParameterSpec a(byte[] bArr) {
        try {
            return (IvParameterSpec) a(IvParameterSpec.class, new Object[]{bArr}, (Class<?>[]) new Class[]{byte[].class});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3) {
        return a(Base64.decode(str, 2), str2, str3, false);
    }

    public static synchronized byte[] a(byte[] bArr, String str, String str2, boolean z5) {
        synchronized (i.class) {
            if (str == null) {
                return null;
            }
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(b(str, "UTF-8"), f1867a);
                IvParameterSpec a6 = a(str2.getBytes("UTF-8"));
                Cipher cipher = Cipher.getInstance(f1868b);
                cipher.init(z5 ? 1 : 2, secretKeySpec, a6);
                return cipher.doFinal(bArr);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
