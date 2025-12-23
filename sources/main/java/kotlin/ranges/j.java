package kotlin.ranges;

import java.lang.Comparable;
import kotlin.jvm.internal.g0;
import kotlin.ranges.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class j<T extends Comparable<? super T>> implements h<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final T f44173a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final T f44174b;

    public j(@NotNull T start, @NotNull T endInclusive) {
        g0.p(start, "start");
        g0.p(endInclusive, "endInclusive");
        this.f44173a = start;
        this.f44174b = endInclusive;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        if (isEmpty() && ((j) obj).isEmpty()) {
            return true;
        }
        j jVar = (j) obj;
        return g0.g(getStart(), jVar.getStart()) && g0.g(getEndInclusive(), jVar.getEndInclusive());
    }

    @Override // kotlin.ranges.h
    @NotNull
    public T getEndInclusive() {
        return this.f44174b;
    }

    @Override // kotlin.ranges.h
    @NotNull
    public T getStart() {
        return this.f44173a;
    }

    @NotNull
    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }

    @Override // kotlin.ranges.h
    public /* bridge */ boolean contains(@NotNull T t5) {
        return h.a.a(this, t5);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    @Override // kotlin.ranges.h
    public /* bridge */ boolean isEmpty() {
        return h.a.b(this);
    }
}
