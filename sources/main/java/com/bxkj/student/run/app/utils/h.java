package com.bxkj.student.run.app.utils;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private int f20220a;

    /* renamed from: b, reason: collision with root package name */
    private int f20221b;

    /* renamed from: c, reason: collision with root package name */
    private double f20222c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<k> f20223d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<k> f20224e = new ArrayList<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Comparator<k> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(k latLngPoint, k t12) {
            return latLngPoint.compareTo(t12);
        }
    }

    private ArrayList<k> b(k[] originalLatLngs, ArrayList<k> endLatLngs, int start, int end, double dMax) {
        k kVar = originalLatLngs[start];
        k kVar2 = originalLatLngs[end];
        double d6 = 0.0d;
        int i6 = 0;
        for (int i7 = start + 1; i7 < end; i7++) {
            double c6 = c(kVar, kVar2, originalLatLngs[i7]);
            if (c6 > d6) {
                i6 = i7;
                d6 = c6;
            }
        }
        if (d6 > dMax) {
            endLatLngs.add(originalLatLngs[i6]);
            int i8 = i6;
            b(originalLatLngs, endLatLngs, start, i8, dMax);
            b(originalLatLngs, endLatLngs, i8, end, dMax);
        }
        return endLatLngs;
    }

    private double c(k start, k end, k center) {
        double abs = Math.abs(AMapUtils.calculateLineDistance(start.f20284b, end.f20284b));
        double abs2 = Math.abs(AMapUtils.calculateLineDistance(start.f20284b, center.f20284b));
        double abs3 = Math.abs(AMapUtils.calculateLineDistance(center.f20284b, end.f20284b));
        double d6 = ((abs + abs2) + abs3) / 2.0d;
        return (Math.sqrt((((d6 - abs) * d6) * (d6 - abs2)) * (d6 - abs3)) * 2.0d) / abs;
    }

    public ArrayList<LatLng> a() {
        int size = this.f20223d.size();
        ArrayList<k> b6 = b((k[]) this.f20223d.toArray(new k[size]), this.f20224e, this.f20220a, this.f20221b, this.f20222c);
        b6.add(this.f20223d.get(0));
        b6.add(this.f20223d.get(size - 1));
        Collections.sort(b6, new a());
        ArrayList<LatLng> arrayList = new ArrayList<>();
        Iterator<k> it = b6.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f20284b);
        }
        return arrayList;
    }

    public h(ArrayList<LatLng> mLineInit, double dmax) {
        if (mLineInit != null) {
            this.f20222c = dmax;
            this.f20220a = 0;
            this.f20221b = mLineInit.size() - 1;
            for (int i6 = 0; i6 < mLineInit.size(); i6++) {
                this.f20223d.add(new k(i6, mLineInit.get(i6)));
            }
            return;
        }
        throw new IllegalArgumentException("传入的经纬度坐标list为空");
    }
}
