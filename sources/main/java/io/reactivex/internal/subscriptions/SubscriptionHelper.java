package io.reactivex.internal.subscriptions;

import androidx.camera.view.p;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public enum SubscriptionHelper implements Subscription {
    CANCELLED;

    public static boolean validate(Subscription subscription, Subscription subscription2) {
        if (subscription2 == null) {
            RxJavaPlugins.onError(new NullPointerException("next is null"));
            return false;
        }
        if (subscription == null) {
            return true;
        }
        subscription2.cancel();
        reportSubscriptionSet();
        return false;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    public static boolean cancel(AtomicReference<Subscription> atomicReference) {
        Subscription andSet;
        Subscription subscription = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (subscription == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static boolean isCancelled(Subscription subscription) {
        return subscription == CANCELLED;
    }

    public static void reportMoreProduced(long j6) {
        RxJavaPlugins.onError(new IllegalStateException("More produced than requested: " + j6));
    }

    public static void reportSubscriptionSet() {
        RxJavaPlugins.onError(new IllegalStateException("Subscription already set!"));
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        ObjectHelper.requireNonNull(subscription, "d is null");
        if (p.a(atomicReference, null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        reportSubscriptionSet();
        return false;
    }

    public static void deferredRequest(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, long j6) {
        Subscription subscription = atomicReference.get();
        if (subscription != null) {
            subscription.request(j6);
            return;
        }
        if (validate(j6)) {
            BackpressureHelper.add(atomicLong, j6);
            Subscription subscription2 = atomicReference.get();
            if (subscription2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    subscription2.request(andSet);
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, Subscription subscription) {
        if (setOnce(atomicReference, subscription)) {
            long andSet = atomicLong.getAndSet(0L);
            if (andSet != 0) {
                subscription.request(andSet);
                return true;
            }
            return true;
        }
        return false;
    }

    public static boolean replace(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = atomicReference.get();
            if (subscription2 == CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                    return false;
                }
                return false;
            }
        } while (!p.a(atomicReference, subscription2, subscription));
        return true;
    }

    public static boolean set(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = atomicReference.get();
            if (subscription2 == CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                    return false;
                }
                return false;
            }
        } while (!p.a(atomicReference, subscription2, subscription));
        if (subscription2 != null) {
            subscription2.cancel();
            return true;
        }
        return true;
    }

    public static boolean validate(long j6) {
        if (j6 > 0) {
            return true;
        }
        RxJavaPlugins.onError(new IllegalArgumentException("n > 0 required but it was " + j6));
        return false;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j6) {
    }
}
