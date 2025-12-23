package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.ExceptionsUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z<T, R> implements e.a<R> {

    /* renamed from: e, reason: collision with root package name */
    public static final int f53881e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static final int f53882f = 1;

    /* renamed from: g, reason: collision with root package name */
    public static final int f53883g = 2;

    /* renamed from: a, reason: collision with root package name */
    final rx.e<? extends T> f53884a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.e<? extends R>> f53885b;

    /* renamed from: c, reason: collision with root package name */
    final int f53886c;

    /* renamed from: d, reason: collision with root package name */
    final int f53887d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f53888a;

        a(d dVar) {
            this.f53888a = dVar;
        }

        @Override // rx.g
        public void request(long j6) {
            this.f53888a.H(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T, R> implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final R f53890a;

        /* renamed from: b, reason: collision with root package name */
        final d<T, R> f53891b;

        /* renamed from: c, reason: collision with root package name */
        boolean f53892c;

        @Override // rx.g
        public void request(long j6) {
            if (this.f53892c || j6 <= 0) {
                return;
            }
            this.f53892c = true;
            d<T, R> dVar = this.f53891b;
            dVar.B(this.f53890a);
            dVar.s(1L);
        }

        public b(R r5, d<T, R> dVar) {
            this.f53890a = r5;
            this.f53891b = dVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T, R> extends rx.l<R> {

        /* renamed from: a, reason: collision with root package name */
        final d<T, R> f53893a;

        /* renamed from: b, reason: collision with root package name */
        long f53894b;

        @Override // rx.f
        public void onCompleted() {
            this.f53893a.s(this.f53894b);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53893a.A(th, this.f53894b);
        }

        @Override // rx.f
        public void onNext(R r5) {
            this.f53894b++;
            this.f53893a.B(r5);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f53893a.f53898d.c(gVar);
        }

        public c(d<T, R> dVar) {
            this.f53893a = dVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d<T, R> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super R> f53895a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends rx.e<? extends R>> f53896b;

        /* renamed from: c, reason: collision with root package name */
        final int f53897c;

        /* renamed from: e, reason: collision with root package name */
        final Queue<Object> f53899e;

        /* renamed from: h, reason: collision with root package name */
        final rx.subscriptions.e f53902h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f53903i;

        /* renamed from: j, reason: collision with root package name */
        volatile boolean f53904j;

        /* renamed from: d, reason: collision with root package name */
        final rx.internal.producers.a f53898d = new rx.internal.producers.a();

        /* renamed from: f, reason: collision with root package name */
        final AtomicInteger f53900f = new AtomicInteger();

        /* renamed from: g, reason: collision with root package name */
        final AtomicReference<Throwable> f53901g = new AtomicReference<>();

        @Override // rx.f
        public void onCompleted() {
            this.f53903i = true;
            g();
        }

        void A(Throwable th, long j6) {
            if (!ExceptionsUtils.addThrowable(this.f53901g, th)) {
                G(th);
                return;
            }
            if (this.f53897c == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.f53901g);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.f53895a.onError(terminate);
                }
                unsubscribe();
                return;
            }
            if (j6 != 0) {
                this.f53898d.b(j6);
            }
            this.f53904j = false;
            g();
        }

        void B(R r5) {
            this.f53895a.onNext(r5);
        }

        void H(long j6) {
            if (j6 > 0) {
                this.f53898d.request(j6);
            } else {
                if (j6 >= 0) {
                    return;
                }
                throw new IllegalArgumentException("n >= 0 required but it was " + j6);
            }
        }

        void g() {
            if (this.f53900f.getAndIncrement() != 0) {
                return;
            }
            int i6 = this.f53897c;
            while (!this.f53895a.isUnsubscribed()) {
                if (!this.f53904j) {
                    if (i6 == 1 && this.f53901g.get() != null) {
                        Throwable terminate = ExceptionsUtils.terminate(this.f53901g);
                        if (ExceptionsUtils.isTerminated(terminate)) {
                            return;
                        }
                        this.f53895a.onError(terminate);
                        return;
                    }
                    boolean z5 = this.f53903i;
                    Object poll = this.f53899e.poll();
                    boolean z6 = poll == null;
                    if (z5 && z6) {
                        Throwable terminate2 = ExceptionsUtils.terminate(this.f53901g);
                        if (terminate2 == null) {
                            this.f53895a.onCompleted();
                            return;
                        } else {
                            if (ExceptionsUtils.isTerminated(terminate2)) {
                                return;
                            }
                            this.f53895a.onError(terminate2);
                            return;
                        }
                    }
                    if (!z6) {
                        try {
                            rx.e<? extends R> call = this.f53896b.call((Object) v.e(poll));
                            if (call == null) {
                                j(new NullPointerException("The source returned by the mapper was null"));
                                return;
                            }
                            if (call != rx.e.S1()) {
                                if (call instanceof rx.internal.util.k) {
                                    this.f53904j = true;
                                    this.f53898d.c(new b(((rx.internal.util.k) call).y7(), this));
                                } else {
                                    c cVar = new c(this);
                                    this.f53902h.b(cVar);
                                    if (cVar.isUnsubscribed()) {
                                        return;
                                    }
                                    this.f53904j = true;
                                    call.J6(cVar);
                                }
                                request(1L);
                            } else {
                                request(1L);
                            }
                        } catch (Throwable th) {
                            rx.exceptions.a.e(th);
                            j(th);
                            return;
                        }
                    }
                }
                if (this.f53900f.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!ExceptionsUtils.addThrowable(this.f53901g, th)) {
                G(th);
                return;
            }
            this.f53903i = true;
            if (this.f53897c != 0) {
                g();
                return;
            }
            Throwable terminate = ExceptionsUtils.terminate(this.f53901g);
            if (!ExceptionsUtils.isTerminated(terminate)) {
                this.f53895a.onError(terminate);
            }
            this.f53902h.unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53899e.offer(v.j(t5))) {
                g();
            } else {
                unsubscribe();
                onError(new MissingBackpressureException());
            }
        }

        void s(long j6) {
            if (j6 != 0) {
                this.f53898d.b(j6);
            }
            this.f53904j = false;
            g();
        }

        public d(rx.l<? super R> lVar, rx.functions.p<? super T, ? extends rx.e<? extends R>> pVar, int i6, int i7) {
            Queue<Object> dVar;
            this.f53895a = lVar;
            this.f53896b = pVar;
            this.f53897c = i7;
            if (rx.internal.util.unsafe.n0.f()) {
                dVar = new rx.internal.util.unsafe.z<>(i6);
            } else {
                dVar = new rx.internal.util.atomic.d<>(i6);
            }
            this.f53899e = dVar;
            this.f53902h = new rx.subscriptions.e();
            request(i6);
        }

        void G(Throwable th) {
            rx.plugins.c.I(th);
        }

        void j(Throwable th) {
            unsubscribe();
            if (ExceptionsUtils.addThrowable(this.f53901g, th)) {
                Throwable terminate = ExceptionsUtils.terminate(this.f53901g);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.f53895a.onError(terminate);
                    return;
                }
                return;
            }
            G(th);
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super R> lVar) {
        d dVar = new d(this.f53887d == 0 ? new rx.observers.g<>(lVar) : lVar, this.f53885b, this.f53886c, this.f53887d);
        lVar.add(dVar);
        lVar.add(dVar.f53902h);
        lVar.setProducer(new a(dVar));
        if (lVar.isUnsubscribed()) {
            return;
        }
        this.f53884a.J6(dVar);
    }

    public z(rx.e<? extends T> eVar, rx.functions.p<? super T, ? extends rx.e<? extends R>> pVar, int i6, int i7) {
        this.f53884a = eVar;
        this.f53885b = pVar;
        this.f53886c = i6;
        this.f53887d = i7;
    }
}
