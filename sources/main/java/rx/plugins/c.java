package rx.plugins;

import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.e;
import rx.i;
import rx.internal.operators.d5;
import rx.internal.operators.p4;
import rx.internal.operators.s0;
import rx.internal.operators.t0;
import rx.internal.operators.u0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    static volatile boolean f54437a;

    /* renamed from: b, reason: collision with root package name */
    static volatile rx.functions.b<Throwable> f54438b;

    /* renamed from: c, reason: collision with root package name */
    static volatile rx.functions.p<e.a, e.a> f54439c;

    /* renamed from: d, reason: collision with root package name */
    static volatile rx.functions.p<i.t, i.t> f54440d;

    /* renamed from: e, reason: collision with root package name */
    static volatile rx.functions.p<b.j0, b.j0> f54441e;

    /* renamed from: f, reason: collision with root package name */
    static volatile rx.functions.q<rx.e, e.a, e.a> f54442f;

    /* renamed from: g, reason: collision with root package name */
    static volatile rx.functions.q<rx.i, i.t, i.t> f54443g;

    /* renamed from: h, reason: collision with root package name */
    static volatile rx.functions.q<rx.b, b.j0, b.j0> f54444h;

    /* renamed from: i, reason: collision with root package name */
    static volatile rx.functions.p<rx.h, rx.h> f54445i;

    /* renamed from: j, reason: collision with root package name */
    static volatile rx.functions.p<rx.h, rx.h> f54446j;

    /* renamed from: k, reason: collision with root package name */
    static volatile rx.functions.p<rx.h, rx.h> f54447k;

    /* renamed from: l, reason: collision with root package name */
    static volatile rx.functions.p<rx.functions.a, rx.functions.a> f54448l;

    /* renamed from: m, reason: collision with root package name */
    static volatile rx.functions.p<rx.m, rx.m> f54449m;

    /* renamed from: n, reason: collision with root package name */
    static volatile rx.functions.p<rx.m, rx.m> f54450n;

    /* renamed from: o, reason: collision with root package name */
    static volatile rx.functions.o<? extends ScheduledExecutorService> f54451o;

    /* renamed from: p, reason: collision with root package name */
    static volatile rx.functions.p<Throwable, Throwable> f54452p;

    /* renamed from: q, reason: collision with root package name */
    static volatile rx.functions.p<Throwable, Throwable> f54453q;

    /* renamed from: r, reason: collision with root package name */
    static volatile rx.functions.p<Throwable, Throwable> f54454r;

    /* renamed from: s, reason: collision with root package name */
    static volatile rx.functions.p<e.b, e.b> f54455s;

    /* renamed from: t, reason: collision with root package name */
    static volatile rx.functions.p<e.b, e.b> f54456t;

    /* renamed from: u, reason: collision with root package name */
    static volatile rx.functions.p<b.k0, b.k0> f54457u;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements rx.functions.p<Throwable, Throwable> {
        @Override // rx.functions.p
        public Throwable call(Throwable th) {
            return rx.plugins.f.c().g().c(th);
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements rx.functions.p<e.b, e.b> {
        @Override // rx.functions.p
        public e.b call(e.b bVar) {
            return rx.plugins.f.c().g().b(bVar);
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.plugins.c$c, reason: collision with other inner class name */
    static class C1075c implements rx.functions.p<Throwable, Throwable> {
        @Override // rx.functions.p
        public Throwable call(Throwable th) {
            return rx.plugins.f.c().a().c(th);
        }

        C1075c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d implements rx.functions.p<b.k0, b.k0> {
        @Override // rx.functions.p
        public b.k0 call(b.k0 k0Var) {
            return rx.plugins.f.c().a().b(k0Var);
        }

        d() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e implements rx.functions.p<e.a, e.a> {
        @Override // rx.functions.p
        public e.a call(e.a aVar) {
            return rx.plugins.f.c().d().a(aVar);
        }

        e() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class f implements rx.functions.p<i.t, i.t> {
        @Override // rx.functions.p
        public i.t call(i.t tVar) {
            return rx.plugins.f.c().g().a(tVar);
        }

        f() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class g implements rx.functions.p<b.j0, b.j0> {
        @Override // rx.functions.p
        public b.j0 call(b.j0 j0Var) {
            return rx.plugins.f.c().a().a(j0Var);
        }

        g() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class h implements rx.functions.p<e.a, e.a> {
        @Override // rx.functions.p
        public e.a call(e.a aVar) {
            return new s0(aVar);
        }

        h() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class i implements rx.functions.p<i.t, i.t> {
        @Override // rx.functions.p
        public i.t call(i.t tVar) {
            return new u0(tVar);
        }

        i() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class j implements rx.functions.p<b.j0, b.j0> {
        @Override // rx.functions.p
        public b.j0 call(b.j0 j0Var) {
            return new t0(j0Var);
        }

        j() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class k implements rx.functions.b<Throwable> {
        @Override // rx.functions.b
        public void call(Throwable th) {
            rx.plugins.f.c().b().a(th);
        }

        k() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class l implements rx.functions.q<rx.e, e.a, e.a> {
        @Override // rx.functions.q
        public e.a call(rx.e eVar, e.a aVar) {
            return rx.plugins.f.c().d().e(eVar, aVar);
        }

        l() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class m implements rx.functions.p<rx.m, rx.m> {
        @Override // rx.functions.p
        public rx.m call(rx.m mVar) {
            return rx.plugins.f.c().d().d(mVar);
        }

        m() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class n implements rx.functions.q<rx.i, i.t, i.t> {
        @Override // rx.functions.q
        public i.t call(rx.i iVar, i.t tVar) {
            rx.plugins.h g6 = rx.plugins.f.c().g();
            return g6 == rx.plugins.i.f() ? tVar : new p4(g6.e(iVar, new d5(tVar)));
        }

        n() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class o implements rx.functions.p<rx.m, rx.m> {
        @Override // rx.functions.p
        public rx.m call(rx.m mVar) {
            return rx.plugins.f.c().g().d(mVar);
        }

        o() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class p implements rx.functions.q<rx.b, b.j0, b.j0> {
        @Override // rx.functions.q
        public b.j0 call(rx.b bVar, b.j0 j0Var) {
            return rx.plugins.f.c().a().d(bVar, j0Var);
        }

        p() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class q implements rx.functions.p<rx.functions.a, rx.functions.a> {
        @Override // rx.functions.p
        public rx.functions.a call(rx.functions.a aVar) {
            return rx.plugins.f.c().f().k(aVar);
        }

        q() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class r implements rx.functions.p<Throwable, Throwable> {
        @Override // rx.functions.p
        public Throwable call(Throwable th) {
            return rx.plugins.f.c().d().c(th);
        }

        r() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class s implements rx.functions.p<e.b, e.b> {
        @Override // rx.functions.p
        public e.b call(e.b bVar) {
            return rx.plugins.f.c().d().b(bVar);
        }

        s() {
        }
    }

    public static void A() {
        f54437a = true;
    }

    public static Throwable B(Throwable th) {
        rx.functions.p<Throwable, Throwable> pVar = f54454r;
        return pVar != null ? pVar.call(th) : th;
    }

    public static <T, R> b.k0 C(b.k0 k0Var) {
        rx.functions.p<b.k0, b.k0> pVar = f54457u;
        return pVar != null ? pVar.call(k0Var) : k0Var;
    }

    public static <T> b.j0 D(rx.b bVar, b.j0 j0Var) {
        rx.functions.q<rx.b, b.j0, b.j0> qVar = f54444h;
        return qVar != null ? qVar.call(bVar, j0Var) : j0Var;
    }

    public static rx.h E(rx.h hVar) {
        rx.functions.p<rx.h, rx.h> pVar = f54445i;
        return pVar != null ? pVar.call(hVar) : hVar;
    }

    public static b.j0 F(b.j0 j0Var) {
        rx.functions.p<b.j0, b.j0> pVar = f54441e;
        return pVar != null ? pVar.call(j0Var) : j0Var;
    }

    public static <T> e.a<T> G(e.a<T> aVar) {
        rx.functions.p<e.a, e.a> pVar = f54439c;
        return pVar != null ? pVar.call(aVar) : aVar;
    }

    public static <T> i.t<T> H(i.t<T> tVar) {
        rx.functions.p<i.t, i.t> pVar = f54440d;
        return pVar != null ? pVar.call(tVar) : tVar;
    }

    public static void I(Throwable th) {
        rx.functions.b<Throwable> bVar = f54438b;
        if (bVar != null) {
            try {
                bVar.call(th);
                return;
            } catch (Throwable th2) {
                PrintStream printStream = System.err;
                th2.getMessage();
                printStream.getClass();
                th2.printStackTrace();
                q0(th2);
            }
        }
        q0(th);
    }

    public static rx.h J(rx.h hVar) {
        rx.functions.p<rx.h, rx.h> pVar = f54446j;
        return pVar != null ? pVar.call(hVar) : hVar;
    }

    public static rx.h K(rx.h hVar) {
        rx.functions.p<rx.h, rx.h> pVar = f54447k;
        return pVar != null ? pVar.call(hVar) : hVar;
    }

    public static Throwable L(Throwable th) {
        rx.functions.p<Throwable, Throwable> pVar = f54452p;
        return pVar != null ? pVar.call(th) : th;
    }

    public static <T, R> e.b<R, T> M(e.b<R, T> bVar) {
        rx.functions.p<e.b, e.b> pVar = f54455s;
        return pVar != null ? pVar.call(bVar) : bVar;
    }

    public static rx.m N(rx.m mVar) {
        rx.functions.p<rx.m, rx.m> pVar = f54449m;
        return pVar != null ? pVar.call(mVar) : mVar;
    }

    public static <T> e.a<T> O(rx.e<T> eVar, e.a<T> aVar) {
        rx.functions.q<rx.e, e.a, e.a> qVar = f54442f;
        return qVar != null ? qVar.call(eVar, aVar) : aVar;
    }

    public static rx.functions.a P(rx.functions.a aVar) {
        rx.functions.p<rx.functions.a, rx.functions.a> pVar = f54448l;
        return pVar != null ? pVar.call(aVar) : aVar;
    }

    public static Throwable Q(Throwable th) {
        rx.functions.p<Throwable, Throwable> pVar = f54453q;
        return pVar != null ? pVar.call(th) : th;
    }

    public static <T, R> e.b<R, T> R(e.b<R, T> bVar) {
        rx.functions.p<e.b, e.b> pVar = f54456t;
        return pVar != null ? pVar.call(bVar) : bVar;
    }

    public static rx.m S(rx.m mVar) {
        rx.functions.p<rx.m, rx.m> pVar = f54450n;
        return pVar != null ? pVar.call(mVar) : mVar;
    }

    public static <T> i.t<T> T(rx.i<T> iVar, i.t<T> tVar) {
        rx.functions.q<rx.i, i.t, i.t> qVar = f54443g;
        return qVar != null ? qVar.call(iVar, tVar) : tVar;
    }

    public static void U() {
        if (f54437a) {
            return;
        }
        x();
        f54445i = null;
        f54446j = null;
        f54447k = null;
        f54451o = null;
    }

    public static void V() {
        if (f54437a) {
            return;
        }
        y();
    }

    public static void W(rx.functions.p<b.j0, b.j0> pVar) {
        if (f54437a) {
            return;
        }
        f54441e = pVar;
    }

    public static void X(rx.functions.p<b.k0, b.k0> pVar) {
        if (f54437a) {
            return;
        }
        f54457u = pVar;
    }

    public static void Y(rx.functions.q<rx.b, b.j0, b.j0> qVar) {
        if (f54437a) {
            return;
        }
        f54444h = qVar;
    }

    public static void Z(rx.functions.p<Throwable, Throwable> pVar) {
        if (f54437a) {
            return;
        }
        f54454r = pVar;
    }

    public static void a() {
        if (f54437a) {
            return;
        }
        f54438b = null;
        f54439c = null;
        f54442f = null;
        f54449m = null;
        f54452p = null;
        f54455s = null;
        f54440d = null;
        f54443g = null;
        f54450n = null;
        f54453q = null;
        f54456t = null;
        f54441e = null;
        f54444h = null;
        f54454r = null;
        f54457u = null;
        f54445i = null;
        f54446j = null;
        f54447k = null;
        f54448l = null;
        f54451o = null;
    }

    public static void a0(rx.functions.p<rx.h, rx.h> pVar) {
        if (f54437a) {
            return;
        }
        f54445i = pVar;
    }

    public static void b() {
        if (f54437a) {
            return;
        }
        f54439c = null;
        f54440d = null;
        f54441e = null;
    }

    public static void b0(rx.functions.b<Throwable> bVar) {
        if (f54437a) {
            return;
        }
        f54438b = bVar;
    }

    public static void c() {
        if (f54437a) {
            return;
        }
        f54439c = new h();
        f54440d = new i();
        f54441e = new j();
    }

    public static void c0(rx.functions.o<? extends ScheduledExecutorService> oVar) {
        if (f54437a) {
            return;
        }
        f54451o = oVar;
    }

    public static rx.functions.p<b.j0, b.j0> d() {
        return f54441e;
    }

    public static void d0(rx.functions.p<rx.h, rx.h> pVar) {
        if (f54437a) {
            return;
        }
        f54446j = pVar;
    }

    public static rx.functions.p<b.k0, b.k0> e() {
        return f54457u;
    }

    public static void e0(rx.functions.p<rx.h, rx.h> pVar) {
        if (f54437a) {
            return;
        }
        f54447k = pVar;
    }

    public static rx.functions.q<rx.b, b.j0, b.j0> f() {
        return f54444h;
    }

    public static void f0(rx.functions.p<e.a, e.a> pVar) {
        if (f54437a) {
            return;
        }
        f54439c = pVar;
    }

    public static rx.functions.p<Throwable, Throwable> g() {
        return f54454r;
    }

    public static void g0(rx.functions.p<e.b, e.b> pVar) {
        if (f54437a) {
            return;
        }
        f54455s = pVar;
    }

    public static rx.functions.p<rx.h, rx.h> h() {
        return f54445i;
    }

    public static void h0(rx.functions.p<rx.m, rx.m> pVar) {
        if (f54437a) {
            return;
        }
        f54449m = pVar;
    }

    public static rx.functions.b<Throwable> i() {
        return f54438b;
    }

    public static void i0(rx.functions.q<rx.e, e.a, e.a> qVar) {
        if (f54437a) {
            return;
        }
        f54442f = qVar;
    }

    public static rx.functions.o<? extends ScheduledExecutorService> j() {
        return f54451o;
    }

    public static void j0(rx.functions.p<Throwable, Throwable> pVar) {
        if (f54437a) {
            return;
        }
        f54452p = pVar;
    }

    public static rx.functions.p<rx.h, rx.h> k() {
        return f54446j;
    }

    public static void k0(rx.functions.p<rx.functions.a, rx.functions.a> pVar) {
        if (f54437a) {
            return;
        }
        f54448l = pVar;
    }

    public static rx.functions.p<rx.h, rx.h> l() {
        return f54447k;
    }

    public static void l0(rx.functions.p<i.t, i.t> pVar) {
        if (f54437a) {
            return;
        }
        f54440d = pVar;
    }

    public static rx.functions.p<e.a, e.a> m() {
        return f54439c;
    }

    public static void m0(rx.functions.p<e.b, e.b> pVar) {
        if (f54437a) {
            return;
        }
        f54456t = pVar;
    }

    public static rx.functions.p<e.b, e.b> n() {
        return f54455s;
    }

    public static void n0(rx.functions.p<rx.m, rx.m> pVar) {
        if (f54437a) {
            return;
        }
        f54450n = pVar;
    }

    public static rx.functions.p<rx.m, rx.m> o() {
        return f54449m;
    }

    public static void o0(rx.functions.q<rx.i, i.t, i.t> qVar) {
        if (f54437a) {
            return;
        }
        f54443g = qVar;
    }

    public static rx.functions.q<rx.e, e.a, e.a> p() {
        return f54442f;
    }

    public static void p0(rx.functions.p<Throwable, Throwable> pVar) {
        if (f54437a) {
            return;
        }
        f54453q = pVar;
    }

    public static rx.functions.p<Throwable, Throwable> q() {
        return f54452p;
    }

    public static rx.functions.p<rx.functions.a, rx.functions.a> r() {
        return f54448l;
    }

    public static rx.functions.p<i.t, i.t> s() {
        return f54440d;
    }

    public static rx.functions.p<e.b, e.b> t() {
        return f54456t;
    }

    public static rx.functions.p<rx.m, rx.m> u() {
        return f54450n;
    }

    public static rx.functions.q<rx.i, i.t, i.t> v() {
        return f54443g;
    }

    public static rx.functions.p<Throwable, Throwable> w() {
        return f54453q;
    }

    static void x() {
        f54438b = new k();
        f54442f = new l();
        f54449m = new m();
        f54443g = new n();
        f54450n = new o();
        f54444h = new p();
        f54448l = new q();
        f54452p = new r();
        f54455s = new s();
        f54453q = new a();
        f54456t = new b();
        f54454r = new C1075c();
        f54457u = new d();
        y();
    }

    static void y() {
        f54439c = new e();
        f54440d = new f();
        f54441e = new g();
    }

    public static boolean z() {
        return f54437a;
    }

    static {
        x();
    }

    private c() {
        throw new IllegalStateException("No instances!");
    }

    static void q0(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
