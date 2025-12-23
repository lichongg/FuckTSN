package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f0 extends k0 implements e4.d {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final t1 f47243d;

    @Override // kotlin.reflect.jvm.internal.impl.types.k0, kotlin.reflect.jvm.internal.impl.types.t0
    public boolean J0() {
        return false;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public f0(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.builtins.j r3, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.t1 r4) {
        /*
            r2 = this;
            java.lang.String r0 = "builtIns"
            kotlin.jvm.internal.g0.p(r3, r0)
            java.lang.String r0 = "attributes"
            kotlin.jvm.internal.g0.p(r4, r0)
            kotlin.reflect.jvm.internal.impl.types.e1 r0 = r3.I()
            java.lang.String r1 = "getNothingType(...)"
            kotlin.jvm.internal.g0.o(r0, r1)
            kotlin.reflect.jvm.internal.impl.types.e1 r3 = r3.J()
            java.lang.String r1 = "getNullableAnyType(...)"
            kotlin.jvm.internal.g0.o(r3, r1)
            r2.<init>(r0, r3)
            r2.f47243d = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.f0.<init>(kotlin.reflect.jvm.internal.impl.builtins.j, kotlin.reflect.jvm.internal.impl.types.t1):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k0, kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public t1 H0() {
        return this.f47243d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k0
    @NotNull
    public String S0(@NotNull kotlin.reflect.jvm.internal.impl.renderer.m renderer, @NotNull kotlin.reflect.jvm.internal.impl.renderer.u options) {
        kotlin.jvm.internal.g0.p(renderer, "renderer");
        kotlin.jvm.internal.g0.p(options, "options");
        return "dynamic";
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public f0 S0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public f0 O0(@NotNull t1 newAttributes) {
        kotlin.jvm.internal.g0.p(newAttributes, "newAttributes");
        return new f0(kotlin.reflect.jvm.internal.impl.types.typeUtil.e.o(P0()), newAttributes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.k0
    @NotNull
    public e1 P0() {
        return R0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public f0 M0(boolean z5) {
        return this;
    }
}
