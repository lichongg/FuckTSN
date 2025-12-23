package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class e implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f45765a = new e();

    private final Void b() {
        throw new IllegalStateException("No methods should be called on this descriptor. Only its presence matters");
    }

    @NotNull
    public String toString() {
        return "[EnhancedType]";
    }

    private e() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        b();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @Nullable
    public kotlin.reflect.jvm.internal.impl.name.c d() {
        return c.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.e1 getSource() {
        b();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.t0 getType() {
        b();
        throw new KotlinNothingValueException();
    }
}
