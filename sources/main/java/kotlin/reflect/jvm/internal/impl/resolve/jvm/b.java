package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.resolve.i;
import kotlin.reflect.jvm.internal.impl.resolve.j;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\ninlineClassManglingRules.kt\nKotlin\n*S Kotlin\n*F\n+ 1 inlineClassManglingRules.kt\norg/jetbrains/kotlin/resolve/jvm/InlineClassManglingRulesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n1761#2,3:54\n1761#2,3:57\n1#3:60\n*S KotlinDebug\n*F\n+ 1 inlineClassManglingRules.kt\norg/jetbrains/kotlin/resolve/jvm/InlineClassManglingRulesKt\n*L\n21#1:54,3\n27#1:57,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {
    public static final boolean c(@NotNull k kVar) {
        g0.p(kVar, "<this>");
        return j.g(kVar) && !a((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar);
    }

    public static final boolean d(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        f c6 = t0Var.I0().c();
        return c6 != null && ((j.b(c6) && c(c6)) || j.i(t0Var));
    }

    public static final boolean f(@NotNull CallableMemberDescriptor descriptor) {
        g0.p(descriptor, "descriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.c cVar = descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.c ? (kotlin.reflect.jvm.internal.impl.descriptors.c) descriptor : null;
        if (cVar == null || r.g(cVar.getVisibility())) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d J = cVar.J();
        g0.o(J, "getConstructedClass(...)");
        if (j.g(J) || i.G(cVar.J())) {
            return false;
        }
        List<q1> g6 = cVar.g();
        g0.o(g6, "getValueParameters(...)");
        List<q1> list = g6;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            t0 type = ((q1) it.next()).getType();
            g0.o(type, "getType(...)");
            if (e(type)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        return g0.g(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o(dVar), o.f44580x);
    }

    private static final boolean b(t0 t0Var, boolean z5) {
        j1 j1Var;
        f c6 = t0Var.I0().c();
        if (c6 instanceof j1) {
            j1Var = (j1) c6;
        } else {
            j1Var = null;
        }
        if (j1Var == null) {
            return false;
        }
        if ((!z5 && j.d(j1Var)) || !e(kotlin.reflect.jvm.internal.impl.types.typeUtil.e.p(j1Var))) {
            return false;
        }
        return true;
    }

    private static final boolean e(t0 t0Var) {
        if (d(t0Var) || b(t0Var, true)) {
            return true;
        }
        return false;
    }
}
