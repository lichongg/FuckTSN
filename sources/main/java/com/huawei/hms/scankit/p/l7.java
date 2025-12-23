package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l7 extends q7 {

    /* renamed from: h, reason: collision with root package name */
    private final q7 f34531h = new o2();

    @Override // com.huawei.hms.scankit.p.q7
    public boolean a(int i6, int i7, r rVar) {
        return rVar.a(i7, (i7 - i6) + i7, false, false);
    }

    @Override // com.huawei.hms.scankit.p.q7
    public s6 a(int i6, r rVar, int[] iArr, Map<l1, ?> map) throws a {
        return a(this.f34531h.a(i6, rVar, iArr, map));
    }

    @Override // com.huawei.hms.scankit.p.q7, com.huawei.hms.scankit.p.g5
    public s6 a(int i6, r rVar, Map<l1, ?> map) throws a {
        return a(this.f34531h.a(i6, rVar, map));
    }

    @Override // com.huawei.hms.scankit.p.g5, com.huawei.hms.scankit.p.o6
    public s6 a(p pVar, Map<l1, ?> map) throws a {
        return a(this.f34531h.a(pVar, map));
    }

    @Override // com.huawei.hms.scankit.p.q7
    BarcodeFormat a() {
        return BarcodeFormat.UPC_A;
    }

    @Override // com.huawei.hms.scankit.p.q7
    protected int a(r rVar, int[] iArr, StringBuilder sb) throws a {
        return this.f34531h.a(rVar, iArr, sb);
    }

    private static s6 a(s6 s6Var) throws a {
        String k6 = s6Var.k();
        if (k6.charAt(0) == '0') {
            return new s6(k6.substring(1), null, s6Var.j(), BarcodeFormat.UPC_A);
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.q7
    boolean a(int[] iArr, int[] iArr2) throws a {
        int i6 = iArr2[1];
        int i7 = i6 - iArr2[0];
        int i8 = iArr[1];
        int i9 = iArr[0];
        return Math.abs(((int) Math.round(((double) (i6 - i9)) / (((double) (i7 + (i8 - i9))) / 6.0d))) + (-113)) <= 5;
    }
}
