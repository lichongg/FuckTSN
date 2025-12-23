package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class g<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f46665a;

    @NotNull
    public abstract t0 getType(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 f0Var);

    public T a() {
        return this.f46665a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        T a6 = a();
        g gVar = obj instanceof g ? (g) obj : null;
        return g0.g(a6, gVar != null ? gVar.a() : null);
    }

    public g(T t5) {
        this.f46665a = t5;
    }

    public int hashCode() {
        T a6 = a();
        if (a6 != null) {
            return a6.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return String.valueOf(a());
    }
}
