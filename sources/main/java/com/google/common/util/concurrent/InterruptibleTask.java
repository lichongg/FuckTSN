package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable DONE;
    private static final Runnable INTERRUPTING;
    private static final int MAX_BUSY_WAIT_SPINS = 1000;
    private static final Runnable PARKED;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.util.concurrent.InterruptibleTask$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class DoNothingRunnable implements Runnable {
        private DoNothingRunnable() {
        }

        /* synthetic */ DoNothingRunnable(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    abstract void afterRanInterruptibly(@NullableDecl T t5, @NullableDecl Throwable th);

    abstract boolean isDone();

    abstract T runInterruptibly() throws Exception;

    abstract String toPendingString();

    static {
        AnonymousClass1 anonymousClass1 = null;
        DONE = new DoNothingRunnable(anonymousClass1);
        INTERRUPTING = new DoNothingRunnable(anonymousClass1);
        PARKED = new DoNothingRunnable(anonymousClass1);
    }

    InterruptibleTask() {
    }

    final void interruptTask() {
        Runnable runnable = get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, INTERRUPTING)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (getAndSet(DONE) == PARKED) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        T runInterruptibly;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean isDone = isDone();
            if (!isDone) {
                try {
                    runInterruptibly = runInterruptibly();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, DONE)) {
                        Runnable runnable = get();
                        boolean z5 = false;
                        int i6 = 0;
                        while (true) {
                            Runnable runnable2 = INTERRUPTING;
                            if (runnable != runnable2 && runnable != PARKED) {
                                break;
                            }
                            i6++;
                            if (i6 > 1000) {
                                Runnable runnable3 = PARKED;
                                if (runnable == runnable3 || compareAndSet(runnable2, runnable3)) {
                                    if (!Thread.interrupted() && !z5) {
                                        z5 = false;
                                    } else {
                                        z5 = true;
                                    }
                                    LockSupport.park(this);
                                }
                            } else {
                                Thread.yield();
                            }
                            runnable = get();
                        }
                        if (z5) {
                            currentThread.interrupt();
                        }
                    }
                    if (!isDone) {
                        afterRanInterruptibly(null, th);
                        return;
                    }
                    return;
                }
            } else {
                runInterruptibly = null;
            }
            if (!compareAndSet(currentThread, DONE)) {
                Runnable runnable4 = get();
                boolean z6 = false;
                int i7 = 0;
                while (true) {
                    Runnable runnable5 = INTERRUPTING;
                    if (runnable4 != runnable5 && runnable4 != PARKED) {
                        break;
                    }
                    i7++;
                    if (i7 > 1000) {
                        Runnable runnable6 = PARKED;
                        if (runnable4 == runnable6 || compareAndSet(runnable5, runnable6)) {
                            if (!Thread.interrupted() && !z6) {
                                z6 = false;
                            } else {
                                z6 = true;
                            }
                            LockSupport.park(this);
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable4 = get();
                }
                if (z6) {
                    currentThread.interrupt();
                }
            }
            if (!isDone) {
                afterRanInterruptibly(runInterruptibly, null);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == DONE) {
            str = "running=[DONE]";
        } else if (runnable == INTERRUPTING) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + toPendingString();
    }
}
