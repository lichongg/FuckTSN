package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class QueueDrainHelper {
    static final long COMPLETED_MASK = Long.MIN_VALUE;
    static final long REQUESTED_MASK = Long.MAX_VALUE;

    public static <T, U> boolean checkTerminated(boolean z5, boolean z6, Subscriber<?> subscriber, boolean z7, SimpleQueue<?> simpleQueue, QueueDrain<T, U> queueDrain) {
        if (queueDrain.cancelled()) {
            simpleQueue.clear();
            return true;
        }
        if (!z5) {
            return false;
        }
        if (z7) {
            if (!z6) {
                return false;
            }
            Throwable error = queueDrain.error();
            if (error != null) {
                subscriber.onError(error);
            } else {
                subscriber.onComplete();
            }
            return true;
        }
        Throwable error2 = queueDrain.error();
        if (error2 != null) {
            simpleQueue.clear();
            subscriber.onError(error2);
            return true;
        }
        if (!z6) {
            return false;
        }
        subscriber.onComplete();
        return true;
    }

    public static <T, U> void drainLoop(SimpleQueue<T> simpleQueue, Subscriber<? super U> subscriber, boolean z5, QueueDrain<T, U> queueDrain) {
        int i6 = 1;
        while (true) {
            SimpleQueue<T> simpleQueue2 = simpleQueue;
            Subscriber<? super U> subscriber2 = subscriber;
            boolean z6 = z5;
            QueueDrain<T, U> queueDrain2 = queueDrain;
            if (checkTerminated(queueDrain.done(), simpleQueue.isEmpty(), subscriber2, z6, simpleQueue2, queueDrain2)) {
                return;
            }
            long requested = queueDrain2.requested();
            long j6 = 0;
            while (j6 != requested) {
                boolean done = queueDrain2.done();
                try {
                    T poll = simpleQueue2.poll();
                    boolean z7 = poll == null;
                    if (checkTerminated(done, z7, subscriber2, z6, simpleQueue2, queueDrain2)) {
                        return;
                    }
                    if (z7) {
                        break;
                    } else if (queueDrain2.accept(subscriber2, poll)) {
                        j6++;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    subscriber2.onError(th);
                    return;
                }
            }
            if (j6 != 0 && requested != Long.MAX_VALUE) {
                queueDrain2.produced(j6);
            }
            i6 = queueDrain2.leave(-i6);
            if (i6 == 0) {
                return;
            }
            subscriber = subscriber2;
            z5 = z6;
            simpleQueue = simpleQueue2;
            queueDrain = queueDrain2;
        }
    }

    public static <T, U> void drainMaxLoop(SimpleQueue<T> simpleQueue, Subscriber<? super U> subscriber, boolean z5, Disposable disposable, QueueDrain<T, U> queueDrain) {
        int i6 = 1;
        while (true) {
            boolean done = queueDrain.done();
            try {
                T poll = simpleQueue.poll();
                boolean z6 = poll == null;
                SimpleQueue<T> simpleQueue2 = simpleQueue;
                Subscriber<? super U> subscriber2 = subscriber;
                boolean z7 = z5;
                QueueDrain<T, U> queueDrain2 = queueDrain;
                if (checkTerminated(done, z6, subscriber2, z7, simpleQueue2, queueDrain2)) {
                    if (disposable != null) {
                        disposable.dispose();
                        return;
                    }
                    return;
                }
                if (z6) {
                    i6 = queueDrain2.leave(-i6);
                    if (i6 == 0) {
                        return;
                    }
                } else {
                    long requested = queueDrain2.requested();
                    if (requested == 0) {
                        simpleQueue2.clear();
                        if (disposable != null) {
                            disposable.dispose();
                        }
                        subscriber2.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
                        return;
                    }
                    if (queueDrain2.accept(subscriber2, poll) && requested != Long.MAX_VALUE) {
                        queueDrain2.produced(1L);
                    }
                }
                subscriber = subscriber2;
                z5 = z7;
                simpleQueue = simpleQueue2;
                queueDrain = queueDrain2;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                subscriber.onError(th);
                return;
            }
        }
    }

    public static <T> SimpleQueue<T> createQueue(int i6) {
        return i6 < 0 ? new SpscLinkedArrayQueue(-i6) : new SpscArrayQueue(i6);
    }

    static <T> boolean postCompleteDrain(long j6, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j7 = j6 & Long.MIN_VALUE;
        while (true) {
            if (j7 != j6) {
                if (isCancelled(booleanSupplier)) {
                    return true;
                }
                T poll = queue.poll();
                if (poll == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.onNext(poll);
                j7++;
            } else {
                if (isCancelled(booleanSupplier)) {
                    return true;
                }
                if (queue.isEmpty()) {
                    subscriber.onComplete();
                    return true;
                }
                j6 = atomicLong.get();
                if (j6 == j7) {
                    long addAndGet = atomicLong.addAndGet(-(j7 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j7 = addAndGet & Long.MIN_VALUE;
                    j6 = addAndGet;
                } else {
                    continue;
                }
            }
        }
    }

    public static void request(Subscription subscription, int i6) {
        subscription.request(i6 < 0 ? Long.MAX_VALUE : i6);
    }

    private QueueDrainHelper() {
        throw new IllegalStateException("No instances!");
    }

    static boolean isCancelled(BooleanSupplier booleanSupplier) {
        try {
            return booleanSupplier.getAsBoolean();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            return true;
        }
    }

    public static <T> void postComplete(Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j6;
        long j7;
        if (queue.isEmpty()) {
            subscriber.onComplete();
            return;
        }
        if (!postCompleteDrain(atomicLong.get(), subscriber, queue, atomicLong, booleanSupplier)) {
            do {
                j6 = atomicLong.get();
                if ((j6 & Long.MIN_VALUE) == 0) {
                    j7 = j6 | Long.MIN_VALUE;
                } else {
                    return;
                }
            } while (!atomicLong.compareAndSet(j6, j7));
            if (j6 != 0) {
                postCompleteDrain(j7, subscriber, queue, atomicLong, booleanSupplier);
            }
        }
    }

    public static <T> boolean postCompleteRequest(long j6, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j7;
        do {
            j7 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j7, BackpressureHelper.addCap(Long.MAX_VALUE & j7, j6) | (j7 & Long.MIN_VALUE)));
        if (j7 == Long.MIN_VALUE) {
            postCompleteDrain(j6 | Long.MIN_VALUE, subscriber, queue, atomicLong, booleanSupplier);
            return true;
        }
        return false;
    }

    public static <T, U> boolean checkTerminated(boolean z5, boolean z6, Observer<?> observer, boolean z7, SimpleQueue<?> simpleQueue, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        if (observableQueueDrain.cancelled()) {
            simpleQueue.clear();
            disposable.dispose();
            return true;
        }
        if (!z5) {
            return false;
        }
        if (z7) {
            if (!z6) {
                return false;
            }
            disposable.dispose();
            Throwable error = observableQueueDrain.error();
            if (error != null) {
                observer.onError(error);
            } else {
                observer.onComplete();
            }
            return true;
        }
        Throwable error2 = observableQueueDrain.error();
        if (error2 != null) {
            simpleQueue.clear();
            disposable.dispose();
            observer.onError(error2);
            return true;
        }
        if (!z6) {
            return false;
        }
        disposable.dispose();
        observer.onComplete();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        r1 = r8.leave(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        if (r1 != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T, U> void drainLoop(io.reactivex.internal.fuseable.SimpleQueue<T> r9, io.reactivex.Observer<? super U> r10, boolean r11, io.reactivex.disposables.Disposable r12, io.reactivex.internal.util.ObservableQueueDrain<T, U> r13) {
        /*
            r0 = 1
            r1 = 1
        L2:
            boolean r2 = r13.done()
            boolean r3 = r9.isEmpty()
            r6 = r9
            r4 = r10
            r5 = r11
            r7 = r12
            r8 = r13
            boolean r9 = checkTerminated(r2, r3, r4, r5, r6, r7, r8)
            if (r9 == 0) goto L16
            goto L35
        L16:
            boolean r2 = r8.done()
            java.lang.Object r9 = r6.poll()     // Catch: java.lang.Throwable -> L40
            if (r9 != 0) goto L22
            r3 = 1
            goto L24
        L22:
            r10 = 0
            r3 = 0
        L24:
            boolean r10 = checkTerminated(r2, r3, r4, r5, r6, r7, r8)
            r11 = r3
            if (r10 == 0) goto L2c
            goto L35
        L2c:
            if (r11 == 0) goto L3c
            int r9 = -r1
            int r1 = r8.leave(r9)
            if (r1 != 0) goto L36
        L35:
            return
        L36:
            r10 = r4
            r11 = r5
            r9 = r6
            r12 = r7
            r13 = r8
            goto L2
        L3c:
            r8.accept(r4, r9)
            goto L16
        L40:
            r0 = move-exception
            r9 = r0
            io.reactivex.exceptions.Exceptions.throwIfFatal(r9)
            r4.onError(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.QueueDrainHelper.drainLoop(io.reactivex.internal.fuseable.SimpleQueue, io.reactivex.Observer, boolean, io.reactivex.disposables.Disposable, io.reactivex.internal.util.ObservableQueueDrain):void");
    }
}
