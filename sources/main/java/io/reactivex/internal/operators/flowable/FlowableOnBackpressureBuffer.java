package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableOnBackpressureBuffer<T> extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Action onOverflow;
    final boolean unbounded;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements Subscriber<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final Action onOverflow;
        boolean outputFused;
        final SimplePlainQueue<T> queue;
        final AtomicLong requested = new AtomicLong();

        /* renamed from: s, reason: collision with root package name */
        Subscription f43192s;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.actual.onComplete();
            } else {
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            if ((i6 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f43192s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z5, boolean z6, Subscriber<? super T> subscriber) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z5) {
                return false;
            }
            if (this.delayError) {
                if (!z6) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z6) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (this.outputFused) {
                this.actual.onError(th);
            } else {
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.queue.offer(t5)) {
                if (this.outputFused) {
                    this.actual.onNext(null);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            this.f43192s.cancel();
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
            try {
                this.onOverflow.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                missingBackpressureException.initCause(th);
            }
            onError(missingBackpressureException);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43192s, subscription)) {
                this.f43192s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (this.outputFused || !SubscriptionHelper.validate(j6)) {
                return;
            }
            BackpressureHelper.add(this.requested, j6);
            drain();
        }

        BackpressureBufferSubscriber(Subscriber<? super T> subscriber, int i6, boolean z5, boolean z6, Action action) {
            SimplePlainQueue<T> spscArrayQueue;
            this.actual = subscriber;
            this.onOverflow = action;
            this.delayError = z6;
            if (z5) {
                spscArrayQueue = new SpscLinkedArrayQueue<>(i6);
            } else {
                spscArrayQueue = new SpscArrayQueue<>(i6);
            }
            this.queue = spscArrayQueue;
        }

        void drain() {
            boolean z5;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                Subscriber<? super T> subscriber = this.actual;
                int i6 = 1;
                while (!checkTerminated(this.done, simplePlainQueue.isEmpty(), subscriber)) {
                    long j6 = this.requested.get();
                    long j7 = 0;
                    while (j7 != j6) {
                        boolean z6 = this.done;
                        T poll = simplePlainQueue.poll();
                        if (poll == null) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (!checkTerminated(z6, z5, subscriber)) {
                            if (z5) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j7++;
                        } else {
                            return;
                        }
                    }
                    if (j7 != j6 || !checkTerminated(this.done, simplePlainQueue.isEmpty(), subscriber)) {
                        if (j7 != 0 && j6 != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j7);
                        }
                        i6 = addAndGet(-i6);
                        if (i6 == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new BackpressureBufferSubscriber(subscriber, this.bufferSize, this.unbounded, this.delayError, this.onOverflow));
    }

    public FlowableOnBackpressureBuffer(Publisher<T> publisher, int i6, boolean z5, boolean z6, Action action) {
        super(publisher);
        this.bufferSize = i6;
        this.unbounded = z5;
        this.delayError = z6;
        this.onOverflow = action;
    }
}
