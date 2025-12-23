package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j1 extends d2 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final t0 f47276a;

    @Override // kotlin.reflect.jvm.internal.impl.types.c2
    public boolean b() {
        return true;
    }

    public j1(@NotNull kotlin.reflect.jvm.internal.impl.builtins.j kotlinBuiltIns) {
        kotlin.jvm.internal.g0.p(kotlinBuiltIns, "kotlinBuiltIns");
        e1 J = kotlinBuiltIns.J();
        kotlin.jvm.internal.g0.o(J, "getNullableAnyType(...)");
        this.f47276a = J;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.c2
    @NotNull
    public c2 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.c2
    @NotNull
    public Variance c() {
        return Variance.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.c2
    @NotNull
    public t0 getType() {
        return this.f47276a;
    }
}
