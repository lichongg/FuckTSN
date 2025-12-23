package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p implements b.j0 {

    /* renamed from: a, reason: collision with root package name */
    final rx.b[] f53312a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f53313a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Queue f53314b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f53315c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rx.d f53316d;

        a(rx.subscriptions.b bVar, Queue queue, AtomicInteger atomicInteger, rx.d dVar) {
            this.f53313a = bVar;
            this.f53314b = queue;
            this.f53315c = atomicInteger;
            this.f53316d = dVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f53313a.a(mVar);
        }

        void b() {
            if (this.f53315c.decrementAndGet() == 0) {
                if (this.f53314b.isEmpty()) {
                    this.f53316d.onCompleted();
                } else {
                    this.f53316d.onError(n.a(this.f53314b));
                }
            }
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f53314b.offer(th);
            b();
        }

        @Override // rx.d
        public void onCompleted() {
            b();
        }
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        rx.d dVar2;
        rx.subscriptions.b bVar = new rx.subscriptions.b();
        AtomicInteger atomicInteger = new AtomicInteger(this.f53312a.length + 1);
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        dVar.a(bVar);
        rx.b[] bVarArr = this.f53312a;
        int length = bVarArr.length;
        int i6 = 0;
        while (i6 < length) {
            rx.b bVar2 = bVarArr[i6];
            if (bVar.isUnsubscribed()) {
                return;
            }
            if (bVar2 == null) {
                concurrentLinkedQueue.offer(new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
                dVar2 = dVar;
            } else {
                dVar2 = dVar;
                bVar2.G0(new a(bVar, concurrentLinkedQueue, atomicInteger, dVar2));
            }
            i6++;
            dVar = dVar2;
        }
        rx.d dVar3 = dVar;
        if (atomicInteger.decrementAndGet() == 0) {
            if (concurrentLinkedQueue.isEmpty()) {
                dVar3.onCompleted();
            } else {
                dVar3.onError(n.a(concurrentLinkedQueue));
            }
        }
    }

    public p(rx.b[] bVarArr) {
        this.f53312a = bVarArr;
    }
}
