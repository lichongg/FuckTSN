package com.facebook.rebound;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class BouncyConversion {

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f32451e = false;

    /* renamed from: a, reason: collision with root package name */
    private final double f32452a;

    /* renamed from: b, reason: collision with root package name */
    private final double f32453b;

    /* renamed from: c, reason: collision with root package name */
    private final double f32454c;

    /* renamed from: d, reason: collision with root package name */
    private final double f32455d;

    public BouncyConversion(double d6, double d7) {
        this.f32454c = d6;
        this.f32455d = d7;
        double k6 = k(j(d7 / 1.7d, 0.0d, 20.0d), 0.0d, 0.8d);
        double k7 = k(j(d6 / 1.7d, 0.0d, 20.0d), 0.5d, 200.0d);
        this.f32452a = k7;
        this.f32453b = l(k6, d(k7), 0.01d);
    }

    private double j(double d6, double d7, double d8) {
        return (d6 - d7) / (d8 - d7);
    }

    private double k(double d6, double d7, double d8) {
        return d7 + (d6 * (d8 - d7));
    }

    private double a(double d6) {
        return ((Math.pow(d6, 3.0d) * 7.0E-4d) - (Math.pow(d6, 2.0d) * 0.031d)) + (d6 * 0.64d) + 1.28d;
    }

    private double b(double d6) {
        return ((Math.pow(d6, 3.0d) * 4.4E-5d) - (Math.pow(d6, 2.0d) * 0.006d)) + (d6 * 0.36d) + 2.0d;
    }

    private double c(double d6) {
        return ((Math.pow(d6, 3.0d) * 4.5E-7d) - (Math.pow(d6, 2.0d) * 3.32E-4d)) + (d6 * 0.1078d) + 5.84d;
    }

    private double d(double d6) {
        if (d6 <= 18.0d) {
            return a(d6);
        }
        if (d6 > 18.0d && d6 <= 44.0d) {
            return b(d6);
        }
        if (d6 > 44.0d) {
            return c(d6);
        }
        return 0.0d;
    }

    private double i(double d6, double d7, double d8) {
        return (d8 * d6) + ((1.0d - d6) * d7);
    }

    private double l(double d6, double d7, double d8) {
        return i((2.0d * d6) - (d6 * d6), d7, d8);
    }

    public double e() {
        return this.f32455d;
    }

    public double f() {
        return this.f32453b;
    }

    public double g() {
        return this.f32452a;
    }

    public double h() {
        return this.f32454c;
    }
}
