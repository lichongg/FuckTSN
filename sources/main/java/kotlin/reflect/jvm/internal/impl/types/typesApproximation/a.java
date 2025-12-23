package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f47338a;

    /* renamed from: b, reason: collision with root package name */
    private final T f47339b;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return g0.g(this.f47338a, aVar.f47338a) && g0.g(this.f47339b, aVar.f47339b);
    }

    public final T a() {
        return this.f47338a;
    }

    public final T b() {
        return this.f47339b;
    }

    public final T c() {
        return this.f47338a;
    }

    public final T d() {
        return this.f47339b;
    }

    public int hashCode() {
        T t5 = this.f47338a;
        int hashCode = (t5 == null ? 0 : t5.hashCode()) * 31;
        T t6 = this.f47339b;
        return hashCode + (t6 != null ? t6.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ApproximationBounds(lower=" + this.f47338a + ", upper=" + this.f47339b + ')';
    }

    public a(T t5, T t6) {
        this.f47338a = t5;
        this.f47339b = t6;
    }
}
