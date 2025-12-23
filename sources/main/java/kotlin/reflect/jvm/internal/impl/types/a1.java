package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class a1 extends c0 {
    @Override // kotlin.reflect.jvm.internal.impl.types.b0, kotlin.reflect.jvm.internal.impl.types.t0
    public boolean J0() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(@NotNull e1 delegate) {
        super(delegate);
        kotlin.jvm.internal.g0.p(delegate, "delegate");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.b0
    @NotNull
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public a1 T0(@NotNull e1 delegate) {
        kotlin.jvm.internal.g0.p(delegate, "delegate");
        return new a1(delegate);
    }
}
