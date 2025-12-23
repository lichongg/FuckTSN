package com.bxkj.student.common.utils;

import com.amap.api.maps.model.LatLng;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private float f17794b;

    /* renamed from: c, reason: collision with root package name */
    private long f17795c;

    /* renamed from: d, reason: collision with root package name */
    private double f17796d;

    /* renamed from: e, reason: collision with root package name */
    private double f17797e;

    /* renamed from: a, reason: collision with root package name */
    private final float f17793a = 3.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f17798f = -1.0f;

    public LatLng a(double lat_measurement, double lng_measurement, float accuracy, long TimeStamp_milliseconds) {
        float f6 = accuracy < 3.0f ? 3.0f : accuracy;
        float f7 = this.f17798f;
        if (f7 < 0.0f) {
            b(lat_measurement, lng_measurement, f6, TimeStamp_milliseconds);
        } else {
            long j6 = TimeStamp_milliseconds - this.f17795c;
            if (j6 > 0) {
                float f8 = this.f17794b;
                this.f17798f = f7 + (((j6 * f8) * f8) / 1000.0f);
                this.f17795c = TimeStamp_milliseconds;
            }
            float f9 = this.f17798f;
            float f10 = f9 / ((f6 * f6) + f9);
            double d6 = this.f17796d;
            double d7 = f10;
            this.f17796d = d6 + ((lat_measurement - d6) * d7);
            double d8 = this.f17797e;
            this.f17797e = d8 + (d7 * (lng_measurement - d8));
            this.f17798f = (1.0f - f10) * f9;
        }
        return new LatLng(this.f17796d, this.f17797e);
    }

    public void b(double lat, double lng, float accuracy, long TimeStamp_milliseconds) {
        this.f17796d = lat;
        this.f17797e = lng;
        this.f17798f = accuracy * accuracy;
        this.f17795c = TimeStamp_milliseconds;
    }

    public long c() {
        return this.f17795c;
    }

    public float d() {
        return (float) Math.sqrt(this.f17798f);
    }

    public double e() {
        return this.f17796d;
    }

    public double f() {
        return this.f17797e;
    }

    public f(float Q_metres_per_second) {
        this.f17794b = Q_metres_per_second;
    }
}
