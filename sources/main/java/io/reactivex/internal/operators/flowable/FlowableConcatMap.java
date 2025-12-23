package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableConcatMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int prefetch;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements Subscriber<T>, ConcatMapSupport<R>, Subscription {
        private static final long serialVersionUID = -3511336836796789179L;
        volatile boolean active;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final int limit;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final int prefetch;
        SimpleQueue<T> queue;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43160s;
        int sourceMode;
        final ConcatMapInner<R> inner = new ConcatMapInner<>(this);
        final AtomicThrowable errors = new AtomicThrowable();

        abstract void drain();

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public final void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.done = true;
            drain();
        }

        abstract void subscribeActual();

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t5) {
            if (this.sourceMode == 2 || this.queue.offer(t5)) {
                drain();
            } else {
                this.f43160s.cancel();
                onError(new IllegalStateException("Queue full?!"));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43160s, subscription)) {
                this.f43160s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        subscribeActual();
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscribeActual();
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                subscribeActual();
                subscription.request(this.prefetch);
            }
        }

        BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> function, int i6) {
            this.mapper = function;
            this.prefetch = i6;
            this.limit = i6 - (i6 >> 2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;
        final Subscriber<? super R> actual;
        final boolean veryEnd;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.f43160s.cancel();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.veryEnd) {
                this.f43160s.cancel();
                this.done = true;
            }
            this.active = false;
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerNext(R r5) {
            this.actual.onNext(r5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.inner.request(j6);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void subscribeActual() {
            this.actual.onSubscribe(this);
        }

        ConcatMapDelayed(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i6, boolean z5) {
            super(function, i6);
            this.actual = subscriber;
            this.veryEnd = z5;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void drain() {
            boolean z5;
            if (getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z6 = this.done;
                        if (z6 && !this.veryEnd && this.errors.get() != null) {
                            this.actual.onError(this.errors.terminate());
                            return;
                        }
                        try {
                            T poll = this.queue.poll();
                            if (poll == null) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z6 && z5) {
                                Throwable terminate = this.errors.terminate();
                                if (terminate != null) {
                                    this.actual.onError(terminate);
                                    return;
                                } else {
                                    this.actual.onComplete();
                                    return;
                                }
                            }
                            if (!z5) {
                                try {
                                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null Publisher");
                                    if (this.sourceMode != 1) {
                                        int i6 = this.consumed + 1;
                                        if (i6 == this.limit) {
                                            this.consumed = 0;
                                            this.f43160s.request(i6);
                                        } else {
                                            this.consumed = i6;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            Object call = ((Callable) publisher).call();
                                            if (call == null) {
                                                continue;
                                            } else if (this.inner.isUnbounded()) {
                                                this.actual.onNext(call);
                                            } else {
                                                this.active = true;
                                                ConcatMapInner<R> concatMapInner = this.inner;
                                                concatMapInner.setSubscription(new WeakScalarSubscription(call, concatMapInner));
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            this.f43160s.cancel();
                                            this.errors.addThrowable(th);
                                            this.actual.onError(this.errors.terminate());
                                            return;
                                        }
                                    } else {
                                        this.active = true;
                                        publisher.subscribe(this.inner);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.f43160s.cancel();
                                    this.errors.addThrowable(th2);
                                    this.actual.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.f43160s.cancel();
                            this.errors.addThrowable(th3);
                            this.actual.onError(this.errors.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;
        final Subscriber<? super R> actual;
        final AtomicInteger wip;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.f43160s.cancel();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z5 = this.done;
                        try {
                            T poll = this.queue.poll();
                            boolean z6 = poll == null;
                            if (z5 && z6) {
                                this.actual.onComplete();
                                return;
                            }
                            if (!z6) {
                                try {
                                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null Publisher");
                                    if (this.sourceMode != 1) {
                                        int i6 = this.consumed + 1;
                                        if (i6 == this.limit) {
                                            this.consumed = 0;
                                            this.f43160s.request(i6);
                                        } else {
                                            this.consumed = i6;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            Object call = ((Callable) publisher).call();
                                            if (call == null) {
                                                continue;
                                            } else if (!this.inner.isUnbounded()) {
                                                this.active = true;
                                                ConcatMapInner<R> concatMapInner = this.inner;
                                                concatMapInner.setSubscription(new WeakScalarSubscription(call, concatMapInner));
                                            } else if (get() == 0 && compareAndSet(0, 1)) {
                                                this.actual.onNext(call);
                                                if (!compareAndSet(1, 0)) {
                                                    this.actual.onError(this.errors.terminate());
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            this.f43160s.cancel();
                                            this.errors.addThrowable(th);
                                            this.actual.onError(this.errors.terminate());
                                            return;
                                        }
                                    } else {
                                        this.active = true;
                                        publisher.subscribe(this.inner);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.f43160s.cancel();
                                    this.errors.addThrowable(th2);
                                    this.actual.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.f43160s.cancel();
                            this.errors.addThrowable(th3);
                            this.actual.onError(this.errors.terminate());
                            return;
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.f43160s.cancel();
            if (getAndIncrement() == 0) {
                this.actual.onError(this.errors.terminate());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.inner.cancel();
            if (getAndIncrement() == 0) {
                this.actual.onError(this.errors.terminate());
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.inner.request(j6);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void subscribeActual() {
            this.actual.onSubscribe(this);
        }

        ConcatMapImmediate(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i6) {
            super(function, i6);
            this.actual = subscriber;
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerNext(R r5) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.actual.onNext(r5);
                if (!compareAndSet(1, 0)) {
                    this.actual.onError(this.errors.terminate());
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ConcatMapInner<R> extends SubscriptionArbiter implements Subscriber<R> {
        private static final long serialVersionUID = 897683679971470653L;
        final ConcatMapSupport<R> parent;
        long produced;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            long j6 = this.produced;
            if (j6 != 0) {
                this.produced = 0L;
                produced(j6);
            }
            this.parent.innerComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            long j6 = this.produced;
            if (j6 != 0) {
                this.produced = 0L;
                produced(j6);
            }
            this.parent.innerError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r5) {
            this.produced++;
            this.parent.innerNext(r5);
        }

        ConcatMapInner(ConcatMapSupport<R> concatMapSupport) {
            this.parent = concatMapSupport;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface ConcatMapSupport<T> {
        void innerComplete();

        void innerError(Throwable th);

        void innerNext(T t5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WeakScalarSubscription<T> implements Subscription {
        final Subscriber<? super T> actual;
        boolean once;
        final T value;

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (j6 <= 0 || this.once) {
                return;
            }
            this.once = true;
            Subscriber<? super T> subscriber = this.actual;
            subscriber.onNext(this.value);
            subscriber.onComplete();
        }

        WeakScalarSubscription(T t5, Subscriber<? super T> subscriber) {
            this.value = t5;
            this.actual = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$internal$util$ErrorMode;

        static {
            int[] iArr = new int[ErrorMode.values().length];
            $SwitchMap$io$reactivex$internal$util$ErrorMode = iArr;
            try {
                iArr[ErrorMode.BOUNDARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$reactivex$internal$util$ErrorMode[ErrorMode.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i6, ErrorMode errorMode) {
        int i7 = AnonymousClass1.$SwitchMap$io$reactivex$internal$util$ErrorMode[errorMode.ordinal()];
        return i7 != 1 ? i7 != 2 ? new ConcatMapImmediate(subscriber, function, i6) : new ConcatMapDelayed(subscriber, function, i6, true) : new ConcatMapDelayed(subscriber, function, i6, false);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.mapper)) {
            return;
        }
        this.source.subscribe(subscribe(subscriber, this.mapper, this.prefetch, this.errorMode));
    }

    public FlowableConcatMap(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i6, ErrorMode errorMode) {
        super(publisher);
        this.mapper = function;
        this.prefetch = i6;
        this.errorMode = errorMode;
    }
}
