package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class n1 {

    /* renamed from: a, reason: collision with root package name */
    private p4 f34579a;

    /* renamed from: b, reason: collision with root package name */
    private p f34580b;

    /* renamed from: c, reason: collision with root package name */
    private p f34581c;

    /* renamed from: d, reason: collision with root package name */
    private p f34582d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34583e;

    /* renamed from: g, reason: collision with root package name */
    private float f34585g;

    /* renamed from: f, reason: collision with root package name */
    private float f34584f = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f34586h = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    private float f34588j = 1.778f;

    /* renamed from: k, reason: collision with root package name */
    private int f34589k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f34590l = 0;

    /* renamed from: i, reason: collision with root package name */
    public m4 f34587i = new m4();

    static s6 a(List<i2> list, n1 n1Var) {
        for (i2 i2Var : list) {
            if (r3.f34731b || i2Var.h() > 0.4d) {
                int j6 = (int) i2Var.j();
                int k6 = (int) i2Var.k();
                if (j6 > n1Var.f34579a.c() / 3 && j6 < (n1Var.f34579a.c() * 2) / 3 && k6 > n1Var.f34579a.a() / 3 && k6 < (n1Var.f34579a.a() * 2) / 3) {
                    float c6 = n1Var.c(n1Var.f34582d);
                    s6 s6Var = new s6(1.0f);
                    s6Var.a(c6);
                    s6Var.a(i2Var);
                    return s6Var;
                }
            }
        }
        return null;
    }

    public s6 b(List<BarcodeFormat> list, i2 i2Var) {
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.f34505c, list);
        try {
            s6 b6 = i2Var != null ? a5Var.b(this.f34580b, this.f34581c, this.f34582d, hashMap, this.f34587i, i2Var) : a5Var.b(this.f34580b, this.f34581c, null, hashMap, this.f34587i, null);
            try {
                if (!r3.f34732c && b6 != null && b6.k() == null && b6.j() != null && b6.j().length >= 3) {
                    float b7 = o8.b(this.f34579a.c(), this.f34579a.a(), b6.j());
                    if (Math.abs(1.0f - b7) > 0.001d) {
                        this.f34586h = b7;
                        this.f34583e = true;
                    }
                }
                return b6;
            } catch (a unused) {
                return b6;
            }
        } catch (a unused2) {
            return null;
        }
    }

    public s6 c(List<BarcodeFormat> list, i2 i2Var) {
        i2 i2Var2;
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.f34505c, list);
        s6 s6Var = null;
        if (i2Var != null) {
            try {
                i2Var2 = i2Var;
                s6Var = a5Var.a(this.f34580b, this.f34581c, this.f34582d, hashMap, this.f34587i, i2Var2);
            } catch (a unused) {
            }
        } else {
            i2Var2 = i2Var;
        }
        if (!r3.f34732c && s6Var != null && s6Var.k() == null && s6Var.j() != null && s6Var.j().length >= 3) {
            float b6 = o8.b(this.f34579a.c(), this.f34579a.a(), new u6[]{new u6(i2Var2.d(), i2Var2.e()), new u6(i2Var2.d() + i2Var2.f(), i2Var2.e()), new u6(i2Var2.d(), i2Var2.e() + i2Var2.c())});
            if (Math.abs(1.0f - b6) > 0.001d) {
                this.f34586h = b6;
                this.f34583e = true;
            }
        }
        return s6Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00eb A[Catch: a -> 0x00f3, TRY_ENTER, TRY_LEAVE, TryCatch #2 {a -> 0x00f3, blocks: (B:11:0x0038, B:16:0x00eb, B:27:0x0056, B:29:0x0064, B:35:0x007e, B:37:0x0088, B:39:0x009a, B:42:0x0092), top: B:10:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0088 A[Catch: a -> 0x00f3, TryCatch #2 {a -> 0x00f3, blocks: (B:11:0x0038, B:16:0x00eb, B:27:0x0056, B:29:0x0064, B:35:0x007e, B:37:0x0088, B:39:0x009a, B:42:0x0092), top: B:10:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.s6 d(java.util.List<com.huawei.hms.scankit.aiscan.common.BarcodeFormat> r27, com.huawei.hms.scankit.p.i2 r28) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.d(java.util.List, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    public s6 e(List<BarcodeFormat> list, i2 i2Var) {
        HashMap hashMap = new HashMap();
        hashMap.put(l1.f34505c, list);
        if (i2Var == null) {
            s6 a6 = a(hashMap);
            if (a6 != null && a6.k() == null && r3.f34746q) {
                r3.f34742m = true;
                a6 = a(hashMap);
                r3.f34742m = false;
            }
            if (a6 == null || a6.k() != null || !r3.f34747r) {
                return a6;
            }
            r3.f34743n = true;
            s6 a7 = a(hashMap);
            r3.f34743n = false;
            return a7;
        }
        r3.f34741l = true;
        s6 a8 = a(hashMap, i2Var);
        r3.f34741l = false;
        if (a8 != null && a8.k() == null && r3.f34745p) {
            r3.f34742m = true;
            a8 = g(list, i2Var);
            r3.f34742m = false;
        }
        if (a8 != null && a8.k() == null && r3.f34746q) {
            r3.f34743n = true;
            a8 = a(hashMap, i2Var);
            r3.f34743n = false;
        }
        if ((a8 != null && a8.k() != null) || !r3.f34747r) {
            return a8;
        }
        r3.f34744o = true;
        s6 a9 = a(hashMap, i2Var);
        r3.f34744o = false;
        return a9;
    }

    public s6 f(List<BarcodeFormat> list, i2 i2Var) {
        float f6;
        p pVar;
        HashMap hashMap = new HashMap();
        hashMap.put(l1.f34505c, list);
        try {
            p4 c6 = i2Var != null ? this.f34582d.a().c() : this.f34579a;
            if (!r3.f34730a || (this.f34580b.e() <= 800 && this.f34580b.c() <= 800)) {
                f6 = 1.0f;
            } else {
                float e6 = (this.f34580b.e() > this.f34580b.c() ? this.f34580b.e() : this.f34580b.c()) / 800.0f;
                c6 = this.f34587i.h(new p(new q3(c6)), e6).a().c();
                f6 = e6;
            }
            p4 p4Var = c6;
            if (p4Var == null) {
                throw a.a();
            }
            if (!r3.f34730a || r3.f34731b) {
                pVar = new p(new q3(p4Var));
            } else {
                s a6 = a(p4Var.b(), p4Var.c(), p4Var.a(), false);
                pVar = new p(new q3(p4Var));
                pVar.a(a6);
            }
            a5 a5Var = new a5();
            try {
                s6 a7 = a5Var.a(pVar, hashMap);
                if (a7 == null || a7.k() == null) {
                    throw a.a();
                }
                k2.a(a7.j(), f6, i2Var);
                return a7;
            } catch (a unused) {
                return a(a5Var, p4Var, pVar, hashMap, f6, i2Var);
            }
        } catch (a unused2) {
            return null;
        }
    }

    public s6 g(List<BarcodeFormat> list, i2 i2Var) {
        p pVar;
        p pVar2;
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.f34505c, list);
        float f6 = 1.0f;
        if (i2Var == null) {
            if (!r3.f34730a || (this.f34580b.e() <= 500 && this.f34580b.c() <= 500)) {
                pVar = this.f34580b;
            } else {
                f6 = (this.f34580b.e() > this.f34580b.c() ? this.f34580b.e() : this.f34580b.c()) / 500.0f;
                pVar = this.f34587i.c(this.f34580b, f6);
            }
        } else if (!r3.f34730a || (pVar2 = this.f34582d) == null || (pVar2.e() <= 500 && this.f34582d.c() <= 500)) {
            pVar = this.f34582d;
        } else {
            f6 = (this.f34582d.e() > this.f34582d.c() ? this.f34582d.e() : this.f34582d.c()) / 500.0f;
            pVar = this.f34587i.g(this.f34582d, f6);
        }
        try {
            s6 a6 = a5Var.a(pVar, hashMap);
            if (a6 != null) {
                try {
                    if (a6.k() != null) {
                        k2.a(a6.j(), f6, i2Var);
                    }
                } catch (a unused) {
                    return a6;
                }
            }
            return a6;
        } catch (a unused2) {
            return null;
        }
    }

    public s6 h(List<BarcodeFormat> list, i2 i2Var) {
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.f34505c, list);
        s6 s6Var = null;
        if (i2Var != null) {
            try {
                s6Var = a5Var.c(this.f34582d, this.f34587i, hashMap, i2Var);
            } catch (a unused) {
            }
        }
        if (!r3.f34732c && s6Var != null && s6Var.k() == null && s6Var.j() != null && s6Var.j().length >= 3) {
            float b6 = o8.b(this.f34579a.c(), this.f34579a.a(), s6Var.j());
            if (Math.abs(1.0f - b6) > 0.001d) {
                this.f34586h = b6;
                this.f34583e = true;
            }
        }
        return s6Var;
    }

    n1(p4 p4Var) {
        this.f34583e = false;
        this.f34585g = 0.0f;
        this.f34579a = p4Var;
        this.f34580b = new p(new q3(this.f34579a));
        this.f34581c = new p(new e4(this.f34579a));
        this.f34583e = false;
        this.f34585g = 0.0f;
    }

    private p b(p pVar) {
        int e6 = pVar.e();
        int c6 = pVar.c();
        if (e6 < c6) {
            if (c6 / e6 <= 1.2d) {
                return pVar;
            }
            int i6 = (int) (e6 * 1.2d);
            int i7 = (c6 - i6) / 2;
            this.f34590l = i7;
            return pVar.a(0, i7, e6, i6);
        }
        if (e6 / c6 <= 1.2d) {
            return pVar;
        }
        int i8 = (int) (c6 * 1.2d);
        int i9 = (e6 - i8) / 2;
        this.f34589k = i9;
        return pVar.a(i9, 0, i8, c6);
    }

    public p a() {
        return this.f34580b;
    }

    static s6 a(n1 n1Var) {
        float c6 = n1Var.c(n1Var.f34580b);
        s6 s6Var = new s6(1.0f);
        s6Var.b(c6);
        s6Var.b(new i2(false, 0.0f, 0.0f, n1Var.f34580b.e(), n1Var.f34580b.e(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        return s6Var;
    }

    public float c(p pVar) {
        if (((pVar == null || (pVar.a() == null && pVar.a().c() == null)) ? null : pVar.a().c().b()) == null) {
            return 1.0f;
        }
        int e6 = pVar.e();
        int c6 = pVar.c();
        long j6 = 0;
        for (int i6 = c6 / 4; i6 < (c6 * 3) / 4; i6++) {
            for (int i7 = e6 / 4; i7 < (e6 * 3) / 4; i7++) {
                j6 += r0[(i6 * e6) + i7] & 255;
            }
        }
        return (j6 / r0.length) * 4;
    }

    public void b(i2 i2Var) {
        try {
            if (r3.f34730a) {
                k2.a(r3.f34731b, this.f34580b, i2Var);
                this.f34582d = i2Var.f34385l;
            }
        } catch (a unused) {
        }
    }

    public static boolean a(List<i2> list, boolean z5) {
        if (!z5 && !r3.f34731b) {
            float[] a6 = a(list.get(0));
            float a7 = a(a6);
            r3.f34754y = a6;
            if (a7 >= 0.6f) {
                r3.f34755z++;
            } else {
                r3.f34755z = 1;
            }
            o4.d("DecodeProcessor", "iou: " + a7 + " focusAreaFrameCount: " + r3.f34755z);
            if (r3.f34755z < 8) {
                return false;
            }
            o4.d("DecodeProcessor", "need area focus");
            r3.f34755z = 1;
            return true;
        }
        r3.f34754y = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        r3.f34755z = 0;
        return false;
    }

    public boolean b() {
        return this.f34583e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b0, code lost:
    
        if (a(r13.f34580b, r0) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b2, code lost:
    
        r1 = com.huawei.hms.scankit.p.r3.f34740k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b5, code lost:
    
        if (r1 <= 4) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b8, code lost:
    
        com.huawei.hms.scankit.p.r3.f34740k = r1 + 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(java.util.List<com.huawei.hms.scankit.p.i2> r14) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.b(java.util.List):boolean");
    }

    public float c() {
        return this.f34584f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e2, code lost:
    
        if (a(r17.f34580b, r2) != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e4, code lost:
    
        r3 = com.huawei.hms.scankit.p.r3.f34740k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e7, code lost:
    
        if (r3 <= 4) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ea, code lost:
    
        com.huawei.hms.scankit.p.r3.f34740k = r3 + 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(java.util.List<com.huawei.hms.scankit.p.i2> r18) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.c(java.util.List):boolean");
    }

    public float e() {
        return this.f34585g;
    }

    public float d() {
        return this.f34586h;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.s6 a(java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r12, com.huawei.hms.scankit.p.i2 r13) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.a(java.util.Map, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    static boolean b(p pVar, i2 i2Var) {
        if (r3.f34730a && !r3.f34731b) {
            float d6 = i2Var.d();
            float e6 = i2Var.e();
            float f6 = i2Var.f();
            float c6 = i2Var.c();
            float f7 = d6 - ((f6 * 0.2f) / 2.0f);
            if (f7 < 0.0f) {
                f7 = 0.0f;
            }
            float f8 = e6 - ((0.2f * c6) / 2.0f);
            float f9 = f8 >= 0.0f ? f8 : 0.0f;
            float f10 = (f6 * 1.2f) + f7;
            if (f10 > pVar.e()) {
                f10 = pVar.e();
            }
            float f11 = (c6 * 1.2f) + f9;
            if (f11 > pVar.c()) {
                f11 = pVar.c();
            }
            List<i2> a6 = k2.a(r3.f34731b, pVar.a((int) f7, (int) f9, (int) (f10 - f7), (int) (f11 - f9)), 0, true);
            if (!a6.isEmpty() && a6.get(0).g() == 6.0f) {
                return true;
            }
        }
        return false;
    }

    public static float a(float[] fArr) {
        float[] fArr2 = r3.f34754y;
        float f6 = fArr2[2] - fArr2[0];
        float f7 = fArr2[3];
        float f8 = fArr2[1];
        float f9 = f6 * (f7 - f8);
        if (f9 == 0.0d) {
            return 0.0f;
        }
        float f10 = fArr[2] - fArr[0];
        float f11 = fArr[3];
        float f12 = fArr[1];
        float f13 = f9 + (f10 * (f11 - f12));
        float max = Math.max(f8, f12);
        float min = Math.min(r3.f34754y[3], fArr[3]);
        float max2 = Math.max(r3.f34754y[0], fArr[0]);
        float min2 = Math.min(r3.f34754y[2], fArr[2]);
        if (max >= min || max2 >= min2) {
            return 0.0f;
        }
        float f14 = (min - max) * (min2 - max2);
        return (f14 / (f13 - f14)) * 1.0f;
    }

    public static float[] a(i2 i2Var) {
        return new float[]{i2Var.f34392s, i2Var.f34391r, r0 + i2Var.f34390q, r2 + i2Var.f34389p};
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x015c A[Catch: a -> 0x01e6, TRY_LEAVE, TryCatch #0 {a -> 0x01e6, blocks: (B:43:0x0112, B:45:0x015c, B:61:0x01af, B:63:0x01bc, B:65:0x01c2, B:67:0x01c7, B:69:0x01dd, B:71:0x01e1, B:72:0x01e5, B:48:0x0179, B:50:0x017f, B:52:0x0185, B:54:0x018a, B:56:0x01a3, B:58:0x01a7, B:59:0x01ab), top: B:42:0x0112, inners: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r21, com.huawei.hms.scankit.p.s6 r22, com.huawei.hms.scankit.p.s6 r23, com.huawei.hms.scankit.p.a5 r24, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r25, float r26, com.huawei.hms.scankit.p.i2 r27) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.s6, com.huawei.hms.scankit.p.s6, com.huawei.hms.scankit.p.a5, java.util.Map, float, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.s6 a(java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r13) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.a(java.util.Map):com.huawei.hms.scankit.p.s6");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.a5 r5, com.huawei.hms.scankit.p.p4 r6, com.huawei.hms.scankit.p.s6 r7, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r8, float r9, int r10, int r11) {
        /*
            r4 = this;
            boolean r0 = com.huawei.hms.scankit.p.r3.f34730a
            r1 = 0
            if (r0 == 0) goto L74
            r0 = 3
            com.huawei.hms.scankit.p.q3 r2 = new com.huawei.hms.scankit.p.q3     // Catch: com.huawei.hms.scankit.p.a -> L3c
            r2.<init>(r6)     // Catch: com.huawei.hms.scankit.p.a -> L3c
            com.huawei.hms.scankit.p.p r3 = new com.huawei.hms.scankit.p.p     // Catch: com.huawei.hms.scankit.p.a -> L3c
            r3.<init>(r2)     // Catch: com.huawei.hms.scankit.p.a -> L3c
            com.huawei.hms.scankit.p.s6 r1 = r5.a(r3, r8)     // Catch: com.huawei.hms.scankit.p.a -> L21
            if (r1 == 0) goto L23
            java.lang.String r2 = r1.k()     // Catch: com.huawei.hms.scankit.p.a -> L21
            if (r2 == 0) goto L23
            com.huawei.hms.scankit.p.s6 r5 = r4.a(r1, r9, r10, r11)     // Catch: com.huawei.hms.scankit.p.a -> L21
            return r5
        L21:
            goto L3a
        L23:
            if (r1 == 0) goto L3e
            com.huawei.hms.scankit.p.u6[] r2 = r1.j()     // Catch: com.huawei.hms.scankit.p.a -> L21
            if (r2 == 0) goto L3e
            com.huawei.hms.scankit.p.u6[] r2 = r1.j()     // Catch: com.huawei.hms.scankit.p.a -> L21
            int r2 = r2.length     // Catch: com.huawei.hms.scankit.p.a -> L21
            if (r2 < r0) goto L3e
            com.huawei.hms.scankit.p.u6[] r1 = r1.j()     // Catch: com.huawei.hms.scankit.p.a -> L21
            r7.b(r1)     // Catch: com.huawei.hms.scankit.p.a -> L21
            goto L3e
        L3a:
            r1 = r3
            goto L3d
        L3c:
        L3d:
            r3 = r1
        L3e:
            if (r7 == 0) goto L68
            com.huawei.hms.scankit.p.u6[] r1 = r7.j()     // Catch: com.huawei.hms.scankit.p.a -> L68
            if (r1 == 0) goto L68
            com.huawei.hms.scankit.p.u6[] r1 = r7.j()     // Catch: com.huawei.hms.scankit.p.a -> L68
            int r1 = r1.length     // Catch: com.huawei.hms.scankit.p.a -> L68
            if (r1 < r0) goto L68
            boolean r0 = com.huawei.hms.scankit.p.r3.f34742m     // Catch: com.huawei.hms.scankit.p.a -> L68
            if (r0 != 0) goto L68
            r0 = 6
            double[] r0 = new double[r0]     // Catch: com.huawei.hms.scankit.p.a -> L68
            r0 = {x0076: FILL_ARRAY_DATA , data: [0, 0, 0, 0, 0, 4607182418800017408} // fill-array     // Catch: com.huawei.hms.scankit.p.a -> L68
            com.huawei.hms.scankit.p.s6 r0 = r4.a(r3, r8, r7, r0)     // Catch: com.huawei.hms.scankit.p.a -> L68
            if (r0 == 0) goto L68
            java.lang.String r1 = r0.k()     // Catch: com.huawei.hms.scankit.p.a -> L68
            if (r1 == 0) goto L68
            com.huawei.hms.scankit.p.s6 r5 = r4.a(r0, r9, r10, r11)     // Catch: com.huawei.hms.scankit.p.a -> L68
            return r5
        L68:
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r3
            r7 = r5
            r5 = r4
            com.huawei.hms.scankit.p.s6 r6 = r5.a(r6, r7, r8, r9, r10, r11)
            return r6
        L74:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.a(com.huawei.hms.scankit.p.a5, com.huawei.hms.scankit.p.p4, com.huawei.hms.scankit.p.s6, java.util.Map, float, int, int):com.huawei.hms.scankit.p.s6");
    }

    private s6 a(p pVar, a5 a5Var, p4 p4Var, s6 s6Var, Map<l1, Object> map, float f6) {
        s6 s6Var2 = null;
        try {
            j6.a(this.f34579a, s6Var);
            if (r3.f34732c && r3.f34751v[1]) {
                r3.f34748s = true;
                s6Var2 = a5Var.a(this.f34580b, map);
                r3.f34748s = false;
                if (s6Var2 != null && s6Var2.k() != null) {
                    return a(s6Var2, f6, 0, 0);
                }
            }
        } catch (a unused) {
            r3.f34748s = false;
        }
        float e6 = pVar.e() / pVar.c();
        if (e6 < 1.0f) {
            e6 = 1.0f / e6;
        }
        if (!r3.f34742m && !r3.f34743n) {
            double d6 = e6;
            if (d6 > 1.27d && d6 < 1.272d) {
                r3.f34750u = true;
                try {
                    s6Var2 = a5Var.a(new p(new e4(p4Var)), map);
                    if (s6Var2 != null && s6Var2.k() != null) {
                        return a(s6Var2, f6, 0, 0);
                    }
                } catch (a unused2) {
                }
                r3.f34750u = false;
            }
        }
        return s6Var2;
    }

    private s6 a(a5 a5Var, p4 p4Var, p pVar, Map<l1, Object> map, float f6, i2 i2Var) throws a {
        p pVar2;
        s6 a6;
        p pVar3;
        s6 s6Var = null;
        if (r3.f34730a && !r3.f34731b) {
            try {
                pVar3 = new p(new q3(p4Var));
            } catch (a unused) {
            }
            try {
                s6Var = a5Var.a(pVar3, map);
                if (s6Var != null && s6Var.k() != null) {
                    k2.a(s6Var.j(), f6, i2Var);
                    return s6Var;
                }
            } catch (a unused2) {
                pVar = pVar3;
                pVar3 = pVar;
                if (s6Var != null) {
                    try {
                        s6Var = a(pVar3, map, s6Var, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d});
                        if (s6Var != null) {
                            k2.a(s6Var.j(), f6, i2Var);
                            return s6Var;
                        }
                    } catch (a unused3) {
                    }
                }
                pVar2 = new p(new e4(p4Var));
                a6 = a5Var.a(pVar2, map);
                if (a6 == null) {
                }
                throw a.a();
            }
            if (s6Var != null && s6Var.j() != null && s6Var.j().length >= 3) {
                s6Var = a(pVar3, map, s6Var, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d});
                if (s6Var != null && s6Var.k() != null) {
                    k2.a(s6Var.j(), f6, i2Var);
                    return s6Var;
                }
            }
        }
        pVar2 = new p(new e4(p4Var));
        try {
            a6 = a5Var.a(pVar2, map);
            if (a6 == null && a6.k() != null) {
                k2.a(a6.j(), f6, i2Var);
                return a6;
            }
            throw a.a();
        } catch (a unused4) {
            if (r3.f34730a && !r3.f34731b && s6Var != null && s6Var.j() != null && s6Var.j().length >= 3 && (s6Var = a(pVar2, map, s6Var, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d})) != null && s6Var.k() != null) {
                k2.a(s6Var.j(), f6, i2Var);
            }
            return s6Var;
        }
    }

    public s6 a(List<BarcodeFormat> list, i2 i2Var) {
        s6 s6Var;
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.f34505c, list);
        if (r3.f34732c) {
            hashMap.put(l1.f34506d, Boolean.valueOf(r3.f34732c));
        }
        try {
            if (i2Var != null) {
                try {
                    s6Var = a5Var.a(this.f34580b, this.f34582d, hashMap, this.f34587i, i2Var);
                    i2Var = i2Var;
                } catch (a unused) {
                    i2Var = i2Var;
                    s6Var = null;
                    return s6Var == null ? s6Var : s6Var;
                }
            } else {
                s6Var = a5Var.a(this.f34580b, (p) null, hashMap, this.f34587i, (i2) null);
            }
        } catch (a unused2) {
        }
        if (s6Var == null || r3.f34731b || i2Var == null || !r3.f34732c || i2Var.h() >= 0.8d) {
            return s6Var;
        }
        float i6 = i2Var.i() % 180.0f;
        boolean z5 = false;
        boolean z6 = ((double) i2Var.c()) > ((double) this.f34580b.c()) * 0.97d && ((i6 < 5.0f && i6 > -5.0f) || i6 < -175.0f || i6 > 175.0f);
        if (i2Var.b() > this.f34580b.e() * 0.97d && ((i6 < 95.0f && i6 > 85.0f) || (i6 < -85.0f && i6 > -95.0f))) {
            z5 = true;
        }
        if (!z6 && !z5) {
            return s6Var;
        }
        this.f34587i.a();
        try {
            return a5Var.a(this.f34580b, (p) null, hashMap, this.f34587i, (i2) null);
        } catch (a unused3) {
            return s6Var;
        }
    }

    public List<i2> a(int i6, boolean z5) {
        List<i2> a6;
        ArrayList arrayList = new ArrayList();
        if (!r3.f34730a) {
            return arrayList;
        }
        boolean z6 = r3.f34731b;
        if (!z6) {
            byte[] c6 = y4.c();
            byte[] a7 = y4.a();
            byte[] b6 = y4.b();
            LoadOpencvJNIUtil.setModel(c6, c6.length, a7, a7.length, b6, b6.length);
            p pVar = this.f34580b;
            long currentTimeMillis = System.currentTimeMillis() % 10;
            boolean z7 = currentTimeMillis % 2 == 0;
            boolean z8 = currentTimeMillis % 3 == 0;
            if (i6 == 0 && !r3.f34732c && z7) {
                pVar = b(this.f34580b);
            } else if (i6 == 0 && !r3.f34732c && z8) {
                pVar = a(b(this.f34580b));
            }
            a6 = k2.a(r3.f34731b, pVar, i6, z5);
        } else {
            a6 = k2.a(z6, this.f34580b, i6, z5);
        }
        a(a6);
        return a6;
    }

    private p a(p pVar) {
        int e6 = pVar.e();
        int c6 = pVar.c();
        int i6 = (int) (e6 * 0.75d);
        int i7 = (int) (c6 * 0.75d);
        int i8 = (e6 - i6) / 2;
        this.f34589k += i8;
        int i9 = (c6 - i7) / 2;
        this.f34590l += i9;
        return pVar.a(i8, i9, i6, i7);
    }

    private void a(List<i2> list) {
        for (i2 i2Var : list) {
            i2Var.a(this.f34579a.c(), this.f34579a.a(), this.f34589k, this.f34590l);
            float min = Math.min(Math.abs(i2Var.i() % 90.0f), 90.0f - Math.abs(i2Var.i() % 90.0f));
            if (i2Var.c() * i2Var.f() > this.f34579a.a() * 0.9f * this.f34579a.c() && min < 5.0f) {
                i2Var.b(this.f34579a.c(), this.f34579a.a());
            }
        }
    }

    private s6 a(p pVar, Map<l1, Object> map, s6 s6Var, double[] dArr) throws a {
        s6 s6Var2;
        if (pVar == null) {
            return null;
        }
        a5 a5Var = new a5();
        int[] iArr = {0, 0};
        byte[] a6 = k7.a(pVar, map, s6Var, iArr, dArr);
        int i6 = iArr[0];
        int i7 = iArr[1];
        e6 e6Var = new e6(a6, i6, i7, 0, 0, i6, i7, false);
        try {
            s6Var2 = a5Var.a(new p(new q3(e6Var)), map);
            if (s6Var2 != null) {
                try {
                    if (s6Var2.k() != null) {
                        u6[] a7 = k7.a(s6Var2.j(), pVar.e(), pVar.c(), dArr);
                        s6Var2.a();
                        s6Var2.b(a7);
                        return s6Var2;
                    }
                } catch (a unused) {
                    p pVar2 = new p(new e4(e6Var));
                    try {
                        s6 a8 = a5Var.a(pVar2, map);
                        if (a8 != null && a8.k() != null) {
                            u6[] a9 = k7.a(a8.j(), pVar.e(), pVar.c(), dArr);
                            a8.a();
                            a8.b(a9);
                            return a8;
                        }
                        throw a.a();
                    } catch (a unused2) {
                        pVar2.a(a(e6Var.b(), e6Var.c(), e6Var.a(), false));
                        try {
                            s6 a10 = a5Var.a(pVar2, map);
                            if (a10 != null && a10.k() != null) {
                                u6[] a11 = k7.a(a10.j(), pVar.e(), pVar.c(), dArr);
                                a10.a();
                                a10.b(a11);
                                return a10;
                            }
                            throw a.a();
                        } catch (a unused3) {
                            return s6Var2;
                        }
                    }
                }
            }
            throw a.a();
        } catch (a unused4) {
            s6Var2 = s6Var;
        }
    }

    private s6 a(s6 s6Var, float f6, int i6, int i7) {
        if (s6Var != null && s6Var.j().length == 4 && (Math.abs(f6 - 1.0f) >= 1.0E-6f || i6 != 0 || i7 != 0)) {
            u6[] u6VarArr = new u6[4];
            for (int i8 = 0; i8 < 4; i8++) {
                u6VarArr[i8] = new u6((s6Var.j()[i8].b() * f6) + i6, (s6Var.j()[i8].c() * f6) + i7);
            }
            s6Var.a();
            s6Var.a(u6VarArr);
        }
        return s6Var;
    }

    public static s a(byte[] bArr, int i6, int i7, boolean z5) throws a {
        int i8 = i6 / 11;
        byte[] adaptivebinary = LoadOpencvJNIUtil.adaptivebinary(bArr, i7, i6, (i8 + (i8 % 2)) - 1, z5);
        if (adaptivebinary != null) {
            s sVar = new s(i6, i7);
            for (int i9 = 0; i9 < i7; i9++) {
                for (int i10 = 0; i10 < i6; i10++) {
                    if (adaptivebinary[(i9 * i6) + i10] == 0) {
                        sVar.c(i10, i9);
                    }
                }
            }
            return sVar;
        }
        throw a.a();
    }

    public static p a(byte[] bArr, int i6, int i7) throws a {
        byte[] sharpen = LoadOpencvJNIUtil.sharpen(bArr, i7, i6);
        if (sharpen != null) {
            return new p(new e4(new e6(sharpen, i6, i7, 0, 0, i6, i7, false)));
        }
        throw a.a();
    }

    private static boolean a(p pVar, i2 i2Var) {
        if (r3.f34730a && !r3.f34731b) {
            float d6 = i2Var.d();
            float e6 = i2Var.e();
            float f6 = i2Var.f();
            float c6 = i2Var.c();
            float f7 = d6 - ((f6 * 0.2f) / 2.0f);
            if (f7 < 0.0f) {
                f7 = 0.0f;
            }
            float f8 = e6 - ((0.2f * c6) / 2.0f);
            float f9 = f8 >= 0.0f ? f8 : 0.0f;
            float f10 = (f6 * 1.2f) + f7;
            if (f10 > pVar.e()) {
                f10 = pVar.e();
            }
            float f11 = (c6 * 1.2f) + f9;
            if (f11 > pVar.c()) {
                f11 = pVar.c();
            }
            float f12 = f10 - f7;
            float f13 = f11 - f9;
            if (f12 < pVar.e() / 2.0f && f13 < pVar.c() / 2.0f) {
                for (i2 i2Var2 : k2.a(r3.f34731b, pVar.a((int) f7, (int) f9, (int) f12, (int) f13), 0, true)) {
                    boolean z5 = i2Var2.g() == 1.0f && ((double) i2Var2.h()) > 0.5d;
                    boolean z6 = i2Var.g() == 2.0f && i2Var2.g() == 2.0f && ((double) i2Var2.h()) > 0.7d;
                    boolean z7 = i2Var.g() == 3.0f && i2Var2.g() == 3.0f && ((double) i2Var2.h()) > 0.7d;
                    boolean z8 = i2Var.g() == 7.0f && i2Var2.g() == 7.0f && ((double) i2Var2.h()) > 0.7d;
                    boolean z9 = i2Var.g() == 6.0f && i2Var2.g() == 6.0f && ((double) i2Var2.h()) > 0.7d;
                    if (z5 || z6 || z7 || z8 || z9) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }
}
