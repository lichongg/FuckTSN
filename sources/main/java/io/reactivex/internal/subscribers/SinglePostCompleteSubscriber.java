package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements Subscriber<T>, Subscription {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final Subscriber<? super R> actual;
    protected long produced;

    /* renamed from: s, reason: collision with root package name */
    protected Subscription f43414s;
    protected R value;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f43414s.cancel();
    }

    protected final void complete(R r5) {
        long j6 = this.produced;
        if (j6 != 0) {
            BackpressureHelper.produced(this, j6);
        }
        while (true) {
            long j7 = get();
            if ((j7 & Long.MIN_VALUE) != 0) {
                onDrop(r5);
                return;
            }
            if ((j7 & Long.MAX_VALUE) != 0) {
                lazySet(-9223372036854775807L);
                this.actual.onNext(r5);
                this.actual.onComplete();
                return;
            } else {
                this.value = r5;
                if (compareAndSet(0L, Long.MIN_VALUE)) {
                    return;
                } else {
                    this.value = null;
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f43414s, subscription)) {
            this.f43414s = subscription;
            this.actual.onSubscribe(this);
        }
    }

    public SinglePostCompleteSubscriber(Subscriber<? super R> subscriber) {
        this.actual = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j6) {
        long j7;
        if (SubscriptionHelper.validate(j6)) {
            do {
                j7 = get();
                if ((j7 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        this.actual.onNext(this.value);
                        this.actual.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j7, BackpressureHelper.addCap(j7, j6)));
            this.f43414s.request(j6);
        }
    }

    protected void onDrop(R r5) {
    }
}
