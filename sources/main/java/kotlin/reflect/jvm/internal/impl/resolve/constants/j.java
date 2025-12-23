package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.e1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j extends g<Double> {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public e1 getType(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module) {
        g0.p(module, "module");
        e1 A = module.p().A();
        g0.o(A, "getDoubleType(...)");
        return A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public String toString() {
        return a().doubleValue() + ".toDouble()";
    }

    public j(double d6) {
        super(Double.valueOf(d6));
    }
}
