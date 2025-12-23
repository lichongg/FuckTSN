package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j4 extends g5 {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f34447c = {6, 8, 10, 12, 14};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f34448d = {1, 1, 1, 1};

    /* renamed from: e, reason: collision with root package name */
    private static final int[][] f34449e = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* renamed from: f, reason: collision with root package name */
    public static final int[][] f34450f = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a, reason: collision with root package name */
    private int f34451a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f34452b = -1;

    private int[] b(r rVar) throws a {
        int c6 = c(rVar);
        while (true) {
            int[] c7 = c(rVar, c6, f34448d);
            int i6 = c7[1];
            int i7 = c7[0];
            this.f34451a = (i6 - i7) / 4;
            if (a(rVar, i7)) {
                return c7;
            }
            c6 = c7[2];
        }
    }

    private static int c(r rVar) throws a {
        int e6 = rVar.e();
        int c6 = rVar.c(0);
        if (c6 != e6) {
            return c6;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i6, r rVar, Map<l1, ?> map) throws a, a {
        boolean z5;
        int[] b6 = b(rVar);
        int[] a6 = a(rVar);
        StringBuilder sb = new StringBuilder(20);
        a(rVar, b6[1], a6[0], sb);
        String sb2 = sb.toString();
        int[] iArr = f34447c;
        int length = sb2.length();
        int length2 = iArr.length;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i7 >= length2) {
                z5 = false;
                break;
            }
            int i9 = iArr[i7];
            if (length == i9) {
                z5 = true;
                break;
            }
            if (i9 > i8) {
                i8 = i9;
            }
            i7++;
        }
        if (!z5 && length > i8) {
            z5 = true;
        }
        if (!z5) {
            throw a.a();
        }
        float f6 = i6;
        return new s6(sb2, null, new u6[]{new u6(b6[0], f6), new u6(a6[1], f6)}, BarcodeFormat.ITF);
    }

    private int[] c(r rVar, int i6, int[] iArr) throws a {
        int i7;
        int i8;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int e6 = rVar.e();
        char c6 = 0;
        int i9 = i6;
        int i10 = i9;
        boolean z5 = false;
        int i11 = 0;
        while (i9 < e6) {
            if (rVar.b(i9) == z5) {
                if (i11 == length - 1) {
                    int[] iArr3 = (int[]) iArr2.clone();
                    Arrays.sort(iArr3);
                    int i12 = iArr3[c6];
                    double d6 = (iArr3[1] + i12) * 0.5d;
                    i8 = 1;
                    int i13 = iArr3[2];
                    int i14 = iArr3[3];
                    int i15 = i9;
                    if (((i13 + i14) * 0.5d) / d6 < 4.0d && (i14 * 1.0d) / i12 <= 3.0d) {
                        int[] iArr4 = new int[10];
                        g5.a(rVar, i15, iArr4);
                        this.f34452b = -1;
                        for (int i16 = 0; i16 < 10; i16++) {
                            int i17 = iArr4[i16];
                            if (i17 > this.f34452b) {
                                this.f34452b = i17;
                            }
                        }
                        return new int[]{i10, i15, iArr2[0] + i10 + iArr2[1]};
                    }
                    i7 = i15;
                    i10 += iArr2[0] + iArr2[1];
                    int i18 = i11 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i18);
                    iArr2[i18] = 0;
                    iArr2[i11] = 0;
                    i11--;
                } else {
                    i7 = i9;
                    i8 = 1;
                    i11++;
                }
                iArr2[i11] = i8;
                z5 = !z5;
            } else if (i11 >= 0 && i11 < length) {
                iArr2[i11] = iArr2[i11] + 1;
                i7 = i9;
            } else {
                throw a.a();
            }
            i9 = i7 + 1;
            c6 = 0;
        }
        throw a.a();
    }

    private int[] b(r rVar, int i6, int[] iArr) throws a {
        int i7;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int e6 = rVar.e();
        int i8 = i6;
        int i9 = i8;
        boolean z5 = false;
        int i10 = 0;
        while (i8 < e6) {
            if (rVar.b(i8) == z5) {
                if (i10 != length - 1) {
                    i7 = 1;
                    i10++;
                } else if (Math.min(iArr2[0], iArr2[1]) != 0 && Math.max(iArr2[0], iArr2[1]) != 0) {
                    float max = Math.max(iArr2[0], iArr2[1]) / Math.min(iArr2[0], iArr2[1]);
                    int i11 = iArr2[0];
                    int i12 = iArr2[1];
                    float f6 = (iArr2[2] * 2.0f) / (i11 + i12);
                    i7 = 1;
                    if (max <= 3.0f && f6 > 1.5d && f6 < 4.0f) {
                        return new int[]{i9, i8, i11 + i9 + i12};
                    }
                    i9 += i11 + i12;
                    int i13 = i10 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i13);
                    iArr2[i13] = 0;
                    iArr2[i10] = 0;
                    i10--;
                } else {
                    throw a.a();
                }
                iArr2[i10] = i7;
                z5 = !z5;
            } else if (i10 >= 0 && i10 < length) {
                iArr2[i10] = iArr2[i10] + 1;
            } else {
                throw a.a();
            }
            i8++;
        }
        throw a.a();
    }

    private static void a(r rVar, int i6, int i7, StringBuilder sb) throws a {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i6 < i7) {
            g5.a(rVar, i6, iArr);
            int i8 = -1;
            int i9 = 10000;
            for (int i10 = 0; i10 < 10; i10++) {
                int i11 = iArr[i10];
                if (i8 <= i11) {
                    i8 = i11;
                }
                if (i9 >= i11) {
                    i9 = i11;
                }
            }
            if (i8 / i9 <= 8) {
                for (int i12 = 0; i12 < 5; i12++) {
                    int i13 = i12 * 2;
                    iArr2[i12] = iArr[i13];
                    iArr3[i12] = iArr[i13 + 1];
                }
                sb.append((char) (b(iArr2) + 48));
                sb.append((char) (b(iArr3) + 48));
                for (int i14 = 0; i14 < 10; i14++) {
                    i6 += iArr[i14];
                }
            } else {
                throw a.a();
            }
        }
        if (i6 != i7) {
            throw a.a();
        }
    }

    private static int b(int[] iArr) throws a {
        int length = f34450f.length;
        float f6 = 0.3f;
        int i6 = -1;
        for (int i7 = 0; i7 < length; i7++) {
            float a6 = g5.a(iArr, f34450f[i7], 0.75f);
            if (a6 < f6) {
                i6 = i7;
                f6 = a6;
            } else if (Math.abs(a6 - f6) < 1.0E-7d) {
                i6 = -1;
            }
        }
        if (i6 >= 0) {
            return i6 % 10;
        }
        throw a.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.huawei.hms.scankit.p.r r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.f34451a
            int r0 = r0 * 10
            int r1 = r5.f34452b
            double r1 = (double) r1
            r3 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            double r1 = r1 * r3
            int r1 = (int) r1
            if (r0 >= r1) goto Lf
            r0 = r1
        Lf:
            r1 = 1
            int r7 = r7 - r1
        L11:
            if (r0 <= 0) goto L21
            if (r7 < 0) goto L21
            boolean r2 = r6.b(r7)
            if (r2 == 0) goto L1c
            goto L21
        L1c:
            int r0 = r0 + (-1)
            int r7 = r7 + (-1)
            goto L11
        L21:
            if (r0 == 0) goto L25
            r6 = 0
            return r6
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.j4.a(com.huawei.hms.scankit.p.r, int):boolean");
    }

    private int[] a(r rVar) throws a {
        try {
            rVar.h();
            int c6 = c(rVar);
            while (true) {
                int[] b6 = b(rVar, c6, f34449e[0]);
                if (a(rVar, b6[0])) {
                    int i6 = b6[0];
                    b6[0] = rVar.e() - b6[1];
                    b6[1] = rVar.e() - i6;
                    return b6;
                }
                c6 = b6[2];
            }
        } finally {
            rVar.h();
        }
    }
}
