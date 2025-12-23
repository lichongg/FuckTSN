package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r implements b.j0 {

    /* renamed from: a, reason: collision with root package name */
    final Iterable<? extends rx.b> f53408a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f53409a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f53410b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.d f53411c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f53412d;

        a(rx.subscriptions.b bVar, AtomicBoolean atomicBoolean, rx.d dVar, AtomicInteger atomicInteger) {
            this.f53409a = bVar;
            this.f53410b = atomicBoolean;
            this.f53411c = dVar;
            this.f53412d = atomicInteger;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f53409a.a(mVar);
        }

        @Override // rx.d
        public void onCompleted() {
            if (this.f53412d.decrementAndGet() == 0 && this.f53410b.compareAndSet(false, true)) {
                this.f53411c.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f53409a.unsubscribe();
            if (this.f53410b.compareAndSet(false, true)) {
                this.f53411c.onError(th);
            } else {
                rx.plugins.c.I(th);
            }
        }
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        rx.subscriptions.b bVar = new rx.subscriptions.b();
        dVar.a(bVar);
        try {
            Iterator<? extends rx.b> it = this.f53408a.iterator();
            if (it == null) {
                dVar.onError(new NullPointerException("The source iterator returned is null"));
                return;
            }
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            while (!bVar.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        if (atomicInteger.decrementAndGet() == 0 && atomicBoolean.compareAndSet(false, true)) {
                            dVar.onCompleted();
                            return;
                        }
                        return;
                    }
                    if (bVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        rx.b next = it.next();
                        if (bVar.isUnsubscribed()) {
                            return;
                        }
                        if (next == null) {
                            bVar.unsubscribe();
                            Throwable nullPointerException = new NullPointerException("A completable source is null");
                            if (atomicBoolean.compareAndSet(false, true)) {
                                dVar.onError(nullPointerException);
                                return;
                            } else {
                                rx.plugins.c.I(nullPointerException);
                                return;
                            }
                        }
                        atomicInteger.getAndIncrement();
                        next.G0(new a(bVar, atomicBoolean, dVar, atomicInteger));
                    } catch (Throwable th) {
                        bVar.unsubscribe();
                        if (atomicBoolean.compareAndSet(false, true)) {
                            dVar.onError(th);
                            return;
                        } else {
                            rx.plugins.c.I(th);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    bVar.unsubscribe();
                    if (atomicBoolean.compareAndSet(false, true)) {
                        dVar.onError(th2);
                        return;
                    } else {
                        rx.plugins.c.I(th2);
                        return;
                    }
                }
            }
        } catch (Throwable th3) {
            dVar.onError(th3);
        }
    }

    public r(Iterable<? extends rx.b> iterable) {
        this.f53408a = iterable;
    }
}
