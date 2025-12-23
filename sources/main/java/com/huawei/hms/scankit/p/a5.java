package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class a5 implements o6 {
    public static boolean a(s6 s6Var, float f6, float f7) {
        double abs = Math.abs(s6Var.j()[0].b() - s6Var.j()[1].b()) / f6;
        return (abs < 0.55d && ((double) f7) > 1.5d) || abs < 0.3d;
    }

    public s6 b(p pVar, p pVar2, p pVar3, Map<l1, ?> map, m4 m4Var, i2 i2Var) throws a {
        return pVar3 != null ? b(pVar3, m4Var, map, i2Var) : a(pVar, pVar2, m4Var, map);
    }

    @Override // com.huawei.hms.scankit.p.o6
    public s6 a(p pVar, Map<l1, ?> map) throws a {
        return a(pVar, a(map), map);
    }

    public s6 b(p pVar, m4 m4Var, Map<l1, ?> map, i2 i2Var) throws a {
        int e6 = pVar.e();
        int c6 = pVar.c();
        int i6 = e6 < c6 ? e6 : c6;
        float f6 = i6 * 1.0f;
        float f7 = f6 / 128.0f;
        if (f7 < 1.0f && r3.f34732c) {
            pVar = m4Var.e(pVar, f7);
        }
        p pVar2 = pVar;
        float f8 = f6 / 500.0f;
        float f9 = f8 >= 1.0f ? f8 : 1.0f;
        try {
            s6 a6 = a(m4Var.g(pVar2, f9), a(map), map);
            if (a6 != null && a6.k() != null) {
                k2.a(a6.j(), f9, i2Var);
                return a6;
            }
            if (!r3.f34732c && a6 != null && a6.k() == null && a6.j().length >= 3) {
            }
            throw a.a();
        } catch (a unused) {
            s6 a7 = a(i6, pVar2, m4Var, map, i2Var);
            if (a7 == null) {
                throw a.a();
            }
            if (0 != 0) {
                a7.a();
                a7.b((u6[]) null);
                k2.a(a7.j(), f9, i2Var);
            }
            return a7;
        }
    }

    public s6 c(p pVar, m4 m4Var, Map<l1, ?> map, i2 i2Var) throws a {
        s6 s6Var;
        int e6 = pVar.e();
        int c6 = pVar.c();
        if (e6 >= c6) {
            e6 = c6;
        }
        float f6 = (e6 * 1.0f) / 500.0f;
        p g6 = m4Var.g(pVar, f6);
        try {
            s6Var = a(g6, a(map), map);
            if (s6Var != null) {
                try {
                    if (s6Var.k() != null) {
                        k2.a(s6Var.j(), f6, i2Var);
                        return s6Var;
                    }
                } catch (a unused) {
                    try {
                        g6.a(n1.a(g6.d(), g6.e(), g6.c(), true));
                        s6 a6 = a(g6, a(map), map);
                        if (a6 != null && a6.k() != null) {
                            k2.a(a6.j(), f6, i2Var);
                            return a6;
                        }
                        throw a.a();
                    } catch (a unused2) {
                        if (s6Var != null) {
                            return s6Var;
                        }
                        throw a.a();
                    }
                }
            }
            throw a.a();
        } catch (a unused3) {
            s6Var = null;
        }
    }

    public o6[] a(Map<l1, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(l1.f34505c);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new z4(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new j6());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new h1());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new h());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new r5());
            }
            if (collection.contains(BarcodeFormat.HARMONY_CODE)) {
                arrayList.add(new z3());
            }
            if (collection.contains(BarcodeFormat.WXCODE)) {
                arrayList.add(new m8());
            }
        }
        return (o6[]) arrayList.toArray(new o6[arrayList.size()]);
    }

    private s6 a(p pVar, o6[] o6VarArr, Map<l1, ?> map) throws a {
        if (o6VarArr != null) {
            for (o6 o6Var : o6VarArr) {
                try {
                    s6 a6 = o6Var.a(pVar, map);
                    if (a6 != null && a6.j() != null) {
                        int i6 = 0;
                        for (u6 u6Var : a6.j()) {
                            if (u6Var != null) {
                                i6++;
                            }
                        }
                        if (i6 == 0 && a6.c() == BarcodeFormat.PDF_417) {
                            throw a.a();
                        }
                    }
                    return a6;
                } catch (a unused) {
                }
            }
        }
        throw a.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r10, com.huawei.hms.scankit.p.p r11, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r12, com.huawei.hms.scankit.p.m4 r13, com.huawei.hms.scankit.p.i2 r14) throws com.huawei.hms.scankit.p.a {
        /*
            r9 = this;
            com.huawei.hms.scankit.p.l1 r0 = com.huawei.hms.scankit.p.l1.f34506d
            boolean r0 = r12.containsKey(r0)
            r1 = 2
            float[] r6 = new float[r1]
            r6 = {x0068: FILL_ARRAY_DATA , data: [1065353216, 0} // fill-array
            r1 = 1
            r8 = 0
            if (r11 == 0) goto L1b
            r2 = r9
            r3 = r11
            r5 = r12
            r4 = r13
            r7 = r14
            com.huawei.hms.scankit.p.s6 r11 = r2.a(r3, r4, r5, r6, r7)
        L19:
            r12 = 0
            goto L34
        L1b:
            r2 = r9
            r5 = r12
            r4 = r13
            if (r0 != 0) goto L27
            boolean r11 = com.huawei.hms.scankit.p.r3.f34730a
            if (r11 != 0) goto L25
            goto L27
        L25:
            r11 = 0
            goto L19
        L27:
            com.huawei.hms.scankit.p.s6 r11 = r9.a(r10, r4, r5, r6)
            r12 = r6[r1]
            r13 = 1065353216(0x3f800000, float:1.0)
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r12 <= 0) goto L19
            r12 = 1
        L34:
            if (r11 == 0) goto L63
            if (r12 == 0) goto L62
            com.huawei.hms.scankit.p.u6[] r12 = r11.j()
            if (r12 == 0) goto L62
        L3e:
            int r13 = r12.length
            if (r8 >= r13) goto L62
            r13 = r12[r8]
            if (r13 == 0) goto L5f
            com.huawei.hms.scankit.p.u6 r13 = new com.huawei.hms.scankit.p.u6
            r14 = r12[r8]
            float r14 = r14.c()
            int r0 = r10.c()
            int r0 = r0 - r1
            float r0 = (float) r0
            r3 = r12[r8]
            float r3 = r3.b()
            float r0 = r0 - r3
            r13.<init>(r14, r0)
            r12[r8] = r13
        L5f:
            int r8 = r8 + 1
            goto L3e
        L62:
            return r11
        L63:
            com.huawei.hms.scankit.p.a r10 = com.huawei.hms.scankit.p.a.a()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a5.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.p, java.util.Map, com.huawei.hms.scankit.p.m4, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r11, com.huawei.hms.scankit.p.m4 r12, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r13, float[] r14, com.huawei.hms.scankit.p.i2 r15) throws com.huawei.hms.scankit.p.a {
        /*
            r10 = this;
            float r0 = r15.n()
            int r1 = r11.e()
            int r2 = r11.c()
            if (r1 >= r2) goto L13
            int r1 = r11.e()
            goto L17
        L13:
            int r1 = r11.c()
        L17:
            float r1 = (float) r1
            r2 = 1140457472(0x43fa0000, float:500.0)
            float r2 = r1 / r2
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L24
            r2 = 1065353216(0x3f800000, float:1.0)
        L24:
            com.huawei.hms.scankit.p.p r4 = r12.g(r11, r2)
            com.huawei.hms.scankit.p.o6[] r5 = r10.a(r13)
            float r6 = r15.a()
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L3f
            float r6 = r15.b()
            float r7 = r15.a()
            float r6 = r6 / r7
            goto L41
        L3f:
            r6 = 1065353216(0x3f800000, float:1.0)
        L41:
            r7 = 0
            com.huawei.hms.scankit.p.s6 r8 = r10.a(r4, r5, r13)     // Catch: com.huawei.hms.scankit.p.a -> L57
            float r9 = r0 / r2
            boolean r9 = a(r8, r9, r6)     // Catch: com.huawei.hms.scankit.p.a -> L54
            if (r9 != 0) goto L4f
            goto Lab
        L4f:
            com.huawei.hms.scankit.p.a r8 = com.huawei.hms.scankit.p.a.a()     // Catch: com.huawei.hms.scankit.p.a -> L57
            throw r8     // Catch: com.huawei.hms.scankit.p.a -> L57
        L54:
            r7 = r8
            goto L58
        L57:
        L58:
            boolean r8 = com.huawei.hms.scankit.p.r3.f34745p
            if (r8 == 0) goto Laa
            r2 = 1132068864(0x437a0000, float:250.0)
            float r1 = r1 / r2
            int r2 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r2 >= 0) goto L64
            goto L65
        L64:
            r3 = r1
        L65:
            com.huawei.hms.scankit.p.p r4 = r12.f(r11, r3)
            com.huawei.hms.scankit.p.l1 r11 = com.huawei.hms.scankit.p.l1.f34507e     // Catch: com.huawei.hms.scankit.p.a -> L8a
            r1 = 2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: com.huawei.hms.scankit.p.a -> L8a
            r13.put(r11, r1)     // Catch: com.huawei.hms.scankit.p.a -> L8a
            com.huawei.hms.scankit.p.p r11 = r12.e(r4)     // Catch: com.huawei.hms.scankit.p.a -> L8a
            com.huawei.hms.scankit.p.s6 r8 = r10.a(r11, r5, r13)     // Catch: com.huawei.hms.scankit.p.a -> L8a
            float r11 = r0 / r3
            boolean r11 = a(r8, r11, r6)     // Catch: com.huawei.hms.scankit.p.a -> L8a
            if (r11 != 0) goto L85
        L83:
            r2 = r3
            goto Lab
        L85:
            com.huawei.hms.scankit.p.a r11 = com.huawei.hms.scankit.p.a.a()     // Catch: com.huawei.hms.scankit.p.a -> L8a
            throw r11     // Catch: com.huawei.hms.scankit.p.a -> L8a
        L8a:
            com.huawei.hms.scankit.p.l1 r11 = com.huawei.hms.scankit.p.l1.f34507e
            r1 = 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13.put(r11, r1)
            com.huawei.hms.scankit.p.p r11 = r12.f(r4)
            com.huawei.hms.scankit.p.s6 r8 = r10.a(r11, r5, r13)
            float r0 = r0 / r3
            boolean r11 = a(r8, r0, r6)
            if (r11 != 0) goto La5
            goto L83
        La5:
            com.huawei.hms.scankit.p.a r11 = com.huawei.hms.scankit.p.a.a()
            throw r11
        Laa:
            r8 = r7
        Lab:
            r11 = 0
            r14[r11] = r2
            if (r8 == 0) goto Lb7
            com.huawei.hms.scankit.p.s r11 = r4.b()
            com.huawei.hms.scankit.p.k2.a(r11, r8, r2, r15)
        Lb7:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a5.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.m4, java.util.Map, float[], com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        r10 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.huawei.hms.scankit.p.m4] */
    /* JADX WARN: Type inference failed for: r10v10, types: [com.huawei.hms.scankit.p.s6] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v7, types: [com.huawei.hms.scankit.p.s6] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r9, com.huawei.hms.scankit.p.m4 r10, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r11, float[] r12) throws com.huawei.hms.scankit.p.a {
        /*
            r8 = this;
            int r0 = r9.c()
            int r1 = r9.e()
            int r0 = java.lang.Math.min(r0, r1)
            float r0 = (float) r0
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r1
            r2 = 1149698048(0x44870000, float:1080.0)
            float r0 = r0 / r2
            boolean r2 = com.huawei.hms.scankit.p.r3.f34730a
            if (r2 == 0) goto L1d
            com.huawei.hms.scankit.p.p r9 = r10.a(r9, r0)
            goto L29
        L1d:
            r2 = 1069547520(0x3fc00000, float:1.5)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L24
            r1 = r0
        L24:
            com.huawei.hms.scankit.p.p r9 = r10.a(r9, r1)
            r0 = r1
        L29:
            com.huawei.hms.scankit.p.o6[] r1 = r8.a(r11)
            boolean r2 = com.huawei.hms.scankit.p.r3.f34731b
            r3 = 0
            r4 = 0
            if (r2 != 0) goto L45
            boolean r2 = com.huawei.hms.scankit.p.r3.f34730a
            if (r2 == 0) goto L45
            com.huawei.hms.scankit.p.l1 r10 = com.huawei.hms.scankit.p.l1.f34507e
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r11.put(r10, r2)
            com.huawei.hms.scankit.p.s6 r10 = r8.a(r9, r1, r11)
            goto L81
        L45:
            r5 = r4
            r2 = 0
        L47:
            r6 = 2
            if (r2 >= r6) goto L5d
            r6 = 1
            if (r2 != r6) goto L5f
            com.huawei.hms.scankit.p.p r7 = com.huawei.hms.scankit.p.l4.a(r9)
            com.huawei.hms.scankit.p.p r7 = r10.c(r7)     // Catch: com.huawei.hms.scankit.p.a -> L7e
            com.huawei.hms.scankit.p.s6 r5 = r8.a(r7, r1, r11)     // Catch: com.huawei.hms.scankit.p.a -> L7e
            r7 = 1073741824(0x40000000, float:2.0)
            r12[r6] = r7     // Catch: com.huawei.hms.scankit.p.a -> L7e
        L5d:
            r10 = r5
            goto L81
        L5f:
            com.huawei.hms.scankit.p.p r7 = r10.b(r9)     // Catch: com.huawei.hms.scankit.p.a -> L68
            com.huawei.hms.scankit.p.s6 r10 = r8.a(r7, r1, r11)     // Catch: com.huawei.hms.scankit.p.a -> L68
            goto L81
        L68:
            boolean r7 = com.huawei.hms.scankit.p.r3.f34745p     // Catch: com.huawei.hms.scankit.p.a -> L7e
            if (r7 == 0) goto L7e
            com.huawei.hms.scankit.p.l1 r7 = com.huawei.hms.scankit.p.l1.f34507e     // Catch: com.huawei.hms.scankit.p.a -> L7e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: com.huawei.hms.scankit.p.a -> L7e
            r11.put(r7, r6)     // Catch: com.huawei.hms.scankit.p.a -> L7e
            com.huawei.hms.scankit.p.p r6 = r10.d(r9)     // Catch: com.huawei.hms.scankit.p.a -> L7e
            com.huawei.hms.scankit.p.s6 r10 = r8.a(r6, r1, r11)     // Catch: com.huawei.hms.scankit.p.a -> L7e
            goto L81
        L7e:
            int r2 = r2 + 1
            goto L47
        L81:
            if (r10 == 0) goto L8a
            com.huawei.hms.scankit.p.s r9 = r9.b()
            com.huawei.hms.scankit.p.k2.a(r9, r10, r0, r4)
        L8a:
            r12[r3] = r0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a5.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.m4, java.util.Map, float[]):com.huawei.hms.scankit.p.s6");
    }

    public s6 a(p pVar, p pVar2, p pVar3, Map<l1, ?> map, m4 m4Var, i2 i2Var) throws a {
        s6 a6 = pVar3 != null ? a(pVar3, m4Var, map, i2Var) : null;
        if (a6 != null) {
            return a6;
        }
        throw a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.huawei.hms.scankit.p.u6[]] */
    private s6 a(p pVar, m4 m4Var, Map<l1, ?> map, i2 i2Var) throws a {
        u6[] u6VarArr;
        boolean z5;
        s6 a6;
        int e6 = pVar.e();
        int c6 = pVar.c();
        if (e6 >= c6) {
            e6 = c6;
        }
        float f6 = (e6 * 1.0f) / 900.0f;
        p i6 = m4Var.i(pVar, f6);
        s6 s6Var = null;
        try {
            s6 a7 = a(i6, a(map), map);
            if (a7 != null) {
                try {
                    if (a7.k() != null) {
                        k2.a(a7.j(), f6, i2Var);
                        return a7;
                    }
                } catch (a unused) {
                    u6VarArr = null;
                    s6Var = a7;
                    z5 = false;
                    try {
                        i6.a(n1.a(i6.d(), i6.e(), i6.c(), false));
                        a6 = a(i6, a(map), map);
                        if (a6 == null) {
                        }
                        throw a.a();
                    } catch (a unused2) {
                        if (s6Var == null) {
                            throw a.a();
                        }
                        if (z5) {
                            s6Var.a();
                            s6Var.b(u6VarArr);
                            k2.a(s6Var.j(), f6, i2Var);
                        }
                        return s6Var;
                    }
                }
            }
            if (r3.f34732c || a7 == null || a7.k() != null || a7.j().length < 3) {
                z5 = false;
            } else {
                z5 = true;
                try {
                    s6Var = (u6[]) a7.j().clone();
                } catch (a unused3) {
                    u6VarArr = s6Var;
                    s6Var = a7;
                    i6.a(n1.a(i6.d(), i6.e(), i6.c(), false));
                    a6 = a(i6, a(map), map);
                    if (a6 == null && a6.k() != null) {
                        k2.a(a6.j(), f6, i2Var);
                        return a6;
                    }
                    throw a.a();
                }
            }
            throw a.a();
        } catch (a unused4) {
            u6VarArr = null;
        }
    }

    private s6 a(int i6, p pVar, m4 m4Var, Map<l1, ?> map, i2 i2Var) throws a {
        float f6 = (i6 * 1.0f) / 250.0f;
        if (f6 < 1.0f) {
            f6 = 1.0f;
        }
        p f7 = m4Var.f(pVar, f6);
        o6[] a6 = a(map);
        try {
            try {
                s6 a7 = a(m4Var.e(f7), a6, map);
                if (a7 != null && a7.k() != null) {
                    k2.a(a7.j(), f6, i2Var);
                    return a7;
                }
                throw a.a();
            } catch (a unused) {
                s6 a8 = a(new p(new e4(pVar.a().c())), a6, map);
                if (a8 != null && a8.k() != null) {
                    k2.a(a8.j(), 1.0f, i2Var);
                }
                return a8;
            }
        } catch (a unused2) {
            s6 a9 = a(m4Var.f(f7), a6, map);
            if (a9 != null && a9.k() != null) {
                k2.a(a9.j(), f6, i2Var);
                return a9;
            }
            throw a.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r10, com.huawei.hms.scankit.p.p r11, com.huawei.hms.scankit.p.m4 r12, java.util.Map<com.huawei.hms.scankit.p.l1, ?> r13) throws com.huawei.hms.scankit.p.a {
        /*
            r9 = this;
            int r0 = r10.e()
            int r1 = r10.c()
            if (r0 >= r1) goto Lc
            r3 = r0
            goto Ld
        Lc:
            r3 = r1
        Ld:
            float r0 = (float) r3
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r1
            r2 = 1149698048(0x44870000, float:1080.0)
            float r0 = r0 / r2
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 <= 0) goto L1a
            goto L1c
        L1a:
            r0 = 1065353216(0x3f800000, float:1.0)
        L1c:
            boolean r2 = com.huawei.hms.scankit.p.r3.f34730a
            if (r2 == 0) goto L25
            com.huawei.hms.scankit.p.p r1 = r12.a(r10, r0)
            goto L33
        L25:
            r2 = 1069547520(0x3fc00000, float:1.5)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L2c
            r1 = r0
        L2c:
            com.huawei.hms.scankit.p.p r0 = r12.a(r10, r1)
            r8 = r1
            r1 = r0
            r0 = r8
        L33:
            com.huawei.hms.scankit.p.o6[] r2 = r9.a(r13)
            r4 = 0
            r5 = 0
            com.huawei.hms.scankit.p.s6 r1 = r9.a(r1, r2, r13)     // Catch: com.huawei.hms.scankit.p.a -> L4d
            if (r1 == 0) goto L4f
            java.lang.String r2 = r1.k()     // Catch: com.huawei.hms.scankit.p.a -> L4d
            if (r2 == 0) goto L4f
            com.huawei.hms.scankit.p.u6[] r2 = r1.j()     // Catch: com.huawei.hms.scankit.p.a -> L4d
            com.huawei.hms.scankit.p.k2.a(r2, r0, r4)     // Catch: com.huawei.hms.scankit.p.a -> L4d
            return r1
        L4d:
            goto L86
        L4f:
            boolean r0 = com.huawei.hms.scankit.p.r3.f34732c     // Catch: com.huawei.hms.scankit.p.a -> L4d
            if (r0 != 0) goto L79
            if (r1 == 0) goto L79
            java.lang.String r0 = r1.k()     // Catch: com.huawei.hms.scankit.p.a -> L4d
            if (r0 != 0) goto L79
            com.huawei.hms.scankit.p.u6[] r0 = r1.j()     // Catch: com.huawei.hms.scankit.p.a -> L4d
            int r0 = r0.length     // Catch: com.huawei.hms.scankit.p.a -> L4d
            r2 = 3
            if (r0 < r2) goto L79
            r5 = 1
            com.huawei.hms.scankit.p.u6[] r0 = r1.j()     // Catch: com.huawei.hms.scankit.p.a -> L70
            java.lang.Object r0 = r0.clone()     // Catch: com.huawei.hms.scankit.p.a -> L70
            com.huawei.hms.scankit.p.u6[] r0 = (com.huawei.hms.scankit.p.u6[]) r0     // Catch: com.huawei.hms.scankit.p.a -> L70
            r4 = r0
            goto L79
        L70:
            r2 = r9
            r5 = r10
            r6 = r11
            r7 = r13
            r10 = r4
            r11 = 1
        L77:
            r4 = r12
            goto L8d
        L79:
            com.huawei.hms.scankit.p.a r0 = com.huawei.hms.scankit.p.a.a()     // Catch: com.huawei.hms.scankit.p.a -> L7e
            throw r0     // Catch: com.huawei.hms.scankit.p.a -> L7e
        L7e:
            r2 = r9
            r6 = r11
            r7 = r13
            r11 = r5
            r5 = r10
            r10 = r4
            goto L77
        L86:
            r2 = r9
            r5 = r10
            r6 = r11
            r7 = r13
            r10 = r4
            r11 = 0
            goto L77
        L8d:
            com.huawei.hms.scankit.p.s6 r12 = r2.a(r3, r4, r5, r6, r7)
            if (r12 == 0) goto L9c
            if (r11 == 0) goto L9b
            r12.a()
            r12.b(r10)
        L9b:
            return r12
        L9c:
            com.huawei.hms.scankit.p.a r10 = com.huawei.hms.scankit.p.a.a()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a5.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.m4, java.util.Map):com.huawei.hms.scankit.p.s6");
    }

    private s6 a(int i6, m4 m4Var, p pVar, p pVar2, Map<l1, ?> map) throws a {
        o6[] a6 = a(map);
        try {
            if (r3.f34730a) {
                float f6 = (i6 * 1.0f) / 500.0f;
                if (f6 <= 1.0f) {
                    f6 = 1.0f;
                }
                s6 a7 = a(m4Var.g(m4Var.g(pVar, f6)), a6, map);
                if (a7 != null && a7.k() != null) {
                    k2.a(a7.j(), f6, (i2) null);
                    return a7;
                }
            }
            throw a.a();
        } catch (a unused) {
            float f7 = (i6 * 1.0f) / 1080.0f;
            float f8 = f7 > 1.0f ? f7 : 1.0f;
            s6 a8 = a(m4Var.b(pVar2, f8), a6, map);
            if (a8 != null && a8.k() != null) {
                k2.a(a8.j(), f8, (i2) null);
            }
            return a8;
        }
    }
}
