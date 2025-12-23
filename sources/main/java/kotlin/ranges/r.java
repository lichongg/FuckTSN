package kotlin.ranges;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class r implements s<Float> {

    /* renamed from: a, reason: collision with root package name */
    private final float f44197a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44198b;

    private final boolean e(float f6, float f7) {
        return f6 <= f7;
    }

    public boolean a(float f6) {
        return f6 >= this.f44197a && f6 < this.f44198b;
    }

    @Override // kotlin.ranges.s
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float d() {
        return Float.valueOf(this.f44198b);
    }

    @Override // kotlin.ranges.s
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Float getStart() {
        return Float.valueOf(this.f44197a);
    }

    @Override // kotlin.ranges.s
    public /* bridge */ /* synthetic */ boolean contains(Float f6) {
        return a(f6.floatValue());
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        if (isEmpty() && ((r) obj).isEmpty()) {
            return true;
        }
        r rVar = (r) obj;
        return this.f44197a == rVar.f44197a && this.f44198b == rVar.f44198b;
    }

    @Override // kotlin.ranges.s
    public boolean isEmpty() {
        return this.f44197a >= this.f44198b;
    }

    @NotNull
    public String toString() {
        return this.f44197a + "..<" + this.f44198b;
    }

    public r(float f6, float f7) {
        this.f44197a = f6;
        this.f44198b = f7;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.floatToIntBits(this.f44197a) * 31) + Float.floatToIntBits(this.f44198b);
    }
}
