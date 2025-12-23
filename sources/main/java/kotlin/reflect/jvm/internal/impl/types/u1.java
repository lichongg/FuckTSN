package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.s1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAttributes.kt\norg/jetbrains/kotlin/types/TypeAttributesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u1 {
    @NotNull
    public static final t1 a(@NotNull t1 t1Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g newAnnotations) {
        t1 q5;
        kotlin.jvm.internal.g0.p(t1Var, "<this>");
        kotlin.jvm.internal.g0.p(newAnnotations, "newAnnotations");
        if (u.a(t1Var) == newAnnotations) {
            return t1Var;
        }
        t b6 = u.b(t1Var);
        if (b6 != null && (q5 = t1Var.q(b6)) != null) {
            t1Var = q5;
        }
        return (newAnnotations.iterator().hasNext() || !newAnnotations.isEmpty()) ? t1Var.p(new t(newAnnotations)) : t1Var;
    }

    @NotNull
    public static final t1 b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        kotlin.jvm.internal.g0.p(gVar, "<this>");
        return s1.a.a(y.f47369a, gVar, null, null, 6, null);
    }
}
