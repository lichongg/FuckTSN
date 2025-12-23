package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t3<T> implements e.b<rx.schedulers.e<T>, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.h f53553a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private long f53554a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.l f53555b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f53555b = lVar2;
            this.f53554a = t3.this.f53553a.b();
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53555b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53555b.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            long b6 = t3.this.f53553a.b();
            this.f53555b.onNext(new rx.schedulers.e(b6 - this.f53554a, t5));
            this.f53554a = b6;
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super rx.schedulers.e<T>> lVar) {
        return new a(lVar, lVar);
    }

    public t3(rx.h hVar) {
        this.f53553a = hVar;
    }
}
