package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e0<T, U> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<? extends T> f52730a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.o<? extends rx.e<U>> f52731b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<U> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f52732a;

        a(rx.l lVar) {
            this.f52732a = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            e0.this.f52730a.J6(rx.observers.h.f(this.f52732a));
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52732a.onError(th);
        }

        @Override // rx.f
        public void onNext(U u5) {
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        try {
            this.f52731b.call().D5(1).J6(new a(lVar));
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
        }
    }

    public e0(rx.e<? extends T> eVar, rx.functions.o<? extends rx.e<U>> oVar) {
        this.f52730a = eVar;
        this.f52731b = oVar;
    }
}
