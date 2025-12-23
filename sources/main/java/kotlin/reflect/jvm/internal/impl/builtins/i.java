package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.o0;
import kotlin.reflect.jvm.internal.impl.builtins.functions.e;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.resolve.constants.y;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.u1;
import kotlin.reflect.jvm.internal.impl.types.w0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nfunctionTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 functionTypes.kt\norg/jetbrains/kotlin/builtins/FunctionTypesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,301:1\n1#2:302\n1563#3:303\n1634#3,3:304\n230#3,2:307\n1563#3:309\n1634#3,3:310\n1563#3:313\n1634#3,3:314\n1604#3,4:317\n*S KotlinDebug\n*F\n+ 1 functionTypes.kt\norg/jetbrains/kotlin/builtins/FunctionTypesKt\n*L\n160#1:303\n160#1:304,3\n195#1:307,2\n200#1:309\n200#1:310,3\n222#1:313\n222#1:314,3\n225#1:317,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {
    public static final int a(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c b6 = t0Var.getAnnotations().b(o.a.D);
        if (b6 == null) {
            return 0;
        }
        kotlin.reflect.jvm.internal.impl.resolve.constants.g gVar = (kotlin.reflect.jvm.internal.impl.resolve.constants.g) i1.K(b6.a(), o.f44573q);
        g0.n(gVar, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((kotlin.reflect.jvm.internal.impl.resolve.constants.n) gVar).a().intValue();
    }

    @JvmOverloads
    @NotNull
    public static final e1 b(@NotNull j builtIns, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, @Nullable t0 t0Var, @NotNull List<? extends t0> contextReceiverTypes, @NotNull List<? extends t0> parameterTypes, @Nullable List<kotlin.reflect.jvm.internal.impl.name.f> list, @NotNull t0 returnType, boolean z5) {
        g0.p(builtIns, "builtIns");
        g0.p(annotations, "annotations");
        g0.p(contextReceiverTypes, "contextReceiverTypes");
        g0.p(parameterTypes, "parameterTypes");
        g0.p(returnType, "returnType");
        List<c2> g6 = g(t0Var, contextReceiverTypes, parameterTypes, list, returnType, builtIns);
        kotlin.reflect.jvm.internal.impl.descriptors.d f6 = f(builtIns, parameterTypes.size() + contextReceiverTypes.size() + (t0Var == null ? 0 : 1), z5);
        if (t0Var != null) {
            annotations = u(annotations, builtIns);
        }
        if (!contextReceiverTypes.isEmpty()) {
            annotations = t(annotations, builtIns, contextReceiverTypes.size());
        }
        return w0.h(u1.b(annotations), f6, g6);
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.name.f d(@NotNull t0 t0Var) {
        String a6;
        g0.p(t0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c b6 = t0Var.getAnnotations().b(o.a.E);
        if (b6 == null) {
            return null;
        }
        Object n52 = f0.n5(b6.a().values());
        y yVar = n52 instanceof y ? (y) n52 : null;
        if (yVar != null && (a6 = yVar.a()) != null) {
            if (!kotlin.reflect.jvm.internal.impl.name.f.j(a6)) {
                a6 = null;
            }
            if (a6 != null) {
                return kotlin.reflect.jvm.internal.impl.name.f.h(a6);
            }
        }
        return null;
    }

    @NotNull
    public static final List<t0> e(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        p(t0Var);
        int a6 = a(t0Var);
        if (a6 == 0) {
            return f0.J();
        }
        List<c2> subList = t0Var.G0().subList(0, a6);
        ArrayList arrayList = new ArrayList(f0.d0(subList, 10));
        Iterator<T> it = subList.iterator();
        while (it.hasNext()) {
            arrayList.add(((c2) it.next()).getType());
        }
        return arrayList;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.d f(@NotNull j builtIns, int i6, boolean z5) {
        g0.p(builtIns, "builtIns");
        kotlin.reflect.jvm.internal.impl.descriptors.d Y = z5 ? builtIns.Y(i6) : builtIns.D(i6);
        g0.m(Y);
        return Y;
    }

    @NotNull
    public static final List<c2> g(@Nullable t0 t0Var, @NotNull List<? extends t0> contextReceiverTypes, @NotNull List<? extends t0> parameterTypes, @Nullable List<kotlin.reflect.jvm.internal.impl.name.f> list, @NotNull t0 returnType, @NotNull j builtIns) {
        kotlin.reflect.jvm.internal.impl.name.f fVar;
        j jVar;
        g0.p(contextReceiverTypes, "contextReceiverTypes");
        g0.p(parameterTypes, "parameterTypes");
        g0.p(returnType, "returnType");
        g0.p(builtIns, "builtIns");
        int i6 = 0;
        ArrayList arrayList = new ArrayList(parameterTypes.size() + contextReceiverTypes.size() + (t0Var != null ? 1 : 0) + 1);
        List<? extends t0> list2 = contextReceiverTypes;
        ArrayList arrayList2 = new ArrayList(f0.d0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(kotlin.reflect.jvm.internal.impl.types.typeUtil.e.e((t0) it.next()));
        }
        arrayList.addAll(arrayList2);
        kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, t0Var != null ? kotlin.reflect.jvm.internal.impl.types.typeUtil.e.e(t0Var) : null);
        for (Object obj : parameterTypes) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                f0.b0();
            }
            t0 t0Var2 = (t0) obj;
            if (list == null || (fVar = list.get(i6)) == null || fVar.i()) {
                fVar = null;
            }
            if (fVar != null) {
                kotlin.reflect.jvm.internal.impl.name.c cVar = o.a.E;
                kotlin.reflect.jvm.internal.impl.name.f fVar2 = o.f44569m;
                String b6 = fVar.b();
                g0.o(b6, "asString(...)");
                Map k6 = i1.k(o0.a(fVar2, new y(b6)));
                jVar = builtIns;
                t0Var2 = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.D(t0Var2, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.a(f0.F4(t0Var2.getAnnotations(), new kotlin.reflect.jvm.internal.impl.descriptors.annotations.k(jVar, cVar, k6, false, 8, null))));
            } else {
                jVar = builtIns;
            }
            arrayList.add(kotlin.reflect.jvm.internal.impl.types.typeUtil.e.e(t0Var2));
            i6 = i7;
            builtIns = jVar;
        }
        arrayList.add(kotlin.reflect.jvm.internal.impl.types.typeUtil.e.e(returnType));
        return arrayList;
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.builtins.functions.e h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        g0.p(kVar, "<this>");
        if ((kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && j.C0(kVar)) {
            return i(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.p(kVar));
        }
        return null;
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.builtins.functions.e j(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        if (c6 != null) {
            return h(c6);
        }
        return null;
    }

    @Nullable
    public static final t0 k(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        p(t0Var);
        if (!s(t0Var)) {
            return null;
        }
        return t0Var.G0().get(a(t0Var)).getType();
    }

    @NotNull
    public static final t0 l(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        p(t0Var);
        t0 type = ((c2) f0.u3(t0Var.G0())).getType();
        g0.o(type, "getType(...)");
        return type;
    }

    @NotNull
    public static final List<c2> m(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        p(t0Var);
        return t0Var.G0().subList(a(t0Var) + (n(t0Var) ? 1 : 0), r0.size() - 1);
    }

    public static final boolean n(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        return p(t0Var) && s(t0Var);
    }

    public static final boolean o(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        g0.p(kVar, "<this>");
        kotlin.reflect.jvm.internal.impl.builtins.functions.e h6 = h(kVar);
        return g0.g(h6, e.a.f44424f) || g0.g(h6, e.d.f44427f);
    }

    public static final boolean p(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
        return c6 != null && o(c6);
    }

    public static final boolean q(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        return g0.g(j(t0Var), e.a.f44424f);
    }

    public static final boolean r(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        return g0.g(j(t0Var), e.d.f44427f);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g t(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull j builtIns, int i6) {
        g0.p(gVar, "<this>");
        g0.p(builtIns, "builtIns");
        kotlin.reflect.jvm.internal.impl.name.c cVar = o.a.D;
        return gVar.l(cVar) ? gVar : kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.a(f0.F4(gVar, new kotlin.reflect.jvm.internal.impl.descriptors.annotations.k(builtIns, cVar, i1.k(o0.a(o.f44573q, new kotlin.reflect.jvm.internal.impl.resolve.constants.n(i6))), false, 8, null)));
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull j builtIns) {
        g0.p(gVar, "<this>");
        g0.p(builtIns, "builtIns");
        kotlin.reflect.jvm.internal.impl.name.c cVar = o.a.C;
        return gVar.l(cVar) ? gVar : kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.a(f0.F4(gVar, new kotlin.reflect.jvm.internal.impl.descriptors.annotations.k(builtIns, cVar, i1.z(), false, 8, null)));
    }

    private static final kotlin.reflect.jvm.internal.impl.builtins.functions.e i(kotlin.reflect.jvm.internal.impl.name.d dVar) {
        if (dVar.f() && !dVar.e()) {
            kotlin.reflect.jvm.internal.impl.builtins.functions.f a6 = kotlin.reflect.jvm.internal.impl.builtins.functions.f.f44428c.a();
            kotlin.reflect.jvm.internal.impl.name.c d6 = dVar.m().d();
            String b6 = dVar.j().b();
            g0.o(b6, "asString(...)");
            return a6.b(d6, b6);
        }
        return null;
    }

    private static final boolean s(t0 t0Var) {
        if (t0Var.getAnnotations().b(o.a.C) != null) {
            return true;
        }
        return false;
    }
}
