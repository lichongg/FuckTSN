package master.flame.danmaku.danmaku.renderer.android;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.k;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;
import master.flame.danmaku.danmaku.model.o;
import master.flame.danmaku.danmaku.renderer.android.b;
import v4.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a extends v4.b {

    /* renamed from: d, reason: collision with root package name */
    private f f50157d;

    /* renamed from: e, reason: collision with root package name */
    private final DanmakuContext f50158e;

    /* renamed from: f, reason: collision with root package name */
    private b.g f50159f;

    /* renamed from: h, reason: collision with root package name */
    private final master.flame.danmaku.danmaku.renderer.android.b f50161h;

    /* renamed from: i, reason: collision with root package name */
    private k f50162i;

    /* renamed from: j, reason: collision with root package name */
    private a.b f50163j;

    /* renamed from: g, reason: collision with root package name */
    private final b.g f50160g = new C0973a();

    /* renamed from: k, reason: collision with root package name */
    private b f50164k = new b(this, null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: master.flame.danmaku.danmaku.renderer.android.a$a, reason: collision with other inner class name */
    class C0973a implements b.g {
        C0973a() {
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.b.g
        public boolean a(d dVar, float f6, int i6, boolean z5) {
            if (dVar.f50068o != 0 || !a.this.f50158e.C.c(dVar, i6, 0, a.this.f50157d, z5, a.this.f50158e)) {
                return false;
            }
            dVar.G(false);
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b extends m.c<d> {

        /* renamed from: e, reason: collision with root package name */
        private d f50166e;

        /* renamed from: f, reason: collision with root package name */
        public n f50167f;

        /* renamed from: g, reason: collision with root package name */
        public a.c f50168g;

        /* renamed from: h, reason: collision with root package name */
        public long f50169h;

        private b() {
        }

        /* synthetic */ b(a aVar, C0973a c0973a) {
            this();
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        public void b() {
            this.f50168g.f54717e = this.f50166e;
            super.b();
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int a(d dVar) {
            d dVar2;
            this.f50166e = dVar;
            if (dVar.w()) {
                this.f50167f.g(dVar);
                return this.f50168g.f54713a ? 2 : 0;
            }
            if (!this.f50168g.f54713a && dVar.r()) {
                return 0;
            }
            if (dVar.m()) {
                dVar2 = dVar;
            } else {
                master.flame.danmaku.controller.b bVar = a.this.f50158e.C;
                a.c cVar = this.f50168g;
                dVar2 = dVar;
                bVar.b(dVar2, cVar.f54715c, cVar.f54716d, cVar.f54714b, false, a.this.f50158e);
            }
            if (dVar2.b() >= this.f50169h && (dVar2.f50068o != 0 || !dVar2.n())) {
                if (dVar2.p()) {
                    o<?> e6 = dVar2.e();
                    if (a.this.f50162i != null && (e6 == null || e6.get() == null)) {
                        a.this.f50162i.a(dVar2);
                    }
                    return 1;
                }
                if (dVar2.getType() == 1) {
                    this.f50168g.f54715c++;
                }
                if (!dVar2.q()) {
                    dVar2.z(this.f50167f, false);
                }
                if (!dVar2.u()) {
                    dVar2.A(this.f50167f, false);
                }
                a.this.f50161h.c(dVar2, this.f50167f, a.this.f50159f);
                if (!dVar2.v() || (dVar2.f50057d == null && dVar2.d() > this.f50167f.getHeight())) {
                    return 0;
                }
                int a6 = dVar2.a(this.f50167f);
                if (a6 == 1) {
                    this.f50168g.f54730r++;
                } else if (a6 == 2) {
                    this.f50168g.f54731s++;
                    if (a.this.f50162i != null) {
                        a.this.f50162i.a(dVar2);
                    }
                }
                this.f50168g.a(dVar2.getType(), 1);
                this.f50168g.b(1);
                this.f50168g.c(dVar2);
                if (a.this.f50163j != null && dVar2.K != a.this.f50158e.B.f50090d) {
                    dVar2.K = a.this.f50158e.B.f50090d;
                    a.this.f50163j.a(dVar2);
                }
            }
            return 0;
        }
    }

    @Override // v4.a
    public void g() {
        this.f50163j = null;
    }

    @Override // v4.a
    public void a(boolean z5) {
        this.f50159f = z5 ? this.f50160g : null;
    }

    @Override // v4.a
    public void b(a.b bVar) {
        this.f50163j = bVar;
    }

    @Override // v4.a
    public void c(n nVar, m mVar, long j6, a.c cVar) {
        this.f50157d = cVar.f54714b;
        b bVar = this.f50164k;
        bVar.f50167f = nVar;
        bVar.f50168g = cVar;
        bVar.f50169h = j6;
        mVar.a(bVar);
    }

    @Override // v4.a
    public void d(boolean z5) {
        master.flame.danmaku.danmaku.renderer.android.b bVar = this.f50161h;
        if (bVar != null) {
            bVar.a(z5);
        }
    }

    @Override // v4.a
    public void e(k kVar) {
        this.f50162i = kVar;
    }

    @Override // v4.a
    public void f() {
        this.f50161h.b();
    }

    @Override // v4.a
    public void release() {
        this.f50161h.d();
        this.f50158e.C.a();
    }

    public a(DanmakuContext danmakuContext) {
        this.f50158e = danmakuContext;
        this.f50161h = new master.flame.danmaku.danmaku.renderer.android.b(danmakuContext.o());
    }

    @Override // v4.a
    public void clear() {
        f();
        this.f50158e.C.a();
    }
}
