package com.facebook.rebound;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class SynchronousLooper extends SpringLooper {

    /* renamed from: d, reason: collision with root package name */
    public static double f32510d = 16.6667d;

    /* renamed from: b, reason: collision with root package name */
    private double f32511b = f32510d;

    /* renamed from: c, reason: collision with root package name */
    private boolean f32512c;

    @Override // com.facebook.rebound.SpringLooper
    public void b() {
        this.f32512c = true;
        while (!this.f32507a.g() && this.f32512c) {
            this.f32507a.i(this.f32511b);
        }
    }

    @Override // com.facebook.rebound.SpringLooper
    public void c() {
        this.f32512c = false;
    }

    public double d() {
        return this.f32511b;
    }

    public void e(double d6) {
        this.f32511b = d6;
    }
}
