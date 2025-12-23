package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class b5 extends g5 {

    /* renamed from: a, reason: collision with root package name */
    private final q7[] f34023a;

    public b5(Map<l1, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(l1.f34505c);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new o2());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new l7());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new q2());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new s7());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new o2());
            arrayList.add(new q2());
            arrayList.add(new s7());
        }
        this.f34023a = (q7[]) arrayList.toArray(new q7[arrayList.size()]);
    }

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i6, r rVar, Map<l1, ?> map) throws a {
        boolean z5;
        Collection collection;
        boolean z6;
        Iterator<int[]> it = q7.b(rVar).iterator();
        while (it.hasNext()) {
            int[] next = it.next();
            for (q7 q7Var : this.f34023a) {
                try {
                    s6 a6 = q7Var.a(i6, rVar, next, map);
                    if (a6.c() == BarcodeFormat.EAN_13 && a6.k().charAt(0) == '0') {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (map == null) {
                        collection = null;
                    } else {
                        collection = (Collection) map.get(l1.f34505c);
                    }
                    if (collection != null && !collection.contains(BarcodeFormat.UPC_A)) {
                        z6 = false;
                        if (!z5 && z6) {
                            return new s6(a6.k().substring(1), a6.i(), a6.j(), BarcodeFormat.UPC_A);
                        }
                        return a6;
                    }
                    z6 = true;
                    if (!z5) {
                    }
                    return a6;
                } catch (a unused) {
                }
            }
        }
        throw a.a();
    }
}
