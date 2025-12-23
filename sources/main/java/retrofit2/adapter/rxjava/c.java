package retrofit2.adapter.rxjava;

import retrofit2.c0;
import rx.e;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class c<T> implements e.a<c0<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final retrofit2.b<T> f52033a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements retrofit2.d<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f52034a;

        a(b bVar) {
            this.f52034a = bVar;
        }

        @Override // retrofit2.d
        public void b(retrofit2.b<T> bVar, c0<T> c0Var) {
            this.f52034a.d(c0Var);
        }

        @Override // retrofit2.d
        public void a(retrofit2.b<T> bVar, Throwable th) {
            rx.exceptions.a.e(th);
            this.f52034a.b(th);
        }
    }

    @Override // rx.functions.b
    public void call(l<? super c0<T>> lVar) {
        retrofit2.b<T> clone = this.f52033a.clone();
        b bVar = new b(clone, lVar);
        lVar.add(bVar);
        lVar.setProducer(bVar);
        clone.j(new a(bVar));
    }

    c(retrofit2.b<T> bVar) {
        this.f52033a = bVar;
    }
}
