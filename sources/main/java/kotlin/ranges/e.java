package kotlin.ranges;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class e implements g<Double> {

    /* renamed from: a, reason: collision with root package name */
    private final double f44167a;

    /* renamed from: b, reason: collision with root package name */
    private final double f44168b;

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean a(Double d6, Double d7) {
        return e(d6.doubleValue(), d7.doubleValue());
    }

    public boolean b(double d6) {
        return d6 >= this.f44167a && d6 <= this.f44168b;
    }

    @Override // kotlin.ranges.h
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Double getEndInclusive() {
        return Double.valueOf(this.f44168b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.g, kotlin.ranges.h
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return b(((Number) comparable).doubleValue());
    }

    @Override // kotlin.ranges.h
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Double getStart() {
        return Double.valueOf(this.f44167a);
    }

    public boolean e(double d6, double d7) {
        return d6 <= d7;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        if (isEmpty() && ((e) obj).isEmpty()) {
            return true;
        }
        e eVar = (e) obj;
        return this.f44167a == eVar.f44167a && this.f44168b == eVar.f44168b;
    }

    @Override // kotlin.ranges.g, kotlin.ranges.h
    public boolean isEmpty() {
        return this.f44167a > this.f44168b;
    }

    @NotNull
    public String toString() {
        return this.f44167a + ".." + this.f44168b;
    }

    public e(double d6, double d7) {
        this.f44167a = d6;
        this.f44168b = d7;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (d.a(this.f44167a) * 31) + d.a(this.f44168b);
    }
}
