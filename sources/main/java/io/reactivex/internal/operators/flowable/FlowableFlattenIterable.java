package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableFlattenIterable<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements Subscriber<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        int consumed;
        Iterator<? extends R> current;
        volatile boolean done;
        int fusionMode;
        final int limit;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        final int prefetch;
        SimpleQueue<T> queue;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43181s;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.current = null;
            this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            return ((i6 & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f43181s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z5, boolean z6, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            if (this.cancelled) {
                this.current = null;
                simpleQueue.clear();
                return true;
            }
            if (!z5) {
                return false;
            }
            if (this.error.get() == null) {
                if (!z6) {
                    return false;
                }
                subscriber.onComplete();
                return true;
            }
            Throwable terminate = ExceptionHelper.terminate(this.error);
            this.current = null;
            simpleQueue.clear();
            subscriber.onError(terminate);
            return true;
        }

        void consumedOne(boolean z5) {
            if (z5) {
                int i6 = this.consumed + 1;
                if (i6 != this.limit) {
                    this.consumed = i6;
                } else {
                    this.consumed = 0;
                    this.f43181s.request(i6);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00f1, code lost:
        
            if (r13 != r9) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00f3, code lost:
        
            r8 = r17.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00f9, code lost:
        
            if (r3.isEmpty() == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00fb, code lost:
        
            if (r6 != null) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00fd, code lost:
        
            r15 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0104, code lost:
        
            if (checkTerminated(r8, r15, r2, r3) == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00ff, code lost:
        
            r15 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0109, code lost:
        
            if (r13 == 0) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0112, code lost:
        
            if (r9 == Long.MAX_VALUE) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0114, code lost:
        
            r17.requested.addAndGet(-r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x011a, code lost:
        
            if (r6 != null) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x001a, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                Method dump skipped, instructions count: 294
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlattenIterable.FlattenIterableSubscriber.drain():void");
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            Iterator<? extends R> it = this.current;
            return !(it == null || it.hasNext()) || this.queue.isEmpty();
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
            if (this.done || !ExceptionHelper.addThrowable(this.error, th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            if (this.fusionMode != 0 || this.queue.offer(t5)) {
                drain();
            } else {
                onError(new MissingBackpressureException("Queue is full?!"));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43181s, subscription)) {
                this.f43181s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.actual.onSubscribe(this);
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public R poll() throws Exception {
            Iterator<? extends R> it = this.current;
            while (true) {
                if (it == null) {
                    T poll = this.queue.poll();
                    if (poll != null) {
                        it = this.mapper.apply(poll).iterator();
                        if (it.hasNext()) {
                            this.current = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R next = it.next();
            if (!it.hasNext()) {
                this.current = null;
            }
            return next;
        }

        FlattenIterableSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i6) {
            this.actual = subscriber;
            this.mapper = function;
            this.prefetch = i6;
            this.limit = i6 - (i6 >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                BackpressureHelper.add(this.requested, j6);
                drain();
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Publisher<T> publisher = this.source;
        if (!(publisher instanceof Callable)) {
            publisher.subscribe(new FlattenIterableSubscriber(subscriber, this.mapper, this.prefetch));
            return;
        }
        try {
            Object call = ((Callable) publisher).call();
            if (call == null) {
                EmptySubscription.complete(subscriber);
                return;
            }
            try {
                FlowableFromIterable.subscribe(subscriber, this.mapper.apply(call).iterator());
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }

    public FlowableFlattenIterable(Publisher<T> publisher, Function<? super T, ? extends Iterable<? extends R>> function, int i6) {
        super(publisher);
        this.mapper = function;
        this.prefetch = i6;
    }
}
