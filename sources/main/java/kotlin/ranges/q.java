package kotlin.ranges;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class q implements s<Double> {

    /* renamed from: a, reason: collision with root package name */
    private final double f44195a;

    /* renamed from: b, reason: collision with root package name */
    private final double f44196b;

    private final boolean e(double d6, double d7) {
        return d6 <= d7;
    }

    public boolean a(double d6) {
        return d6 >= this.f44195a && d6 < this.f44196b;
    }

    @Override // kotlin.ranges.s
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Double d() {
        return Double.valueOf(this.f44196b);
    }

    @Override // kotlin.ranges.s
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Double getStart() {
        return Double.valueOf(this.f44195a);
    }

    @Override // kotlin.ranges.s
    public /* bridge */ /* synthetic */ boolean contains(Double d6) {
        return a(d6.doubleValue());
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        if (isEmpty() && ((q) obj).isEmpty()) {
            return true;
        }
        q qVar = (q) obj;
        return this.f44195a == qVar.f44195a && this.f44196b == qVar.f44196b;
    }

    @Override // kotlin.ranges.s
    public boolean isEmpty() {
        return this.f44195a >= this.f44196b;
    }

    @NotNull
    public String toString() {
        return this.f44195a + "..<" + this.f44196b;
    }

    public q(double d6, double d7) {
        this.f44195a = d6;
        this.f44196b = d7;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (d.a(this.f44195a) * 31) + d.a(this.f44196b);
    }
}
