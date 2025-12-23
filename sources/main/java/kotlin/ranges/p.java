package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p extends n implements h<Long>, s<Long> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f44193e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final p f44194f = new p(1, 0);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final p a() {
            return p.f44194f;
        }
    }

    public p(long j6, long j7) {
        super(j6, j7, 1L);
    }

    @Override // kotlin.ranges.h
    public /* bridge */ /* synthetic */ boolean contains(Long l6) {
        return n(l6.longValue());
    }

    @Override // kotlin.ranges.n
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        if (isEmpty() && ((p) obj).isEmpty()) {
            return true;
        }
        p pVar = (p) obj;
        return e() == pVar.e() && f() == pVar.f();
    }

    @Override // kotlin.ranges.n
    @NotNull
    public String toString() {
        return e() + ".." + f();
    }

    @Override // kotlin.ranges.n
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (e() ^ (e() >>> 32))) + (f() ^ (f() >>> 32)));
    }

    @Override // kotlin.ranges.n, kotlin.ranges.h
    public boolean isEmpty() {
        if (e() > f()) {
            return true;
        }
        return false;
    }

    public boolean n(long j6) {
        if (e() <= j6 && j6 <= f()) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.s
    @NotNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Long d() {
        if (f() != Long.MAX_VALUE) {
            return Long.valueOf(f() + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // kotlin.ranges.h
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Long getEndInclusive() {
        return Long.valueOf(f());
    }

    @Override // kotlin.ranges.h
    @NotNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Long getStart() {
        return Long.valueOf(e());
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with Long type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* synthetic */ void p() {
    }
}
