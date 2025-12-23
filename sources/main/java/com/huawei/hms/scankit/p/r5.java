package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class r5 implements o6 {

    /* renamed from: a, reason: collision with root package name */
    private static final s6[] f34756a = new s6[0];

    private static int b(u6 u6Var, u6 u6Var2) {
        if (u6Var == null || u6Var2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(u6Var.b() - u6Var2.b());
    }

    @Override // com.huawei.hms.scankit.p.o6
    public s6 a(p pVar, Map<l1, ?> map) throws a {
        s6 s6Var;
        s6[] a6 = a(pVar, map, false);
        if (a6.length == 0 || (s6Var = a6[0]) == null) {
            throw a.a();
        }
        return s6Var;
    }

    private static int b(u6[] u6VarArr) {
        return Math.min(Math.min(b(u6VarArr[0], u6VarArr[4]), (b(u6VarArr[6], u6VarArr[2]) * 17) / 18), Math.min(b(u6VarArr[1], u6VarArr[5]), (b(u6VarArr[7], u6VarArr[3]) * 17) / 18));
    }

    private static s6[] a(p pVar, Map<l1, ?> map, boolean z5) throws a {
        ArrayList arrayList = new ArrayList();
        o5 a6 = f2.a(pVar, map, z5);
        for (u6[] u6VarArr : a6.b()) {
            w1 a7 = t5.a(a6.a(), u6VarArr[4], u6VarArr[5], u6VarArr[6], u6VarArr[7], b(u6VarArr), a(u6VarArr), map);
            if (f2.a()) {
                for (int i6 = 0; i6 < u6VarArr.length; i6++) {
                    if (u6VarArr[i6] != null) {
                        u6VarArr[i6] = new u6((pVar.e() - 1) - u6VarArr[i6].b(), (pVar.c() - 1) - u6VarArr[i6].c());
                    }
                }
            }
            if (u6VarArr.length == 8) {
                u6 u6Var = u6VarArr[0];
                if (u6Var == null && u6VarArr[1] == null && u6VarArr[4] == null && u6VarArr[5] == null) {
                    u6VarArr[0] = u6VarArr[6];
                    u6VarArr[1] = u6VarArr[7];
                    u6VarArr[4] = u6VarArr[2];
                    u6VarArr[5] = u6VarArr[3];
                } else if (u6VarArr[2] == null && u6VarArr[3] == null && u6VarArr[6] == null && u6VarArr[7] == null) {
                    u6VarArr[2] = u6VarArr[4];
                    u6VarArr[3] = u6VarArr[5];
                    u6VarArr[6] = u6Var;
                    u6VarArr[7] = u6VarArr[1];
                }
                arrayList.add(new s6(a7.d(), a7.c(), u6VarArr, BarcodeFormat.PDF_417));
            } else {
                throw a.a("pdf417 points size incorrect!");
            }
        }
        return (s6[]) arrayList.toArray(f34756a);
    }

    private static int a(u6 u6Var, u6 u6Var2) {
        if (u6Var == null || u6Var2 == null) {
            return 0;
        }
        return (int) Math.abs(u6Var.b() - u6Var2.b());
    }

    private static int a(u6[] u6VarArr) {
        return Math.max(Math.max(a(u6VarArr[0], u6VarArr[4]), (a(u6VarArr[6], u6VarArr[2]) * 17) / 18), Math.max(a(u6VarArr[1], u6VarArr[5]), (a(u6VarArr[7], u6VarArr[3]) * 17) / 18));
    }
}
