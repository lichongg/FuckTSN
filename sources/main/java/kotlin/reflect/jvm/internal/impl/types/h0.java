package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class h0 {
    public static /* synthetic */ c2 b(h0 h0Var, kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var, i0 i0Var, b2 b2Var, t0 t0Var, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: computeProjection");
        }
        if ((i6 & 8) != 0) {
            t0Var = b2Var.e(j1Var, i0Var);
        }
        return h0Var.a(j1Var, i0Var, b2Var, t0Var);
    }

    @NotNull
    public c2 a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1 parameter, @NotNull i0 typeAttr, @NotNull b2 typeParameterUpperBoundEraser, @NotNull t0 erasedUpperBound) {
        kotlin.jvm.internal.g0.p(parameter, "parameter");
        kotlin.jvm.internal.g0.p(typeAttr, "typeAttr");
        kotlin.jvm.internal.g0.p(typeParameterUpperBoundEraser, "typeParameterUpperBoundEraser");
        kotlin.jvm.internal.g0.p(erasedUpperBound, "erasedUpperBound");
        return new e2(Variance.OUT_VARIANCE, erasedUpperBound);
    }
}
