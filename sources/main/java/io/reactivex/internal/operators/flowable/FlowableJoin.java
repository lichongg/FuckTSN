package io.reactivex.internal.operators.flowable;

import defpackage.H5BaseWebChromeClient;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
    final Publisher<? extends TRight> other;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
    final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, FlowableGroupJoin.JoinSupport {
        private static final long serialVersionUID = -6071216598687999801L;
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        final Function<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
        int leftIndex;
        final BiFunction<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final Function<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final AtomicLong requested = new AtomicLong();
        final CompositeDisposable disposables = new CompositeDisposable();
        final SpscLinkedArrayQueue<Object> queue = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
        final Map<Integer, TLeft> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerClose(boolean z5, FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                try {
                    this.queue.offer(z5 ? LEFT_CLOSE : RIGHT_CLOSE, leftRightEndSubscriber);
                } catch (Throwable th) {
                    throw th;
                }
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerValue(boolean z5, Object obj) {
            synchronized (this) {
                try {
                    this.queue.offer(z5 ? LEFT_VALUE : RIGHT_VALUE, obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            Subscriber<? super R> subscriber = this.actual;
            boolean z5 = true;
            int i6 = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    spscLinkedArrayQueue.clear();
                    cancelAll();
                    errorAll(subscriber);
                    return;
                }
                boolean z6 = this.active.get() == 0;
                Integer num = (Integer) spscLinkedArrayQueue.poll();
                boolean z7 = num == null;
                if (z6 && z7) {
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    subscriber.onComplete();
                    return;
                }
                if (z7) {
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                } else {
                    Object poll = spscLinkedArrayQueue.poll();
                    if (num == LEFT_VALUE) {
                        int i7 = this.leftIndex;
                        this.leftIndex = i7 + 1;
                        this.lefts.put(Integer.valueOf(i7), poll);
                        try {
                            Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.leftEnd.apply(poll), "The leftEnd returned a null Publisher");
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber = new FlowableGroupJoin.LeftRightEndSubscriber(this, z5, i7);
                            this.disposables.add(leftRightEndSubscriber);
                            publisher.subscribe(leftRightEndSubscriber);
                            if (this.error.get() != null) {
                                spscLinkedArrayQueue.clear();
                                cancelAll();
                                errorAll(subscriber);
                                return;
                            }
                            long j6 = this.requested.get();
                            Iterator<TRight> it = this.rights.values().iterator();
                            long j7 = 0;
                            while (it.hasNext()) {
                                try {
                                    H5BaseWebChromeClient h5BaseWebChromeClient = (Object) ObjectHelper.requireNonNull(this.resultSelector.apply(poll, it.next()), "The resultSelector returned a null value");
                                    if (j7 == j6) {
                                        ExceptionHelper.addThrowable(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        spscLinkedArrayQueue.clear();
                                        cancelAll();
                                        errorAll(subscriber);
                                        return;
                                    }
                                    subscriber.onNext(h5BaseWebChromeClient);
                                    j7++;
                                } catch (Throwable th) {
                                    fail(th, subscriber, spscLinkedArrayQueue);
                                    return;
                                }
                            }
                            if (j7 != 0) {
                                BackpressureHelper.produced(this.requested, j7);
                            }
                        } catch (Throwable th2) {
                            fail(th2, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i8 = this.rightIndex;
                        this.rightIndex = i8 + 1;
                        this.rights.put(Integer.valueOf(i8), poll);
                        try {
                            Publisher publisher2 = (Publisher) ObjectHelper.requireNonNull(this.rightEnd.apply(poll), "The rightEnd returned a null Publisher");
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber2 = new FlowableGroupJoin.LeftRightEndSubscriber(this, false, i8);
                            this.disposables.add(leftRightEndSubscriber2);
                            publisher2.subscribe(leftRightEndSubscriber2);
                            if (this.error.get() != null) {
                                spscLinkedArrayQueue.clear();
                                cancelAll();
                                errorAll(subscriber);
                                return;
                            }
                            long j8 = this.requested.get();
                            Iterator<TLeft> it2 = this.lefts.values().iterator();
                            long j9 = 0;
                            while (it2.hasNext()) {
                                try {
                                    H5BaseWebChromeClient h5BaseWebChromeClient2 = (Object) ObjectHelper.requireNonNull(this.resultSelector.apply(it2.next(), poll), "The resultSelector returned a null value");
                                    if (j9 == j8) {
                                        ExceptionHelper.addThrowable(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        spscLinkedArrayQueue.clear();
                                        cancelAll();
                                        errorAll(subscriber);
                                        return;
                                    }
                                    subscriber.onNext(h5BaseWebChromeClient2);
                                    j9++;
                                } catch (Throwable th3) {
                                    fail(th3, subscriber, spscLinkedArrayQueue);
                                    return;
                                }
                            }
                            if (j9 != 0) {
                                BackpressureHelper.produced(this.requested, j9);
                            }
                        } catch (Throwable th4) {
                            fail(th4, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber3 = (FlowableGroupJoin.LeftRightEndSubscriber) poll;
                        this.lefts.remove(Integer.valueOf(leftRightEndSubscriber3.index));
                        this.disposables.remove(leftRightEndSubscriber3);
                    } else if (num == RIGHT_CLOSE) {
                        FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber4 = (FlowableGroupJoin.LeftRightEndSubscriber) poll;
                        this.rights.remove(Integer.valueOf(leftRightEndSubscriber4.index));
                        this.disposables.remove(leftRightEndSubscriber4);
                    }
                    z5 = true;
                }
            }
            spscLinkedArrayQueue.clear();
        }

        void errorAll(Subscriber<?> subscriber) {
            Throwable terminate = ExceptionHelper.terminate(this.error);
            this.lefts.clear();
            this.rights.clear();
            subscriber.onError(terminate);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerCloseError(Throwable th) {
            if (ExceptionHelper.addThrowable(this.error, th)) {
                drain();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerComplete(FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber) {
            this.disposables.delete(leftRightSubscriber);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerError(Throwable th) {
            if (!ExceptionHelper.addThrowable(this.error, th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.active.decrementAndGet();
                drain();
            }
        }

        JoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.actual = subscriber;
            this.leftEnd = function;
            this.rightEnd = function2;
            this.resultSelector = biFunction;
        }

        void fail(Throwable th, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            Exceptions.throwIfFatal(th);
            ExceptionHelper.addThrowable(this.error, th);
            simpleQueue.clear();
            cancelAll();
            errorAll(subscriber);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this.requested, j6);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        JoinSubscription joinSubscription = new JoinSubscription(subscriber, this.leftEnd, this.rightEnd, this.resultSelector);
        subscriber.onSubscribe(joinSubscription);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, true);
        joinSubscription.disposables.add(leftRightSubscriber);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber2 = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, false);
        joinSubscription.disposables.add(leftRightSubscriber2);
        this.source.subscribe(leftRightSubscriber);
        this.other.subscribe(leftRightSubscriber2);
    }

    public FlowableJoin(Publisher<TLeft> publisher, Publisher<? extends TRight> publisher2, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(publisher);
        this.other = publisher2;
        this.leftEnd = function;
        this.rightEnd = function2;
        this.resultSelector = biFunction;
    }
}
