package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {
    final Callable<C> bufferSupplier;
    final int size;
    final int skip;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements Subscriber<T>, Subscription {
        final Subscriber<? super C> actual;
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        int index;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43145s;
        final int size;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43145s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c6 = this.buffer;
            if (c6 != null && !c6.isEmpty()) {
                this.actual.onNext(c6);
            }
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            C c6 = this.buffer;
            if (c6 == null) {
                try {
                    c6 = (C) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                    this.buffer = c6;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            c6.add(t5);
            int i6 = this.index + 1;
            if (i6 != this.size) {
                this.index = i6;
                return;
            }
            this.index = 0;
            this.buffer = null;
            this.actual.onNext(c6);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43145s, subscription)) {
                this.f43145s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        PublisherBufferExactSubscriber(Subscriber<? super C> subscriber, int i6, Callable<C> callable) {
            this.actual = subscriber;
            this.size = i6;
            this.bufferSupplier = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                this.f43145s.request(BackpressureHelper.multiplyCap(j6, this.size));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements Subscriber<T>, Subscription, BooleanSupplier {
        private static final long serialVersionUID = -7370244972039324525L;
        final Subscriber<? super C> actual;
        final Callable<C> bufferSupplier;
        volatile boolean cancelled;
        boolean done;
        int index;
        long produced;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43146s;
        final int size;
        final int skip;
        final AtomicBoolean once = new AtomicBoolean();
        final ArrayDeque<C> buffers = new ArrayDeque<>();

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.f43146s.cancel();
        }

        @Override // io.reactivex.functions.BooleanSupplier
        public boolean getAsBoolean() {
            return this.cancelled;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long j6 = this.produced;
            if (j6 != 0) {
                BackpressureHelper.produced(this, j6);
            }
            QueueDrainHelper.postComplete(this.actual, this.buffers, this, this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffers.clear();
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            ArrayDeque<C> arrayDeque = this.buffers;
            int i6 = this.index;
            int i7 = i6 + 1;
            if (i6 == 0) {
                try {
                    arrayDeque.offer((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer"));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            Collection collection = (Collection) arrayDeque.peek();
            if (collection != null && collection.size() + 1 == this.size) {
                arrayDeque.poll();
                collection.add(t5);
                this.produced++;
                this.actual.onNext(collection);
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((Collection) it.next()).add(t5);
            }
            if (i7 == this.skip) {
                i7 = 0;
            }
            this.index = i7;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43146s, subscription)) {
                this.f43146s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        PublisherBufferOverlappingSubscriber(Subscriber<? super C> subscriber, int i6, int i7, Callable<C> callable) {
            this.actual = subscriber;
            this.size = i6;
            this.skip = i7;
            this.bufferSupplier = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6) && !QueueDrainHelper.postCompleteRequest(j6, this.actual, this.buffers, this, this)) {
                if (!this.once.get() && this.once.compareAndSet(false, true)) {
                    this.f43146s.request(BackpressureHelper.addCap(this.size, BackpressureHelper.multiplyCap(this.skip, j6 - 1)));
                } else {
                    this.f43146s.request(BackpressureHelper.multiplyCap(this.skip, j6));
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = -5616169793639412593L;
        final Subscriber<? super C> actual;
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        int index;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43147s;
        final int size;
        final int skip;

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f43147s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c6 = this.buffer;
            this.buffer = null;
            if (c6 != null) {
                this.actual.onNext(c6);
            }
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffer = null;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.done) {
                return;
            }
            C c6 = this.buffer;
            int i6 = this.index;
            int i7 = i6 + 1;
            if (i6 == 0) {
                try {
                    c6 = (C) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                    this.buffer = c6;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            if (c6 != null) {
                c6.add(t5);
                if (c6.size() == this.size) {
                    this.buffer = null;
                    this.actual.onNext(c6);
                }
            }
            if (i7 == this.skip) {
                i7 = 0;
            }
            this.index = i7;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43147s, subscription)) {
                this.f43147s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        PublisherBufferSkipSubscriber(Subscriber<? super C> subscriber, int i6, int i7, Callable<C> callable) {
            this.actual = subscriber;
            this.size = i6;
            this.skip = i7;
            this.bufferSupplier = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            if (SubscriptionHelper.validate(j6)) {
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.f43147s.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(j6, this.size), BackpressureHelper.multiplyCap(this.skip - this.size, j6 - 1)));
                    return;
                }
                this.f43147s.request(BackpressureHelper.multiplyCap(this.skip, j6));
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super C> subscriber) {
        int i6 = this.size;
        int i7 = this.skip;
        if (i6 == i7) {
            this.source.subscribe(new PublisherBufferExactSubscriber(subscriber, i6, this.bufferSupplier));
        } else if (i7 > i6) {
            this.source.subscribe(new PublisherBufferSkipSubscriber(subscriber, this.size, this.skip, this.bufferSupplier));
        } else {
            this.source.subscribe(new PublisherBufferOverlappingSubscriber(subscriber, this.size, this.skip, this.bufferSupplier));
        }
    }

    public FlowableBuffer(Publisher<T> publisher, int i6, int i7, Callable<C> callable) {
        super(publisher);
        this.size = i6;
        this.skip = i7;
        this.bufferSupplier = callable;
    }
}
