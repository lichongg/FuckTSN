package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class SmoothRateLimiter extends RateLimiter {
    double maxPermits;
    private long nextFreeTicketMicros;
    double stableIntervalMicros;
    double storedPermits;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.util.concurrent.SmoothRateLimiter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SmoothBursty extends SmoothRateLimiter {
        final double maxBurstSeconds;

        SmoothBursty(RateLimiter.SleepingStopwatch sleepingStopwatch, double d6) {
            super(sleepingStopwatch, null);
            this.maxBurstSeconds = d6;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        double coolDownIntervalMicros() {
            return this.stableIntervalMicros;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        void doSetRate(double d6, double d7) {
            double d8 = this.maxPermits;
            double d9 = this.maxBurstSeconds * d6;
            this.maxPermits = d9;
            if (d8 == Double.POSITIVE_INFINITY) {
                this.storedPermits = d9;
            } else {
                this.storedPermits = d8 != 0.0d ? (this.storedPermits * d9) / d8 : 0.0d;
            }
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        long storedPermitsToWaitTime(double d6, double d7) {
            return 0L;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SmoothWarmingUp extends SmoothRateLimiter {
        private double coldFactor;
        private double slope;
        private double thresholdPermits;
        private final long warmupPeriodMicros;

        SmoothWarmingUp(RateLimiter.SleepingStopwatch sleepingStopwatch, long j6, TimeUnit timeUnit, double d6) {
            super(sleepingStopwatch, null);
            this.warmupPeriodMicros = timeUnit.toMicros(j6);
            this.coldFactor = d6;
        }

        private double permitsToTime(double d6) {
            return this.stableIntervalMicros + (d6 * this.slope);
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        double coolDownIntervalMicros() {
            return this.warmupPeriodMicros / this.maxPermits;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        void doSetRate(double d6, double d7) {
            double d8 = this.maxPermits;
            double d9 = this.coldFactor * d7;
            long j6 = this.warmupPeriodMicros;
            double d10 = (j6 * 0.5d) / d7;
            this.thresholdPermits = d10;
            double d11 = ((j6 * 2.0d) / (d7 + d9)) + d10;
            this.maxPermits = d11;
            this.slope = (d9 - d7) / (d11 - d10);
            if (d8 == Double.POSITIVE_INFINITY) {
                this.storedPermits = 0.0d;
                return;
            }
            if (d8 != 0.0d) {
                d11 = (this.storedPermits * d11) / d8;
            }
            this.storedPermits = d11;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        long storedPermitsToWaitTime(double d6, double d7) {
            long j6;
            double d8 = d6 - this.thresholdPermits;
            if (d8 > 0.0d) {
                double min = Math.min(d8, d7);
                j6 = (long) (((permitsToTime(d8) + permitsToTime(d8 - min)) * min) / 2.0d);
                d7 -= min;
            } else {
                j6 = 0;
            }
            return j6 + ((long) (this.stableIntervalMicros * d7));
        }
    }

    /* synthetic */ SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch, AnonymousClass1 anonymousClass1) {
        this(sleepingStopwatch);
    }

    abstract double coolDownIntervalMicros();

    abstract void doSetRate(double d6, double d7);

    @Override // com.google.common.util.concurrent.RateLimiter
    final void doSetRate(double d6, long j6) {
        resync(j6);
        double micros = TimeUnit.SECONDS.toMicros(1L) / d6;
        this.stableIntervalMicros = micros;
        doSetRate(d6, micros);
    }

    abstract long storedPermitsToWaitTime(double d6, double d7);

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        this.nextFreeTicketMicros = 0L;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final double doGetRate() {
        return TimeUnit.SECONDS.toMicros(1L) / this.stableIntervalMicros;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long queryEarliestAvailable(long j6) {
        return this.nextFreeTicketMicros;
    }

    void resync(long j6) {
        if (j6 > this.nextFreeTicketMicros) {
            this.storedPermits = Math.min(this.maxPermits, this.storedPermits + ((j6 - r0) / coolDownIntervalMicros()));
            this.nextFreeTicketMicros = j6;
        }
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long reserveEarliestAvailable(int i6, long j6) {
        resync(j6);
        long j7 = this.nextFreeTicketMicros;
        double d6 = i6;
        double min = Math.min(d6, this.storedPermits);
        this.nextFreeTicketMicros = LongMath.saturatedAdd(this.nextFreeTicketMicros, storedPermitsToWaitTime(this.storedPermits, min) + ((long) ((d6 - min) * this.stableIntervalMicros)));
        this.storedPermits -= min;
        return j7;
    }
}
