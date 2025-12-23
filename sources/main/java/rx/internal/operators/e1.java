package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e1<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Throwable f52734a;

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        lVar.onError(this.f52734a);
    }

    public e1(Throwable th) {
        this.f52734a = th;
    }
}
