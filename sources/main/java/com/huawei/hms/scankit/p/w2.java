package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class w2 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f34931a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    private static int a(c0 c0Var) {
        return r4.a(c0Var) + r4.b(c0Var) + r4.c(c0Var) + r4.d(c0Var);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34932a;

        static {
            int[] iArr = new int[u4.values().length];
            f34932a = iArr;
            try {
                iArr[u4.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34932a[u4.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34932a[u4.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34932a[u4.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static void b(CharSequence charSequence, r rVar) {
        int length = charSequence.length();
        int i6 = 0;
        while (i6 < length) {
            int charAt = charSequence.charAt(i6) - '0';
            int i7 = i6 + 2;
            if (i7 < length) {
                rVar.a((charAt * 100) + ((charSequence.charAt(i6 + 1) - '0') * 10) + (charSequence.charAt(i7) - '0'), 10);
                i6 += 3;
            } else {
                i6++;
                if (i6 < length) {
                    rVar.a((charAt * 10) + (charSequence.charAt(i6) - '0'), 7);
                    i6 = i7;
                } else {
                    rVar.a(charAt, 4);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.scankit.p.h6 a(java.lang.String r6, com.huawei.hms.scankit.p.b3 r7, java.util.Map<com.huawei.hms.scankit.p.u2, ?> r8) throws com.huawei.hms.hmsscankit.WriterException {
        /*
            if (r8 == 0) goto Lc
            com.huawei.hms.scankit.p.u2 r0 = com.huawei.hms.scankit.p.u2.CHARACTER_SET
            boolean r0 = r8.containsKey(r0)
            if (r0 == 0) goto Lc
            r0 = 1
            goto Ld
        Lc:
            r0 = 0
        Ld:
            if (r0 == 0) goto L1a
            com.huawei.hms.scankit.p.u2 r1 = com.huawei.hms.scankit.p.u2.CHARACTER_SET
            java.lang.Object r1 = r8.get(r1)
            java.lang.String r1 = r1.toString()
            goto L1c
        L1a:
            java.lang.String r1 = "ISO-8859-1"
        L1c:
            com.huawei.hms.scankit.p.u4 r2 = a(r6, r1)
            com.huawei.hms.scankit.p.r r3 = new com.huawei.hms.scankit.p.r
            r3.<init>()
            com.huawei.hms.scankit.p.u4 r4 = com.huawei.hms.scankit.p.u4.BYTE
            if (r2 != r4) goto L34
            if (r0 == 0) goto L34
            com.huawei.hms.scankit.p.o0 r0 = com.huawei.hms.scankit.p.o0.a(r1)
            if (r0 == 0) goto L34
            a(r0, r3)
        L34:
            if (r8 == 0) goto L55
            com.huawei.hms.scankit.p.u2 r0 = com.huawei.hms.scankit.p.u2.GS1_FORMAT
            boolean r5 = r8.containsKey(r0)
            if (r5 == 0) goto L55
            java.lang.Object r0 = r8.get(r0)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L55
            com.huawei.hms.scankit.p.u4 r0 = com.huawei.hms.scankit.p.u4.FNC1_FIRST_POSITION
            a(r0, r3)
        L55:
            a(r2, r3)
            com.huawei.hms.scankit.p.r r0 = new com.huawei.hms.scankit.p.r
            r0.<init>()
            a(r6, r2, r0, r1)
            if (r8 == 0) goto L8d
            com.huawei.hms.scankit.p.u2 r1 = com.huawei.hms.scankit.p.u2.QR_VERSION
            boolean r5 = r8.containsKey(r1)
            if (r5 == 0) goto L8d
            java.lang.Object r8 = r8.get(r1)
            java.lang.String r8 = r8.toString()
            int r8 = java.lang.Integer.parseInt(r8)
            com.huawei.hms.scankit.p.b8 r8 = com.huawei.hms.scankit.p.b8.c(r8)
            int r1 = a(r2, r3, r0, r8)
            boolean r1 = a(r1, r8, r7)
            if (r1 == 0) goto L85
            goto L91
        L85:
            com.huawei.hms.hmsscankit.WriterException r6 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.String r7 = "Data too big for requested version"
            r6.<init>(r7)
            throw r6
        L8d:
            com.huawei.hms.scankit.p.b8 r8 = a(r7, r2, r3, r0)
        L91:
            com.huawei.hms.scankit.p.r r1 = new com.huawei.hms.scankit.p.r
            r1.<init>()
            r1.a(r3)
            if (r2 != r4) goto La0
            int r6 = r0.f()
            goto La4
        La0:
            int r6 = r6.length()
        La4:
            a(r6, r8, r2, r1)
            r1.a(r0)
            com.huawei.hms.scankit.p.b8$b r6 = r8.a(r7)
            int r0 = r8.e()
            int r3 = r6.d()
            int r0 = r0 - r3
            a(r0, r1)
            int r3 = r8.e()
            int r6 = r6.c()
            com.huawei.hms.scankit.p.r r6 = a(r1, r3, r0, r6)
            com.huawei.hms.scankit.p.h6 r0 = new com.huawei.hms.scankit.p.h6
            r0.<init>()
            r0.a(r7)
            r0.a(r2)
            r0.a(r8)
            int r1 = r8.d()
            com.huawei.hms.scankit.p.c0 r2 = new com.huawei.hms.scankit.p.c0
            r2.<init>(r1, r1)
            int r1 = a(r6, r7, r8, r2)
            r0.b(r1)
            com.huawei.hms.scankit.p.t4.a(r6, r7, r8, r1, r2)
            r0.a(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w2.a(java.lang.String, com.huawei.hms.scankit.p.b3, java.util.Map):com.huawei.hms.scankit.p.h6");
    }

    private static b8 a(b3 b3Var, u4 u4Var, r rVar, r rVar2) throws WriterException {
        return a(a(u4Var, rVar, rVar2, a(a(u4Var, rVar, rVar2, b8.c(1)), b3Var)), b3Var);
    }

    private static int a(u4 u4Var, r rVar, r rVar2, b8 b8Var) {
        return rVar.e() + u4Var.a(b8Var) + rVar2.e();
    }

    static int a(int i6) {
        int[] iArr = f34931a;
        if (i6 < iArr.length) {
            return iArr[i6];
        }
        return -1;
    }

    private static u4 a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && a(str)) {
            return u4.KANJI;
        }
        boolean z5 = false;
        boolean z6 = false;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt >= '0' && charAt <= '9') {
                z6 = true;
            } else {
                if (a(charAt) == -1) {
                    return u4.BYTE;
                }
                z5 = true;
            }
        }
        if (z5) {
            return u4.ALPHANUMERIC;
        }
        if (z6) {
            return u4.NUMERIC;
        }
        return u4.BYTE;
    }

    private static boolean a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i6 = 0; i6 < length; i6 += 2) {
                int i7 = bytes[i6] & 255;
                if ((i7 < 129 || i7 > 159) && (i7 < 224 || i7 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int a(r rVar, b3 b3Var, b8 b8Var, c0 c0Var) throws WriterException {
        int i6 = Integer.MAX_VALUE;
        int i7 = -1;
        for (int i8 = 0; i8 < 8; i8++) {
            t4.a(rVar, b3Var, b8Var, i8, c0Var);
            int a6 = a(c0Var);
            if (a6 < i6) {
                i7 = i8;
                i6 = a6;
            }
        }
        return i7;
    }

    private static b8 a(int i6, b3 b3Var) throws WriterException {
        for (int i7 = 1; i7 <= 40; i7++) {
            b8 c6 = b8.c(i7);
            if (a(i6, c6, b3Var)) {
                return c6;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean a(int i6, b8 b8Var, b3 b3Var) {
        return b8Var.e() - b8Var.a(b3Var).d() >= (i6 + 7) / 8;
    }

    static void a(int i6, r rVar) throws WriterException {
        int i7 = i6 * 8;
        if (rVar.e() <= i7) {
            for (int i8 = 0; i8 < 4 && rVar.e() < i7; i8++) {
                rVar.a(false);
            }
            int e6 = rVar.e() & 7;
            if (e6 > 0) {
                while (e6 < 8) {
                    rVar.a(false);
                    e6++;
                }
            }
            int f6 = i6 - rVar.f();
            for (int i9 = 0; i9 < f6; i9++) {
                rVar.a((i9 & 1) == 0 ? org.apache.commons.net.telnet.f.f51105u : 17, 8);
            }
            if (rVar.e() != i7) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + rVar.e() + " > " + i7);
    }

    static void a(int i6, int i7, int i8, int i9, int[] iArr, int[] iArr2) throws WriterException {
        if (i9 < i8) {
            int i10 = i6 % i8;
            int i11 = i8 - i10;
            int i12 = i6 / i8;
            int i13 = i12 + 1;
            int i14 = i7 / i8;
            int i15 = i14 + 1;
            int i16 = i12 - i14;
            int i17 = i13 - i15;
            if (i16 != i17) {
                throw new WriterException("EC bytes mismatch");
            }
            if (i8 != i11 + i10) {
                throw new WriterException("RS blocks mismatch");
            }
            if (i6 != ((i14 + i16) * i11) + ((i15 + i17) * i10)) {
                throw new WriterException("Total bytes mismatch");
            }
            if (i9 < i11) {
                iArr[0] = i14;
                iArr2[0] = i16;
                return;
            } else {
                iArr[0] = i15;
                iArr2[0] = i17;
                return;
            }
        }
        throw new WriterException("Block ID too large");
    }

    static r a(r rVar, int i6, int i7, int i8) throws WriterException {
        if (rVar.f() == i7) {
            ArrayList arrayList = new ArrayList(i8);
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i9 < i8) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                int i13 = i6;
                int i14 = i7;
                int i15 = i8;
                a(i13, i14, i15, i9, iArr, iArr2);
                int i16 = iArr[0];
                byte[] bArr = new byte[i16];
                rVar.a(i10 * 8, bArr, 0, i16);
                byte[] a6 = a(bArr, iArr2[0]);
                arrayList.add(new y(bArr, a6));
                i12 = Math.max(i12, i16);
                i11 = Math.max(i11, a6.length);
                i10 += iArr[0];
                i9++;
                i6 = i13;
                i7 = i14;
                i8 = i15;
            }
            int i17 = i6;
            if (i7 == i10) {
                r rVar2 = new r();
                for (int i18 = 0; i18 < i12; i18++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] a7 = ((y) it.next()).a();
                        if (i18 < a7.length) {
                            rVar2.a(a7[i18], 8);
                        }
                    }
                }
                for (int i19 = 0; i19 < i11; i19++) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        byte[] b6 = ((y) it2.next()).b();
                        if (i19 < b6.length) {
                            rVar2.a(b6[i19], 8);
                        }
                    }
                }
                if (i17 == rVar2.f()) {
                    return rVar2;
                }
                throw new WriterException("Interleaving error: " + i17 + " and " + rVar2.f() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    static byte[] a(byte[] bArr, int i6) {
        int length = bArr.length;
        int[] iArr = new int[length + i6];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = bArr[i7] & 255;
        }
        new q6(o3.f34649l).a(iArr, i6);
        byte[] bArr2 = new byte[i6];
        for (int i8 = 0; i8 < i6; i8++) {
            bArr2[i8] = (byte) iArr[length + i8];
        }
        return bArr2;
    }

    static void a(u4 u4Var, r rVar) {
        rVar.a(u4Var.a(), 4);
    }

    static void a(int i6, b8 b8Var, u4 u4Var, r rVar) throws WriterException {
        int a6 = u4Var.a(b8Var);
        int i7 = 1 << a6;
        if (i6 < i7) {
            rVar.a(i6, a6);
            return;
        }
        throw new WriterException(i6 + " is bigger than " + (i7 - 1));
    }

    static void a(String str, u4 u4Var, r rVar, String str2) throws WriterException {
        int i6 = a.f34932a[u4Var.ordinal()];
        if (i6 == 1) {
            b(str, rVar);
            return;
        }
        if (i6 == 2) {
            a((CharSequence) str, rVar);
            return;
        }
        if (i6 == 3) {
            a(str, rVar, str2);
        } else {
            if (i6 == 4) {
                a(str, rVar);
                return;
            }
            throw new WriterException("Invalid mode: " + u4Var);
        }
    }

    static void a(CharSequence charSequence, r rVar) throws WriterException {
        int length = charSequence.length();
        int i6 = 0;
        while (i6 < length) {
            int a6 = a(charSequence.charAt(i6));
            if (a6 == -1) {
                throw new WriterException();
            }
            int i7 = i6 + 1;
            if (i7 < length) {
                int a7 = a(charSequence.charAt(i7));
                if (a7 != -1) {
                    rVar.a((a6 * 45) + a7, 11);
                    i6 += 2;
                } else {
                    throw new WriterException();
                }
            } else {
                rVar.a(a6, 6);
                i6 = i7;
            }
        }
    }

    static void a(String str, r rVar, String str2) throws WriterException {
        try {
            for (byte b6 : str.getBytes(str2)) {
                rVar.a(b6, 8);
            }
        } catch (UnsupportedEncodingException e6) {
            throw new WriterException(e6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[LOOP:0: B:4:0x0008->B:11:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(java.lang.String r6, com.huawei.hms.scankit.p.r r7) throws com.huawei.hms.hmsscankit.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L4d
            int r0 = r6.length
            r1 = 0
        L8:
            if (r1 >= r0) goto L4c
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L24
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L24
        L22:
            int r2 = r2 - r3
            goto L33
        L24:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L32
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L32
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L22
        L32:
            r2 = -1
        L33:
            if (r2 == r4) goto L44
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.a(r3, r2)
            int r1 = r1 + 2
            goto L8
        L44:
            com.huawei.hms.hmsscankit.WriterException r6 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L4c:
            return
        L4d:
            r6 = move-exception
            com.huawei.hms.hmsscankit.WriterException r7 = new com.huawei.hms.hmsscankit.WriterException
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w2.a(java.lang.String, com.huawei.hms.scankit.p.r):void");
    }

    private static void a(o0 o0Var, r rVar) {
        rVar.a(u4.ECI.a(), 4);
        rVar.a(o0Var.a(), 8);
    }
}
