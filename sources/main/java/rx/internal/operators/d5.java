package rx.internal.operators;

import rx.e;
import rx.i;
import rx.internal.operators.q4;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d5<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.t<T> f52721a;

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        q4.a aVar = new q4.a(lVar);
        lVar.add(aVar);
        this.f52721a.call(aVar);
    }

    public d5(i.t<T> tVar) {
        this.f52721a = tVar;
    }
}
