package kotlin.random;

import kotlin.SinceKotlin;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.ranges.m;
import kotlin.ranges.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/RandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,387:1\n1#2:388\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final Random a(int i6) {
        return new XorWowRandom(i6, i6 >> 31);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final Random b(long j6) {
        return new XorWowRandom((int) j6, (int) (j6 >> 32));
    }

    @NotNull
    public static final String c(@NotNull Object from, @NotNull Object until) {
        g0.p(from, "from");
        g0.p(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void d(double d6, double d7) {
        if (d7 <= d6) {
            throw new IllegalArgumentException(c(Double.valueOf(d6), Double.valueOf(d7)).toString());
        }
    }

    public static final void e(int i6, int i7) {
        if (i7 <= i6) {
            throw new IllegalArgumentException(c(Integer.valueOf(i6), Integer.valueOf(i7)).toString());
        }
    }

    public static final void f(long j6, long j7) {
        if (j7 <= j6) {
            throw new IllegalArgumentException(c(Long.valueOf(j6), Long.valueOf(j7)).toString());
        }
    }

    @SinceKotlin(version = "1.3")
    public static final int h(@NotNull Random random, @NotNull m range) {
        g0.p(random, "<this>");
        g0.p(range, "range");
        if (!range.isEmpty()) {
            return range.f() < Integer.MAX_VALUE ? random.nextInt(range.e(), range.f() + 1) : range.e() > Integer.MIN_VALUE ? random.nextInt(range.e() - 1, range.f()) + 1 : random.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @SinceKotlin(version = "1.3")
    public static final long i(@NotNull Random random, @NotNull p range) {
        g0.p(random, "<this>");
        g0.p(range, "range");
        if (!range.isEmpty()) {
            return range.f() < Long.MAX_VALUE ? random.nextLong(range.e(), range.f() + 1) : range.e() > Long.MIN_VALUE ? random.nextLong(range.e() - 1, range.f()) + 1 : random.nextLong();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int j(int i6, int i7) {
        return (i6 >>> (32 - i7)) & ((-i7) >> 31);
    }

    public static final int g(int i6) {
        return 31 - Integer.numberOfLeadingZeros(i6);
    }
}
