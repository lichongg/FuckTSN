package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.FullArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FullArbiterSubscriber<T> implements Subscriber<T> {
    final FullArbiter<T> arbiter;

    /* renamed from: s, reason: collision with root package name */
    Subscription f43404s;

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.arbiter.onComplete(this.f43404s);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.arbiter.onError(th, this.f43404s);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t5) {
        this.arbiter.onNext(t5, this.f43404s);
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f43404s, subscription)) {
            this.f43404s = subscription;
            this.arbiter.setSubscription(subscription);
        }
    }

    public FullArbiterSubscriber(FullArbiter<T> fullArbiter) {
        this.arbiter = fullArbiter;
    }
}
