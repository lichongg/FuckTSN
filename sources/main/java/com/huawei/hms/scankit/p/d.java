package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class d extends u6 {

    /* renamed from: e, reason: collision with root package name */
    private final float f34115e;

    d(float f6, float f7, float f8) {
        super(f6, f7);
        this.f34115e = f8;
    }

    boolean b(float f6, float f7, float f8) {
        if (Math.abs(f7 - c()) > f6 || Math.abs(f8 - b()) > f6) {
            return false;
        }
        float abs = Math.abs(f6 - this.f34115e);
        if (abs > 1.0f && abs > this.f34115e) {
            return false;
        }
        return true;
    }

    d c(float f6, float f7, float f8) {
        return new d((b() + f7) / 2.0f, (c() + f6) / 2.0f, (this.f34115e + f8) / 2.0f);
    }
}
