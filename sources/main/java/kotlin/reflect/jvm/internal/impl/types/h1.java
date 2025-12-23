package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h1 extends b0 implements k2 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final e1 f47261b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final t0 f47262c;

    public h1(@NotNull e1 delegate, @NotNull t0 enhancement) {
        kotlin.jvm.internal.g0.p(delegate, "delegate");
        kotlin.jvm.internal.g0.p(enhancement, "enhancement");
        this.f47261b = delegate;
        this.f47262c = enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: Q0 */
    public e1 O0(@NotNull t1 newAttributes) {
        kotlin.jvm.internal.g0.p(newAttributes, "newAttributes");
        m2 d6 = l2.d(T().O0(newAttributes), o0());
        kotlin.jvm.internal.g0.n(d6, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (e1) d6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0
    @NotNull
    protected e1 R0() {
        return this.f47261b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0
    @NotNull
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public h1 S0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        t0 a6 = kotlinTypeRefiner.a(R0());
        kotlin.jvm.internal.g0.n(a6, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new h1((e1) a6, kotlinTypeRefiner.a(o0()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0
    @NotNull
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public h1 T0(@NotNull e1 delegate) {
        kotlin.jvm.internal.g0.p(delegate, "delegate");
        return new h1(delegate, o0());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k2
    @NotNull
    public t0 o0() {
        return this.f47262c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e1
    @NotNull
    public String toString() {
        return "[@EnhancedForWarnings(" + o0() + ")] " + T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: P0 */
    public e1 M0(boolean z5) {
        m2 d6 = l2.d(T().M0(z5), o0().L0().M0(z5));
        kotlin.jvm.internal.g0.n(d6, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (e1) d6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k2
    @NotNull
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public e1 T() {
        return R0();
    }
}
