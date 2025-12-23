package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<Subscription> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Subscription andSet;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i6 = 0; i6 < length; i6++) {
                Subscription subscription = get(i6);
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (subscription != subscriptionHelper && (andSet = getAndSet(i6, subscriptionHelper)) != subscriptionHelper && andSet != null) {
                    andSet.cancel();
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }

    public ArrayCompositeSubscription(int i6) {
        super(i6);
    }

    public Subscription replaceResource(int i6, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = get(i6);
            if (subscription2 == SubscriptionHelper.CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                    return null;
                }
                return null;
            }
        } while (!compareAndSet(i6, subscription2, subscription));
        return subscription2;
    }

    public boolean setResource(int i6, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = get(i6);
            if (subscription2 == SubscriptionHelper.CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(i6, subscription2, subscription));
        if (subscription2 != null) {
            subscription2.cancel();
            return true;
        }
        return true;
    }
}
