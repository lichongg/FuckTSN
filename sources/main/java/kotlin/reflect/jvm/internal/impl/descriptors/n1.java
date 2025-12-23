package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\ntypeParameterUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeParameterUtils.kt\norg/jetbrains/kotlin/descriptors/TypeParameterUtilsKt\n+ 2 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n16#2,2:101\n1563#3:103\n1634#3,3:104\n*S KotlinDebug\n*F\n+ 1 typeParameterUtils.kt\norg/jetbrains/kotlin/descriptors/TypeParameterUtilsKt\n*L\n37#1:101,2\n42#1:103\n42#1:104,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n1 {
    private static final u0 e(kotlin.reflect.jvm.internal.impl.types.t0 t0Var, g gVar, int i6) {
        if (gVar == null || kotlin.reflect.jvm.internal.impl.types.error.i.m(gVar)) {
            return null;
        }
        int size = gVar.t().size() + i6;
        if (gVar.k()) {
            List<c2> subList = t0Var.G0().subList(i6, size);
            k b6 = gVar.b();
            return new u0(gVar, subList, e(t0Var, b6 instanceof g ? (g) b6 : null, size));
        }
        if (size != t0Var.G0().size()) {
            kotlin.reflect.jvm.internal.impl.resolve.i.E(gVar);
        }
        return new u0(gVar, t0Var.G0().subList(i6, t0Var.G0().size()), null);
    }

    @Nullable
    public static final u0 d(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var) {
        kotlin.jvm.internal.g0.p(t0Var, "<this>");
        f c6 = t0Var.I0().c();
        return e(t0Var, c6 instanceof g ? (g) c6 : null, 0);
    }

    private static final b f(j1 j1Var, k kVar, int i6) {
        return new b(j1Var, kVar, i6);
    }

    @NotNull
    public static final List<j1> g(@NotNull g gVar) {
        List<j1> list;
        k kVar;
        w1 o5;
        kotlin.jvm.internal.g0.p(gVar, "<this>");
        List<j1> t5 = gVar.t();
        kotlin.jvm.internal.g0.o(t5, "getDeclaredTypeParameters(...)");
        if (!gVar.k() && !(gVar.b() instanceof a)) {
            return t5;
        }
        List I3 = kotlin.sequences.p.I3(kotlin.sequences.p.k1(kotlin.sequences.p.P0(kotlin.sequences.p.F3(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.u(gVar), k1.f44937a), l1.f44938a), m1.f44939a));
        Iterator<k> it = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.u(gVar).iterator();
        while (true) {
            list = null;
            if (!it.hasNext()) {
                kVar = null;
                break;
            }
            kVar = it.next();
            if (kVar instanceof d) {
                break;
            }
        }
        d dVar = (d) kVar;
        if (dVar != null && (o5 = dVar.o()) != null) {
            list = o5.getParameters();
        }
        if (list == null) {
            list = kotlin.collections.f0.J();
        }
        if (I3.isEmpty() && list.isEmpty()) {
            List<j1> t6 = gVar.t();
            kotlin.jvm.internal.g0.o(t6, "getDeclaredTypeParameters(...)");
            return t6;
        }
        List<j1> I4 = kotlin.collections.f0.I4(I3, list);
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(I4, 10));
        for (j1 j1Var : I4) {
            kotlin.jvm.internal.g0.m(j1Var);
            arrayList.add(f(j1Var, gVar, t5.size()));
        }
        return kotlin.collections.f0.I4(t5, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(k it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return it instanceof a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(k it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return !(it instanceof j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.sequences.m j(k it) {
        kotlin.jvm.internal.g0.p(it, "it");
        List<j1> typeParameters = ((a) it).getTypeParameters();
        kotlin.jvm.internal.g0.o(typeParameters, "getTypeParameters(...)");
        return kotlin.collections.f0.E1(typeParameters);
    }
}
