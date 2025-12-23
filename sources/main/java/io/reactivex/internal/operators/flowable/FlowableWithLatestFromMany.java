package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableWithLatestFromMany<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super Object[], R> combiner;
    final Publisher<?>[] otherArray;
    final Iterable<? extends Publisher<?>> otherIterable;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = 1577321883966341961L;
        final Subscriber<? super R> actual;
        final Function<? super Object[], R> combiner;
        volatile boolean done;
        final AtomicThrowable error;
        final AtomicLong requested;

        /* renamed from: s, reason: collision with root package name */
        final AtomicReference<Subscription> f43249s;
        final WithLatestInnerSubscriber[] subscribers;
        final AtomicReferenceArray<Object> values;

        void innerError(int i6, Throwable th) {
            this.done = true;
            SubscriptionHelper.cancel(this.f43249s);
            cancelAllBut(i6);
            HalfSerializer.onError(this.actual, th, this, this.error);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.f43249s);
            for (WithLatestInnerSubscriber withLatestInnerSubscriber : this.subscribers) {
                withLatestInnerSubscriber.dispose();
            }
        }

        void cancelAllBut(int i6) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.subscribers;
            for (int i7 = 0; i7 < withLatestInnerSubscriberArr.length; i7++) {
                if (i7 != i6) {
                    withLatestInnerSubscriberArr[i7].dispose();
                }
            }
        }

        void innerComplete(int i6, boolean z5) {
            if (z5) {
                return;
            }
            this.done = true;
            cancelAllBut(i6);
            HalfSerializer.onComplete(this.actual, this, this.error);
        }

        void innerNext(int i6, Object obj) {
            this.values.set(i6, obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            HalfSerializer.onComplete(this.actual, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            HalfSerializer.onError(this.actual, th, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i6 = 0;
            objArr[0] = t5;
            while (i6 < length) {
                Object obj = atomicReferenceArray.get(i6);
                if (obj == null) {
                    this.f43249s.get().request(1L);
                    return;
                } else {
                    i6++;
                    objArr[i6] = obj;
                }
            }
            try {
                HalfSerializer.onNext(this.actual, ObjectHelper.requireNonNull(this.combiner.apply(objArr), "combiner returned a null value"), this, this.error);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f43249s, this.requested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            SubscriptionHelper.deferredRequest(this.f43249s, this.requested, j6);
        }

        void subscribe(Publisher<?>[] publisherArr, int i6) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.subscribers;
            AtomicReference<Subscription> atomicReference = this.f43249s;
            for (int i7 = 0; i7 < i6 && !SubscriptionHelper.isCancelled(atomicReference.get()) && !this.done; i7++) {
                publisherArr[i7].subscribe(withLatestInnerSubscriberArr[i7]);
            }
        }

        WithLatestFromSubscriber(Subscriber<? super R> subscriber, Function<? super Object[], R> function, int i6) {
            this.actual = subscriber;
            this.combiner = function;
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = new WithLatestInnerSubscriber[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                withLatestInnerSubscriberArr[i7] = new WithLatestInnerSubscriber(this, i7);
            }
            this.subscribers = withLatestInnerSubscriberArr;
            this.values = new AtomicReferenceArray<>(i6);
            this.f43249s = new AtomicReference<>();
            this.requested = new AtomicLong();
            this.error = new AtomicThrowable();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class WithLatestInnerSubscriber extends AtomicReference<Subscription> implements Subscriber<Object>, Disposable {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final WithLatestFromSubscriber<?, ?> parent;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        WithLatestInnerSubscriber(WithLatestFromSubscriber<?, ?> withLatestFromSubscriber, int i6) {
            this.parent = withLatestFromSubscriber;
            this.index = i6;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableWithLatestFromMany(Publisher<T> publisher, Publisher<?>[] publisherArr, Function<? super Object[], R> function) {
        super(publisher);
        this.otherArray = publisherArr;
        this.otherIterable = null;
        this.combiner = function;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Publisher<?>[] publisherArr = this.otherArray;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                length = 0;
                for (Publisher<?> publisher : this.otherIterable) {
                    if (length == publisherArr.length) {
                        publisherArr = (Publisher[]) Arrays.copyOf(publisherArr, (length >> 1) + length);
                    }
                    int i6 = length + 1;
                    publisherArr[length] = publisher;
                    length = i6;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        if (length == 0) {
            new FlowableMap(this.source, new Function<T, R>() { // from class: io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany.1
                /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
                @Override // io.reactivex.functions.Function
                public R apply(T t5) throws Exception {
                    return FlowableWithLatestFromMany.this.combiner.apply(new Object[]{t5});
                }
            }).subscribeActual(subscriber);
            return;
        }
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(subscriber, this.combiner, length);
        subscriber.onSubscribe(withLatestFromSubscriber);
        withLatestFromSubscriber.subscribe(publisherArr, length);
        this.source.subscribe(withLatestFromSubscriber);
    }

    public FlowableWithLatestFromMany(Publisher<T> publisher, Iterable<? extends Publisher<?>> iterable, Function<? super Object[], R> function) {
        super(publisher);
        this.otherArray = null;
        this.otherIterable = iterable;
        this.combiner = function;
    }
}
