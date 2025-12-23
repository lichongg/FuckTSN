package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSpecialTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialTypes.kt\norg/jetbrains/kotlin/types/SpecialTypesKt\n+ 2 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,216:1\n102#2,2:217\n104#2,6:222\n112#2,7:229\n1563#3:219\n1634#3,2:220\n1636#3:228\n*S KotlinDebug\n*F\n+ 1 SpecialTypes.kt\norg/jetbrains/kotlin/types/SpecialTypesKt\n*L\n214#1:217,2\n214#1:222,6\n214#1:229,7\n214#1:219\n214#1:220,2\n214#1:228\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i1 {
    @Nullable
    public static final a a(@NotNull t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        m2 L0 = t0Var.L0();
        if (L0 instanceof a) {
            return (a) L0;
        }
        return null;
    }

    @Nullable
    public static final e1 b(@NotNull t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        a a6 = a(t0Var);
        if (a6 != null) {
            return a6.U0();
        }
        return null;
    }

    public static final boolean c(@NotNull t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        return t0Var.L0() instanceof z;
    }

    @NotNull
    public static final m2 e(@NotNull m2 m2Var, boolean z5) {
        kotlin.jvm.internal.g0.p(m2Var, "<this>");
        z c6 = z.a.c(z.f47374d, m2Var, z5, false, 4, null);
        if (c6 != null) {
            return c6;
        }
        e1 g6 = g(m2Var);
        return g6 != null ? g6 : m2Var.M0(false);
    }

    public static /* synthetic */ m2 f(m2 m2Var, boolean z5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        return e(m2Var, z5);
    }

    @NotNull
    public static final e1 h(@NotNull e1 e1Var, boolean z5) {
        kotlin.jvm.internal.g0.p(e1Var, "<this>");
        z c6 = z.a.c(z.f47374d, e1Var, z5, false, 4, null);
        if (c6 != null) {
            return c6;
        }
        e1 g6 = g(e1Var);
        return g6 == null ? e1Var.M0(false) : g6;
    }

    public static /* synthetic */ e1 i(e1 e1Var, boolean z5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        return h(e1Var, z5);
    }

    @NotNull
    public static final e1 j(@NotNull e1 e1Var, @NotNull e1 abbreviatedType) {
        kotlin.jvm.internal.g0.p(e1Var, "<this>");
        kotlin.jvm.internal.g0.p(abbreviatedType, "abbreviatedType");
        return x0.a(e1Var) ? e1Var : new a(e1Var, abbreviatedType);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.types.checker.i k(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.i iVar) {
        kotlin.jvm.internal.g0.p(iVar, "<this>");
        return new kotlin.reflect.jvm.internal.impl.types.checker.i(iVar.R0(), iVar.I0(), iVar.T0(), iVar.H0(), iVar.J0(), true);
    }

    private static final s0 d(s0 s0Var) {
        t0 t0Var;
        Collection<t0> i6 = s0Var.i();
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(i6, 10));
        Iterator<T> it = i6.iterator();
        boolean z5 = false;
        while (true) {
            t0Var = null;
            if (!it.hasNext()) {
                break;
            }
            t0 t0Var2 = (t0) it.next();
            if (j2.l(t0Var2)) {
                t0Var2 = f(t0Var2.L0(), false, 1, null);
                z5 = true;
            }
            arrayList.add(t0Var2);
        }
        if (!z5) {
            return null;
        }
        t0 l6 = s0Var.l();
        if (l6 != null) {
            if (j2.l(l6)) {
                l6 = f(l6.L0(), false, 1, null);
            }
            t0Var = l6;
        }
        return new s0(arrayList).s(t0Var);
    }

    private static final e1 g(t0 t0Var) {
        s0 s0Var;
        s0 d6;
        w1 I0 = t0Var.I0();
        if (I0 instanceof s0) {
            s0Var = (s0) I0;
        } else {
            s0Var = null;
        }
        if (s0Var == null || (d6 = d(s0Var)) == null) {
            return null;
        }
        return d6.j();
    }
}
