package master.flame.danmaku.danmaku.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class d {
    public static final String L = "/n";
    public static final int M = 1;
    public static final int N = 6;
    public static final int O = 5;
    public static final int P = 4;
    public static final int Q = 7;
    public static final int R = 0;
    public static final int S = 0;
    public static final int T = 1;
    public static final int U = 1;
    public static final int V = 2;
    public boolean A;
    public String C;
    public boolean D;
    protected f E;

    /* renamed from: a, reason: collision with root package name */
    private long f50054a;

    /* renamed from: b, reason: collision with root package name */
    public long f50055b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f50056c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f50057d;

    /* renamed from: e, reason: collision with root package name */
    public Object f50058e;

    /* renamed from: f, reason: collision with root package name */
    public Object f50059f;

    /* renamed from: g, reason: collision with root package name */
    public int f50060g;

    /* renamed from: h, reason: collision with root package name */
    public float f50061h;

    /* renamed from: i, reason: collision with root package name */
    public float f50062i;

    /* renamed from: j, reason: collision with root package name */
    public int f50063j;

    /* renamed from: r, reason: collision with root package name */
    public g f50071r;

    /* renamed from: s, reason: collision with root package name */
    public int f50072s;

    /* renamed from: t, reason: collision with root package name */
    public int f50073t;

    /* renamed from: y, reason: collision with root package name */
    public o<?> f50078y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f50079z;

    /* renamed from: k, reason: collision with root package name */
    public int f50064k = 0;

    /* renamed from: l, reason: collision with root package name */
    public float f50065l = -1.0f;

    /* renamed from: m, reason: collision with root package name */
    public int f50066m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f50067n = 0;

    /* renamed from: o, reason: collision with root package name */
    public byte f50068o = 0;

    /* renamed from: p, reason: collision with root package name */
    public float f50069p = -1.0f;

    /* renamed from: q, reason: collision with root package name */
    public float f50070q = -1.0f;

    /* renamed from: u, reason: collision with root package name */
    private int f50074u = 0;

    /* renamed from: v, reason: collision with root package name */
    public int f50075v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f50076w = 0;

    /* renamed from: x, reason: collision with root package name */
    public int f50077x = -1;
    public int B = 0;
    protected int F = c.f50052a;
    public int G = 0;
    public int H = -1;
    public j I = null;
    public int J = 0;
    public int K = -1;

    public abstract float d();

    public abstract float g();

    public abstract int getType();

    public abstract float[] h(n nVar, long j6);

    public abstract float i();

    public abstract float l();

    public abstract void y(n nVar, float f6, float f7);

    public void B(g gVar) {
        this.f50071r = gVar;
    }

    public void C(Object obj) {
        this.f50059f = obj;
    }

    public void D(long j6) {
        this.f50054a = j6;
        this.f50055b = 0L;
    }

    public void E(long j6) {
        this.f50055b = j6;
        this.f50076w = this.I.f50091e;
    }

    public void F(f fVar) {
        this.E = fVar;
    }

    public void G(boolean z5) {
        if (!z5) {
            this.f50073t = 0;
        } else {
            this.f50074u = this.I.f50088b;
            this.f50073t = 1;
        }
    }

    public long b() {
        j jVar = this.I;
        if (jVar != null && jVar.f50091e == this.f50076w) {
            return this.f50054a + this.f50055b;
        }
        this.f50055b = 0L;
        return this.f50054a;
    }

    public int c() {
        return this.F;
    }

    public o<?> e() {
        return this.f50078y;
    }

    public long f() {
        return this.f50071r.f50084c;
    }

    public long j() {
        return this.f50054a;
    }

    public f k() {
        return this.E;
    }

    public boolean m() {
        if (this.H == this.I.f50089c) {
            return true;
        }
        this.G = 0;
        return false;
    }

    public boolean n() {
        return this.H == this.I.f50089c && this.G != 0;
    }

    public boolean o(int i6) {
        return this.H == this.I.f50089c && (this.G & i6) == i6;
    }

    public boolean p() {
        f fVar = this.E;
        return fVar == null || fVar.f50080a < b();
    }

    public boolean q() {
        return this.f50069p > -1.0f && this.f50070q > -1.0f && this.f50075v == this.I.f50087a;
    }

    public boolean r() {
        j jVar = this.I;
        if (jVar != null && jVar.f50091e == this.f50076w) {
            return this.f50055b != 0;
        }
        this.f50055b = 0L;
        return false;
    }

    public boolean s() {
        f fVar = this.E;
        return fVar == null || t(fVar.f50080a);
    }

    public boolean u() {
        return this.f50077x == this.I.f50092f;
    }

    public boolean v() {
        return this.f50073t == 1 && this.f50074u == this.I.f50088b;
    }

    public boolean w() {
        f fVar = this.E;
        return fVar == null || x(fVar.f50080a);
    }

    public void A(n nVar, boolean z5) {
        nVar.l(this, z5);
        this.f50077x = this.I.f50092f;
    }

    public int a(n nVar) {
        return nVar.p(this);
    }

    public boolean t(long j6) {
        long b6 = j6 - b();
        if (b6 > 0 && b6 < this.f50071r.f50084c) {
            return false;
        }
        return true;
    }

    public boolean x(long j6) {
        if (j6 - b() >= this.f50071r.f50084c) {
            return true;
        }
        return false;
    }

    public void z(n nVar, boolean z5) {
        nVar.e(this, z5);
        this.f50075v = this.I.f50087a;
    }
}
