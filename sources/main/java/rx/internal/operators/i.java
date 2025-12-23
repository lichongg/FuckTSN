package rx.internal.operators;

import rx.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i<T> implements b.j0 {

    /* renamed from: a, reason: collision with root package name */
    final rx.i<T> f52910a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends rx.b> f52911b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.k<T> implements rx.d {

        /* renamed from: b, reason: collision with root package name */
        final rx.d f52912b;

        /* renamed from: c, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends rx.b> f52913c;

        @Override // rx.k
        public void d(T t5) {
            try {
                rx.b call = this.f52913c.call(t5);
                if (call == null) {
                    onError(new NullPointerException("The mapper returned a null Completable"));
                } else {
                    call.q0(this);
                }
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                onError(th);
            }
        }

        @Override // rx.d
        public void onCompleted() {
            this.f52912b.onCompleted();
        }

        @Override // rx.k
        public void onError(Throwable th) {
            this.f52912b.onError(th);
        }

        public a(rx.d dVar, rx.functions.p<? super T, ? extends rx.b> pVar) {
            this.f52912b = dVar;
            this.f52913c = pVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            b(mVar);
        }
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        a aVar = new a(dVar, this.f52911b);
        dVar.a(aVar);
        this.f52910a.j0(aVar);
    }

    public i(rx.i<T> iVar, rx.functions.p<? super T, ? extends rx.b> pVar) {
        this.f52910a = iVar;
        this.f52911b = pVar;
    }
}
