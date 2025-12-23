package io.reactivex.internal.subscribers;

import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements Subscriber<T>, Subscription {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final InnerQueuedSubscriberSupport<T> parent;
    final int prefetch;
    long produced;
    volatile SimpleQueue<T> queue;

    public void setDone() {
        this.done = true;
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t5) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t5);
        } else {
            this.parent.drain();
        }
    }

    public SimpleQueue<T> queue() {
        return this.queue;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j6) {
        if (this.fusionMode != 1) {
            long j7 = this.produced + j6;
            if (j7 < this.limit) {
                this.produced = j7;
            } else {
                this.produced = 0L;
                get().request(j7);
            }
        }
    }

    public void requestOne() {
        if (this.fusionMode != 1) {
            long j6 = this.produced + 1;
            if (j6 != this.limit) {
                this.produced = j6;
            } else {
                this.produced = 0L;
                get().request(j6);
            }
        }
    }

    public InnerQueuedSubscriber(InnerQueuedSubscriberSupport<T> innerQueuedSubscriberSupport, int i6) {
        this.parent = innerQueuedSubscriberSupport;
        this.prefetch = i6;
        this.limit = i6 - (i6 >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueSubscription;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = queueSubscription;
                    QueueDrainHelper.request(subscription, this.prefetch);
                    return;
                }
            }
            this.queue = QueueDrainHelper.createQueue(this.prefetch);
            QueueDrainHelper.request(subscription, this.prefetch);
        }
    }
}
