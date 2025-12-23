package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u3<T> implements e.b<rx.schedulers.f<T>, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.h f53586a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f53587a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f53587a = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53587a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53587a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53587a.onNext(new rx.schedulers.f(u3.this.f53586a.b(), t5));
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super rx.schedulers.f<T>> lVar) {
        return new a(lVar, lVar);
    }

    public u3(rx.h hVar) {
        this.f53586a = hVar;
    }
}
