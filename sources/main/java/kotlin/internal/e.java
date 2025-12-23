package kotlin.internal;

import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.d1;
import kotlin.r0;
import kotlin.s0;
import kotlin.z0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final long c(long j6, long j7, long j8) {
        int compare;
        int compare2;
        if (j8 > 0) {
            compare2 = Long.compare(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE);
            return compare2 >= 0 ? j7 : d1.k(j7 - b(j7, j6, d1.k(j8)));
        }
        if (j8 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        }
        compare = Long.compare(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE);
        return compare <= 0 ? j7 : d1.k(j7 + b(j6, j7, d1.k(-j8)));
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final int d(int i6, int i7, int i8) {
        int compare;
        int compare2;
        if (i8 > 0) {
            compare2 = Integer.compare(i6 ^ Integer.MIN_VALUE, i7 ^ Integer.MIN_VALUE);
            if (compare2 < 0) {
                return z0.k(i7 - a(i7, i6, z0.k(i8)));
            }
        } else {
            if (i8 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            compare = Integer.compare(i6 ^ Integer.MIN_VALUE, i7 ^ Integer.MIN_VALUE);
            if (compare > 0) {
                return z0.k(i7 + a(i6, i7, z0.k(-i8)));
            }
        }
        return i7;
    }

    private static final int a(int i6, int i7, int i8) {
        int compare;
        int a6 = r0.a(i6, i8);
        int a7 = r0.a(i7, i8);
        compare = Integer.compare(a6 ^ Integer.MIN_VALUE, a7 ^ Integer.MIN_VALUE);
        int k6 = z0.k(a6 - a7);
        if (compare >= 0) {
            return k6;
        }
        return z0.k(k6 + i8);
    }

    private static final long b(long j6, long j7, long j8) {
        int compare;
        long a6 = s0.a(j6, j8);
        long a7 = s0.a(j7, j8);
        compare = Long.compare(a6 ^ Long.MIN_VALUE, a7 ^ Long.MIN_VALUE);
        long k6 = d1.k(a6 - a7);
        if (compare >= 0) {
            return k6;
        }
        return d1.k(k6 + j8);
    }
}
