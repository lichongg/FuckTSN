package com.amap.api.maps.model;

import com.amap.api.col.p0003l.l2;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final l2 f8986a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8987b;

    /* renamed from: c, reason: collision with root package name */
    private List<WeightedLatLng> f8988c;

    /* renamed from: d, reason: collision with root package name */
    private List<a> f8989d;

    protected a(l2 l2Var) {
        this(l2Var, 0);
    }

    protected final void a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.f8986a.a(point.f9903x, point.f9904y)) {
            a(point.f9903x, point.f9904y, weightedLatLng);
        }
    }

    private a(double d6, double d7, double d8, double d9, int i6) {
        this(new l2(d6, d7, d8, d9), i6);
    }

    private a(l2 l2Var, int i6) {
        this.f8989d = null;
        this.f8986a = l2Var;
        this.f8987b = i6;
    }

    private void a(double d6, double d7, WeightedLatLng weightedLatLng) {
        List<a> list = this.f8989d;
        if (list != null) {
            l2 l2Var = this.f8986a;
            if (d7 < l2Var.f6733f) {
                if (d6 < l2Var.f6732e) {
                    list.get(0).a(d6, d7, weightedLatLng);
                    return;
                } else {
                    list.get(1).a(d6, d7, weightedLatLng);
                    return;
                }
            }
            if (d6 < l2Var.f6732e) {
                list.get(2).a(d6, d7, weightedLatLng);
                return;
            } else {
                list.get(3).a(d6, d7, weightedLatLng);
                return;
            }
        }
        if (this.f8988c == null) {
            this.f8988c = new ArrayList();
        }
        this.f8988c.add(weightedLatLng);
        if (this.f8988c.size() <= 50 || this.f8987b >= 40) {
            return;
        }
        a();
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.f8989d = arrayList;
        l2 l2Var = this.f8986a;
        arrayList.add(new a(l2Var.f6728a, l2Var.f6732e, l2Var.f6729b, l2Var.f6733f, this.f8987b + 1));
        List<a> list = this.f8989d;
        l2 l2Var2 = this.f8986a;
        list.add(new a(l2Var2.f6732e, l2Var2.f6730c, l2Var2.f6729b, l2Var2.f6733f, this.f8987b + 1));
        List<a> list2 = this.f8989d;
        l2 l2Var3 = this.f8986a;
        list2.add(new a(l2Var3.f6728a, l2Var3.f6732e, l2Var3.f6733f, l2Var3.f6731d, this.f8987b + 1));
        List<a> list3 = this.f8989d;
        l2 l2Var4 = this.f8986a;
        list3.add(new a(l2Var4.f6732e, l2Var4.f6730c, l2Var4.f6733f, l2Var4.f6731d, this.f8987b + 1));
        List<WeightedLatLng> list4 = this.f8988c;
        this.f8988c = null;
        for (WeightedLatLng weightedLatLng : list4) {
            a(weightedLatLng.getPoint().f9903x, weightedLatLng.getPoint().f9904y, weightedLatLng);
        }
    }

    protected final Collection<WeightedLatLng> a(l2 l2Var) {
        ArrayList arrayList = new ArrayList();
        a(l2Var, arrayList);
        return arrayList;
    }

    private void a(l2 l2Var, Collection<WeightedLatLng> collection) {
        if (this.f8986a.c(l2Var)) {
            List<a> list = this.f8989d;
            if (list != null) {
                Iterator<a> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(l2Var, collection);
                }
            } else if (this.f8988c != null) {
                if (l2Var.e(this.f8986a)) {
                    collection.addAll(this.f8988c);
                    return;
                }
                for (WeightedLatLng weightedLatLng : this.f8988c) {
                    if (l2Var.d(weightedLatLng.getPoint())) {
                        collection.add(weightedLatLng);
                    }
                }
            }
        }
    }
}
