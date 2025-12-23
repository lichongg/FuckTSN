package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.5")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y extends w implements h<z0>, s<z0> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f44207e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final y f44208f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final y a() {
            return y.f44208f;
        }
    }

    public /* synthetic */ y(int i6, int i7, kotlin.jvm.internal.v vVar) {
        this(i6, i7);
    }

    static {
        kotlin.jvm.internal.v vVar = null;
        f44207e = new a(vVar);
        f44208f = new y(-1, 0, vVar);
    }

    private y(int i6, int i7) {
        super(i6, i7, 1, null);
    }

    @Override // kotlin.ranges.h
    public /* bridge */ /* synthetic */ boolean contains(z0 z0Var) {
        return m(z0Var.q0());
    }

    @Override // kotlin.ranges.w
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        if (isEmpty() && ((y) obj).isEmpty()) {
            return true;
        }
        y yVar = (y) obj;
        return e() == yVar.e() && f() == yVar.f();
    }

    @Override // kotlin.ranges.w
    @NotNull
    public String toString() {
        return ((Object) z0.l0(e())) + ".." + ((Object) z0.l0(f()));
    }

    @Override // kotlin.ranges.s
    public /* bridge */ /* synthetic */ z0 d() {
        return z0.b(n());
    }

    @Override // kotlin.ranges.h
    public /* bridge */ /* synthetic */ z0 getEndInclusive() {
        return z0.b(p());
    }

    @Override // kotlin.ranges.h
    public /* bridge */ /* synthetic */ z0 getStart() {
        return z0.b(q());
    }

    @Override // kotlin.ranges.w
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (e() * 31) + f();
    }

    @Override // kotlin.ranges.w, kotlin.ranges.h
    public boolean isEmpty() {
        int compare;
        compare = Integer.compare(e() ^ Integer.MIN_VALUE, f() ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return true;
        }
        return false;
    }

    public boolean m(int i6) {
        int compare;
        int compare2;
        compare = Integer.compare(e() ^ Integer.MIN_VALUE, i6 ^ Integer.MIN_VALUE);
        if (compare <= 0) {
            compare2 = Integer.compare(i6 ^ Integer.MIN_VALUE, f() ^ Integer.MIN_VALUE);
            if (compare2 <= 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int n() {
        if (f() != -1) {
            return z0.k(f() + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    public int p() {
        return f();
    }

    public int q() {
        return e();
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* synthetic */ void o() {
    }
}
