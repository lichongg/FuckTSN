package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nflexibleTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 flexibleTypes.kt\norg/jetbrains/kotlin/types/FlexibleTypesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,174:1\n295#2:175\n1740#2,3:176\n296#2:179\n1563#2:180\n1634#2,3:181\n1563#2:184\n1634#2,3:185\n*S KotlinDebug\n*F\n+ 1 flexibleTypes.kt\norg/jetbrains/kotlin/types/FlexibleTypesKt\n*L\n50#1:175\n51#1:176,3\n50#1:179\n62#1:180\n62#1:181,3\n65#1:184\n65#1:185,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n0 {
    @NotNull
    public static final k0 a(@NotNull t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        m2 L0 = t0Var.L0();
        kotlin.jvm.internal.g0.n(L0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (k0) L0;
    }

    public static final boolean b(@NotNull t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        return t0Var.L0() instanceof k0;
    }

    @NotNull
    public static final e1 c(@NotNull t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        m2 L0 = t0Var.L0();
        if (L0 instanceof k0) {
            return ((k0) L0).Q0();
        }
        if (L0 instanceof e1) {
            return (e1) L0;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final e1 d(@NotNull t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        m2 L0 = t0Var.L0();
        if (L0 instanceof k0) {
            return ((k0) L0).R0();
        }
        if (L0 instanceof e1) {
            return (e1) L0;
        }
        throw new NoWhenBranchMatchedException();
    }
}
