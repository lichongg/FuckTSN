package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c1<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<? extends T> f52623a;

    /* renamed from: b, reason: collision with root package name */
    final rx.e<? extends T> f52624b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private final rx.internal.producers.a f52625a;

        /* renamed from: b, reason: collision with root package name */
        private final rx.l<? super T> f52626b;

        @Override // rx.f
        public void onCompleted() {
            this.f52626b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52626b.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f52626b.onNext(t5);
            this.f52625a.b(1L);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f52625a.c(gVar);
        }

        a(rx.l<? super T> lVar, rx.internal.producers.a aVar) {
            this.f52626b = lVar;
            this.f52625a = aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends rx.l<T> {

        /* renamed from: b, reason: collision with root package name */
        private final rx.l<? super T> f52628b;

        /* renamed from: c, reason: collision with root package name */
        private final rx.subscriptions.e f52629c;

        /* renamed from: d, reason: collision with root package name */
        private final rx.internal.producers.a f52630d;

        /* renamed from: e, reason: collision with root package name */
        private final rx.e<? extends T> f52631e;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f52633g;

        /* renamed from: a, reason: collision with root package name */
        private boolean f52627a = true;

        /* renamed from: f, reason: collision with root package name */
        final AtomicInteger f52632f = new AtomicInteger();

        @Override // rx.f
        public void onNext(T t5) {
            this.f52627a = false;
            this.f52628b.onNext(t5);
            this.f52630d.b(1L);
        }

        void g(rx.e<? extends T> eVar) {
            if (this.f52632f.getAndIncrement() == 0) {
                while (!this.f52628b.isUnsubscribed()) {
                    if (!this.f52633g) {
                        if (eVar == null) {
                            a aVar = new a(this.f52628b, this.f52630d);
                            this.f52629c.b(aVar);
                            this.f52633g = true;
                            this.f52631e.J6(aVar);
                        } else {
                            this.f52633g = true;
                            eVar.J6(this);
                            eVar = null;
                        }
                    }
                    if (this.f52632f.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (!this.f52627a) {
                this.f52628b.onCompleted();
            } else {
                if (this.f52628b.isUnsubscribed()) {
                    return;
                }
                this.f52633g = false;
                g(null);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52628b.onError(th);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f52630d.c(gVar);
        }

        b(rx.l<? super T> lVar, rx.subscriptions.e eVar, rx.internal.producers.a aVar, rx.e<? extends T> eVar2) {
            this.f52628b = lVar;
            this.f52629c = eVar;
            this.f52630d = aVar;
            this.f52631e = eVar2;
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        b bVar = new b(lVar, eVar, aVar, this.f52624b);
        eVar.b(bVar);
        lVar.add(eVar);
        lVar.setProducer(aVar);
        bVar.g(this.f52623a);
    }

    public c1(rx.e<? extends T> eVar, rx.e<? extends T> eVar2) {
        this.f52623a = eVar;
        this.f52624b = eVar2;
    }
}
