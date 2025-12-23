package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z2<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final long f53922a;

    /* renamed from: b, reason: collision with root package name */
    final TimeUnit f53923b;

    /* renamed from: c, reason: collision with root package name */
    final rx.h f53924c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: c, reason: collision with root package name */
        private static final Object f53925c = new Object();

        /* renamed from: a, reason: collision with root package name */
        private final rx.l<? super T> f53926a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference<Object> f53927b = new AtomicReference<>(f53925c);

        private void g() {
            AtomicReference<Object> atomicReference = this.f53927b;
            Object obj = f53925c;
            Object andSet = atomicReference.getAndSet(obj);
            if (andSet != obj) {
                try {
                    this.f53926a.onNext(andSet);
                } catch (Throwable th) {
                    rx.exceptions.a.f(th, this);
                }
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53926a.onError(th);
            unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53927b.set(t5);
        }

        public a(rx.l<? super T> lVar) {
            this.f53926a = lVar;
        }

        @Override // rx.functions.a
        public void call() {
            g();
        }

        @Override // rx.f
        public void onCompleted() {
            g();
            this.f53926a.onCompleted();
            unsubscribe();
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.observers.g gVar = new rx.observers.g(lVar);
        h.a a6 = this.f53924c.a();
        lVar.add(a6);
        a aVar = new a(gVar);
        lVar.add(aVar);
        long j6 = this.f53922a;
        a6.f(aVar, j6, j6, this.f53923b);
        return aVar;
    }

    public z2(long j6, TimeUnit timeUnit, rx.h hVar) {
        this.f53922a = j6;
        this.f53923b = timeUnit;
        this.f53924c = hVar;
    }
}
