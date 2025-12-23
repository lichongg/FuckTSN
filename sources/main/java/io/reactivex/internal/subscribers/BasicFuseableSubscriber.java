package io.reactivex.internal.subscribers;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class BasicFuseableSubscriber<T, R> implements Subscriber<T>, QueueSubscription<R> {
    protected final Subscriber<? super R> actual;
    protected boolean done;
    protected QueueSubscription<T> qs;

    /* renamed from: s, reason: collision with root package name */
    protected Subscription f43401s;
    protected int sourceMode;

    protected boolean beforeDownstream() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r5) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f43401s.cancel();
    }

    public void clear() {
        this.qs.clear();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.qs.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r5, R r6) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.actual.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
        } else {
            this.done = true;
            this.actual.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f43401s, subscription)) {
            this.f43401s = subscription;
            if (subscription instanceof QueueSubscription) {
                this.qs = (QueueSubscription) subscription;
            }
            if (beforeDownstream()) {
                this.actual.onSubscribe(this);
                afterDownstream();
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j6) {
        this.f43401s.request(j6);
    }

    protected final int transitiveBoundaryFusion(int i6) {
        QueueSubscription<T> queueSubscription = this.qs;
        if (queueSubscription == null || (i6 & 4) != 0) {
            return 0;
        }
        int requestFusion = queueSubscription.requestFusion(i6);
        if (requestFusion != 0) {
            this.sourceMode = requestFusion;
        }
        return requestFusion;
    }

    public BasicFuseableSubscriber(Subscriber<? super R> subscriber) {
        this.actual = subscriber;
    }

    protected final void fail(Throwable th) {
        Exceptions.throwIfFatal(th);
        this.f43401s.cancel();
        onError(th);
    }

    protected void afterDownstream() {
    }
}
