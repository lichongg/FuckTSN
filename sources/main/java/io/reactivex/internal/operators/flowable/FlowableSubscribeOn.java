package io.reactivex.internal.operators.flowable;

import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean nonScheduledRequests;
    final Scheduler scheduler;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements Subscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        final Subscriber<? super T> actual;
        final boolean nonScheduledRequests;
        Publisher<T> source;
        final Scheduler.Worker worker;

        /* renamed from: s, reason: collision with root package name */
        final AtomicReference<Subscription> f43218s = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.f43218s);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            this.actual.onNext(t5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f43218s, subscription)) {
                long andSet = this.requested.getAndSet(0L);
                if (andSet != 0) {
                    requestUpstream(andSet, subscription);
                }
            }
        }

        void requestUpstream(final long j6, final Subscription subscription) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                subscription.request(j6);
            } else {
                this.worker.schedule(new Runnable() { // from class: io.reactivex.internal.operators.flowable.FlowableSubscribeOn.SubscribeOnSubscriber.1
                    @Override // java.lang.Runnable
                    public void run() {
                        subscription.request(j6);
                    }
                });
            }
        }

        SubscribeOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, Publisher<T> publisher, boolean z5) {
            this.actual = subscriber;
            this.worker = worker;
            this.source = publisher;
            this.nonScheduledRequests = z5;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                Subscription subscription = this.f43218s.get();
                if (subscription != null) {
                    requestUpstream(j6, subscription);
                    return;
                }
                BackpressureHelper.add(this.requested, j6);
                Subscription subscription2 = this.f43218s.get();
                if (subscription2 != null) {
                    long andSet = this.requested.getAndSet(0L);
                    if (andSet != 0) {
                        requestUpstream(andSet, subscription2);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            Publisher<T> publisher = this.source;
            this.source = null;
            publisher.subscribe(this);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, createWorker, this.source, this.nonScheduledRequests);
        subscriber.onSubscribe(subscribeOnSubscriber);
        createWorker.schedule(subscribeOnSubscriber);
    }

    public FlowableSubscribeOn(Publisher<T> publisher, Scheduler scheduler, boolean z5) {
        super(publisher);
        this.scheduler = scheduler;
        this.nonScheduledRequests = z5;
    }
}
