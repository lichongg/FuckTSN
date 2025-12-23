package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.impl.types.x1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nutils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 utils.kt\norg/jetbrains/kotlin/types/checker/UtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,108:1\n1761#2,3:109\n*S KotlinDebug\n*F\n+ 1 utils.kt\norg/jetbrains/kotlin/types/checker/UtilsKt\n*L\n51#1:109,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d0 {
    private static final String b(w1 w1Var) {
        StringBuilder sb = new StringBuilder();
        c("type: " + w1Var, sb);
        c("hashCode: " + w1Var.hashCode(), sb);
        c("javaClass: " + w1Var.getClass().getCanonicalName(), sb);
        for (kotlin.reflect.jvm.internal.impl.descriptors.k c6 = w1Var.c(); c6 != null; c6 = c6.b()) {
            c("fqName: " + kotlin.reflect.jvm.internal.impl.renderer.m.f46581h.N(c6), sb);
            c("javaClass: " + c6.getClass().getCanonicalName(), sb);
        }
        return sb.toString();
    }

    private static final StringBuilder c(String str, StringBuilder sb) {
        g0.p(str, "<this>");
        sb.append(str);
        sb.append('\n');
        return sb;
    }

    @Nullable
    public static final t0 d(@NotNull t0 subtype, @NotNull t0 supertype, @NotNull z typeCheckingProcedureCallbacks) {
        g0.p(subtype, "subtype");
        g0.p(supertype, "supertype");
        g0.p(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new w(subtype, null));
        w1 I0 = supertype.I0();
        while (!arrayDeque.isEmpty()) {
            w wVar = (w) arrayDeque.poll();
            t0 type = wVar.getType();
            w1 I02 = type.I0();
            if (typeCheckingProcedureCallbacks.a(I02, I0)) {
                boolean J0 = type.J0();
                for (w a6 = wVar.a(); a6 != null; a6 = a6.a()) {
                    t0 type2 = a6.getType();
                    List<c2> G0 = type2.G0();
                    if (!(G0 instanceof Collection) || !G0.isEmpty()) {
                        Iterator<T> it = G0.iterator();
                        while (it.hasNext()) {
                            Variance c6 = ((c2) it.next()).c();
                            Variance variance = Variance.INVARIANT;
                            if (c6 != variance) {
                                t0 n6 = kotlin.reflect.jvm.internal.impl.resolve.calls.inference.e.h(x1.f47366c.a(type2), false, 1, null).c().n(type, variance);
                                g0.o(n6, "safeSubstitute(...)");
                                type = a(n6);
                                break;
                            }
                        }
                    }
                    type = x1.f47366c.a(type2).c().n(type, Variance.INVARIANT);
                    g0.m(type);
                    J0 = J0 || type2.J0();
                }
                w1 I03 = type.I0();
                if (typeCheckingProcedureCallbacks.a(I03, I0)) {
                    return j2.p(type, J0);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(I03) + ", \n\nsupertype: " + b(I0) + " \n" + typeCheckingProcedureCallbacks.a(I03, I0));
            }
            for (t0 t0Var : I02.i()) {
                g0.m(t0Var);
                arrayDeque.add(new w(t0Var, wVar));
            }
        }
        return null;
    }

    private static final t0 a(t0 t0Var) {
        return kotlin.reflect.jvm.internal.impl.types.typesApproximation.d.c(t0Var).d();
    }
}
