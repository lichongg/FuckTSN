package com.huawei.hms.scankit.p;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f2 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f34257a = {0, 4, 1, 5};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f34258b = {6, 2, 7, 3};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f34259c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f34260d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* renamed from: e, reason: collision with root package name */
    private static boolean f34261e;

    public static o5 a(p pVar, Map<l1, ?> map, boolean z5) throws a {
        s b6 = pVar.b();
        a(false);
        List<u6[]> a6 = a(z5, b6);
        if (a6.isEmpty()) {
            b6 = b6.clone();
            b6.f();
            a6 = a(z5, b6);
            a(true);
        }
        return new o5(b6, a6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r4 != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        r3 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if (r3.hasNext() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        r4 = (com.huawei.hms.scankit.p.u6[]) r3.next();
        r7 = r4[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        if (r7 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        r2 = (int) java.lang.Math.max(r2, r7.c());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
    
        r4 = r4[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        if (r4 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        r2 = java.lang.Math.max(r2, (int) r4.c());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.huawei.hms.scankit.p.u6[]> a(boolean r8, com.huawei.hms.scankit.p.s r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = 0
        L7:
            r3 = 0
            r4 = 0
        L9:
            int r5 = r9.c()
            if (r2 >= r5) goto L78
            com.huawei.hms.scankit.p.u6[] r3 = a(r9, r2, r3)
            r5 = r3[r1]
            r6 = 1
            if (r5 != 0) goto L4f
            r5 = 3
            r7 = r3[r5]
            if (r7 != 0) goto L4f
            if (r4 != 0) goto L20
            goto L78
        L20:
            java.util.Iterator r3 = r0.iterator()
        L24:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L4c
            java.lang.Object r4 = r3.next()
            com.huawei.hms.scankit.p.u6[] r4 = (com.huawei.hms.scankit.p.u6[]) r4
            r7 = r4[r6]
            if (r7 == 0) goto L3e
            float r2 = (float) r2
            float r7 = r7.c()
            float r2 = java.lang.Math.max(r2, r7)
            int r2 = (int) r2
        L3e:
            r4 = r4[r5]
            if (r4 == 0) goto L24
            float r4 = r4.c()
            int r4 = (int) r4
            int r2 = java.lang.Math.max(r2, r4)
            goto L24
        L4c:
            int r2 = r2 + 5
            goto L7
        L4f:
            r0.add(r3)
            if (r8 != 0) goto L55
            goto L78
        L55:
            r2 = 2
            r4 = r3[r2]
            if (r4 == 0) goto L69
            float r4 = r4.b()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.c()
        L65:
            int r2 = (int) r2
            r3 = r4
            r4 = 1
            goto L9
        L69:
            r2 = 4
            r4 = r3[r2]
            float r4 = r4.b()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.c()
            goto L65
        L78:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.f2.a(boolean, com.huawei.hms.scankit.p.s):java.util.List");
    }

    private static u6[] a(s sVar, int i6, int i7) {
        int c6 = sVar.c();
        int e6 = sVar.e();
        u6[] u6VarArr = new u6[8];
        int i8 = i6;
        int i9 = i7;
        a(u6VarArr, a(sVar, c6, e6, i8, i9, f34259c), f34257a);
        u6 u6Var = u6VarArr[4];
        if (u6Var != null) {
            int b6 = (int) u6Var.b();
            i8 = (int) u6VarArr[4].c();
            i9 = b6;
        }
        a(u6VarArr, a(sVar, c6, e6, i8, i9, f34260d), f34258b);
        return u6VarArr;
    }

    private static void a(u6[] u6VarArr, u6[] u6VarArr2, int[] iArr) {
        for (int i6 = 0; i6 < iArr.length; i6++) {
            u6VarArr[iArr[i6]] = u6VarArr2[i6];
        }
    }

    private static u6[] a(s sVar, int i6, int i7, int i8, int i9, int[] iArr) {
        int i10;
        boolean z5;
        int[] iArr2;
        u6[] u6VarArr = new u6[4];
        int[] iArr3 = iArr;
        int[] iArr4 = new int[iArr3.length];
        int i11 = i8;
        while (true) {
            if (i11 >= i6) {
                i10 = i11;
                z5 = false;
                break;
            }
            int[] a6 = a(sVar, i9, i11, i7, false, iArr3, iArr4);
            if (a6 != null) {
                do {
                    i10 = i11;
                    iArr2 = a6;
                    if (i10 <= 0) {
                        break;
                    }
                    i11 = i10 - 1;
                    a6 = a(sVar, i9, i11, i7, false, iArr, iArr4);
                } while (a6 != null);
                float f6 = i10;
                u6VarArr[0] = new u6(iArr2[0], f6);
                u6VarArr[1] = new u6(iArr2[1], f6);
                z5 = true;
            } else {
                i11 += 5;
                iArr3 = iArr;
            }
        }
        int i12 = i10 + 1;
        if (z5) {
            int[] iArr5 = {(int) u6VarArr[0].b(), (int) u6VarArr[1].b()};
            int i13 = i12;
            int i14 = 0;
            while (i13 < i6) {
                int[] a7 = a(sVar, iArr5[0], i13, i7, false, iArr, iArr4);
                if (a7 != null && Math.abs(iArr5[0] - a7[0]) < 5 && Math.abs(iArr5[1] - a7[1]) < 5) {
                    iArr5 = a7;
                    i14 = 0;
                } else {
                    if (i14 > 25) {
                        break;
                    }
                    i14++;
                }
                i13++;
            }
            i12 = i13 - (i14 + 1);
            float f7 = i12;
            u6VarArr[2] = new u6(iArr5[0], f7);
            u6VarArr[3] = new u6(iArr5[1], f7);
        }
        if (i12 - i10 < 10) {
            Arrays.fill(u6VarArr, (Object) null);
        }
        return u6VarArr;
    }

    private static int[] a(s sVar, int i6, int i7, int i8, boolean z5, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i9 = 0;
        while (sVar.b(i6, i7) && i6 > 0) {
            int i10 = i9 + 1;
            if (i9 >= 3) {
                break;
            }
            i6--;
            i9 = i10;
        }
        int length = iArr.length;
        boolean z6 = z5;
        int i11 = 0;
        int i12 = i6;
        while (i6 < i8) {
            if (sVar.b(i6, i7) != z6) {
                iArr2[i11] = iArr2[i11] + 1;
            } else {
                if (i11 != length - 1) {
                    i11++;
                } else {
                    if (a(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i12, i6};
                    }
                    i12 += iArr2[0] + iArr2[1];
                    int i13 = i11 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i13);
                    iArr2[i13] = 0;
                    iArr2[i11] = 0;
                    i11--;
                }
                iArr2[i11] = 1;
                z6 = !z6;
            }
            i6++;
        }
        if (i11 != length - 1 || a(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i12, i6 - 1};
    }

    private static float a(int[] iArr, int[] iArr2, float f6) {
        int length = iArr.length;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            i6 += iArr[i8];
            i7 += iArr2[i8];
        }
        if (i6 < i7) {
            return Float.POSITIVE_INFINITY;
        }
        float f7 = i6;
        float f8 = f7 / i7;
        float f9 = f6 * f8;
        float f10 = 0.0f;
        for (int i9 = 0; i9 < length; i9++) {
            float f11 = iArr2[i9] * f8;
            float f12 = iArr[i9];
            float f13 = f12 > f11 ? f12 - f11 : f11 - f12;
            if (f13 > f9) {
                return Float.POSITIVE_INFINITY;
            }
            f10 += f13;
        }
        return f10 / f7;
    }

    public static void a(boolean z5) {
        f34261e = z5;
    }

    public static boolean a() {
        return f34261e;
    }
}
