package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.h;
import rx.internal.subscriptions.SequentialSubscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g1<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T> f52812a;

    /* renamed from: b, reason: collision with root package name */
    final long f52813b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f52814c;

    /* renamed from: d, reason: collision with root package name */
    final rx.h f52815d;

    /* renamed from: e, reason: collision with root package name */
    final rx.e<? extends T> f52816e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f52817a;

        /* renamed from: b, reason: collision with root package name */
        final rx.internal.producers.a f52818b;

        @Override // rx.f
        public void onCompleted() {
            this.f52817a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52817a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f52817a.onNext(t5);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f52818b.c(gVar);
        }

        a(rx.l<? super T> lVar, rx.internal.producers.a aVar) {
            this.f52817a = lVar;
            this.f52818b = aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f52819a;

        /* renamed from: b, reason: collision with root package name */
        final long f52820b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f52821c;

        /* renamed from: d, reason: collision with root package name */
        final h.a f52822d;

        /* renamed from: e, reason: collision with root package name */
        final rx.e<? extends T> f52823e;

        /* renamed from: f, reason: collision with root package name */
        final rx.internal.producers.a f52824f = new rx.internal.producers.a();

        /* renamed from: g, reason: collision with root package name */
        final AtomicLong f52825g = new AtomicLong();

        /* renamed from: h, reason: collision with root package name */
        final SequentialSubscription f52826h;

        /* renamed from: i, reason: collision with root package name */
        final SequentialSubscription f52827i;

        /* renamed from: j, reason: collision with root package name */
        long f52828j;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class a implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final long f52829a;

            a(long j6) {
                this.f52829a = j6;
            }

            @Override // rx.functions.a
            public void call() {
                b.this.g(this.f52829a);
            }
        }

        void g(long j6) {
            if (this.f52825g.compareAndSet(j6, Long.MAX_VALUE)) {
                unsubscribe();
                if (this.f52823e == null) {
                    this.f52819a.onError(new TimeoutException());
                    return;
                }
                long j7 = this.f52828j;
                if (j7 != 0) {
                    this.f52824f.b(j7);
                }
                a aVar = new a(this.f52819a, this.f52824f);
                if (this.f52827i.replace(aVar)) {
                    this.f52823e.r5(aVar);
                }
            }
        }

        void j(long j6) {
            this.f52826h.replace(this.f52822d.e(new a(j6), this.f52820b, this.f52821c));
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f52825g.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f52826h.unsubscribe();
                this.f52819a.onCompleted();
                this.f52822d.unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f52825g.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                rx.plugins.c.I(th);
                return;
            }
            this.f52826h.unsubscribe();
            this.f52819a.onError(th);
            this.f52822d.unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t5) {
            long j6 = this.f52825g.get();
            if (j6 != Long.MAX_VALUE) {
                long j7 = j6 + 1;
                if (this.f52825g.compareAndSet(j6, j7)) {
                    rx.m mVar = this.f52826h.get();
                    if (mVar != null) {
                        mVar.unsubscribe();
                    }
                    this.f52828j++;
                    this.f52819a.onNext(t5);
                    j(j7);
                }
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f52824f.c(gVar);
        }

        b(rx.l<? super T> lVar, long j6, TimeUnit timeUnit, h.a aVar, rx.e<? extends T> eVar) {
            this.f52819a = lVar;
            this.f52820b = j6;
            this.f52821c = timeUnit;
            this.f52822d = aVar;
            this.f52823e = eVar;
            SequentialSubscription sequentialSubscription = new SequentialSubscription();
            this.f52826h = sequentialSubscription;
            this.f52827i = new SequentialSubscription(this);
            add(aVar);
            add(sequentialSubscription);
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        b bVar = new b(lVar, this.f52813b, this.f52814c, this.f52815d.a(), this.f52816e);
        lVar.add(bVar.f52827i);
        lVar.setProducer(bVar.f52824f);
        bVar.j(0L);
        this.f52812a.r5(bVar);
    }

    public g1(rx.e<T> eVar, long j6, TimeUnit timeUnit, rx.h hVar, rx.e<? extends T> eVar2) {
        this.f52812a = eVar;
        this.f52813b = j6;
        this.f52814c = timeUnit;
        this.f52815d = hVar;
        this.f52816e = eVar2;
    }
}
