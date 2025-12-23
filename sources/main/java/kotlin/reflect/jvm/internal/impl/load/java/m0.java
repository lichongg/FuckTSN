package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m0<T> implements k0<T> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Map<kotlin.reflect.jvm.internal.impl.name.c, T> f45725b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.f f45726c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.c, T> f45727d;

    /* JADX WARN: Multi-variable type inference failed */
    public m0(@NotNull Map<kotlin.reflect.jvm.internal.impl.name.c, ? extends T> states) {
        kotlin.jvm.internal.g0.p(states, "states");
        this.f45725b = states;
        kotlin.reflect.jvm.internal.impl.storage.f fVar = new kotlin.reflect.jvm.internal.impl.storage.f("Java nullability annotation states");
        this.f45726c = fVar;
        kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.c, T> c6 = fVar.c(new l0(this));
        kotlin.jvm.internal.g0.o(c6, "createMemoizedFunctionWithNullableValues(...)");
        this.f45727d = c6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.k0
    @Nullable
    public T a(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        return this.f45727d.invoke(fqName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object c(m0 m0Var, kotlin.reflect.jvm.internal.impl.name.c cVar) {
        kotlin.jvm.internal.g0.m(cVar);
        return kotlin.reflect.jvm.internal.impl.name.e.a(cVar, m0Var.f45725b);
    }
}
