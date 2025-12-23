package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.i;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n4<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.b<rx.j<T>> f53233a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends AtomicBoolean implements rx.j<T>, rx.m {
        private static final long serialVersionUID = 8082834163465882809L;

        /* renamed from: a, reason: collision with root package name */
        final rx.k<? super T> f53234a;

        /* renamed from: b, reason: collision with root package name */
        final SequentialSubscription f53235b = new SequentialSubscription();

        @Override // rx.j
        public void onSuccess(T t5) {
            if (compareAndSet(false, true)) {
                try {
                    this.f53234a.d(t5);
                } finally {
                    this.f53235b.unsubscribe();
                }
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f53235b.unsubscribe();
            }
        }

        @Override // rx.j
        public void a(rx.functions.n nVar) {
            b(new CancellableSubscription(nVar));
        }

        @Override // rx.j
        public void b(rx.m mVar) {
            this.f53235b.update(mVar);
        }

        @Override // rx.j
        public void onError(Throwable th) {
            if (th == null) {
                th = new NullPointerException();
            }
            if (!compareAndSet(false, true)) {
                rx.plugins.c.I(th);
                return;
            }
            try {
                this.f53234a.onError(th);
            } finally {
                this.f53235b.unsubscribe();
            }
        }

        a(rx.k<? super T> kVar) {
            this.f53234a = kVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get();
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.b(aVar);
        try {
            this.f53233a.call(aVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            aVar.onError(th);
        }
    }

    public n4(rx.functions.b<rx.j<T>> bVar) {
        this.f53233a = bVar;
    }
}
