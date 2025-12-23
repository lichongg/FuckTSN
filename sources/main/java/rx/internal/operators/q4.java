package rx.internal.operators;

import rx.e;
import rx.i;
import rx.internal.operators.p4;
import rx.internal.producers.SingleProducer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q4<T, R> implements i.t<R> {

    /* renamed from: a, reason: collision with root package name */
    final i.t<T> f53405a;

    /* renamed from: b, reason: collision with root package name */
    final e.b<? extends R, ? super T> f53406b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.k<T> {

        /* renamed from: b, reason: collision with root package name */
        final rx.l<? super T> f53407b;

        @Override // rx.k
        public void d(T t5) {
            this.f53407b.setProducer(new SingleProducer(this.f53407b, t5));
        }

        @Override // rx.k
        public void onError(Throwable th) {
            this.f53407b.onError(th);
        }

        a(rx.l<? super T> lVar) {
            this.f53407b = lVar;
        }
    }

    public static <T> rx.k<T> a(rx.l<T> lVar) {
        a aVar = new a(lVar);
        lVar.add(aVar);
        return aVar;
    }

    @Override // rx.functions.b
    public void call(rx.k<? super R> kVar) {
        p4.a aVar = new p4.a(kVar);
        kVar.b(aVar);
        try {
            rx.l<? super T> call = rx.plugins.c.R(this.f53406b).call(aVar);
            rx.k a6 = a(call);
            call.onStart();
            this.f53405a.call(a6);
        } catch (Throwable th) {
            rx.exceptions.a.h(th, kVar);
        }
    }

    public q4(i.t<T> tVar, e.b<? extends R, ? super T> bVar) {
        this.f53405a = tVar;
        this.f53406b = bVar;
    }
}
