package rx.internal.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c<T> extends rx.l<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.b<? super T> f54136a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.b<Throwable> f54137b;

    /* renamed from: c, reason: collision with root package name */
    final rx.functions.a f54138c;

    @Override // rx.f
    public void onCompleted() {
        this.f54138c.call();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f54137b.call(th);
    }

    @Override // rx.f
    public void onNext(T t5) {
        this.f54136a.call(t5);
    }

    public c(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        this.f54136a = bVar;
        this.f54137b = bVar2;
        this.f54138c = aVar;
    }
}
