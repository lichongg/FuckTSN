package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FullArbiter<T> extends FullArbiterPad2 implements Subscription {
    static final Subscription INITIAL = new Subscription() { // from class: io.reactivex.internal.subscriptions.FullArbiter.1
        @Override // org.reactivestreams.Subscription
        public void cancel() {
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
        }
    };
    static final Object REQUEST = new Object();
    final Subscriber<? super T> actual;
    volatile boolean cancelled;
    final SpscLinkedArrayQueue<Object> queue;
    long requested;
    Disposable resource;

    /* renamed from: s, reason: collision with root package name */
    volatile Subscription f43415s = INITIAL;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        dispose();
    }

    void dispose() {
        Disposable disposable = this.resource;
        this.resource = null;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
        Subscriber<? super T> subscriber = this.actual;
        int i6 = 1;
        while (true) {
            Object poll = spscLinkedArrayQueue.poll();
            if (poll == null) {
                i6 = this.wip.addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
            } else {
                Object poll2 = spscLinkedArrayQueue.poll();
                if (poll == REQUEST) {
                    long andSet = this.missedRequested.getAndSet(0L);
                    if (andSet != 0) {
                        this.requested = BackpressureHelper.addCap(this.requested, andSet);
                        this.f43415s.request(andSet);
                    }
                } else if (poll == this.f43415s) {
                    if (NotificationLite.isSubscription(poll2)) {
                        Subscription subscription = NotificationLite.getSubscription(poll2);
                        if (this.cancelled) {
                            subscription.cancel();
                        } else {
                            this.f43415s = subscription;
                            long j6 = this.requested;
                            if (j6 != 0) {
                                subscription.request(j6);
                            }
                        }
                    } else if (NotificationLite.isError(poll2)) {
                        spscLinkedArrayQueue.clear();
                        dispose();
                        Throwable error = NotificationLite.getError(poll2);
                        if (this.cancelled) {
                            RxJavaPlugins.onError(error);
                        } else {
                            this.cancelled = true;
                            subscriber.onError(error);
                        }
                    } else if (NotificationLite.isComplete(poll2)) {
                        spscLinkedArrayQueue.clear();
                        dispose();
                        if (!this.cancelled) {
                            this.cancelled = true;
                            subscriber.onComplete();
                        }
                    } else {
                        long j7 = this.requested;
                        if (j7 != 0) {
                            subscriber.onNext((Object) NotificationLite.getValue(poll2));
                            this.requested = j7 - 1;
                        }
                    }
                }
            }
        }
    }

    public void onComplete(Subscription subscription) {
        this.queue.offer(subscription, NotificationLite.complete());
        drain();
    }

    public void onError(Throwable th, Subscription subscription) {
        if (this.cancelled) {
            RxJavaPlugins.onError(th);
        } else {
            this.queue.offer(subscription, NotificationLite.error(th));
            drain();
        }
    }

    public boolean onNext(T t5, Subscription subscription) {
        if (this.cancelled) {
            return false;
        }
        this.queue.offer(subscription, NotificationLite.next(t5));
        drain();
        return true;
    }

    public boolean setSubscription(Subscription subscription) {
        if (this.cancelled) {
            if (subscription == null) {
                return false;
            }
            subscription.cancel();
            return false;
        }
        ObjectHelper.requireNonNull(subscription, "s is null");
        this.queue.offer(this.f43415s, NotificationLite.subscription(subscription));
        drain();
        return true;
    }

    public FullArbiter(Subscriber<? super T> subscriber, Disposable disposable, int i6) {
        this.actual = subscriber;
        this.resource = disposable;
        this.queue = new SpscLinkedArrayQueue<>(i6);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j6) {
        if (SubscriptionHelper.validate(j6)) {
            BackpressureHelper.add(this.missedRequested, j6);
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            Object obj = REQUEST;
            spscLinkedArrayQueue.offer(obj, obj);
            drain();
        }
    }
}
