package io.reactivex.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class DefaultSubscriber<T> implements Subscriber<T> {

    /* renamed from: s, reason: collision with root package name */
    private Subscription f43430s;

    protected final void cancel() {
        Subscription subscription = this.f43430s;
        this.f43430s = SubscriptionHelper.CANCELLED;
        subscription.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f43430s, subscription)) {
            this.f43430s = subscription;
            onStart();
        }
    }

    protected final void request(long j6) {
        Subscription subscription = this.f43430s;
        if (subscription != null) {
            subscription.request(j6);
        }
    }

    protected void onStart() {
        request(Long.MAX_VALUE);
    }
}
