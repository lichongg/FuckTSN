package com.amap.api.trace;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TraceLocation {

    /* renamed from: a, reason: collision with root package name */
    private double f9891a;

    /* renamed from: b, reason: collision with root package name */
    private double f9892b;

    /* renamed from: c, reason: collision with root package name */
    private float f9893c;

    /* renamed from: d, reason: collision with root package name */
    private float f9894d;

    /* renamed from: e, reason: collision with root package name */
    private long f9895e;

    public TraceLocation(double d6, double d7, float f6, float f7, long j6) {
        this.f9891a = a(d6);
        this.f9892b = a(d7);
        this.f9893c = (int) ((f6 * 3600.0f) / 1000.0f);
        this.f9894d = (int) f7;
        this.f9895e = j6;
    }

    public void setBearing(float f6) {
        this.f9894d = (int) f6;
    }

    public TraceLocation copy() {
        TraceLocation traceLocation = new TraceLocation();
        traceLocation.f9894d = this.f9894d;
        traceLocation.f9891a = this.f9891a;
        traceLocation.f9892b = this.f9892b;
        traceLocation.f9893c = this.f9893c;
        traceLocation.f9895e = this.f9895e;
        return traceLocation;
    }

    public float getBearing() {
        return this.f9894d;
    }

    public double getLatitude() {
        return this.f9891a;
    }

    public double getLongitude() {
        return this.f9892b;
    }

    public float getSpeed() {
        return this.f9893c;
    }

    public long getTime() {
        return this.f9895e;
    }

    public void setSpeed(float f6) {
        this.f9893c = (int) ((f6 * 3600.0f) / 1000.0f);
    }

    public void setTime(long j6) {
        this.f9895e = j6;
    }

    public String toString() {
        return this.f9891a + ",longtitude " + this.f9892b + ",speed " + this.f9893c + ",bearing " + this.f9894d + ",time " + this.f9895e;
    }

    public void setLatitude(double d6) {
        this.f9891a = a(d6);
    }

    public void setLongitude(double d6) {
        this.f9892b = a(d6);
    }

    private static double a(double d6) {
        return Math.round(d6 * 1000000.0d) / 1000000.0d;
    }

    public TraceLocation() {
    }
}
