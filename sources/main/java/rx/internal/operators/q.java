package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q implements b.j0 {

    /* renamed from: a, reason: collision with root package name */
    final Iterable<? extends rx.b> f53366a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f53367a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Queue f53368b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f53369c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rx.d f53370d;

        a(rx.subscriptions.b bVar, Queue queue, AtomicInteger atomicInteger, rx.d dVar) {
            this.f53367a = bVar;
            this.f53368b = queue;
            this.f53369c = atomicInteger;
            this.f53370d = dVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f53367a.a(mVar);
        }

        void b() {
            if (this.f53369c.decrementAndGet() == 0) {
                if (this.f53368b.isEmpty()) {
                    this.f53370d.onCompleted();
                } else {
                    this.f53370d.onError(n.a(this.f53368b));
                }
            }
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f53368b.offer(th);
            b();
        }

        @Override // rx.d
        public void onCompleted() {
            b();
        }
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        rx.subscriptions.b bVar = new rx.subscriptions.b();
        dVar.a(bVar);
        try {
            Iterator<? extends rx.b> it = this.f53366a.iterator();
            if (it == null) {
                dVar.onError(new NullPointerException("The source iterator returned is null"));
                return;
            }
            AtomicInteger atomicInteger = new AtomicInteger(1);
            Queue oVar = rx.internal.util.unsafe.n0.f() ? new rx.internal.util.unsafe.o() : new rx.internal.util.atomic.c();
            while (!bVar.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        if (atomicInteger.decrementAndGet() == 0) {
                            if (oVar.isEmpty()) {
                                dVar.onCompleted();
                                return;
                            } else {
                                dVar.onError(n.a(oVar));
                                return;
                            }
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
                            oVar.offer(new NullPointerException("A completable source is null"));
                            if (atomicInteger.decrementAndGet() == 0) {
                                if (oVar.isEmpty()) {
                                    dVar.onCompleted();
                                    return;
                                } else {
                                    dVar.onError(n.a(oVar));
                                    return;
                                }
                            }
                            return;
                        }
                        atomicInteger.getAndIncrement();
                        next.G0(new a(bVar, oVar, atomicInteger, dVar));
                    } catch (Throwable th) {
                        oVar.offer(th);
                        if (atomicInteger.decrementAndGet() == 0) {
                            if (oVar.isEmpty()) {
                                dVar.onCompleted();
                                return;
                            } else {
                                dVar.onError(n.a(oVar));
                                return;
                            }
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    oVar.offer(th2);
                    if (atomicInteger.decrementAndGet() == 0) {
                        if (oVar.isEmpty()) {
                            dVar.onCompleted();
                            return;
                        } else {
                            dVar.onError(n.a(oVar));
                            return;
                        }
                    }
                    return;
                }
            }
        } catch (Throwable th3) {
            dVar.onError(th3);
        }
    }

    public q(Iterable<? extends rx.b> iterable) {
        this.f53366a = iterable;
    }
}
