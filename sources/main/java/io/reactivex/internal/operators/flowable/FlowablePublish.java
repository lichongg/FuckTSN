package io.reactivex.internal.operators.flowable;

import androidx.camera.view.p;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
    static final long CANCELLED = Long.MIN_VALUE;
    final int bufferSize;
    final AtomicReference<PublishSubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Publisher<T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class PublishSubscriber<T> extends AtomicInteger implements Subscriber<T>, Disposable {
        static final InnerSubscriber[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber[] TERMINATED = new InnerSubscriber[0];
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<PublishSubscriber<T>> current;
        volatile SimpleQueue<T> queue;
        int sourceMode;
        volatile Object terminalEvent;

        /* renamed from: s, reason: collision with root package name */
        final AtomicReference<Subscription> f43197s = new AtomicReference<>();
        final AtomicReference<InnerSubscriber[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        boolean checkTerminated(Object obj, boolean z5) {
            int i6 = 0;
            if (obj != null) {
                if (!NotificationLite.isComplete(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    p.a(this.current, this, null);
                    InnerSubscriber[] andSet = this.subscribers.getAndSet(TERMINATED);
                    if (andSet.length != 0) {
                        int length = andSet.length;
                        while (i6 < length) {
                            andSet[i6].child.onError(error);
                            i6++;
                        }
                    } else {
                        RxJavaPlugins.onError(error);
                    }
                    return true;
                }
                if (z5) {
                    p.a(this.current, this, null);
                    InnerSubscriber[] andSet2 = this.subscribers.getAndSet(TERMINATED);
                    int length2 = andSet2.length;
                    while (i6 < length2) {
                        andSet2[i6].child.onComplete();
                        i6++;
                    }
                    return true;
                }
            }
            return false;
        }

        boolean add(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!p.a(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        void dispatch() {
            T t5;
            long j6;
            T t6;
            if (getAndIncrement() != 0) {
                return;
            }
            int i6 = 1;
            while (true) {
                Object obj = this.terminalEvent;
                SimpleQueue<T> simpleQueue = this.queue;
                boolean z5 = simpleQueue == null || simpleQueue.isEmpty();
                if (checkTerminated(obj, z5)) {
                    return;
                }
                if (!z5) {
                    InnerSubscriber[] innerSubscriberArr = this.subscribers.get();
                    int length = innerSubscriberArr.length;
                    int length2 = innerSubscriberArr.length;
                    long j7 = Long.MAX_VALUE;
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < length2) {
                        boolean z6 = z5;
                        long j8 = innerSubscriberArr[i7].get();
                        if (j8 >= 0) {
                            j7 = Math.min(j7, j8);
                        } else if (j8 == Long.MIN_VALUE) {
                            i8++;
                        }
                        i7++;
                        z5 = z6;
                    }
                    boolean z7 = z5;
                    if (length == i8) {
                        Object obj2 = this.terminalEvent;
                        try {
                            t5 = simpleQueue.poll();
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.f43197s.get().cancel();
                            obj2 = NotificationLite.error(th);
                            this.terminalEvent = obj2;
                            t5 = null;
                        }
                        if (checkTerminated(obj2, t5 == null)) {
                            return;
                        }
                        if (this.sourceMode != 1) {
                            this.f43197s.get().request(1L);
                        }
                    } else {
                        long j9 = j7;
                        int i9 = 0;
                        while (true) {
                            j6 = i9;
                            if (j6 >= j9) {
                                break;
                            }
                            Object obj3 = this.terminalEvent;
                            try {
                                t6 = simpleQueue.poll();
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f43197s.get().cancel();
                                obj3 = NotificationLite.error(th2);
                                this.terminalEvent = obj3;
                                t6 = null;
                            }
                            boolean z8 = t6 == null;
                            if (checkTerminated(obj3, z8)) {
                                return;
                            }
                            if (z8) {
                                z7 = z8;
                                break;
                            }
                            Object value = NotificationLite.getValue(t6);
                            for (InnerSubscriber innerSubscriber : innerSubscriberArr) {
                                if (innerSubscriber.get() > 0) {
                                    innerSubscriber.child.onNext(value);
                                    innerSubscriber.produced(1L);
                                }
                            }
                            i9++;
                            z7 = z8;
                        }
                        if (i9 > 0 && this.sourceMode != 1) {
                            this.f43197s.get().request(j6);
                        }
                        if (j9 != 0 && !z7) {
                        }
                    }
                }
                i6 = addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            InnerSubscriber[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber[] innerSubscriberArr2 = TERMINATED;
            if (innerSubscriberArr == innerSubscriberArr2 || this.subscribers.getAndSet(innerSubscriberArr2) == innerSubscriberArr2) {
                return;
            }
            p.a(this.current, this, null);
            SubscriptionHelper.cancel(this.f43197s);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.complete();
                dispatch();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.terminalEvent != null) {
                RxJavaPlugins.onError(th);
            } else {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.sourceMode != 0 || this.queue.offer(t5)) {
                dispatch();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f43197s, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.terminalEvent = NotificationLite.complete();
                        dispatch();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                subscription.request(this.bufferSize);
            }
        }

        void remove(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        i6 = -1;
                        break;
                    } else if (innerSubscriberArr[i6].equals(innerSubscriber)) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (i6 < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = EMPTY;
                } else {
                    InnerSubscriber[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i6);
                    System.arraycopy(innerSubscriberArr, i6 + 1, innerSubscriberArr3, i6, (length - i6) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!p.a(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
        }

        PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference, int i6) {
            this.current = atomicReference;
            this.bufferSize = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class InnerSubscriber<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        volatile PublishSubscriber<T> parent;

        InnerSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            PublishSubscriber<T> publishSubscriber;
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE && (publishSubscriber = this.parent) != null) {
                publishSubscriber.remove(this);
                publishSubscriber.dispatch();
            }
        }

        public long produced(long j6) {
            return BackpressureHelper.producedCancel(this, j6);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.addCancel(this, j6);
                PublishSubscriber<T> publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.dispatch();
                }
            }
        }
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, final int i6) {
        final AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowablePublish(new Publisher<T>() { // from class: io.reactivex.internal.operators.flowable.FlowablePublish.1
            @Override // org.reactivestreams.Publisher
            public void subscribe(Subscriber<? super T> subscriber) {
                PublishSubscriber<T> publishSubscriber;
                InnerSubscriber<T> innerSubscriber = new InnerSubscriber<>(subscriber);
                subscriber.onSubscribe(innerSubscriber);
                while (true) {
                    publishSubscriber = (PublishSubscriber) atomicReference.get();
                    if (publishSubscriber == null || publishSubscriber.isDisposed()) {
                        PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(atomicReference, i6);
                        if (p.a(atomicReference, publishSubscriber, publishSubscriber2)) {
                            publishSubscriber = publishSubscriber2;
                        } else {
                            continue;
                        }
                    }
                    if (publishSubscriber.add(innerSubscriber)) {
                        break;
                    }
                }
                if (innerSubscriber.get() == Long.MIN_VALUE) {
                    publishSubscriber.remove(innerSubscriber);
                } else {
                    innerSubscriber.parent = publishSubscriber;
                }
                publishSubscriber.dispatch();
            }
        }, flowable, atomicReference, i6));
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> consumer) {
        PublishSubscriber<T> publishSubscriber;
        while (true) {
            publishSubscriber = this.current.get();
            if (publishSubscriber != null && !publishSubscriber.isDisposed()) {
                break;
            }
            PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.current, this.bufferSize);
            if (p.a(this.current, publishSubscriber, publishSubscriber2)) {
                publishSubscriber = publishSubscriber2;
                break;
            }
        }
        boolean z5 = false;
        if (!publishSubscriber.shouldConnect.get() && publishSubscriber.shouldConnect.compareAndSet(false, true)) {
            z5 = true;
        }
        try {
            consumer.accept(publishSubscriber);
            if (z5) {
                this.source.subscribe(publishSubscriber);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.source;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.onSubscribe.subscribe(subscriber);
    }

    private FlowablePublish(Publisher<T> publisher, Publisher<T> publisher2, AtomicReference<PublishSubscriber<T>> atomicReference, int i6) {
        this.onSubscribe = publisher;
        this.source = publisher2;
        this.current = atomicReference;
        this.bufferSize = i6;
    }
}
