package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements Subscriber<T> {
    volatile boolean cancelled;
    Throwable error;

    /* renamed from: s, reason: collision with root package name */
    Subscription f43402s;
    T value;

    public BlockingBaseSubscriber() {
        super(1);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f43402s, subscription)) {
            this.f43402s = subscription;
            if (this.cancelled) {
                return;
            }
            subscription.request(Long.MAX_VALUE);
            if (this.cancelled) {
                this.f43402s = SubscriptionHelper.CANCELLED;
                subscription.cancel();
            }
        }
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e6) {
                Subscription subscription = this.f43402s;
                this.f43402s = SubscriptionHelper.CANCELLED;
                if (subscription != null) {
                    subscription.cancel();
                }
                throw ExceptionHelper.wrapOrThrow(e6);
            }
        }
        Throwable th = this.error;
        if (th == null) {
            return this.value;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        countDown();
    }
}
