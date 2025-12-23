package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q0<T, R> implements e.a<R> {

    /* renamed from: a, reason: collision with root package name */
    final e.a<T> f53372a;

    /* renamed from: b, reason: collision with root package name */
    final e.b<? extends R, ? super T> f53373b;

    @Override // rx.functions.b
    public void call(rx.l<? super R> lVar) {
        try {
            rx.l<? super T> call = rx.plugins.c.M(this.f53373b).call(lVar);
            try {
                call.onStart();
                this.f53372a.call(call);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                call.onError(th);
            }
        } catch (Throwable th2) {
            rx.exceptions.a.e(th2);
            lVar.onError(th2);
        }
    }

    public q0(e.a<T> aVar, e.b<? extends R, ? super T> bVar) {
        this.f53372a = aVar;
        this.f53373b = bVar;
    }
}
