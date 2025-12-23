package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m0 extends k0 implements k2 {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final k0 f47294d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final t0 f47295e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(@NotNull k0 origin, @NotNull t0 enhancement) {
        super(origin.Q0(), origin.R0());
        kotlin.jvm.internal.g0.p(origin, "origin");
        kotlin.jvm.internal.g0.p(enhancement, "enhancement");
        this.f47294d = origin;
        this.f47295e = enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    public m2 O0(@NotNull t1 newAttributes) {
        kotlin.jvm.internal.g0.p(newAttributes, "newAttributes");
        return l2.d(T().O0(newAttributes), o0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k0
    @NotNull
    public String S0(@NotNull kotlin.reflect.jvm.internal.impl.renderer.m renderer, @NotNull kotlin.reflect.jvm.internal.impl.renderer.u options) {
        kotlin.jvm.internal.g0.p(renderer, "renderer");
        kotlin.jvm.internal.g0.p(options, "options");
        return options.b() ? renderer.T(o0()) : T().S0(renderer, options);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k2
    @NotNull
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public k0 T() {
        return this.f47294d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public m0 S0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        t0 a6 = kotlinTypeRefiner.a(T());
        kotlin.jvm.internal.g0.n(a6, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return new m0((k0) a6, kotlinTypeRefiner.a(o0()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k2
    @NotNull
    public t0 o0() {
        return this.f47295e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k0
    @NotNull
    public String toString() {
        return "[@EnhancedForWarnings(" + o0() + ")] " + T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    public m2 M0(boolean z5) {
        return l2.d(T().M0(z5), o0().L0().M0(z5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k0
    @NotNull
    public e1 P0() {
        return T().P0();
    }
}
