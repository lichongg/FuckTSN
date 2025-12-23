package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableIntervalRange extends Flowable<Long> {
    final long end;
    final long initialDelay;
    final long period;
    final Scheduler scheduler;
    final long start;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class IntervalRangeSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final Subscriber<? super Long> actual;
        long count;
        final long end;
        final AtomicReference<Disposable> resource = new AtomicReference<>();

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.dispose(this.resource);
        }

        @Override // java.lang.Runnable
        public void run() {
            Disposable disposable = this.resource.get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                long j6 = get();
                if (j6 == 0) {
                    this.actual.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
                    DisposableHelper.dispose(this.resource);
                    return;
                }
                long j7 = this.count;
                this.actual.onNext(Long.valueOf(j7));
                if (j7 == this.end) {
                    if (this.resource.get() != disposableHelper) {
                        this.actual.onComplete();
                    }
                    DisposableHelper.dispose(this.resource);
                } else {
                    this.count = j7 + 1;
                    if (j6 != Long.MAX_VALUE) {
                        decrementAndGet();
                    }
                }
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this.resource, disposable);
        }

        IntervalRangeSubscriber(Subscriber<? super Long> subscriber, long j6, long j7) {
            this.actual = subscriber;
            this.count = j6;
            this.end = j7;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this, j6);
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        IntervalRangeSubscriber intervalRangeSubscriber = new IntervalRangeSubscriber(subscriber, this.start, this.end);
        subscriber.onSubscribe(intervalRangeSubscriber);
        intervalRangeSubscriber.setResource(this.scheduler.schedulePeriodicallyDirect(intervalRangeSubscriber, this.initialDelay, this.period, this.unit));
    }

    public FlowableIntervalRange(long j6, long j7, long j8, long j9, TimeUnit timeUnit, Scheduler scheduler) {
        this.initialDelay = j8;
        this.period = j9;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.start = j6;
        this.end = j7;
    }
}
