package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b0<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.o<? extends rx.e<? extends T>> f52575a;

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        try {
            this.f52575a.call().J6(rx.observers.h.f(lVar));
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
        }
    }

    public b0(rx.functions.o<? extends rx.e<? extends T>> oVar) {
        this.f52575a = oVar;
    }
}
