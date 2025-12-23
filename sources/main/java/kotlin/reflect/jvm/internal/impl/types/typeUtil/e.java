package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import e4.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.a1;
import kotlin.collections.f0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.e2;
import kotlin.reflect.jvm.internal.impl.types.error.g;
import kotlin.reflect.jvm.internal.impl.types.g2;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.k0;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.l2;
import kotlin.reflect.jvm.internal.impl.types.m2;
import kotlin.reflect.jvm.internal.impl.types.n1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.u1;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.impl.types.x0;
import kotlin.reflect.jvm.internal.impl.types.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTypeUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeUtils.kt\norg/jetbrains/kotlin/types/typeUtil/TypeUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,390:1\n245#1,14:415\n260#1:433\n249#1,12:434\n245#1,14:446\n260#1:464\n249#1,12:465\n256#1,3:483\n260#1:490\n256#1,3:491\n260#1:498\n256#1,3:499\n260#1:506\n381#1:532\n381#1:533\n381#1:534\n1761#2,3:391\n1563#2:394\n1634#2,3:395\n1617#2,9:399\n1869#2:408\n1870#2:410\n1626#2:411\n774#2:412\n865#2,2:413\n1563#2:429\n1634#2,3:430\n1563#2:460\n1634#2,3:461\n1761#2,3:477\n1761#2,3:480\n1563#2:486\n1634#2,3:487\n1563#2:494\n1634#2,3:495\n1563#2:502\n1634#2,3:503\n1563#2:507\n1634#2,3:508\n1563#2:511\n1634#2,3:512\n1761#2,3:515\n295#2,2:518\n1563#2:520\n1634#2,3:521\n1563#2:524\n1634#2,3:525\n1563#2:528\n1634#2,3:529\n1#3:398\n1#3:409\n*S KotlinDebug\n*F\n+ 1 TypeUtils.kt\norg/jetbrains/kotlin/types/typeUtil/TypeUtilsKt\n*L\n184#1:415,14\n184#1:433\n184#1:434,12\n185#1:446,14\n185#1:464\n185#1:465,12\n248#1:483,3\n248#1:490\n249#1:491,3\n249#1:498\n251#1:499,3\n251#1:506\n373#1:532\n376#1:533\n379#1:534\n80#1:391,3\n131#1:394\n131#1:395,3\n167#1:399,9\n167#1:408\n167#1:410\n167#1:411\n173#1:412\n173#1:413,2\n184#1:429\n184#1:430,3\n185#1:460\n185#1:461,3\n223#1:477,3\n235#1:480,3\n248#1:486\n248#1:487,3\n249#1:494\n249#1:495,3\n251#1:502\n251#1:503,3\n258#1:507\n258#1:508,3\n265#1:511\n265#1:512,3\n291#1:515,3\n298#1:518,2\n308#1:520\n308#1:521,3\n327#1:524\n327#1:525,3\n335#1:528\n335#1:529,3\n167#1:409\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {
    public static final boolean A(@NotNull t0 type) {
        g0.p(type, "type");
        return (type instanceof g) && ((g) type).S0().isUnresolved();
    }

    @NotNull
    public static final t0 B(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        t0 n6 = j2.n(t0Var);
        g0.o(n6, "makeNotNullable(...)");
        return n6;
    }

    @NotNull
    public static final t0 C(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        t0 o5 = j2.o(t0Var);
        g0.o(o5, "makeNullable(...)");
        return o5;
    }

    @NotNull
    public static final t0 D(@NotNull t0 t0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g newAnnotations) {
        g0.p(t0Var, "<this>");
        g0.p(newAnnotations, "newAnnotations");
        return (t0Var.getAnnotations().isEmpty() && newAnnotations.isEmpty()) ? t0Var : t0Var.L0().O0(u1.a(t0Var.H0(), newAnnotations));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [kotlin.reflect.jvm.internal.impl.types.m2] */
    @NotNull
    public static final t0 E(@NotNull t0 t0Var) {
        e1 e1Var;
        g0.p(t0Var, "<this>");
        m2 L0 = t0Var.L0();
        if (L0 instanceof k0) {
            k0 k0Var = (k0) L0;
            e1 Q0 = k0Var.Q0();
            if (!Q0.I0().getParameters().isEmpty() && Q0.I0().c() != null) {
                List<j1> parameters = Q0.I0().getParameters();
                g0.o(parameters, "getParameters(...)");
                List<j1> list = parameters;
                ArrayList arrayList = new ArrayList(f0.d0(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new l1((j1) it.next()));
                }
                Q0 = g2.f(Q0, arrayList, null, 2, null);
            }
            e1 R0 = k0Var.R0();
            if (!R0.I0().getParameters().isEmpty() && R0.I0().c() != null) {
                List<j1> parameters2 = R0.I0().getParameters();
                g0.o(parameters2, "getParameters(...)");
                List<j1> list2 = parameters2;
                ArrayList arrayList2 = new ArrayList(f0.d0(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new l1((j1) it2.next()));
                }
                R0 = g2.f(R0, arrayList2, null, 2, null);
            }
            e1Var = w0.e(Q0, R0);
        } else {
            if (!(L0 instanceof e1)) {
                throw new NoWhenBranchMatchedException();
            }
            e1 e1Var2 = (e1) L0;
            boolean isEmpty = e1Var2.I0().getParameters().isEmpty();
            e1Var = e1Var2;
            if (!isEmpty) {
                f c6 = e1Var2.I0().c();
                e1Var = e1Var2;
                if (c6 != null) {
                    List<j1> parameters3 = e1Var2.I0().getParameters();
                    g0.o(parameters3, "getParameters(...)");
                    List<j1> list3 = parameters3;
                    ArrayList arrayList3 = new ArrayList(f0.d0(list3, 10));
                    Iterator it3 = list3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(new l1((j1) it3.next()));
                    }
                    e1Var = g2.f(e1Var2, arrayList3, null, 2, null);
                }
            }
        }
        return l2.b(e1Var, L0);
    }

    public static final boolean F(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        return f(t0Var, c.f47336a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G(m2 it) {
        g0.p(it, "it");
        f c6 = it.I0().c();
        if (c6 != null) {
            return (c6 instanceof i1) || (c6 instanceof j1);
        }
        return false;
    }

    public static final boolean H(@Nullable t0 t0Var) {
        return t0Var == null || f(t0Var, d.f47337a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I(m2 it) {
        g0.p(it, "it");
        return (it instanceof n1) || (it.I0() instanceof w) || x0.a(it);
    }

    @NotNull
    public static final c2 e(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        return new e2(t0Var);
    }

    public static final boolean f(@NotNull t0 t0Var, @NotNull Function1<? super m2, Boolean> predicate) {
        g0.p(t0Var, "<this>");
        g0.p(predicate, "predicate");
        return j2.c(t0Var, predicate);
    }

    public static final boolean h(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        return f(t0Var, b.f47335a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(m2 it) {
        g0.p(it, "it");
        f c6 = it.I0().c();
        if (c6 != null) {
            return y(c6);
        }
        return false;
    }

    public static final boolean j(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        return j2.c(t0Var, a.f47334a);
    }

    @NotNull
    public static final c2 l(@NotNull t0 type, @NotNull Variance projectionKind, @Nullable j1 j1Var) {
        g0.p(type, "type");
        g0.p(projectionKind, "projectionKind");
        if ((j1Var != null ? j1Var.l() : null) == projectionKind) {
            projectionKind = Variance.INVARIANT;
        }
        return new e2(projectionKind, type);
    }

    @NotNull
    public static final Set<j1> m(@NotNull t0 t0Var, @Nullable Set<? extends j1> set) {
        g0.p(t0Var, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        n(t0Var, t0Var, linkedHashSet, set);
        return linkedHashSet;
    }

    @NotNull
    public static final j o(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        j p5 = t0Var.I0().p();
        g0.o(p5, "getBuiltIns(...)");
        return p5;
    }

    @NotNull
    public static final t0 p(@NotNull j1 j1Var) {
        Object obj;
        g0.p(j1Var, "<this>");
        List<t0> upperBounds = j1Var.getUpperBounds();
        g0.o(upperBounds, "getUpperBounds(...)");
        upperBounds.isEmpty();
        List<t0> upperBounds2 = j1Var.getUpperBounds();
        g0.o(upperBounds2, "getUpperBounds(...)");
        Iterator<T> it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            f c6 = ((t0) next).I0().c();
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) c6 : null;
            if (dVar != null && dVar.h() != ClassKind.INTERFACE && dVar.h() != ClassKind.ANNOTATION_CLASS) {
                obj = next;
                break;
            }
        }
        t0 t0Var = (t0) obj;
        if (t0Var != null) {
            return t0Var;
        }
        List<t0> upperBounds3 = j1Var.getUpperBounds();
        g0.o(upperBounds3, "getUpperBounds(...)");
        Object G2 = f0.G2(upperBounds3);
        g0.o(G2, "first(...)");
        return (t0) G2;
    }

    @JvmOverloads
    public static final boolean q(@NotNull j1 typeParameter) {
        g0.p(typeParameter, "typeParameter");
        return s(typeParameter, null, null, 6, null);
    }

    @JvmOverloads
    public static final boolean r(@NotNull j1 typeParameter, @Nullable w1 w1Var, @Nullable Set<? extends j1> set) {
        g0.p(typeParameter, "typeParameter");
        List<t0> upperBounds = typeParameter.getUpperBounds();
        g0.o(upperBounds, "getUpperBounds(...)");
        List<t0> list = upperBounds;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (t0 t0Var : list) {
            g0.m(t0Var);
            if (g(t0Var, typeParameter.s().I0(), set) && (w1Var == null || g0.g(t0Var.I0(), w1Var))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean s(j1 j1Var, w1 w1Var, Set set, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            w1Var = null;
        }
        if ((i6 & 4) != 0) {
            set = null;
        }
        return r(j1Var, w1Var, set);
    }

    public static final boolean t(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        return j.g0(t0Var);
    }

    public static final boolean u(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        return j.o0(t0Var);
    }

    public static final boolean v(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        if (t0Var instanceof kotlin.reflect.jvm.internal.impl.types.e) {
            return true;
        }
        return (t0Var instanceof z) && (((z) t0Var).U0() instanceof kotlin.reflect.jvm.internal.impl.types.e);
    }

    public static final boolean w(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        if (t0Var instanceof n1) {
            return true;
        }
        return (t0Var instanceof z) && (((z) t0Var).U0() instanceof n1);
    }

    public static final boolean x(@NotNull t0 t0Var, @NotNull t0 superType) {
        g0.p(t0Var, "<this>");
        g0.p(superType, "superType");
        return kotlin.reflect.jvm.internal.impl.types.checker.e.f47168a.d(t0Var, superType);
    }

    public static final boolean y(@NotNull f fVar) {
        g0.p(fVar, "<this>");
        return (fVar instanceof j1) && (((j1) fVar).b() instanceof i1);
    }

    public static final boolean z(@NotNull t0 t0Var) {
        g0.p(t0Var, "<this>");
        return j2.m(t0Var);
    }

    private static final boolean g(t0 t0Var, w1 w1Var, Set<? extends j1> set) {
        kotlin.reflect.jvm.internal.impl.descriptors.g gVar;
        List<j1> list;
        j1 j1Var;
        boolean g6;
        if (g0.g(t0Var.I0(), w1Var)) {
            return true;
        }
        f c6 = t0Var.I0().c();
        if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) {
            gVar = (kotlin.reflect.jvm.internal.impl.descriptors.g) c6;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            list = gVar.t();
        } else {
            list = null;
        }
        Iterable<a1> m6 = f0.m6(t0Var.G0());
        if ((m6 instanceof Collection) && ((Collection) m6).isEmpty()) {
            return false;
        }
        for (a1 a1Var : m6) {
            int a6 = a1Var.a();
            c2 c2Var = (c2) a1Var.b();
            if (list != null) {
                j1Var = (j1) f0.b3(list, a6);
            } else {
                j1Var = null;
            }
            if ((j1Var != null && set != null && set.contains(j1Var)) || c2Var.b()) {
                g6 = false;
            } else {
                t0 type = c2Var.getType();
                g0.o(type, "getType(...)");
                g6 = g(type, w1Var, set);
            }
            if (g6) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean k(m2 m2Var) {
        return Boolean.valueOf(j2.m(m2Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void n(t0 t0Var, t0 t0Var2, Set<j1> set, Set<? extends j1> set2) {
        kotlin.reflect.jvm.internal.impl.descriptors.g gVar;
        List<j1> list;
        j1 j1Var;
        f c6 = t0Var.I0().c();
        if (c6 instanceof j1) {
            if (!g0.g(t0Var.I0(), t0Var2.I0())) {
                set.add(c6);
                return;
            }
            for (t0 t0Var3 : ((j1) c6).getUpperBounds()) {
                g0.m(t0Var3);
                n(t0Var3, t0Var2, set, set2);
            }
            return;
        }
        f c7 = t0Var.I0().c();
        if (c7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) {
            gVar = (kotlin.reflect.jvm.internal.impl.descriptors.g) c7;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            list = gVar.t();
        } else {
            list = null;
        }
        int i6 = 0;
        for (c2 c2Var : t0Var.G0()) {
            int i7 = i6 + 1;
            if (list != null) {
                j1Var = (j1) f0.b3(list, i6);
            } else {
                j1Var = null;
            }
            if ((j1Var == null || set2 == null || !set2.contains(j1Var)) && !c2Var.b() && !f0.a2(set, c2Var.getType().I0().c()) && !g0.g(c2Var.getType().I0(), t0Var2.I0())) {
                t0 type = c2Var.getType();
                g0.o(type, "getType(...)");
                n(type, t0Var2, set, set2);
            }
            i6 = i7;
        }
    }
}
