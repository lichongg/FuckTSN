package com.amap.api.col.s;

import com.amap.api.col.s.n;
import com.amap.api.services.core.LatLonPoint;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class p extends o {

    /* renamed from: j, reason: collision with root package name */
    private double f8295j;

    @Override // com.amap.api.col.s.o
    protected final boolean f(LinkedHashMap<n.b, Object> linkedHashMap, n.b bVar) {
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.f8261b == null) {
                return super.f(linkedHashMap, bVar);
            }
            for (n.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && (str = bVar2.f8260a) != null && str.equals(bVar.f8260a)) {
                    Object obj = bVar2.f8261b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f8261b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.amap.api.col.s.o
    protected final Object g(LinkedHashMap<n.b, Object> linkedHashMap, n.b bVar) {
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.f8261b == null) {
                return super.g(linkedHashMap, bVar);
            }
            for (n.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && (str = bVar2.f8260a) != null && str.equals(bVar.f8260a)) {
                    Object obj = bVar2.f8261b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f8261b)) {
                        return linkedHashMap.get(bVar2);
                    }
                }
            }
        }
        return null;
    }

    @Override // com.amap.api.col.s.o
    protected final Object k(LinkedHashMap<n.b, Object> linkedHashMap, n.b bVar) {
        n.b bVar2;
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.f8261b == null) {
                return super.k(linkedHashMap, bVar);
            }
            Iterator<n.b> it = linkedHashMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    bVar2 = null;
                    break;
                }
                bVar2 = it.next();
                if (bVar2 != null && (str = bVar2.f8260a) != null && str.equals(bVar.f8260a)) {
                    Object obj = bVar2.f8261b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f8261b)) {
                        break;
                    }
                }
            }
            if (bVar2 != null) {
                return linkedHashMap.remove(bVar2);
            }
        }
        return null;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        LatLonPoint f8296a;

        /* renamed from: b, reason: collision with root package name */
        double f8297b;

        public final boolean a(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                LatLonPoint latLonPoint = this.f8296a;
                a aVar = (a) obj;
                if (latLonPoint == aVar.f8296a) {
                    return true;
                }
                if (latLonPoint != null && j4.b(latLonPoint, r3) <= aVar.f8297b) {
                    return true;
                }
            }
            return false;
        }

        public a(double d6, double d7, double d8) {
            this.f8296a = null;
            this.f8297b = 0.0d;
            this.f8296a = new LatLonPoint(d6, d7);
            this.f8297b = d8;
        }
    }

    public final double l() {
        return this.f8295j;
    }

    public p(String... strArr) {
        super(strArr);
        this.f8295j = 0.0d;
    }

    @Override // com.amap.api.col.s.o
    public final void c(n.a aVar) {
        super.c(aVar);
        if (aVar != null) {
            this.f8295j = aVar.h();
        }
    }
}
