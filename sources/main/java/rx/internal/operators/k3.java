package rx.internal.operators;

import defpackage.H5BaseWebChromeClient;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.CompositeException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k3<T> implements e.b<T, rx.e<? extends T>> {

    /* renamed from: a, reason: collision with root package name */
    final boolean f53103a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private final long f53106a;

        /* renamed from: b, reason: collision with root package name */
        private final d<T> f53107b;

        @Override // rx.f
        public void onCompleted() {
            this.f53107b.A(this.f53106a);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53107b.H(th, this.f53106a);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53107b.G(t5, this);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f53107b.P(gVar, this.f53106a);
        }

        c(long j6, d<T> dVar) {
            this.f53106a = j6;
            this.f53107b = dVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d<T> extends rx.l<rx.e<? extends T>> {

        /* renamed from: m, reason: collision with root package name */
        static final Throwable f53108m = new Throwable("Terminal error");

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f53109a;

        /* renamed from: c, reason: collision with root package name */
        final boolean f53111c;

        /* renamed from: f, reason: collision with root package name */
        boolean f53114f;

        /* renamed from: g, reason: collision with root package name */
        boolean f53115g;

        /* renamed from: h, reason: collision with root package name */
        long f53116h;

        /* renamed from: i, reason: collision with root package name */
        rx.g f53117i;

        /* renamed from: j, reason: collision with root package name */
        volatile boolean f53118j;

        /* renamed from: k, reason: collision with root package name */
        Throwable f53119k;

        /* renamed from: l, reason: collision with root package name */
        boolean f53120l;

        /* renamed from: b, reason: collision with root package name */
        final rx.subscriptions.e f53110b = new rx.subscriptions.e();

        /* renamed from: d, reason: collision with root package name */
        final AtomicLong f53112d = new AtomicLong();

        /* renamed from: e, reason: collision with root package name */
        final rx.internal.util.atomic.e<Object> f53113e = new rx.internal.util.atomic.e<>(rx.internal.util.j.f54163d);

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.a {
            a() {
            }

            @Override // rx.functions.a
            public void call() {
                d.this.s();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements rx.g {
            b() {
            }

            @Override // rx.g
            public void request(long j6) {
                if (j6 > 0) {
                    d.this.j(j6);
                } else {
                    if (j6 >= 0) {
                        return;
                    }
                    throw new IllegalArgumentException("n >= 0 expected but it was " + j6);
                }
            }
        }

        void A(long j6) {
            synchronized (this) {
                try {
                    if (this.f53112d.get() != j6) {
                        return;
                    }
                    this.f53120l = false;
                    this.f53117i = null;
                    B();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void G(T t5, c<T> cVar) {
            synchronized (this) {
                try {
                    if (this.f53112d.get() != ((c) cVar).f53106a) {
                        return;
                    }
                    this.f53113e.r(cVar, v.j(t5));
                    B();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void H(Throwable th, long j6) {
            boolean z5;
            synchronized (this) {
                try {
                    if (this.f53112d.get() == j6) {
                        z5 = S(th);
                        this.f53120l = false;
                        this.f53117i = null;
                    } else {
                        z5 = true;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z5) {
                B();
            } else {
                R(th);
            }
        }

        void P(rx.g gVar, long j6) {
            synchronized (this) {
                try {
                    if (this.f53112d.get() != j6) {
                        return;
                    }
                    long j7 = this.f53116h;
                    this.f53117i = gVar;
                    gVar.request(j7);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void j(long j6) {
            rx.g gVar;
            synchronized (this) {
                gVar = this.f53117i;
                this.f53116h = rx.internal.operators.a.a(this.f53116h, j6);
            }
            if (gVar != null) {
                gVar.request(j6);
            }
            B();
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53118j = true;
            B();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            boolean S;
            synchronized (this) {
                S = S(th);
            }
            if (!S) {
                R(th);
            } else {
                this.f53118j = true;
                B();
            }
        }

        void s() {
            synchronized (this) {
                this.f53117i = null;
            }
        }

        void B() {
            Throwable th;
            Throwable th2;
            synchronized (this) {
                try {
                    if (this.f53114f) {
                        this.f53115g = true;
                        return;
                    }
                    this.f53114f = true;
                    boolean z5 = this.f53120l;
                    long j6 = this.f53116h;
                    Throwable th3 = this.f53119k;
                    if (th3 != null && th3 != (th2 = f53108m) && !this.f53111c) {
                        this.f53119k = th2;
                    }
                    rx.internal.util.atomic.e<Object> eVar = this.f53113e;
                    AtomicLong atomicLong = this.f53112d;
                    rx.l<? super T> lVar = this.f53109a;
                    long j7 = j6;
                    boolean z6 = this.f53118j;
                    boolean z7 = z5;
                    while (true) {
                        long j8 = 0;
                        while (j8 != j7) {
                            if (lVar.isUnsubscribed()) {
                                return;
                            }
                            boolean isEmpty = eVar.isEmpty();
                            if (g(z6, z7, th3, eVar, lVar, isEmpty)) {
                                return;
                            }
                            if (isEmpty) {
                                break;
                            }
                            c cVar = (c) eVar.poll();
                            H5BaseWebChromeClient h5BaseWebChromeClient = (Object) v.e(eVar.poll());
                            if (atomicLong.get() == cVar.f53106a) {
                                lVar.onNext(h5BaseWebChromeClient);
                                j8++;
                            }
                        }
                        if (j8 == j7 && (lVar.isUnsubscribed() || g(this.f53118j, z7, th3, eVar, lVar, eVar.isEmpty()))) {
                            return;
                        }
                        synchronized (this) {
                            try {
                                long j9 = this.f53116h;
                                if (j9 != Long.MAX_VALUE) {
                                    j9 -= j8;
                                    this.f53116h = j9;
                                }
                                j7 = j9;
                                if (!this.f53115g) {
                                    this.f53114f = false;
                                    return;
                                }
                                this.f53115g = false;
                                z6 = this.f53118j;
                                z7 = this.f53120l;
                                th3 = this.f53119k;
                                if (th3 != null && th3 != (th = f53108m) && !this.f53111c) {
                                    this.f53119k = th;
                                }
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        void N() {
            this.f53109a.add(this.f53110b);
            this.f53109a.add(rx.subscriptions.f.a(new a()));
            this.f53109a.setProducer(new b());
        }

        @Override // rx.f
        /* renamed from: Q, reason: merged with bridge method [inline-methods] */
        public void onNext(rx.e<? extends T> eVar) {
            c cVar;
            long incrementAndGet = this.f53112d.incrementAndGet();
            rx.m a6 = this.f53110b.a();
            if (a6 != null) {
                a6.unsubscribe();
            }
            synchronized (this) {
                cVar = new c(incrementAndGet, this);
                this.f53120l = true;
                this.f53117i = null;
            }
            this.f53110b.b(cVar);
            eVar.J6(cVar);
        }

        boolean S(Throwable th) {
            Throwable th2 = this.f53119k;
            if (th2 == f53108m) {
                return false;
            }
            if (th2 == null) {
                this.f53119k = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                arrayList.add(th);
                this.f53119k = new CompositeException(arrayList);
            } else {
                this.f53119k = new CompositeException(th2, th);
            }
            return true;
        }

        protected boolean g(boolean z5, boolean z6, Throwable th, rx.internal.util.atomic.e<Object> eVar, rx.l<? super T> lVar, boolean z7) {
            if (this.f53111c) {
                if (!z5 || z6 || !z7) {
                    return false;
                }
                if (th != null) {
                    lVar.onError(th);
                } else {
                    lVar.onCompleted();
                }
                return true;
            }
            if (th != null) {
                eVar.clear();
                lVar.onError(th);
                return true;
            }
            if (!z5 || z6 || !z7) {
                return false;
            }
            lVar.onCompleted();
            return true;
        }

        d(rx.l<? super T> lVar, boolean z5) {
            this.f53109a = lVar;
            this.f53111c = z5;
        }

        void R(Throwable th) {
            rx.plugins.c.I(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final k3<Object> f53104a = new k3<>(false);

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final k3<Object> f53105a = new k3<>(true);

        b() {
        }
    }

    public static <T> k3<T> a(boolean z5) {
        return z5 ? (k3<T>) b.f53105a : (k3<T>) a.f53104a;
    }

    @Override // rx.functions.p
    public rx.l<? super rx.e<? extends T>> call(rx.l<? super T> lVar) {
        d dVar = new d(lVar, this.f53103a);
        lVar.add(dVar);
        dVar.N();
        return dVar;
    }

    k3(boolean z5) {
        this.f53103a = z5;
    }
}
