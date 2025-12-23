package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c0<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<? extends T> f52617a;

    /* renamed from: b, reason: collision with root package name */
    final long f52618b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f52619c;

    /* renamed from: d, reason: collision with root package name */
    final rx.h f52620d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f52621a;

        a(rx.l lVar) {
            this.f52621a = lVar;
        }

        @Override // rx.functions.a
        public void call() {
            if (this.f52621a.isUnsubscribed()) {
                return;
            }
            c0.this.f52617a.J6(rx.observers.h.f(this.f52621a));
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        h.a a6 = this.f52620d.a();
        lVar.add(a6);
        a6.e(new a(lVar), this.f52618b, this.f52619c);
    }

    public c0(rx.e<? extends T> eVar, long j6, TimeUnit timeUnit, rx.h hVar) {
        this.f52617a = eVar;
        this.f52618b = j6;
        this.f52619c = timeUnit;
        this.f52620d = hVar;
    }
}
