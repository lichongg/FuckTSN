package rx.observables;

import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.functions.o;
import rx.functions.q;
import rx.l;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class e<S, T> implements e.a<T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements q<S, rx.f<? super T>, S> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.c f54381a;

        @Override // rx.functions.q
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2) {
            return call((a) obj, (rx.f) obj2);
        }

        a(rx.functions.c cVar) {
            this.f54381a = cVar;
        }

        public S call(S s5, rx.f<? super T> fVar) {
            this.f54381a.call(s5, fVar);
            return s5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements q<S, rx.f<? super T>, S> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.c f54382a;

        @Override // rx.functions.q
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2) {
            return call((b) obj, (rx.f) obj2);
        }

        b(rx.functions.c cVar) {
            this.f54382a = cVar;
        }

        public S call(S s5, rx.f<? super T> fVar) {
            this.f54382a.call(s5, fVar);
            return s5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements q<Void, rx.f<? super T>, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54383a;

        c(rx.functions.b bVar) {
            this.f54383a = bVar;
        }

        @Override // rx.functions.q
        public Void call(Void r22, rx.f<? super T> fVar) {
            this.f54383a.call(fVar);
            return r22;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d implements q<Void, rx.f<? super T>, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54384a;

        d(rx.functions.b bVar) {
            this.f54384a = bVar;
        }

        @Override // rx.functions.q
        public Void call(Void r12, rx.f<? super T> fVar) {
            this.f54384a.call(fVar);
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.observables.e$e, reason: collision with other inner class name */
    static class C1073e implements rx.functions.b<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f54385a;

        C1073e(rx.functions.a aVar) {
            this.f54385a = aVar;
        }

        @Override // rx.functions.b
        public void call(Void r12) {
            this.f54385a.call();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class f<S, T> extends AtomicLong implements rx.g, m, rx.f<T> {
        private static final long serialVersionUID = -3736864024352728072L;

        /* renamed from: a, reason: collision with root package name */
        private final l<? super T> f54386a;

        /* renamed from: b, reason: collision with root package name */
        private final e<S, T> f54387b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f54388c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f54389d;

        /* renamed from: e, reason: collision with root package name */
        private S f54390e;

        private void d() {
            try {
                this.f54387b.i(this.f54390e);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                rx.plugins.c.I(th);
            }
        }

        private void e() {
            e<S, T> eVar = this.f54387b;
            l<? super T> lVar = this.f54386a;
            do {
                try {
                    this.f54388c = false;
                    g(eVar);
                } catch (Throwable th) {
                    f(lVar, th);
                    return;
                }
            } while (!s());
        }

        private void f(l<? super T> lVar, Throwable th) {
            if (this.f54389d) {
                rx.plugins.c.I(th);
                return;
            }
            this.f54389d = true;
            lVar.onError(th);
            unsubscribe();
        }

        private void g(e<S, T> eVar) {
            this.f54390e = eVar.h(this.f54390e, this);
        }

        private void j(long j6) {
            e<S, T> eVar = this.f54387b;
            l<? super T> lVar = this.f54386a;
            do {
                long j7 = j6;
                do {
                    try {
                        this.f54388c = false;
                        g(eVar);
                        if (s()) {
                            return;
                        }
                        if (this.f54388c) {
                            j7--;
                        }
                    } catch (Throwable th) {
                        f(lVar, th);
                        return;
                    }
                } while (j7 != 0);
                j6 = addAndGet(-j6);
            } while (j6 > 0);
            s();
        }

        private boolean s() {
            if (!this.f54389d && get() >= -1) {
                return false;
            }
            set(-1L);
            d();
            return true;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f54389d) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.f54389d = true;
            if (this.f54386a.isUnsubscribed()) {
                return;
            }
            this.f54386a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f54389d) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.f54389d = true;
            if (this.f54386a.isUnsubscribed()) {
                return;
            }
            this.f54386a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f54388c) {
                throw new IllegalStateException("onNext called multiple times!");
            }
            this.f54388c = true;
            this.f54386a.onNext(t5);
        }

        @Override // rx.g
        public void request(long j6) {
            if (j6 <= 0 || rx.internal.operators.a.b(this, j6) != 0) {
                return;
            }
            if (j6 == Long.MAX_VALUE) {
                e();
            } else {
                j(j6);
            }
        }

        f(l<? super T> lVar, e<S, T> eVar, S s5) {
            this.f54386a = lVar;
            this.f54387b = eVar;
            this.f54390e = s5;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            if (get() < 0) {
                return true;
            }
            return false;
        }

        @Override // rx.m
        public void unsubscribe() {
            long j6;
            do {
                j6 = get();
                if (compareAndSet(0L, -1L)) {
                    d();
                    return;
                }
            } while (!compareAndSet(j6, -2L));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class g<S, T> extends e<S, T> {

        /* renamed from: a, reason: collision with root package name */
        private final o<? extends S> f54391a;

        /* renamed from: b, reason: collision with root package name */
        private final q<? super S, ? super rx.f<? super T>, ? extends S> f54392b;

        /* renamed from: c, reason: collision with root package name */
        private final rx.functions.b<? super S> f54393c;

        g(o<? extends S> oVar, q<? super S, ? super rx.f<? super T>, ? extends S> qVar, rx.functions.b<? super S> bVar) {
            this.f54391a = oVar;
            this.f54392b = qVar;
            this.f54393c = bVar;
        }

        @Override // rx.observables.e, rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            super.call((l) obj);
        }

        @Override // rx.observables.e
        protected S g() {
            o<? extends S> oVar = this.f54391a;
            if (oVar == null) {
                return null;
            }
            return oVar.call();
        }

        @Override // rx.observables.e
        protected S h(S s5, rx.f<? super T> fVar) {
            return this.f54392b.call(s5, fVar);
        }

        @Override // rx.observables.e
        protected void i(S s5) {
            rx.functions.b<? super S> bVar = this.f54393c;
            if (bVar != null) {
                bVar.call(s5);
            }
        }

        public g(o<? extends S> oVar, q<? super S, ? super rx.f<? super T>, ? extends S> qVar) {
            this(oVar, qVar, null);
        }

        public g(q<S, rx.f<? super T>, S> qVar, rx.functions.b<? super S> bVar) {
            this(null, qVar, bVar);
        }

        public g(q<S, rx.f<? super T>, S> qVar) {
            this(null, qVar, null);
        }
    }

    protected abstract S g();

    protected abstract S h(S s5, rx.f<? super T> fVar);

    public static <S, T> e<S, T> a(o<? extends S> oVar, rx.functions.c<? super S, ? super rx.f<? super T>> cVar) {
        return new g(oVar, new a(cVar));
    }

    public static <S, T> e<S, T> b(o<? extends S> oVar, rx.functions.c<? super S, ? super rx.f<? super T>> cVar, rx.functions.b<? super S> bVar) {
        return new g(oVar, new b(cVar), bVar);
    }

    public static <S, T> e<S, T> c(o<? extends S> oVar, q<? super S, ? super rx.f<? super T>, ? extends S> qVar) {
        return new g(oVar, qVar);
    }

    public static <S, T> e<S, T> d(o<? extends S> oVar, q<? super S, ? super rx.f<? super T>, ? extends S> qVar, rx.functions.b<? super S> bVar) {
        return new g(oVar, qVar, bVar);
    }

    public static <T> e<Void, T> e(rx.functions.b<? super rx.f<? super T>> bVar) {
        return new g(new c(bVar));
    }

    public static <T> e<Void, T> f(rx.functions.b<? super rx.f<? super T>> bVar, rx.functions.a aVar) {
        return new g(new d(bVar), new C1073e(aVar));
    }

    @Override // rx.functions.b
    public final void call(l<? super T> lVar) {
        try {
            f fVar = new f(lVar, this, g());
            lVar.add(fVar);
            lVar.setProducer(fVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            lVar.onError(th);
        }
    }

    protected void i(S s5) {
    }
}
