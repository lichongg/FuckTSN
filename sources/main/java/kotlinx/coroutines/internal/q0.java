package kotlinx.coroutines.internal;

import kotlin.jvm.JvmInline;
import kotlinx.coroutines.internal.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmInline
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q0<S extends p0<S>> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Object f49299a;

    public static final /* synthetic */ q0 a(Object obj) {
        return new q0(obj);
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof q0) && kotlin.jvm.internal.g0.g(obj, ((q0) obj2).j());
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static String i(Object obj) {
        return "SegmentOrClosed(value=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f49299a, obj);
    }

    public int hashCode() {
        return g(this.f49299a);
    }

    public final /* synthetic */ Object j() {
        return this.f49299a;
    }

    public String toString() {
        return i(this.f49299a);
    }

    private /* synthetic */ q0(Object obj) {
        this.f49299a = obj;
    }

    public static final boolean d(Object obj, Object obj2) {
        return kotlin.jvm.internal.g0.g(obj, obj2);
    }

    @NotNull
    public static final S f(Object obj) {
        if (obj != f.f49257b) {
            kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (S) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final boolean h(Object obj) {
        if (obj == f.f49257b) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void e() {
    }

    @NotNull
    public static <S extends p0<S>> Object b(@Nullable Object obj) {
        return obj;
    }
}
