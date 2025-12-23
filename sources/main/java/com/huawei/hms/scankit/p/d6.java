package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class d6 {

    /* renamed from: a, reason: collision with root package name */
    private final float f34126a;

    /* renamed from: b, reason: collision with root package name */
    private final float f34127b;

    /* renamed from: c, reason: collision with root package name */
    private final float f34128c;

    /* renamed from: d, reason: collision with root package name */
    private final float f34129d;

    /* renamed from: e, reason: collision with root package name */
    private final float f34130e;

    /* renamed from: f, reason: collision with root package name */
    private final float f34131f;

    /* renamed from: g, reason: collision with root package name */
    private final float f34132g;

    /* renamed from: h, reason: collision with root package name */
    private final float f34133h;

    /* renamed from: i, reason: collision with root package name */
    private final float f34134i;

    /* renamed from: j, reason: collision with root package name */
    private float f34135j;

    /* renamed from: k, reason: collision with root package name */
    private float f34136k;

    /* renamed from: l, reason: collision with root package name */
    private float f34137l;

    /* renamed from: m, reason: collision with root package name */
    private float f34138m;

    /* renamed from: n, reason: collision with root package name */
    private float f34139n;

    /* renamed from: o, reason: collision with root package name */
    private float f34140o;

    /* renamed from: p, reason: collision with root package name */
    private float f34141p;

    /* renamed from: q, reason: collision with root package name */
    private float f34142q;

    /* renamed from: r, reason: collision with root package name */
    private float f34143r;

    /* renamed from: s, reason: collision with root package name */
    private float f34144s = 0.0f;

    /* renamed from: t, reason: collision with root package name */
    private float f34145t = 0.0f;

    /* renamed from: u, reason: collision with root package name */
    private float f34146u = 0.0f;

    /* renamed from: v, reason: collision with root package name */
    private float f34147v = 0.0f;

    /* renamed from: w, reason: collision with root package name */
    private float f34148w = 0.0f;

    public void a(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        this.f34135j = f6;
        this.f34136k = f7;
        this.f34137l = f8;
        this.f34138m = f9;
        this.f34139n = f10;
        this.f34140o = f11;
        this.f34141p = f12;
        this.f34142q = f13;
        this.f34143r = f14;
        this.f34144s = f15;
        this.f34145t = f16;
        this.f34146u = f17;
        this.f34147v = f18;
        this.f34148w = f19;
    }

    public void b(float[] fArr) {
        int length = fArr.length;
        for (int i6 = 0; i6 < length; i6 += 2) {
            float f6 = fArr[i6];
            int i7 = i6 + 1;
            float f7 = fArr[i7];
            float f8 = (this.f34145t * f6) + (this.f34146u * f7) + (this.f34147v * f6 * f6) + (this.f34148w * f7 * f7) + 1.0f;
            fArr[i6] = (((((this.f34135j * f6) + (this.f34136k * f7)) + ((this.f34137l * f6) * f6)) + ((this.f34138m * f7) * f7)) + this.f34139n) / f8;
            fArr[i7] = (((((this.f34140o * f6) + (this.f34141p * f7)) + ((this.f34142q * f6) * f6)) + ((this.f34143r * f7) * f7)) + this.f34144s) / f8;
        }
    }

    public d6(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        this.f34126a = f6;
        this.f34127b = f9;
        this.f34128c = f12;
        this.f34129d = f7;
        this.f34130e = f10;
        this.f34131f = f13;
        this.f34132g = f8;
        this.f34133h = f11;
        this.f34134i = f14;
        this.f34135j = f6;
        this.f34136k = f7;
        this.f34137l = f8;
        this.f34138m = f9;
        this.f34139n = f10;
        this.f34140o = f11;
        this.f34141p = f12;
        this.f34142q = f13;
        this.f34143r = f14;
    }

    public static d6 b(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        float f14 = ((f6 - f8) + f10) - f12;
        float f15 = ((f7 - f9) + f11) - f13;
        if (f14 == 0.0f && f15 == 0.0f) {
            return new d6(f8 - f6, f10 - f8, f6, f9 - f7, f11 - f9, f7, 0.0f, 0.0f, 1.0f);
        }
        float f16 = f8 - f10;
        float f17 = f12 - f10;
        float f18 = f9 - f11;
        float f19 = f13 - f11;
        float f20 = (f16 * f19) - (f17 * f18);
        float f21 = ((f19 * f14) - (f17 * f15)) / f20;
        float f22 = ((f16 * f15) - (f14 * f18)) / f20;
        return new d6((f8 - f6) + (f21 * f8), (f12 - f6) + (f22 * f12), f6, (f9 - f7) + (f21 * f9), (f13 - f7) + (f22 * f13), f7, f21, f22, 1.0f);
    }

    public static d6 a(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21) {
        return b(f14, f15, f16, f17, f18, f19, f20, f21).a(a(f6, f7, f8, f9, f10, f11, f12, f13));
    }

    public void a(float[] fArr) {
        int length = fArr.length;
        float f6 = this.f34126a;
        float f7 = this.f34127b;
        float f8 = this.f34128c;
        float f9 = this.f34129d;
        float f10 = this.f34130e;
        float f11 = this.f34131f;
        float f12 = this.f34132g;
        float f13 = this.f34133h;
        float f14 = this.f34134i;
        for (int i6 = 0; i6 < length; i6 += 2) {
            float f15 = fArr[i6];
            int i7 = i6 + 1;
            float f16 = fArr[i7];
            float f17 = (f8 * f15) + (f11 * f16) + f14;
            fArr[i6] = (((f6 * f15) + (f9 * f16)) + f12) / f17;
            fArr[i7] = (((f15 * f7) + (f16 * f10)) + f13) / f17;
        }
    }

    public static d6 a(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        return b(f6, f7, f8, f9, f10, f11, f12, f13).a();
    }

    d6 a() {
        float f6 = this.f34130e;
        float f7 = this.f34134i;
        float f8 = this.f34131f;
        float f9 = this.f34133h;
        float f10 = (f6 * f7) - (f8 * f9);
        float f11 = this.f34132g;
        float f12 = this.f34129d;
        float f13 = (f8 * f11) - (f12 * f7);
        float f14 = (f12 * f9) - (f6 * f11);
        float f15 = this.f34128c;
        float f16 = this.f34127b;
        float f17 = (f15 * f9) - (f16 * f7);
        float f18 = this.f34126a;
        return new d6(f10, f13, f14, f17, (f7 * f18) - (f15 * f11), (f11 * f16) - (f9 * f18), (f16 * f8) - (f15 * f6), (f15 * f12) - (f8 * f18), (f18 * f6) - (f16 * f12));
    }

    d6 a(d6 d6Var) {
        float f6 = this.f34126a;
        float f7 = d6Var.f34126a;
        float f8 = this.f34129d;
        float f9 = d6Var.f34127b;
        float f10 = this.f34132g;
        float f11 = d6Var.f34128c;
        float f12 = (f6 * f7) + (f8 * f9) + (f10 * f11);
        float f13 = d6Var.f34129d;
        float f14 = d6Var.f34130e;
        float f15 = d6Var.f34131f;
        float f16 = (f6 * f13) + (f8 * f14) + (f10 * f15);
        float f17 = d6Var.f34132g;
        float f18 = d6Var.f34133h;
        float f19 = d6Var.f34134i;
        float f20 = (f6 * f17) + (f8 * f18) + (f10 * f19);
        float f21 = this.f34127b;
        float f22 = this.f34130e;
        float f23 = (f21 * f7) + (f22 * f9);
        float f24 = this.f34133h;
        float f25 = f23 + (f24 * f11);
        float f26 = (f21 * f13) + (f22 * f14) + (f24 * f15);
        float f27 = (f21 * f17) + (f22 * f18) + (f24 * f19);
        float f28 = this.f34128c;
        float f29 = f7 * f28;
        float f30 = this.f34131f;
        float f31 = f29 + (f9 * f30);
        float f32 = this.f34134i;
        return new d6(f12, f16, f20, f25, f26, f27, f31 + (f11 * f32), (f28 * f13) + (f14 * f30) + (f15 * f32), (f28 * f17) + (f30 * f18) + (f32 * f19));
    }
}
