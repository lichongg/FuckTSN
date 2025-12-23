package master.flame.danmaku.controller;

import android.graphics.Canvas;
import master.flame.danmaku.controller.h;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.parser.a;
import v4.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class e implements h {

    /* renamed from: w, reason: collision with root package name */
    static final /* synthetic */ boolean f49878w = false;

    /* renamed from: c, reason: collision with root package name */
    protected final DanmakuContext f49879c;

    /* renamed from: d, reason: collision with root package name */
    protected final master.flame.danmaku.danmaku.model.b f49880d;

    /* renamed from: e, reason: collision with root package name */
    protected m f49881e;

    /* renamed from: f, reason: collision with root package name */
    protected master.flame.danmaku.danmaku.parser.a f49882f;

    /* renamed from: g, reason: collision with root package name */
    h.a f49883g;

    /* renamed from: h, reason: collision with root package name */
    final v4.a f49884h;

    /* renamed from: i, reason: collision with root package name */
    master.flame.danmaku.danmaku.model.f f49885i;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f49887k;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f49890n;

    /* renamed from: o, reason: collision with root package name */
    private long f49891o;

    /* renamed from: p, reason: collision with root package name */
    private long f49892p;

    /* renamed from: q, reason: collision with root package name */
    protected int f49893q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f49894r;

    /* renamed from: s, reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.d f49895s;

    /* renamed from: u, reason: collision with root package name */
    private m f49897u;

    /* renamed from: j, reason: collision with root package name */
    private m f49886j = new master.flame.danmaku.danmaku.model.android.e(4);

    /* renamed from: l, reason: collision with root package name */
    private long f49888l = 0;

    /* renamed from: m, reason: collision with root package name */
    private final a.c f49889m = new a.c();

    /* renamed from: t, reason: collision with root package name */
    private master.flame.danmaku.danmaku.model.android.e f49896t = new master.flame.danmaku.danmaku.model.android.e(4);

    /* renamed from: v, reason: collision with root package name */
    private DanmakuContext.a f49898v = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements DanmakuContext.a {
        a() {
        }

        @Override // master.flame.danmaku.danmaku.model.android.DanmakuContext.a
        public boolean a(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
            return e.this.t(danmakuContext, danmakuConfigTag, objArr);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements a.b {
        b() {
        }

        @Override // v4.a.b
        public void a(master.flame.danmaku.danmaku.model.d dVar) {
            h.a aVar = e.this.f49883g;
            if (aVar != null) {
                aVar.a(dVar);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends m.c<master.flame.danmaku.danmaku.model.d> {
        c() {
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int a(master.flame.danmaku.danmaku.model.d dVar) {
            if (!dVar.f50079z) {
                return 0;
            }
            e.this.u(dVar);
            return 2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends m.c<master.flame.danmaku.danmaku.model.d> {

        /* renamed from: e, reason: collision with root package name */
        long f49902e = w4.c.b();

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f49903f;

        d(int i6) {
            this.f49903f = i6;
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int a(master.flame.danmaku.danmaku.model.d dVar) {
            boolean w5 = dVar.w();
            if (w4.c.b() - this.f49902e > this.f49903f || !w5) {
                return 1;
            }
            e.this.f49881e.e(dVar);
            e.this.u(dVar);
            return 2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: master.flame.danmaku.controller.e$e, reason: collision with other inner class name */
    class C0970e extends m.c<master.flame.danmaku.danmaku.model.d> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ m f49905e;

        C0970e(m mVar) {
            this.f49905e = mVar;
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int a(master.flame.danmaku.danmaku.model.d dVar) {
            if (dVar.v() && !dVar.s()) {
                this.f49905e.j(dVar);
                return 0;
            }
            return 0;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements a.InterfaceC0972a {
        f() {
        }

        @Override // master.flame.danmaku.danmaku.parser.a.InterfaceC0972a
        public void b(master.flame.danmaku.danmaku.model.d dVar) {
            h.a aVar = e.this.f49883g;
            if (aVar != null) {
                aVar.b(dVar);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends m.c<master.flame.danmaku.danmaku.model.d> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f49908e;

        g(long j6) {
            this.f49908e = j6;
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int a(master.flame.danmaku.danmaku.model.d dVar) {
            if (dVar.s()) {
                return 2;
            }
            dVar.E(this.f49908e + dVar.f50055b);
            if (dVar.f50055b == 0) {
                return 2;
            }
            return 0;
        }
    }

    @Override // master.flame.danmaku.controller.h
    public synchronized void a(master.flame.danmaku.danmaku.model.d dVar) {
        boolean z5;
        boolean j6;
        h.a aVar;
        try {
            if (this.f49881e == null) {
                return;
            }
            if (dVar.f50079z) {
                this.f49896t.j(dVar);
                v(10);
            }
            dVar.f50072s = this.f49881e.size();
            if (this.f49891o > dVar.b() || dVar.b() > this.f49892p) {
                z5 = !dVar.f50079z;
            } else {
                synchronized (this.f49886j) {
                    z5 = this.f49886j.j(dVar);
                }
            }
            synchronized (this.f49881e) {
                j6 = this.f49881e.j(dVar);
            }
            if (!z5 || !j6) {
                this.f49892p = 0L;
                this.f49891o = 0L;
            }
            if (j6 && (aVar = this.f49883g) != null) {
                aVar.b(dVar);
            }
            master.flame.danmaku.danmaku.model.d dVar2 = this.f49895s;
            if (dVar2 == null || (dVar2 != null && dVar.b() > this.f49895s.b())) {
                this.f49895s = dVar;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // master.flame.danmaku.controller.h
    public synchronized void c(boolean z5) {
        m mVar = this.f49881e;
        if (mVar != null && !mVar.isEmpty()) {
            synchronized (this.f49881e) {
                if (!z5) {
                    try {
                        long j6 = this.f49885i.f50080a;
                        long j7 = this.f49879c.D.f50009e;
                        m i6 = this.f49881e.i((j6 - j7) - 100, j6 + j7);
                        if (i6 != null) {
                            this.f49886j = i6;
                        }
                    } finally {
                    }
                }
                this.f49881e.clear();
            }
        }
    }

    @Override // master.flame.danmaku.controller.h
    public synchronized void e() {
        m mVar = this.f49886j;
        if (mVar != null && !mVar.isEmpty()) {
            synchronized (this.f49886j) {
                this.f49886j.a(new c());
            }
        }
    }

    @Override // master.flame.danmaku.controller.h
    public void j() {
        this.f49887k = true;
    }

    @Override // master.flame.danmaku.controller.h
    public synchronized a.c l(master.flame.danmaku.danmaku.model.b bVar) {
        return o(bVar, this.f49885i);
    }

    @Override // master.flame.danmaku.controller.h
    public void m() {
        this.f49894r = true;
    }

    protected boolean q(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object[] objArr) {
        Boolean bool;
        if (danmakuConfigTag == null || DanmakuContext.DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN.equals(danmakuConfigTag)) {
            return true;
        }
        if (DanmakuContext.DanmakuConfigTag.DUPLICATE_MERGING_ENABLED.equals(danmakuConfigTag)) {
            Boolean bool2 = (Boolean) objArr[0];
            if (bool2 != null) {
                if (bool2.booleanValue()) {
                    this.f49879c.C.f(master.flame.danmaku.controller.b.f49818w);
                } else {
                    this.f49879c.C.k(master.flame.danmaku.controller.b.f49818w);
                }
                return true;
            }
        } else {
            if (DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.DANMAKU_MARGIN.equals(danmakuConfigTag)) {
                j();
                return false;
            }
            if (DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES.equals(danmakuConfigTag) || DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE.equals(danmakuConfigTag)) {
                v4.a aVar = this.f49884h;
                if (aVar != null) {
                    aVar.a(this.f49879c.r() || this.f49879c.q());
                }
                return true;
            }
            if (DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM.equals(danmakuConfigTag) && (bool = (Boolean) objArr[0]) != null) {
                v4.a aVar2 = this.f49884h;
                if (aVar2 != null) {
                    aVar2.d(bool.booleanValue());
                }
                return true;
            }
        }
        return false;
    }

    protected synchronized void v(int i6) {
        m mVar = this.f49881e;
        if (mVar != null && !mVar.isEmpty() && !this.f49896t.isEmpty()) {
            this.f49896t.a(new d(i6));
        }
    }

    private void p(a.c cVar) {
        boolean z5 = cVar.f54723k == 0;
        cVar.f54728p = z5;
        if (z5) {
            cVar.f54726n = -1L;
        }
        master.flame.danmaku.danmaku.model.d dVar = cVar.f54717e;
        cVar.f54717e = null;
        cVar.f54727o = dVar != null ? dVar.b() : -1L;
        cVar.f54725m = cVar.f54714b.update(w4.c.b());
    }

    @Override // master.flame.danmaku.controller.h
    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z5) {
        this.f49879c.g().t().a(dVar);
        int i6 = dVar.J;
        dVar.J = i6 | 2;
        if (z5) {
            dVar.f50069p = -1.0f;
            dVar.f50070q = -1.0f;
            dVar.J = i6 | 3;
            dVar.f50075v++;
        }
    }

    @Override // master.flame.danmaku.controller.h
    public m d(long j6) {
        m mVar;
        long j7 = this.f49879c.D.f50009e;
        long j8 = (j6 - j7) - 100;
        long j9 = j6 + j7;
        int i6 = 0;
        while (true) {
            int i7 = i6 + 1;
            if (i6 >= 3) {
                mVar = null;
                break;
            }
            try {
                mVar = this.f49881e.i(j8, j9);
                break;
            } catch (Exception unused) {
                i6 = i7;
            }
        }
        master.flame.danmaku.danmaku.model.android.e eVar = new master.flame.danmaku.danmaku.model.android.e();
        if (mVar != null && !mVar.isEmpty()) {
            mVar.a(new C0970e(eVar));
        }
        return eVar;
    }

    @Override // master.flame.danmaku.controller.h
    public void f(master.flame.danmaku.danmaku.parser.a aVar) {
        this.f49882f = aVar;
        this.f49890n = false;
    }

    @Override // master.flame.danmaku.controller.h
    public void h(long j6, long j7, long j8) {
        m d6 = this.f49889m.d();
        this.f49897u = d6;
        d6.a(new g(j8));
        this.f49888l = j7;
    }

    @Override // master.flame.danmaku.controller.h
    public void i() {
        this.f49892p = 0L;
        this.f49891o = 0L;
        this.f49894r = false;
    }

    @Override // master.flame.danmaku.controller.h
    public void k() {
        this.f49879c.X();
        v4.a aVar = this.f49884h;
        if (aVar != null) {
            aVar.release();
        }
    }

    protected a.c o(master.flame.danmaku.danmaku.model.b bVar, master.flame.danmaku.danmaku.model.f fVar) {
        long j6;
        m mVar;
        m mVar2;
        if (this.f49887k) {
            this.f49884h.f();
            this.f49887k = false;
        }
        if (this.f49881e == null) {
            return null;
        }
        master.flame.danmaku.controller.d.a((Canvas) bVar.u());
        if (this.f49894r) {
            return this.f49889m;
        }
        a.c cVar = this.f49889m;
        long j7 = fVar.f50080a;
        long j8 = this.f49879c.D.f50009e;
        long j9 = (j7 - j8) - 100;
        long j10 = j8 + j7;
        m mVar3 = this.f49886j;
        long j11 = this.f49891o;
        if (j11 <= j9) {
            j6 = this.f49892p;
            if (j7 <= j6) {
                j9 = j11;
                mVar = mVar3;
                mVar2 = this.f49897u;
                n(cVar, mVar2, mVar);
                if (mVar2 != null && !mVar2.isEmpty()) {
                    a.c cVar2 = this.f49889m;
                    cVar2.f54713a = true;
                    this.f49884h.c(bVar, mVar2, 0L, cVar2);
                }
                this.f49889m.f54713a = false;
                if (mVar != null || mVar.isEmpty()) {
                    cVar.f54728p = true;
                    cVar.f54726n = j9;
                    cVar.f54727o = j6;
                    return cVar;
                }
                this.f49884h.c(this.f49880d, mVar, this.f49888l, cVar);
                p(cVar);
                if (cVar.f54728p) {
                    master.flame.danmaku.danmaku.model.d dVar = this.f49895s;
                    if (dVar != null && dVar.w()) {
                        this.f49895s = null;
                        h.a aVar = this.f49883g;
                        if (aVar != null) {
                            aVar.d();
                        }
                    }
                    if (cVar.f54726n == -1) {
                        cVar.f54726n = j9;
                    }
                    if (cVar.f54727o == -1) {
                        cVar.f54727o = j6;
                    }
                }
                return cVar;
            }
        }
        mVar3 = this.f49881e.d(j9, j10);
        if (mVar3 != null) {
            this.f49886j = mVar3;
        }
        this.f49891o = j9;
        this.f49892p = j10;
        j6 = j10;
        mVar = mVar3;
        mVar2 = this.f49897u;
        n(cVar, mVar2, mVar);
        if (mVar2 != null) {
            a.c cVar22 = this.f49889m;
            cVar22.f54713a = true;
            this.f49884h.c(bVar, mVar2, 0L, cVar22);
        }
        this.f49889m.f54713a = false;
        if (mVar != null) {
        }
        cVar.f54728p = true;
        cVar.f54726n = j9;
        cVar.f54727o = j6;
        return cVar;
    }

    @Override // master.flame.danmaku.controller.h
    public void onPlayStateChanged(int i6) {
        this.f49893q = i6;
    }

    @Override // master.flame.danmaku.controller.h
    public void prepare() {
        s(this.f49882f);
        this.f49892p = 0L;
        this.f49891o = 0L;
        h.a aVar = this.f49883g;
        if (aVar != null) {
            aVar.c();
            this.f49890n = true;
        }
    }

    protected void r(master.flame.danmaku.danmaku.model.f fVar) {
        this.f49885i = fVar;
    }

    @Override // master.flame.danmaku.controller.h
    public void reset() {
        if (this.f49886j != null) {
            this.f49886j = new master.flame.danmaku.danmaku.model.android.e();
        }
        v4.a aVar = this.f49884h;
        if (aVar != null) {
            aVar.clear();
        }
    }

    protected void s(master.flame.danmaku.danmaku.parser.a aVar) {
        this.f49881e = aVar.i(this.f49879c).j(this.f49880d).l(this.f49885i).k(new f()).a();
        this.f49879c.B.a();
        m mVar = this.f49881e;
        if (mVar != null) {
            this.f49895s = mVar.last();
        }
    }

    @Override // master.flame.danmaku.controller.h
    public void start() {
        this.f49879c.u(this.f49898v);
    }

    public e(master.flame.danmaku.danmaku.model.f fVar, DanmakuContext danmakuContext, h.a aVar) {
        boolean z5;
        if (danmakuContext != null) {
            this.f49879c = danmakuContext;
            this.f49880d = danmakuContext.g();
            this.f49883g = aVar;
            master.flame.danmaku.danmaku.renderer.android.a aVar2 = new master.flame.danmaku.danmaku.renderer.android.a(danmakuContext);
            this.f49884h = aVar2;
            aVar2.b(new b());
            if (!danmakuContext.r() && !danmakuContext.q()) {
                z5 = false;
            } else {
                z5 = true;
            }
            aVar2.a(z5);
            r(fVar);
            if (danmakuContext.p()) {
                danmakuContext.C.f(master.flame.danmaku.controller.b.f49818w);
                return;
            } else {
                danmakuContext.C.k(master.flame.danmaku.controller.b.f49818w);
                return;
            }
        }
        throw new IllegalArgumentException("context is null");
    }

    private void n(a.c cVar, m mVar, m mVar2) {
        int i6;
        cVar.e();
        cVar.f54714b.update(w4.c.b());
        int i7 = 0;
        cVar.f54715c = 0;
        if (mVar != null) {
            i6 = mVar.size();
        } else {
            i6 = 0;
        }
        if (mVar2 != null) {
            i7 = mVar2.size();
        }
        cVar.f54716d = i6 + i7;
    }

    @Override // master.flame.danmaku.controller.h
    public void g(long j6) {
        reset();
        this.f49879c.B.g();
        this.f49879c.B.c();
        this.f49888l = j6;
    }

    @Override // master.flame.danmaku.controller.h
    public void seek(long j6) {
        master.flame.danmaku.danmaku.model.d last;
        reset();
        this.f49879c.B.g();
        this.f49879c.B.c();
        this.f49879c.B.f();
        this.f49879c.B.e();
        this.f49897u = new master.flame.danmaku.danmaku.model.android.e(4);
        if (j6 < 1000) {
            j6 = 0;
        }
        this.f49888l = j6;
        this.f49889m.e();
        this.f49889m.f54727o = this.f49888l;
        this.f49892p = 0L;
        this.f49891o = 0L;
        m mVar = this.f49881e;
        if (mVar != null && (last = mVar.last()) != null && !last.w()) {
            this.f49895s = last;
        }
    }

    public boolean t(DanmakuContext danmakuContext, DanmakuContext.DanmakuConfigTag danmakuConfigTag, Object... objArr) {
        boolean q5 = q(danmakuContext, danmakuConfigTag, objArr);
        h.a aVar = this.f49883g;
        if (aVar != null) {
            aVar.e();
        }
        return q5;
    }

    protected void u(master.flame.danmaku.danmaku.model.d dVar) {
    }
}
