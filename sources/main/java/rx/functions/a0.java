package rx.functions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a0 {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f52402a;

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 9) {
                return (R) this.f52402a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Func9 expecting 9 arguments.");
        }

        a(x xVar) {
            this.f52402a = xVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements y<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f52403a;

        b(rx.functions.a aVar) {
            this.f52403a = aVar;
        }

        @Override // rx.functions.y
        public Void call(Object... objArr) {
            if (objArr.length != 0) {
                throw new IllegalArgumentException("Action0 expecting 0 arguments.");
            }
            this.f52403a.call();
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements y<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f52404a;

        c(rx.functions.b bVar) {
            this.f52404a = bVar;
        }

        @Override // rx.functions.y
        public Void call(Object... objArr) {
            if (objArr.length != 1) {
                throw new IllegalArgumentException("Action1 expecting 1 argument.");
            }
            this.f52404a.call(objArr[0]);
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d implements y<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.c f52405a;

        d(rx.functions.c cVar) {
            this.f52405a = cVar;
        }

        @Override // rx.functions.y
        public Void call(Object... objArr) {
            if (objArr.length != 2) {
                throw new IllegalArgumentException("Action3 expecting 2 arguments.");
            }
            this.f52405a.call(objArr[0], objArr[1]);
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e implements y<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.d f52406a;

        e(rx.functions.d dVar) {
            this.f52406a = dVar;
        }

        @Override // rx.functions.y
        public Void call(Object... objArr) {
            if (objArr.length != 3) {
                throw new IllegalArgumentException("Action3 expecting 3 arguments.");
            }
            this.f52406a.call(objArr[0], objArr[1], objArr[2]);
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class f<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o f52407a;

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 0) {
                return (R) this.f52407a.call();
            }
            throw new IllegalArgumentException("Func0 expecting 0 arguments.");
        }

        f(o oVar) {
            this.f52407a = oVar;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class g<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f52408a;

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 1) {
                return (R) this.f52408a.call(objArr[0]);
            }
            throw new IllegalArgumentException("Func1 expecting 1 argument.");
        }

        g(p pVar) {
            this.f52408a = pVar;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class h<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f52409a;

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 2) {
                return (R) this.f52409a.call(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Func2 expecting 2 arguments.");
        }

        h(q qVar) {
            this.f52409a = qVar;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class i<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f52410a;

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 3) {
                return (R) this.f52410a.call(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Func3 expecting 3 arguments.");
        }

        i(r rVar) {
            this.f52410a = rVar;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class j<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f52411a;

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 4) {
                return (R) this.f52411a.call(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Func4 expecting 4 arguments.");
        }

        j(s sVar) {
            this.f52411a = sVar;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class k<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f52412a;

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 5) {
                return (R) this.f52412a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Func5 expecting 5 arguments.");
        }

        k(t tVar) {
            this.f52412a = tVar;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class l<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f52413a;

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 6) {
                return (R) this.f52413a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Func6 expecting 6 arguments.");
        }

        l(u uVar) {
            this.f52413a = uVar;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class m<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f52414a;

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 7) {
                return (R) this.f52414a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Func7 expecting 7 arguments.");
        }

        m(v vVar) {
            this.f52414a = vVar;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class n<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ w f52415a;

        @Override // rx.functions.y
        public R call(Object... objArr) {
            if (objArr.length == 8) {
                return (R) this.f52415a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Func8 expecting 8 arguments.");
        }

        n(w wVar) {
            this.f52415a = wVar;
        }
    }

    public static y<Void> a(rx.functions.a aVar) {
        return new b(aVar);
    }

    public static <T0> y<Void> b(rx.functions.b<? super T0> bVar) {
        return new c(bVar);
    }

    public static <T0, T1> y<Void> c(rx.functions.c<? super T0, ? super T1> cVar) {
        return new d(cVar);
    }

    public static <T0, T1, T2> y<Void> d(rx.functions.d<? super T0, ? super T1, ? super T2> dVar) {
        return new e(dVar);
    }

    public static <R> y<R> e(o<? extends R> oVar) {
        return new f(oVar);
    }

    public static <T0, R> y<R> f(p<? super T0, ? extends R> pVar) {
        return new g(pVar);
    }

    public static <T0, T1, R> y<R> g(q<? super T0, ? super T1, ? extends R> qVar) {
        return new h(qVar);
    }

    public static <T0, T1, T2, R> y<R> h(r<? super T0, ? super T1, ? super T2, ? extends R> rVar) {
        return new i(rVar);
    }

    public static <T0, T1, T2, T3, R> y<R> i(s<? super T0, ? super T1, ? super T2, ? super T3, ? extends R> sVar) {
        return new j(sVar);
    }

    public static <T0, T1, T2, T3, T4, R> y<R> j(t<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? extends R> tVar) {
        return new k(tVar);
    }

    public static <T0, T1, T2, T3, T4, T5, R> y<R> k(u<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> uVar) {
        return new l(uVar);
    }

    public static <T0, T1, T2, T3, T4, T5, T6, R> y<R> l(v<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> vVar) {
        return new m(vVar);
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, R> y<R> m(w<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> wVar) {
        return new n(wVar);
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, R> y<R> n(x<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> xVar) {
        return new a(xVar);
    }

    private a0() {
        throw new IllegalStateException("No instances!");
    }
}
