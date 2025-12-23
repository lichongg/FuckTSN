package com.huawei.hms.scankit.p;

import java.util.Arrays;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class g5 implements o6 {
    public abstract s6 a(int i6, r rVar, Map<l1, ?> map) throws a;

    @Override // com.huawei.hms.scankit.p.o6
    public s6 a(p pVar, Map<l1, ?> map) throws a {
        return b(pVar, map);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r10, com.huawei.hms.scankit.p.r r11, java.util.Map<com.huawei.hms.scankit.p.l1, ?> r12, int r13, int r14) throws com.huawei.hms.scankit.p.a {
        /*
            r9 = this;
            r0 = 0
        L1:
            r1 = 3
            if (r0 >= r1) goto L58
            r2 = 1
            if (r0 != 0) goto Ld
            com.huawei.hms.scankit.p.r r11 = r10.a(r13, r11)     // Catch: com.huawei.hms.scankit.p.a -> L21
        Lb:
            r4 = r11
            goto L2a
        Ld:
            if (r0 != r2) goto L1a
            com.huawei.hms.scankit.p.s r1 = r10.b()
            com.huawei.hms.scankit.p.r r11 = r1.a(r13, r11)
            r4 = r11
            r1 = 1
            goto L2a
        L1a:
            r3 = 2
            if (r0 != r3) goto Lb
            boolean r3 = com.huawei.hms.scankit.p.r3.f34749t
            if (r3 != 0) goto L25
        L21:
            r6 = r12
            r7 = r13
            r8 = r14
            goto L52
        L25:
            com.huawei.hms.scankit.p.r r11 = r10.a(r13, r2)
            goto Lb
        L2a:
            int[] r11 = r4.d()
            boolean r11 = a(r11)
            if (r11 != 0) goto L38
            r6 = r12
            r7 = r13
            r8 = r14
            goto L51
        L38:
            boolean r11 = com.huawei.hms.scankit.p.r3.f34732c
            if (r11 != 0) goto L42
            r5 = 1
        L3d:
            r3 = r9
            r6 = r12
            r7 = r13
            r8 = r14
            goto L44
        L42:
            r5 = r1
            goto L3d
        L44:
            com.huawei.hms.scankit.p.s6 r11 = r3.a(r4, r5, r6, r7, r8)
            if (r11 == 0) goto L51
            java.lang.String r12 = r11.k()
            if (r12 == 0) goto L51
            return r11
        L51:
            r11 = r4
        L52:
            int r0 = r0 + 1
            r12 = r6
            r13 = r7
            r14 = r8
            goto L1
        L58:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.g5.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.r, java.util.Map, int, int):com.huawei.hms.scankit.p.s6");
    }

    private s6 b(p pVar, Map<l1, ?> map) throws a {
        int e6 = pVar.e();
        int c6 = pVar.c();
        r rVar = new r(e6);
        int max = Math.max(1, c6 >> 5);
        int i6 = c6 / 2;
        if (map != null) {
            l1 l1Var = l1.f34507e;
            if (map.containsKey(l1Var)) {
                i6 += (((Integer) map.get(l1Var)).intValue() * max) / 3;
            }
        }
        int i7 = i6;
        int i8 = 0;
        while (i8 < 15) {
            int i9 = i8 + 1;
            int i10 = i9 / 2;
            if ((i8 & 1) != 0) {
                i10 = -i10;
            }
            int i11 = i7 + (i10 * max);
            if (i11 < 0 || i11 >= c6) {
                break;
            }
            p pVar2 = pVar;
            Map<l1, ?> map2 = map;
            s6 a6 = a(pVar2, rVar, map2, i11, e6);
            if (a6 != null && a6.k() != null) {
                return a6;
            }
            pVar = pVar2;
            map = map2;
            i8 = i9;
        }
        throw a.a();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(2:14|(2:16|(6:18|19|20|(1:42)(4:24|25|26|27)|28|(2:33|34)(2:30|31))))|45|19|20|(1:22)|42|28|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0098 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.r r20, int r21, java.util.Map<com.huawei.hms.scankit.p.l1, ?> r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r24
            r1 = 0
            r3 = r21
            r2 = r22
            r4 = 0
        L8:
            if (r4 >= r3) goto Lb0
            if (r4 != 0) goto Lf
            r20.c()
        Lf:
            r5 = 1
            if (r4 != r5) goto L15
            r20.i()
        L15:
            r6 = 2
            if (r4 != r6) goto L1e
            r20.g()
            r20.j()
        L1e:
            r7 = 0
        L1f:
            if (r7 >= r6) goto La3
            if (r7 != r5) goto L45
            r20.h()
            if (r2 == 0) goto L45
            com.huawei.hms.scankit.p.l1 r8 = com.huawei.hms.scankit.p.l1.f34512j
            boolean r9 = r2.containsKey(r8)
            if (r9 == 0) goto L45
            java.util.EnumMap r9 = new java.util.EnumMap
            java.lang.Class<com.huawei.hms.scankit.p.l1> r10 = com.huawei.hms.scankit.p.l1.class
            r9.<init>(r10)
            r9.putAll(r2)
            r9.remove(r8)
            r2 = r9
            r8 = r19
            r10 = r23
            r9 = r20
            goto L4b
        L45:
            r8 = r19
            r9 = r20
            r10 = r23
        L4b:
            com.huawei.hms.scankit.p.s6 r11 = r8.a(r10, r9, r2)     // Catch: com.huawei.hms.scankit.p.a -> L8c
            if (r7 != r5) goto L8f
            com.huawei.hms.scankit.p.u6[] r12 = r11.j()     // Catch: com.huawei.hms.scankit.p.a -> L8c
            if (r12 == 0) goto L8f
            com.huawei.hms.scankit.p.u6 r13 = new com.huawei.hms.scankit.p.u6     // Catch: com.huawei.hms.scankit.p.a -> L8c
            float r14 = (float) r0     // Catch: com.huawei.hms.scankit.p.a -> L8c
            r15 = r12[r1]     // Catch: com.huawei.hms.scankit.p.a -> L8c
            float r15 = r15.b()     // Catch: com.huawei.hms.scankit.p.a -> L8c
            float r15 = r14 - r15
            r16 = 1065353216(0x3f800000, float:1.0)
            float r15 = r15 - r16
            r17 = r12[r1]     // Catch: com.huawei.hms.scankit.p.a -> L8c
            r18 = 0
            float r1 = r17.c()     // Catch: com.huawei.hms.scankit.p.a -> L8a
            r13.<init>(r15, r1)     // Catch: com.huawei.hms.scankit.p.a -> L8a
            r12[r18] = r13     // Catch: com.huawei.hms.scankit.p.a -> L8a
            com.huawei.hms.scankit.p.u6 r1 = new com.huawei.hms.scankit.p.u6     // Catch: com.huawei.hms.scankit.p.a -> L8a
            r13 = r12[r5]     // Catch: com.huawei.hms.scankit.p.a -> L8a
            float r13 = r13.b()     // Catch: com.huawei.hms.scankit.p.a -> L8a
            float r14 = r14 - r13
            float r14 = r14 - r16
            r13 = r12[r5]     // Catch: com.huawei.hms.scankit.p.a -> L8a
            float r13 = r13.c()     // Catch: com.huawei.hms.scankit.p.a -> L8a
            r1.<init>(r14, r13)     // Catch: com.huawei.hms.scankit.p.a -> L8a
            r12[r5] = r1     // Catch: com.huawei.hms.scankit.p.a -> L8a
            goto L91
        L8a:
            goto L99
        L8c:
            r18 = 0
            goto L8a
        L8f:
            r18 = 0
        L91:
            boolean r1 = a(r11, r0)     // Catch: com.huawei.hms.scankit.p.a -> L8a
            if (r1 != 0) goto L98
            goto L9e
        L98:
            return r11
        L99:
            if (r7 != r5) goto L9e
            r9.h()
        L9e:
            int r7 = r7 + 1
            r1 = 0
            goto L1f
        La3:
            r8 = r19
            r9 = r20
            r10 = r23
            r18 = 0
            int r4 = r4 + 1
            r1 = 0
            goto L8
        Lb0:
            r8 = r19
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.g5.a(com.huawei.hms.scankit.p.r, int, java.util.Map, int, int):com.huawei.hms.scankit.p.s6");
    }

    private static boolean a(int[] iArr) {
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < iArr.length && i6 < 20; i8++) {
            int i9 = iArr[i8];
            i6 += Integer.bitCount((i7 | (i9 << 1)) ^ i9);
            i7 = (iArr[i8] >> 31) & 1;
        }
        return i6 >= 20;
    }

    private static boolean a(s6 s6Var, int i6) {
        u6[] j6 = s6Var.j();
        return Math.abs(((double) j6[1].b()) - ((double) j6[0].b())) / ((double) i6) > 0.4d;
    }

    protected static void a(r rVar, int i6, int[] iArr) throws a {
        int length = iArr.length;
        int i7 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int e6 = rVar.e();
        if (i6 < e6) {
            boolean z5 = !rVar.b(i6);
            while (i6 < e6) {
                if (rVar.b(i6) == z5) {
                    i7++;
                    if (i7 == length) {
                        break;
                    }
                    if (i7 >= 0 && i7 < iArr.length) {
                        iArr[i7] = 1;
                        z5 = !z5;
                    } else {
                        throw a.a();
                    }
                } else if (i7 >= 0 && i7 < iArr.length) {
                    iArr[i7] = iArr[i7] + 1;
                } else {
                    throw a.a();
                }
                i6++;
            }
            if (i7 != length) {
                if (i7 != length - 1 || i6 != e6) {
                    throw a.a();
                }
                return;
            }
            return;
        }
        throw a.a();
    }

    protected static float a(int[] iArr, int[] iArr2, float f6) {
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
}
