package io.reactivex.internal.util;

import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class BackpressureHelper {
    public static long addCap(long j6, long j7) {
        long j8 = j6 + j7;
        if (j8 < 0) {
            return Long.MAX_VALUE;
        }
        return j8;
    }

    public static long multiplyCap(long j6, long j7) {
        long j8 = j6 * j7;
        if (((j6 | j7) >>> 31) == 0 || j8 / j6 == j7) {
            return j8;
        }
        return Long.MAX_VALUE;
    }

    private BackpressureHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static long add(AtomicLong atomicLong, long j6) {
        long j7;
        do {
            j7 = atomicLong.get();
            if (j7 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j7, addCap(j7, j6)));
        return j7;
    }

    public static long addCancel(AtomicLong atomicLong, long j6) {
        long j7;
        do {
            j7 = atomicLong.get();
            if (j7 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j7 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j7, addCap(j7, j6)));
        return j7;
    }

    public static long produced(AtomicLong atomicLong, long j6) {
        long j7;
        long j8;
        do {
            j7 = atomicLong.get();
            if (j7 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j8 = j7 - j6;
            if (j8 < 0) {
                RxJavaPlugins.onError(new IllegalStateException("More produced than requested: " + j8));
                j8 = 0L;
            }
        } while (!atomicLong.compareAndSet(j7, j8));
        return j8;
    }

    public static long producedCancel(AtomicLong atomicLong, long j6) {
        long j7;
        long j8;
        do {
            j7 = atomicLong.get();
            if (j7 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j7 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j8 = j7 - j6;
            if (j8 < 0) {
                RxJavaPlugins.onError(new IllegalStateException("More produced than requested: " + j8));
                j8 = 0L;
            }
        } while (!atomicLong.compareAndSet(j7, j8));
        return j8;
    }
}
