package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v1 {
    @Nullable
    public static final x a(@NotNull t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        e4.g L0 = t0Var.L0();
        x xVar = L0 instanceof x ? (x) L0 : null;
        if (xVar == null || !xVar.E0()) {
            return null;
        }
        return xVar;
    }

    public static final boolean b(@NotNull t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        e4.g L0 = t0Var.L0();
        x xVar = L0 instanceof x ? (x) L0 : null;
        if (xVar != null) {
            return xVar.E0();
        }
        return false;
    }
}
