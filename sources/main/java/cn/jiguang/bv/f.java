package cn.jiguang.bv;

import android.text.TextUtils;
import cn.jiguang.bz.l;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2607a = l.b(new byte[]{96, 89, 98, 99, 101, 89, 76, 106, 38, 96, 116, 66, 83, 112, 103, 120, Utf8.REPLACEMENT_BYTE, 67, 84, 120, 122, 98, 81, 112});

    /* renamed from: b, reason: collision with root package name */
    public static final String f2608b = l.b(new byte[]{81, 112, 74, 108, 124, Byte.MAX_VALUE, 125, 67, 14, 111, 109, 100, 98, 89, 79, 119, 38, 115, Byte.MAX_VALUE, 84, 96, 89});

    private static int a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0023, code lost:
    
        r6 = r6 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(byte[] r4, byte[] r5, int r6) {
        /*
            r0 = -1
            if (r4 == 0) goto L2a
            if (r5 != 0) goto L6
            goto L2a
        L6:
            int r1 = r5.length     // Catch: java.lang.Throwable -> L2a
            if (r1 != 0) goto La
            return r6
        La:
            if (r6 >= 0) goto Ld
            return r0
        Ld:
            int r1 = r4.length     // Catch: java.lang.Throwable -> L2a
            int r2 = r5.length     // Catch: java.lang.Throwable -> L2a
            if (r1 >= r2) goto L12
            return r0
        L12:
            int r1 = r4.length     // Catch: java.lang.Throwable -> L2a
            int r2 = r5.length     // Catch: java.lang.Throwable -> L2a
            int r1 = r1 - r2
            if (r6 > r1) goto L2a
            r1 = 0
        L18:
            int r2 = r5.length     // Catch: java.lang.Throwable -> L2a
            if (r1 >= r2) goto L29
            int r2 = r6 + r1
            r2 = r4[r2]     // Catch: java.lang.Throwable -> L2a
            r3 = r5[r1]     // Catch: java.lang.Throwable -> L2a
            if (r2 == r3) goto L26
            int r6 = r6 + 1
            goto L12
        L26:
            int r1 = r1 + 1
            goto L18
        L29:
            return r6
        L2a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bv.f.a(byte[], byte[], int):int");
    }

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                return a(bArr, f2607a.getBytes("UTF-8"), f2608b.getBytes("UTF-8"));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static String a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int a6;
        int length;
        int length2;
        try {
            int a7 = a(bArr, bArr2);
            if (a7 == -1 || (a6 = a(bArr, bArr3, bArr2.length + a7)) == -1 || (length2 = a6 - (length = a7 + bArr2.length)) < 0) {
                return null;
            }
            if (length2 == 0) {
                return "";
            }
            if (length + length2 > bArr.length) {
                return null;
            }
            byte[] bArr4 = new byte[length2];
            System.arraycopy(bArr, length, bArr4, 0, length2);
            String str = new String(bArr4, "UTF-8");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str.trim();
        } catch (Throwable unused) {
            return null;
        }
    }
}
