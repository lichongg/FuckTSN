package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.e;
import rx.internal.producers.SingleProducer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l1 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<T> implements e.a<T> {

        /* renamed from: a, reason: collision with root package name */
        final Future<? extends T> f53134a;

        /* renamed from: b, reason: collision with root package name */
        private final long f53135b;

        /* renamed from: c, reason: collision with root package name */
        private final TimeUnit f53136c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.l1$a$a, reason: collision with other inner class name */
        class C1040a implements rx.functions.a {
            C1040a() {
            }

            @Override // rx.functions.a
            public void call() {
                a.this.f53134a.cancel(true);
            }
        }

        public a(Future<? extends T> future) {
            this.f53134a = future;
            this.f53135b = 0L;
            this.f53136c = null;
        }

        @Override // rx.functions.b
        public void call(rx.l<? super T> lVar) {
            lVar.add(rx.subscriptions.f.a(new C1040a()));
            try {
                if (lVar.isUnsubscribed()) {
                    return;
                }
                TimeUnit timeUnit = this.f53136c;
                lVar.setProducer(new SingleProducer(lVar, timeUnit == null ? this.f53134a.get() : this.f53134a.get(this.f53135b, timeUnit)));
            } catch (Throwable th) {
                if (lVar.isUnsubscribed()) {
                    return;
                }
                rx.exceptions.a.f(th, lVar);
            }
        }

        public a(Future<? extends T> future, long j6, TimeUnit timeUnit) {
            this.f53134a = future;
            this.f53135b = j6;
            this.f53136c = timeUnit;
        }
    }

    public static <T> e.a<T> a(Future<? extends T> future) {
        return new a(future);
    }

    public static <T> e.a<T> b(Future<? extends T> future, long j6, TimeUnit timeUnit) {
        return new a(future, j6, timeUnit);
    }

    private l1() {
        throw new IllegalStateException("No instances!");
    }
}
