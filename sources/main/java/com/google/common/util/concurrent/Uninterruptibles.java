package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Uninterruptibles {
    @GwtIncompatible
    public static void awaitUninterruptibly(CountDownLatch countDownLatch) {
        boolean z5 = false;
        while (true) {
            try {
                countDownLatch.await();
                break;
            } catch (InterruptedException unused) {
                z5 = true;
            } catch (Throwable th) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
    }

    @CanIgnoreReturnValue
    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v5;
        boolean z5 = false;
        while (true) {
            try {
                v5 = future.get();
                break;
            } catch (InterruptedException unused) {
                z5 = true;
            } catch (Throwable th) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
        return v5;
    }

    @GwtIncompatible
    public static void joinUninterruptibly(Thread thread) {
        boolean z5 = false;
        while (true) {
            try {
                thread.join();
                break;
            } catch (InterruptedException unused) {
                z5 = true;
            } catch (Throwable th) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
    }

    @GwtIncompatible
    public static <E> void putUninterruptibly(BlockingQueue<E> blockingQueue, E e6) {
        boolean z5 = false;
        while (true) {
            try {
                blockingQueue.put(e6);
                break;
            } catch (InterruptedException unused) {
                z5 = true;
            } catch (Throwable th) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
    }

    @GwtIncompatible
    public static void sleepUninterruptibly(long j6, TimeUnit timeUnit) {
        boolean z5 = false;
        try {
            long nanos = timeUnit.toNanos(j6);
            long nanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    TimeUnit.NANOSECONDS.sleep(nanos);
                    break;
                } catch (InterruptedException unused) {
                    z5 = true;
                    nanos = nanoTime - System.nanoTime();
                }
            }
        } finally {
            if (z5) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @GwtIncompatible
    public static <E> E takeUninterruptibly(BlockingQueue<E> blockingQueue) {
        E take;
        boolean z5 = false;
        while (true) {
            try {
                take = blockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z5 = true;
            } catch (Throwable th) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
        return take;
    }

    @GwtIncompatible
    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, long j6, TimeUnit timeUnit) {
        return tryAcquireUninterruptibly(semaphore, 1, j6, timeUnit);
    }

    @GwtIncompatible
    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, int i6, long j6, TimeUnit timeUnit) {
        boolean z5 = false;
        try {
            long nanos = timeUnit.toNanos(j6);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z5 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return semaphore.tryAcquire(i6, nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z5) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private Uninterruptibles() {
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j6, TimeUnit timeUnit) {
        boolean z5 = false;
        try {
            long nanos = timeUnit.toNanos(j6);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z5 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z5) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public static <V> V getUninterruptibly(Future<V> future, long j6, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        boolean z5 = false;
        try {
            long nanos = timeUnit.toNanos(j6);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z5 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return future.get(nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z5) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @GwtIncompatible
    public static void joinUninterruptibly(Thread thread, long j6, TimeUnit timeUnit) {
        Preconditions.checkNotNull(thread);
        boolean z5 = false;
        try {
            long nanos = timeUnit.toNanos(j6);
            long nanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    TimeUnit.NANOSECONDS.timedJoin(thread, nanos);
                    break;
                } catch (InterruptedException unused) {
                    z5 = true;
                    nanos = nanoTime - System.nanoTime();
                }
            }
        } finally {
            if (z5) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @GwtIncompatible
    public static boolean awaitUninterruptibly(Condition condition, long j6, TimeUnit timeUnit) {
        boolean z5 = false;
        try {
            long nanos = timeUnit.toNanos(j6);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z5 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return condition.await(nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z5) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
