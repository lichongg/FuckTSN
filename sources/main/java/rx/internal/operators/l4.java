package rx.internal.operators;

import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l4<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.t<T> f53162a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.a f53163b;

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        kVar.b(rx.subscriptions.f.a(this.f53163b));
        this.f53162a.call(kVar);
    }

    public l4(i.t<T> tVar, rx.functions.a aVar) {
        this.f53162a = tVar;
        this.f53163b = aVar;
    }
}
