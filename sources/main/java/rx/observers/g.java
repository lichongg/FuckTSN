package rx.observers;

import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class g<T> extends l<T> {

    /* renamed from: a, reason: collision with root package name */
    private final rx.f<T> f54414a;

    public g(l<? super T> lVar) {
        this(lVar, true);
    }

    public g(l<? super T> lVar, boolean z5) {
        super(lVar, z5);
        this.f54414a = new f(lVar);
    }

    @Override // rx.f
    public void onCompleted() {
        this.f54414a.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f54414a.onError(th);
    }

    @Override // rx.f
    public void onNext(T t5) {
        this.f54414a.onNext(t5);
    }
}
