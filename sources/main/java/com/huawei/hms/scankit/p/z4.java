package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class z4 extends g5 {

    /* renamed from: b, reason: collision with root package name */
    private static final g5[] f35072b = new g5[0];

    /* renamed from: a, reason: collision with root package name */
    private final g5[] f35073a;

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i6, r rVar, Map<l1, ?> map) throws a {
        for (g5 g5Var : this.f35073a) {
            try {
                return g5Var.a(i6, rVar, map);
            } catch (a unused) {
            }
        }
        throw a.a();
    }

    public z4(Map<l1, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(l1.f34505c);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new b5(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new t0(false));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new v0());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new r0());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new j4());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new p0());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new b5(map));
            arrayList.add(new t0());
            arrayList.add(new p0());
            arrayList.add(new v0());
            arrayList.add(new r0());
            arrayList.add(new j4());
        }
        this.f35073a = (g5[]) arrayList.toArray(f35072b);
    }
}
