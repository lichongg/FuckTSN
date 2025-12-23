package io.reactivex.internal.subscribers;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class QueueDrainSubscriber<T, U, V> extends QueueDrainSubscriberPad4 implements Subscriber<T>, QueueDrain<U, V> {
    protected final Subscriber<? super V> actual;
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected Throwable error;
    protected final SimplePlainQueue<U> queue;

    public boolean accept(Subscriber<? super V> subscriber, U u5) {
        return false;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long requested() {
        return this.requested.get();
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean cancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean done() {
        return this.done;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean enter() {
        return this.wip.getAndIncrement() == 0;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final Throwable error() {
        return this.error;
    }

    public final boolean fastEnter() {
        return this.wip.get() == 0 && this.wip.compareAndSet(0, 1);
    }

    protected final void fastPathEmitMax(U u5, boolean z5, Disposable disposable) {
        Subscriber<? super V> subscriber = this.actual;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
            long j6 = this.requested.get();
            if (j6 == 0) {
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else {
                if (accept(subscriber, u5) && j6 != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (leave(-1) == 0) {
                    return;
                }
            }
        } else {
            simplePlainQueue.offer(u5);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, z5, disposable, this);
    }

    protected final void fastPathOrderedEmitMax(U u5, boolean z5, Disposable disposable) {
        Subscriber<? super V> subscriber = this.actual;
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
            long j6 = this.requested.get();
            if (j6 == 0) {
                this.cancelled = true;
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else if (simplePlainQueue.isEmpty()) {
                if (accept(subscriber, u5) && j6 != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                simplePlainQueue.offer(u5);
            }
        } else {
            simplePlainQueue.offer(u5);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, z5, disposable, this);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final int leave(int i6) {
        return this.wip.addAndGet(i6);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long produced(long j6) {
        return this.requested.addAndGet(-j6);
    }

    public final void requested(long j6) {
        if (SubscriptionHelper.validate(j6)) {
            BackpressureHelper.add(this.requested, j6);
        }
    }

    public QueueDrainSubscriber(Subscriber<? super V> subscriber, SimplePlainQueue<U> simplePlainQueue) {
        this.actual = subscriber;
        this.queue = simplePlainQueue;
    }

    public void drain(boolean z5) {
        if (enter()) {
            QueueDrainHelper.drainLoop(this.queue, this.actual, z5, this);
        }
    }
}
