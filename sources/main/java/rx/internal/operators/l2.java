package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l2<T, R> implements e.b<R, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends R> f53138a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super Throwable, ? extends R> f53139b;

    /* renamed from: c, reason: collision with root package name */
    final rx.functions.o<? extends R> f53140c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f53141a;

        a(b bVar) {
            this.f53141a = bVar;
        }

        @Override // rx.g
        public void request(long j6) {
            this.f53141a.j(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T, R> extends rx.l<T> {

        /* renamed from: j, reason: collision with root package name */
        static final long f53143j = Long.MIN_VALUE;

        /* renamed from: k, reason: collision with root package name */
        static final long f53144k = Long.MAX_VALUE;

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super R> f53145a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends R> f53146b;

        /* renamed from: c, reason: collision with root package name */
        final rx.functions.p<? super Throwable, ? extends R> f53147c;

        /* renamed from: d, reason: collision with root package name */
        final rx.functions.o<? extends R> f53148d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicLong f53149e = new AtomicLong();

        /* renamed from: f, reason: collision with root package name */
        final AtomicLong f53150f = new AtomicLong();

        /* renamed from: g, reason: collision with root package name */
        final AtomicReference<rx.g> f53151g = new AtomicReference<>();

        /* renamed from: h, reason: collision with root package name */
        long f53152h;

        /* renamed from: i, reason: collision with root package name */
        R f53153i;

        void g() {
            long j6 = this.f53152h;
            if (j6 == 0 || this.f53151g.get() == null) {
                return;
            }
            rx.internal.operators.a.i(this.f53149e, j6);
        }

        void j(long j6) {
            if (j6 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j6);
            }
            if (j6 == 0) {
                return;
            }
            while (true) {
                long j7 = this.f53149e.get();
                if ((j7 & Long.MIN_VALUE) != 0) {
                    long j8 = Long.MAX_VALUE & j7;
                    if (this.f53149e.compareAndSet(j7, Long.MIN_VALUE | rx.internal.operators.a.a(j8, j6))) {
                        if (j8 == 0) {
                            if (!this.f53145a.isUnsubscribed()) {
                                this.f53145a.onNext(this.f53153i);
                            }
                            if (this.f53145a.isUnsubscribed()) {
                                return;
                            }
                            this.f53145a.onCompleted();
                            return;
                        }
                        return;
                    }
                } else {
                    if (this.f53149e.compareAndSet(j7, rx.internal.operators.a.a(j7, j6))) {
                        AtomicReference<rx.g> atomicReference = this.f53151g;
                        rx.g gVar = atomicReference.get();
                        if (gVar != null) {
                            gVar.request(j6);
                            return;
                        }
                        rx.internal.operators.a.b(this.f53150f, j6);
                        rx.g gVar2 = atomicReference.get();
                        if (gVar2 != null) {
                            long andSet = this.f53150f.getAndSet(0L);
                            if (andSet != 0) {
                                gVar2.request(andSet);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            try {
                this.f53152h++;
                this.f53145a.onNext(this.f53146b.call(t5));
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this.f53145a, t5);
            }
        }

        void s() {
            long j6;
            do {
                j6 = this.f53149e.get();
                if ((j6 & Long.MIN_VALUE) != 0) {
                    return;
                }
            } while (!this.f53149e.compareAndSet(j6, Long.MIN_VALUE | j6));
            if (j6 != 0 || this.f53151g.get() == null) {
                if (!this.f53145a.isUnsubscribed()) {
                    this.f53145a.onNext(this.f53153i);
                }
                if (this.f53145a.isUnsubscribed()) {
                    return;
                }
                this.f53145a.onCompleted();
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            if (!androidx.camera.view.p.a(this.f53151g, null, gVar)) {
                throw new IllegalStateException("Producer already set!");
            }
            long andSet = this.f53150f.getAndSet(0L);
            if (andSet != 0) {
                gVar.request(andSet);
            }
        }

        public b(rx.l<? super R> lVar, rx.functions.p<? super T, ? extends R> pVar, rx.functions.p<? super Throwable, ? extends R> pVar2, rx.functions.o<? extends R> oVar) {
            this.f53145a = lVar;
            this.f53146b = pVar;
            this.f53147c = pVar2;
            this.f53148d = oVar;
        }

        @Override // rx.f
        public void onCompleted() {
            g();
            try {
                this.f53153i = this.f53148d.call();
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this.f53145a);
            }
            s();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            g();
            try {
                this.f53153i = this.f53147c.call(th);
            } catch (Throwable th2) {
                rx.exceptions.a.g(th2, this.f53145a, th);
            }
            s();
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super R> lVar) {
        b bVar = new b(lVar, this.f53138a, this.f53139b, this.f53140c);
        lVar.add(bVar);
        lVar.setProducer(new a(bVar));
        return bVar;
    }

    public l2(rx.functions.p<? super T, ? extends R> pVar, rx.functions.p<? super Throwable, ? extends R> pVar2, rx.functions.o<? extends R> oVar) {
        this.f53138a = pVar;
        this.f53139b = pVar2;
        this.f53140c = oVar;
    }
}
