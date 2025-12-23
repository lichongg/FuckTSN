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
public final class j1 implements Comparable<j1> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f43984b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final short f43985c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final short f43986d = -1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f43987e = 2;

    /* renamed from: f, reason: collision with root package name */
    public static final int f43988f = 16;

    /* renamed from: a, reason: collision with root package name */
    private final short f43989a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    @InlineOnly
    private static final long D(short s5, long j6) {
        return d1.k(d1.k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX) - j6);
    }

    @InlineOnly
    private static final long J(short s5, long j6) {
        return s0.a(d1.k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX), j6);
    }

    @InlineOnly
    private static final short M(short s5, short s6) {
        return k((short) (s5 | s6));
    }

    @InlineOnly
    private static final long Q(short s5, long j6) {
        return d1.k(d1.k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX) + j6);
    }

    @InlineOnly
    private static final long W(short s5, long j6) {
        return s0.a(d1.k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX), j6);
    }

    @InlineOnly
    private static final short a(short s5, short s6) {
        return k((short) (s5 & s6));
    }

    @InlineOnly
    private static final long a0(short s5, long j6) {
        return d1.k(d1.k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX) * j6);
    }

    @InlineOnly
    private static final int d(short s5, long j6) {
        int compare;
        compare = Long.compare(d1.k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX) ^ Long.MIN_VALUE, j6 ^ Long.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    private static final byte d0(short s5) {
        return (byte) s5;
    }

    @InlineOnly
    private static final long h0(short s5) {
        return s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    @InlineOnly
    private static final byte k0(short s5) {
        return v0.k((byte) s5);
    }

    @InlineOnly
    private static final long m0(short s5) {
        return d1.k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    @InlineOnly
    private static final long n(short s5, long j6) {
        return t0.a(d1.k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX), j6);
    }

    @InlineOnly
    private static final short p0(short s5, short s6) {
        return k((short) (s5 ^ s6));
    }

    @InlineOnly
    private static final long t(short s5, long j6) {
        return t0.a(d1.k(s5 & WebSocketProtocol.PAYLOAD_SHORT_MAX), j6);
    }

    @InlineOnly
    private static final short z(short s5) {
        return k((short) (~s5));
    }

    @InlineOnly
    private static final kotlin.ranges.y T(short s5, short s6) {
        return new kotlin.ranges.y(z0.k(s5 & f43986d), z0.k(s6 & f43986d), null);
    }

    public static final /* synthetic */ j1 b(short s5) {
        return new j1(s5);
    }

    @InlineOnly
    private static final short l(short s5) {
        return k((short) (s5 - 1));
    }

    public static boolean q(short s5, Object obj) {
        return (obj instanceof j1) && s5 == ((j1) obj).o0();
    }

    public static final boolean r(short s5, short s6) {
        return s5 == s6;
    }

    @InlineOnly
    private static final short y(short s5) {
        return k((short) (s5 + 1));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(j1 j1Var) {
        return kotlin.jvm.internal.g0.t(o0() & f43986d, j1Var.o0() & f43986d);
    }

    public boolean equals(Object obj) {
        return q(this.f43989a, obj);
    }

    public int hashCode() {
        return x(this.f43989a);
    }

    public final /* synthetic */ short o0() {
        return this.f43989a;
    }

    @NotNull
    public String toString() {
        return j0(this.f43989a);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ j1(short s5) {
        this.f43989a = s5;
    }

    @InlineOnly
    private static final int C(short s5, byte b6) {
        return z0.k(z0.k(s5 & f43986d) - z0.k(b6 & 255));
    }

    @InlineOnly
    private static final int E(short s5, int i6) {
        return z0.k(z0.k(s5 & f43986d) - i6);
    }

    @InlineOnly
    private static final int F(short s5, short s6) {
        return z0.k(z0.k(s5 & f43986d) - z0.k(s6 & f43986d));
    }

    @InlineOnly
    private static final byte I(short s5, byte b6) {
        return v0.k((byte) r0.a(z0.k(s5 & f43986d), z0.k(b6 & 255)));
    }

    @InlineOnly
    private static final int K(short s5, int i6) {
        return r0.a(z0.k(s5 & f43986d), i6);
    }

    @InlineOnly
    private static final short L(short s5, short s6) {
        return k((short) r0.a(z0.k(s5 & f43986d), z0.k(s6 & f43986d)));
    }

    @InlineOnly
    private static final int O(short s5, byte b6) {
        return z0.k(z0.k(s5 & f43986d) + z0.k(b6 & 255));
    }

    @InlineOnly
    private static final int R(short s5, int i6) {
        return z0.k(z0.k(s5 & f43986d) + i6);
    }

    @InlineOnly
    private static final int S(short s5, short s6) {
        return z0.k(z0.k(s5 & f43986d) + z0.k(s6 & f43986d));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final kotlin.ranges.y U(short s5, short s6) {
        return kotlin.ranges.c0.V(z0.k(s5 & f43986d), z0.k(s6 & f43986d));
    }

    @InlineOnly
    private static final int V(short s5, byte b6) {
        return r0.a(z0.k(s5 & f43986d), z0.k(b6 & 255));
    }

    @InlineOnly
    private static final int X(short s5, int i6) {
        return r0.a(z0.k(s5 & f43986d), i6);
    }

    @InlineOnly
    private static final int Y(short s5, short s6) {
        return r0.a(z0.k(s5 & f43986d), z0.k(s6 & f43986d));
    }

    @InlineOnly
    private static final int Z(short s5, byte b6) {
        return z0.k(z0.k(s5 & f43986d) * z0.k(b6 & 255));
    }

    @InlineOnly
    private static final int b0(short s5, int i6) {
        return z0.k(z0.k(s5 & f43986d) * i6);
    }

    @InlineOnly
    private static final int c(short s5, byte b6) {
        return kotlin.jvm.internal.g0.t(s5 & f43986d, b6 & 255);
    }

    @InlineOnly
    private static final int c0(short s5, short s6) {
        return z0.k(z0.k(s5 & f43986d) * z0.k(s6 & f43986d));
    }

    @InlineOnly
    private static final double e0(short s5) {
        return o1.h(s5 & f43986d);
    }

    @InlineOnly
    private static final float f0(short s5) {
        return (float) o1.h(s5 & f43986d);
    }

    @InlineOnly
    private static final int g0(short s5) {
        return s5 & f43986d;
    }

    @InlineOnly
    private static final int h(short s5, int i6) {
        int compare;
        compare = Integer.compare(z0.k(s5 & f43986d) ^ Integer.MIN_VALUE, i6 ^ Integer.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    private int i(short s5) {
        return kotlin.jvm.internal.g0.t(o0() & f43986d, s5 & f43986d);
    }

    @InlineOnly
    private static int j(short s5, short s6) {
        return kotlin.jvm.internal.g0.t(s5 & f43986d, s6 & f43986d);
    }

    @NotNull
    public static String j0(short s5) {
        return String.valueOf(s5 & f43986d);
    }

    @InlineOnly
    private static final int l0(short s5) {
        return z0.k(s5 & f43986d);
    }

    @InlineOnly
    private static final int m(short s5, byte b6) {
        return q0.a(z0.k(s5 & f43986d), z0.k(b6 & 255));
    }

    @InlineOnly
    private static final int o(short s5, int i6) {
        return q0.a(z0.k(s5 & f43986d), i6);
    }

    @InlineOnly
    private static final int p(short s5, short s6) {
        return q0.a(z0.k(s5 & f43986d), z0.k(s6 & f43986d));
    }

    @InlineOnly
    private static final int s(short s5, byte b6) {
        return q0.a(z0.k(s5 & f43986d), z0.k(b6 & 255));
    }

    @InlineOnly
    private static final int u(short s5, int i6) {
        return q0.a(z0.k(s5 & f43986d), i6);
    }

    @InlineOnly
    private static final int v(short s5, short s6) {
        return q0.a(z0.k(s5 & f43986d), z0.k(s6 & f43986d));
    }

    @PublishedApi
    public static /* synthetic */ void w() {
    }

    @InlineOnly
    private static final short i0(short s5) {
        return s5;
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    public static short k(short s5) {
        return s5;
    }

    @InlineOnly
    private static final short n0(short s5) {
        return s5;
    }

    public static int x(short s5) {
        return s5;
    }
}
