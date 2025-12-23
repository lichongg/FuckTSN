package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super Open, ? extends Publisher<? extends Close>> bufferClose;
    final Publisher<? extends Open> bufferOpen;
    final Callable<U> bufferSupplier;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, Open, Close> extends QueueDrainSubscriber<T, U, U> implements Subscription, Disposable {
        final Function<? super Open, ? extends Publisher<? extends Close>> bufferClose;
        final Publisher<? extends Open> bufferOpen;
        final Callable<U> bufferSupplier;
        final List<U> buffers;
        final CompositeDisposable resources;

        /* renamed from: s, reason: collision with root package name */
        Subscription f43148s;
        final AtomicInteger windows;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber subscriber, Object obj) {
            return accept((Subscriber<? super Subscriber>) subscriber, (Subscriber) obj);
        }

        void close(U u5, Disposable disposable) {
            boolean remove;
            synchronized (this) {
                remove = this.buffers.remove(u5);
            }
            if (remove) {
                fastPathOrderedEmitMax(u5, false, this);
            }
            if (this.resources.remove(disposable) && this.windows.decrementAndGet() == 0) {
                complete();
            }
        }

        void complete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.buffers);
                this.buffers.clear();
            }
            SimpleQueue simpleQueue = this.queue;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                simpleQueue.offer((Collection) it.next());
            }
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(simpleQueue, this.actual, false, this, this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            synchronized (this) {
                try {
                    Iterator<U> it = this.buffers.iterator();
                    while (it.hasNext()) {
                        it.next().add(t5);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        BufferBoundarySubscriber(Subscriber<? super U> subscriber, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Callable<U> callable) {
            super(subscriber, new MpscLinkedQueue());
            this.windows = new AtomicInteger();
            this.bufferOpen = publisher;
            this.bufferClose = function;
            this.bufferSupplier = callable;
            this.buffers = new LinkedList();
            this.resources = new CompositeDisposable();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean accept(Subscriber<? super U> subscriber, U u5) {
            subscriber.onNext(u5);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.resources.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.resources.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.windows.decrementAndGet() == 0) {
                complete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f43148s, subscription)) {
                this.f43148s = subscription;
                BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
                this.resources.add(bufferOpenSubscriber);
                this.actual.onSubscribe(this);
                this.windows.lazySet(1);
                this.bufferOpen.subscribe(bufferOpenSubscriber);
                subscription.request(Long.MAX_VALUE);
            }
        }

        void open(Open open) {
            if (this.cancelled) {
                return;
            }
            try {
                Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.bufferClose.apply(open), "The buffer closing publisher is null");
                    if (this.cancelled) {
                        return;
                    }
                    synchronized (this) {
                        try {
                            if (this.cancelled) {
                                return;
                            }
                            this.buffers.add(collection);
                            BufferCloseSubscriber bufferCloseSubscriber = new BufferCloseSubscriber(collection, this);
                            this.resources.add(bufferCloseSubscriber);
                            this.windows.getAndIncrement();
                            publisher.subscribe(bufferCloseSubscriber);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                onError(th3);
            }
        }

        void openFinished(Disposable disposable) {
            if (this.resources.remove(disposable) && this.windows.decrementAndGet() == 0) {
                complete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            cancel();
            this.cancelled = true;
            synchronized (this) {
                this.buffers.clear();
            }
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j6) {
            requested(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferCloseSubscriber<T, U extends Collection<? super T>, Open, Close> extends DisposableSubscriber<Close> {
        boolean done;
        final BufferBoundarySubscriber<T, U, Open, Close> parent;
        final U value;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.close(this.value, this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.parent.onError(th);
            }
        }

        BufferCloseSubscriber(U u5, BufferBoundarySubscriber<T, U, Open, Close> bufferBoundarySubscriber) {
            this.parent = bufferBoundarySubscriber;
            this.value = u5;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Close close) {
            onComplete();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BufferOpenSubscriber<T, U extends Collection<? super T>, Open, Close> extends DisposableSubscriber<Open> {
        boolean done;
        final BufferBoundarySubscriber<T, U, Open, Close> parent;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.openFinished(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.parent.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Open open) {
            if (this.done) {
                return;
            }
            this.parent.open(open);
        }

        BufferOpenSubscriber(BufferBoundarySubscriber<T, U, Open, Close> bufferBoundarySubscriber) {
            this.parent = bufferBoundarySubscriber;
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        this.source.subscribe(new BufferBoundarySubscriber(new SerializedSubscriber(subscriber), this.bufferOpen, this.bufferClose, this.bufferSupplier));
    }

    public FlowableBufferBoundary(Publisher<T> publisher, Publisher<? extends Open> publisher2, Function<? super Open, ? extends Publisher<? extends Close>> function, Callable<U> callable) {
        super(publisher);
        this.bufferOpen = publisher2;
        this.bufferClose = function;
        this.bufferSupplier = callable;
    }
}
