package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class t5 {

    /* renamed from: a, reason: collision with root package name */
    private static final a3 f34835a = new a3();

    private static boolean a(int i6, int i7, int i8) {
        return i7 + (-2) <= i6 && i6 <= i8 + 2;
    }

    private static z1 b(b2 b2Var, b2 b2Var2) throws a {
        k a6;
        if ((b2Var == null && b2Var2 == null) || (a6 = a(b2Var, b2Var2)) == null) {
            return null;
        }
        return new z1(a6, a0.a(a(b2Var), a(b2Var2)));
    }

    private static int c(int i6) {
        return 2 << i6;
    }

    public static w1 a(s sVar, u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4, int i6, int i7, Map<l1, ?> map) throws a {
        b2 b2Var;
        a0 a0Var;
        int i8;
        int i9;
        b2 b2Var2;
        s sVar2;
        z1 b6;
        a0 a0Var2 = new a0(sVar, u6Var, u6Var2, u6Var3, u6Var4);
        u6 u6Var5 = u6Var;
        b2 b2Var3 = null;
        a0 a0Var3 = a0Var2;
        boolean z5 = true;
        b2 b2Var4 = null;
        while (true) {
            if (u6Var5 != null) {
                a0Var = a0Var3;
                i8 = i6;
                i9 = i7;
                b2Var = a(sVar, a0Var, u6Var5, true, i8, i9);
            } else {
                a0 a0Var4 = a0Var3;
                b2Var = b2Var3;
                a0Var = a0Var4;
                i8 = i6;
                i9 = i7;
            }
            u6 u6Var6 = u6Var5;
            b2Var2 = b2Var;
            if (u6Var3 != null) {
                b2Var4 = a(sVar, a0Var, u6Var3, false, i8, i9);
            }
            u6Var5 = u6Var6;
            i7 = i9;
            i6 = i8;
            sVar2 = sVar;
            b6 = b(b2Var2, b2Var4);
            if (b6 == null) {
                throw a.a();
            }
            a0Var3 = b6.i();
            if (!z5 || a0Var3 == null || (a0Var3.f() >= a0Var.f() && a0Var3.d() <= a0Var.d())) {
                break;
            }
            sVar = sVar2;
            b2Var3 = b2Var2;
            z5 = false;
        }
        b6.a(a0Var);
        int f6 = b6.f() + 1;
        b6.a(0, b2Var2);
        b6.a(f6, b2Var4);
        a(b6, b2Var2, a0Var, f6, sVar2, i6, i7);
        return a(b6, map);
    }

    private static int b(int[] iArr) {
        int i6 = -1;
        for (int i7 : iArr) {
            i6 = Math.max(i6, i7);
        }
        return i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027 A[EDGE_INSN: B:17:0x0027->B:18:0x0027 BREAK  A[LOOP:0: B:5:0x000c->B:13:0x000c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] b(com.huawei.hms.scankit.p.s r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = 1
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.b(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.t5.b(com.huawei.hms.scankit.p.s, int, int, boolean, int, int):int[]");
    }

    private static int b(int i6) {
        return a(a(i6));
    }

    private static void a(z1 z1Var, b2 b2Var, a0 a0Var, int i6, s sVar, int i7, int i8) {
        a2 b2Var2;
        int i9;
        boolean z5 = b2Var != null;
        int i10 = i7;
        int i11 = i8;
        for (int i12 = 1; i12 <= i6; i12++) {
            int i13 = z5 ? i12 : i6 - i12;
            if (z1Var.a(i13) == null) {
                if (i13 != 0 && i13 != i6) {
                    b2Var2 = new a2(a0Var);
                } else {
                    b2Var2 = new b2(a0Var, i13 == 0);
                }
                a2 a2Var = b2Var2;
                z1Var.a(i13, a2Var);
                int i14 = -1;
                int i15 = i10;
                int i16 = i11;
                int f6 = a0Var.f();
                int i17 = -1;
                while (f6 <= a0Var.d()) {
                    int a6 = a(z1Var, i13, f6, z5);
                    if (a6 < 0 || a6 > a0Var.c()) {
                        if (i17 == i14) {
                            i9 = i17;
                            i17 = i9;
                            f6++;
                            i14 = -1;
                        } else {
                            a6 = i17;
                        }
                    }
                    int i18 = a6;
                    i9 = i17;
                    x0 a7 = a(sVar, a0Var.e(), a0Var.c(), z5, i18, f6, i15, i16);
                    if (a7 != null) {
                        a2Var.a(f6, a7);
                        i15 = Math.min(i15, a7.f());
                        i16 = Math.max(i16, a7.f());
                        i17 = i18;
                        f6++;
                        i14 = -1;
                    }
                    i17 = i9;
                    f6++;
                    i14 = -1;
                }
                i10 = i15;
                i11 = i16;
            }
        }
    }

    private static a0 a(b2 b2Var) throws a {
        int[] d6;
        if (b2Var == null || (d6 = b2Var.d()) == null) {
            return null;
        }
        int b6 = b(d6);
        int i6 = 0;
        int i7 = 0;
        for (int i8 : d6) {
            i7 += b6 - i8;
            if (i8 > 0) {
                break;
            }
        }
        x0[] b7 = b2Var.b();
        for (int i9 = 0; i7 > 0 && b7[i9] == null; i9++) {
            i7--;
        }
        for (int length = d6.length - 1; length >= 0; length--) {
            int i10 = d6[length];
            i6 += b6 - i10;
            if (i10 > 0) {
                break;
            }
        }
        for (int length2 = b7.length - 1; i6 > 0 && b7[length2] == null; length2--) {
            i6--;
        }
        return b2Var.a().a(i7, i6, b2Var.e());
    }

    private static k a(b2 b2Var, b2 b2Var2) throws a {
        k c6;
        k c7;
        if (b2Var == null || (c6 = b2Var.c()) == null) {
            if (b2Var2 == null) {
                return null;
            }
            return b2Var2.c();
        }
        if (b2Var2 == null || (c7 = b2Var2.c()) == null || c6.a() == c7.a() || c6.b() == c7.b() || c6.c() == c7.c()) {
            return c6;
        }
        return null;
    }

    private static b2 a(s sVar, a0 a0Var, u6 u6Var, boolean z5, int i6, int i7) {
        int b6;
        b2 b2Var = new b2(a0Var, z5);
        int i8 = 0;
        while (i8 < 2) {
            int i9 = i8 == 0 ? 1 : -1;
            int b7 = (int) u6Var.b();
            for (int c6 = (int) u6Var.c(); c6 <= a0Var.d() && c6 >= a0Var.f(); c6 += i9) {
                x0 a6 = a(sVar, 0, sVar.e(), z5, b7, c6, i6, i7);
                if (a6 != null) {
                    b2Var.a(c6, a6);
                    if (z5) {
                        b6 = a6.d();
                    } else {
                        b6 = a6.b();
                    }
                    b7 = b6;
                }
            }
            i8++;
        }
        return b2Var;
    }

    private static void a(z1 z1Var, m[][] mVarArr) throws a {
        m mVar = mVarArr[0][1];
        int[] a6 = mVar.a();
        int f6 = (z1Var.f() * z1Var.h()) - c(z1Var.g());
        if (a6.length != 0) {
            if (a6[0] != f6) {
                mVar.a(f6);
            }
        } else {
            if (f6 >= 1 && f6 <= 928) {
                mVar.a(f6);
                return;
            }
            throw a.a();
        }
    }

    private static w1 a(z1 z1Var, Map<l1, ?> map) throws a {
        m[][] a6 = a(z1Var);
        a(z1Var, a6);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[z1Var.h() * z1Var.f()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i6 = 0; i6 < z1Var.h(); i6++) {
            int i7 = 0;
            while (i7 < z1Var.f()) {
                int i8 = i7 + 1;
                int[] a7 = a6[i6][i8].a();
                int f6 = (z1Var.f() * i6) + i7;
                if (a7.length == 0) {
                    arrayList.add(Integer.valueOf(f6));
                } else if (a7.length == 1) {
                    iArr[f6] = a7[0];
                } else {
                    arrayList3.add(Integer.valueOf(f6));
                    arrayList2.add(a7);
                }
                i7 = i8;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i9 = 0; i9 < size; i9++) {
            iArr2[i9] = (int[]) arrayList2.get(i9);
        }
        return a(z1Var.g(), iArr, n5.a(arrayList), n5.a(arrayList3), iArr2, map);
    }

    private static w1 a(int i6, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4, Map<l1, ?> map) throws a {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i7 = 100;
        while (true) {
            int i8 = i7 - 1;
            if (i7 > 0) {
                for (int i9 = 0; i9 < length; i9++) {
                    iArr[iArr3[i9]] = iArr4[i9][iArr5[i9]];
                }
                try {
                    return a(iArr, i6, iArr2, map);
                } catch (a unused) {
                    if (length == 0) {
                        throw a.a();
                    }
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            break;
                        }
                        int i11 = iArr5[i10];
                        if (i11 < iArr4[i10].length - 1) {
                            iArr5[i10] = i11 + 1;
                            break;
                        }
                        iArr5[i10] = 0;
                        if (i10 == length - 1) {
                            throw a.a();
                        }
                        i10++;
                    }
                    i7 = i8;
                }
            } else {
                throw a.a();
            }
        }
    }

    private static m[][] a(z1 z1Var) throws a {
        int c6;
        m[][] mVarArr = (m[][]) Array.newInstance((Class<?>) m.class, z1Var.h(), z1Var.f() + 2);
        for (m[] mVarArr2 : mVarArr) {
            int i6 = 0;
            while (true) {
                if (i6 < mVarArr2.length) {
                    mVarArr2[i6] = new m();
                    i6++;
                }
            }
        }
        int i7 = 0;
        for (a2 a2Var : z1Var.j()) {
            if (a2Var != null) {
                for (x0 x0Var : a2Var.b()) {
                    if (x0Var != null && (c6 = x0Var.c()) >= 0 && c6 < mVarArr.length) {
                        mVarArr[c6][i7].a(x0Var.e());
                    }
                }
            }
            i7++;
        }
        return mVarArr;
    }

    private static boolean a(z1 z1Var, int i6) {
        return i6 >= 0 && i6 <= z1Var.f() + 1;
    }

    private static int a(z1 z1Var, int i6, int i7, boolean z5) {
        int i8 = z5 ? 1 : -1;
        int i9 = i6 - i8;
        x0 a6 = a(z1Var, i9) ? z1Var.a(i9).a(i7) : null;
        if (a6 != null) {
            return z5 ? a6.b() : a6.d();
        }
        x0 b6 = z1Var.a(i6).b(i7);
        if (b6 != null) {
            return z5 ? b6.d() : b6.b();
        }
        if (a(z1Var, i9)) {
            b6 = z1Var.a(i9).b(i7);
        }
        if (b6 != null) {
            return z5 ? b6.b() : b6.d();
        }
        int i10 = 0;
        while (true) {
            i6 -= i8;
            if (!a(z1Var, i6)) {
                return z5 ? z1Var.i().e() : z1Var.i().c();
            }
            for (x0 x0Var : z1Var.a(i6).b()) {
                if (x0Var != null) {
                    return (z5 ? x0Var.b() : x0Var.d()) + (i8 * i10 * (x0Var.b() - x0Var.d()));
                }
            }
            i10++;
        }
    }

    private static x0 a(s sVar, int i6, int i7, boolean z5, int i8, int i9, int i10, int i11) {
        int i12;
        int d6;
        int a6;
        int a7 = a(sVar, i6, i7, z5, i8, i9);
        int[] b6 = b(sVar, i6, i7, z5, a7, i9);
        if (b6 == null) {
            return null;
        }
        int a8 = s4.a(b6);
        if (z5) {
            i12 = a7 + a8;
        } else {
            for (int i13 = 0; i13 < b6.length / 2; i13++) {
                int i14 = b6[i13];
                b6[i13] = b6[(b6.length - 1) - i13];
                b6[(b6.length - 1) - i13] = i14;
            }
            a7 -= a8;
            i12 = a7;
        }
        if (a(a8, i10, i11) && (a6 = n5.a((d6 = m5.d(b6)))) != -1) {
            return new x0(a7, i12, b(d6), a6);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.huawei.hms.scankit.p.s r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.b(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.t5.a(com.huawei.hms.scankit.p.s, int, int, boolean, int, int):int");
    }

    private static w1 a(int[] iArr, int i6, int[] iArr2, Map<l1, ?> map) throws a, a {
        if (iArr.length != 0) {
            int i7 = 1 << (i6 + 1);
            int a6 = a(iArr, iArr2, i7);
            a(iArr, i7);
            w1 a7 = q1.a(iArr, String.valueOf(i6), map);
            a7.b(Integer.valueOf(a6));
            a7.a(Integer.valueOf(iArr2.length));
            return a7;
        }
        throw a.a();
    }

    private static int a(int[] iArr, int[] iArr2, int i6) throws a {
        if ((iArr2 == null || iArr2.length <= (i6 / 2) + 3) && i6 >= 0 && i6 <= 512) {
            return f34835a.a(iArr, i6, iArr2);
        }
        throw a.a();
    }

    private static void a(int[] iArr, int i6) throws a {
        if (iArr.length >= 4) {
            int i7 = iArr[0];
            if (i7 > iArr.length) {
                throw a.a();
            }
            if (i7 == 0) {
                if (i6 < iArr.length) {
                    iArr[0] = iArr.length - i6;
                    return;
                }
                throw a.a();
            }
            return;
        }
        throw a.a();
    }

    private static int[] a(int i6) {
        int[] iArr = new int[8];
        int i7 = 0;
        int i8 = 7;
        while (true) {
            int i9 = i6 & 1;
            if (i9 != i7) {
                i8--;
                if (i8 < 0) {
                    return iArr;
                }
                i7 = i9;
            }
            iArr[i8] = iArr[i8] + 1;
            i6 >>= 1;
        }
    }

    private static int a(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
