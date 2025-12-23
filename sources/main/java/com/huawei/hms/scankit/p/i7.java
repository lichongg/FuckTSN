package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
abstract class i7 {

    /* renamed from: b, reason: collision with root package name */
    static final i7 f34411b = new a7(null, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final i7 f34412a;

    final i7 a() {
        return this.f34412a;
    }

    abstract void a(r rVar, byte[] bArr);

    final i7 a(int i6, int i7) {
        return new a7(this, i6, i7);
    }

    final i7 b(int i6, int i7) {
        return new q(this, i6, i7);
    }

    i7(i7 i7Var) {
        this.f34412a = i7Var;
    }
}
