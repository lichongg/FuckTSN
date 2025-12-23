package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c extends kotlin.ranges.a implements h<Character>, s<Character> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f44165e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final c f44166f = new c(1, 0);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final c a() {
            return c.f44166f;
        }
    }

    public c(char c6, char c7) {
        super(c6, c7, 1);
    }

    @Override // kotlin.ranges.h
    public /* bridge */ /* synthetic */ boolean contains(Character ch) {
        return n(ch.charValue());
    }

    @Override // kotlin.ranges.a
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (isEmpty() && ((c) obj).isEmpty()) {
            return true;
        }
        c cVar = (c) obj;
        return e() == cVar.e() && f() == cVar.f();
    }

    @Override // kotlin.ranges.a
    @NotNull
    public String toString() {
        return e() + ".." + f();
    }

    @Override // kotlin.ranges.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (e() * 31) + f();
    }

    @Override // kotlin.ranges.a, kotlin.ranges.h
    public boolean isEmpty() {
        if (g0.t(e(), f()) > 0) {
            return true;
        }
        return false;
    }

    public boolean n(char c6) {
        if (g0.t(e(), c6) <= 0 && g0.t(c6, f()) <= 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.s
    @NotNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Character d() {
        if (f() != 65535) {
            return Character.valueOf((char) (f() + 1));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @Override // kotlin.ranges.h
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Character getEndInclusive() {
        return Character.valueOf(f());
    }

    @Override // kotlin.ranges.h
    @NotNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Character getStart() {
        return Character.valueOf(e());
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with Char type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* synthetic */ void p() {
    }
}
