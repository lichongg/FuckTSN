package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.q1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTypeAliasExpander.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAliasExpander.kt\norg/jetbrains/kotlin/types/TypeAliasExpander\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,278:1\n1#2:279\n1634#3,3:280\n1573#3:283\n1604#3,4:284\n1573#3:288\n1604#3,4:289\n1878#3,3:293\n*S KotlinDebug\n*F\n+ 1 TypeAliasExpander.kt\norg/jetbrains/kotlin/types/TypeAliasExpander\n*L\n148#1:280,3\n197#1:283\n197#1:284,4\n232#1:288\n232#1:289,4\n249#1:293,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o1 {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f47304c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final o1 f47305d = new o1(q1.a.f47324a, false);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final q1 f47306a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f47307b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i6, kotlin.reflect.jvm.internal.impl.descriptors.i1 i1Var) {
            if (i6 <= 100) {
                return;
            }
            throw new AssertionError("Too deep recursion while expanding type alias " + i1Var.getName());
        }
    }

    public o1(@NotNull q1 reportStrategy, boolean z5) {
        kotlin.jvm.internal.g0.p(reportStrategy, "reportStrategy");
        this.f47306a = reportStrategy;
        this.f47307b = z5;
    }

    private final void a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar2) {
        HashSet hashSet = new HashSet();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = gVar.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().d());
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar : gVar2) {
            if (hashSet.contains(cVar.d())) {
                this.f47306a.c(cVar);
            }
        }
    }

    private final e1 k(p1 p1Var, t1 t1Var, boolean z5, int i6, boolean z6) {
        c2 l6 = l(new e2(Variance.INVARIANT, p1Var.b().y0()), p1Var, null, i6);
        t0 type = l6.getType();
        kotlin.jvm.internal.g0.o(type, "getType(...)");
        e1 a6 = g2.a(type);
        if (x0.a(a6)) {
            return a6;
        }
        l6.c();
        a(a6.getAnnotations(), u.a(t1Var));
        e1 r5 = j2.r(d(a6, t1Var), z5);
        kotlin.jvm.internal.g0.o(r5, "let(...)");
        return z6 ? i1.j(r5, g(p1Var, t1Var, z5)) : r5;
    }

    private final c2 l(c2 c2Var, p1 p1Var, kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var, int i6) {
        Variance variance;
        Variance variance2;
        Variance variance3;
        f47304c.b(i6, p1Var.b());
        if (c2Var.b()) {
            kotlin.jvm.internal.g0.m(j1Var);
            c2 s5 = j2.s(j1Var);
            kotlin.jvm.internal.g0.o(s5, "makeStarProjection(...)");
            return s5;
        }
        t0 type = c2Var.getType();
        kotlin.jvm.internal.g0.o(type, "getType(...)");
        c2 c6 = p1Var.c(type.I0());
        if (c6 == null) {
            return j(c2Var, p1Var, i6);
        }
        if (c6.b()) {
            kotlin.jvm.internal.g0.m(j1Var);
            c2 s6 = j2.s(j1Var);
            kotlin.jvm.internal.g0.o(s6, "makeStarProjection(...)");
            return s6;
        }
        m2 L0 = c6.getType().L0();
        Variance c7 = c6.c();
        kotlin.jvm.internal.g0.o(c7, "getProjectionKind(...)");
        Variance c8 = c2Var.c();
        kotlin.jvm.internal.g0.o(c8, "getProjectionKind(...)");
        if (c8 != c7 && c8 != (variance3 = Variance.INVARIANT)) {
            if (c7 == variance3) {
                c7 = c8;
            } else {
                this.f47306a.d(p1Var.b(), j1Var, L0);
            }
        }
        if (j1Var == null || (variance = j1Var.l()) == null) {
            variance = Variance.INVARIANT;
        }
        if (variance != c7 && variance != (variance2 = Variance.INVARIANT)) {
            if (c7 == variance2) {
                c7 = variance2;
            } else {
                this.f47306a.d(p1Var.b(), j1Var, L0);
            }
        }
        a(type.getAnnotations(), L0.getAnnotations());
        return new e2(c7, L0 instanceof f0 ? c((f0) L0, type.H0()) : f(g2.a(L0), type));
    }

    @NotNull
    public final e1 i(@NotNull p1 typeAliasExpansion, @NotNull t1 attributes) {
        kotlin.jvm.internal.g0.p(typeAliasExpansion, "typeAliasExpansion");
        kotlin.jvm.internal.g0.p(attributes, "attributes");
        return k(typeAliasExpansion, attributes, false, 0, true);
    }

    private final void b(t0 t0Var, t0 t0Var2) {
        h2 f6 = h2.f(t0Var2);
        kotlin.jvm.internal.g0.o(f6, "create(...)");
        int i6 = 0;
        for (Object obj : t0Var2.G0()) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            c2 c2Var = (c2) obj;
            if (!c2Var.b()) {
                t0 type = c2Var.getType();
                kotlin.jvm.internal.g0.o(type, "getType(...)");
                if (!kotlin.reflect.jvm.internal.impl.types.typeUtil.e.h(type)) {
                    c2 c2Var2 = t0Var.G0().get(i6);
                    kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var = t0Var.I0().getParameters().get(i6);
                    if (this.f47307b) {
                        q1 q1Var = this.f47306a;
                        t0 type2 = c2Var2.getType();
                        kotlin.jvm.internal.g0.o(type2, "getType(...)");
                        t0 type3 = c2Var.getType();
                        kotlin.jvm.internal.g0.o(type3, "getType(...)");
                        kotlin.jvm.internal.g0.m(j1Var);
                        q1Var.a(f6, type2, type3, j1Var);
                    }
                }
            }
            i6 = i7;
        }
    }

    private final f0 c(f0 f0Var, t1 t1Var) {
        return f0Var.O0(h(f0Var, t1Var));
    }

    private final e1 d(e1 e1Var, t1 t1Var) {
        if (x0.a(e1Var)) {
            return e1Var;
        }
        return g2.f(e1Var, null, h(e1Var, t1Var), 1, null);
    }

    private final e1 e(e1 e1Var, t0 t0Var) {
        e1 r5 = j2.r(e1Var, t0Var.J0());
        kotlin.jvm.internal.g0.o(r5, "makeNullableIfNeeded(...)");
        return r5;
    }

    private final e1 f(e1 e1Var, t0 t0Var) {
        return d(e(e1Var, t0Var), t0Var.H0());
    }

    private final e1 g(p1 p1Var, t1 t1Var, boolean z5) {
        w1 o5 = p1Var.b().o();
        kotlin.jvm.internal.g0.o(o5, "getTypeConstructor(...)");
        return w0.o(t1Var, o5, p1Var.a(), z5, k.c.f46780b);
    }

    private final t1 h(t0 t0Var, t1 t1Var) {
        if (x0.a(t0Var)) {
            return t0Var.H0();
        }
        return t1Var.m(t0Var.H0());
    }

    private final c2 j(c2 c2Var, p1 p1Var, int i6) {
        m2 L0 = c2Var.getType().L0();
        if (!g0.a(L0)) {
            e1 a6 = g2.a(L0);
            if (!x0.a(a6) && kotlin.reflect.jvm.internal.impl.types.typeUtil.e.F(a6)) {
                w1 I0 = a6.I0();
                kotlin.reflect.jvm.internal.impl.descriptors.f c6 = I0.c();
                I0.getParameters().size();
                a6.G0().size();
                if (!(c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.j1)) {
                    if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.i1) {
                        kotlin.reflect.jvm.internal.impl.descriptors.i1 i1Var = (kotlin.reflect.jvm.internal.impl.descriptors.i1) c6;
                        if (p1Var.d(i1Var)) {
                            this.f47306a.b(i1Var);
                            return new e2(Variance.INVARIANT, kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.RECURSIVE_TYPE_ALIAS, i1Var.getName().toString()));
                        }
                        List<c2> G0 = a6.G0();
                        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(G0, 10));
                        int i7 = 0;
                        for (Object obj : G0) {
                            int i8 = i7 + 1;
                            if (i7 < 0) {
                                kotlin.collections.f0.b0();
                            }
                            arrayList.add(l((c2) obj, p1Var, I0.getParameters().get(i7), i6 + 1));
                            i7 = i8;
                        }
                        e1 k6 = k(p1.f47311e.a(p1Var, i1Var, arrayList), a6.H0(), a6.J0(), i6 + 1, false);
                        e1 m6 = m(a6, p1Var, i6);
                        if (!g0.a(k6)) {
                            k6 = i1.j(k6, m6);
                        }
                        return new e2(c2Var.c(), k6);
                    }
                    e1 m7 = m(a6, p1Var, i6);
                    b(a6, m7);
                    return new e2(c2Var.c(), m7);
                }
            }
        }
        return c2Var;
    }

    private final e1 m(e1 e1Var, p1 p1Var, int i6) {
        w1 I0 = e1Var.I0();
        List<c2> G0 = e1Var.G0();
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(G0, 10));
        int i7 = 0;
        for (Object obj : G0) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.f0.b0();
            }
            c2 c2Var = (c2) obj;
            c2 l6 = l(c2Var, p1Var, I0.getParameters().get(i7), i6 + 1);
            if (!l6.b()) {
                l6 = new e2(l6.c(), j2.q(l6.getType(), c2Var.getType().J0()));
            }
            arrayList.add(l6);
            i7 = i8;
        }
        return g2.f(e1Var, arrayList, null, 2, null);
    }
}
