package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.SinceKotlin;
import kotlin.d1;
import kotlin.internal.InlineOnly;
import kotlin.j1;
import kotlin.jvm.internal.g0;
import kotlin.random.Random;
import kotlin.ranges.w;
import kotlin.ranges.z;
import kotlin.v0;
import kotlin.z0;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class d0 {
    @SinceKotlin(version = "1.5")
    @NotNull
    public static y V(int i6, int i7) {
        int compare;
        compare = Integer.compare(i7 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
        return compare <= 0 ? y.f44207e.a() : new y(i6, z0.k(i7 - 1), null);
    }

    @SinceKotlin(version = "1.7")
    public static final int A(@NotNull w wVar) {
        g0.p(wVar, "<this>");
        if (!wVar.isEmpty()) {
            return wVar.e();
        }
        throw new NoSuchElementException("Progression " + wVar + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final long B(@NotNull z zVar) {
        g0.p(zVar, "<this>");
        if (!zVar.isEmpty()) {
            return zVar.e();
        }
        throw new NoSuchElementException("Progression " + zVar + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final z0 C(@NotNull w wVar) {
        g0.p(wVar, "<this>");
        if (wVar.isEmpty()) {
            return null;
        }
        return z0.b(wVar.e());
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final d1 D(@NotNull z zVar) {
        g0.p(zVar, "<this>");
        if (zVar.isEmpty()) {
            return null;
        }
        return d1.b(zVar.e());
    }

    @SinceKotlin(version = "1.7")
    public static final int E(@NotNull w wVar) {
        g0.p(wVar, "<this>");
        if (!wVar.isEmpty()) {
            return wVar.f();
        }
        throw new NoSuchElementException("Progression " + wVar + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final long F(@NotNull z zVar) {
        g0.p(zVar, "<this>");
        if (!zVar.isEmpty()) {
            return zVar.f();
        }
        throw new NoSuchElementException("Progression " + zVar + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final z0 G(@NotNull w wVar) {
        g0.p(wVar, "<this>");
        if (wVar.isEmpty()) {
            return null;
        }
        return z0.b(wVar.f());
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final d1 H(@NotNull z zVar) {
        g0.p(zVar, "<this>");
        if (zVar.isEmpty()) {
            return null;
        }
        return d1.b(zVar.f());
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int I(y yVar) {
        g0.p(yVar, "<this>");
        return J(yVar, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    public static final int J(@NotNull y yVar, @NotNull Random random) {
        g0.p(yVar, "<this>");
        g0.p(random, "random");
        try {
            return kotlin.random.g.h(random, yVar);
        } catch (IllegalArgumentException e6) {
            throw new NoSuchElementException(e6.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long K(b0 b0Var) {
        g0.p(b0Var, "<this>");
        return L(b0Var, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    public static final long L(@NotNull b0 b0Var, @NotNull Random random) {
        g0.p(b0Var, "<this>");
        g0.p(random, "random");
        try {
            return kotlin.random.g.l(random, b0Var);
        } catch (IllegalArgumentException e6) {
            throw new NoSuchElementException(e6.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final z0 M(y yVar) {
        g0.p(yVar, "<this>");
        return N(yVar, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final z0 N(@NotNull y yVar, @NotNull Random random) {
        g0.p(yVar, "<this>");
        g0.p(random, "random");
        if (yVar.isEmpty()) {
            return null;
        }
        return z0.b(kotlin.random.g.h(random, yVar));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final d1 O(b0 b0Var) {
        g0.p(b0Var, "<this>");
        return P(b0Var, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final d1 P(@NotNull b0 b0Var, @NotNull Random random) {
        g0.p(b0Var, "<this>");
        g0.p(random, "random");
        if (b0Var.isEmpty()) {
            return null;
        }
        return d1.b(kotlin.random.g.l(random, b0Var));
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final w Q(@NotNull w wVar) {
        g0.p(wVar, "<this>");
        return w.f44199d.a(wVar.f(), wVar.e(), -wVar.g());
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final z R(@NotNull z zVar) {
        g0.p(zVar, "<this>");
        return z.f44209d.a(zVar.f(), zVar.e(), -zVar.g());
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final w S(@NotNull w wVar, int i6) {
        g0.p(wVar, "<this>");
        u.a(i6 > 0, Integer.valueOf(i6));
        w.a aVar = w.f44199d;
        int e6 = wVar.e();
        int f6 = wVar.f();
        if (wVar.g() <= 0) {
            i6 = -i6;
        }
        return aVar.a(e6, f6, i6);
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final z T(@NotNull z zVar, long j6) {
        g0.p(zVar, "<this>");
        u.a(j6 > 0, Long.valueOf(j6));
        z.a aVar = z.f44209d;
        long e6 = zVar.e();
        long f6 = zVar.f();
        if (zVar.g() <= 0) {
            j6 = -j6;
        }
        return aVar.a(e6, f6, j6);
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final y W(byte b6, byte b7) {
        return g0.t(b7 & 255, 0) <= 0 ? y.f44207e.a() : new y(z0.k(b6 & 255), z0.k(z0.k(r3) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static b0 X(long j6, long j7) {
        int compare;
        compare = Long.compare(j7 ^ Long.MIN_VALUE, 0 ^ Long.MIN_VALUE);
        return compare <= 0 ? b0.f44163e.a() : new b0(j6, d1.k(j7 - d1.k(1 & 4294967295L)), null);
    }

    @SinceKotlin(version = "1.5")
    public static final byte c(byte b6, byte b7) {
        return g0.t(b6 & 255, b7 & 255) < 0 ? b7 : b6;
    }

    @SinceKotlin(version = "1.5")
    public static final byte g(byte b6, byte b7) {
        return g0.t(b6 & 255, b7 & 255) > 0 ? b7 : b6;
    }

    @SinceKotlin(version = "1.5")
    public static final long i(long j6, @NotNull h<d1> range) {
        int compare;
        int compare2;
        g0.p(range, "range");
        if (range instanceof g) {
            return ((d1) v.N(d1.b(j6), (g) range)).q0();
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        compare = Long.compare(j6 ^ Long.MIN_VALUE, range.getStart().q0() ^ Long.MIN_VALUE);
        if (compare < 0) {
            return range.getStart().q0();
        }
        compare2 = Long.compare(j6 ^ Long.MIN_VALUE, range.getEndInclusive().q0() ^ Long.MIN_VALUE);
        return compare2 > 0 ? range.getEndInclusive().q0() : j6;
    }

    @SinceKotlin(version = "1.5")
    public static final byte l(byte b6, byte b7, byte b8) {
        int i6 = b7 & 255;
        int i7 = b8 & 255;
        if (g0.t(i6, i7) <= 0) {
            int i8 = b6 & 255;
            return g0.t(i8, i6) < 0 ? b7 : g0.t(i8, i7) > 0 ? b8 : b6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) v0.j0(b8)) + " is less than minimum " + ((Object) v0.j0(b7)) + '.');
    }

    @SinceKotlin(version = "1.5")
    public static final int n(int i6, @NotNull h<z0> range) {
        int compare;
        int compare2;
        g0.p(range, "range");
        if (range instanceof g) {
            return ((z0) v.N(z0.b(i6), (g) range)).q0();
        }
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
        }
        compare = Integer.compare(i6 ^ Integer.MIN_VALUE, range.getStart().q0() ^ Integer.MIN_VALUE);
        if (compare < 0) {
            return range.getStart().q0();
        }
        compare2 = Integer.compare(i6 ^ Integer.MIN_VALUE, range.getEndInclusive().q0() ^ Integer.MIN_VALUE);
        return compare2 > 0 ? range.getEndInclusive().q0() : i6;
    }

    @SinceKotlin(version = "1.5")
    public static final boolean o(@NotNull y contains, byte b6) {
        g0.p(contains, "$this$contains");
        return contains.m(z0.k(b6 & 255));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final boolean p(b0 contains, d1 d1Var) {
        g0.p(contains, "$this$contains");
        return d1Var != null && contains.m(d1Var.q0());
    }

    @SinceKotlin(version = "1.5")
    public static final boolean q(@NotNull b0 contains, int i6) {
        g0.p(contains, "$this$contains");
        return contains.m(d1.k(i6 & 4294967295L));
    }

    @SinceKotlin(version = "1.5")
    public static final boolean r(@NotNull b0 contains, byte b6) {
        g0.p(contains, "$this$contains");
        return contains.m(d1.k(b6 & 255));
    }

    @SinceKotlin(version = "1.5")
    public static final boolean s(@NotNull y contains, short s5) {
        g0.p(contains, "$this$contains");
        return contains.m(z0.k(s5 & j1.f43986d));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final boolean t(y contains, z0 z0Var) {
        g0.p(contains, "$this$contains");
        return z0Var != null && contains.m(z0Var.q0());
    }

    @SinceKotlin(version = "1.5")
    public static final boolean u(@NotNull y contains, long j6) {
        g0.p(contains, "$this$contains");
        return d1.k(j6 >>> 32) == 0 && contains.m(z0.k((int) j6));
    }

    @SinceKotlin(version = "1.5")
    public static final boolean v(@NotNull b0 contains, short s5) {
        g0.p(contains, "$this$contains");
        return contains.m(d1.k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final w w(short s5, short s6) {
        return w.f44199d.a(z0.k(s5 & j1.f43986d), z0.k(s6 & j1.f43986d), -1);
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final w x(int i6, int i7) {
        return w.f44199d.a(i6, i7, -1);
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final w y(byte b6, byte b7) {
        return w.f44199d.a(z0.k(b6 & 255), z0.k(b7 & 255), -1);
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final z z(long j6, long j7) {
        return z.f44209d.a(j6, j7, -1L);
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final y U(short s5, short s6) {
        if (g0.t(s6 & j1.f43986d, 0) <= 0) {
            return y.f44207e.a();
        }
        return new y(z0.k(s5 & j1.f43986d), z0.k(z0.k(r3) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    public static final short a(short s5, short s6) {
        if (g0.t(s5 & j1.f43986d, 65535 & s6) < 0) {
            return s6;
        }
        return s5;
    }

    @SinceKotlin(version = "1.5")
    public static final int b(int i6, int i7) {
        int compare;
        compare = Integer.compare(i6 ^ Integer.MIN_VALUE, i7 ^ Integer.MIN_VALUE);
        if (compare < 0) {
            return i7;
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    public static final long d(long j6, long j7) {
        int compare;
        compare = Long.compare(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE);
        if (compare < 0) {
            return j7;
        }
        return j6;
    }

    @SinceKotlin(version = "1.5")
    public static final short e(short s5, short s6) {
        if (g0.t(s5 & j1.f43986d, 65535 & s6) > 0) {
            return s6;
        }
        return s5;
    }

    @SinceKotlin(version = "1.5")
    public static final int f(int i6, int i7) {
        int compare;
        compare = Integer.compare(i6 ^ Integer.MIN_VALUE, i7 ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return i7;
        }
        return i6;
    }

    @SinceKotlin(version = "1.5")
    public static final long h(long j6, long j7) {
        int compare;
        compare = Long.compare(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE);
        if (compare > 0) {
            return j7;
        }
        return j6;
    }

    @SinceKotlin(version = "1.5")
    public static final short j(short s5, short s6, short s7) {
        int i6 = s6 & j1.f43986d;
        int i7 = s7 & j1.f43986d;
        if (g0.t(i6, i7) <= 0) {
            int i8 = 65535 & s5;
            if (g0.t(i8, i6) < 0) {
                return s6;
            }
            if (g0.t(i8, i7) > 0) {
                return s7;
            }
            return s5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) j1.j0(s7)) + " is less than minimum " + ((Object) j1.j0(s6)) + '.');
    }

    @SinceKotlin(version = "1.5")
    public static final int k(int i6, int i7, int i8) {
        int compare;
        int compare2;
        int compare3;
        compare = Integer.compare(i7 ^ Integer.MIN_VALUE, i8 ^ Integer.MIN_VALUE);
        if (compare <= 0) {
            compare2 = Integer.compare(i6 ^ Integer.MIN_VALUE, i7 ^ Integer.MIN_VALUE);
            if (compare2 >= 0) {
                compare3 = Integer.compare(i6 ^ Integer.MIN_VALUE, i8 ^ Integer.MIN_VALUE);
                if (compare3 > 0) {
                    return i8;
                }
                return i6;
            }
            return i7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) z0.l0(i8)) + " is less than minimum " + ((Object) z0.l0(i7)) + '.');
    }

    @SinceKotlin(version = "1.5")
    public static final long m(long j6, long j7, long j8) {
        int compare;
        int compare2;
        int compare3;
        compare = Long.compare(j7 ^ Long.MIN_VALUE, j8 ^ Long.MIN_VALUE);
        if (compare <= 0) {
            compare2 = Long.compare(j6 ^ Long.MIN_VALUE, j7 ^ Long.MIN_VALUE);
            if (compare2 >= 0) {
                compare3 = Long.compare(j6 ^ Long.MIN_VALUE, j8 ^ Long.MIN_VALUE);
                if (compare3 > 0) {
                    return j8;
                }
                return j6;
            }
            return j7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) d1.l0(j8)) + " is less than minimum " + ((Object) d1.l0(j7)) + '.');
    }
}
