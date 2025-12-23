package kotlin.ranges;

import java.lang.Comparable;
import kotlin.jvm.internal.g0;
import kotlin.ranges.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class i<T extends Comparable<? super T>> implements s<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final T f44171a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final T f44172b;

    public i(@NotNull T start, @NotNull T endExclusive) {
        g0.p(start, "start");
        g0.p(endExclusive, "endExclusive");
        this.f44171a = start;
        this.f44172b = endExclusive;
    }

    @Override // kotlin.ranges.s
    @NotNull
    public T d() {
        return this.f44172b;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        if (isEmpty() && ((i) obj).isEmpty()) {
            return true;
        }
        i iVar = (i) obj;
        return g0.g(getStart(), iVar.getStart()) && g0.g(d(), iVar.d());
    }

    @Override // kotlin.ranges.s
    @NotNull
    public T getStart() {
        return this.f44171a;
    }

    @NotNull
    public String toString() {
        return getStart() + "..<" + d();
    }

    @Override // kotlin.ranges.s
    public /* bridge */ boolean contains(@NotNull T t5) {
        return s.a.a(this, t5);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + d().hashCode();
    }

    @Override // kotlin.ranges.s
    public /* bridge */ boolean isEmpty() {
        return s.a.b(this);
    }
}
