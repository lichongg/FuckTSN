package io.reactivex.internal.operators.flowable;

import androidx.camera.view.p;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final boolean delayError;
    final int prefetch;
    final Function<? super Flowable<T>, ? extends Publisher<? extends R>> selector;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class MulticastProcessor<T> extends Flowable<T> implements Subscriber<T>, Disposable {
        static final MulticastSubscription[] EMPTY = new MulticastSubscription[0];
        static final MulticastSubscription[] TERMINATED = new MulticastSubscription[0];
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int prefetch;
        volatile SimpleQueue<T> queue;
        int sourceMode;
        final AtomicInteger wip = new AtomicInteger();

        /* renamed from: s, reason: collision with root package name */
        final AtomicReference<Subscription> f43198s = new AtomicReference<>();
        final AtomicReference<MulticastSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);

        boolean add(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.subscribers.get();
                if (multicastSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!p.a(this.subscribers, multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        void completeAll() {
            for (MulticastSubscription<T> multicastSubscription : this.subscribers.getAndSet(TERMINATED)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.actual.onComplete();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SimpleQueue<T> simpleQueue;
            SubscriptionHelper.cancel(this.f43198s);
            if (this.wip.getAndIncrement() != 0 || (simpleQueue = this.queue) == null) {
                return;
            }
            simpleQueue.clear();
        }

        void drain() {
            Throwable th;
            Throwable th2;
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            SimpleQueue<T> simpleQueue = this.queue;
            int i6 = 1;
            while (true) {
                MulticastSubscription<T>[] multicastSubscriptionArr = this.subscribers.get();
                int length = multicastSubscriptionArr.length;
                if (simpleQueue != null && length != 0) {
                    long j6 = Long.MAX_VALUE;
                    for (MulticastSubscription<T> multicastSubscription : multicastSubscriptionArr) {
                        long j7 = multicastSubscription.get();
                        if (j7 != Long.MIN_VALUE && j6 > j7) {
                            j6 = j7;
                        }
                    }
                    long j8 = 0;
                    while (j8 != j6) {
                        if (isDisposed()) {
                            simpleQueue.clear();
                            return;
                        }
                        boolean z5 = this.done;
                        if (z5 && !this.delayError && (th2 = this.error) != null) {
                            errorAll(th2);
                            return;
                        }
                        try {
                            T poll = simpleQueue.poll();
                            boolean z6 = poll == null;
                            if (z5 && z6) {
                                Throwable th3 = this.error;
                                if (th3 != null) {
                                    errorAll(th3);
                                    return;
                                } else {
                                    completeAll();
                                    return;
                                }
                            }
                            if (z6) {
                                break;
                            }
                            for (MulticastSubscription<T> multicastSubscription2 : multicastSubscriptionArr) {
                                if (multicastSubscription2.get() != Long.MIN_VALUE) {
                                    multicastSubscription2.actual.onNext(poll);
                                }
                            }
                            j8++;
                        } catch (Throwable th4) {
                            Exceptions.throwIfFatal(th4);
                            SubscriptionHelper.cancel(this.f43198s);
                            errorAll(th4);
                            return;
                        }
                    }
                    if (j8 == j6) {
                        if (isDisposed()) {
                            simpleQueue.clear();
                            return;
                        }
                        boolean z7 = this.done;
                        if (z7 && !this.delayError && (th = this.error) != null) {
                            errorAll(th);
                            return;
                        }
                        if (z7 && simpleQueue.isEmpty()) {
                            Throwable th5 = this.error;
                            if (th5 != null) {
                                errorAll(th5);
                                return;
                            } else {
                                completeAll();
                                return;
                            }
                        }
                    }
                    for (MulticastSubscription<T> multicastSubscription3 : multicastSubscriptionArr) {
                        BackpressureHelper.produced(multicastSubscription3, j8);
                    }
                }
                i6 = this.wip.addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
                if (simpleQueue == null) {
                    simpleQueue = this.queue;
                }
            }
        }

        void errorAll(Throwable th) {
            for (MulticastSubscription<T> multicastSubscription : this.subscribers.getAndSet(TERMINATED)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.actual.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(this.f43198s.get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0 || this.queue.offer(t5)) {
                drain();
            } else {
                this.f43198s.get().cancel();
                onError(new MissingBackpressureException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f43198s, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        QueueDrainHelper.request(subscription, this.prefetch);
                        return;
                    }
                }
                this.queue = QueueDrainHelper.createQueue(this.prefetch);
                QueueDrainHelper.request(subscription, this.prefetch);
            }
        }

        void remove(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.subscribers.get();
                if (multicastSubscriptionArr == TERMINATED || multicastSubscriptionArr == EMPTY) {
                    return;
                }
                int length = multicastSubscriptionArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        i6 = -1;
                        break;
                    } else if (multicastSubscriptionArr[i6] == multicastSubscription) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (i6 < 0) {
                    return;
                }
                if (length == 1) {
                    multicastSubscriptionArr2 = EMPTY;
                } else {
                    MulticastSubscription[] multicastSubscriptionArr3 = new MulticastSubscription[length - 1];
                    System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i6);
                    System.arraycopy(multicastSubscriptionArr, i6 + 1, multicastSubscriptionArr3, i6, (length - i6) - 1);
                    multicastSubscriptionArr2 = multicastSubscriptionArr3;
                }
            } while (!p.a(this.subscribers, multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        @Override // io.reactivex.Flowable
        protected void subscribeActual(Subscriber<? super T> subscriber) {
            MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(subscriber, this);
            subscriber.onSubscribe(multicastSubscription);
            if (add(multicastSubscription)) {
                if (multicastSubscription.isCancelled()) {
                    remove(multicastSubscription);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            Throwable th = this.error;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
        }

        MulticastProcessor(int i6, boolean z5) {
            this.prefetch = i6;
            this.delayError = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;
        final Subscriber<? super T> actual;
        final MulticastProcessor<T> parent;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            getAndSet(Long.MIN_VALUE);
            this.parent.remove(this);
        }

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.actual = subscriber;
            this.parent = multicastProcessor;
        }

        public boolean isCancelled() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.addCancel(this, j6);
                this.parent.drain();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class OutputCanceller<R> implements Subscriber<R>, Subscription {
        final Subscriber<? super R> actual;
        final MulticastProcessor<?> processor;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43199s;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43199s.cancel();
            this.processor.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.actual.onComplete();
            this.processor.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
            this.processor.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r5) {
            this.actual.onNext(r5);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43199s, subscription)) {
                this.f43199s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            this.f43199s.request(j6);
        }

        OutputCanceller(Subscriber<? super R> subscriber, MulticastProcessor<?> multicastProcessor) {
            this.actual = subscriber;
            this.processor = multicastProcessor;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        MulticastProcessor multicastProcessor = new MulticastProcessor(this.prefetch, this.delayError);
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.selector.apply(multicastProcessor), "selector returned a null Publisher")).subscribe(new OutputCanceller(subscriber, multicastProcessor));
            this.source.subscribe(multicastProcessor);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    public FlowablePublishMulticast(Publisher<T> publisher, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i6, boolean z5) {
        super(publisher);
        this.selector = function;
        this.prefetch = i6;
        this.delayError = z5;
    }
}
