package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.d1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.5")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b0 extends z implements h<d1>, s<d1> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f44163e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final b0 f44164f = new b0(-1, 0, null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final b0 a() {
            return b0.f44164f;
        }
    }

    public /* synthetic */ b0(long j6, long j7, kotlin.jvm.internal.v vVar) {
        this(j6, j7);
    }

    private b0(long j6, long j7) {
        super(j6, j7, 1L, null);
    }

    @Override // kotlin.ranges.h
    public /* bridge */ /* synthetic */ boolean contains(d1 d1Var) {
        return m(d1Var.q0());
    }

    @Override // kotlin.ranges.z
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof b0)) {
            return false;
        }
        if (isEmpty() && ((b0) obj).isEmpty()) {
            return true;
        }
        b0 b0Var = (b0) obj;
        return e() == b0Var.e() && f() == b0Var.f();
    }

    @Override // kotlin.ranges.z
    @NotNull
    public String toString() {
        return ((Object) d1.l0(e())) + ".." + ((Object) d1.l0(f()));
    }

    @Override // kotlin.ranges.s
    public /* bridge */ /* synthetic */ d1 d() {
        return d1.b(n());
    }

    @Override // kotlin.ranges.h
    public /* bridge */ /* synthetic */ d1 getEndInclusive() {
        return d1.b(p());
    }

    @Override // kotlin.ranges.h
    public /* bridge */ /* synthetic */ d1 getStart() {
        return d1.b(q());
    }

    @Override // kotlin.ranges.z
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((int) d1.k(e() ^ d1.k(e() >>> 32))) * 31) + ((int) d1.k(f() ^ d1.k(f() >>> 32)));
    }

    @Override // kotlin.ranges.z, kotlin.ranges.h
    public boolean isEmpty() {
        int compare;
        compare = Long.compare(e() ^ Long.MIN_VALUE, f() ^ Long.MIN_VALUE);
        if (compare > 0) {
            return true;
        }
        return false;
    }

    public boolean m(long j6) {
        int compare;
        int compare2;
        compare = Long.compare(e() ^ Long.MIN_VALUE, j6 ^ Long.MIN_VALUE);
        if (compare <= 0) {
            compare2 = Long.compare(j6 ^ Long.MIN_VALUE, f() ^ Long.MIN_VALUE);
            if (compare2 <= 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public long n() {
        if (f() != -1) {
            return d1.k(f() + d1.k(1 & 4294967295L));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    public long p() {
        return f();
    }

    public long q() {
        return e();
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* synthetic */ void o() {
    }
}
