package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o implements b.j0 {

    /* renamed from: a, reason: collision with root package name */
    final rx.b[] f53236a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f53237a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f53238b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.d f53239c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f53240d;

        a(rx.subscriptions.b bVar, AtomicBoolean atomicBoolean, rx.d dVar, AtomicInteger atomicInteger) {
            this.f53237a = bVar;
            this.f53238b = atomicBoolean;
            this.f53239c = dVar;
            this.f53240d = atomicInteger;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f53237a.a(mVar);
        }

        @Override // rx.d
        public void onCompleted() {
            if (this.f53240d.decrementAndGet() == 0 && this.f53238b.compareAndSet(false, true)) {
                this.f53239c.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f53237a.unsubscribe();
            if (this.f53238b.compareAndSet(false, true)) {
                this.f53239c.onError(th);
            } else {
                rx.plugins.c.I(th);
            }
        }
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        rx.subscriptions.b bVar = new rx.subscriptions.b();
        AtomicInteger atomicInteger = new AtomicInteger(this.f53236a.length + 1);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        dVar.a(bVar);
        for (rx.b bVar2 : this.f53236a) {
            if (bVar.isUnsubscribed()) {
                return;
            }
            if (bVar2 == null) {
                bVar.unsubscribe();
                Throwable nullPointerException = new NullPointerException("A completable source is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    dVar.onError(nullPointerException);
                    return;
                }
                rx.plugins.c.I(nullPointerException);
            }
            bVar2.G0(new a(bVar, atomicBoolean, dVar, atomicInteger));
        }
        if (atomicInteger.decrementAndGet() == 0 && atomicBoolean.compareAndSet(false, true)) {
            dVar.onCompleted();
        }
    }

    public o(rx.b[] bVarArr) {
        this.f53236a = bVarArr;
    }
}
