package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class i2 implements Comparable<i2> {

    /* renamed from: a, reason: collision with root package name */
    private float f34374a;

    /* renamed from: b, reason: collision with root package name */
    private float f34375b;

    /* renamed from: c, reason: collision with root package name */
    private float f34376c;

    /* renamed from: d, reason: collision with root package name */
    private float f34377d;

    /* renamed from: e, reason: collision with root package name */
    private float f34378e;

    /* renamed from: f, reason: collision with root package name */
    private float f34379f;

    /* renamed from: g, reason: collision with root package name */
    private float f34380g;

    /* renamed from: h, reason: collision with root package name */
    private float f34381h;

    /* renamed from: i, reason: collision with root package name */
    private float f34382i;

    /* renamed from: j, reason: collision with root package name */
    private float f34383j;

    /* renamed from: k, reason: collision with root package name */
    private float f34384k;

    /* renamed from: l, reason: collision with root package name */
    public p f34385l;

    /* renamed from: m, reason: collision with root package name */
    public float[] f34386m = new float[5];

    /* renamed from: n, reason: collision with root package name */
    public float f34387n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    public float f34388o = 0.0f;

    /* renamed from: p, reason: collision with root package name */
    public int f34389p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f34390q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f34391r = 0;

    /* renamed from: s, reason: collision with root package name */
    public int f34392s = 0;

    /* renamed from: t, reason: collision with root package name */
    public int f34393t = 0;

    /* renamed from: u, reason: collision with root package name */
    public int f34394u = 0;

    /* renamed from: v, reason: collision with root package name */
    public float f34395v = 0.0f;

    public i2(boolean z5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        this.f34374a = f6;
        this.f34375b = f7;
        this.f34376c = f8;
        this.f34377d = f9;
        this.f34378e = f10;
        this.f34379f = f11;
        this.f34384k = f15;
        if (!z5) {
            this.f34382i = f14;
            this.f34383j = f13;
        } else {
            this.f34380g = f12;
            this.f34381h = f13;
            this.f34383j = f14;
        }
    }

    private float a(float f6, int i6, int i7) {
        float f7 = i6;
        if (f6 <= f7) {
            f6 = f7;
        }
        float f8 = i7 - 1;
        return f6 < f8 ? f6 : f8;
    }

    public void b(float f6, float f7) {
        this.f34374a = 0.0f;
        this.f34375b = 0.0f;
        this.f34376c = f6;
        this.f34377d = f7;
        this.f34378e = f6 / 2.0f;
        this.f34379f = f7 / 2.0f;
        this.f34380g = f6;
        this.f34381h = f7;
        this.f34383j = 0.0f;
    }

    public void a(int i6, int i7, float f6, float f7) {
        float f8 = this.f34374a + f6;
        this.f34374a = f8;
        float f9 = this.f34375b + f7;
        this.f34375b = f9;
        if (f8 < 0.0f) {
            this.f34376c += f8;
        }
        if (f9 < 0.0f) {
            this.f34377d += f9;
        }
        this.f34378e += f6;
        this.f34379f += f7;
        this.f34374a = a(f8, 0, i6);
        this.f34378e = a(this.f34378e, 0, i6);
        this.f34375b = a(this.f34375b, 0, i7);
        this.f34379f = a(this.f34379f, 0, i7);
        float f10 = this.f34374a;
        float f11 = i6 - f6;
        if (this.f34376c + f10 >= f11) {
            this.f34376c = (f11 - 1.0f) - f10;
        }
        float f12 = this.f34375b;
        float f13 = i7 - f7;
        if (this.f34377d + f12 >= f13) {
            this.f34377d = (f13 - 1.0f) - f12;
        }
    }

    public float c() {
        return this.f34377d;
    }

    public float d() {
        return this.f34374a;
    }

    public float e() {
        return this.f34375b;
    }

    public float f() {
        return this.f34376c;
    }

    public float g() {
        return this.f34384k;
    }

    public float h() {
        return this.f34382i;
    }

    public float i() {
        return this.f34383j;
    }

    public float j() {
        return this.f34378e;
    }

    public float k() {
        return this.f34379f;
    }

    public float l() {
        return this.f34381h;
    }

    public float m() {
        return this.f34380g;
    }

    public float n() {
        return this.f34395v;
    }

    public float b() {
        return this.f34387n;
    }

    public void a(float f6, float f7) {
        this.f34374a += f6;
        this.f34375b += f7;
        this.f34378e += f6;
        this.f34379f += f7;
    }

    public float a() {
        return this.f34388o;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(i2 i2Var) {
        return Float.compare((-i2Var.g()) + i2Var.h(), (-g()) + h());
    }
}
