package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.e;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w0<T> implements e.a<T> {

    /* renamed from: f, reason: collision with root package name */
    static final rx.functions.p<rx.e<? extends Notification<?>>, rx.e<?>> f53655f = new a();

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T> f53656a;

    /* renamed from: b, reason: collision with root package name */
    private final rx.functions.p<? super rx.e<? extends Notification<?>>, ? extends rx.e<?>> f53657b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f53658c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f53659d;

    /* renamed from: e, reason: collision with root package name */
    private final rx.h f53660e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements rx.functions.p<rx.e<? extends Notification<?>>, rx.e<?>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.w0$a$a, reason: collision with other inner class name */
        class C1052a implements rx.functions.p<Notification<?>, Notification<?>> {
            C1052a() {
            }

            @Override // rx.functions.p
            public Notification<?> call(Notification<?> notification) {
                return Notification.e(null);
            }
        }

        @Override // rx.functions.p
        public rx.e<?> call(rx.e<? extends Notification<?>> eVar) {
            return eVar.c3(new C1052a());
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f53662a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.subjects.f f53663b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.internal.producers.a f53664c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicLong f53665d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.e f53666e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends rx.l<T> {

            /* renamed from: a, reason: collision with root package name */
            boolean f53668a;

            a() {
            }

            private void g() {
                long j6;
                do {
                    j6 = b.this.f53665d.get();
                    if (j6 == Long.MAX_VALUE) {
                        return;
                    }
                } while (!b.this.f53665d.compareAndSet(j6, j6 - 1));
            }

            @Override // rx.f
            public void onCompleted() {
                if (this.f53668a) {
                    return;
                }
                this.f53668a = true;
                unsubscribe();
                b.this.f53663b.onNext(Notification.b());
            }

            @Override // rx.f
            public void onError(Throwable th) {
                if (this.f53668a) {
                    return;
                }
                this.f53668a = true;
                unsubscribe();
                b.this.f53663b.onNext(Notification.d(th));
            }

            @Override // rx.f
            public void onNext(T t5) {
                if (this.f53668a) {
                    return;
                }
                b.this.f53662a.onNext(t5);
                g();
                b.this.f53664c.b(1L);
            }

            @Override // rx.l, rx.observers.a
            public void setProducer(rx.g gVar) {
                b.this.f53664c.c(gVar);
            }
        }

        b(rx.l lVar, rx.subjects.f fVar, rx.internal.producers.a aVar, AtomicLong atomicLong, rx.subscriptions.e eVar) {
            this.f53662a = lVar;
            this.f53663b = fVar;
            this.f53664c = aVar;
            this.f53665d = atomicLong;
            this.f53666e = eVar;
        }

        @Override // rx.functions.a
        public void call() {
            if (this.f53662a.isUnsubscribed()) {
                return;
            }
            a aVar = new a();
            this.f53666e.b(aVar);
            w0.this.f53656a.J6(aVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements e.b<Notification<?>, Notification<?>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends rx.l<Notification<?>> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.l f53671a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(rx.l lVar, rx.l lVar2) {
                super(lVar);
                this.f53671a = lVar2;
            }

            @Override // rx.f
            public void onCompleted() {
                this.f53671a.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f53671a.onError(th);
            }

            @Override // rx.f
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public void onNext(Notification<?> notification) {
                if (notification.k() && w0.this.f53658c) {
                    this.f53671a.onCompleted();
                } else if (notification.l() && w0.this.f53659d) {
                    this.f53671a.onError(notification.g());
                } else {
                    this.f53671a.onNext(notification);
                }
            }

            @Override // rx.l, rx.observers.a
            public void setProducer(rx.g gVar) {
                gVar.request(Long.MAX_VALUE);
            }
        }

        c() {
        }

        @Override // rx.functions.p
        public rx.l<? super Notification<?>> call(rx.l<? super Notification<?>> lVar) {
            return new a(lVar, lVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.e f53673a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.l f53674b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicLong f53675c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h.a f53676d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f53677e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f53678f;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends rx.l<Object> {
            a(rx.l lVar) {
                super(lVar);
            }

            @Override // rx.f
            public void onCompleted() {
                d.this.f53674b.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                d.this.f53674b.onError(th);
            }

            @Override // rx.f
            public void onNext(Object obj) {
                if (d.this.f53674b.isUnsubscribed()) {
                    return;
                }
                if (d.this.f53675c.get() <= 0) {
                    d.this.f53678f.compareAndSet(false, true);
                } else {
                    d dVar = d.this;
                    dVar.f53676d.d(dVar.f53677e);
                }
            }

            @Override // rx.l, rx.observers.a
            public void setProducer(rx.g gVar) {
                gVar.request(Long.MAX_VALUE);
            }
        }

        d(rx.e eVar, rx.l lVar, AtomicLong atomicLong, h.a aVar, rx.functions.a aVar2, AtomicBoolean atomicBoolean) {
            this.f53673a = eVar;
            this.f53674b = lVar;
            this.f53675c = atomicLong;
            this.f53676d = aVar;
            this.f53677e = aVar2;
            this.f53678f = atomicBoolean;
        }

        @Override // rx.functions.a
        public void call() {
            this.f53673a.J6(new a(this.f53674b));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicLong f53681a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.internal.producers.a f53682b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f53683c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h.a f53684d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f53685e;

        e(AtomicLong atomicLong, rx.internal.producers.a aVar, AtomicBoolean atomicBoolean, h.a aVar2, rx.functions.a aVar3) {
            this.f53681a = atomicLong;
            this.f53682b = aVar;
            this.f53683c = atomicBoolean;
            this.f53684d = aVar2;
            this.f53685e = aVar3;
        }

        @Override // rx.g
        public void request(long j6) {
            if (j6 > 0) {
                rx.internal.operators.a.b(this.f53681a, j6);
                this.f53682b.request(j6);
                if (this.f53683c.compareAndSet(true, false)) {
                    this.f53684d.d(this.f53685e);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class f implements rx.functions.p<rx.e<? extends Notification<?>>, rx.e<?>> {

        /* renamed from: a, reason: collision with root package name */
        final long f53687a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.p<Notification<?>, Notification<?>> {

            /* renamed from: a, reason: collision with root package name */
            int f53688a;

            a() {
            }

            @Override // rx.functions.p
            public Notification<?> call(Notification<?> notification) {
                long j6 = f.this.f53687a;
                if (j6 == 0) {
                    return notification;
                }
                int i6 = this.f53688a + 1;
                this.f53688a = i6;
                return ((long) i6) <= j6 ? Notification.e(Integer.valueOf(i6)) : notification;
            }
        }

        @Override // rx.functions.p
        public rx.e<?> call(rx.e<? extends Notification<?>> eVar) {
            return eVar.c3(new a()).A1();
        }

        public f(long j6) {
            this.f53687a = j6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class g implements rx.functions.p<rx.e<? extends Notification<?>>, rx.e<? extends Notification<?>>> {

        /* renamed from: a, reason: collision with root package name */
        final rx.functions.q<Integer, Throwable, Boolean> f53690a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.q<Notification<Integer>, Notification<?>, Notification<Integer>> {
            a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.functions.q
            public Notification<Integer> call(Notification<Integer> notification, Notification<?> notification2) {
                Integer h6 = notification.h();
                return g.this.f53690a.call(h6, notification2.g()).booleanValue() ? Notification.e(Integer.valueOf(h6.intValue() + 1)) : notification2;
            }
        }

        @Override // rx.functions.p
        public rx.e<? extends Notification<?>> call(rx.e<? extends Notification<?>> eVar) {
            return eVar.K4(Notification.e(0), new a());
        }

        public g(rx.functions.q<Integer, Throwable, Boolean> qVar) {
            this.f53690a = qVar;
        }
    }

    public static <T> rx.e<T> a(rx.e<T> eVar, rx.functions.p<? super rx.e<? extends Notification<?>>, ? extends rx.e<?>> pVar, rx.h hVar) {
        return rx.e.I6(new w0(eVar, pVar, false, false, hVar));
    }

    public static <T> rx.e<T> d(rx.e<T> eVar, long j6, rx.h hVar) {
        if (j6 == 0) {
            return rx.e.S1();
        }
        if (j6 >= 0) {
            return g(eVar, new f(j6 - 1), hVar);
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    public static <T> rx.e<T> e(rx.e<T> eVar, rx.h hVar) {
        return g(eVar, f53655f, hVar);
    }

    public static <T> rx.e<T> f(rx.e<T> eVar, rx.functions.p<? super rx.e<? extends Notification<?>>, ? extends rx.e<?>> pVar) {
        return rx.e.I6(new w0(eVar, pVar, false, true, rx.schedulers.c.m()));
    }

    public static <T> rx.e<T> g(rx.e<T> eVar, rx.functions.p<? super rx.e<? extends Notification<?>>, ? extends rx.e<?>> pVar, rx.h hVar) {
        return rx.e.I6(new w0(eVar, pVar, false, true, hVar));
    }

    public static <T> rx.e<T> h(rx.e<T> eVar) {
        return j(eVar, f53655f);
    }

    public static <T> rx.e<T> i(rx.e<T> eVar, long j6) {
        if (j6 >= 0) {
            return j6 == 0 ? eVar : j(eVar, new f(j6));
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    public static <T> rx.e<T> j(rx.e<T> eVar, rx.functions.p<? super rx.e<? extends Notification<?>>, ? extends rx.e<?>> pVar) {
        return rx.e.I6(new w0(eVar, pVar, true, false, rx.schedulers.c.m()));
    }

    public static <T> rx.e<T> k(rx.e<T> eVar, rx.functions.p<? super rx.e<? extends Notification<?>>, ? extends rx.e<?>> pVar, rx.h hVar) {
        return rx.e.I6(new w0(eVar, pVar, true, false, hVar));
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        h.a a6 = this.f53660e.a();
        lVar.add(a6);
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        lVar.add(eVar);
        rx.subjects.e<T, T> x7 = rx.subjects.b.y7().x7();
        x7.r5(rx.observers.h.d());
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        b bVar = new b(lVar, x7, aVar, atomicLong, eVar);
        a6.d(new d(this.f53657b.call(x7.a3(new c())), lVar, atomicLong, a6, bVar, atomicBoolean));
        lVar.setProducer(new e(atomicLong, aVar, atomicBoolean, a6, bVar));
    }

    private w0(rx.e<T> eVar, rx.functions.p<? super rx.e<? extends Notification<?>>, ? extends rx.e<?>> pVar, boolean z5, boolean z6, rx.h hVar) {
        this.f53656a = eVar;
        this.f53657b = pVar;
        this.f53658c = z5;
        this.f53659d = z6;
        this.f53660e = hVar;
    }

    public static <T> rx.e<T> b(rx.e<T> eVar) {
        return e(eVar, rx.schedulers.c.m());
    }

    public static <T> rx.e<T> c(rx.e<T> eVar, long j6) {
        return d(eVar, j6, rx.schedulers.c.m());
    }
}
