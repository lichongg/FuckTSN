package rx.internal.operators;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class u<T, R> extends t<T, R> {

    /* renamed from: i, reason: collision with root package name */
    protected boolean f53565i;

    @Override // rx.internal.operators.t, rx.f
    public void onCompleted() {
        if (this.f53565i) {
            return;
        }
        this.f53565i = true;
        super.onCompleted();
    }

    @Override // rx.internal.operators.t, rx.f
    public void onError(Throwable th) {
        if (this.f53565i) {
            rx.plugins.c.I(th);
        } else {
            this.f53565i = true;
            super.onError(th);
        }
    }

    public u(rx.l<? super R> lVar) {
        super(lVar);
    }
}
