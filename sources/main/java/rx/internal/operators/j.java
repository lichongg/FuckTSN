package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.b;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j implements b.j0 {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.b<rx.c> f52982a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends AtomicBoolean implements rx.c, rx.m {
        private static final long serialVersionUID = 5539301318568668881L;

        /* renamed from: a, reason: collision with root package name */
        final rx.d f52983a;

        /* renamed from: b, reason: collision with root package name */
        final SequentialSubscription f52984b = new SequentialSubscription();

        @Override // rx.c
        public void onCompleted() {
            if (compareAndSet(false, true)) {
                try {
                    this.f52983a.onCompleted();
                } finally {
                    this.f52984b.unsubscribe();
                }
            }
        }

        @Override // rx.c
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                rx.plugins.c.I(th);
                return;
            }
            try {
                this.f52983a.onError(th);
            } finally {
                this.f52984b.unsubscribe();
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f52984b.unsubscribe();
            }
        }

        @Override // rx.c
        public void a(rx.functions.n nVar) {
            b(new CancellableSubscription(nVar));
        }

        @Override // rx.c
        public void b(rx.m mVar) {
            this.f52984b.update(mVar);
        }

        public a(rx.d dVar) {
            this.f52983a = dVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get();
        }
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        a aVar = new a(dVar);
        dVar.a(aVar);
        try {
            this.f52982a.call(aVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            aVar.onError(th);
        }
    }

    public j(rx.functions.b<rx.c> bVar) {
        this.f52982a = bVar;
    }
}
