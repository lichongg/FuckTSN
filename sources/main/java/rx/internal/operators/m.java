package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b;
import rx.internal.subscriptions.SequentialSubscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m implements b.j0 {

    /* renamed from: a, reason: collision with root package name */
    final Iterable<? extends rx.b> f53164a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends AtomicInteger implements rx.d {
        private static final long serialVersionUID = -7965400327305809232L;

        /* renamed from: a, reason: collision with root package name */
        final rx.d f53165a;

        /* renamed from: b, reason: collision with root package name */
        final Iterator<? extends rx.b> f53166b;

        /* renamed from: c, reason: collision with root package name */
        final SequentialSubscription f53167c = new SequentialSubscription();

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f53167c.replace(mVar);
        }

        void b() {
            if (!this.f53167c.isUnsubscribed() && getAndIncrement() == 0) {
                Iterator<? extends rx.b> it = this.f53166b;
                while (!this.f53167c.isUnsubscribed()) {
                    try {
                        if (!it.hasNext()) {
                            this.f53165a.onCompleted();
                            return;
                        }
                        try {
                            rx.b next = it.next();
                            if (next == null) {
                                this.f53165a.onError(new NullPointerException("The completable returned is null"));
                                return;
                            } else {
                                next.G0(this);
                                if (decrementAndGet() == 0) {
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            this.f53165a.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        this.f53165a.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f53165a.onError(th);
        }

        public a(rx.d dVar, Iterator<? extends rx.b> it) {
            this.f53165a = dVar;
            this.f53166b = it;
        }

        @Override // rx.d
        public void onCompleted() {
            b();
        }
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        try {
            Iterator<? extends rx.b> it = this.f53164a.iterator();
            if (it == null) {
                dVar.a(rx.subscriptions.f.e());
                dVar.onError(new NullPointerException("The iterator returned is null"));
            } else {
                a aVar = new a(dVar, it);
                dVar.a(aVar.f53167c);
                aVar.b();
            }
        } catch (Throwable th) {
            dVar.a(rx.subscriptions.f.e());
            dVar.onError(th);
        }
    }

    public m(Iterable<? extends rx.b> iterable) {
        this.f53164a = iterable;
    }
}
