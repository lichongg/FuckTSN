package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f3 extends u6 {

    /* renamed from: e, reason: collision with root package name */
    private final float f34262e;

    /* renamed from: f, reason: collision with root package name */
    private final int f34263f;

    f3(float f6, float f7, float f8) {
        this(f6, f7, f8, 1);
    }

    private f3(float f6, float f7, float f8, int i6) {
        super(f6, f7);
        this.f34262e = f8;
        this.f34263f = i6;
    }

    @Override // com.huawei.hms.scankit.p.u6
    public int a() {
        return this.f34263f;
    }

    f3 c(float f6, float f7, float f8) {
        int i6 = this.f34263f;
        int i7 = i6 + 1;
        float b6 = (i6 * b()) + f7;
        float f9 = i7;
        return new f3(b6 / f9, ((this.f34263f * c()) + f6) / f9, ((this.f34263f * this.f34262e) + f8) / f9, i7);
    }

    public float e() {
        return this.f34262e;
    }

    boolean b(float f6, float f7, float f8) {
        if (Math.abs(f7 - c()) > f6 || Math.abs(f8 - b()) > f6) {
            return false;
        }
        float abs = Math.abs(f6 - this.f34262e);
        if (abs > 1.0f && abs > this.f34262e) {
            return false;
        }
        return true;
    }
}
