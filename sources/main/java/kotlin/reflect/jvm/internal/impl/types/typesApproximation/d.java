package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.renderer.a;
import kotlin.reflect.jvm.internal.impl.renderer.u;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.e2;
import kotlin.reflect.jvm.internal.impl.types.g2;
import kotlin.reflect.jvm.internal.impl.types.h2;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.l2;
import kotlin.reflect.jvm.internal.impl.types.m2;
import kotlin.reflect.jvm.internal.impl.types.n0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.impl.types.x1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCapturedTypeApproximation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CapturedTypeApproximation.kt\norg/jetbrains/kotlin/types/typesApproximation/CapturedTypeApproximationKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,178:1\n1761#2,3:179\n1563#2:183\n1634#2,3:184\n1#3:182\n*S KotlinDebug\n*F\n+ 1 CapturedTypeApproximation.kt\norg/jetbrains/kotlin/types/typesApproximation/CapturedTypeApproximationKt\n*L\n158#1:179,3\n167#1:183\n167#1:184,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends x1 {
        @Override // kotlin.reflect.jvm.internal.impl.types.x1
        public c2 k(w1 key) {
            g0.p(key, "key");
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b bVar = key instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b ? (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b) key : null;
            if (bVar == null) {
                return null;
            }
            return bVar.getProjection().b() ? new e2(Variance.OUT_VARIANCE, bVar.getProjection().getType()) : bVar.getProjection();
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47342a;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f47342a = iArr;
        }
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<t0> c(@NotNull t0 type) {
        Object h6;
        g0.p(type, "type");
        if (n0.b(type)) {
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<t0> c6 = c(n0.c(type));
            kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<t0> c7 = c(n0.d(type));
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<>(l2.b(w0.e(n0.c(c6.c()), n0.d(c7.c())), type), l2.b(w0.e(n0.c(c6.d()), n0.d(c7.d())), type));
        }
        w1 I0 = type.I0();
        if (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.e.f(type)) {
            g0.n(I0, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
            c2 projection = ((kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b) I0).getProjection();
            t0 type2 = projection.getType();
            g0.o(type2, "getType(...)");
            t0 d6 = d(type2, type);
            int i6 = a.f47342a[projection.c().ordinal()];
            if (i6 == 2) {
                return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<>(d6, kotlin.reflect.jvm.internal.impl.types.typeUtil.e.o(type).J());
            }
            if (i6 == 3) {
                e1 I = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.o(type).I();
                g0.o(I, "getNothingType(...)");
                return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<>(d(I, type), d6);
            }
            throw new AssertionError("Only nontrivial projections should have been captured, not: " + projection);
        }
        if (type.G0().isEmpty() || type.G0().size() != I0.getParameters().size()) {
            return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<>(type, type);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<c2> G0 = type.G0();
        List<j1> parameters = I0.getParameters();
        g0.o(parameters, "getParameters(...)");
        for (Pair pair : f0.o6(G0, parameters)) {
            c2 c2Var = (c2) pair.component1();
            j1 j1Var = (j1) pair.component2();
            g0.m(j1Var);
            e j6 = j(c2Var, j1Var);
            if (c2Var.b()) {
                arrayList.add(j6);
                arrayList2.add(j6);
            } else {
                kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<e> g6 = g(j6);
                e a6 = g6.a();
                e b6 = g6.b();
                arrayList.add(a6);
                arrayList2.add(b6);
            }
        }
        boolean z5 = false;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!((e) it.next()).d()) {
                    z5 = true;
                    break;
                }
            }
        }
        if (z5) {
            h6 = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.o(type).I();
            g0.o(h6, "getNothingType(...)");
        } else {
            h6 = h(type, arrayList);
        }
        return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<>(h6, h(type, arrayList2));
    }

    @Nullable
    public static final c2 e(@Nullable c2 c2Var, boolean z5) {
        if (c2Var == null) {
            return null;
        }
        if (!c2Var.b()) {
            t0 type = c2Var.getType();
            g0.o(type, "getType(...)");
            if (j2.c(type, c.f47341a)) {
                Variance c6 = c2Var.c();
                g0.o(c6, "getProjectionKind(...)");
                return c6 == Variance.OUT_VARIANCE ? new e2(c6, c(type).d()) : z5 ? new e2(c6, c(type).c()) : i(c2Var);
            }
        }
        return c2Var;
    }

    private static final c2 i(c2 c2Var) {
        h2 g6 = h2.g(new b());
        g0.o(g6, "create(...)");
        return g6.t(c2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 l(u withOptions) {
        g0.p(withOptions, "$this$withOptions");
        withOptions.p(a.C0908a.f46560a);
        return n1.f44123a;
    }

    private static final t0 d(t0 t0Var, t0 t0Var2) {
        t0 q5 = j2.q(t0Var, t0Var2.J0());
        g0.o(q5, "makeNullableIfNeeded(...)");
        return q5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean f(m2 m2Var) {
        g0.m(m2Var);
        return Boolean.valueOf(kotlin.reflect.jvm.internal.impl.resolve.calls.inference.e.f(m2Var));
    }

    private static final kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<e> g(e eVar) {
        kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<t0> c6 = c(eVar.a());
        t0 a6 = c6.a();
        t0 b6 = c6.b();
        kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<t0> c7 = c(eVar.b());
        return new kotlin.reflect.jvm.internal.impl.types.typesApproximation.a<>(new e(eVar.c(), b6, c7.a()), new e(eVar.c(), a6, c7.b()));
    }

    private static final t0 h(t0 t0Var, List<e> list) {
        t0Var.G0().size();
        list.size();
        List<e> list2 = list;
        ArrayList arrayList = new ArrayList(f0.d0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(k((e) it.next()));
        }
        return g2.e(t0Var, arrayList, null, null, 6, null);
    }

    private static final e j(c2 c2Var, j1 j1Var) {
        int i6 = a.f47342a[h2.c(j1Var.l(), c2Var).ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3) {
                    e1 I = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(j1Var).I();
                    g0.o(I, "getNothingType(...)");
                    t0 type = c2Var.getType();
                    g0.o(type, "getType(...)");
                    return new e(j1Var, I, type);
                }
                throw new NoWhenBranchMatchedException();
            }
            t0 type2 = c2Var.getType();
            g0.o(type2, "getType(...)");
            e1 J = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(j1Var).J();
            g0.o(J, "getNullableAnyType(...)");
            return new e(j1Var, type2, J);
        }
        t0 type3 = c2Var.getType();
        g0.o(type3, "getType(...)");
        t0 type4 = c2Var.getType();
        g0.o(type4, "getType(...)");
        return new e(j1Var, type3, type4);
    }

    private static final c2 k(e eVar) {
        eVar.d();
        if (!g0.g(eVar.a(), eVar.b())) {
            Variance l6 = eVar.c().l();
            Variance variance = Variance.IN_VARIANCE;
            if (l6 != variance) {
                if (j.o0(eVar.a()) && eVar.c().l() != variance) {
                    return new e2(m(eVar, Variance.OUT_VARIANCE), eVar.b());
                }
                if (j.q0(eVar.b())) {
                    return new e2(m(eVar, variance), eVar.a());
                }
                return new e2(m(eVar, Variance.OUT_VARIANCE), eVar.b());
            }
        }
        return new e2(eVar.a());
    }

    private static final Variance m(e eVar, Variance variance) {
        if (variance == eVar.c().l()) {
            return Variance.INVARIANT;
        }
        return variance;
    }
}
