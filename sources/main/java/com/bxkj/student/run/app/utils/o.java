package com.bxkj.student.run.app.utils;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class o {

    /* renamed from: d, reason: collision with root package name */
    private double f20293d;

    /* renamed from: e, reason: collision with root package name */
    private double f20294e;

    /* renamed from: f, reason: collision with root package name */
    private double f20295f;

    /* renamed from: g, reason: collision with root package name */
    private double f20296g;

    /* renamed from: h, reason: collision with root package name */
    private double f20297h;

    /* renamed from: i, reason: collision with root package name */
    private double f20298i;

    /* renamed from: j, reason: collision with root package name */
    private double f20299j;

    /* renamed from: k, reason: collision with root package name */
    private double f20300k;

    /* renamed from: l, reason: collision with root package name */
    private double f20301l;

    /* renamed from: m, reason: collision with root package name */
    private double f20302m;

    /* renamed from: n, reason: collision with root package name */
    private double f20303n;

    /* renamed from: o, reason: collision with root package name */
    private double f20304o;

    /* renamed from: p, reason: collision with root package name */
    private double f20305p;

    /* renamed from: q, reason: collision with root package name */
    private double f20306q;

    /* renamed from: a, reason: collision with root package name */
    private int f20290a = 3;

    /* renamed from: b, reason: collision with root package name */
    private float f20291b = 0.3f;

    /* renamed from: c, reason: collision with root package name */
    private float f20292c = 10.0f;

    /* renamed from: r, reason: collision with root package name */
    private double f20307r = 0.0d;

    /* renamed from: s, reason: collision with root package name */
    private double f20308s = 0.0d;

    private static LatLngTimeSpeed c(List<LatLngTimeSpeed> oneGraspList) {
        if (oneGraspList == null || oneGraspList.size() == 0) {
            return null;
        }
        return oneGraspList.get(oneGraspList.size() - 1);
    }

    private LatLngTimeSpeed f(double oldValue_x, double value_x, double oldValue_y, double value_y, float lastLocationSpeed, float currentLocationSpeed, long lastLocationTime, long currentLocationTime, boolean isPause, int locationType) {
        this.f20293d = oldValue_x;
        this.f20294e = value_x;
        double d6 = this.f20299j;
        double d7 = this.f20301l;
        double sqrt = Math.sqrt((d6 * d6) + (d7 * d7)) + this.f20308s;
        this.f20303n = sqrt;
        double d8 = this.f20299j;
        double sqrt2 = Math.sqrt((sqrt * sqrt) / ((sqrt * sqrt) + (d8 * d8))) + this.f20307r;
        this.f20305p = sqrt2;
        double d9 = this.f20294e;
        double d10 = this.f20293d;
        this.f20297h = ((d9 - d10) * sqrt2) + d10;
        double d11 = this.f20303n;
        this.f20301l = Math.sqrt((1.0d - sqrt2) * d11 * d11);
        this.f20295f = oldValue_y;
        this.f20296g = value_y;
        double d12 = this.f20300k;
        double d13 = this.f20302m;
        double sqrt3 = Math.sqrt((d12 * d12) + (d13 * d13)) + this.f20308s;
        this.f20304o = sqrt3;
        double d14 = this.f20300k;
        double sqrt4 = Math.sqrt((sqrt3 * sqrt3) / ((sqrt3 * sqrt3) + (d14 * d14))) + this.f20307r;
        this.f20306q = sqrt4;
        double d15 = this.f20296g;
        double d16 = this.f20295f;
        this.f20298i = ((d15 - d16) * sqrt4) + d16;
        double d17 = 1.0d - sqrt4;
        double d18 = this.f20304o;
        this.f20302m = Math.sqrt(d17 * d18 * d18);
        return new LatLngTimeSpeed(this.f20298i, this.f20297h, currentLocationTime, currentLocationSpeed, isPause, locationType);
    }

    private List<LatLngTimeSpeed> h(List<LatLngTimeSpeed> originlist, int intensity) {
        ArrayList arrayList = new ArrayList();
        if (originlist != null && originlist.size() > 2) {
            e();
            LatLngTimeSpeed latLngTimeSpeed = originlist.get(0);
            arrayList.add(latLngTimeSpeed);
            for (int i6 = 1; i6 < originlist.size(); i6++) {
                LatLngTimeSpeed j6 = j(latLngTimeSpeed, originlist.get(i6), intensity);
                if (j6 != null) {
                    arrayList.add(j6);
                    latLngTimeSpeed = j6;
                }
            }
        }
        return arrayList;
    }

    private LatLngTimeSpeed j(LatLngTimeSpeed lastLoc, LatLngTimeSpeed curLoc, int intensity) {
        o oVar = this;
        int i6 = intensity;
        if (oVar.f20299j == 0.0d || oVar.f20300k == 0.0d) {
            oVar.e();
        }
        if (lastLoc == null || curLoc == null) {
            return null;
        }
        if (i6 < 1) {
            i6 = 1;
        } else if (i6 > 5) {
            i6 = 5;
        }
        LatLngTimeSpeed latLngTimeSpeed = null;
        int i7 = 0;
        LatLngTimeSpeed latLngTimeSpeed2 = curLoc;
        while (i7 < i6) {
            LatLngTimeSpeed latLngTimeSpeed3 = latLngTimeSpeed2;
            latLngTimeSpeed = oVar.f(lastLoc.getLongitude(), latLngTimeSpeed3.getLongitude(), lastLoc.getLatitude(), latLngTimeSpeed3.getLatitude(), lastLoc.getSpeed(), latLngTimeSpeed3.getSpeed(), lastLoc.getTime(), latLngTimeSpeed3.getTime(), latLngTimeSpeed3.isPuase(), latLngTimeSpeed3.getLocationType());
            i7++;
            oVar = this;
            latLngTimeSpeed2 = latLngTimeSpeed;
        }
        return latLngTimeSpeed;
    }

    private List<LatLngTimeSpeed> l(List<LatLngTimeSpeed> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < inPoints.size(); i6++) {
            LatLngTimeSpeed c6 = c(arrayList);
            LatLngTimeSpeed latLngTimeSpeed = inPoints.get(i6);
            if (c6 == null || i6 == inPoints.size() - 1) {
                arrayList.add(latLngTimeSpeed);
            } else if (a(latLngTimeSpeed, c6, inPoints.get(i6 + 1)) < threshHold) {
                arrayList.add(latLngTimeSpeed);
            }
        }
        return arrayList;
    }

    private List<LatLngTimeSpeed> n(List<LatLngTimeSpeed> inPoints, float threshHold) {
        if (inPoints == null) {
            return null;
        }
        if (inPoints.size() <= 2) {
            return inPoints;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < inPoints.size(); i6++) {
            LatLngTimeSpeed c6 = c(arrayList);
            LatLngTimeSpeed latLngTimeSpeed = inPoints.get(i6);
            if (c6 == null || i6 == inPoints.size() - 1) {
                arrayList.add(latLngTimeSpeed);
            } else if (a(latLngTimeSpeed, c6, inPoints.get(i6 + 1)) > threshHold) {
                arrayList.add(latLngTimeSpeed);
            }
        }
        return arrayList;
    }

    public int b() {
        return this.f20290a;
    }

    public float d() {
        return this.f20291b;
    }

    public List<LatLngTimeSpeed> g(List<LatLngTimeSpeed> originlist) {
        return h(originlist, this.f20290a);
    }

    public LatLngTimeSpeed i(LatLngTimeSpeed lastLoc, LatLngTimeSpeed curLoc) {
        return j(lastLoc, curLoc, this.f20290a);
    }

    public List<LatLngTimeSpeed> m(List<LatLngTimeSpeed> inPoints) {
        return n(inPoints, this.f20291b);
    }

    public List<LatLngTimeSpeed> o(List<LatLngTimeSpeed> originlist) {
        return l(originlist, this.f20292c);
    }

    public void p(int mIntensity) {
        this.f20290a = mIntensity;
    }

    public void q(float mnoiseThreshhold) {
        this.f20292c = mnoiseThreshhold;
    }

    public void r(float mThreshhold) {
        this.f20291b = mThreshhold;
    }

    private static double a(LatLngTimeSpeed p5, LatLngTimeSpeed lineBegin, LatLngTimeSpeed lineEnd) {
        double longitude;
        double latitude;
        double longitude2 = p5.getLongitude() - lineBegin.getLongitude();
        double latitude2 = p5.getLatitude() - lineBegin.getLatitude();
        double longitude3 = lineEnd.getLongitude() - lineBegin.getLongitude();
        double latitude3 = lineEnd.getLatitude() - lineBegin.getLatitude();
        double d6 = ((longitude2 * longitude3) + (latitude2 * latitude3)) / ((longitude3 * longitude3) + (latitude3 * latitude3));
        if (d6 >= 0.0d && (lineBegin.getLongitude() != lineEnd.getLongitude() || lineBegin.getLatitude() != lineEnd.getLatitude())) {
            if (d6 > 1.0d) {
                longitude = lineEnd.getLongitude();
                latitude = lineEnd.getLatitude();
            } else {
                double longitude4 = lineBegin.getLongitude() + (longitude3 * d6);
                latitude = lineBegin.getLatitude() + (d6 * latitude3);
                longitude = longitude4;
            }
        } else {
            longitude = lineBegin.getLongitude();
            latitude = lineBegin.getLatitude();
        }
        return AMapUtils.calculateLineDistance(new LatLng(p5.getLatitude(), p5.getLongitude()), new LatLng(latitude, longitude));
    }

    public List<LatLngTimeSpeed> k(List<LatLngTimeSpeed> originlist) {
        return n(h(o(originlist), this.f20290a), this.f20291b);
    }

    private void e() {
        this.f20299j = 0.001d;
        this.f20300k = 0.001d;
        this.f20301l = 5.698402909980532E-4d;
        this.f20302m = 5.698402909980532E-4d;
    }
}
