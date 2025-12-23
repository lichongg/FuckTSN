package rx.internal.operators;

import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k4<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.t<T> f53123a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.a f53124b;

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        try {
            this.f53124b.call();
            this.f53123a.call(kVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            kVar.onError(th);
        }
    }

    public k4(i.t<T> tVar, rx.functions.a aVar) {
        this.f53123a = tVar;
        this.f53124b = aVar;
    }
}
