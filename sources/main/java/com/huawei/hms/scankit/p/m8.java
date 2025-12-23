package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class m8 implements o6 {

    /* renamed from: a, reason: collision with root package name */
    private Map<l1, Object> f34577a = new EnumMap(l1.class);

    @Override // com.huawei.hms.scankit.p.o6
    public s6 a(p pVar, Map<l1, ?> map) throws a {
        f3[] a6 = new h2(pVar.b()).a(map);
        int length = a6.length;
        s6 s6Var = null;
        if (length > 10) {
            return null;
        }
        int i6 = 3;
        if (length != 3) {
            int i7 = 0;
            while (i7 <= length - 3) {
                int i8 = i7 + 1;
                int i9 = i8;
                while (i9 <= length - 2) {
                    int i10 = i9 + 1;
                    int i11 = i10;
                    while (i11 <= length - 1) {
                        f3 f3Var = a6[i7];
                        f3 f3Var2 = a6[i9];
                        f3 f3Var3 = a6[i11];
                        s6 s6Var2 = s6Var;
                        f3[] f3VarArr = new f3[i6];
                        f3VarArr[0] = f3Var;
                        f3VarArr[1] = f3Var2;
                        f3VarArr[2] = f3Var3;
                        int[] iArr = {i7, i9, i11};
                        u6.a(f3VarArr);
                        if (h2.a(f3VarArr[0], f3VarArr[1], f3VarArr[2]) && !h2.a(f3VarArr, a6, iArr)) {
                            return a(a6[i7], a6[i9], a6[i11]);
                        }
                        i11++;
                        s6Var = s6Var2;
                        i6 = 3;
                    }
                    i9 = i10;
                }
                i7 = i8;
            }
        } else if (h2.a(a6[0], a6[1], a6[2])) {
            return a(a6[0], a6[1], a6[2]);
        }
        return s6Var;
    }

    private s6 a(f3 f3Var, f3 f3Var2, f3 f3Var3) {
        return new s6("WXCODE_TEXT", null, new u6[]{new u6(f3Var.b(), f3Var.c()), new u6(f3Var2.b(), f3Var2.c()), new u6(f3Var3.b(), f3Var3.c())}, BarcodeFormat.WXCODE);
    }
}
