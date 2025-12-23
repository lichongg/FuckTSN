package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableTimer extends Flowable<Long> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class IntervalOnceSubscriber extends AtomicReference<Disposable> implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final Subscriber<? super Long> actual;
        volatile boolean requested;

        IntervalOnceSubscriber(Subscriber<? super Long> subscriber) {
            this.actual = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                this.requested = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                if (this.requested) {
                    this.actual.onNext(0L);
                    this.actual.onComplete();
                } else {
                    this.actual.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
                }
                lazySet(EmptyDisposable.INSTANCE);
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        IntervalOnceSubscriber intervalOnceSubscriber = new IntervalOnceSubscriber(subscriber);
        subscriber.onSubscribe(intervalOnceSubscriber);
        intervalOnceSubscriber.setResource(this.scheduler.scheduleDirect(intervalOnceSubscriber, this.delay, this.unit));
    }

    public FlowableTimer(long j6, TimeUnit timeUnit, Scheduler scheduler) {
        this.delay = j6;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }
}
