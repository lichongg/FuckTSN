package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.5")
@JvmInline
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d1 implements Comparable<d1> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f43782b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final long f43783c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final long f43784d = -1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f43785e = 8;

    /* renamed from: f, reason: collision with root package name */
    public static final int f43786f = 64;

    /* renamed from: a, reason: collision with root package name */
    private final long f43787a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    @InlineOnly
    private static final long C(long j6, byte b6) {
        return k(j6 - k(b6 & 255));
    }

    @InlineOnly
    private static final long D(long j6, long j7) {
        return k(j6 - j7);
    }

    @InlineOnly
    private static final long E(long j6, int i6) {
        return k(j6 - k(i6 & 4294967295L));
    }

    @InlineOnly
    private static final long F(long j6, short s5) {
        return k(j6 - k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    private static final byte I(long j6, byte b6) {
        return v0.k((byte) s0.a(j6, k(b6 & 255)));
    }

    @InlineOnly
    private static final int K(long j6, int i6) {
        return z0.k((int) s0.a(j6, k(i6 & 4294967295L)));
    }

    @InlineOnly
    private static final short L(long j6, short s5) {
        return j1.k((short) s0.a(j6, k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX)));
    }

    @InlineOnly
    private static final long M(long j6, long j7) {
        return k(j6 | j7);
    }

    @InlineOnly
    private static final long O(long j6, byte b6) {
        return k(j6 + k(b6 & 255));
    }

    @InlineOnly
    private static final long Q(long j6, long j7) {
        return k(j6 + j7);
    }

    @InlineOnly
    private static final long R(long j6, int i6) {
        return k(j6 + k(i6 & 4294967295L));
    }

    @InlineOnly
    private static final long S(long j6, short s5) {
        return k(j6 + k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    private static final long V(long j6, byte b6) {
        return s0.a(j6, k(b6 & 255));
    }

    @InlineOnly
    private static final long X(long j6, int i6) {
        return s0.a(j6, k(i6 & 4294967295L));
    }

    @InlineOnly
    private static final long Y(long j6, short s5) {
        return s0.a(j6, k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    private static final long Z(long j6, int i6) {
        return k(j6 << i6);
    }

    @InlineOnly
    private static final long a(long j6, long j7) {
        return k(j6 & j7);
    }

    @InlineOnly
    private static final long a0(long j6, int i6) {
        return k(j6 >>> i6);
    }

    @InlineOnly
    private static final long b0(long j6, byte b6) {
        return k(j6 * k(b6 & 255));
    }

    @InlineOnly
    private static final int c(long j6, byte b6) {
        int compare;
        compare = Long.compare(j6 ^ Long.MIN_VALUE, k(b6 & 255) ^ Long.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    private static final long d0(long j6, int i6) {
        return k(j6 * k(i6 & 4294967295L));
    }

    @InlineOnly
    private static final long e0(long j6, short s5) {
        return k(j6 * k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    private static final byte f0(long j6) {
        return (byte) j6;
    }

    @InlineOnly
    private static final int i(long j6, int i6) {
        int compare;
        compare = Long.compare(j6 ^ Long.MIN_VALUE, k(i6 & 4294967295L) ^ Long.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    private static final int i0(long j6) {
        return (int) j6;
    }

    @InlineOnly
    private static final int j(long j6, short s5) {
        int compare;
        compare = Long.compare(j6 ^ Long.MIN_VALUE, k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX) ^ Long.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    private static final short k0(long j6) {
        return (short) j6;
    }

    @InlineOnly
    private static final long m(long j6, byte b6) {
        return t0.a(j6, k(b6 & 255));
    }

    @InlineOnly
    private static final byte m0(long j6) {
        return v0.k((byte) j6);
    }

    @InlineOnly
    private static final int n0(long j6) {
        return z0.k((int) j6);
    }

    @InlineOnly
    private static final long o(long j6, int i6) {
        return t0.a(j6, k(i6 & 4294967295L));
    }

    @InlineOnly
    private static final long p(long j6, short s5) {
        return t0.a(j6, k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    private static final short p0(long j6) {
        return j1.k((short) j6);
    }

    @InlineOnly
    private static final long r0(long j6, long j7) {
        return k(j6 ^ j7);
    }

    @InlineOnly
    private static final long s(long j6, byte b6) {
        return t0.a(j6, k(b6 & 255));
    }

    @InlineOnly
    private static final long u(long j6, int i6) {
        return t0.a(j6, k(i6 & 4294967295L));
    }

    @InlineOnly
    private static final long v(long j6, short s5) {
        return t0.a(j6, k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    private static final long z(long j6) {
        return k(~j6);
    }

    @InlineOnly
    private static final kotlin.ranges.b0 T(long j6, long j7) {
        return new kotlin.ranges.b0(j6, j7, null);
    }

    public static final /* synthetic */ d1 b(long j6) {
        return new d1(j6);
    }

    @InlineOnly
    private static final long c0(long j6, long j7) {
        return k(j6 * j7);
    }

    @InlineOnly
    private static final long l(long j6) {
        return k(j6 - 1);
    }

    @NotNull
    public static String l0(long j6) {
        return o1.t(j6, 10);
    }

    public static boolean q(long j6, Object obj) {
        return (obj instanceof d1) && j6 == ((d1) obj).q0();
    }

    public static final boolean r(long j6, long j7) {
        return j6 == j7;
    }

    @InlineOnly
    private static final long y(long j6) {
        return k(j6 + 1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(d1 d1Var) {
        return o1.n(q0(), d1Var.q0());
    }

    public boolean equals(Object obj) {
        return q(this.f43787a, obj);
    }

    public int hashCode() {
        return x(this.f43787a);
    }

    public final /* synthetic */ long q0() {
        return this.f43787a;
    }

    @NotNull
    public String toString() {
        return l0(this.f43787a);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ d1(long j6) {
        this.f43787a = j6;
    }

    @InlineOnly
    private static final long J(long j6, long j7) {
        return s0.a(j6, j7);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final kotlin.ranges.b0 U(long j6, long j7) {
        return kotlin.ranges.c0.X(j6, j7);
    }

    @InlineOnly
    private static final long W(long j6, long j7) {
        return o1.p(j6, j7);
    }

    @InlineOnly
    private int d(long j6) {
        return o1.n(q0(), j6);
    }

    @InlineOnly
    private static final double g0(long j6) {
        return o1.q(j6);
    }

    @InlineOnly
    private static int h(long j6, long j7) {
        return o1.n(j6, j7);
    }

    @InlineOnly
    private static final float h0(long j6) {
        return (float) o1.q(j6);
    }

    @InlineOnly
    private static final long n(long j6, long j7) {
        return o1.o(j6, j7);
    }

    @InlineOnly
    private static final long t(long j6, long j7) {
        return t0.a(j6, j7);
    }

    public static int x(long j6) {
        return androidx.camera.camera2.internal.compat.params.e.a(j6);
    }

    @PublishedApi
    public static /* synthetic */ void w() {
    }

    @InlineOnly
    private static final long j0(long j6) {
        return j6;
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    public static long k(long j6) {
        return j6;
    }

    @InlineOnly
    private static final long o0(long j6) {
        return j6;
    }
}
