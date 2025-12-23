package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableTakeLast<T> extends AbstractFlowableWithUpstream<T, T> {
    final int count;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TakeLastSubscriber<T> extends ArrayDeque<T> implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = 7240042530241604978L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final int count;
        volatile boolean done;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43220s;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger wip = new AtomicInteger();

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.f43220s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.actual;
                long j6 = this.requested.get();
                while (!this.cancelled) {
                    if (this.done) {
                        long j7 = 0;
                        while (j7 != j6) {
                            if (this.cancelled) {
                                return;
                            }
                            T poll = poll();
                            if (poll == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onNext(poll);
                                j7++;
                            }
                        }
                        if (j7 != 0 && j6 != Long.MAX_VALUE) {
                            j6 = this.requested.addAndGet(-j7);
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.count == size()) {
                poll();
            }
            offer(t5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43220s, subscription)) {
                this.f43220s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        TakeLastSubscriber(Subscriber<? super T> subscriber, int i6) {
            this.actual = subscriber;
            this.count = i6;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this.requested, j6);
                drain();
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new TakeLastSubscriber(subscriber, this.count));
    }

    public FlowableTakeLast(Publisher<T> publisher, int i6) {
        super(publisher);
        this.count = i6;
    }
}
