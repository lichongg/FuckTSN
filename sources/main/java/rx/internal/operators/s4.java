package rx.internal.operators;

import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s4<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.t<T> f53505a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<Throwable, ? extends T> f53506b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.k<T> {

        /* renamed from: b, reason: collision with root package name */
        final rx.k<? super T> f53507b;

        /* renamed from: c, reason: collision with root package name */
        final rx.functions.p<Throwable, ? extends T> f53508c;

        @Override // rx.k
        public void d(T t5) {
            this.f53507b.d(t5);
        }

        @Override // rx.k
        public void onError(Throwable th) {
            try {
                this.f53507b.d(this.f53508c.call(th));
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                this.f53507b.onError(th2);
            }
        }

        public a(rx.k<? super T> kVar, rx.functions.p<Throwable, ? extends T> pVar) {
            this.f53507b = kVar;
            this.f53508c = pVar;
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar, this.f53506b);
        kVar.b(aVar);
        this.f53505a.call(aVar);
    }

    public s4(i.t<T> tVar, rx.functions.p<Throwable, ? extends T> pVar) {
        this.f53505a = tVar;
        this.f53506b = pVar;
    }
}
