package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a extends g<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c value) {
        super(value);
        g0.p(value, "value");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public t0 getType(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module) {
        g0.p(module, "module");
        return a().getType();
    }
}
