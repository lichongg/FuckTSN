package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.5")
@JvmInline
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z0 implements Comparable<z0> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f48072b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f48073c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f48074d = -1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f48075e = 4;

    /* renamed from: f, reason: collision with root package name */
    public static final int f48076f = 32;

    /* renamed from: a, reason: collision with root package name */
    private final int f48077a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    @InlineOnly
    private static final long D(int i6, long j6) {
        return d1.k(d1.k(i6 & 4294967295L) - j6);
    }

    @InlineOnly
    private static final int E(int i6, int i7) {
        return k(i6 - i7);
    }

    @InlineOnly
    private static final long J(int i6, long j6) {
        return s0.a(d1.k(i6 & 4294967295L), j6);
    }

    @InlineOnly
    private static final int M(int i6, int i7) {
        return k(i6 | i7);
    }

    @InlineOnly
    private static final long Q(int i6, long j6) {
        return d1.k(d1.k(i6 & 4294967295L) + j6);
    }

    @InlineOnly
    private static final int R(int i6, int i7) {
        return k(i6 + i7);
    }

    @InlineOnly
    private static final long W(int i6, long j6) {
        return s0.a(d1.k(i6 & 4294967295L), j6);
    }

    @InlineOnly
    private static final int Z(int i6, int i7) {
        return k(i6 << i7);
    }

    @InlineOnly
    private static final int a(int i6, int i7) {
        return k(i6 & i7);
    }

    @InlineOnly
    private static final int a0(int i6, int i7) {
        return k(i6 >>> i7);
    }

    @InlineOnly
    private static final long c0(int i6, long j6) {
        return d1.k(d1.k(i6 & 4294967295L) * j6);
    }

    @InlineOnly
    private static final int d(int i6, long j6) {
        int compare;
        compare = Long.compare(d1.k(i6 & 4294967295L) ^ Long.MIN_VALUE, j6 ^ Long.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    private static final byte f0(int i6) {
        return (byte) i6;
    }

    @InlineOnly
    private static final long j0(int i6) {
        return i6 & 4294967295L;
    }

    @InlineOnly
    private static final short k0(int i6) {
        return (short) i6;
    }

    @NotNull
    public static String l0(int i6) {
        return String.valueOf(i6 & 4294967295L);
    }

    @InlineOnly
    private static final byte m0(int i6) {
        return v0.k((byte) i6);
    }

    @InlineOnly
    private static final long n(int i6, long j6) {
        return t0.a(d1.k(i6 & 4294967295L), j6);
    }

    @InlineOnly
    private static final long o0(int i6) {
        return d1.k(i6 & 4294967295L);
    }

    @InlineOnly
    private static final short p0(int i6) {
        return j1.k((short) i6);
    }

    @InlineOnly
    private static final int r0(int i6, int i7) {
        return k(i6 ^ i7);
    }

    @InlineOnly
    private static final long t(int i6, long j6) {
        return t0.a(d1.k(i6 & 4294967295L), j6);
    }

    @InlineOnly
    private static final int z(int i6) {
        return k(~i6);
    }

    @InlineOnly
    private static final int C(int i6, byte b6) {
        return k(i6 - k(b6 & 255));
    }

    @InlineOnly
    private static final byte I(int i6, byte b6) {
        return v0.k((byte) r0.a(i6, k(b6 & 255)));
    }

    @InlineOnly
    private static final int O(int i6, byte b6) {
        return k(i6 + k(b6 & 255));
    }

    @InlineOnly
    private static final kotlin.ranges.y T(int i6, int i7) {
        return new kotlin.ranges.y(i6, i7, null);
    }

    @InlineOnly
    private static final int V(int i6, byte b6) {
        return r0.a(i6, k(b6 & 255));
    }

    public static final /* synthetic */ z0 b(int i6) {
        return new z0(i6);
    }

    @InlineOnly
    private static final int b0(int i6, byte b6) {
        return k(i6 * k(b6 & 255));
    }

    @InlineOnly
    private static final int c(int i6, byte b6) {
        int compare;
        compare = Integer.compare(i6 ^ Integer.MIN_VALUE, k(b6 & 255) ^ Integer.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    private static final int d0(int i6, int i7) {
        return k(i6 * i7);
    }

    @InlineOnly
    private static final int l(int i6) {
        return k(i6 - 1);
    }

    @InlineOnly
    private static final int m(int i6, byte b6) {
        return q0.a(i6, k(b6 & 255));
    }

    public static boolean q(int i6, Object obj) {
        return (obj instanceof z0) && i6 == ((z0) obj).q0();
    }

    public static final boolean r(int i6, int i7) {
        return i6 == i7;
    }

    @InlineOnly
    private static final int s(int i6, byte b6) {
        return q0.a(i6, k(b6 & 255));
    }

    @InlineOnly
    private static final int y(int i6) {
        return k(i6 + 1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(z0 z0Var) {
        return o1.e(q0(), z0Var.q0());
    }

    public boolean equals(Object obj) {
        return q(this.f48077a, obj);
    }

    public int hashCode() {
        return x(this.f48077a);
    }

    public final /* synthetic */ int q0() {
        return this.f48077a;
    }

    @NotNull
    public String toString() {
        return l0(this.f48077a);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ z0(int i6) {
        this.f48077a = i6;
    }

    @InlineOnly
    private static final int F(int i6, short s5) {
        return k(i6 - k(s5 & j1.f43986d));
    }

    @InlineOnly
    private static final int K(int i6, int i7) {
        return r0.a(i6, i7);
    }

    @InlineOnly
    private static final short L(int i6, short s5) {
        return j1.k((short) r0.a(i6, k(s5 & j1.f43986d)));
    }

    @InlineOnly
    private static final int S(int i6, short s5) {
        return k(i6 + k(s5 & j1.f43986d));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final kotlin.ranges.y U(int i6, int i7) {
        return kotlin.ranges.c0.V(i6, i7);
    }

    @InlineOnly
    private static final int X(int i6, int i7) {
        return o1.g(i6, i7);
    }

    @InlineOnly
    private static final int Y(int i6, short s5) {
        return r0.a(i6, k(s5 & j1.f43986d));
    }

    @InlineOnly
    private static final int e0(int i6, short s5) {
        return k(i6 * k(s5 & j1.f43986d));
    }

    @InlineOnly
    private static final double g0(int i6) {
        return o1.h(i6);
    }

    @InlineOnly
    private int h(int i6) {
        return o1.e(q0(), i6);
    }

    @InlineOnly
    private static final float h0(int i6) {
        return (float) o1.h(i6);
    }

    @InlineOnly
    private static int i(int i6, int i7) {
        return o1.e(i6, i7);
    }

    @InlineOnly
    private static final int j(int i6, short s5) {
        int compare;
        compare = Integer.compare(i6 ^ Integer.MIN_VALUE, k(s5 & j1.f43986d) ^ Integer.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    private static final int o(int i6, int i7) {
        return o1.f(i6, i7);
    }

    @InlineOnly
    private static final int p(int i6, short s5) {
        return q0.a(i6, k(s5 & j1.f43986d));
    }

    @InlineOnly
    private static final int u(int i6, int i7) {
        return q0.a(i6, i7);
    }

    @InlineOnly
    private static final int v(int i6, short s5) {
        return q0.a(i6, k(s5 & j1.f43986d));
    }

    @PublishedApi
    public static /* synthetic */ void w() {
    }

    @InlineOnly
    private static final int i0(int i6) {
        return i6;
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    public static int k(int i6) {
        return i6;
    }

    @InlineOnly
    private static final int n0(int i6) {
        return i6;
    }

    public static int x(int i6) {
        return i6;
    }
}
