package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.KotlinNothingValueException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o extends KDeclarationContainerImpl {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final o f47537d = new o();

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.w0 R(int i6) {
        return null;
    }

    private final Void a0() {
        throw new KotlinReflectionInternalError("Introspecting local functions, lambdas, anonymous functions, local variables and typealiases is not yet fully supported in Kotlin reflection");
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.y> Q(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        a0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> U(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        a0();
        throw new KotlinNothingValueException();
    }

    private o() {
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.j> P() {
        a0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.s
    @NotNull
    public Class<?> c() {
        a0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.h
    @NotNull
    public Collection<kotlin.reflect.c<?>> o() {
        a0();
        throw new KotlinNothingValueException();
    }
}
