package kotlin.random;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.d1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.ranges.b0;
import kotlin.ranges.y;
import kotlin.w0;
import kotlin.z0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nURandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URandom.kt\nkotlin/random/URandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,147:1\n1#2:148\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] c(@NotNull Random random, int i6) {
        g0.p(random, "<this>");
        return w0.f(random.nextBytes(i6));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] d(@NotNull Random nextUBytes, @NotNull byte[] bArr) {
        g0.p(nextUBytes, "$this$nextUBytes");
        g0.p(bArr, "$v$c$kotlin-UByteArray$-array$0");
        nextUBytes.nextBytes(bArr);
        return bArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] e(@NotNull Random nextUBytes, @NotNull byte[] bArr, int i6, int i7) {
        g0.p(nextUBytes, "$this$nextUBytes");
        g0.p(bArr, "$v$c$kotlin-UByteArray$-array$0");
        nextUBytes.nextBytes(bArr, i6, i7);
        return bArr;
    }

    public static /* synthetic */ byte[] f(Random random, byte[] bArr, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = w0.r(bArr);
        }
        return e(random, bArr, i6, i7);
    }

    @SinceKotlin(version = "1.5")
    public static final int g(@NotNull Random random) {
        g0.p(random, "<this>");
        return z0.k(random.nextInt());
    }

    @SinceKotlin(version = "1.5")
    public static final int h(@NotNull Random random, @NotNull y range) {
        int compare;
        int compare2;
        g0.p(random, "<this>");
        g0.p(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        compare = Integer.compare(range.f() ^ Integer.MIN_VALUE, (-1) ^ Integer.MIN_VALUE);
        if (compare < 0) {
            return i(random, range.e(), z0.k(range.f() + 1));
        }
        compare2 = Integer.compare(range.e() ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
        return compare2 > 0 ? z0.k(i(random, z0.k(range.e() - 1), range.f()) + 1) : g(random);
    }

    @SinceKotlin(version = "1.5")
    public static final int i(@NotNull Random nextUInt, int i6, int i7) {
        g0.p(nextUInt, "$this$nextUInt");
        a(i6, i7);
        return z0.k(nextUInt.nextInt(i6 ^ Integer.MIN_VALUE, i7 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    public static final int j(@NotNull Random nextUInt, int i6) {
        g0.p(nextUInt, "$this$nextUInt");
        return i(nextUInt, 0, i6);
    }

    @SinceKotlin(version = "1.5")
    public static final long k(@NotNull Random random) {
        g0.p(random, "<this>");
        return d1.k(random.nextLong());
    }

    @SinceKotlin(version = "1.5")
    public static final long l(@NotNull Random random, @NotNull b0 range) {
        int compare;
        int compare2;
        g0.p(random, "<this>");
        g0.p(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        compare = Long.compare(range.f() ^ Long.MIN_VALUE, (-1) ^ Long.MIN_VALUE);
        if (compare < 0) {
            return n(random, range.e(), d1.k(range.f() + d1.k(4294967295L & 1)));
        }
        compare2 = Long.compare(range.e() ^ Long.MIN_VALUE, 0 ^ Long.MIN_VALUE);
        if (compare2 <= 0) {
            return k(random);
        }
        long j6 = 4294967295L & 1;
        return d1.k(n(random, d1.k(range.e() - d1.k(j6)), range.f()) + d1.k(j6));
    }

    @SinceKotlin(version = "1.5")
    public static final long m(@NotNull Random nextULong, long j6) {
        g0.p(nextULong, "$this$nextULong");
        return n(nextULong, 0L, j6);
    }

    @SinceKotlin(version = "1.5")
    public static final long n(@NotNull Random nextULong, long j6, long j7) {
        g0.p(nextULong, "$this$nextULong");
        b(j6, j7);
        return d1.k(nextULong.nextLong(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    public static final void a(int i6, int i7) {
        int compare;
        compare = Integer.compare(i7 ^ Integer.MIN_VALUE, i6 ^ Integer.MIN_VALUE);
        if (compare > 0) {
        } else {
            throw new IllegalArgumentException(f.c(z0.b(i6), z0.b(i7)).toString());
        }
    }

    public static final void b(long j6, long j7) {
        int compare;
        compare = Long.compare(j7 ^ Long.MIN_VALUE, j6 ^ Long.MIN_VALUE);
        if (compare > 0) {
        } else {
            throw new IllegalArgumentException(f.c(d1.b(j6), d1.b(j7)).toString());
        }
    }
}
