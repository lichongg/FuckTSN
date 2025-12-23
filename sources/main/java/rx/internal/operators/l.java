package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.b;
import rx.internal.subscriptions.SequentialSubscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l implements b.j0 {

    /* renamed from: a, reason: collision with root package name */
    final rx.b[] f53125a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends AtomicInteger implements rx.d {
        private static final long serialVersionUID = -7965400327305809232L;

        /* renamed from: a, reason: collision with root package name */
        final rx.d f53126a;

        /* renamed from: b, reason: collision with root package name */
        final rx.b[] f53127b;

        /* renamed from: c, reason: collision with root package name */
        int f53128c;

        /* renamed from: d, reason: collision with root package name */
        final SequentialSubscription f53129d = new SequentialSubscription();

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f53129d.replace(mVar);
        }

        void b() {
            if (!this.f53129d.isUnsubscribed() && getAndIncrement() == 0) {
                rx.b[] bVarArr = this.f53127b;
                while (!this.f53129d.isUnsubscribed()) {
                    int i6 = this.f53128c;
                    this.f53128c = i6 + 1;
                    if (i6 == bVarArr.length) {
                        this.f53126a.onCompleted();
                        return;
                    } else {
                        bVarArr[i6].G0(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
            }
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f53126a.onError(th);
        }

        public a(rx.d dVar, rx.b[] bVarArr) {
            this.f53126a = dVar;
            this.f53127b = bVarArr;
        }

        @Override // rx.d
        public void onCompleted() {
            b();
        }
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        a aVar = new a(dVar, this.f53125a);
        dVar.a(aVar.f53129d);
        aVar.b();
    }

    public l(rx.b[] bVarArr) {
        this.f53125a = bVarArr;
    }
}
