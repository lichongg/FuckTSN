package rx.internal.util;

import rx.Notification;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a<T> implements rx.f<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.b<Notification<? super T>> f54103a;

    @Override // rx.f
    public void onCompleted() {
        this.f54103a.call(Notification.b());
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f54103a.call(Notification.d(th));
    }

    @Override // rx.f
    public void onNext(T t5) {
        this.f54103a.call(Notification.e(t5));
    }

    public a(rx.functions.b<Notification<? super T>> bVar) {
        this.f54103a = bVar;
    }
}
