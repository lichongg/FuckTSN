package rx.internal.operators;

import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i4<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.i<T> f52978a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.a f52979b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.k<T> {

        /* renamed from: b, reason: collision with root package name */
        final rx.k<? super T> f52980b;

        /* renamed from: c, reason: collision with root package name */
        final rx.functions.a f52981c;

        @Override // rx.k
        public void d(T t5) {
            try {
                this.f52980b.d(t5);
            } finally {
                e();
            }
        }

        void e() {
            try {
                this.f52981c.call();
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                rx.plugins.c.I(th);
            }
        }

        @Override // rx.k
        public void onError(Throwable th) {
            try {
                this.f52980b.onError(th);
            } finally {
                e();
            }
        }

        public a(rx.k<? super T> kVar, rx.functions.a aVar) {
            this.f52980b = kVar;
            this.f52981c = aVar;
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar, this.f52979b);
        kVar.b(aVar);
        this.f52978a.j0(aVar);
    }

    public i4(rx.i<T> iVar, rx.functions.a aVar) {
        this.f52978a = iVar;
        this.f52979b = aVar;
    }
}
