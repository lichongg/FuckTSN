package rx.functions;

import rx.exceptions.OnErrorNotImplementedException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private static final C1023m f52416a = new C1023m();

    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, R, T7, T8, T9, T1, T2, T3] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<R, T1, T2, T3, T4, T5, T6, T7, T8, T9> implements x<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.j f52417a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f52418b;

        a(rx.functions.j jVar, Object obj) {
            this.f52417a = jVar;
            this.f52418b = obj;
        }

        @Override // rx.functions.x
        public R call(T1 t12, T2 t22, T3 t32, T4 t42, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
            this.f52417a.call(t12, t22, t32, t42, t5, t6, t7, t8, t9);
            return (R) this.f52418b;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.l f52419a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f52420b;

        b(rx.functions.l lVar, Object obj) {
            this.f52419a = lVar;
            this.f52420b = obj;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            this.f52419a.call(objArr);
            return (R) this.f52420b;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c<R> implements o<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f52421a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f52422b;

        c(rx.functions.a aVar, Object obj) {
            this.f52421a = aVar;
            this.f52422b = obj;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public R call() {
            this.f52421a.call();
            return (R) this.f52422b;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T1] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d<R, T1> implements p<T1, R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f52423a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f52424b;

        d(rx.functions.b bVar, Object obj) {
            this.f52423a = bVar;
            this.f52424b = obj;
        }

        @Override // rx.functions.p
        public R call(T1 t12) {
            this.f52423a.call(t12);
            return (R) this.f52424b;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T1, T2] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e<R, T1, T2> implements q<T1, T2, R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.c f52425a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f52426b;

        e(rx.functions.c cVar, Object obj) {
            this.f52425a = cVar;
            this.f52426b = obj;
        }

        @Override // rx.functions.q
        public R call(T1 t12, T2 t22) {
            this.f52425a.call(t12, t22);
            return (R) this.f52426b;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T1, T2, T3] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class f<R, T1, T2, T3> implements r<T1, T2, T3, R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.d f52427a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f52428b;

        f(rx.functions.d dVar, Object obj) {
            this.f52427a = dVar;
            this.f52428b = obj;
        }

        @Override // rx.functions.r
        public R call(T1 t12, T2 t22, T3 t32) {
            this.f52427a.call(t12, t22, t32);
            return (R) this.f52428b;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T4, R, T1, T2, T3] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class g<R, T1, T2, T3, T4> implements s<T1, T2, T3, T4, R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.e f52429a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f52430b;

        g(rx.functions.e eVar, Object obj) {
            this.f52429a = eVar;
            this.f52430b = obj;
        }

        @Override // rx.functions.s
        public R call(T1 t12, T2 t22, T3 t32, T4 t42) {
            this.f52429a.call(t12, t22, t32, t42);
            return (R) this.f52430b;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T4, T5, R, T1, T2, T3] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class h<R, T1, T2, T3, T4, T5> implements t<T1, T2, T3, T4, T5, R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.f f52431a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f52432b;

        h(rx.functions.f fVar, Object obj) {
            this.f52431a = fVar;
            this.f52432b = obj;
        }

        @Override // rx.functions.t
        public R call(T1 t12, T2 t22, T3 t32, T4 t42, T5 t5) {
            this.f52431a.call(t12, t22, t32, t42, t5);
            return (R) this.f52432b;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, R, T1, T2, T3] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class i<R, T1, T2, T3, T4, T5, T6> implements u<T1, T2, T3, T4, T5, T6, R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.g f52433a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f52434b;

        i(rx.functions.g gVar, Object obj) {
            this.f52433a = gVar;
            this.f52434b = obj;
        }

        @Override // rx.functions.u
        public R call(T1 t12, T2 t22, T3 t32, T4 t42, T5 t5, T6 t6) {
            this.f52433a.call(t12, t22, t32, t42, t5, t6);
            return (R) this.f52434b;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, R, T7, T1, T2, T3] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class j<R, T1, T2, T3, T4, T5, T6, T7> implements v<T1, T2, T3, T4, T5, T6, T7, R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.h f52435a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f52436b;

        j(rx.functions.h hVar, Object obj) {
            this.f52435a = hVar;
            this.f52436b = obj;
        }

        @Override // rx.functions.v
        public R call(T1 t12, T2 t22, T3 t32, T4 t42, T5 t5, T6 t6, T7 t7) {
            this.f52435a.call(t12, t22, t32, t42, t5, t6, t7);
            return (R) this.f52436b;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, R, T7, T8, T1, T2, T3] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class k<R, T1, T2, T3, T4, T5, T6, T7, T8> implements w<T1, T2, T3, T4, T5, T6, T7, T8, R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.i f52437a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f52438b;

        k(rx.functions.i iVar, Object obj) {
            this.f52437a = iVar;
            this.f52438b = obj;
        }

        @Override // rx.functions.w
        public R call(T1 t12, T2 t22, T3 t32, T4 t42, T5 t5, T6 t6, T7 t7, T8 t8) {
            this.f52437a.call(t12, t22, t32, t42, t5, t6, t7, t8);
            return (R) this.f52438b;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class l<T> implements rx.functions.b<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.functions.a f52439a;

        @Override // rx.functions.b
        public void call(T t5) {
            this.f52439a.call();
        }

        public l(rx.functions.a aVar) {
            this.f52439a = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.functions.m$m, reason: collision with other inner class name */
    public static final class C1023m<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements rx.functions.a, rx.functions.b<T0>, rx.functions.c<T0, T1>, rx.functions.d<T0, T1, T2>, rx.functions.e<T0, T1, T2, T3>, rx.functions.f<T0, T1, T2, T3, T4>, rx.functions.g<T0, T1, T2, T3, T4, T5>, rx.functions.h<T0, T1, T2, T3, T4, T5, T6>, rx.functions.i<T0, T1, T2, T3, T4, T5, T6, T7>, rx.functions.j<T0, T1, T2, T3, T4, T5, T6, T7, T8>, rx.functions.l {
        @Override // rx.functions.a
        public void call() {
        }

        @Override // rx.functions.b
        public void call(T0 t02) {
        }

        C1023m() {
        }

        @Override // rx.functions.c
        public void call(T0 t02, T1 t12) {
        }

        @Override // rx.functions.d
        public void call(T0 t02, T1 t12, T2 t22) {
        }

        @Override // rx.functions.e
        public void call(T0 t02, T1 t12, T2 t22, T3 t32) {
        }

        @Override // rx.functions.f
        public void call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42) {
        }

        @Override // rx.functions.g
        public void call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42, T5 t5) {
        }

        @Override // rx.functions.h
        public void call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42, T5 t5, T6 t6) {
        }

        @Override // rx.functions.i
        public void call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42, T5 t5, T6 t6, T7 t7) {
        }

        @Override // rx.functions.j
        public void call(T0 t02, T1 t12, T2 t22, T3 t32, T4 t42, T5 t5, T6 t6, T7 t7, T8 t8) {
        }

        @Override // rx.functions.l
        public void call(Object... objArr) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum n implements rx.functions.b<Throwable> {
        INSTANCE;

        @Override // rx.functions.b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }

    public static o<Void> d(rx.functions.a aVar) {
        return e(aVar, null);
    }

    public static <T1> p<T1, Void> f(rx.functions.b<T1> bVar) {
        return g(bVar, null);
    }

    public static <T1, T2> q<T1, T2, Void> h(rx.functions.c<T1, T2> cVar) {
        return i(cVar, null);
    }

    public static <T1, T2, T3> r<T1, T2, T3, Void> j(rx.functions.d<T1, T2, T3> dVar) {
        return k(dVar, null);
    }

    public static <T1, T2, T3, T4> s<T1, T2, T3, T4, Void> l(rx.functions.e<T1, T2, T3, T4> eVar) {
        return m(eVar, null);
    }

    public static <T1, T2, T3, T4, T5> t<T1, T2, T3, T4, T5, Void> n(rx.functions.f<T1, T2, T3, T4, T5> fVar) {
        return o(fVar, null);
    }

    public static <T1, T2, T3, T4, T5, T6> u<T1, T2, T3, T4, T5, T6, Void> p(rx.functions.g<T1, T2, T3, T4, T5, T6> gVar) {
        return q(gVar, null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7> v<T1, T2, T3, T4, T5, T6, T7, Void> r(rx.functions.h<T1, T2, T3, T4, T5, T6, T7> hVar) {
        return s(hVar, null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> w<T1, T2, T3, T4, T5, T6, T7, T8, Void> t(rx.functions.i<T1, T2, T3, T4, T5, T6, T7, T8> iVar) {
        return u(iVar, null);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> x<T1, T2, T3, T4, T5, T6, T7, T8, T9, Void> v(rx.functions.j<T1, T2, T3, T4, T5, T6, T7, T8, T9> jVar) {
        return w(jVar, null);
    }

    public static y<Void> x(rx.functions.l lVar) {
        return y(lVar, null);
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> C1023m<T0, T1, T2, T3, T4, T5, T6, T7, T8> a() {
        return f52416a;
    }

    public static rx.functions.b<Throwable> b() {
        return n.INSTANCE;
    }

    public static <T> rx.functions.b<T> c(rx.functions.a aVar) {
        return new l(aVar);
    }

    public static <R> o<R> e(rx.functions.a aVar, R r5) {
        return new c(aVar, r5);
    }

    public static <T1, R> p<T1, R> g(rx.functions.b<T1> bVar, R r5) {
        return new d(bVar, r5);
    }

    public static <T1, T2, R> q<T1, T2, R> i(rx.functions.c<T1, T2> cVar, R r5) {
        return new e(cVar, r5);
    }

    public static <T1, T2, T3, R> r<T1, T2, T3, R> k(rx.functions.d<T1, T2, T3> dVar, R r5) {
        return new f(dVar, r5);
    }

    public static <T1, T2, T3, T4, R> s<T1, T2, T3, T4, R> m(rx.functions.e<T1, T2, T3, T4> eVar, R r5) {
        return new g(eVar, r5);
    }

    public static <T1, T2, T3, T4, T5, R> t<T1, T2, T3, T4, T5, R> o(rx.functions.f<T1, T2, T3, T4, T5> fVar, R r5) {
        return new h(fVar, r5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> u<T1, T2, T3, T4, T5, T6, R> q(rx.functions.g<T1, T2, T3, T4, T5, T6> gVar, R r5) {
        return new i(gVar, r5);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> v<T1, T2, T3, T4, T5, T6, T7, R> s(rx.functions.h<T1, T2, T3, T4, T5, T6, T7> hVar, R r5) {
        return new j(hVar, r5);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> w<T1, T2, T3, T4, T5, T6, T7, T8, R> u(rx.functions.i<T1, T2, T3, T4, T5, T6, T7, T8> iVar, R r5) {
        return new k(iVar, r5);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> x<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> w(rx.functions.j<T1, T2, T3, T4, T5, T6, T7, T8, T9> jVar, R r5) {
        return new a(jVar, r5);
    }

    public static <R> y<R> y(rx.functions.l lVar, R r5) {
        return new b(lVar, r5);
    }

    private m() {
        throw new IllegalStateException("No instances!");
    }
}
