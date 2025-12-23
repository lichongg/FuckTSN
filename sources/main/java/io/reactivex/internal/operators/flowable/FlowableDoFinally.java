package io.reactivex.internal.operators.flowable;

import io.reactivex.annotations.Experimental;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Experimental
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableDoFinally<T> extends AbstractFlowableWithUpstream<T, T> {
    final Action onFinally;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements ConditionalSubscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final ConditionalSubscriber<? super T> actual;
        final Action onFinally;
        QueueSubscription<T> qs;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43170s;
        boolean syncFused;

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43170s.cancel();
            runFinally();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.qs.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            this.actual.onNext(t5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43170s, subscription)) {
                this.f43170s = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.qs = (QueueSubscription) subscription;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T poll = this.qs.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43170s.request(j6);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null || (i6 & 4) != 0) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i6);
            if (requestFusion != 0) {
                this.syncFused = requestFusion == 1;
            }
            return requestFusion;
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t5) {
            return this.actual.tryOnNext(t5);
        }

        DoFinallyConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Action action) {
            this.actual = conditionalSubscriber;
            this.onFinally = action;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final Subscriber<? super T> actual;
        final Action onFinally;
        QueueSubscription<T> qs;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43171s;
        boolean syncFused;

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43171s.cancel();
            runFinally();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.qs.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            this.actual.onNext(t5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43171s, subscription)) {
                this.f43171s = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.qs = (QueueSubscription) subscription;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T poll = this.qs.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43171s.request(j6);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            QueueSubscription<T> queueSubscription = this.qs;
            if (queueSubscription == null || (i6 & 4) != 0) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i6);
            if (requestFusion != 0) {
                this.syncFused = requestFusion == 1;
            }
            return requestFusion;
        }

        DoFinallySubscriber(Subscriber<? super T> subscriber, Action action) {
            this.actual = subscriber;
            this.onFinally = action;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new DoFinallyConditionalSubscriber((ConditionalSubscriber) subscriber, this.onFinally));
        } else {
            this.source.subscribe(new DoFinallySubscriber(subscriber, this.onFinally));
        }
    }

    public FlowableDoFinally(Publisher<T> publisher, Action action) {
        super(publisher);
        this.onFinally = action;
    }
}
