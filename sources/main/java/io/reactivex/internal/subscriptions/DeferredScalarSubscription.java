package io.reactivex.internal.subscriptions;

import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    static final int CANCELLED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2151279923272604993L;
    protected final Subscriber<? super T> actual;
    protected T value;

    public void cancel() {
        set(4);
        this.value = null;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public final int requestFusion(int i6) {
        if ((i6 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean tryCancel() {
        return getAndSet(4) != 4;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public DeferredScalarSubscription(Subscriber<? super T> subscriber) {
        this.actual = subscriber;
    }

    public final void complete(T t5) {
        int i6 = get();
        while (i6 != 8) {
            if ((i6 & (-3)) == 0) {
                if (i6 == 2) {
                    lazySet(3);
                    Subscriber<? super T> subscriber = this.actual;
                    subscriber.onNext(t5);
                    if (get() != 4) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
                this.value = t5;
                if (compareAndSet(0, 1)) {
                    return;
                }
                i6 = get();
                if (i6 == 4) {
                    this.value = null;
                    return;
                }
            } else {
                return;
            }
        }
        this.value = t5;
        lazySet(16);
        Subscriber<? super T> subscriber2 = this.actual;
        subscriber2.onNext(t5);
        if (get() != 4) {
            subscriber2.onComplete();
        }
    }

    public final boolean isCancelled() {
        if (get() == 4) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        if (get() != 16) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t5 = this.value;
        this.value = null;
        return t5;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j6) {
        T t5;
        if (SubscriptionHelper.validate(j6)) {
            do {
                int i6 = get();
                if ((i6 & (-2)) == 0) {
                    if (i6 == 1) {
                        if (compareAndSet(1, 3) && (t5 = this.value) != null) {
                            this.value = null;
                            Subscriber<? super T> subscriber = this.actual;
                            subscriber.onNext(t5);
                            if (get() != 4) {
                                subscriber.onComplete();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }
}
