package com.huawei.hms.scankit.p;

import com.huawei.hms.common.util.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class x0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f34996a;

    /* renamed from: b, reason: collision with root package name */
    private final int f34997b;

    /* renamed from: c, reason: collision with root package name */
    private final int f34998c;

    /* renamed from: d, reason: collision with root package name */
    private final int f34999d;

    /* renamed from: e, reason: collision with root package name */
    private int f35000e = -1;

    boolean a(int i6) {
        return i6 != -1 && this.f34998c == (i6 % 3) * 3;
    }

    int b() {
        return this.f34997b;
    }

    int a() {
        return this.f34998c;
    }

    void b(int i6) {
        this.f35000e = i6;
    }

    int c() {
        return this.f35000e;
    }

    int d() {
        return this.f34996a;
    }

    int e() {
        return this.f34999d;
    }

    int f() {
        return this.f34997b - this.f34996a;
    }

    boolean g() {
        return a(this.f35000e);
    }

    void h() {
        this.f35000e = ((this.f34999d / 30) * 3) + (this.f34998c / 3);
    }

    public String toString() {
        return this.f35000e + Logger.f33116c + this.f34999d;
    }

    x0(int i6, int i7, int i8, int i9) {
        this.f34996a = i6;
        this.f34997b = i7;
        this.f34998c = i8;
        this.f34999d = i9;
    }
}
