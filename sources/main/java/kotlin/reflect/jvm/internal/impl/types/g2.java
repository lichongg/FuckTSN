package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g2 {
    @NotNull
    public static final e1 a(@NotNull t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        m2 L0 = t0Var.L0();
        e1 e1Var = L0 instanceof e1 ? (e1) L0 : null;
        if (e1Var != null) {
            return e1Var;
        }
        throw new IllegalStateException(("This is should be simple type: " + t0Var).toString());
    }

    @JvmOverloads
    @NotNull
    public static final t0 b(@NotNull t0 t0Var, @NotNull List<? extends c2> newArguments, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g newAnnotations) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        kotlin.jvm.internal.g0.p(newArguments, "newArguments");
        kotlin.jvm.internal.g0.p(newAnnotations, "newAnnotations");
        return e(t0Var, newArguments, newAnnotations, null, 4, null);
    }

    @JvmOverloads
    @NotNull
    public static final t0 c(@NotNull t0 t0Var, @NotNull List<? extends c2> newArguments, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g newAnnotations, @NotNull List<? extends c2> newArgumentsForUpperBound) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        kotlin.jvm.internal.g0.p(newArguments, "newArguments");
        kotlin.jvm.internal.g0.p(newAnnotations, "newAnnotations");
        kotlin.jvm.internal.g0.p(newArgumentsForUpperBound, "newArgumentsForUpperBound");
        if ((newArguments.isEmpty() || newArguments == t0Var.G0()) && newAnnotations == t0Var.getAnnotations()) {
            return t0Var;
        }
        t1 H0 = t0Var.H0();
        if ((newAnnotations instanceof kotlin.reflect.jvm.internal.impl.descriptors.annotations.o) && ((kotlin.reflect.jvm.internal.impl.descriptors.annotations.o) newAnnotations).isEmpty()) {
            newAnnotations = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b();
        }
        t1 a6 = u1.a(H0, newAnnotations);
        m2 L0 = t0Var.L0();
        if (L0 instanceof k0) {
            k0 k0Var = (k0) L0;
            return w0.e(d(k0Var.Q0(), newArguments, a6), d(k0Var.R0(), newArgumentsForUpperBound, a6));
        }
        if (L0 instanceof e1) {
            return d((e1) L0, newArguments, a6);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmOverloads
    @NotNull
    public static final e1 d(@NotNull e1 e1Var, @NotNull List<? extends c2> newArguments, @NotNull t1 newAttributes) {
        kotlin.jvm.internal.g0.p(e1Var, "<this>");
        kotlin.jvm.internal.g0.p(newArguments, "newArguments");
        kotlin.jvm.internal.g0.p(newAttributes, "newAttributes");
        return (newArguments.isEmpty() && newAttributes == e1Var.H0()) ? e1Var : newArguments.isEmpty() ? e1Var.O0(newAttributes) : e1Var instanceof kotlin.reflect.jvm.internal.impl.types.error.g ? ((kotlin.reflect.jvm.internal.impl.types.error.g) e1Var).U0(newArguments) : w0.m(newAttributes, e1Var.I0(), newArguments, e1Var.J0(), null, 16, null);
    }

    public static /* synthetic */ t0 e(t0 t0Var, List list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, List list2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            list = t0Var.G0();
        }
        if ((i6 & 2) != 0) {
            gVar = t0Var.getAnnotations();
        }
        if ((i6 & 4) != 0) {
            list2 = list;
        }
        return c(t0Var, list, gVar, list2);
    }

    public static /* synthetic */ e1 f(e1 e1Var, List list, t1 t1Var, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            list = e1Var.G0();
        }
        if ((i6 & 2) != 0) {
            t1Var = e1Var.H0();
        }
        return d(e1Var, list, t1Var);
    }
}
