package kotlin.time;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.h;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,81:1\n80#1:82\n80#1:83\n80#1:84\n80#1:85\n80#1:86\n80#1:87\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n14#1:82\n17#1:83\n36#1:84\n46#1:85\n53#1:86\n57#1:87\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y {
    private static final long e(long j6, DurationUnit durationUnit, long j7) {
        long o5 = h.o(j7, 2);
        long i02 = h.i0(o5, durationUnit);
        return (1 | (i02 - 1)) == Long.MAX_VALUE ? i02 : d(d(j6, durationUnit, o5), durationUnit, h.X(j7, o5));
    }

    private static final long b(long j6) {
        h.a aVar = h.f48019b;
        return j6 < 0 ? aVar.G() : aVar.n();
    }

    public static final boolean c(long j6) {
        return ((j6 - 1) | 1) == Long.MAX_VALUE;
    }

    public static final long d(long j6, @NotNull DurationUnit unit, long j7) {
        kotlin.jvm.internal.g0.p(unit, "unit");
        long i02 = h.i0(j7, unit);
        if (((j6 - 1) | 1) == Long.MAX_VALUE) {
            return a(j6, j7, i02);
        }
        if (((i02 - 1) | 1) == Long.MAX_VALUE) {
            return e(j6, unit, j7);
        }
        long j8 = j6 + i02;
        return ((j6 ^ j8) & (i02 ^ j8)) < 0 ? j6 < 0 ? Long.MIN_VALUE : Long.MAX_VALUE : j8;
    }

    public static final long f(long j6, long j7, @NotNull DurationUnit unit) {
        kotlin.jvm.internal.g0.p(unit, "unit");
        return (1 | (j7 - 1)) == Long.MAX_VALUE ? h.n0(b(j7)) : g(j6, j7, unit);
    }

    private static final long g(long j6, long j7, DurationUnit durationUnit) {
        long j8 = j6 - j7;
        if (((j8 ^ j6) & (~(j8 ^ j7))) >= 0) {
            return j.x(j8, durationUnit);
        }
        DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
        if (durationUnit.compareTo(durationUnit2) >= 0) {
            return h.n0(b(j8));
        }
        long b6 = l.b(1L, durationUnit2, durationUnit);
        long j9 = (j6 / b6) - (j7 / b6);
        long j10 = (j6 % b6) - (j7 % b6);
        h.a aVar = h.f48019b;
        return h.Y(j.x(j9, durationUnit2), j.x(j10, durationUnit));
    }

    public static final long h(long j6, long j7, @NotNull DurationUnit unit) {
        kotlin.jvm.internal.g0.p(unit, "unit");
        return ((j7 - 1) | 1) == Long.MAX_VALUE ? j6 == j7 ? h.f48019b.T() : h.n0(b(j7)) : (1 | (j6 - 1)) == Long.MAX_VALUE ? b(j6) : g(j6, j7, unit);
    }

    private static final long a(long j6, long j7, long j8) {
        if (h.U(j7) && (j6 ^ j8) < 0) {
            throw new IllegalArgumentException("Summing infinities of different signs");
        }
        return j6;
    }
}
