package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class g1 extends c0 {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final t1 f47256c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g1(@NotNull e1 delegate, @NotNull t1 attributes) {
        super(delegate);
        kotlin.jvm.internal.g0.p(delegate, "delegate");
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        this.f47256c = attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0, kotlin.reflect.jvm.internal.impl.types.t0
    @NotNull
    public t1 H0() {
        return this.f47256c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0
    @NotNull
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public g1 T0(@NotNull e1 delegate) {
        kotlin.jvm.internal.g0.p(delegate, "delegate");
        return new g1(delegate, H0());
    }
}
