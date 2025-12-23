package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.e;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x2<T> implements e.b<T, rx.e<T>> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.q<Integer, Throwable, Boolean> f53797a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<rx.e<T>> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f53798a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.q<Integer, Throwable, Boolean> f53799b;

        /* renamed from: c, reason: collision with root package name */
        final h.a f53800c;

        /* renamed from: d, reason: collision with root package name */
        final rx.subscriptions.e f53801d;

        /* renamed from: e, reason: collision with root package name */
        final rx.internal.producers.a f53802e;

        /* renamed from: f, reason: collision with root package name */
        final AtomicInteger f53803f = new AtomicInteger();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.x2$a$a, reason: collision with other inner class name */
        class C1055a implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.e f53804a;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: rx.internal.operators.x2$a$a$a, reason: collision with other inner class name */
            class C1056a extends rx.l<T> {

                /* renamed from: a, reason: collision with root package name */
                boolean f53806a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ rx.functions.a f53807b;

                C1056a(rx.functions.a aVar) {
                    this.f53807b = aVar;
                }

                @Override // rx.f
                public void onCompleted() {
                    if (this.f53806a) {
                        return;
                    }
                    this.f53806a = true;
                    a.this.f53798a.onCompleted();
                }

                @Override // rx.f
                public void onError(Throwable th) {
                    if (this.f53806a) {
                        return;
                    }
                    this.f53806a = true;
                    a aVar = a.this;
                    if (!aVar.f53799b.call(Integer.valueOf(aVar.f53803f.get()), th).booleanValue() || a.this.f53800c.isUnsubscribed()) {
                        a.this.f53798a.onError(th);
                    } else {
                        a.this.f53800c.d(this.f53807b);
                    }
                }

                @Override // rx.f
                public void onNext(T t5) {
                    if (this.f53806a) {
                        return;
                    }
                    a.this.f53798a.onNext(t5);
                    a.this.f53802e.b(1L);
                }

                @Override // rx.l, rx.observers.a
                public void setProducer(rx.g gVar) {
                    a.this.f53802e.c(gVar);
                }
            }

            C1055a(rx.e eVar) {
                this.f53804a = eVar;
            }

            @Override // rx.functions.a
            public void call() {
                a.this.f53803f.incrementAndGet();
                C1056a c1056a = new C1056a(this);
                a.this.f53801d.b(c1056a);
                this.f53804a.J6(c1056a);
            }
        }

        @Override // rx.f
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onNext(rx.e<T> eVar) {
            this.f53800c.d(new C1055a(eVar));
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53798a.onError(th);
        }

        public a(rx.l<? super T> lVar, rx.functions.q<Integer, Throwable, Boolean> qVar, h.a aVar, rx.subscriptions.e eVar, rx.internal.producers.a aVar2) {
            this.f53798a = lVar;
            this.f53799b = qVar;
            this.f53800c = aVar;
            this.f53801d = eVar;
            this.f53802e = aVar2;
        }

        @Override // rx.f
        public void onCompleted() {
        }
    }

    @Override // rx.functions.p
    public rx.l<? super rx.e<T>> call(rx.l<? super T> lVar) {
        h.a a6 = rx.schedulers.c.m().a();
        lVar.add(a6);
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        lVar.add(eVar);
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        lVar.setProducer(aVar);
        return new a(lVar, this.f53797a, a6, eVar, aVar);
    }

    public x2(rx.functions.q<Integer, Throwable, Boolean> qVar) {
        this.f53797a = qVar;
    }
}
