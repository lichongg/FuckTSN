package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class f2<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    private final rx.functions.a f52778a;

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        lVar.add(rx.subscriptions.f.a(this.f52778a));
        return rx.observers.h.f(lVar);
    }

    public f2(rx.functions.a aVar) {
        this.f52778a = aVar;
    }
}
