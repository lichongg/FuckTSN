package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTypeWithEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeWithEnhancement.kt\norg/jetbrains/kotlin/types/TypeWithEnhancementKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,169:1\n1563#2:170\n1634#2,3:171\n1740#2,3:174\n*S KotlinDebug\n*F\n+ 1 TypeWithEnhancement.kt\norg/jetbrains/kotlin/types/TypeWithEnhancementKt\n*L\n97#1:170\n97#1:171,3\n112#1:174,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l2 {
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final t0 a(@NotNull t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        if (t0Var instanceof k2) {
            return ((k2) t0Var).o0();
        }
        return null;
    }

    @NotNull
    public static final m2 b(@NotNull m2 m2Var, @NotNull t0 origin) {
        kotlin.jvm.internal.g0.p(m2Var, "<this>");
        kotlin.jvm.internal.g0.p(origin, "origin");
        return d(m2Var, a(origin));
    }

    @NotNull
    public static final m2 c(@NotNull m2 m2Var, @NotNull t0 origin, @NotNull Function1<? super t0, ? extends t0> transform) {
        kotlin.jvm.internal.g0.p(m2Var, "<this>");
        kotlin.jvm.internal.g0.p(origin, "origin");
        kotlin.jvm.internal.g0.p(transform, "transform");
        t0 a6 = a(origin);
        return d(m2Var, a6 != null ? transform.invoke(a6) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final m2 d(@NotNull m2 m2Var, @Nullable t0 t0Var) {
        kotlin.jvm.internal.g0.p(m2Var, "<this>");
        if (m2Var instanceof k2) {
            return d(((k2) m2Var).T(), t0Var);
        }
        if (t0Var == null || kotlin.jvm.internal.g0.g(t0Var, m2Var)) {
            return m2Var;
        }
        if (m2Var instanceof e1) {
            return new h1((e1) m2Var, t0Var);
        }
        if (m2Var instanceof k0) {
            return new m0((k0) m2Var, t0Var);
        }
        throw new NoWhenBranchMatchedException();
    }
}
