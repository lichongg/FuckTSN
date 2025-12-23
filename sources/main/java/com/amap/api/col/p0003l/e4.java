package com.amap.api.col.p0003l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e4 {

    /* renamed from: a, reason: collision with root package name */
    private static int f5993a = 6;

    private static byte[] a() {
        try {
            return b("16,99,86,77,511,98,86,97,511,99,86,77,511,18,48,97,511,99,86,77,511,58,601,77,511,58,48,77,511,58,86,87,511,18,48,97,511,58,86,87,511,18,48,97,511,98,48,87,511,98,48,97,511,99,86,77,511,58,221,77,511,98,601,87");
        } catch (Throwable th) {
            v5.p(th, "AMU", "grk");
            return null;
        }
    }

    private static byte[] b(String str) {
        try {
            String[] split = new StringBuffer(str).reverse().toString().split(",");
            int length = split.length;
            byte[] bArr = new byte[length];
            for (int i6 = 0; i6 < length; i6++) {
                bArr[i6] = Byte.parseByte(split[i6]);
            }
            String[] split2 = new StringBuffer(new String(j5.c(new String(bArr)), "UTF-8")).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i7 = 0; i7 < split2.length; i7++) {
                bArr2[i7] = Byte.parseByte(split2[i7]);
            }
            return bArr2;
        } catch (Throwable th) {
            v5.p(th, "AMU", "rcs");
            return null;
        }
    }

    private static byte[] d() {
        try {
            return b("16,18,86,97,511,18,48,97,511,18,86,97,511,58,86,77,511,18,86,97,511,58,48,77,511,18,86,97,511,58,601,77,511,18,86,97,511,58,221,77,511,18,86,97,511,58,86,87,511,18,86,97,511,58,48,87,511,18,86,97,511,58,601,87");
        } catch (Throwable th) {
            v5.p(th, "AMU", "giv");
            return null;
        }
    }

    public static byte[] c(byte[] bArr) {
        try {
            return j4.h(a(), bArr, d());
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] e(byte[] bArr) {
        try {
            return j4.e(a(), bArr, d());
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
