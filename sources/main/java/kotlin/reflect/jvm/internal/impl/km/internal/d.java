package kotlin.reflect.jvm.internal.impl.km.internal;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final int f45176a;

    /* renamed from: b, reason: collision with root package name */
    private final int f45177b;

    /* renamed from: c, reason: collision with root package name */
    private final int f45178c;

    public d(int i6, int i7, int i8) {
        this.f45176a = i6;
        this.f45177b = i7;
        this.f45178c = i8;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@NotNull b.d<?> field, int i6) {
        this(field.f46233a, field.f46234b, i6);
        g0.p(field, "field");
    }

    public final int a() {
        return this.f45177b;
    }

    public final int b() {
        return this.f45176a;
    }

    public final int c() {
        return this.f45178c;
    }

    public final boolean d(int i6) {
        return ((i6 >>> this.f45176a) & ((1 << this.f45177b) - 1)) == this.f45178c;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@NotNull b.C0902b field) {
        this(field, 1);
        g0.p(field, "field");
    }
}
