package com.amap.api.col.p0003l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c5 extends x7 {

    /* renamed from: h, reason: collision with root package name */
    private static int f5840h = 10000000;

    /* renamed from: b, reason: collision with root package name */
    protected int f5841b;

    /* renamed from: c, reason: collision with root package name */
    protected long f5842c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5843d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5844e;

    /* renamed from: f, reason: collision with root package name */
    private int f5845f;

    /* renamed from: g, reason: collision with root package name */
    private long f5846g;

    @Override // com.amap.api.col.p0003l.x7
    protected final boolean d() {
        if (this.f5844e && this.f5846g <= this.f5845f) {
            return true;
        }
        if (!this.f5843d || this.f5846g >= this.f5845f) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f5842c < this.f5841b) {
            return false;
        }
        this.f5842c = currentTimeMillis;
        return true;
    }

    public final void f(int i6) {
        if (i6 <= 0) {
            return;
        }
        this.f5846g += i6;
    }

    public final void g(boolean z5) {
        this.f5844e = z5;
    }

    public final long h() {
        return this.f5846g;
    }

    public c5(boolean z5, x7 x7Var, long j6, int i6) {
        super(x7Var);
        this.f5844e = false;
        this.f5843d = z5;
        this.f5841b = 600000;
        this.f5846g = j6;
        this.f5845f = i6;
    }

    @Override // com.amap.api.col.p0003l.x7
    public final int a() {
        return 320000;
    }
}
