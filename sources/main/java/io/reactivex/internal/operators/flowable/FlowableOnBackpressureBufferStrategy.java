package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractFlowableWithUpstream<T, T> {
    final long bufferSize;
    final Action onOverflow;
    final BackpressureOverflowStrategy strategy;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = 3240706908776709697L;
        final Subscriber<? super T> actual;
        final long bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final Action onOverflow;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43193s;
        final BackpressureOverflowStrategy strategy;
        final AtomicLong requested = new AtomicLong();
        final Deque<T> deque = new ArrayDeque();

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.f43193s.cancel();
            if (getAndIncrement() == 0) {
                clear(this.deque);
            }
        }

        void clear(Deque<T> deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
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
            boolean z5;
            boolean z6;
            if (this.done) {
                return;
            }
            Deque<T> deque = this.deque;
            synchronized (deque) {
                try {
                    z5 = false;
                    if (deque.size() == this.bufferSize) {
                        int i6 = AnonymousClass1.$SwitchMap$io$reactivex$BackpressureOverflowStrategy[this.strategy.ordinal()];
                        z6 = true;
                        if (i6 == 1) {
                            deque.pollLast();
                            deque.offer(t5);
                        } else if (i6 == 2) {
                            deque.poll();
                            deque.offer(t5);
                        }
                        z6 = false;
                        z5 = true;
                    } else {
                        deque.offer(t5);
                        z6 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!z5) {
                if (!z6) {
                    drain();
                    return;
                } else {
                    this.f43193s.cancel();
                    onError(new MissingBackpressureException());
                    return;
                }
            }
            Action action = this.onOverflow;
            if (action != null) {
                try {
                    action.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f43193s.cancel();
                    onError(th2);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43193s, subscription)) {
                this.f43193s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        OnBackpressureBufferStrategySubscriber(Subscriber<? super T> subscriber, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy, long j6) {
            this.actual = subscriber;
            this.onOverflow = action;
            this.strategy = backpressureOverflowStrategy;
            this.bufferSize = j6;
        }

        void drain() {
            boolean isEmpty;
            T poll;
            boolean z5;
            if (getAndIncrement() == 0) {
                Deque<T> deque = this.deque;
                Subscriber<? super T> subscriber = this.actual;
                int i6 = 1;
                do {
                    long j6 = this.requested.get();
                    long j7 = 0;
                    while (j7 != j6) {
                        if (this.cancelled) {
                            clear(deque);
                            return;
                        }
                        boolean z6 = this.done;
                        synchronized (deque) {
                            poll = deque.poll();
                        }
                        if (poll == null) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z6) {
                            Throwable th = this.error;
                            if (th != null) {
                                clear(deque);
                                subscriber.onError(th);
                                return;
                            } else if (z5) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                        if (z5) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j7++;
                    }
                    if (j7 == j6) {
                        if (this.cancelled) {
                            clear(deque);
                            return;
                        }
                        boolean z7 = this.done;
                        synchronized (deque) {
                            isEmpty = deque.isEmpty();
                        }
                        if (z7) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                clear(deque);
                                subscriber.onError(th2);
                                return;
                            } else if (isEmpty) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    if (j7 != 0) {
                        BackpressureHelper.produced(this.requested, j7);
                    }
                    i6 = addAndGet(-i6);
                } while (i6 != 0);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this.requested, j6);
                drain();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$BackpressureOverflowStrategy;

        static {
            int[] iArr = new int[BackpressureOverflowStrategy.values().length];
            $SwitchMap$io$reactivex$BackpressureOverflowStrategy = iArr;
            try {
                iArr[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureOverflowStrategy[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new OnBackpressureBufferStrategySubscriber(subscriber, this.onOverflow, this.strategy, this.bufferSize));
    }

    public FlowableOnBackpressureBufferStrategy(Publisher<T> publisher, long j6, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(publisher);
        this.bufferSize = j6;
        this.onOverflow = action;
        this.strategy = backpressureOverflowStrategy;
    }
}
