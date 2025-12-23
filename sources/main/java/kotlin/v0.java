package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.5")
@JvmInline
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v0 implements Comparable<v0> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f48063b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final byte f48064c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final byte f48065d = -1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f48066e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f48067f = 8;

    /* renamed from: a, reason: collision with root package name */
    private final byte f48068a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    @InlineOnly
    private static final long D(byte b6, long j6) {
        return d1.k(d1.k(b6 & 255) - j6);
    }

    @InlineOnly
    private static final long J(byte b6, long j6) {
        return s0.a(d1.k(b6 & 255), j6);
    }

    @InlineOnly
    private static final byte M(byte b6, byte b7) {
        return k((byte) (b6 | b7));
    }

    @InlineOnly
    private static final long Q(byte b6, long j6) {
        return d1.k(d1.k(b6 & 255) + j6);
    }

    @InlineOnly
    private static final long W(byte b6, long j6) {
        return s0.a(d1.k(b6 & 255), j6);
    }

    @InlineOnly
    private static final byte a(byte b6, byte b7) {
        return k((byte) (b6 & b7));
    }

    @InlineOnly
    private static final long a0(byte b6, long j6) {
        return d1.k(d1.k(b6 & 255) * j6);
    }

    @InlineOnly
    private static final int h(byte b6, long j6) {
        int compare;
        compare = Long.compare(d1.k(b6 & 255) ^ Long.MIN_VALUE, j6 ^ Long.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    private static final long h0(byte b6) {
        return b6 & 255;
    }

    @InlineOnly
    private static final short i0(byte b6) {
        return (short) (b6 & 255);
    }

    @InlineOnly
    private static final long m0(byte b6) {
        return d1.k(b6 & 255);
    }

    @InlineOnly
    private static final long n(byte b6, long j6) {
        return t0.a(d1.k(b6 & 255), j6);
    }

    @InlineOnly
    private static final short n0(byte b6) {
        return j1.k((short) (b6 & 255));
    }

    @InlineOnly
    private static final byte p0(byte b6, byte b7) {
        return k((byte) (b6 ^ b7));
    }

    @InlineOnly
    private static final long t(byte b6, long j6) {
        return t0.a(d1.k(b6 & 255), j6);
    }

    @InlineOnly
    private static final byte z(byte b6) {
        return k((byte) (~b6));
    }

    @InlineOnly
    private static final int C(byte b6, byte b7) {
        return z0.k(z0.k(b6 & 255) - z0.k(b7 & 255));
    }

    @InlineOnly
    private static final int E(byte b6, int i6) {
        return z0.k(z0.k(b6 & 255) - i6);
    }

    @InlineOnly
    private static final int F(byte b6, short s5) {
        return z0.k(z0.k(b6 & 255) - z0.k(s5 & j1.f43986d));
    }

    @InlineOnly
    private static final byte I(byte b6, byte b7) {
        return k((byte) r0.a(z0.k(b6 & 255), z0.k(b7 & 255)));
    }

    @InlineOnly
    private static final int K(byte b6, int i6) {
        return r0.a(z0.k(b6 & 255), i6);
    }

    @InlineOnly
    private static final short L(byte b6, short s5) {
        return j1.k((short) r0.a(z0.k(b6 & 255), z0.k(s5 & j1.f43986d)));
    }

    @InlineOnly
    private static final int O(byte b6, byte b7) {
        return z0.k(z0.k(b6 & 255) + z0.k(b7 & 255));
    }

    @InlineOnly
    private static final int R(byte b6, int i6) {
        return z0.k(z0.k(b6 & 255) + i6);
    }

    @InlineOnly
    private static final int S(byte b6, short s5) {
        return z0.k(z0.k(b6 & 255) + z0.k(s5 & j1.f43986d));
    }

    @InlineOnly
    private static final kotlin.ranges.y T(byte b6, byte b7) {
        return new kotlin.ranges.y(z0.k(b6 & 255), z0.k(b7 & 255), null);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final kotlin.ranges.y U(byte b6, byte b7) {
        return kotlin.ranges.c0.V(z0.k(b6 & 255), z0.k(b7 & 255));
    }

    @InlineOnly
    private static final int V(byte b6, byte b7) {
        return r0.a(z0.k(b6 & 255), z0.k(b7 & 255));
    }

    @InlineOnly
    private static final int X(byte b6, int i6) {
        return r0.a(z0.k(b6 & 255), i6);
    }

    @InlineOnly
    private static final int Y(byte b6, short s5) {
        return r0.a(z0.k(b6 & 255), z0.k(s5 & j1.f43986d));
    }

    @InlineOnly
    private static final int Z(byte b6, byte b7) {
        return z0.k(z0.k(b6 & 255) * z0.k(b7 & 255));
    }

    public static final /* synthetic */ v0 b(byte b6) {
        return new v0(b6);
    }

    @InlineOnly
    private static final int b0(byte b6, int i6) {
        return z0.k(z0.k(b6 & 255) * i6);
    }

    @InlineOnly
    private static final int c0(byte b6, short s5) {
        return z0.k(z0.k(b6 & 255) * z0.k(s5 & j1.f43986d));
    }

    @InlineOnly
    private static int d(byte b6, byte b7) {
        return kotlin.jvm.internal.g0.t(b6 & 255, b7 & 255);
    }

    @InlineOnly
    private static final double e0(byte b6) {
        return o1.h(b6 & 255);
    }

    @InlineOnly
    private static final float f0(byte b6) {
        return (float) o1.h(b6 & 255);
    }

    @InlineOnly
    private static final int g0(byte b6) {
        return b6 & 255;
    }

    @InlineOnly
    private static final int i(byte b6, int i6) {
        int compare;
        compare = Integer.compare(z0.k(b6 & 255) ^ Integer.MIN_VALUE, i6 ^ Integer.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    private static final int j(byte b6, short s5) {
        return kotlin.jvm.internal.g0.t(b6 & 255, s5 & j1.f43986d);
    }

    @NotNull
    public static String j0(byte b6) {
        return String.valueOf(b6 & 255);
    }

    @InlineOnly
    private static final byte l(byte b6) {
        return k((byte) (b6 - 1));
    }

    @InlineOnly
    private static final int l0(byte b6) {
        return z0.k(b6 & 255);
    }

    @InlineOnly
    private static final int m(byte b6, byte b7) {
        return q0.a(z0.k(b6 & 255), z0.k(b7 & 255));
    }

    @InlineOnly
    private static final int o(byte b6, int i6) {
        return q0.a(z0.k(b6 & 255), i6);
    }

    @InlineOnly
    private static final int p(byte b6, short s5) {
        return q0.a(z0.k(b6 & 255), z0.k(s5 & j1.f43986d));
    }

    public static boolean q(byte b6, Object obj) {
        return (obj instanceof v0) && b6 == ((v0) obj).o0();
    }

    public static final boolean r(byte b6, byte b7) {
        return b6 == b7;
    }

    @InlineOnly
    private static final int s(byte b6, byte b7) {
        return q0.a(z0.k(b6 & 255), z0.k(b7 & 255));
    }

    @InlineOnly
    private static final int u(byte b6, int i6) {
        return q0.a(z0.k(b6 & 255), i6);
    }

    @InlineOnly
    private static final int v(byte b6, short s5) {
        return q0.a(z0.k(b6 & 255), z0.k(s5 & j1.f43986d));
    }

    @InlineOnly
    private static final byte y(byte b6) {
        return k((byte) (b6 + 1));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(v0 v0Var) {
        return kotlin.jvm.internal.g0.t(o0() & 255, v0Var.o0() & 255);
    }

    public boolean equals(Object obj) {
        return q(this.f48068a, obj);
    }

    public int hashCode() {
        return x(this.f48068a);
    }

    public final /* synthetic */ byte o0() {
        return this.f48068a;
    }

    @NotNull
    public String toString() {
        return j0(this.f48068a);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ v0(byte b6) {
        this.f48068a = b6;
    }

    @InlineOnly
    private int c(byte b6) {
        return kotlin.jvm.internal.g0.t(o0() & 255, b6 & 255);
    }

    @PublishedApi
    public static /* synthetic */ void w() {
    }

    @InlineOnly
    private static final byte d0(byte b6) {
        return b6;
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    public static byte k(byte b6) {
        return b6;
    }

    @InlineOnly
    private static final byte k0(byte b6) {
        return b6;
    }

    public static int x(byte b6) {
        return b6;
    }
}
