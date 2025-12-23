package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h1 implements o6 {

    /* renamed from: b, reason: collision with root package name */
    private static final u6[] f34331b = new u6[0];

    /* renamed from: a, reason: collision with root package name */
    private final t1 f34332a = new t1();

    @Override // com.huawei.hms.scankit.p.o6
    public s6 a(p pVar, Map<l1, ?> map) throws a {
        j2 a6 = new d2(pVar.b()).a();
        try {
            w1 a7 = this.f34332a.a(a6.a(), map);
            return new s6(a7.d(), a7.c(), a6.d(), BarcodeFormat.DATA_MATRIX);
        } catch (a e6) {
            if (a6.d() == null || r3.f34732c) {
                throw e6;
            }
            double sqrt = Math.sqrt(Math.pow(a6.d()[0].b() - a6.d()[1].b(), 2.0d) + Math.pow(a6.d()[0].c() - a6.d()[1].c(), 2.0d));
            double sqrt2 = Math.sqrt(Math.pow(a6.d()[0].b() - a6.d()[3].b(), 2.0d) + Math.pow(a6.d()[0].c() - a6.d()[3].c(), 2.0d));
            if (this.f34332a.a() == null || Math.abs(sqrt - sqrt2) / sqrt >= 0.1d) {
                throw e6;
            }
            return new s6(null, null, a6.d(), BarcodeFormat.DATA_MATRIX);
        }
    }
}
