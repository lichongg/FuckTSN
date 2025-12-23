package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.n;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.k;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.p;
import kotlin.reflect.jvm.internal.impl.load.java.s0;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.b2;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.e2;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.t1;
import kotlin.reflect.jvm.internal.impl.types.u1;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import kotlin.reflect.jvm.internal.impl.types.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y3.a0;
import y3.c0;
import y3.v;
import y3.x;
import y3.y;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJavaTypeResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaTypeResolver.kt\norg/jetbrains/kotlin/load/java/lazy/types/JavaTypeResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 coreLib.kt\norg/jetbrains/kotlin/utils/CoreLibKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,321:1\n1#2:322\n19#3:323\n1563#4:324\n1634#4,3:325\n1563#4:328\n1634#4,3:329\n1563#4:332\n1634#4,3:333\n*S KotlinDebug\n*F\n+ 1 JavaTypeResolver.kt\norg/jetbrains/kotlin/load/java/lazy/types/JavaTypeResolver\n*L\n144#1:323\n205#1:324\n205#1:325,3\n263#1:328\n263#1:329,3\n267#1:332\n267#1:333,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final k f45708a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final p f45709b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final f f45710c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final b2 f45711d;

    public d(@NotNull k c6, @NotNull p typeParameterResolver) {
        g0.p(c6, "c");
        g0.p(typeParameterResolver, "typeParameterResolver");
        this.f45708a = c6;
        this.f45709b = typeParameterResolver;
        f fVar = new f();
        this.f45710c = fVar;
        this.f45711d = new b2(fVar, null, 2, 0 == true ? 1 : 0);
    }

    private final List<c2> d(y3.j jVar, List<? extends j1> list, w1 w1Var, a aVar) {
        y3.j jVar2;
        w1 w1Var2;
        a aVar2;
        c2 a6;
        List<? extends j1> list2 = list;
        ArrayList arrayList = new ArrayList(f0.d0(list2, 10));
        for (j1 j1Var : list2) {
            if (kotlin.reflect.jvm.internal.impl.types.typeUtil.e.r(j1Var, null, aVar.c())) {
                a6 = j2.t(j1Var, aVar);
                jVar2 = jVar;
                w1Var2 = w1Var;
                aVar2 = aVar;
            } else {
                jVar2 = jVar;
                w1Var2 = w1Var;
                aVar2 = aVar;
                a6 = this.f45710c.a(j1Var, aVar2.j(jVar2.C()), this.f45711d, new z0(this.f45708a.e(), new c(this, j1Var, aVar2, w1Var2, jVar2)));
            }
            arrayList.add(a6);
            aVar = aVar2;
            w1Var = w1Var2;
            jVar = jVar2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t0 e(d dVar, j1 j1Var, a aVar, w1 w1Var, y3.j jVar) {
        b2 b2Var = dVar.f45711d;
        kotlin.reflect.jvm.internal.impl.descriptors.f c6 = w1Var.c();
        return b2Var.e(j1Var, aVar.k(c6 != null ? c6.s() : null).j(jVar.C()));
    }

    private final e1 f(y3.j jVar, a aVar, e1 e1Var) {
        y3.j jVar2;
        t1 b6;
        if (e1Var == null || (b6 = e1Var.H0()) == null) {
            jVar2 = jVar;
            b6 = u1.b(new kotlin.reflect.jvm.internal.impl.load.java.lazy.g(this.f45708a, jVar2, false, 4, null));
        } else {
            jVar2 = jVar;
        }
        t1 t1Var = b6;
        w1 g6 = g(jVar2, aVar);
        if (g6 == null) {
            return null;
        }
        boolean j6 = j(aVar);
        return (g0.g(e1Var != null ? e1Var.I0() : null, g6) && !jVar2.C() && j6) ? e1Var.M0(true) : w0.m(t1Var, g6, c(jVar2, aVar, g6), j6, null, 16, null);
    }

    private final w1 h(y3.j jVar) {
        w1 o5 = this.f45708a.a().b().f().r().d(kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(new kotlin.reflect.jvm.internal.impl.name.c(jVar.v())), f0.l(0)).o();
        g0.o(o5, "getTypeConstructor(...)");
        return o5;
    }

    public static /* synthetic */ t0 m(d dVar, y3.f fVar, a aVar, boolean z5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return dVar.l(fVar, aVar, z5);
    }

    private static final kotlin.reflect.jvm.internal.impl.types.error.g o(y3.j jVar) {
        return kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.UNRESOLVED_JAVA_CLASS, jVar.t());
    }

    private final c2 q(x xVar, a aVar, j1 j1Var) {
        if (!(xVar instanceof c0)) {
            return new e2(Variance.INVARIANT, p(xVar, aVar));
        }
        c0 c0Var = (c0) xVar;
        x bound = c0Var.getBound();
        Variance variance = c0Var.J() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
        if (bound == null || i(variance, j1Var)) {
            c2 t5 = j2.t(j1Var, aVar);
            g0.o(t5, "makeStarProjection(...)");
            return t5;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a6 = s0.a(this.f45708a, c0Var);
        t0 p5 = p(bound, b.b(TypeUsage.COMMON, false, false, null, 7, null));
        if (a6 != null) {
            p5 = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.D(p5, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.a(f0.F4(p5.getAnnotations(), a6)));
        }
        return kotlin.reflect.jvm.internal.impl.types.typeUtil.e.l(p5, variance, j1Var);
    }

    @NotNull
    public final t0 l(@NotNull y3.f arrayType, @NotNull a attr, boolean z5) {
        g0.p(arrayType, "arrayType");
        g0.p(attr, "attr");
        x j6 = arrayType.j();
        v vVar = j6 instanceof v ? (v) j6 : null;
        PrimitiveType type = vVar != null ? vVar.getType() : null;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar = new kotlin.reflect.jvm.internal.impl.load.java.lazy.g(this.f45708a, arrayType, true);
        if (type != null) {
            e1 P = this.f45708a.d().p().P(type);
            g0.m(P);
            t0 D = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.D(P, new n(P.getAnnotations(), gVar));
            g0.n(D, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            e1 e1Var = (e1) D;
            return attr.h() ? e1Var : w0.e(e1Var, e1Var.M0(true));
        }
        t0 p5 = p(j6, b.b(TypeUsage.COMMON, attr.h(), false, null, 6, null));
        if (attr.h()) {
            e1 n6 = this.f45708a.d().p().n(z5 ? Variance.OUT_VARIANCE : Variance.INVARIANT, p5, gVar);
            g0.o(n6, "getArrayType(...)");
            return n6;
        }
        e1 n7 = this.f45708a.d().p().n(Variance.INVARIANT, p5, gVar);
        g0.o(n7, "getArrayType(...)");
        return w0.e(n7, this.f45708a.d().p().n(Variance.OUT_VARIANCE, p5, gVar).M0(true));
    }

    @NotNull
    public final t0 p(@Nullable x xVar, @NotNull a attr) {
        t0 p5;
        g0.p(attr, "attr");
        if (xVar instanceof v) {
            PrimitiveType type = ((v) xVar).getType();
            e1 S = type != null ? this.f45708a.d().p().S(type) : this.f45708a.d().p().a0();
            g0.m(S);
            return S;
        }
        if (xVar instanceof y3.j) {
            return n((y3.j) xVar, attr);
        }
        if (xVar instanceof y3.f) {
            return m(this, (y3.f) xVar, attr, false, 4, null);
        }
        if (xVar instanceof c0) {
            x bound = ((c0) xVar).getBound();
            if (bound != null && (p5 = p(bound, attr)) != null) {
                return p5;
            }
            e1 z5 = this.f45708a.d().p().z();
            g0.o(z5, "getDefaultBound(...)");
            return z5;
        }
        if (xVar == null) {
            e1 z6 = this.f45708a.d().p().z();
            g0.o(z6, "getDefaultBound(...)");
            return z6;
        }
        throw new UnsupportedOperationException("Unsupported type: " + xVar);
    }

    private final boolean b(y3.j jVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        Variance l6;
        if (!a0.a((x) f0.A3(jVar.p()))) {
            return false;
        }
        List<j1> parameters = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f44483a.b(dVar).o().getParameters();
        g0.o(parameters, "getParameters(...)");
        j1 j1Var = (j1) f0.A3(parameters);
        if (j1Var == null || (l6 = j1Var.l()) == null || l6 == Variance.OUT_VARIANCE) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
    
        if (r0.isEmpty() == false) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.c2> c(y3.j r10, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a r11, kotlin.reflect.jvm.internal.impl.types.w1 r12) {
        /*
            r9 = this;
            boolean r0 = r10.C()
            java.lang.String r1 = "getParameters(...)"
            if (r0 != 0) goto L24
            java.util.List r0 = r10.p()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L22
            java.util.List r0 = r12.getParameters()
            kotlin.jvm.internal.g0.o(r0, r1)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L22
            goto L24
        L22:
            r0 = 0
            goto L25
        L24:
            r0 = 1
        L25:
            java.util.List r2 = r12.getParameters()
            kotlin.jvm.internal.g0.o(r2, r1)
            if (r0 == 0) goto L33
            java.util.List r10 = r9.d(r10, r2, r12, r11)
            return r10
        L33:
            int r11 = r2.size()
            java.util.List r12 = r10.p()
            int r12 = r12.size()
            r0 = 10
            if (r11 == r12) goto L7e
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = kotlin.collections.f0.d0(r2, r0)
            r10.<init>(r11)
            java.util.Iterator r11 = r2.iterator()
        L52:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L79
            java.lang.Object r12 = r11.next()
            kotlin.reflect.jvm.internal.impl.descriptors.j1 r12 = (kotlin.reflect.jvm.internal.impl.descriptors.j1) r12
            kotlin.reflect.jvm.internal.impl.types.e2 r0 = new kotlin.reflect.jvm.internal.impl.types.e2
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r1 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER
            kotlin.reflect.jvm.internal.impl.name.f r12 = r12.getName()
            java.lang.String r12 = r12.b()
            java.lang.String[] r12 = new java.lang.String[]{r12}
            kotlin.reflect.jvm.internal.impl.types.error.g r12 = kotlin.reflect.jvm.internal.impl.types.error.i.d(r1, r12)
            r0.<init>(r12)
            r10.add(r0)
            goto L52
        L79:
            java.util.List r10 = kotlin.collections.f0.a6(r10)
            return r10
        L7e:
            java.util.List r10 = r10.p()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.lang.Iterable r10 = kotlin.collections.f0.m6(r10)
            java.util.ArrayList r11 = new java.util.ArrayList
            int r12 = kotlin.collections.f0.d0(r10, r0)
            r11.<init>(r12)
            java.util.Iterator r10 = r10.iterator()
        L95:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto Lca
            java.lang.Object r12 = r10.next()
            kotlin.collections.a1 r12 = (kotlin.collections.a1) r12
            int r0 = r12.a()
            java.lang.Object r12 = r12.b()
            y3.x r12 = (y3.x) r12
            r2.size()
            java.lang.Object r0 = r2.get(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.j1 r0 = (kotlin.reflect.jvm.internal.impl.descriptors.j1) r0
            kotlin.reflect.jvm.internal.impl.types.TypeUsage r3 = kotlin.reflect.jvm.internal.impl.types.TypeUsage.COMMON
            r7 = 7
            r8 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a r1 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(r3, r4, r5, r6, r7, r8)
            kotlin.jvm.internal.g0.m(r0)
            kotlin.reflect.jvm.internal.impl.types.c2 r12 = r9.q(r12, r1, r0)
            r11.add(r12)
            goto L95
        Lca:
            java.util.List r10 = kotlin.collections.f0.a6(r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.d.c(y3.j, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a, kotlin.reflect.jvm.internal.impl.types.w1):java.util.List");
    }

    private final w1 g(y3.j jVar, a aVar) {
        w1 o5;
        y3.i n6 = jVar.n();
        if (n6 == null) {
            return h(jVar);
        }
        if (n6 instanceof y3.g) {
            y3.g gVar = (y3.g) n6;
            kotlin.reflect.jvm.internal.impl.name.c d6 = gVar.d();
            if (d6 != null) {
                kotlin.reflect.jvm.internal.impl.descriptors.d k6 = k(jVar, aVar, d6);
                if (k6 == null) {
                    k6 = this.f45708a.a().n().a(gVar);
                }
                if (k6 != null && (o5 = k6.o()) != null) {
                    return o5;
                }
                return h(jVar);
            }
            throw new AssertionError("Class type should have a FQ name: " + n6);
        }
        if (n6 instanceof y) {
            j1 a6 = this.f45709b.a((y) n6);
            if (a6 != null) {
                return a6.o();
            }
            return null;
        }
        throw new IllegalStateException("Unknown classifier kind: " + n6);
    }

    private final boolean i(Variance variance, j1 j1Var) {
        if (j1Var.l() == Variance.INVARIANT || variance == j1Var.l()) {
            return false;
        }
        return true;
    }

    private final boolean j(a aVar) {
        if (aVar.g() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || aVar.h() || aVar.b() == TypeUsage.SUPERTYPE) {
            return false;
        }
        return true;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d k(y3.j jVar, a aVar, kotlin.reflect.jvm.internal.impl.name.c cVar) {
        kotlin.reflect.jvm.internal.impl.name.c cVar2;
        if (aVar.h()) {
            cVar2 = e.f45712a;
            if (g0.g(cVar, cVar2)) {
                return this.f45708a.a().p().d();
            }
        }
        kotlin.reflect.jvm.internal.impl.builtins.jvm.d dVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f44483a;
        kotlin.reflect.jvm.internal.impl.descriptors.d f6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f(dVar, cVar, this.f45708a.d().p(), null, 4, null);
        if (f6 == null) {
            return null;
        }
        if (dVar.d(f6) && (aVar.g() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || aVar.b() == TypeUsage.SUPERTYPE || b(jVar, f6))) {
            return dVar.b(f6);
        }
        return f6;
    }

    private final t0 n(y3.j jVar, a aVar) {
        boolean z5;
        if (!aVar.h() && aVar.b() != TypeUsage.SUPERTYPE) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean C = jVar.C();
        if (!C && !z5) {
            e1 f6 = f(jVar, aVar, null);
            if (f6 != null) {
                return f6;
            }
            return o(jVar);
        }
        e1 f7 = f(jVar, aVar.l(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (f7 == null) {
            return o(jVar);
        }
        e1 f8 = f(jVar, aVar.l(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), f7);
        if (f8 == null) {
            return o(jVar);
        }
        if (C) {
            return new j(f7, f8);
        }
        return w0.e(f7, f8);
    }
}
