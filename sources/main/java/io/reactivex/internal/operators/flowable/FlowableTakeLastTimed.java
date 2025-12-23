package io.reactivex.internal.operators.flowable;

import io.reactivex.Scheduler;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableTakeLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final long count;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested = new AtomicLong();

        /* renamed from: s, reason: collision with root package name */
        Subscription f43222s;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f43222s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z5, Subscriber<? super T> subscriber, boolean z6) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z6) {
                if (!z5) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z5) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            trim(this.scheduler.now(this.unit), this.queue);
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.delayError) {
                trim(this.scheduler.now(this.unit), this.queue);
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            long now = this.scheduler.now(this.unit);
            spscLinkedArrayQueue.offer(Long.valueOf(now), t5);
            trim(now, spscLinkedArrayQueue);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43222s, subscription)) {
                this.f43222s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        void trim(long j6, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue) {
            long j7 = this.time;
            long j8 = this.count;
            boolean z5 = j8 == Long.MAX_VALUE;
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() >= j6 - j7 && (z5 || (spscLinkedArrayQueue.size() >> 1) <= j8)) {
                    return;
                }
                spscLinkedArrayQueue.poll();
                spscLinkedArrayQueue.poll();
            }
        }

        TakeLastTimedSubscriber(Subscriber<? super T> subscriber, long j6, long j7, TimeUnit timeUnit, Scheduler scheduler, int i6, boolean z5) {
            this.actual = subscriber;
            this.count = j6;
            this.time = j7;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.queue = new SpscLinkedArrayQueue<>(i6);
            this.delayError = z5;
        }

        void drain() {
            boolean z5;
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.actual;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                boolean z6 = this.delayError;
                int i6 = 1;
                do {
                    if (this.done) {
                        if (!checkTerminated(spscLinkedArrayQueue.isEmpty(), subscriber, z6)) {
                            long j6 = this.requested.get();
                            long j7 = 0;
                            while (true) {
                                if (spscLinkedArrayQueue.peek() == null) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if (!checkTerminated(z5, subscriber, z6)) {
                                    if (j6 == j7) {
                                        if (j7 != 0) {
                                            BackpressureHelper.produced(this.requested, j7);
                                        }
                                    } else {
                                        spscLinkedArrayQueue.poll();
                                        subscriber.onNext(spscLinkedArrayQueue.poll());
                                        j7++;
                                    }
                                } else {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    i6 = addAndGet(-i6);
                } while (i6 != 0);
            }
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
        this.source.subscribe(new TakeLastTimedSubscriber(subscriber, this.count, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }

    public FlowableTakeLastTimed(Publisher<T> publisher, long j6, long j7, TimeUnit timeUnit, Scheduler scheduler, int i6, boolean z5) {
        super(publisher);
        this.count = j6;
        this.time = j7;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = i6;
        this.delayError = z5;
    }
}
