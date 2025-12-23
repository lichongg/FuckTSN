package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.internal.operators.g1;
import rx.internal.subscriptions.SequentialSubscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f1<T, U, V> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T> f52763a;

    /* renamed from: b, reason: collision with root package name */
    final rx.e<U> f52764b;

    /* renamed from: c, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.e<V>> f52765c;

    /* renamed from: d, reason: collision with root package name */
    final rx.e<? extends T> f52766d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f52767a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends rx.e<?>> f52768b;

        /* renamed from: c, reason: collision with root package name */
        final rx.e<? extends T> f52769c;

        /* renamed from: d, reason: collision with root package name */
        final rx.internal.producers.a f52770d = new rx.internal.producers.a();

        /* renamed from: e, reason: collision with root package name */
        final AtomicLong f52771e = new AtomicLong();

        /* renamed from: f, reason: collision with root package name */
        final SequentialSubscription f52772f;

        /* renamed from: g, reason: collision with root package name */
        final SequentialSubscription f52773g;

        /* renamed from: h, reason: collision with root package name */
        long f52774h;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.f1$a$a, reason: collision with other inner class name */
        final class C1032a extends rx.l<Object> {

            /* renamed from: a, reason: collision with root package name */
            final long f52775a;

            /* renamed from: b, reason: collision with root package name */
            boolean f52776b;

            C1032a(long j6) {
                this.f52775a = j6;
            }

            @Override // rx.f
            public void onCompleted() {
                if (this.f52776b) {
                    return;
                }
                this.f52776b = true;
                a.this.g(this.f52775a);
            }

            @Override // rx.f
            public void onError(Throwable th) {
                if (this.f52776b) {
                    rx.plugins.c.I(th);
                } else {
                    this.f52776b = true;
                    a.this.j(this.f52775a, th);
                }
            }

            @Override // rx.f
            public void onNext(Object obj) {
                if (this.f52776b) {
                    return;
                }
                this.f52776b = true;
                unsubscribe();
                a.this.g(this.f52775a);
            }
        }

        void g(long j6) {
            if (this.f52771e.compareAndSet(j6, Long.MAX_VALUE)) {
                unsubscribe();
                if (this.f52769c == null) {
                    this.f52767a.onError(new TimeoutException());
                    return;
                }
                long j7 = this.f52774h;
                if (j7 != 0) {
                    this.f52770d.b(j7);
                }
                g1.a aVar = new g1.a(this.f52767a, this.f52770d);
                if (this.f52773g.replace(aVar)) {
                    this.f52769c.r5(aVar);
                }
            }
        }

        void j(long j6, Throwable th) {
            if (!this.f52771e.compareAndSet(j6, Long.MAX_VALUE)) {
                rx.plugins.c.I(th);
            } else {
                unsubscribe();
                this.f52767a.onError(th);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f52771e.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f52772f.unsubscribe();
                this.f52767a.onCompleted();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f52771e.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                rx.plugins.c.I(th);
            } else {
                this.f52772f.unsubscribe();
                this.f52767a.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            long j6 = this.f52771e.get();
            if (j6 != Long.MAX_VALUE) {
                long j7 = j6 + 1;
                if (this.f52771e.compareAndSet(j6, j7)) {
                    rx.m mVar = this.f52772f.get();
                    if (mVar != null) {
                        mVar.unsubscribe();
                    }
                    this.f52767a.onNext(t5);
                    this.f52774h++;
                    try {
                        rx.e<?> call = this.f52768b.call(t5);
                        if (call == null) {
                            throw new NullPointerException("The itemTimeoutIndicator returned a null Observable");
                        }
                        C1032a c1032a = new C1032a(j7);
                        if (this.f52772f.replace(c1032a)) {
                            call.r5(c1032a);
                        }
                    } catch (Throwable th) {
                        rx.exceptions.a.e(th);
                        unsubscribe();
                        this.f52771e.getAndSet(Long.MAX_VALUE);
                        this.f52767a.onError(th);
                    }
                }
            }
        }

        void s(rx.e<?> eVar) {
            if (eVar != null) {
                C1032a c1032a = new C1032a(0L);
                if (this.f52772f.replace(c1032a)) {
                    eVar.r5(c1032a);
                }
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f52770d.c(gVar);
        }

        a(rx.l<? super T> lVar, rx.functions.p<? super T, ? extends rx.e<?>> pVar, rx.e<? extends T> eVar) {
            this.f52767a = lVar;
            this.f52768b = pVar;
            this.f52769c = eVar;
            SequentialSubscription sequentialSubscription = new SequentialSubscription();
            this.f52772f = sequentialSubscription;
            this.f52773g = new SequentialSubscription(this);
            add(sequentialSubscription);
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        a aVar = new a(lVar, this.f52765c, this.f52766d);
        lVar.add(aVar.f52773g);
        lVar.setProducer(aVar.f52770d);
        aVar.s(this.f52764b);
        this.f52763a.r5(aVar);
    }

    public f1(rx.e<T> eVar, rx.e<U> eVar2, rx.functions.p<? super T, ? extends rx.e<V>> pVar, rx.e<? extends T> eVar3) {
        this.f52763a = eVar;
        this.f52764b = eVar2;
        this.f52765c = pVar;
        this.f52766d = eVar3;
    }
}
