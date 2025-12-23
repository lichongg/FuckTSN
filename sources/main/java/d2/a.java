package d2;

import android.annotation.SuppressLint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42971a = "BaseKeyUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final int f42972b = 16;

    /* renamed from: c, reason: collision with root package name */
    private static final int f42973c = 16;

    /* renamed from: d, reason: collision with root package name */
    private static final int f42974d = 10000;

    /* renamed from: e, reason: collision with root package name */
    private static final int f42975e = 32;

    /* renamed from: f, reason: collision with root package name */
    private static final int f42976f = 1;

    private static boolean d(byte[] bArr) {
        return bArr.length >= 16;
    }

    public static byte[] k(String str, String str2, String str3, byte[] bArr, boolean z5) {
        return g(str, str2, str3, bArr, 1, 32, z5);
    }

    @SuppressLint({"NewApi"})
    public static byte[] l(String str, String str2, String str3, byte[] bArr, boolean z5) {
        return g(str, str2, str3, bArr, 1, 16, z5);
    }

    private static int a(int i6, int i7, int i8) {
        if (i7 < i6) {
            i6 = i7;
        }
        return i8 < i6 ? i8 : i6;
    }

    private static boolean b(int i6) {
        return i6 >= 16;
    }

    @SuppressLint({"NewApi"})
    public static byte[] h(String str, String str2, String str3, byte[] bArr, int i6, boolean z5) {
        return g(str, str2, str3, bArr, 10000, i6, z5);
    }

    @SuppressLint({"NewApi"})
    public static byte[] i(String str, String str2, String str3, byte[] bArr, boolean z5) {
        return h(str, str2, str3, bArr, 16, z5);
    }

    public static byte[] j(String str, String str2, String str3, byte[] bArr, boolean z5) {
        return h(str, str2, str3, bArr, 32, z5);
    }

    private static boolean c(int i6, byte[] bArr) {
        return b(i6) & d(bArr);
    }

    public static String e(String str, String str2, String str3, byte[] bArr, int i6, boolean z5) {
        return c.b(h(str, str2, str3, bArr, i6, z5));
    }

    public static byte[] f(String str, String str2, String str3, String str4, int i6, boolean z5) {
        return h(str, str2, str3, c.c(str4), i6, z5);
    }

    public static byte[] g(String str, String str2, String str3, byte[] bArr, int i6, int i7, boolean z5) {
        byte[] c6 = c.c(str);
        byte[] c7 = c.c(str2);
        byte[] c8 = c.c(str3);
        int a6 = a(c6.length, c7.length, c8.length);
        if (c(a6, bArr)) {
            char[] cArr = new char[a6];
            for (int i8 = 0; i8 < a6; i8++) {
                cArr[i8] = (char) ((c6[i8] ^ c7[i8]) ^ c8[i8]);
            }
            if (!z5) {
                g.e(f42971a, "exportRootKey: sha1");
                return z1.c.c(cArr, bArr, i6, i7 * 8);
            }
            g.e(f42971a, "exportRootKey: sha256");
            return z1.c.j(cArr, bArr, i6, i7 * 8);
        }
        throw new IllegalArgumentException("key length must be more than 128bit.");
    }
}
