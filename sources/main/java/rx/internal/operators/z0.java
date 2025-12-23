package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z0<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final rx.observables.c<? extends T> f53905a;

    /* renamed from: b, reason: collision with root package name */
    volatile rx.subscriptions.b f53906b = new rx.subscriptions.b();

    /* renamed from: c, reason: collision with root package name */
    final AtomicInteger f53907c = new AtomicInteger(0);

    /* renamed from: d, reason: collision with root package name */
    final ReentrantLock f53908d = new ReentrantLock();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.functions.b<rx.m> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f53909a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f53910b;

        a(rx.l lVar, AtomicBoolean atomicBoolean) {
            this.f53909a = lVar;
            this.f53910b = atomicBoolean;
        }

        @Override // rx.functions.b
        public void call(rx.m mVar) {
            try {
                z0.this.f53906b.a(mVar);
                z0 z0Var = z0.this;
                z0Var.c(this.f53909a, z0Var.f53906b);
            } finally {
                z0.this.f53908d.unlock();
                this.f53910b.set(false);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f53912a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f53913b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.l lVar, rx.l lVar2, rx.subscriptions.b bVar) {
            super(lVar);
            this.f53912a = lVar2;
            this.f53913b = bVar;
        }

        void g() {
            z0.this.f53908d.lock();
            try {
                if (z0.this.f53906b == this.f53913b) {
                    if (z0.this.f53905a instanceof rx.m) {
                        ((rx.m) z0.this.f53905a).unsubscribe();
                    }
                    z0.this.f53906b.unsubscribe();
                    z0.this.f53906b = new rx.subscriptions.b();
                    z0.this.f53907c.set(0);
                }
                z0.this.f53908d.unlock();
            } catch (Throwable th) {
                z0.this.f53908d.unlock();
                throw th;
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53912a.onNext(t5);
        }

        @Override // rx.f
        public void onCompleted() {
            g();
            this.f53912a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            g();
            this.f53912a.onError(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f53915a;

        c(rx.subscriptions.b bVar) {
            this.f53915a = bVar;
        }

        @Override // rx.functions.a
        public void call() {
            z0.this.f53908d.lock();
            try {
                if (z0.this.f53906b == this.f53915a && z0.this.f53907c.decrementAndGet() == 0) {
                    if (z0.this.f53905a instanceof rx.m) {
                        ((rx.m) z0.this.f53905a).unsubscribe();
                    }
                    z0.this.f53906b.unsubscribe();
                    z0.this.f53906b = new rx.subscriptions.b();
                }
                z0.this.f53908d.unlock();
            } catch (Throwable th) {
                z0.this.f53908d.unlock();
                throw th;
            }
        }
    }

    private rx.m b(rx.subscriptions.b bVar) {
        return rx.subscriptions.f.a(new c(bVar));
    }

    private rx.functions.b<rx.m> d(rx.l<? super T> lVar, AtomicBoolean atomicBoolean) {
        return new a(lVar, atomicBoolean);
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        this.f53908d.lock();
        if (this.f53907c.incrementAndGet() != 1) {
            try {
                c(lVar, this.f53906b);
            } finally {
                this.f53908d.unlock();
            }
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f53905a.A7(d(lVar, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
    }

    public z0(rx.observables.c<? extends T> cVar) {
        this.f53905a = cVar;
    }

    void c(rx.l<? super T> lVar, rx.subscriptions.b bVar) {
        lVar.add(b(bVar));
        this.f53905a.J6(new b(lVar, lVar, bVar));
    }
}
