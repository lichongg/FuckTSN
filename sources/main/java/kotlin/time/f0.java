package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.9")
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f0<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f48009a;

    /* renamed from: b, reason: collision with root package name */
    private final long f48010b;

    public /* synthetic */ f0(Object obj, long j6, kotlin.jvm.internal.v vVar) {
        this(obj, j6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return kotlin.jvm.internal.g0.g(this.f48009a, f0Var.f48009a) && h.q(this.f48010b, f0Var.f48010b);
    }

    private f0(T t5, long j6) {
        this.f48009a = t5;
        this.f48010b = j6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ f0 d(f0 f0Var, Object obj, long j6, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            obj = f0Var.f48009a;
        }
        if ((i6 & 2) != 0) {
            j6 = f0Var.f48010b;
        }
        return f0Var.c(obj, j6);
    }

    public final T a() {
        return this.f48009a;
    }

    public final long b() {
        return this.f48010b;
    }

    @NotNull
    public final f0<T> c(T t5, long j6) {
        return new f0<>(t5, j6, null);
    }

    public final long e() {
        return this.f48010b;
    }

    public final T f() {
        return this.f48009a;
    }

    public int hashCode() {
        T t5 = this.f48009a;
        return ((t5 == null ? 0 : t5.hashCode()) * 31) + h.Q(this.f48010b);
    }

    @NotNull
    public String toString() {
        return "TimedValue(value=" + this.f48009a + ", duration=" + ((Object) h.j0(this.f48010b)) + ')';
    }
}
