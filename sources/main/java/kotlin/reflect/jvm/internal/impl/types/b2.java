package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.x1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTypeParameterUpperBoundEraser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeParameterUpperBoundEraser.kt\norg/jetbrains/kotlin/types/TypeParameterUpperBoundEraser\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n1193#2,2:159\n1267#2,4:161\n1563#2:166\n1634#2,3:167\n1#3:165\n*S KotlinDebug\n*F\n+ 1 TypeParameterUpperBoundEraser.kt\norg/jetbrains/kotlin/types/TypeParameterUpperBoundEraser\n*L\n77#1:159,2\n77#1:161,4\n100#1:166\n100#1:167,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b2 {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f47146f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final h0 f47147a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final y1 f47148b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.f f47149c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.s f47150d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.g<b, t0> f47151e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nTypeParameterUpperBoundEraser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeParameterUpperBoundEraser.kt\norg/jetbrains/kotlin/types/TypeParameterUpperBoundEraser$Companion\n+ 2 TypeUtils.kt\norg/jetbrains/kotlin/types/typeUtil/TypeUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,158:1\n245#2,14:159\n260#2:177\n1563#3:173\n1634#3,3:174\n*S KotlinDebug\n*F\n+ 1 TypeParameterUpperBoundEraser.kt\norg/jetbrains/kotlin/types/TypeParameterUpperBoundEraser$Companion\n*L\n140#1:159,14\n140#1:177\n140#1:173\n140#1:174,3\n*E\n"})
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final t0 a(@NotNull t0 t0Var, @NotNull h2 substitutor, @Nullable Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.j1> set, boolean z5) {
            m2 m2Var;
            t0 type;
            t0 type2;
            t0 type3;
            kotlin.jvm.internal.g0.p(t0Var, "<this>");
            kotlin.jvm.internal.g0.p(substitutor, "substitutor");
            m2 L0 = t0Var.L0();
            if (L0 instanceof k0) {
                k0 k0Var = (k0) L0;
                e1 Q0 = k0Var.Q0();
                if (!Q0.I0().getParameters().isEmpty() && Q0.I0().c() != null) {
                    List<kotlin.reflect.jvm.internal.impl.descriptors.j1> parameters = Q0.I0().getParameters();
                    kotlin.jvm.internal.g0.o(parameters, "getParameters(...)");
                    List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list = parameters;
                    ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
                    for (kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var : list) {
                        c2 c2Var = (c2) kotlin.collections.f0.b3(t0Var.G0(), j1Var.getIndex());
                        if (!z5 || c2Var == null || (type3 = c2Var.getType()) == null || kotlin.reflect.jvm.internal.impl.types.typeUtil.e.j(type3)) {
                            boolean z6 = set != null && set.contains(j1Var);
                            if (c2Var != null && !z6) {
                                f2 j6 = substitutor.j();
                                t0 type4 = c2Var.getType();
                                kotlin.jvm.internal.g0.o(type4, "getType(...)");
                                if (j6.e(type4) != null) {
                                }
                            }
                            c2Var = new l1(j1Var);
                        }
                        arrayList.add(c2Var);
                    }
                    Q0 = g2.f(Q0, arrayList, null, 2, null);
                }
                e1 R0 = k0Var.R0();
                if (!R0.I0().getParameters().isEmpty() && R0.I0().c() != null) {
                    List<kotlin.reflect.jvm.internal.impl.descriptors.j1> parameters2 = R0.I0().getParameters();
                    kotlin.jvm.internal.g0.o(parameters2, "getParameters(...)");
                    List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list2 = parameters2;
                    ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(list2, 10));
                    for (kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var2 : list2) {
                        c2 c2Var2 = (c2) kotlin.collections.f0.b3(t0Var.G0(), j1Var2.getIndex());
                        if (!z5 || c2Var2 == null || (type2 = c2Var2.getType()) == null || kotlin.reflect.jvm.internal.impl.types.typeUtil.e.j(type2)) {
                            boolean z7 = set != null && set.contains(j1Var2);
                            if (c2Var2 != null && !z7) {
                                f2 j7 = substitutor.j();
                                t0 type5 = c2Var2.getType();
                                kotlin.jvm.internal.g0.o(type5, "getType(...)");
                                if (j7.e(type5) != null) {
                                }
                            }
                            c2Var2 = new l1(j1Var2);
                        }
                        arrayList2.add(c2Var2);
                    }
                    R0 = g2.f(R0, arrayList2, null, 2, null);
                }
                m2Var = w0.e(Q0, R0);
            } else {
                if (!(L0 instanceof e1)) {
                    throw new NoWhenBranchMatchedException();
                }
                e1 e1Var = (e1) L0;
                if (e1Var.I0().getParameters().isEmpty() || e1Var.I0().c() == null) {
                    m2Var = e1Var;
                } else {
                    List<kotlin.reflect.jvm.internal.impl.descriptors.j1> parameters3 = e1Var.I0().getParameters();
                    kotlin.jvm.internal.g0.o(parameters3, "getParameters(...)");
                    List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list3 = parameters3;
                    ArrayList arrayList3 = new ArrayList(kotlin.collections.f0.d0(list3, 10));
                    for (kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var3 : list3) {
                        c2 c2Var3 = (c2) kotlin.collections.f0.b3(t0Var.G0(), j1Var3.getIndex());
                        if (!z5 || c2Var3 == null || (type = c2Var3.getType()) == null || kotlin.reflect.jvm.internal.impl.types.typeUtil.e.j(type)) {
                            boolean z8 = set != null && set.contains(j1Var3);
                            if (c2Var3 != null && !z8) {
                                f2 j8 = substitutor.j();
                                t0 type6 = c2Var3.getType();
                                kotlin.jvm.internal.g0.o(type6, "getType(...)");
                                if (j8.e(type6) != null) {
                                }
                            }
                            c2Var3 = new l1(j1Var3);
                        }
                        arrayList3.add(c2Var3);
                    }
                    m2Var = g2.f(e1Var, arrayList3, null, 2, null);
                }
            }
            t0 n6 = substitutor.n(l2.b(m2Var, L0), Variance.OUT_VARIANCE);
            kotlin.jvm.internal.g0.o(n6, "safeSubstitute(...)");
            return n6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.descriptors.j1 f47152a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final i0 f47153b;

        public b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1 typeParameter, @NotNull i0 typeAttr) {
            kotlin.jvm.internal.g0.p(typeParameter, "typeParameter");
            kotlin.jvm.internal.g0.p(typeAttr, "typeAttr");
            this.f47152a = typeParameter;
            this.f47153b = typeAttr;
        }

        @NotNull
        public final i0 a() {
            return this.f47153b;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.descriptors.j1 b() {
            return this.f47152a;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return kotlin.jvm.internal.g0.g(bVar.f47152a, this.f47152a) && kotlin.jvm.internal.g0.g(bVar.f47153b, this.f47153b);
        }

        public int hashCode() {
            int hashCode = this.f47152a.hashCode();
            return hashCode + (hashCode * 31) + this.f47153b.hashCode();
        }

        @NotNull
        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.f47152a + ", typeAttr=" + this.f47153b + ')';
        }
    }

    public b2(@NotNull h0 projectionComputer, @NotNull y1 options) {
        kotlin.jvm.internal.g0.p(projectionComputer, "projectionComputer");
        kotlin.jvm.internal.g0.p(options, "options");
        this.f47147a = projectionComputer;
        this.f47148b = options;
        kotlin.reflect.jvm.internal.impl.storage.f fVar = new kotlin.reflect.jvm.internal.impl.storage.f("Type parameter upper bound erasure results");
        this.f47149c = fVar;
        this.f47150d = kotlin.t.c(new z1(this));
        kotlin.reflect.jvm.internal.impl.storage.g<b, t0> i6 = fVar.i(new a2(this));
        kotlin.jvm.internal.g0.o(i6, "createMemoizedFunction(...)");
        this.f47151e = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.error.g c(b2 b2Var) {
        return kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.CANNOT_COMPUTE_ERASED_BOUND, b2Var.toString());
    }

    private final kotlin.reflect.jvm.internal.impl.types.error.g h() {
        return (kotlin.reflect.jvm.internal.impl.types.error.g) this.f47150d.getValue();
    }

    @NotNull
    public final t0 e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.j1 typeParameter, @NotNull i0 typeAttr) {
        kotlin.jvm.internal.g0.p(typeParameter, "typeParameter");
        kotlin.jvm.internal.g0.p(typeAttr, "typeAttr");
        t0 invoke = this.f47151e.invoke(new b(typeParameter, typeAttr));
        kotlin.jvm.internal.g0.o(invoke, "invoke(...)");
        return invoke;
    }

    private final t0 d(i0 i0Var) {
        t0 E;
        e1 a6 = i0Var.a();
        if (a6 != null && (E = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.E(a6)) != null) {
            return E;
        }
        return h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t0 f(b2 b2Var, b bVar) {
        return b2Var.g(bVar.b(), bVar.a());
    }

    private final t0 g(kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var, i0 i0Var) {
        c2 a6;
        Set<kotlin.reflect.jvm.internal.impl.descriptors.j1> c6 = i0Var.c();
        if (c6 != null && c6.contains(j1Var.a())) {
            return d(i0Var);
        }
        e1 s5 = j1Var.s();
        kotlin.jvm.internal.g0.o(s5, "getDefaultType(...)");
        Set<kotlin.reflect.jvm.internal.impl.descriptors.j1> m6 = kotlin.reflect.jvm.internal.impl.types.typeUtil.e.m(s5, c6);
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(kotlin.collections.i1.j(kotlin.collections.f0.d0(m6, 10)), 16));
        for (kotlin.reflect.jvm.internal.impl.descriptors.j1 j1Var2 : m6) {
            if (c6 != null && c6.contains(j1Var2)) {
                a6 = j2.t(j1Var2, i0Var);
                kotlin.jvm.internal.g0.o(a6, "makeStarProjection(...)");
            } else {
                a6 = this.f47147a.a(j1Var2, i0Var, this, e(j1Var2, i0Var.d(j1Var)));
            }
            Pair a7 = kotlin.o0.a(j1Var2.o(), a6);
            linkedHashMap.put(a7.getFirst(), a7.getSecond());
        }
        h2 g6 = h2.g(x1.a.e(x1.f47366c, linkedHashMap, false, 2, null));
        kotlin.jvm.internal.g0.o(g6, "create(...)");
        List<t0> upperBounds = j1Var.getUpperBounds();
        kotlin.jvm.internal.g0.o(upperBounds, "getUpperBounds(...)");
        Set<t0> i6 = i(g6, upperBounds, i0Var);
        if (!i6.isEmpty()) {
            if (!this.f47148b.a()) {
                if (i6.size() == 1) {
                    return (t0) kotlin.collections.f0.k5(i6);
                }
                throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds");
            }
            List a62 = kotlin.collections.f0.a6(i6);
            ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(a62, 10));
            Iterator it = a62.iterator();
            while (it.hasNext()) {
                arrayList.add(((t0) it.next()).L0());
            }
            return kotlin.reflect.jvm.internal.impl.types.checker.d.a(arrayList);
        }
        return d(i0Var);
    }

    private final Set<t0> i(h2 h2Var, List<? extends t0> list, i0 i0Var) {
        Set d6 = kotlin.collections.u1.d();
        for (t0 t0Var : list) {
            kotlin.reflect.jvm.internal.impl.descriptors.f c6 = t0Var.I0().c();
            if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                d6.add(f47146f.a(t0Var, h2Var, i0Var.c(), this.f47148b.b()));
            } else if (c6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.j1) {
                Set<kotlin.reflect.jvm.internal.impl.descriptors.j1> c7 = i0Var.c();
                if (c7 != null && c7.contains(c6)) {
                    d6.add(d(i0Var));
                } else {
                    List<t0> upperBounds = ((kotlin.reflect.jvm.internal.impl.descriptors.j1) c6).getUpperBounds();
                    kotlin.jvm.internal.g0.o(upperBounds, "getUpperBounds(...)");
                    d6.addAll(i(h2Var, upperBounds, i0Var));
                }
            }
            if (!this.f47148b.a()) {
                break;
            }
        }
        return kotlin.collections.u1.a(d6);
    }

    public /* synthetic */ b2(h0 h0Var, y1 y1Var, int i6, kotlin.jvm.internal.v vVar) {
        this(h0Var, (i6 & 2) != 0 ? new y1(false, false) : y1Var);
    }
}
