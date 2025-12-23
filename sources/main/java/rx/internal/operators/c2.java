package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c2<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.a f52634a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f52635a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f52635a = lVar2;
        }

        void g() {
            try {
                c2.this.f52634a.call();
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                rx.plugins.c.I(th);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                this.f52635a.onCompleted();
            } finally {
                g();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                this.f52635a.onError(th);
            } finally {
                g();
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f52635a.onNext(t5);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }

    public c2(rx.functions.a aVar) {
        if (aVar != null) {
            this.f52634a = aVar;
            return;
        }
        throw new NullPointerException("Action can not be null");
    }
}
