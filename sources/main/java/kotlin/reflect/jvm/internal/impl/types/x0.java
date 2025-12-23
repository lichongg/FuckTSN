package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x0 {
    public static final boolean a(@NotNull t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        m2 L0 = t0Var.L0();
        if (L0 instanceof kotlin.reflect.jvm.internal.impl.types.error.g) {
            return true;
        }
        return (L0 instanceof k0) && (((k0) L0).P0() instanceof kotlin.reflect.jvm.internal.impl.types.error.g);
    }

    public static final boolean b(@NotNull t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        return j2.l(t0Var);
    }
}
