package com.facebook.rebound;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class SteppingLooper extends SpringLooper {

    /* renamed from: b, reason: collision with root package name */
    private boolean f32508b;

    /* renamed from: c, reason: collision with root package name */
    private long f32509c;

    @Override // com.facebook.rebound.SpringLooper
    public void b() {
        this.f32508b = true;
        this.f32509c = 0L;
    }

    @Override // com.facebook.rebound.SpringLooper
    public void c() {
        this.f32508b = false;
    }

    public boolean d(long j6) {
        BaseSpringSystem baseSpringSystem = this.f32507a;
        if (baseSpringSystem == null || !this.f32508b) {
            return false;
        }
        long j7 = this.f32509c + j6;
        baseSpringSystem.i(j7);
        this.f32509c = j7;
        return this.f32507a.g();
    }
}
