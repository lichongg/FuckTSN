package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e3 extends u6 {

    /* renamed from: e, reason: collision with root package name */
    private final float f34213e;

    /* renamed from: f, reason: collision with root package name */
    private final int f34214f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f34215g;

    e3(float f6, float f7, float f8, boolean z5) {
        this(f6, f7, f8, z5, 1);
    }

    public e3(float f6, float f7, float f8, boolean z5, int i6) {
        super(f6, f7, i6);
        this.f34213e = f8;
        this.f34214f = i6;
        this.f34215g = z5;
    }

    e3 a(float f6, float f7, float f8, boolean z5) {
        int i6 = this.f34214f;
        int i7 = i6 + 1;
        float b6 = (i6 * b()) + f7;
        float f9 = i7;
        float f10 = b6 / f9;
        float c6 = ((this.f34214f * c()) + f6) / f9;
        float f11 = ((this.f34214f * this.f34213e) + f8) / f9;
        boolean z6 = this.f34215g;
        return new e3(f10, c6, f11, z6 ? z5 : z6, i7);
    }

    @Override // com.huawei.hms.scankit.p.u6
    public boolean d() {
        return this.f34215g;
    }

    public float e() {
        return this.f34213e;
    }

    boolean b(float f6, float f7, float f8) {
        if (Math.abs(f7 - c()) > f6 || Math.abs(f8 - b()) > f6) {
            return false;
        }
        float abs = Math.abs(f6 - this.f34213e);
        if (abs > 1.0f && abs > this.f34213e) {
            return false;
        }
        return true;
    }
}
