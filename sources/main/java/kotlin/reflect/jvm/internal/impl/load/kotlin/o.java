package kotlin.reflect.jvm.internal.impl.load.kotlin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final v f45978a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final n f45979b;

    public o(@NotNull v kotlinClassFinder, @NotNull n deserializedDescriptorResolver) {
        kotlin.jvm.internal.g0.p(kotlinClassFinder, "kotlinClassFinder");
        kotlin.jvm.internal.g0.p(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        this.f45978a = kotlinClassFinder;
        this.f45979b = deserializedDescriptorResolver;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.i
    @Nullable
    public kotlin.reflect.jvm.internal.impl.serialization.deserialization.h a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        kotlin.jvm.internal.g0.p(classId, "classId");
        x a6 = w.a(this.f45978a, classId, this.f45979b.f().g().f());
        if (a6 == null) {
            return null;
        }
        kotlin.jvm.internal.g0.g(a6.c(), classId);
        return this.f45979b.l(a6);
    }
}
