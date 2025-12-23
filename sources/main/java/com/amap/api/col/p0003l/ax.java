package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.col.p0003l.by;
import com.amap.api.col.p0003l.u0;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class ax extends OfflineMapCity implements l0, c1 {
    public static final Parcelable.Creator<ax> CREATOR = new b();

    /* renamed from: f, reason: collision with root package name */
    public final g1 f5639f;

    /* renamed from: g, reason: collision with root package name */
    public final g1 f5640g;

    /* renamed from: h, reason: collision with root package name */
    public final g1 f5641h;

    /* renamed from: i, reason: collision with root package name */
    public final g1 f5642i;

    /* renamed from: j, reason: collision with root package name */
    public final g1 f5643j;

    /* renamed from: k, reason: collision with root package name */
    public final g1 f5644k;

    /* renamed from: l, reason: collision with root package name */
    public final g1 f5645l;

    /* renamed from: m, reason: collision with root package name */
    public final g1 f5646m;

    /* renamed from: n, reason: collision with root package name */
    public final g1 f5647n;

    /* renamed from: o, reason: collision with root package name */
    public final g1 f5648o;

    /* renamed from: p, reason: collision with root package name */
    public final g1 f5649p;

    /* renamed from: q, reason: collision with root package name */
    g1 f5650q;

    /* renamed from: r, reason: collision with root package name */
    Context f5651r;

    /* renamed from: s, reason: collision with root package name */
    private String f5652s;

    /* renamed from: t, reason: collision with root package name */
    private String f5653t;

    /* renamed from: u, reason: collision with root package name */
    boolean f5654u;

    /* renamed from: v, reason: collision with root package name */
    private long f5655v;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements u0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5656a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f5657b;

        @Override // com.amap.api.col.3l.u0.a
        public final void a(float f6) {
            int i6 = (int) ((f6 * 0.39d) + 60.0d);
            if (i6 - ax.this.getcompleteCode() <= 0 || System.currentTimeMillis() - ax.this.f5655v <= 1000) {
                return;
            }
            ax.this.setCompleteCode(i6);
            ax.this.f5655v = System.currentTimeMillis();
        }

        a(String str, File file) {
            this.f5656a = str;
            this.f5657b = file;
        }

        @Override // com.amap.api.col.3l.u0.a
        public final void b() {
            ax axVar = ax.this;
            axVar.f5650q.b(axVar.f5649p.d());
        }

        @Override // com.amap.api.col.3l.u0.a
        public final void a() {
            try {
                if (new File(this.f5656a).delete()) {
                    a1.l(this.f5657b);
                    ax.this.setCompleteCode(100);
                    ax.this.f5650q.k();
                }
            } catch (Exception unused) {
                ax axVar = ax.this;
                axVar.f5650q.b(axVar.f5649p.d());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements Parcelable.Creator<ax> {
        private static ax a(Parcel parcel) {
            return new ax(parcel);
        }

        private static ax[] b(int i6) {
            return new ax[i6];
        }

        b() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ax createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ax[] newArray(int i6) {
            return b(i6);
        }
    }

    public ax(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        F();
    }

    @Override // com.amap.api.col.p0003l.by
    public final void a(long j6, long j7) {
        int i6 = (int) ((j7 * 100) / j6);
        if (i6 != getcompleteCode()) {
            setCompleteCode(i6);
            t();
        }
    }

    @Override // com.amap.api.col.p0003l.l0
    public final String b() {
        return getUrl();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void m(int i6) {
        if (i6 == -1) {
            this.f5650q = this.f5646m;
        } else if (i6 == 0) {
            this.f5650q = this.f5641h;
        } else if (i6 == 1) {
            this.f5650q = this.f5643j;
        } else if (i6 == 2) {
            this.f5650q = this.f5640g;
        } else if (i6 == 3) {
            this.f5650q = this.f5642i;
        } else if (i6 == 4) {
            this.f5650q = this.f5644k;
        } else if (i6 == 6) {
            this.f5650q = this.f5639f;
        } else if (i6 != 7) {
            switch (i6) {
                case 101:
                    this.f5650q = this.f5647n;
                    break;
                case 102:
                    this.f5650q = this.f5648o;
                    break;
                case 103:
                    this.f5650q = this.f5649p;
                    break;
                default:
                    if (i6 < 0) {
                        this.f5650q = this.f5646m;
                        break;
                    }
                    break;
            }
        } else {
            this.f5650q = this.f5645l;
        }
        setState(i6);
    }

    public final void n(g1 g1Var) {
        this.f5650q = g1Var;
        setState(g1Var.d());
    }

    public final void p(String str) {
        this.f5653t = str;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5659a;

        static {
            int[] iArr = new int[by.a.values().length];
            f5659a = iArr;
            try {
                iArr[by.a.amap_exception.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5659a[by.a.file_io_exception.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5659a[by.a.network_exception.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void H() {
        c0 b6 = c0.b(this.f5651r);
        if (b6 != null) {
            b6.e(this);
        }
    }

    private String f() {
        if (TextUtils.isEmpty(this.f5652s)) {
            return null;
        }
        String str = this.f5652s;
        return str.substring(0, str.lastIndexOf("."));
    }

    private String h() {
        if (TextUtils.isEmpty(this.f5652s)) {
            return null;
        }
        String f6 = f();
        return f6.substring(0, f6.lastIndexOf(46));
    }

    private void o(File file, File file2, String str) {
        new u0().b(file, file2, -1L, a1.b(file), new a(str, file));
    }

    public final void A() {
        this.f5650q.b(this.f5649p.d());
    }

    public final void B() {
        this.f5650q.a();
        if (this.f5654u) {
            this.f5650q.h();
        }
        this.f5654u = false;
    }

    public final void C() {
        this.f5650q.equals(this.f5644k);
        this.f5650q.j();
    }

    public final void D() {
        c0 b6 = c0.b(this.f5651r);
        if (b6 != null) {
            b6.k(this);
        }
    }

    public final void E() {
        c0 b6 = c0.b(this.f5651r);
        if (b6 != null) {
            b6.u(this);
        }
    }

    protected final void F() {
        String str = c0.f5771o;
        String i6 = a1.i(getUrl());
        if (i6 != null) {
            this.f5652s = str + i6 + ".zip.tmp";
            return;
        }
        this.f5652s = str + getPinyin() + ".zip.tmp";
    }

    public final n0 G() {
        setState(this.f5650q.d());
        n0 n0Var = new n0(this, this.f5651r);
        n0Var.m(l());
        l();
        return n0Var;
    }

    @Override // com.amap.api.col.p0003l.by
    public final void b(by.a aVar) {
        int i6 = c.f5659a[aVar.ordinal()];
        int d6 = i6 != 1 ? i6 != 2 ? i6 != 3 ? 6 : this.f5647n.d() : this.f5649p.d() : this.f5648o.d();
        if (this.f5650q.equals(this.f5641h) || this.f5650q.equals(this.f5640g)) {
            this.f5650q.b(d6);
        }
    }

    @Override // com.amap.api.col.p0003l.v0
    public final void c() {
        this.f5650q.equals(this.f5643j);
        this.f5650q.b(this.f5646m.d());
    }

    public final String l() {
        return this.f5653t;
    }

    @Override // com.amap.api.col.p0003l.v0
    public final void p() {
        this.f5655v = 0L;
        setCompleteCode(0);
        this.f5650q.equals(this.f5643j);
        this.f5650q.f();
    }

    public final g1 s() {
        return this.f5650q;
    }

    public final void t() {
        c0 b6 = c0.b(this.f5651r);
        if (b6 != null) {
            b6.q(this);
        }
    }

    public final void u() {
        c0 b6 = c0.b(this.f5651r);
        if (b6 != null) {
            b6.x(this);
            t();
        }
    }

    @Override // com.amap.api.col.p0003l.c1
    public final String v() {
        StringBuffer stringBuffer = new StringBuffer();
        String i6 = a1.i(getUrl());
        if (i6 != null) {
            stringBuffer.append(i6);
        } else {
            stringBuffer.append(getPinyin());
        }
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }

    public final void z() {
        this.f5650q.i();
    }

    private boolean i() {
        a1.a();
        getSize();
        getcompleteCode();
        getSize();
        return false;
    }

    @Override // com.amap.api.col.p0003l.c1
    public final boolean d() {
        return i();
    }

    @Override // com.amap.api.col.p0003l.w0
    public final String e() {
        return h();
    }

    @Override // com.amap.api.col.p0003l.by
    public final void n() {
        this.f5650q.equals(this.f5641h);
        this.f5650q.k();
    }

    public final g1 q(int i6) {
        switch (i6) {
            case 101:
                return this.f5647n;
            case 102:
                return this.f5648o;
            case 103:
                return this.f5649p;
            default:
                return this.f5646m;
        }
    }

    @Override // com.amap.api.col.p0003l.v0
    public final void r() {
        u();
    }

    @Override // com.amap.api.col.p0003l.c1
    public final String w() {
        return getAdcode();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeString(this.f5653t);
    }

    @Override // com.amap.api.col.p0003l.w0
    public final String x() {
        return f();
    }

    public final void y() {
        s().d();
        if (this.f5650q.equals(this.f5642i)) {
            this.f5650q.g();
            return;
        }
        if (this.f5650q.equals(this.f5641h)) {
            this.f5650q.i();
            return;
        }
        if (!this.f5650q.equals(this.f5645l) && !this.f5650q.equals(this.f5646m)) {
            if (!this.f5650q.equals(this.f5648o) && !this.f5650q.equals(this.f5647n) && !this.f5650q.c(this.f5649p)) {
                s().h();
                return;
            } else {
                this.f5650q.f();
                return;
            }
        }
        H();
        this.f5654u = true;
    }

    @Override // com.amap.api.col.p0003l.by
    public final void a() {
        u();
    }

    @Override // com.amap.api.col.p0003l.v0
    public final void a(long j6) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f5655v > 500) {
            int i6 = (int) j6;
            if (i6 > getcompleteCode()) {
                setCompleteCode(i6);
                t();
            }
            this.f5655v = currentTimeMillis;
        }
    }

    @Override // com.amap.api.col.p0003l.v0
    public final void b(String str) {
        this.f5650q.equals(this.f5643j);
        this.f5653t = str;
        String f6 = f();
        String h6 = h();
        if (!TextUtils.isEmpty(f6) && !TextUtils.isEmpty(h6)) {
            File file = new File(h6 + "/");
            File file2 = new File(b3.v(this.f5651r) + File.separator + "map/");
            File file3 = new File(b3.v(this.f5651r));
            if (file3.exists() || file3.mkdir()) {
                if (file2.exists() || file2.mkdir()) {
                    o(file, file2, f6);
                    return;
                }
                return;
            }
            return;
        }
        c();
    }

    private ax(Context context, int i6) {
        this.f5639f = new i1(this);
        this.f5640g = new p1(this);
        this.f5641h = new l1(this);
        this.f5642i = new n1(this);
        this.f5643j = new o1(this);
        this.f5644k = new h1(this);
        this.f5645l = new m1(this);
        this.f5646m = new j1(-1, this);
        this.f5647n = new j1(101, this);
        this.f5648o = new j1(102, this);
        this.f5649p = new j1(103, this);
        this.f5652s = null;
        this.f5653t = "";
        this.f5654u = false;
        this.f5655v = 0L;
        this.f5651r = context;
        m(i6);
    }

    @Override // com.amap.api.col.p0003l.by
    public final void m() {
        this.f5655v = 0L;
        this.f5650q.equals(this.f5640g);
        this.f5650q.f();
    }

    public ax(Parcel parcel) {
        super(parcel);
        this.f5639f = new i1(this);
        this.f5640g = new p1(this);
        this.f5641h = new l1(this);
        this.f5642i = new n1(this);
        this.f5643j = new o1(this);
        this.f5644k = new h1(this);
        this.f5645l = new m1(this);
        this.f5646m = new j1(-1, this);
        this.f5647n = new j1(101, this);
        this.f5648o = new j1(102, this);
        this.f5649p = new j1(103, this);
        this.f5652s = null;
        this.f5653t = "";
        this.f5654u = false;
        this.f5655v = 0L;
        this.f5653t = parcel.readString();
    }
}
