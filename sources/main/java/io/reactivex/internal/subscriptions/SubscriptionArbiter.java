package io.reactivex.internal.subscriptions;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;
    Subscription actual;
    volatile boolean cancelled;
    long requested;
    protected boolean unbounded;
    final AtomicReference<Subscription> missedSubscription = new AtomicReference<>();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicLong missedProduced = new AtomicLong();

    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        drain();
    }

    final void drainLoop() {
        int i6 = 1;
        long j6 = 0;
        Subscription subscription = null;
        do {
            Subscription subscription2 = this.missedSubscription.get();
            if (subscription2 != null) {
                subscription2 = this.missedSubscription.getAndSet(null);
            }
            long j7 = this.missedRequested.get();
            if (j7 != 0) {
                j7 = this.missedRequested.getAndSet(0L);
            }
            long j8 = this.missedProduced.get();
            if (j8 != 0) {
                j8 = this.missedProduced.getAndSet(0L);
            }
            Subscription subscription3 = this.actual;
            if (this.cancelled) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    this.actual = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long j9 = this.requested;
                if (j9 != Long.MAX_VALUE) {
                    j9 = BackpressureHelper.addCap(j9, j7);
                    if (j9 != Long.MAX_VALUE) {
                        j9 -= j8;
                        if (j9 < 0) {
                            SubscriptionHelper.reportMoreProduced(j9);
                            j9 = 0;
                        }
                    }
                    this.requested = j9;
                }
                if (subscription2 != null) {
                    if (subscription3 != null) {
                        subscription3.cancel();
                    }
                    this.actual = subscription2;
                    if (j9 != 0) {
                        j6 = BackpressureHelper.addCap(j6, j9);
                        subscription = subscription2;
                    }
                } else if (subscription3 != null && j7 != 0) {
                    j6 = BackpressureHelper.addCap(j6, j7);
                    subscription = subscription3;
                }
            }
            i6 = addAndGet(-i6);
        } while (i6 != 0);
        if (j6 != 0) {
            subscription.request(j6);
        }
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long j6) {
        if (this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            BackpressureHelper.add(this.missedProduced, j6);
            drain();
            return;
        }
        long j7 = this.requested;
        if (j7 != Long.MAX_VALUE) {
            long j8 = j7 - j6;
            if (j8 < 0) {
                SubscriptionHelper.reportMoreProduced(j8);
                j8 = 0;
            }
            this.requested = j8;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        drainLoop();
    }

    public final void setSubscription(Subscription subscription) {
        if (this.cancelled) {
            subscription.cancel();
            return;
        }
        ObjectHelper.requireNonNull(subscription, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            Subscription andSet = this.missedSubscription.getAndSet(subscription);
            if (andSet != null) {
                andSet.cancel();
            }
            drain();
            return;
        }
        Subscription subscription2 = this.actual;
        if (subscription2 != null) {
            subscription2.cancel();
        }
        this.actual = subscription;
        long j6 = this.requested;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (j6 != 0) {
            subscription.request(j6);
        }
    }

    final void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j6) {
        if (SubscriptionHelper.validate(j6) && !this.unbounded) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j7 = this.requested;
                if (j7 != Long.MAX_VALUE) {
                    long addCap = BackpressureHelper.addCap(j7, j6);
                    this.requested = addCap;
                    if (addCap == Long.MAX_VALUE) {
                        this.unbounded = true;
                    }
                }
                Subscription subscription = this.actual;
                if (decrementAndGet() != 0) {
                    drainLoop();
                }
                if (subscription != null) {
                    subscription.request(j6);
                    return;
                }
                return;
            }
            BackpressureHelper.add(this.missedRequested, j6);
            drain();
        }
    }
}
