package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {
    protected final Observer<? super V> actual;
    protected volatile boolean cancelled;
    protected volatile boolean done;
    protected Throwable error;
    protected final SimpleQueue<U> queue;

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean cancelled() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean done() {
        return this.done;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean enter() {
        return this.wip.getAndIncrement() == 0;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final Throwable error() {
        return this.error;
    }

    public final boolean fastEnter() {
        return this.wip.get() == 0 && this.wip.compareAndSet(0, 1);
    }

    protected final void fastPathEmit(U u5, boolean z5, Disposable disposable) {
        Observer<? super V> observer = this.actual;
        SimpleQueue<U> simpleQueue = this.queue;
        if (this.wip.get() == 0 && this.wip.compareAndSet(0, 1)) {
            accept(observer, u5);
            if (leave(-1) == 0) {
                return;
            }
        } else {
            simpleQueue.offer(u5);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainLoop(simpleQueue, observer, z5, disposable, this);
    }

    protected final void fastPathOrderedEmit(U u5, boolean z5, Disposable disposable) {
        Observer<? super V> observer = this.actual;
        SimpleQueue<U> simpleQueue = this.queue;
        if (this.wip.get() != 0 || !this.wip.compareAndSet(0, 1)) {
            simpleQueue.offer(u5);
            if (!enter()) {
                return;
            }
        } else if (simpleQueue.isEmpty()) {
            accept(observer, u5);
            if (leave(-1) == 0) {
                return;
            }
        } else {
            simpleQueue.offer(u5);
        }
        QueueDrainHelper.drainLoop(simpleQueue, observer, z5, disposable, this);
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final int leave(int i6) {
        return this.wip.addAndGet(i6);
    }

    public QueueDrainObserver(Observer<? super V> observer, SimpleQueue<U> simpleQueue) {
        this.actual = observer;
        this.queue = simpleQueue;
    }

    public void drain(boolean z5, Disposable disposable) {
        if (enter()) {
            QueueDrainHelper.drainLoop(this.queue, this.actual, z5, disposable, this);
        }
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public void accept(Observer<? super V> observer, U u5) {
    }
}
