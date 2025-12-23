package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class z3 implements o6 {

    /* renamed from: a, reason: collision with root package name */
    private Map<l1, Object> f35070a = new EnumMap(l1.class);

    /* renamed from: b, reason: collision with root package name */
    private final u1 f35071b = new u1();

    private s6 a(int i6, e2 e2Var, Map<l1, ?> map) throws a {
        int i7 = 1;
        int max = Math.max(1, i6 - 2);
        int min = Math.min(6, i6 + 2);
        int max2 = Math.max(Math.abs(i6 - max), Math.abs(i6 - min));
        int i8 = 0;
        j2 j2Var = null;
        while (i8 <= max2 * 2) {
            i6 += i8 * i7;
            if (i6 >= max && i6 <= min) {
                try {
                    j2Var = e2Var.a(i6);
                    w1 a6 = this.f35071b.a(j2Var.a(), map);
                    if (a6.d() != null) {
                        return new s6(a6.d(), a6.c(), j2Var.d(), BarcodeFormat.HARMONY_CODE);
                    }
                    continue;
                } catch (a unused) {
                    continue;
                }
            }
            i8++;
            i7 *= -1;
        }
        if (j2Var == null || j2Var.d().length <= 3) {
            return null;
        }
        return new s6(null, null, j2Var.d(), BarcodeFormat.HARMONY_CODE);
    }

    private s6 a(int i6, int i7, g3[] g3VarArr, e2 e2Var, Map<l1, ?> map) throws a {
        float b6;
        float c6;
        float max;
        float max2;
        s6 a6;
        char c7 = 0;
        int i8 = 0;
        while (i8 <= i6 - 2) {
            int i9 = i8 + 1;
            int i10 = i9;
            while (i10 <= i6 - 1) {
                int i11 = i10 + 1;
                int i12 = i11;
                while (i12 <= i6) {
                    int i13 = i6;
                    while (i13 < i7) {
                        g3 g3Var = g3VarArr[i8];
                        g3 g3Var2 = g3VarArr[i10];
                        g3 g3Var3 = g3VarArr[i12];
                        g3[] g3VarArr2 = new g3[3];
                        g3VarArr2[c7] = g3Var;
                        g3VarArr2[1] = g3Var2;
                        g3VarArr2[2] = g3Var3;
                        u6.a(g3VarArr2);
                        g3 g3Var4 = g3VarArr[i13];
                        try {
                            b6 = (g3VarArr2[2].b() - g3VarArr2[1].b()) + g3VarArr2[c7].b();
                            c6 = (g3VarArr2[2].c() - g3VarArr2[1].c()) + g3VarArr2[c7].c();
                            try {
                                max = Math.max(Math.abs(g3VarArr2[1].b() - g3VarArr2[c7].b()), Math.abs(g3VarArr2[1].b() - g3VarArr2[2].b()));
                                max2 = Math.max(Math.abs(g3VarArr2[1].c() - g3VarArr2[0].c()), Math.abs(g3VarArr2[1].c() - g3VarArr2[2].c()));
                            } catch (a unused) {
                            }
                        } catch (a unused2) {
                        }
                        if (Math.abs(b6 - g3Var4.b()) < max / 2.0f && Math.abs(c6 - g3Var4.c()) < max2 / 2.0f) {
                            try {
                                a6 = a(e2Var.a(g3VarArr2, g3Var4), e2Var, map);
                            } catch (a unused3) {
                                continue;
                            }
                            if (a6 != null) {
                                return a6;
                            }
                            i13++;
                            c7 = 0;
                        }
                        i13++;
                        c7 = 0;
                    }
                    i12++;
                    c7 = 0;
                }
                i10 = i11;
            }
            i8 = i9;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.o6
    public s6 a(p pVar, Map<l1, ?> map) throws a {
        e2 e2Var = new e2(pVar.b());
        g3[] a6 = e2Var.a(map);
        int length = a6.length;
        if (length == 3) {
            u6.a(a6);
            s6 a7 = a(e2Var.a(a6, null), e2Var, map);
            if (a7 != null) {
                return a7;
            }
        } else {
            if (length == 4) {
                g3[] g3VarArr = new g3[3];
                for (int i6 = 0; i6 < 3; i6++) {
                    g3VarArr[i6] = a6[i6];
                }
                u6.a(g3VarArr);
                s6 a8 = a(e2Var.a(g3VarArr, a6[3]), e2Var, map);
                if (a8 != null) {
                    return a8;
                }
            } else {
                float e6 = ((a6[0].e() + a6[1].e()) + a6[2].e()) / 3.0f;
                float e7 = a6[length - 1].e();
                int i7 = length - 2;
                while (i7 > 2 && Math.abs(a6[i7].e() - e6) >= Math.abs(a6[i7].e() - e7)) {
                    e7 = (((r6 - 1) * e7) + a6[i7].e()) / (length - i7);
                    i7--;
                }
                return a(i7, length, a6, e2Var, map);
            }
        }
        throw a.a();
    }
}
