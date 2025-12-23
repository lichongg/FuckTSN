package rx;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class k<T> implements m {

    /* renamed from: a, reason: collision with root package name */
    private final rx.internal.util.m f54316a = new rx.internal.util.m();

    public abstract void d(T t5);

    public abstract void onError(Throwable th);

    public final void b(m mVar) {
        this.f54316a.a(mVar);
    }

    @Override // rx.m
    public final boolean isUnsubscribed() {
        return this.f54316a.isUnsubscribed();
    }

    @Override // rx.m
    public final void unsubscribe() {
        this.f54316a.unsubscribe();
    }
}
