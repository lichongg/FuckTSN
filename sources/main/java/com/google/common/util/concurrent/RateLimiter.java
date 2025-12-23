package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class RateLimiter {

    @MonotonicNonNullDecl
    private volatile Object mutexDoNotUseDirectly;
    private final SleepingStopwatch stopwatch;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class SleepingStopwatch {
        protected abstract long readMicros();

        protected abstract void sleepMicrosUninterruptibly(long j6);

        public static SleepingStopwatch createFromSystemTimer() {
            return new SleepingStopwatch() { // from class: com.google.common.util.concurrent.RateLimiter.SleepingStopwatch.1
                final Stopwatch stopwatch = Stopwatch.createStarted();

                @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
                protected long readMicros() {
                    return this.stopwatch.elapsed(TimeUnit.MICROSECONDS);
                }

                @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
                protected void sleepMicrosUninterruptibly(long j6) {
                    if (j6 > 0) {
                        Uninterruptibles.sleepUninterruptibly(j6, TimeUnit.MICROSECONDS);
                    }
                }
            };
        }

        protected SleepingStopwatch() {
        }
    }

    public static RateLimiter create(double d6) {
        return create(d6, SleepingStopwatch.createFromSystemTimer());
    }

    @CanIgnoreReturnValue
    public double acquire() {
        return acquire(1);
    }

    abstract double doGetRate();

    abstract void doSetRate(double d6, long j6);

    abstract long queryEarliestAvailable(long j6);

    abstract long reserveEarliestAvailable(int i6, long j6);

    public boolean tryAcquire(long j6, TimeUnit timeUnit) {
        return tryAcquire(1, j6, timeUnit);
    }

    private static void checkPermits(int i6) {
        Preconditions.checkArgument(i6 > 0, "Requested permits (%s) must be positive", i6);
    }

    @VisibleForTesting
    static RateLimiter create(double d6, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothBursty smoothBursty = new SmoothRateLimiter.SmoothBursty(sleepingStopwatch, 1.0d);
        smoothBursty.setRate(d6);
        return smoothBursty;
    }

    private Object mutex() {
        Object obj;
        Object obj2 = this.mutexDoNotUseDirectly;
        if (obj2 != null) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.mutexDoNotUseDirectly;
                if (obj == null) {
                    obj = new Object();
                    this.mutexDoNotUseDirectly = obj;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @CanIgnoreReturnValue
    public double acquire(int i6) {
        long reserve = reserve(i6);
        this.stopwatch.sleepMicrosUninterruptibly(reserve);
        return (reserve * 1.0d) / TimeUnit.SECONDS.toMicros(1L);
    }

    public final void setRate(double d6) {
        Preconditions.checkArgument(d6 > 0.0d && !Double.isNaN(d6), "rate must be positive");
        synchronized (mutex()) {
            doSetRate(d6, this.stopwatch.readMicros());
        }
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(getRate()));
    }

    public boolean tryAcquire(int i6) {
        return tryAcquire(i6, 0L, TimeUnit.MICROSECONDS);
    }

    RateLimiter(SleepingStopwatch sleepingStopwatch) {
        this.stopwatch = (SleepingStopwatch) Preconditions.checkNotNull(sleepingStopwatch);
    }

    private boolean canAcquire(long j6, long j7) {
        if (queryEarliestAvailable(j6) - j7 <= j6) {
            return true;
        }
        return false;
    }

    public final double getRate() {
        double doGetRate;
        synchronized (mutex()) {
            doGetRate = doGetRate();
        }
        return doGetRate;
    }

    final long reserve(int i6) {
        long reserveAndGetWaitLength;
        checkPermits(i6);
        synchronized (mutex()) {
            reserveAndGetWaitLength = reserveAndGetWaitLength(i6, this.stopwatch.readMicros());
        }
        return reserveAndGetWaitLength;
    }

    final long reserveAndGetWaitLength(int i6, long j6) {
        return Math.max(reserveEarliestAvailable(i6, j6) - j6, 0L);
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0L, TimeUnit.MICROSECONDS);
    }

    public static RateLimiter create(double d6, long j6, TimeUnit timeUnit) {
        Preconditions.checkArgument(j6 >= 0, "warmupPeriod must not be negative: %s", j6);
        return create(d6, j6, timeUnit, 3.0d, SleepingStopwatch.createFromSystemTimer());
    }

    public boolean tryAcquire(int i6, long j6, TimeUnit timeUnit) {
        long max = Math.max(timeUnit.toMicros(j6), 0L);
        checkPermits(i6);
        synchronized (mutex()) {
            try {
                long readMicros = this.stopwatch.readMicros();
                if (!canAcquire(readMicros, max)) {
                    return false;
                }
                this.stopwatch.sleepMicrosUninterruptibly(reserveAndGetWaitLength(i6, readMicros));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    static RateLimiter create(double d6, long j6, TimeUnit timeUnit, double d7, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothWarmingUp smoothWarmingUp = new SmoothRateLimiter.SmoothWarmingUp(sleepingStopwatch, j6, timeUnit, d7);
        smoothWarmingUp.setRate(d6);
        return smoothWarmingUp;
    }
}
