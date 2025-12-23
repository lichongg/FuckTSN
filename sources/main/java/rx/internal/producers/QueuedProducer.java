package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.f;
import rx.g;
import rx.internal.util.unsafe.g0;
import rx.internal.util.unsafe.n0;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class QueuedProducer<T> extends AtomicLong implements g, f<T> {
    static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    final l<? super T> child;
    volatile boolean done;
    Throwable error;
    final Queue<Object> queue;
    final AtomicInteger wip;

    public QueuedProducer(l<? super T> lVar) {
        this(lVar, n0.f() ? new g0() : new rx.internal.util.atomic.f());
    }

    public boolean offer(T t5) {
        if (t5 == null) {
            if (!this.queue.offer(NULL_SENTINEL)) {
                return false;
            }
        } else if (!this.queue.offer(t5)) {
            return false;
        }
        drain();
        return true;
    }

    @Override // rx.f
    public void onCompleted() {
        this.done = true;
        drain();
    }

    public QueuedProducer(l<? super T> lVar, Queue<Object> queue) {
        this.child = lVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }

    private boolean checkTerminated(boolean z5, boolean z6) {
        if (this.child.isUnsubscribed()) {
            return true;
        }
        if (!z5) {
            return false;
        }
        Throwable th = this.error;
        if (th != null) {
            this.queue.clear();
            this.child.onError(th);
            return true;
        }
        if (!z6) {
            return false;
        }
        this.child.onCompleted();
        return true;
    }

    private void drain() {
        if (this.wip.getAndIncrement() == 0) {
            l<? super T> lVar = this.child;
            Queue<Object> queue = this.queue;
            while (!checkTerminated(this.done, queue.isEmpty())) {
                this.wip.lazySet(1);
                long j6 = get();
                long j7 = 0;
                while (j6 != 0) {
                    boolean z5 = this.done;
                    Object poll = queue.poll();
                    if (checkTerminated(z5, poll == null)) {
                        return;
                    }
                    if (poll == null) {
                        break;
                    }
                    try {
                        if (poll == NULL_SENTINEL) {
                            lVar.onNext(null);
                        } else {
                            lVar.onNext(poll);
                        }
                        j6--;
                        j7++;
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        rx.exceptions.a.g(th, lVar, poll);
                        return;
                    }
                }
                if (j7 != 0 && get() != Long.MAX_VALUE) {
                    addAndGet(-j7);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // rx.g
    public void request(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j6 > 0) {
            rx.internal.operators.a.b(this, j6);
            drain();
        }
    }

    @Override // rx.f
    public void onNext(T t5) {
        if (!offer(t5)) {
            onError(new MissingBackpressureException());
        }
    }
}
