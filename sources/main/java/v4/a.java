package v4;

import master.flame.danmaku.danmaku.model.android.e;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.k;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f54706a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f54707b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f54708c = 2;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: v4.a$a, reason: collision with other inner class name */
    public static class C1083a {

        /* renamed from: a, reason: collision with root package name */
        public final float[] f54709a = new float[4];

        /* renamed from: b, reason: collision with root package name */
        private int f54710b;

        /* renamed from: c, reason: collision with root package name */
        private int f54711c;

        public void a() {
            c(this.f54711c, this.f54710b, 0.0f, 0.0f);
        }

        public void b() {
            c(0.0f, 0.0f, this.f54711c, this.f54710b);
        }

        public void c(float f6, float f7, float f8, float f9) {
            float[] fArr = this.f54709a;
            fArr[0] = f6;
            fArr[1] = f7;
            fArr[2] = f8;
            fArr[3] = f9;
        }

        public void d(int i6, int i7) {
            this.f54711c = i6;
            this.f54710b = i7;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(d dVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c {

        /* renamed from: v, reason: collision with root package name */
        public static final int f54712v = -1;

        /* renamed from: a, reason: collision with root package name */
        public boolean f54713a;

        /* renamed from: c, reason: collision with root package name */
        public int f54715c;

        /* renamed from: d, reason: collision with root package name */
        public int f54716d;

        /* renamed from: e, reason: collision with root package name */
        public d f54717e;

        /* renamed from: f, reason: collision with root package name */
        public int f54718f;

        /* renamed from: g, reason: collision with root package name */
        public int f54719g;

        /* renamed from: h, reason: collision with root package name */
        public int f54720h;

        /* renamed from: i, reason: collision with root package name */
        public int f54721i;

        /* renamed from: j, reason: collision with root package name */
        public int f54722j;

        /* renamed from: k, reason: collision with root package name */
        public int f54723k;

        /* renamed from: l, reason: collision with root package name */
        public int f54724l;

        /* renamed from: m, reason: collision with root package name */
        public long f54725m;

        /* renamed from: n, reason: collision with root package name */
        public long f54726n;

        /* renamed from: o, reason: collision with root package name */
        public long f54727o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f54728p;

        /* renamed from: q, reason: collision with root package name */
        public long f54729q;

        /* renamed from: r, reason: collision with root package name */
        public long f54730r;

        /* renamed from: s, reason: collision with root package name */
        public long f54731s;

        /* renamed from: u, reason: collision with root package name */
        private boolean f54733u;

        /* renamed from: b, reason: collision with root package name */
        public f f54714b = new f();

        /* renamed from: t, reason: collision with root package name */
        private m f54732t = new e(4);

        public int a(int i6, int i7) {
            if (i6 == 1) {
                int i8 = this.f54718f + i7;
                this.f54718f = i8;
                return i8;
            }
            if (i6 == 4) {
                int i9 = this.f54721i + i7;
                this.f54721i = i9;
                return i9;
            }
            if (i6 == 5) {
                int i10 = this.f54720h + i7;
                this.f54720h = i10;
                return i10;
            }
            if (i6 == 6) {
                int i11 = this.f54719g + i7;
                this.f54719g = i11;
                return i11;
            }
            if (i6 != 7) {
                return 0;
            }
            int i12 = this.f54722j + i7;
            this.f54722j = i12;
            return i12;
        }

        public m d() {
            m mVar;
            this.f54733u = true;
            synchronized (this) {
                mVar = this.f54732t;
                this.f54732t = new e(4);
            }
            this.f54733u = false;
            return mVar;
        }

        public int b(int i6) {
            int i7 = this.f54723k + i6;
            this.f54723k = i7;
            return i7;
        }

        public void c(d dVar) {
            if (this.f54733u) {
                return;
            }
            this.f54732t.j(dVar);
        }

        public void e() {
            this.f54724l = this.f54723k;
            this.f54723k = 0;
            this.f54722j = 0;
            this.f54721i = 0;
            this.f54720h = 0;
            this.f54719g = 0;
            this.f54718f = 0;
            this.f54725m = 0L;
            this.f54727o = 0L;
            this.f54726n = 0L;
            this.f54729q = 0L;
            this.f54728p = false;
            synchronized (this) {
                this.f54732t.clear();
            }
        }

        public void f(c cVar) {
            if (cVar == null) {
                return;
            }
            this.f54724l = cVar.f54724l;
            this.f54718f = cVar.f54718f;
            this.f54719g = cVar.f54719g;
            this.f54720h = cVar.f54720h;
            this.f54721i = cVar.f54721i;
            this.f54722j = cVar.f54722j;
            this.f54723k = cVar.f54723k;
            this.f54725m = cVar.f54725m;
            this.f54726n = cVar.f54726n;
            this.f54727o = cVar.f54727o;
            this.f54728p = cVar.f54728p;
            this.f54729q = cVar.f54729q;
            this.f54730r = cVar.f54730r;
            this.f54731s = cVar.f54731s;
        }
    }

    void a(boolean z5);

    void b(b bVar);

    void c(n nVar, m mVar, long j6, c cVar);

    void clear();

    void d(boolean z5);

    void e(k kVar);

    void f();

    void g();

    void release();
}
