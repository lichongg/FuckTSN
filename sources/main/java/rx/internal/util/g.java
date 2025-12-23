package rx.internal.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g<T> extends rx.l<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.f<? super T> f54153a;

    @Override // rx.f
    public void onCompleted() {
        this.f54153a.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f54153a.onError(th);
    }

    @Override // rx.f
    public void onNext(T t5) {
        this.f54153a.onNext(t5);
    }

    public g(rx.f<? super T> fVar) {
        this.f54153a = fVar;
    }
}
