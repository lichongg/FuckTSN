package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class c0 extends b0 {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final e1 f47155b;

    public c0(@NotNull e1 delegate) {
        kotlin.jvm.internal.g0.p(delegate, "delegate");
        this.f47155b = delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: Q0 */
    public e1 O0(@NotNull t1 newAttributes) {
        kotlin.jvm.internal.g0.p(newAttributes, "newAttributes");
        return newAttributes != H0() ? new g1(this, newAttributes) : this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0
    @NotNull
    protected e1 R0() {
        return this.f47155b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m2
    @NotNull
    /* renamed from: P0 */
    public e1 M0(boolean z5) {
        if (z5 == J0()) {
            return this;
        }
        return R0().M0(z5).O0(H0());
    }
}
