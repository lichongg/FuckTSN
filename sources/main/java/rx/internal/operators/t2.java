package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t2<T> implements e.b<T, T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends AtomicLong implements rx.g, rx.m, rx.f<T> {

        /* renamed from: h, reason: collision with root package name */
        static final Object f53543h = new Object();

        /* renamed from: i, reason: collision with root package name */
        static final long f53544i = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f53545a;

        /* renamed from: b, reason: collision with root package name */
        c<? super T> f53546b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference<Object> f53547c = new AtomicReference<>(f53543h);

        /* renamed from: d, reason: collision with root package name */
        Throwable f53548d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f53549e;

        /* renamed from: f, reason: collision with root package name */
        boolean f53550f;

        /* renamed from: g, reason: collision with root package name */
        boolean f53551g;

        void d() {
            boolean z5;
            Object obj;
            synchronized (this) {
                try {
                    boolean z6 = true;
                    if (this.f53550f) {
                        this.f53551g = true;
                        return;
                    }
                    this.f53550f = true;
                    this.f53551g = false;
                    while (true) {
                        try {
                            long j6 = get();
                            if (j6 == Long.MIN_VALUE) {
                                return;
                            }
                            Object obj2 = this.f53547c.get();
                            if (j6 > 0 && obj2 != (obj = f53543h)) {
                                this.f53545a.onNext(obj2);
                                androidx.camera.view.p.a(this.f53547c, obj2, obj);
                                e(1L);
                                obj2 = obj;
                            }
                            if (obj2 == f53543h && this.f53549e) {
                                Throwable th = this.f53548d;
                                if (th != null) {
                                    this.f53545a.onError(th);
                                } else {
                                    this.f53545a.onCompleted();
                                }
                            }
                            try {
                                synchronized (this) {
                                    try {
                                        if (!this.f53551g) {
                                            this.f53550f = false;
                                            return;
                                        }
                                        this.f53551g = false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z6 = false;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                z5 = z6;
                                th = th4;
                                if (z5) {
                                    throw th;
                                }
                                synchronized (this) {
                                    this.f53550f = false;
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            z5 = false;
                        }
                    }
                } finally {
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53549e = true;
            d();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53548d = th;
            this.f53549e = true;
            d();
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53547c.lazySet(t5);
            d();
        }

        @Override // rx.g
        public void request(long j6) {
            long j7;
            long j8;
            if (j6 >= 0) {
                do {
                    j7 = get();
                    if (j7 == Long.MIN_VALUE) {
                        return;
                    }
                    if (j7 == f53544i) {
                        j8 = j6;
                    } else {
                        j8 = j7 + j6;
                        if (j8 < 0) {
                            j8 = Long.MAX_VALUE;
                        }
                    }
                } while (!compareAndSet(j7, j8));
                if (j7 == f53544i) {
                    this.f53546b.g(Long.MAX_VALUE);
                }
                d();
            }
        }

        public b(rx.l<? super T> lVar) {
            this.f53545a = lVar;
            lazySet(f53544i);
        }

        long e(long j6) {
            long j7;
            long j8;
            do {
                j7 = get();
                if (j7 < 0) {
                    return j7;
                }
                j8 = j7 - j6;
            } while (!compareAndSet(j7, j8));
            return j8;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        @Override // rx.m
        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private final b<T> f53552a;

        @Override // rx.f
        public void onCompleted() {
            this.f53552a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53552a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53552a.onNext(t5);
        }

        @Override // rx.l
        public void onStart() {
            request(0L);
        }

        c(b<T> bVar) {
            this.f53552a = bVar;
        }

        void g(long j6) {
            request(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final t2<Object> f53542a = new t2<>();

        a() {
        }
    }

    public static <T> t2<T> a() {
        return (t2<T>) a.f53542a;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        b bVar = new b(lVar);
        c<? super T> cVar = new c<>(bVar);
        bVar.f53546b = cVar;
        lVar.add(cVar);
        lVar.add(bVar);
        lVar.setProducer(bVar);
        return cVar;
    }
}
