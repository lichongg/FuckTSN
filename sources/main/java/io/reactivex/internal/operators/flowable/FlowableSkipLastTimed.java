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
public final class FlowableSkipLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested = new AtomicLong();

        /* renamed from: s, reason: collision with root package name */
        Subscription f43215s;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f43215s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z5, boolean z6, Subscriber<? super T> subscriber, boolean z7) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z5) {
                return false;
            }
            if (z7) {
                if (!z6) {
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
            if (!z6) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        void drain() {
            long j6;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.actual;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            boolean z5 = this.delayError;
            TimeUnit timeUnit = this.unit;
            Scheduler scheduler = this.scheduler;
            long j7 = this.time;
            int i6 = 1;
            do {
                long j8 = this.requested.get();
                long j9 = 0;
                while (true) {
                    if (j9 == j8) {
                        j6 = 0;
                        break;
                    }
                    boolean z6 = this.done;
                    Long l6 = (Long) spscLinkedArrayQueue.peek();
                    boolean z7 = l6 == null;
                    boolean z8 = (z7 || l6.longValue() <= scheduler.now(timeUnit) - j7) ? z7 : true;
                    j6 = 0;
                    if (checkTerminated(z6, z8, subscriber, z5)) {
                        return;
                    }
                    if (z8) {
                        break;
                    }
                    spscLinkedArrayQueue.poll();
                    subscriber.onNext(spscLinkedArrayQueue.poll());
                    j9++;
                }
                if (j9 != j6) {
                    BackpressureHelper.produced(this.requested, j9);
                }
                i6 = addAndGet(-i6);
            } while (i6 != 0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            this.queue.offer(Long.valueOf(this.scheduler.now(this.unit)), t5);
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43215s, subscription)) {
                this.f43215s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        SkipLastTimedSubscriber(Subscriber<? super T> subscriber, long j6, TimeUnit timeUnit, Scheduler scheduler, int i6, boolean z5) {
            this.actual = subscriber;
            this.time = j6;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.queue = new SpscLinkedArrayQueue<>(i6);
            this.delayError = z5;
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
        this.source.subscribe(new SkipLastTimedSubscriber(subscriber, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }

    public FlowableSkipLastTimed(Publisher<T> publisher, long j6, TimeUnit timeUnit, Scheduler scheduler, int i6, boolean z5) {
        super(publisher);
        this.time = j6;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = i6;
        this.delayError = z5;
    }
}
