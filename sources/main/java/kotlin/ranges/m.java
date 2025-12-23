package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m extends k implements h<Integer>, s<Integer> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f44183e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final m f44184f = new m(1, 0);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final m a() {
            return m.f44184f;
        }
    }

    public m(int i6, int i7) {
        super(i6, i7, 1);
    }

    @Override // kotlin.ranges.h
    public /* bridge */ /* synthetic */ boolean contains(Integer num) {
        return n(num.intValue());
    }

    @Override // kotlin.ranges.k
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        if (isEmpty() && ((m) obj).isEmpty()) {
            return true;
        }
        m mVar = (m) obj;
        return e() == mVar.e() && f() == mVar.f();
    }

    @Override // kotlin.ranges.k
    @NotNull
    public String toString() {
        return e() + ".." + f();
    }

    @Override // kotlin.ranges.k
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (e() * 31) + f();
    }

    @Override // kotlin.ranges.k, kotlin.ranges.h
    public boolean isEmpty() {
        if (e() > f()) {
            return true;
        }
        return false;
    }

    public boolean n(int i6) {
        if (e() <= i6 && i6 <= f()) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.s
    @NotNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Integer d() {
        if (f() != Integer.MAX_VALUE) {
            return Integer.valueOf(f() + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // kotlin.ranges.h
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Integer getEndInclusive() {
        return Integer.valueOf(f());
    }

    @Override // kotlin.ranges.h
    @NotNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer getStart() {
        return Integer.valueOf(e());
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with Int type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* synthetic */ void p() {
    }
}
