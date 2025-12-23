package com.autonavi.aps.amapapi.restruct;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class d {

    /* renamed from: l, reason: collision with root package name */
    public int f10040l;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10042n;

    /* renamed from: a, reason: collision with root package name */
    public int f10029a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f10030b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f10031c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f10032d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f10033e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f10034f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f10035g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f10036h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f10037i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f10038j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f10039k = -113;

    /* renamed from: m, reason: collision with root package name */
    public short f10041m = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f10043o = 32767;

    /* renamed from: p, reason: collision with root package name */
    public int f10044p = Integer.MAX_VALUE;

    /* renamed from: q, reason: collision with root package name */
    public int f10045q = Integer.MAX_VALUE;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10046r = true;

    /* renamed from: s, reason: collision with root package name */
    public int f10047s = 99;

    /* renamed from: t, reason: collision with root package name */
    public long f10048t = 0;

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            int i6 = dVar.f10040l;
            if (i6 != 1) {
                return i6 != 2 ? i6 != 3 ? i6 != 4 ? i6 == 5 && this.f10040l == 5 && dVar.f10031c == this.f10031c && dVar.f10033e == this.f10033e && dVar.f10045q == this.f10045q : this.f10040l == 4 && dVar.f10031c == this.f10031c && dVar.f10032d == this.f10032d && dVar.f10030b == this.f10030b : this.f10040l == 3 && dVar.f10031c == this.f10031c && dVar.f10032d == this.f10032d && dVar.f10030b == this.f10030b : this.f10040l == 2 && dVar.f10038j == this.f10038j && dVar.f10037i == this.f10037i && dVar.f10036h == this.f10036h;
            }
            if (this.f10040l == 1 && dVar.f10031c == this.f10031c && dVar.f10032d == this.f10032d && dVar.f10030b == this.f10030b) {
                return true;
            }
        }
        return false;
    }

    private String e() {
        return this.f10040l + "#" + this.f10029a + "#" + this.f10030b + "#0#" + a();
    }

    private String f() {
        return this.f10040l + "#" + this.f10036h + "#" + this.f10037i + "#" + this.f10038j;
    }

    public final long a() {
        return this.f10040l == 5 ? this.f10033e : this.f10032d;
    }

    public final String b() {
        int i6 = this.f10040l;
        if (i6 != 1) {
            if (i6 == 2) {
                return f();
            }
            if (i6 != 3 && i6 != 4 && i6 != 5) {
                return null;
            }
        }
        return e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final d clone() {
        d dVar = new d(this.f10040l, this.f10042n);
        dVar.f10029a = this.f10029a;
        dVar.f10030b = this.f10030b;
        dVar.f10031c = this.f10031c;
        dVar.f10032d = this.f10032d;
        dVar.f10033e = this.f10033e;
        dVar.f10034f = this.f10034f;
        dVar.f10035g = this.f10035g;
        dVar.f10036h = this.f10036h;
        dVar.f10037i = this.f10037i;
        dVar.f10038j = this.f10038j;
        dVar.f10039k = this.f10039k;
        dVar.f10041m = this.f10041m;
        dVar.f10043o = this.f10043o;
        dVar.f10044p = this.f10044p;
        dVar.f10045q = this.f10045q;
        dVar.f10046r = this.f10046r;
        dVar.f10047s = this.f10047s;
        dVar.f10048t = this.f10048t;
        return dVar;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = String.valueOf(this.f10040l).hashCode();
        if (this.f10040l == 2) {
            hashCode = String.valueOf(this.f10038j).hashCode() + String.valueOf(this.f10037i).hashCode();
            hashCode2 = String.valueOf(this.f10036h).hashCode();
        } else {
            hashCode = String.valueOf(this.f10031c).hashCode() + String.valueOf(this.f10032d).hashCode();
            hashCode2 = String.valueOf(this.f10030b).hashCode();
        }
        return hashCode3 + hashCode + hashCode2;
    }

    public d(int i6, boolean z5) {
        this.f10040l = i6;
        this.f10042n = z5;
    }

    public final String c() {
        String b6 = b();
        if (b6 != null && b6.length() > 0) {
            return (this.f10046r ? 1 : 0) + "#" + b6;
        }
        return "";
    }
}
