package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y0<T, R> implements e.a<R> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T> f53843a;

    /* renamed from: b, reason: collision with root package name */
    final R f53844b;

    /* renamed from: c, reason: collision with root package name */
    final rx.functions.q<R, ? super T, R> f53845c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T, R> extends t<T, R> {

        /* renamed from: i, reason: collision with root package name */
        final rx.functions.q<R, ? super T, R> f53846i;

        @Override // rx.f
        public void onNext(T t5) {
            try {
                this.f53515c = this.f53846i.call(this.f53515c, t5);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                this.f53513a.onError(th);
            }
        }

        public a(rx.l<? super R> lVar, R r5, rx.functions.q<R, ? super T, R> qVar) {
            super(lVar);
            this.f53515c = r5;
            this.f53514b = true;
            this.f53846i = qVar;
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super R> lVar) {
        new a(lVar, this.f53844b, this.f53845c).B(this.f53843a);
    }

    public y0(rx.e<T> eVar, R r5, rx.functions.q<R, ? super T, R> qVar) {
        this.f53843a = eVar;
        this.f53844b = r5;
        this.f53845c = qVar;
    }
}
