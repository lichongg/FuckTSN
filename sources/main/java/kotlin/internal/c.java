package kotlin.internal;

import kotlin.PublishedApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {
    private static final int e(int i6, int i7) {
        int i8 = i6 % i7;
        return i8 >= 0 ? i8 : i8 + i7;
    }

    private static final long f(long j6, long j7) {
        long j8 = j6 % j7;
        return j8 >= 0 ? j8 : j8 + j7;
    }

    @PublishedApi
    public static final int c(int i6, int i7, int i8) {
        if (i8 > 0) {
            if (i6 < i7) {
                return i7 - a(i7, i6, i8);
            }
        } else {
            if (i8 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i6 > i7) {
                return i7 + a(i6, i7, -i8);
            }
        }
        return i7;
    }

    @PublishedApi
    public static final long d(long j6, long j7, long j8) {
        if (j8 > 0) {
            return j6 >= j7 ? j7 : j7 - b(j7, j6, j8);
        }
        if (j8 < 0) {
            return j6 <= j7 ? j7 : j7 + b(j6, j7, -j8);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int a(int i6, int i7, int i8) {
        return e(e(i6, i8) - e(i7, i8), i8);
    }

    private static final long b(long j6, long j7, long j8) {
        return f(f(j6, j8) - f(j7, j8), j8);
    }
}
