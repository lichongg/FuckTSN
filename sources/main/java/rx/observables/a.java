package rx.observables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.annotations.Beta;
import rx.e;
import rx.functions.o;
import rx.functions.p;
import rx.functions.r;
import rx.l;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class a<S, T> implements e.a<T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.observables.a$a, reason: collision with other inner class name */
    static class C1069a implements r<S, Long, rx.f<rx.e<? extends T>>, S> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.d f54317a;

        @Override // rx.functions.r
        public /* bridge */ /* synthetic */ Object call(Object obj, Long l6, Object obj2) {
            return call((C1069a) obj, l6, (rx.f) obj2);
        }

        C1069a(rx.functions.d dVar) {
            this.f54317a = dVar;
        }

        public S call(S s5, Long l6, rx.f<rx.e<? extends T>> fVar) {
            this.f54317a.call(s5, l6, fVar);
            return s5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements r<S, Long, rx.f<rx.e<? extends T>>, S> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.d f54318a;

        @Override // rx.functions.r
        public /* bridge */ /* synthetic */ Object call(Object obj, Long l6, Object obj2) {
            return call((b) obj, l6, (rx.f) obj2);
        }

        b(rx.functions.d dVar) {
            this.f54318a = dVar;
        }

        public S call(S s5, Long l6, rx.f<rx.e<? extends T>> fVar) {
            this.f54318a.call(s5, l6, fVar);
            return s5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements r<Void, Long, rx.f<rx.e<? extends T>>, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.c f54319a;

        c(rx.functions.c cVar) {
            this.f54319a = cVar;
        }

        @Override // rx.functions.r
        public Void call(Void r22, Long l6, rx.f<rx.e<? extends T>> fVar) {
            this.f54319a.call(l6, fVar);
            return r22;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d implements r<Void, Long, rx.f<rx.e<? extends T>>, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.c f54320a;

        d(rx.functions.c cVar) {
            this.f54320a = cVar;
        }

        @Override // rx.functions.r
        public Void call(Void r12, Long l6, rx.f<rx.e<? extends T>> fVar) {
            this.f54320a.call(l6, fVar);
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e implements rx.functions.b<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f54321a;

        e(rx.functions.a aVar) {
            this.f54321a = aVar;
        }

        @Override // rx.functions.b
        public void call(Void r12) {
            this.f54321a.call();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f54322a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f54323b;

        f(l lVar, i iVar) {
            this.f54322a = lVar;
            this.f54323b = iVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f54322a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f54322a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f54322a.onNext(t5);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f54323b.s(gVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements p<rx.e<T>, rx.e<T>> {
        g() {
        }

        @Override // rx.functions.p
        public rx.e<T> call(rx.e<T> eVar) {
            return eVar.N3();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class h<S, T> extends a<S, T> {

        /* renamed from: a, reason: collision with root package name */
        private final o<? extends S> f54326a;

        /* renamed from: b, reason: collision with root package name */
        private final r<? super S, Long, ? super rx.f<rx.e<? extends T>>, ? extends S> f54327b;

        /* renamed from: c, reason: collision with root package name */
        private final rx.functions.b<? super S> f54328c;

        h(o<? extends S> oVar, r<? super S, Long, ? super rx.f<rx.e<? extends T>>, ? extends S> rVar, rx.functions.b<? super S> bVar) {
            this.f54326a = oVar;
            this.f54327b = rVar;
            this.f54328c = bVar;
        }

        @Override // rx.observables.a, rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            super.call((l) obj);
        }

        @Override // rx.observables.a
        protected S g() {
            o<? extends S> oVar = this.f54326a;
            if (oVar == null) {
                return null;
            }
            return oVar.call();
        }

        @Override // rx.observables.a
        protected S h(S s5, long j6, rx.f<rx.e<? extends T>> fVar) {
            return this.f54327b.call(s5, Long.valueOf(j6), fVar);
        }

        @Override // rx.observables.a
        protected void i(S s5) {
            rx.functions.b<? super S> bVar = this.f54328c;
            if (bVar != null) {
                bVar.call(s5);
            }
        }

        public h(o<? extends S> oVar, r<? super S, Long, ? super rx.f<rx.e<? extends T>>, ? extends S> rVar) {
            this(oVar, rVar, null);
        }

        public h(r<S, Long, rx.f<rx.e<? extends T>>, S> rVar, rx.functions.b<? super S> bVar) {
            this(null, rVar, bVar);
        }

        public h(r<S, Long, rx.f<rx.e<? extends T>>, S> rVar) {
            this(null, rVar, null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class i<S, T> implements rx.g, m, rx.f<rx.e<? extends T>> {

        /* renamed from: b, reason: collision with root package name */
        private final a<S, T> f54330b;

        /* renamed from: e, reason: collision with root package name */
        private boolean f54333e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f54334f;

        /* renamed from: g, reason: collision with root package name */
        private S f54335g;

        /* renamed from: h, reason: collision with root package name */
        private final j<rx.e<T>> f54336h;

        /* renamed from: i, reason: collision with root package name */
        boolean f54337i;

        /* renamed from: j, reason: collision with root package name */
        List<Long> f54338j;

        /* renamed from: k, reason: collision with root package name */
        rx.g f54339k;

        /* renamed from: l, reason: collision with root package name */
        long f54340l;

        /* renamed from: d, reason: collision with root package name */
        final rx.subscriptions.b f54332d = new rx.subscriptions.b();

        /* renamed from: c, reason: collision with root package name */
        private final rx.observers.f<rx.e<? extends T>> f54331c = new rx.observers.f<>(this);

        /* renamed from: a, reason: collision with root package name */
        final AtomicBoolean f54329a = new AtomicBoolean();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.observables.a$i$a, reason: collision with other inner class name */
        class C1070a extends l<T> {

            /* renamed from: a, reason: collision with root package name */
            long f54341a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f54342b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ rx.internal.operators.g f54343c;

            C1070a(long j6, rx.internal.operators.g gVar) {
                this.f54342b = j6;
                this.f54343c = gVar;
                this.f54341a = j6;
            }

            @Override // rx.f
            public void onCompleted() {
                this.f54343c.onCompleted();
                long j6 = this.f54341a;
                if (j6 > 0) {
                    i.this.j(j6);
                }
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f54343c.onError(th);
            }

            @Override // rx.f
            public void onNext(T t5) {
                this.f54341a--;
                this.f54343c.onNext(t5);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ l f54345a;

            b(l lVar) {
                this.f54345a = lVar;
            }

            @Override // rx.functions.a
            public void call() {
                i.this.f54332d.f(this.f54345a);
            }
        }

        private void e(Throwable th) {
            if (this.f54333e) {
                rx.plugins.c.I(th);
                return;
            }
            this.f54333e = true;
            this.f54336h.onError(th);
            d();
        }

        void d() {
            this.f54332d.unsubscribe();
            try {
                this.f54330b.i(this.f54335g);
            } catch (Throwable th) {
                e(th);
            }
        }

        public void f(long j6) {
            this.f54335g = this.f54330b.h(this.f54335g, j6, this.f54331c);
        }

        @Override // rx.f
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onNext(rx.e<? extends T> eVar) {
            if (this.f54334f) {
                throw new IllegalStateException("onNext called multiple times!");
            }
            this.f54334f = true;
            if (this.f54333e) {
                return;
            }
            A(eVar);
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f54329a.get();
        }

        public void j(long j6) {
            if (j6 == 0) {
                return;
            }
            if (j6 < 0) {
                throw new IllegalStateException("Request can't be negative! " + j6);
            }
            synchronized (this) {
                try {
                    if (this.f54337i) {
                        List list = this.f54338j;
                        if (list == null) {
                            list = new ArrayList();
                            this.f54338j = list;
                        }
                        list.add(Long.valueOf(j6));
                        return;
                    }
                    this.f54337i = true;
                    if (B(j6)) {
                        return;
                    }
                    while (true) {
                        synchronized (this) {
                            try {
                                List<Long> list2 = this.f54338j;
                                if (list2 == null) {
                                    this.f54337i = false;
                                    return;
                                }
                                this.f54338j = null;
                                Iterator<Long> it = list2.iterator();
                                while (it.hasNext()) {
                                    if (B(it.next().longValue())) {
                                        return;
                                    }
                                }
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f54333e) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.f54333e = true;
            this.f54336h.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f54333e) {
                throw new IllegalStateException("Terminal event already emitted.");
            }
            this.f54333e = true;
            this.f54336h.onError(th);
        }

        @Override // rx.g
        public void request(long j6) {
            boolean z5;
            if (j6 == 0) {
                return;
            }
            if (j6 < 0) {
                throw new IllegalStateException("Request can't be negative! " + j6);
            }
            synchronized (this) {
                try {
                    z5 = true;
                    if (this.f54337i) {
                        List list = this.f54338j;
                        if (list == null) {
                            list = new ArrayList();
                            this.f54338j = list;
                        }
                        list.add(Long.valueOf(j6));
                    } else {
                        this.f54337i = true;
                        z5 = false;
                    }
                } finally {
                }
            }
            this.f54339k.request(j6);
            if (z5 || B(j6)) {
                return;
            }
            while (true) {
                synchronized (this) {
                    try {
                        List<Long> list2 = this.f54338j;
                        if (list2 == null) {
                            this.f54337i = false;
                            return;
                        }
                        this.f54338j = null;
                        Iterator<Long> it = list2.iterator();
                        while (it.hasNext()) {
                            if (B(it.next().longValue())) {
                                return;
                            }
                        }
                    } finally {
                    }
                }
            }
        }

        void s(rx.g gVar) {
            if (this.f54339k != null) {
                throw new IllegalStateException("setConcatProducer may be called at most once!");
            }
            this.f54339k = gVar;
        }

        @Override // rx.m
        public void unsubscribe() {
            if (this.f54329a.compareAndSet(false, true)) {
                synchronized (this) {
                    try {
                        if (!this.f54337i) {
                            this.f54337i = true;
                            d();
                        } else {
                            ArrayList arrayList = new ArrayList();
                            this.f54338j = arrayList;
                            arrayList.add(0L);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public i(a<S, T> aVar, S s5, j<rx.e<T>> jVar) {
            this.f54330b = aVar;
            this.f54335g = s5;
            this.f54336h = jVar;
        }

        private void A(rx.e<? extends T> eVar) {
            rx.internal.operators.g y7 = rx.internal.operators.g.y7();
            C1070a c1070a = new C1070a(this.f54340l, y7);
            this.f54332d.a(c1070a);
            eVar.O1(new b(c1070a)).r5(c1070a);
            this.f54336h.onNext(y7);
        }

        boolean B(long j6) {
            if (isUnsubscribed()) {
                d();
                return true;
            }
            try {
                this.f54334f = false;
                this.f54340l = j6;
                f(j6);
                if (this.f54333e) {
                    if (this.f54332d.e()) {
                    }
                    d();
                    return true;
                }
                if (!isUnsubscribed()) {
                    if (this.f54334f) {
                        return false;
                    }
                    e(new IllegalStateException("No events emitted!"));
                    return true;
                }
                d();
                return true;
            } catch (Throwable th) {
                e(th);
                return true;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class j<T> extends rx.e<T> implements rx.f<T> {

        /* renamed from: b, reason: collision with root package name */
        private final C1071a<T> f54347b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.observables.a$j$a, reason: collision with other inner class name */
        static final class C1071a<T> implements e.a<T> {

            /* renamed from: a, reason: collision with root package name */
            l<? super T> f54348a;

            @Override // rx.functions.b
            public void call(l<? super T> lVar) {
                synchronized (this) {
                    try {
                        if (this.f54348a == null) {
                            this.f54348a = lVar;
                        } else {
                            lVar.onError(new IllegalStateException("There can be only one subscriber"));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            C1071a() {
            }
        }

        public static <T> j<T> w7() {
            return new j<>(new C1071a());
        }

        @Override // rx.f
        public void onCompleted() {
            this.f54347b.f54348a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f54347b.f54348a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f54347b.f54348a.onNext(t5);
        }

        protected j(C1071a<T> c1071a) {
            super(c1071a);
            this.f54347b = c1071a;
        }
    }

    protected abstract S g();

    protected abstract S h(S s5, long j6, rx.f<rx.e<? extends T>> fVar);

    public static <S, T> a<S, T> a(o<? extends S> oVar, rx.functions.d<? super S, Long, ? super rx.f<rx.e<? extends T>>> dVar) {
        return new h(oVar, new C1069a(dVar));
    }

    public static <S, T> a<S, T> b(o<? extends S> oVar, rx.functions.d<? super S, Long, ? super rx.f<rx.e<? extends T>>> dVar, rx.functions.b<? super S> bVar) {
        return new h(oVar, new b(dVar), bVar);
    }

    public static <S, T> a<S, T> c(o<? extends S> oVar, r<? super S, Long, ? super rx.f<rx.e<? extends T>>, ? extends S> rVar) {
        return new h(oVar, rVar);
    }

    public static <S, T> a<S, T> d(o<? extends S> oVar, r<? super S, Long, ? super rx.f<rx.e<? extends T>>, ? extends S> rVar, rx.functions.b<? super S> bVar) {
        return new h(oVar, rVar, bVar);
    }

    public static <T> a<Void, T> e(rx.functions.c<Long, ? super rx.f<rx.e<? extends T>>> cVar) {
        return new h(new c(cVar));
    }

    public static <T> a<Void, T> f(rx.functions.c<Long, ? super rx.f<rx.e<? extends T>>> cVar, rx.functions.a aVar) {
        return new h(new d(cVar), new e(aVar));
    }

    @Override // rx.functions.b
    public final void call(l<? super T> lVar) {
        try {
            S g6 = g();
            j w7 = j.w7();
            i iVar = new i(this, g6, w7);
            f fVar = new f(lVar, iVar);
            w7.N3().Z0(new g()).J6(fVar);
            lVar.add(fVar);
            lVar.add(iVar);
            lVar.setProducer(iVar);
        } catch (Throwable th) {
            lVar.onError(th);
        }
    }

    protected void i(S s5) {
    }
}
