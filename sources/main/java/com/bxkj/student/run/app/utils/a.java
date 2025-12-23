package com.bxkj.student.run.app.utils;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private double f20175d;

    /* renamed from: e, reason: collision with root package name */
    private double f20176e;

    /* renamed from: f, reason: collision with root package name */
    private double f20177f;

    /* renamed from: g, reason: collision with root package name */
    private double f20178g;

    /* renamed from: h, reason: collision with root package name */
    private double f20179h;

    /* renamed from: i, reason: collision with root package name */
    private double f20180i;

    /* renamed from: j, reason: collision with root package name */
    private double f20181j;

    /* renamed from: k, reason: collision with root package name */
    private double f20182k;

    /* renamed from: l, reason: collision with root package name */
    private double f20183l;

    /* renamed from: m, reason: collision with root package name */
    private double f20184m;

    /* renamed from: n, reason: collision with root package name */
    private double f20185n;

    /* renamed from: o, reason: collision with root package name */
    private double f20186o;

    /* renamed from: p, reason: collision with root package name */
    private double f20187p;

    /* renamed from: q, reason: collision with root package name */
    private double f20188q;

    /* renamed from: a, reason: collision with root package name */
    private int f20172a = 3;

    /* renamed from: b, reason: collision with root package name */
    private float f20173b = 0.3f;

    /* renamed from: c, reason: collision with root package name */
    private float f20174c = 10.0f;

    /* renamed from: r, reason: collision with root package name */
    private double f20189r = 0.0d;

    /* renamed from: s, reason: collision with root package name */
    private double f20190s = 0.0d;

    private static double a(LatLng p5, LatLng lineBegin, LatLng lineEnd) {
        double d6 = p5.longitude;
        double d7 = lineBegin.longitude;
        double d8 = p5.latitude;
        double d9 = lineBegin.latitude;
        double d10 = lineEnd.longitude;
        double d11 = d10 - d7;
        double d12 = lineEnd.latitude;
        double d13 = d12 - d9;
        double d14 = (((d6 - d7) * d11) + ((d8 - d9) * d13)) / ((d11 * d11) + (d13 * d13));
        if (d14 >= 0.0d && (d7 != d10 || d9 != d12)) {
            if (d14 > 1.0d) {
                d9 = d12;
                d7 = d10;
            } else {
                d7 += d11 * d14;
                d9 += d14 * d13;
            }
        }
        return AMapUtils.calculateLineDistance(p5, new LatLng(d9, d7));
    }

    private static LatLng c(List<LatLng> oneGraspList) {
        if (oneGraspList == null || oneGraspList.size() == 0) {
            return null;
        }
        return oneGraspList.get(oneGraspList.size() - 1);
    }

    private LatLng f(double oldValue_x, double value_x, double oldValue_y, double value_y) {
        this.f20175d = oldValue_x;
        this.f20176e = value_x;
        double d6 = this.f20181j;
        double d7 = this.f20183l;
        double sqrt = Math.sqrt((d6 * d6) + (d7 * d7)) + this.f20190s;
        this.f20185n = sqrt;
        double d8 = this.f20181j;
        double sqrt2 = Math.sqrt((sqrt * sqrt) / ((sqrt * sqrt) + (d8 * d8))) + this.f20189r;
        this.f20187p = sqrt2;
        double d9 = this.f20176e;
        double d10 = this.f20175d;
        this.f20179h = ((d9 - d10) * sqrt2) + d10;
        double d11 = this.f20185n;
        this.f20183l = Math.sqrt((1.0d - sqrt2) * d11 * d11);
        this.f20177f = oldValue_y;
        this.f20178g = value_y;
        double d12 = this.f20182k;
        double d13 = this.f20184m;
        double sqrt3 = Math.sqrt((d12 * d12) + (d13 * d13)) + this.f20190s;
        this.f20186o = sqrt3;
        double d14 = this.f20182k;
        double sqrt4 = Math.sqrt((sqrt3 * sqrt3) / ((sqrt3 * sqrt3) + (d14 * d14))) + this.f20189r;
        this.f20188q = sqrt4;
        double d15 = this.f20178g;
        double d16 = this.f20177f;
        this.f20180i = ((d15 - d16) * sqrt4) + d16;
        double d17 = 1.0d - sqrt4;
        double d18 = this.f20186o;
        this.f20184m = Math.sqrt(d17 * d18 * d18);
        return new LatLng(this.f20180i, this.f20179h);
    }

    private List<LatLng> h(List<LatLng> originlist, int intensity) {
        ArrayList arrayList = new ArrayList();
        if (originlist != null && originlist.size() > 2) {
            e();
            LatLng latLng = originlist.get(0);
            arrayList.add(latLng);
            for (int i6 = 1; i6 < originlist.size(); i6++) {
                LatLng j6 = j(latLng, originlist.get(i6), intensity);
                if (j6 != null) {
                    arrayList.add(j6);
                    latLng = j6;
                }
            }
        }
        return arrayList;
    }

    private LatLng j(LatLng lastLoc, LatLng curLoc, int intensity) {
        if (this.f20181j == 0.0d || this.f20182k == 0.0d) {
            e();
        }
        LatLng latLng = null;
        if (lastLoc != null && curLoc != null) {
            if (intensity < 1) {
                intensity = 1;
            } else if (intensity > 5) {
                intensity = 5;
            }
            int i6 = 0;
            while (i6 < intensity) {
                latLng = f(lastLoc.longitude, curLoc.longitude, lastLoc.latitude, curLoc.latitude);
                i6++;
                curLoc = latLng;
            }
        }
        return latLng;
    }

    private List<LatLng> l(List<LatLng> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < inPoints.size(); i6++) {
            LatLng c6 = c(arrayList);
            LatLng latLng = inPoints.get(i6);
            if (c6 == null || i6 == inPoints.size() - 1) {
                arrayList.add(latLng);
            } else if (a(latLng, c6, inPoints.get(i6 + 1)) < threshHold) {
                arrayList.add(latLng);
            }
        }
        return arrayList;
    }

    private List<LatLng> n(List<LatLng> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < inPoints.size(); i6++) {
            LatLng c6 = c(arrayList);
            LatLng latLng = inPoints.get(i6);
            if (c6 == null || i6 == inPoints.size() - 1) {
                arrayList.add(latLng);
            } else if (a(latLng, c6, inPoints.get(i6 + 1)) > threshHold) {
                arrayList.add(latLng);
            }
        }
        return arrayList;
    }

    public int b() {
        return this.f20172a;
    }

    public float d() {
        return this.f20173b;
    }

    public List<LatLng> g(List<LatLng> originlist) {
        return h(originlist, this.f20172a);
    }

    public LatLng i(LatLng lastLoc, LatLng curLoc) {
        return j(lastLoc, curLoc, this.f20172a);
    }

    public List<LatLng> m(List<LatLng> inPoints) {
        return n(inPoints, this.f20173b);
    }

    public List<LatLng> o(List<LatLng> originlist) {
        return l(originlist, this.f20174c);
    }

    public void p(int mIntensity) {
        this.f20172a = mIntensity;
    }

    public void q(float mnoiseThreshhold) {
        this.f20174c = mnoiseThreshhold;
    }

    public void r(float mThreshhold) {
        this.f20173b = mThreshhold;
    }

    public List<LatLng> k(List<LatLng> originlist) {
        return n(h(o(originlist), this.f20172a), this.f20173b);
    }

    private void e() {
        this.f20181j = 0.001d;
        this.f20182k = 0.001d;
        this.f20183l = 5.698402909980532E-4d;
        this.f20184m = 5.698402909980532E-4d;
    }
}
