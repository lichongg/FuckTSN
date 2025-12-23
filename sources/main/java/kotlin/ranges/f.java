package kotlin.ranges;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class f implements g<Float> {

    /* renamed from: a, reason: collision with root package name */
    private final float f44169a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44170b;

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean a(Float f6, Float f7) {
        return e(f6.floatValue(), f7.floatValue());
    }

    public boolean b(float f6) {
        return f6 >= this.f44169a && f6 <= this.f44170b;
    }

    @Override // kotlin.ranges.h
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Float getEndInclusive() {
        return Float.valueOf(this.f44170b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.g, kotlin.ranges.h
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return b(((Number) comparable).floatValue());
    }

    @Override // kotlin.ranges.h
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Float getStart() {
        return Float.valueOf(this.f44169a);
    }

    public boolean e(float f6, float f7) {
        return f6 <= f7;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        if (isEmpty() && ((f) obj).isEmpty()) {
            return true;
        }
        f fVar = (f) obj;
        return this.f44169a == fVar.f44169a && this.f44170b == fVar.f44170b;
    }

    @Override // kotlin.ranges.g, kotlin.ranges.h
    public boolean isEmpty() {
        return this.f44169a > this.f44170b;
    }

    @NotNull
    public String toString() {
        return this.f44169a + ".." + this.f44170b;
    }

    public f(float f6, float f7) {
        this.f44169a = f6;
        this.f44170b = f7;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.floatToIntBits(this.f44169a) * 31) + Float.floatToIntBits(this.f44170b);
    }
}
