package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a extends b0 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final e1 f47142b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final e1 f47143c;

    public a(@NotNull e1 delegate, @NotNull e1 abbreviation) {
        kotlin.jvm.internal.g0.p(delegate, "delegate");
        kotlin.jvm.internal.g0.p(abbreviation, "abbreviation");
        this.f47142b = delegate;
        this.f47143c = abbreviation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: Q0 */
    public e1 O0(@NotNull t1 newAttributes) {
        kotlin.jvm.internal.g0.p(newAttributes, "newAttributes");
        return new a(R0().O0(newAttributes), this.f47143c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0
    @NotNull
    protected e1 R0() {
        return this.f47142b;
    }

    @NotNull
    public final e1 U0() {
        return this.f47143c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.e1
    @NotNull
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public a M0(boolean z5) {
        return new a(R0().M0(z5), this.f47143c.M0(z5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0
    @NotNull
    /* renamed from: W0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public a S0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        t0 a6 = kotlinTypeRefiner.a(R0());
        kotlin.jvm.internal.g0.n(a6, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        t0 a7 = kotlinTypeRefiner.a(this.f47143c);
        kotlin.jvm.internal.g0.n(a7, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new a((e1) a6, (e1) a7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0
    @NotNull
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public a T0(@NotNull e1 delegate) {
        kotlin.jvm.internal.g0.p(delegate, "delegate");
        return new a(delegate, this.f47143c);
    }

    @NotNull
    public final e1 Z() {
        return R0();
    }
}
