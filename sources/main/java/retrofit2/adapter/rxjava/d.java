package retrofit2.adapter.rxjava;

import retrofit2.c0;
import rx.e;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class d<T> implements e.a<c0<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final retrofit2.b<T> f52036a;

    @Override // rx.functions.b
    public void call(l<? super c0<T>> lVar) {
        retrofit2.b<T> clone = this.f52036a.clone();
        b bVar = new b(clone, lVar);
        lVar.add(bVar);
        lVar.setProducer(bVar);
        try {
            bVar.d(clone.execute());
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            bVar.b(th);
        }
    }

    d(retrofit2.b<T> bVar) {
        this.f52036a = bVar;
    }
}
