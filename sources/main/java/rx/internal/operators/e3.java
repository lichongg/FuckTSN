package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e3<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final int f52736a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        int f52737a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.l f52738b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f52738b = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52738b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52738b.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            int i6 = this.f52737a;
            if (i6 >= e3.this.f52736a) {
                this.f52738b.onNext(t5);
            } else {
                this.f52737a = i6 + 1;
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f52738b.setProducer(gVar);
            gVar.request(e3.this.f52736a);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }

    public e3(int i6) {
        if (i6 >= 0) {
            this.f52736a = i6;
            return;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + i6);
    }
}
