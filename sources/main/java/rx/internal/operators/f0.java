package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f0<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T> f52756a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> implements rx.g, rx.m {

        /* renamed from: a, reason: collision with root package name */
        final b<T> f52757a;

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f52757a.isUnsubscribed();
        }

        @Override // rx.g
        public void request(long j6) {
            this.f52757a.g(j6);
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f52757a.j();
        }

        public a(b<T> bVar) {
            this.f52757a = bVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReference<rx.l<? super T>> f52758a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference<rx.g> f52759b = new AtomicReference<>();

        /* renamed from: c, reason: collision with root package name */
        final AtomicLong f52760c = new AtomicLong();

        void g(long j6) {
            if (j6 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j6);
            }
            rx.g gVar = this.f52759b.get();
            if (gVar != null) {
                gVar.request(j6);
                return;
            }
            rx.internal.operators.a.b(this.f52760c, j6);
            rx.g gVar2 = this.f52759b.get();
            if (gVar2 == null || gVar2 == c.INSTANCE) {
                return;
            }
            gVar2.request(this.f52760c.getAndSet(0L));
        }

        void j() {
            this.f52759b.lazySet(c.INSTANCE);
            this.f52758a.lazySet(null);
            unsubscribe();
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52759b.lazySet(c.INSTANCE);
            rx.l<? super T> andSet = this.f52758a.getAndSet(null);
            if (andSet != null) {
                andSet.onCompleted();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52759b.lazySet(c.INSTANCE);
            rx.l<? super T> andSet = this.f52758a.getAndSet(null);
            if (andSet != null) {
                andSet.onError(th);
            } else {
                rx.plugins.c.I(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            rx.l<? super T> lVar = this.f52758a.get();
            if (lVar != null) {
                lVar.onNext(t5);
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            if (androidx.camera.view.p.a(this.f52759b, null, gVar)) {
                gVar.request(this.f52760c.getAndSet(0L));
            } else if (this.f52759b.get() != c.INSTANCE) {
                throw new IllegalStateException("Producer already set!");
            }
        }

        public b(rx.l<? super T> lVar) {
            this.f52758a = new AtomicReference<>(lVar);
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        b bVar = new b(lVar);
        a aVar = new a(bVar);
        lVar.add(aVar);
        lVar.setProducer(aVar);
        this.f52756a.J6(bVar);
    }

    public f0(rx.e<T> eVar) {
        this.f52756a = eVar;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum c implements rx.g {
        INSTANCE;

        @Override // rx.g
        public void request(long j6) {
        }
    }
}
