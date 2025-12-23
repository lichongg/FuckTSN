package rx.internal.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b<T> implements rx.f<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.b<? super T> f54133a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.b<? super Throwable> f54134b;

    /* renamed from: c, reason: collision with root package name */
    final rx.functions.a f54135c;

    @Override // rx.f
    public void onCompleted() {
        this.f54135c.call();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f54134b.call(th);
    }

    @Override // rx.f
    public void onNext(T t5) {
        this.f54133a.call(t5);
    }

    public b(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.f54133a = bVar;
        this.f54134b = bVar2;
        this.f54135c = aVar;
    }
}
