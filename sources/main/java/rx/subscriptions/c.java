package rx.subscriptions;

import rx.internal.subscriptions.SequentialSubscription;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class c implements m {

    /* renamed from: a, reason: collision with root package name */
    final SequentialSubscription f54587a = new SequentialSubscription();

    public m a() {
        return this.f54587a.current();
    }

    public void b(m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.f54587a.replace(mVar);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f54587a.isUnsubscribed();
    }

    @Override // rx.m
    public void unsubscribe() {
        this.f54587a.unsubscribe();
    }
}
