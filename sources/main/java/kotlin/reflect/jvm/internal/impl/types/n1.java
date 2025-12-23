package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n1 extends e implements e4.j {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final w1 f47298f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.k f47299g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.r originalTypeVariable, boolean z5, @NotNull w1 constructor) {
        super(originalTypeVariable, z5);
        kotlin.jvm.internal.g0.p(originalTypeVariable, "originalTypeVariable");
        kotlin.jvm.internal.g0.p(constructor, "constructor");
        this.f47298f = constructor;
        this.f47299g = originalTypeVariable.p().i().r();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public w1 I0() {
        return this.f47298f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e
    @NotNull
    public e S0(boolean z5) {
        return new n1(R0(), z5, I0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e, kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k r() {
        return this.f47299g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e1
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stub (BI): ");
        sb.append(R0());
        sb.append(J0() ? "?" : "");
        return sb.toString();
    }
}
