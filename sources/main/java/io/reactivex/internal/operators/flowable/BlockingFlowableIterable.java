package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class BlockingFlowableIterable<T> implements Iterable<T> {
    final int bufferSize;
    final Publisher<? extends T> source;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class BlockingFlowableIterator<T> extends AtomicReference<Subscription> implements Subscriber<T>, Iterator<T>, Runnable, Disposable {
        private static final long serialVersionUID = 6695226475494099826L;
        final long batchSize;
        final Condition condition;
        volatile boolean done;
        Throwable error;
        final long limit;
        final Lock lock;
        long produced;
        final SpscArrayQueue<T> queue;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                boolean z5 = this.done;
                boolean isEmpty = this.queue.isEmpty();
                if (z5) {
                    Throwable th = this.error;
                    if (th != null) {
                        throw ExceptionHelper.wrapOrThrow(th);
                    }
                    if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                this.lock.lock();
                while (!this.done && this.queue.isEmpty()) {
                    try {
                        try {
                            this.condition.await();
                        } catch (InterruptedException e6) {
                            run();
                            throw ExceptionHelper.wrapOrThrow(e6);
                        }
                    } finally {
                        this.lock.unlock();
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            signalConsumer();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t5) {
            if (this.queue.offer(t5)) {
                signalConsumer();
            } else {
                SubscriptionHelper.cancel(this);
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        void signalConsumer() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }

        BlockingFlowableIterator(int i6) {
            this.queue = new SpscArrayQueue<>(i6);
            this.batchSize = i6;
            this.limit = i6 - (i6 >> 2);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.condition = reentrantLock.newCondition();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T poll = this.queue.poll();
                long j6 = this.produced + 1;
                if (j6 == this.limit) {
                    this.produced = 0L;
                    get().request(j6);
                    return poll;
                }
                this.produced = j6;
                return poll;
            }
            throw new NoSuchElementException();
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                subscription.request(this.batchSize);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SubscriptionHelper.cancel(this);
            signalConsumer();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingFlowableIterator blockingFlowableIterator = new BlockingFlowableIterator(this.bufferSize);
        this.source.subscribe(blockingFlowableIterator);
        return blockingFlowableIterator;
    }

    public BlockingFlowableIterable(Publisher<? extends T> publisher, int i6) {
        this.source = publisher;
        this.bufferSize = i6;
    }
}
