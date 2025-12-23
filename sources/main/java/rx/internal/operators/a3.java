package rx.internal.operators;

import defpackage.H5BaseWebChromeClient;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a3<R, T> implements e.b<R, T> {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f52513c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final rx.functions.o<R> f52514a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.q<R, ? super T, R> f52515b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.functions.o<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f52516a;

        a(Object obj) {
            this.f52516a = obj;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public R call() {
            return (R) this.f52516a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        boolean f52517a;

        /* renamed from: b, reason: collision with root package name */
        R f52518b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.l f52519c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f52519c = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52519c.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52519c.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f52517a) {
                try {
                    t5 = a3.this.f52515b.call(this.f52518b, t5);
                } catch (Throwable th) {
                    rx.exceptions.a.g(th, this.f52519c, t5);
                    return;
                }
            } else {
                this.f52517a = true;
            }
            this.f52518b = (R) t5;
            this.f52519c.onNext(t5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private R f52521a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f52522b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f52523c;

        /* JADX WARN: Multi-variable type inference failed */
        c(Object obj, d dVar) {
            this.f52522b = obj;
            this.f52523c = dVar;
            this.f52521a = obj;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52523c.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52523c.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            try {
                R call = a3.this.f52515b.call(this.f52521a, t5);
                this.f52521a = call;
                this.f52523c.onNext(call);
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this, t5);
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f52523c.setProducer(gVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d<R> implements rx.g, rx.f<R> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super R> f52525a;

        /* renamed from: b, reason: collision with root package name */
        final Queue<Object> f52526b;

        /* renamed from: c, reason: collision with root package name */
        boolean f52527c;

        /* renamed from: d, reason: collision with root package name */
        boolean f52528d;

        /* renamed from: e, reason: collision with root package name */
        long f52529e;

        /* renamed from: f, reason: collision with root package name */
        final AtomicLong f52530f;

        /* renamed from: g, reason: collision with root package name */
        volatile rx.g f52531g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f52532h;

        /* renamed from: i, reason: collision with root package name */
        Throwable f52533i;

        void e() {
            synchronized (this) {
                try {
                    if (this.f52527c) {
                        this.f52528d = true;
                    } else {
                        this.f52527c = true;
                        f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52532h = true;
            e();
        }

        void f() {
            rx.l<? super R> lVar = this.f52525a;
            Queue<Object> queue = this.f52526b;
            AtomicLong atomicLong = this.f52530f;
            long j6 = atomicLong.get();
            while (!d(this.f52532h, queue.isEmpty(), lVar)) {
                long j7 = 0;
                while (j7 != j6) {
                    boolean z5 = this.f52532h;
                    Object poll = queue.poll();
                    boolean z6 = poll == null;
                    if (d(z5, z6, lVar)) {
                        return;
                    }
                    if (z6) {
                        break;
                    }
                    H5BaseWebChromeClient h5BaseWebChromeClient = (Object) v.e(poll);
                    try {
                        lVar.onNext(h5BaseWebChromeClient);
                        j7++;
                    } catch (Throwable th) {
                        rx.exceptions.a.g(th, lVar, h5BaseWebChromeClient);
                        return;
                    }
                }
                if (j7 != 0 && j6 != Long.MAX_VALUE) {
                    j6 = rx.internal.operators.a.i(atomicLong, j7);
                }
                synchronized (this) {
                    try {
                        if (!this.f52528d) {
                            this.f52527c = false;
                            return;
                        }
                        this.f52528d = false;
                    } finally {
                    }
                }
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52533i = th;
            this.f52532h = true;
            e();
        }

        @Override // rx.f
        public void onNext(R r5) {
            this.f52526b.offer(v.j(r5));
            e();
        }

        @Override // rx.g
        public void request(long j6) {
            if (j6 < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j6);
            }
            if (j6 != 0) {
                rx.internal.operators.a.b(this.f52530f, j6);
                rx.g gVar = this.f52531g;
                if (gVar == null) {
                    synchronized (this.f52530f) {
                        try {
                            gVar = this.f52531g;
                            if (gVar == null) {
                                this.f52529e = rx.internal.operators.a.a(this.f52529e, j6);
                            }
                        } finally {
                        }
                    }
                }
                if (gVar != null) {
                    gVar.request(j6);
                }
                e();
            }
        }

        public d(R r5, rx.l<? super R> lVar) {
            Queue<Object> fVar;
            this.f52525a = lVar;
            if (rx.internal.util.unsafe.n0.f()) {
                fVar = new rx.internal.util.unsafe.g0<>();
            } else {
                fVar = new rx.internal.util.atomic.f<>();
            }
            this.f52526b = fVar;
            fVar.offer(v.j(r5));
            this.f52530f = new AtomicLong();
        }

        boolean d(boolean z5, boolean z6, rx.l<? super R> lVar) {
            if (lVar.isUnsubscribed()) {
                return true;
            }
            if (z5) {
                Throwable th = this.f52533i;
                if (th != null) {
                    lVar.onError(th);
                    return true;
                }
                if (z6) {
                    lVar.onCompleted();
                    return true;
                }
                return false;
            }
            return false;
        }

        public void setProducer(rx.g gVar) {
            long j6;
            gVar.getClass();
            synchronized (this.f52530f) {
                if (this.f52531g == null) {
                    j6 = this.f52529e;
                    if (j6 != Long.MAX_VALUE) {
                        j6--;
                    }
                    this.f52529e = 0L;
                    this.f52531g = gVar;
                } else {
                    throw new IllegalStateException("Can't set more than one Producer!");
                }
            }
            if (j6 > 0) {
                gVar.request(j6);
            }
            e();
        }
    }

    public a3(R r5, rx.functions.q<R, ? super T, R> qVar) {
        this((rx.functions.o) new a(r5), (rx.functions.q) qVar);
    }

    public a3(rx.functions.o<R> oVar, rx.functions.q<R, ? super T, R> qVar) {
        this.f52514a = oVar;
        this.f52515b = qVar;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super R> lVar) {
        R call = this.f52514a.call();
        if (call == f52513c) {
            return new b(lVar, lVar);
        }
        d dVar = new d(call, lVar);
        c cVar = new c(call, dVar);
        lVar.add(cVar);
        lVar.setProducer(dVar);
        return cVar;
    }

    public a3(rx.functions.q<R, ? super T, R> qVar) {
        this(f52513c, qVar);
    }
}
