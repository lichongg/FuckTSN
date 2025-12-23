package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "UnsignedKt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o1 {
    @PublishedApi
    @InlineOnly
    private static final int c(float f6) {
        return a(f6);
    }

    @PublishedApi
    @InlineOnly
    private static final long d(float f6) {
        return b(f6);
    }

    @PublishedApi
    public static final int f(int i6, int i7) {
        return z0.k((int) ((i6 & 4294967295L) / (i7 & 4294967295L)));
    }

    @PublishedApi
    public static final int g(int i6, int i7) {
        return z0.k((int) ((i6 & 4294967295L) % (i7 & 4294967295L)));
    }

    @PublishedApi
    @InlineOnly
    private static final long j(int i6) {
        return i6 & 4294967295L;
    }

    @InlineOnly
    private static final String k(int i6) {
        return String.valueOf(i6 & 4294967295L);
    }

    @InlineOnly
    private static final String l(int i6, int i7) {
        return t(i6 & 4294967295L, i7);
    }

    @PublishedApi
    @InlineOnly
    private static final long m(int i6) {
        return d1.k(i6 & 4294967295L);
    }

    @PublishedApi
    public static final int e(int i6, int i7) {
        return kotlin.jvm.internal.g0.t(i6 ^ Integer.MIN_VALUE, i7 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    public static final int n(long j6, long j7) {
        return kotlin.jvm.internal.g0.u(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    public static final long o(long j6, long j7) {
        int compare;
        int compare2;
        if (j7 < 0) {
            compare2 = Long.compare(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE);
            return compare2 < 0 ? d1.k(0L) : d1.k(1L);
        }
        if (j6 >= 0) {
            return d1.k(j6 / j7);
        }
        long j8 = ((j6 >>> 1) / j7) << 1;
        compare = Long.compare(d1.k(j6 - (j8 * j7)) ^ Long.MIN_VALUE, d1.k(j7) ^ Long.MIN_VALUE);
        return d1.k(j8 + (compare < 0 ? 0 : 1));
    }

    @PublishedApi
    public static final long p(long j6, long j7) {
        int compare;
        int compare2;
        if (j7 < 0) {
            compare2 = Long.compare(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE);
            return compare2 < 0 ? j6 : d1.k(j6 - j7);
        }
        if (j6 >= 0) {
            return d1.k(j6 % j7);
        }
        long j8 = j6 - ((((j6 >>> 1) / j7) << 1) * j7);
        compare = Long.compare(d1.k(j8) ^ Long.MIN_VALUE, d1.k(j7) ^ Long.MIN_VALUE);
        if (compare < 0) {
            j7 = 0;
        }
        return d1.k(j8 - j7);
    }

    @PublishedApi
    public static final double q(long j6) {
        return ((j6 >>> 11) * 2048) + (j6 & 2047);
    }

    @InlineOnly
    private static final String s(long j6) {
        return t(j6, 10);
    }

    @NotNull
    public static final String t(long j6, int i6) {
        if (j6 >= 0) {
            String l6 = Long.toString(j6, kotlin.text.b.a(i6));
            kotlin.jvm.internal.g0.o(l6, "toString(...)");
            return l6;
        }
        long j7 = i6;
        long j8 = ((j6 >>> 1) / j7) << 1;
        long j9 = j6 - (j8 * j7);
        if (j9 >= j7) {
            j9 -= j7;
            j8++;
        }
        StringBuilder sb = new StringBuilder();
        String l7 = Long.toString(j8, kotlin.text.b.a(i6));
        kotlin.jvm.internal.g0.o(l7, "toString(...)");
        sb.append(l7);
        String l8 = Long.toString(j9, kotlin.text.b.a(i6));
        kotlin.jvm.internal.g0.o(l8, "toString(...)");
        sb.append(l8);
        return sb.toString();
    }

    @PublishedApi
    public static final int a(double d6) {
        if (Double.isNaN(d6) || d6 <= h(0)) {
            return 0;
        }
        if (d6 >= h(-1)) {
            return -1;
        }
        if (d6 <= 2.147483647E9d) {
            return z0.k((int) d6);
        }
        return z0.k(z0.k((int) (d6 - Integer.MAX_VALUE)) + z0.k(Integer.MAX_VALUE));
    }

    @PublishedApi
    public static final long b(double d6) {
        if (Double.isNaN(d6) || d6 <= q(0L)) {
            return 0L;
        }
        if (d6 >= q(-1L)) {
            return -1L;
        }
        if (d6 < 9.223372036854776E18d) {
            return d1.k((long) d6);
        }
        return d1.k(d1.k((long) (d6 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @PublishedApi
    public static final double h(int i6) {
        return (Integer.MAX_VALUE & i6) + (((i6 >>> 31) << 30) * 2);
    }

    @PublishedApi
    @InlineOnly
    private static final float i(int i6) {
        return (float) h(i6);
    }

    @PublishedApi
    @InlineOnly
    private static final float r(long j6) {
        return (float) q(j6);
    }
}
