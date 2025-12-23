package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.primitives.Longs;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
@JvmInline
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1062:1\n37#1:1063\n37#1:1064\n37#1:1065\n37#1:1066\n37#1:1067\n500#1:1068\n517#1:1076\n170#2,6:1069\n1#3:1075\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n*L\n38#1:1063\n39#1:1064\n274#1:1065\n294#1:1066\n478#1:1067\n727#1:1068\n818#1:1076\n769#1:1069,6\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h implements Comparable<h> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f48019b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final long f48020c = l(0);

    /* renamed from: d, reason: collision with root package name */
    private static final long f48021d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f48022e;

    /* renamed from: a, reason: collision with root package name */
    private final long f48023a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        private final long A(double d6) {
            return j.v(d6, DurationUnit.MINUTES);
        }

        private final long B(int i6) {
            return j.w(i6, DurationUnit.MINUTES);
        }

        private final long C(long j6) {
            return j.x(j6, DurationUnit.MINUTES);
        }

        private final long H(double d6) {
            return j.v(d6, DurationUnit.NANOSECONDS);
        }

        private final long I(int i6) {
            return j.w(i6, DurationUnit.NANOSECONDS);
        }

        private final long J(long j6) {
            return j.x(j6, DurationUnit.NANOSECONDS);
        }

        private final long N(double d6) {
            return j.v(d6, DurationUnit.SECONDS);
        }

        private final long O(int i6) {
            return j.w(i6, DurationUnit.SECONDS);
        }

        private final long P(long j6) {
            return j.x(j6, DurationUnit.SECONDS);
        }

        private final long b(double d6) {
            return j.v(d6, DurationUnit.DAYS);
        }

        private final long c(int i6) {
            return j.w(i6, DurationUnit.DAYS);
        }

        private final long d(long j6) {
            return j.x(j6, DurationUnit.DAYS);
        }

        private final long h(double d6) {
            return j.v(d6, DurationUnit.HOURS);
        }

        private final long i(int i6) {
            return j.w(i6, DurationUnit.HOURS);
        }

        private final long j(long j6) {
            return j.x(j6, DurationUnit.HOURS);
        }

        private final long o(double d6) {
            return j.v(d6, DurationUnit.MICROSECONDS);
        }

        private final long p(int i6) {
            return j.w(i6, DurationUnit.MICROSECONDS);
        }

        private final long q(long j6) {
            return j.x(j6, DurationUnit.MICROSECONDS);
        }

        private final long u(double d6) {
            return j.v(d6, DurationUnit.MILLISECONDS);
        }

        private final long v(int i6) {
            return j.w(i6, DurationUnit.MILLISECONDS);
        }

        private final long w(long j6) {
            return j.x(j6, DurationUnit.MILLISECONDS);
        }

        public final long U(@NotNull String value) {
            long p5;
            kotlin.jvm.internal.g0.p(value, "value");
            try {
                p5 = j.p(value, false);
                return p5;
            } catch (IllegalArgumentException e6) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e6);
            }
        }

        public final long V(@NotNull String value) {
            long p5;
            kotlin.jvm.internal.g0.p(value, "value");
            try {
                p5 = j.p(value, true);
                return p5;
            } catch (IllegalArgumentException e6) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e6);
            }
        }

        @Nullable
        public final h W(@NotNull String value) {
            long p5;
            kotlin.jvm.internal.g0.p(value, "value");
            try {
                p5 = j.p(value, true);
                return h.i(p5);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @Nullable
        public final h X(@NotNull String value) {
            long p5;
            kotlin.jvm.internal.g0.p(value, "value");
            try {
                p5 = j.p(value, false);
                return h.i(p5);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @ExperimentalTime
        public final double a(double d6, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
            kotlin.jvm.internal.g0.p(sourceUnit, "sourceUnit");
            kotlin.jvm.internal.g0.p(targetUnit, "targetUnit");
            return l.a(d6, sourceUnit, targetUnit);
        }

        public final long G() {
            return h.f48022e;
        }

        public final long T() {
            return h.f48020c;
        }

        public final long n() {
            return h.f48021d;
        }

        @InlineOnly
        public static /* synthetic */ void D(double d6) {
        }

        @InlineOnly
        public static /* synthetic */ void E(int i6) {
        }

        @InlineOnly
        public static /* synthetic */ void F(long j6) {
        }

        @InlineOnly
        public static /* synthetic */ void K(double d6) {
        }

        @InlineOnly
        public static /* synthetic */ void L(int i6) {
        }

        @InlineOnly
        public static /* synthetic */ void M(long j6) {
        }

        @InlineOnly
        public static /* synthetic */ void Q(double d6) {
        }

        @InlineOnly
        public static /* synthetic */ void R(int i6) {
        }

        @InlineOnly
        public static /* synthetic */ void S(long j6) {
        }

        @InlineOnly
        public static /* synthetic */ void e(double d6) {
        }

        @InlineOnly
        public static /* synthetic */ void f(int i6) {
        }

        @InlineOnly
        public static /* synthetic */ void g(long j6) {
        }

        @InlineOnly
        public static /* synthetic */ void k(double d6) {
        }

        @InlineOnly
        public static /* synthetic */ void l(int i6) {
        }

        @InlineOnly
        public static /* synthetic */ void m(long j6) {
        }

        @InlineOnly
        public static /* synthetic */ void r(double d6) {
        }

        @InlineOnly
        public static /* synthetic */ void s(int i6) {
        }

        @InlineOnly
        public static /* synthetic */ void t(long j6) {
        }

        @InlineOnly
        public static /* synthetic */ void x(double d6) {
        }

        @InlineOnly
        public static /* synthetic */ void y(int i6) {
        }

        @InlineOnly
        public static /* synthetic */ void z(long j6) {
        }
    }

    private static final int M(long j6) {
        return ((int) j6) & 1;
    }

    private static final long O(long j6) {
        return j6 >> 1;
    }

    private static final boolean S(long j6) {
        return (((int) j6) & 1) == 1;
    }

    private static final boolean T(long j6) {
        return (((int) j6) & 1) == 0;
    }

    static {
        long j6;
        long j7;
        j6 = j.j(j.f48028c);
        f48021d = j6;
        j7 = j.j(-4611686018427387903L);
        f48022e = j7;
    }

    public static final long C(long j6) {
        return i0(j6, DurationUnit.SECONDS);
    }

    public static final boolean U(long j6) {
        return j6 == f48021d || j6 == f48022e;
    }

    public static final boolean V(long j6) {
        return j6 < 0;
    }

    public static final boolean W(long j6) {
        return j6 > 0;
    }

    public static final <T> T b0(long j6, @NotNull Function2<? super Long, ? super Integer, ? extends T> action) {
        kotlin.jvm.internal.g0.p(action, "action");
        return action.invoke(Long.valueOf(C(j6)), Integer.valueOf(I(j6)));
    }

    public static final <T> T c0(long j6, @NotNull Function3<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        kotlin.jvm.internal.g0.p(action, "action");
        return action.invoke(Long.valueOf(y(j6)), Integer.valueOf(K(j6)), Integer.valueOf(I(j6)));
    }

    public static final <T> T d0(long j6, @NotNull Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        kotlin.jvm.internal.g0.p(action, "action");
        return action.invoke(Long.valueOf(v(j6)), Integer.valueOf(E(j6)), Integer.valueOf(K(j6)), Integer.valueOf(I(j6)));
    }

    public static final <T> T e0(long j6, @NotNull Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        kotlin.jvm.internal.g0.p(action, "action");
        return action.invoke(Long.valueOf(u(j6)), Integer.valueOf(t(j6)), Integer.valueOf(E(j6)), Integer.valueOf(K(j6)), Integer.valueOf(I(j6)));
    }

    public static final double f0(long j6, @NotNull DurationUnit unit) {
        kotlin.jvm.internal.g0.p(unit, "unit");
        if (j6 == f48021d) {
            return Double.POSITIVE_INFINITY;
        }
        if (j6 == f48022e) {
            return Double.NEGATIVE_INFINITY;
        }
        return l.a(O(j6), L(j6), unit);
    }

    public static final int g0(long j6, @NotNull DurationUnit unit) {
        kotlin.jvm.internal.g0.p(unit, "unit");
        return (int) kotlin.ranges.t.K(i0(j6, unit), -2147483648L, 2147483647L);
    }

    @NotNull
    public static final String h0(long j6) {
        StringBuilder sb = new StringBuilder();
        if (V(j6)) {
            sb.append('-');
        }
        sb.append("PT");
        long r5 = r(j6);
        long v5 = v(r5);
        int E = E(r5);
        int K = K(r5);
        int I = I(r5);
        long j7 = U(j6) ? 9999999999999L : v5;
        boolean z5 = false;
        boolean z6 = j7 != 0;
        boolean z7 = (K == 0 && I == 0) ? false : true;
        if (E != 0 || (z7 && z6)) {
            z5 = true;
        }
        if (z6) {
            sb.append(j7);
            sb.append('H');
        }
        if (z5) {
            sb.append(E);
            sb.append('M');
        }
        if (z7 || (!z6 && !z5)) {
            h(j6, sb, K, I, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        return sb.toString();
    }

    public static final /* synthetic */ h i(long j6) {
        return new h(j6);
    }

    public static final long i0(long j6, @NotNull DurationUnit unit) {
        kotlin.jvm.internal.g0.p(unit, "unit");
        if (j6 == f48021d) {
            return Long.MAX_VALUE;
        }
        if (j6 == f48022e) {
            return Long.MIN_VALUE;
        }
        return l.b(O(j6), L(j6), unit);
    }

    @NotNull
    public static String j0(long j6) {
        if (j6 == 0) {
            return "0s";
        }
        if (j6 == f48021d) {
            return "Infinity";
        }
        if (j6 == f48022e) {
            return "-Infinity";
        }
        boolean V = V(j6);
        StringBuilder sb = new StringBuilder();
        if (V) {
            sb.append('-');
        }
        long r5 = r(j6);
        long u5 = u(r5);
        int t5 = t(r5);
        int E = E(r5);
        int K = K(r5);
        int I = I(r5);
        int i6 = 0;
        boolean z5 = u5 != 0;
        boolean z6 = t5 != 0;
        boolean z7 = E != 0;
        boolean z8 = (K == 0 && I == 0) ? false : true;
        if (z5) {
            sb.append(u5);
            sb.append('d');
            i6 = 1;
        }
        if (z6 || (z5 && (z7 || z8))) {
            int i7 = i6 + 1;
            if (i6 > 0) {
                sb.append(' ');
            }
            sb.append(t5);
            sb.append('h');
            i6 = i7;
        }
        if (z7 || (z8 && (z6 || z5))) {
            int i8 = i6 + 1;
            if (i6 > 0) {
                sb.append(' ');
            }
            sb.append(E);
            sb.append('m');
            i6 = i8;
        }
        if (z8) {
            int i9 = i6 + 1;
            if (i6 > 0) {
                sb.append(' ');
            }
            if (K != 0 || z5 || z6 || z7) {
                h(j6, sb, K, I, 9, "s", false);
            } else if (I >= 1000000) {
                h(j6, sb, I / 1000000, I % 1000000, 6, "ms", false);
            } else if (I >= 1000) {
                h(j6, sb, I / 1000, I % 1000, 3, "us", false);
            } else {
                sb.append(I);
                sb.append("ns");
            }
            i6 = i9;
        }
        if (V && i6 > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    public static int k(long j6, long j7) {
        long j8 = j6 ^ j7;
        if (j8 < 0 || (((int) j8) & 1) == 0) {
            return kotlin.jvm.internal.g0.u(j6, j7);
        }
        int i6 = (((int) j6) & 1) - (((int) j7) & 1);
        return V(j6) ? -i6 : i6;
    }

    @NotNull
    public static final String k0(long j6, @NotNull DurationUnit unit, int i6) {
        kotlin.jvm.internal.g0.p(unit, "unit");
        if (i6 < 0) {
            throw new IllegalArgumentException(("decimals must be not negative, but was " + i6).toString());
        }
        double f02 = f0(j6, unit);
        if (Double.isInfinite(f02)) {
            return String.valueOf(f02);
        }
        return i.b(f02, kotlin.ranges.t.B(i6, 12)) + m.h(unit);
    }

    public static /* synthetic */ String l0(long j6, DurationUnit durationUnit, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return k0(j6, durationUnit, i6);
    }

    public static final long m0(long j6, @NotNull DurationUnit unit) {
        kotlin.jvm.internal.g0.p(unit, "unit");
        DurationUnit L = L(j6);
        if (unit.compareTo(L) <= 0 || U(j6)) {
            return j6;
        }
        return j.x(O(j6) - (O(j6) % l.b(1L, unit, L)), L);
    }

    public static final long o(long j6, int i6) {
        long j7;
        long n6;
        long n7;
        long l6;
        long l7;
        if (i6 == 0) {
            if (W(j6)) {
                return f48021d;
            }
            if (V(j6)) {
                return f48022e;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (T(j6)) {
            l7 = j.l(O(j6) / i6);
            return l7;
        }
        if (U(j6)) {
            return a0(j6, kotlin.math.b.U(i6));
        }
        long j8 = i6;
        long O = O(j6) / j8;
        if (-4611686018426L > O || O >= 4611686018427L) {
            j7 = j.j(O);
            return j7;
        }
        n6 = j.n(O(j6) - (O * j8));
        n7 = j.n(O);
        l6 = j.l(n7 + (n6 / j8));
        return l6;
    }

    public static boolean p(long j6, Object obj) {
        return (obj instanceof h) && j6 == ((h) obj).o0();
    }

    public static final boolean q(long j6, long j7) {
        return j6 == j7;
    }

    public static final long u(long j6) {
        return i0(j6, DurationUnit.DAYS);
    }

    public static final long v(long j6) {
        return i0(j6, DurationUnit.HOURS);
    }

    public static final long w(long j6) {
        return i0(j6, DurationUnit.MICROSECONDS);
    }

    public static final long y(long j6) {
        return i0(j6, DurationUnit.MINUTES);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(h hVar) {
        return j(hVar.o0());
    }

    public boolean equals(Object obj) {
        return p(this.f48023a, obj);
    }

    public int hashCode() {
        return Q(this.f48023a);
    }

    public int j(long j6) {
        return k(this.f48023a, j6);
    }

    public final /* synthetic */ long o0() {
        return this.f48023a;
    }

    @NotNull
    public String toString() {
        return j0(this.f48023a);
    }

    private /* synthetic */ h(long j6) {
        this.f48023a = j6;
    }

    public static final int E(long j6) {
        if (U(j6)) {
            return 0;
        }
        return (int) (y(j6) % 60);
    }

    public static final int I(long j6) {
        long O;
        if (U(j6)) {
            return 0;
        }
        if (S(j6)) {
            O = j.n(O(j6) % 1000);
        } else {
            O = O(j6) % 1000000000;
        }
        return (int) O;
    }

    public static final int K(long j6) {
        if (U(j6)) {
            return 0;
        }
        return (int) (C(j6) % 60);
    }

    private static final DurationUnit L(long j6) {
        if (T(j6)) {
            return DurationUnit.NANOSECONDS;
        }
        return DurationUnit.MILLISECONDS;
    }

    public static int Q(long j6) {
        return androidx.camera.camera2.internal.compat.params.e.a(j6);
    }

    public static final boolean R(long j6) {
        return !U(j6);
    }

    public static final long X(long j6, long j7) {
        return Y(j6, n0(j7));
    }

    public static final long Y(long j6, long j7) {
        long k6;
        long m6;
        if (U(j6)) {
            if (!R(j7) && (j7 ^ j6) < 0) {
                throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
            }
            return j6;
        }
        if (U(j7)) {
            return j7;
        }
        if ((((int) j6) & 1) == (((int) j7) & 1)) {
            long O = O(j6) + O(j7);
            if (T(j6)) {
                m6 = j.m(O);
                return m6;
            }
            k6 = j.k(O);
            return k6;
        }
        if (S(j6)) {
            return d(j6, O(j6), O(j7));
        }
        return d(j6, O(j7), O(j6));
    }

    public static final long Z(long j6, double d6) {
        int K0 = kotlin.math.b.K0(d6);
        if (K0 == d6) {
            return a0(j6, K0);
        }
        DurationUnit L = L(j6);
        return j.v(f0(j6, L) * d6, L);
    }

    public static final long a0(long j6, int i6) {
        long j7;
        long o5;
        long n6;
        long o6;
        long j8;
        long m6;
        long l6;
        if (U(j6)) {
            if (i6 != 0) {
                if (i6 > 0) {
                    return j6;
                }
                return n0(j6);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i6 == 0) {
            return f48020c;
        }
        long O = O(j6);
        long j9 = i6;
        long j10 = O * j9;
        if (T(j6)) {
            if (-2147483647L <= O && O < IjkMediaMeta.AV_CH_WIDE_LEFT) {
                l6 = j.l(j10);
                return l6;
            }
            if (j10 / j9 == O) {
                m6 = j.m(j10);
                return m6;
            }
            o5 = j.o(O);
            n6 = j.n(o5);
            long j11 = o5 * j9;
            o6 = j.o((O - n6) * j9);
            long j12 = o6 + j11;
            if (j11 / j9 == o5 && (j12 ^ j11) >= 0) {
                j8 = j.j(kotlin.ranges.t.L(j12, new kotlin.ranges.p(-4611686018427387903L, j.f48028c)));
                return j8;
            }
            if (kotlin.math.b.V(O) * kotlin.math.b.U(i6) > 0) {
                return f48021d;
            }
            return f48022e;
        }
        if (j10 / j9 == O) {
            j7 = j.j(kotlin.ranges.t.L(j10, new kotlin.ranges.p(-4611686018427387903L, j.f48028c)));
            return j7;
        }
        if (kotlin.math.b.V(O) * kotlin.math.b.U(i6) > 0) {
            return f48021d;
        }
        return f48022e;
    }

    private static final long d(long j6, long j7, long j8) {
        long o5;
        long j9;
        long n6;
        long n7;
        long l6;
        o5 = j.o(j8);
        long j10 = j7 + o5;
        if (-4611686018426L > j10 || j10 >= 4611686018427L) {
            j9 = j.j(kotlin.ranges.t.K(j10, -4611686018427387903L, j.f48028c));
            return j9;
        }
        n6 = j.n(o5);
        long j11 = j8 - n6;
        n7 = j.n(j10);
        l6 = j.l(n7 + j11);
        return l6;
    }

    private static final void h(long j6, StringBuilder sb, int i6, int i7, int i8, String str, boolean z5) {
        sb.append(i6);
        if (i7 != 0) {
            sb.append('.');
            String k42 = kotlin.text.u.k4(String.valueOf(i7), i8, '0');
            int i9 = -1;
            int length = k42.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i10 = length - 1;
                    if (k42.charAt(length) != '0') {
                        i9 = length;
                        break;
                    } else if (i10 < 0) {
                        break;
                    } else {
                        length = i10;
                    }
                }
            }
            int i11 = i9 + 1;
            if (!z5 && i11 < 3) {
                sb.append((CharSequence) k42, 0, i11);
                kotlin.jvm.internal.g0.o(sb, "append(...)");
            } else {
                sb.append((CharSequence) k42, 0, ((i9 + 3) / 3) * 3);
                kotlin.jvm.internal.g0.o(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    public static long l(long j6) {
        if (i.c()) {
            if (T(j6)) {
                long O = O(j6);
                if (-4611686018426999999L <= O && O < 4611686018427000000L) {
                    return j6;
                }
                throw new AssertionError(O(j6) + " ns is out of nanoseconds range");
            }
            long O2 = O(j6);
            if (-4611686018427387903L <= O2 && O2 < Longs.MAX_POWER_OF_TWO) {
                long O3 = O(j6);
                if (-4611686018426L <= O3) {
                    if (O3 >= 4611686018427L) {
                        return j6;
                    }
                    throw new AssertionError(O(j6) + " ms is denormalized");
                }
                return j6;
            }
            throw new AssertionError(O(j6) + " ms is out of milliseconds range");
        }
        return j6;
    }

    public static final double m(long j6, long j7) {
        DurationUnit durationUnit = (DurationUnit) kotlin.comparisons.a.X(L(j6), L(j7));
        return f0(j6, durationUnit) / f0(j7, durationUnit);
    }

    public static final long n(long j6, double d6) {
        int K0 = kotlin.math.b.K0(d6);
        if (K0 == d6 && K0 != 0) {
            return o(j6, K0);
        }
        DurationUnit L = L(j6);
        return j.v(f0(j6, L) / d6, L);
    }

    public static final long n0(long j6) {
        long i6;
        i6 = j.i(-O(j6), ((int) j6) & 1);
        return i6;
    }

    public static final long r(long j6) {
        if (V(j6)) {
            return n0(j6);
        }
        return j6;
    }

    public static final int t(long j6) {
        if (U(j6)) {
            return 0;
        }
        return (int) (v(j6) % 24);
    }

    public static final long x(long j6) {
        if (S(j6) && R(j6)) {
            return O(j6);
        }
        return i0(j6, DurationUnit.MILLISECONDS);
    }

    public static final long z(long j6) {
        long n6;
        long O = O(j6);
        if (T(j6)) {
            return O;
        }
        if (O > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (O >= -9223372036854L) {
            n6 = j.n(O);
            return n6;
        }
        return Long.MIN_VALUE;
    }

    @PublishedApi
    public static /* synthetic */ void D() {
    }

    @PublishedApi
    public static /* synthetic */ void F() {
    }

    @PublishedApi
    public static /* synthetic */ void J() {
    }

    @PublishedApi
    public static /* synthetic */ void s() {
    }
}
