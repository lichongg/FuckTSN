package io.reactivex.internal.operators.flowable;

import androidx.camera.view.p;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.FullArbiterSubscriber;
import io.reactivex.internal.subscriptions.FullArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableTimeout<T, U, V> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<U> firstTimeoutIndicator;
    final Function<? super T, ? extends Publisher<V>> itemTimeoutIndicator;
    final Publisher<? extends T> other;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface OnTimeout {
        void onError(Throwable th);

        void timeout(long j6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TimeoutInnerSubscriber<T, U, V> extends DisposableSubscriber<Object> {
        boolean done;
        final long index;
        final OnTimeout parent;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.timeout(this.index);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.parent.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (this.done) {
                return;
            }
            this.done = true;
            cancel();
            this.parent.timeout(this.index);
        }

        TimeoutInnerSubscriber(OnTimeout onTimeout, long j6) {
            this.parent = onTimeout;
            this.index = j6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TimeoutOtherSubscriber<T, U, V> implements Subscriber<T>, Disposable, OnTimeout {
        final Subscriber<? super T> actual;
        final FullArbiter<T> arbiter;
        volatile boolean cancelled;
        boolean done;
        final Publisher<U> firstTimeoutIndicator;
        volatile long index;
        final Function<? super T, ? extends Publisher<V>> itemTimeoutIndicator;
        final Publisher<? extends T> other;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43228s;
        final AtomicReference<Disposable> timeout = new AtomicReference<>();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.f43228s.cancel();
            DisposableHelper.dispose(this.timeout);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            dispose();
            this.arbiter.onComplete(this.f43228s);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            dispose();
            this.arbiter.onError(th, this.f43228s);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            long j6 = this.index + 1;
            this.index = j6;
            if (this.arbiter.onNext(t5, this.f43228s)) {
                Disposable disposable = this.timeout.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(t5), "The publisher returned is null");
                    TimeoutInnerSubscriber timeoutInnerSubscriber = new TimeoutInnerSubscriber(this, j6);
                    if (p.a(this.timeout, disposable, timeoutInnerSubscriber)) {
                        publisher.subscribe(timeoutInnerSubscriber);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.actual.onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43228s, subscription)) {
                this.f43228s = subscription;
                if (this.arbiter.setSubscription(subscription)) {
                    Subscriber<? super T> subscriber = this.actual;
                    Publisher<U> publisher = this.firstTimeoutIndicator;
                    if (publisher == null) {
                        subscriber.onSubscribe(this.arbiter);
                        return;
                    }
                    TimeoutInnerSubscriber timeoutInnerSubscriber = new TimeoutInnerSubscriber(this, 0L);
                    if (p.a(this.timeout, null, timeoutInnerSubscriber)) {
                        subscriber.onSubscribe(this.arbiter);
                        publisher.subscribe(timeoutInnerSubscriber);
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.OnTimeout
        public void timeout(long j6) {
            if (j6 == this.index) {
                dispose();
                this.other.subscribe(new FullArbiterSubscriber(this.arbiter));
            }
        }

        TimeoutOtherSubscriber(Subscriber<? super T> subscriber, Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
            this.actual = subscriber;
            this.firstTimeoutIndicator = publisher;
            this.itemTimeoutIndicator = function;
            this.other = publisher2;
            this.arbiter = new FullArbiter<>(subscriber, this, 8);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TimeoutSubscriber<T, U, V> implements Subscriber<T>, Subscription, OnTimeout {
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final Publisher<U> firstTimeoutIndicator;
        volatile long index;
        final Function<? super T, ? extends Publisher<V>> itemTimeoutIndicator;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43229s;
        final AtomicReference<Disposable> timeout = new AtomicReference<>();

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.f43229s.cancel();
            DisposableHelper.dispose(this.timeout);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            long j6 = this.index + 1;
            this.index = j6;
            this.actual.onNext(t5);
            Disposable disposable = this.timeout.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(t5), "The publisher returned is null");
                TimeoutInnerSubscriber timeoutInnerSubscriber = new TimeoutInnerSubscriber(this, j6);
                if (p.a(this.timeout, disposable, timeoutInnerSubscriber)) {
                    publisher.subscribe(timeoutInnerSubscriber);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.actual.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43229s, subscription)) {
                this.f43229s = subscription;
                if (this.cancelled) {
                    return;
                }
                Subscriber<? super T> subscriber = this.actual;
                Publisher<U> publisher = this.firstTimeoutIndicator;
                if (publisher == null) {
                    subscriber.onSubscribe(this);
                    return;
                }
                TimeoutInnerSubscriber timeoutInnerSubscriber = new TimeoutInnerSubscriber(this, 0L);
                if (p.a(this.timeout, null, timeoutInnerSubscriber)) {
                    subscriber.onSubscribe(this);
                    publisher.subscribe(timeoutInnerSubscriber);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43229s.request(j6);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.OnTimeout
        public void timeout(long j6) {
            if (j6 == this.index) {
                cancel();
                this.actual.onError(new TimeoutException());
            }
        }

        TimeoutSubscriber(Subscriber<? super T> subscriber, Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function) {
            this.actual = subscriber;
            this.firstTimeoutIndicator = publisher;
            this.itemTimeoutIndicator = function;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            cancel();
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            cancel();
            this.actual.onError(th);
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Publisher<? extends T> publisher = this.other;
        if (publisher == null) {
            this.source.subscribe(new TimeoutSubscriber(new SerializedSubscriber(subscriber), this.firstTimeoutIndicator, this.itemTimeoutIndicator));
        } else {
            this.source.subscribe(new TimeoutOtherSubscriber(subscriber, this.firstTimeoutIndicator, this.itemTimeoutIndicator, publisher));
        }
    }

    public FlowableTimeout(Publisher<T> publisher, Publisher<U> publisher2, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher3) {
        super(publisher);
        this.firstTimeoutIndicator = publisher2;
        this.itemTimeoutIndicator = function;
        this.other = publisher3;
    }
}
