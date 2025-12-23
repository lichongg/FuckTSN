package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.i1;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.components.o;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.load.java.t;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j1;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.utils.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLazyJavaClassMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaClassMemberScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassMemberScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 collections.kt\norg/jetbrains/kotlin/utils/CollectionsKt\n*L\n1#1,890:1\n1460#2,5:891\n1761#2,2:896\n1761#2,3:898\n1763#2:901\n1617#2,9:902\n1869#2:911\n1870#2:913\n1626#2:914\n1761#2,3:915\n1563#2:918\n1634#2,3:919\n827#2:922\n855#2,2:923\n774#2:925\n865#2,2:926\n1761#2,3:928\n1761#2,3:931\n2746#2,3:935\n774#2:938\n865#2,2:939\n774#2:941\n865#2,2:942\n1563#2:944\n1634#2,3:945\n2746#2,3:948\n295#2,2:951\n1563#2:953\n1634#2,3:954\n1460#2,5:957\n2746#2,3:962\n1374#2:965\n1460#2,2:966\n1563#2:968\n1634#2,3:969\n1462#2,3:972\n1563#2:975\n1634#2,3:976\n3301#2,10:979\n1460#2,5:989\n2746#2,3:994\n774#2:998\n865#2,2:999\n1208#2,2:1001\n1236#2,4:1003\n1#3:912\n1#3:934\n58#4:997\n*S KotlinDebug\n*F\n+ 1 LazyJavaClassMemberScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassMemberScope\n*L\n74#1:891,5\n160#1:896,2\n161#1:898,3\n160#1:901\n189#1:902,9\n189#1:911\n189#1:913\n189#1:914\n193#1:915,3\n199#1:918\n199#1:919,3\n202#1:922\n202#1:923,2\n211#1:925\n211#1:926,2\n216#1:928,3\n222#1:931,3\n322#1:935,3\n327#1:938\n327#1:939,2\n354#1:941\n354#1:942,2\n376#1:944\n376#1:945,3\n461#1:948,3\n470#1:951,2\n476#1:953\n476#1:954,3\n489#1:957,5\n495#1:962,3\n649#1:965\n649#1:966,2\n650#1:968\n650#1:969,3\n649#1:972,3\n698#1:975\n698#1:976,3\n749#1:979,10\n879#1:989,5\n95#1:994,3\n811#1:998\n811#1:999,2\n811#1:1001,2\n811#1:1003,4\n189#1:912\n105#1:997\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z extends t0 {

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f45660n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final y3.g f45661o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f45662p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i<List<kotlin.reflect.jvm.internal.impl.descriptors.c>> f45663q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i<Set<kotlin.reflect.jvm.internal.impl.name.f>> f45664r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i<Set<kotlin.reflect.jvm.internal.impl.name.f>> f45665s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i<Map<kotlin.reflect.jvm.internal.impl.name.f, y3.n>> f45666t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.d> f45667u;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class a extends FunctionReferenceImpl implements Function1<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends d1>> {
        a(Object obj) {
            super(1, obj, z.class, "searchMethodsByNameWithoutBuiltinMagic", "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Collection<d1> invoke(kotlin.reflect.jvm.internal.impl.name.f p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return ((z) this.receiver).q1(p02);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends d1>> {
        b(Object obj) {
            super(1, obj, z.class, "searchMethodsInSupertypesWithoutBuiltinMagic", "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Collection<d1> invoke(kotlin.reflect.jvm.internal.impl.name.f p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return ((z) this.receiver).r1(p02);
        }
    }

    public /* synthetic */ z(kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar, y3.g gVar, boolean z5, z zVar, int i6, kotlin.jvm.internal.v vVar) {
        this(kVar, dVar, gVar, z5, (i6 & 16) != 0 ? null : zVar);
    }

    private final boolean f1(d1 d1Var, kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        String c6 = kotlin.reflect.jvm.internal.impl.load.kotlin.c0.c(d1Var, false, false, 2, null);
        kotlin.reflect.jvm.internal.impl.descriptors.y a6 = yVar.a();
        kotlin.jvm.internal.g0.o(a6, "getOriginal(...)");
        return kotlin.jvm.internal.g0.g(c6, kotlin.reflect.jvm.internal.impl.load.kotlin.c0.c(a6, false, false, 2, null)) && !R0(d1Var, yVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d ownerDescriptor, @NotNull y3.g jClass, boolean z5, @Nullable z zVar) {
        super(c6, zVar);
        kotlin.jvm.internal.g0.p(c6, "c");
        kotlin.jvm.internal.g0.p(ownerDescriptor, "ownerDescriptor");
        kotlin.jvm.internal.g0.p(jClass, "jClass");
        this.f45660n = ownerDescriptor;
        this.f45661o = jClass;
        this.f45662p = z5;
        this.f45663q = c6.e().e(new p(this, c6));
        this.f45664r = c6.e().e(new q(this));
        this.f45665s = c6.e().e(new r(c6, this));
        this.f45666t = c6.e().e(new s(this));
        this.f45667u = c6.e().c(new t(this, c6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A0(y3.q it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return !it.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection B0(z zVar, kotlin.reflect.jvm.internal.impl.name.f it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return zVar.q1(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection C0(z zVar, kotlin.reflect.jvm.internal.impl.name.f it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return zVar.r1(it);
    }

    private final Collection<kotlin.reflect.jvm.internal.impl.types.t0> D0() {
        if (!this.f45662p) {
            return M().a().k().c().g(S());
        }
        Collection<kotlin.reflect.jvm.internal.impl.types.t0> i6 = S().o().i();
        kotlin.jvm.internal.g0.o(i6, "getSupertypes(...)");
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.Collection] */
    public static final List E0(z zVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar) {
        Collection<y3.k> f6 = zVar.f45661o.f();
        ArrayList arrayList = new ArrayList(f6.size());
        Iterator<y3.k> it = f6.iterator();
        while (it.hasNext()) {
            arrayList.add(zVar.o1(it.next()));
        }
        if (zVar.f45661o.A()) {
            kotlin.reflect.jvm.internal.impl.descriptors.c H0 = zVar.H0();
            String c6 = kotlin.reflect.jvm.internal.impl.load.kotlin.c0.c(H0, false, false, 2, null);
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (kotlin.jvm.internal.g0.g(kotlin.reflect.jvm.internal.impl.load.kotlin.c0.c((kotlin.reflect.jvm.internal.impl.descriptors.c) it2.next(), false, false, 2, null), c6)) {
                        break;
                    }
                }
            }
            arrayList.add(H0);
            kVar.a().h().b(zVar.f45661o, H0);
        }
        kVar.a().w().a(zVar.S(), arrayList, kVar);
        j1 r5 = kVar.a().r();
        boolean isEmpty = arrayList.isEmpty();
        ArrayList arrayList2 = arrayList;
        if (isEmpty) {
            arrayList2 = kotlin.collections.f0.R(zVar.G0());
        }
        return kotlin.collections.f0.a6(r5.p(kVar, arrayList2));
    }

    private final List<q1> F0(kotlin.reflect.jvm.internal.impl.descriptors.impl.i iVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.i iVar2;
        Pair pair;
        Collection<y3.r> r5 = this.f45661o.r();
        ArrayList arrayList = new ArrayList(r5.size());
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a b6 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(TypeUsage.COMMON, true, false, null, 6, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : r5) {
            if (kotlin.jvm.internal.g0.g(((y3.r) obj).getName(), kotlin.reflect.jvm.internal.impl.load.java.i0.f45448c)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        Pair pair2 = new Pair(arrayList2, arrayList3);
        List list = (List) pair2.component1();
        List<y3.r> list2 = (List) pair2.component2();
        list.size();
        y3.r rVar = (y3.r) kotlin.collections.f0.L2(list);
        if (rVar != null) {
            y3.x returnType = rVar.getReturnType();
            if (returnType instanceof y3.f) {
                y3.f fVar = (y3.f) returnType;
                pair = new Pair(M().g().l(fVar, b6, true), M().g().p(fVar.j(), b6));
            } else {
                pair = new Pair(M().g().p(returnType, b6), null);
            }
            kotlin.reflect.jvm.internal.impl.types.t0 t0Var = (kotlin.reflect.jvm.internal.impl.types.t0) pair.component1();
            kotlin.reflect.jvm.internal.impl.types.t0 t0Var2 = (kotlin.reflect.jvm.internal.impl.types.t0) pair.component2();
            iVar2 = iVar;
            t0(arrayList, iVar2, 0, rVar, t0Var, t0Var2);
        } else {
            iVar2 = iVar;
        }
        int i6 = 0;
        int i7 = rVar == null ? 0 : 1;
        for (y3.r rVar2 : list2) {
            t0(arrayList, iVar2, i6 + i7, rVar2, M().g().p(rVar2.getReturnType(), b6), null);
            i6++;
        }
        return arrayList;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.c G0() {
        boolean k6 = this.f45661o.k();
        if ((this.f45661o.I() || !this.f45661o.B()) && !k6) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d S = S();
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.b o12 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.b.o1(S, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), true, M().a().t().a(this.f45661o));
        kotlin.jvm.internal.g0.o(o12, "createJavaConstructor(...)");
        List<q1> F0 = k6 ? F0(o12) : Collections.EMPTY_LIST;
        o12.U0(false);
        o12.l1(F0, a1(S));
        o12.T0(true);
        o12.b1(S.s());
        M().a().h().b(this.f45661o, o12);
        return o12;
    }

    private final d1 I0(d1 d1Var, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, Collection<? extends d1> collection) {
        Collection<? extends d1> collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return d1Var;
        }
        for (d1 d1Var2 : collection2) {
            if (!kotlin.jvm.internal.g0.g(d1Var, d1Var2) && d1Var2.x0() == null && R0(d1Var2, aVar)) {
                d1 build = d1Var.n().e().build();
                kotlin.jvm.internal.g0.m(build);
                return build;
            }
        }
        return d1Var;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.f L0(y3.r rVar, kotlin.reflect.jvm.internal.impl.types.t0 t0Var, Modality modality) {
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.f fVar;
        z zVar;
        kotlin.reflect.jvm.internal.impl.types.t0 t0Var2;
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.f b12 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.f.b1(S(), kotlin.reflect.jvm.internal.impl.load.java.lazy.h.a(M(), rVar), modality, kotlin.reflect.jvm.internal.impl.load.java.s0.d(rVar.getVisibility()), false, rVar.getName(), M().a().t().a(rVar), false);
        kotlin.jvm.internal.g0.o(b12, "create(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.impl.l0 d6 = kotlin.reflect.jvm.internal.impl.resolve.h.d(b12, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b());
        kotlin.jvm.internal.g0.o(d6, "createDefaultGetter(...)");
        b12.Q0(d6, null);
        if (t0Var == null) {
            kotlin.reflect.jvm.internal.impl.load.java.lazy.k i6 = kotlin.reflect.jvm.internal.impl.load.java.lazy.c.i(M(), b12, rVar, 0, 4, null);
            fVar = b12;
            zVar = this;
            t0Var2 = zVar.B(rVar, i6);
        } else {
            fVar = b12;
            zVar = this;
            t0Var2 = t0Var;
        }
        fVar.X0(t0Var2, kotlin.collections.f0.J(), zVar.P(), null, kotlin.collections.f0.J());
        d6.L0(t0Var2);
        return fVar;
    }

    static /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.descriptors.f M0(z zVar, y3.r rVar, kotlin.reflect.jvm.internal.impl.types.t0 t0Var, Modality modality, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            t0Var = null;
        }
        return zVar.L0(rVar, t0Var, modality);
    }

    private final List<q1> N0(kotlin.reflect.jvm.internal.impl.descriptors.impl.i iVar) {
        Collection<y3.w> z5 = this.f45661o.z();
        ArrayList arrayList = new ArrayList(z5.size());
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a b6 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(TypeUsage.COMMON, false, false, null, 6, null);
        int i6 = 0;
        for (y3.w wVar : z5) {
            int i7 = i6 + 1;
            kotlin.reflect.jvm.internal.impl.types.t0 p5 = M().g().p(wVar.getType(), b6);
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.impl.u0(iVar, null, i6, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), wVar.getName(), p5, false, false, false, wVar.a() ? M().a().m().p().k(p5) : null, M().a().t().a(wVar)));
            i6 = i7;
        }
        return arrayList;
    }

    private final boolean R0(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        OverridingUtil.OverrideCompatibilityInfo.Result c6 = OverridingUtil.f46633f.F(aVar2, aVar, true).c();
        kotlin.jvm.internal.g0.o(c6, "getResult(...)");
        return c6 == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && !kotlin.reflect.jvm.internal.impl.load.java.y.f45859a.a(aVar2, aVar);
    }

    private final boolean S0(d1 d1Var) {
        SpecialGenericSignatures.a aVar = SpecialGenericSignatures.f45335a;
        kotlin.reflect.jvm.internal.impl.name.f name = d1Var.getName();
        kotlin.jvm.internal.g0.o(name, "getName(...)");
        kotlin.reflect.jvm.internal.impl.name.f b6 = aVar.b(name);
        if (b6 == null) {
            return false;
        }
        Set<d1> c12 = c1(b6);
        ArrayList arrayList = new ArrayList();
        for (Object obj : c12) {
            if (kotlin.reflect.jvm.internal.impl.load.java.r0.d((d1) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        d1 O0 = O0(d1Var, b6);
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (T0((d1) it.next(), O0)) {
                return true;
            }
        }
        return false;
    }

    private final boolean T0(d1 d1Var, kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        if (kotlin.reflect.jvm.internal.impl.load.java.e.f45424o.m(d1Var)) {
            yVar = yVar.a();
        }
        kotlin.jvm.internal.g0.m(yVar);
        return R0(yVar, d1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map V0(z zVar) {
        Collection<y3.n> F = zVar.f45661o.F();
        ArrayList arrayList = new ArrayList();
        for (Object obj : F) {
            if (((y3.n) obj).H()) {
                arrayList.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(i1.j(kotlin.collections.f0.d0(arrayList, 10)), 16));
        for (Object obj2 : arrayList) {
            linkedHashMap.put(((y3.n) obj2).getName(), obj2);
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection h1(d1 d1Var, z zVar, kotlin.reflect.jvm.internal.impl.name.f accessorName) {
        kotlin.jvm.internal.g0.p(accessorName, "accessorName");
        return kotlin.jvm.internal.g0.g(d1Var.getName(), accessorName) ? kotlin.collections.f0.l(d1Var) : kotlin.collections.f0.I4(zVar.q1(accessorName), zVar.r1(accessorName));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set i1(z zVar) {
        return kotlin.collections.f0.f6(zVar.f45661o.q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.d j1(z zVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar, kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        if (zVar.f45664r.invoke().contains(name)) {
            kotlin.reflect.jvm.internal.impl.load.java.t d6 = kVar.a().d();
            kotlin.reflect.jvm.internal.impl.name.b n6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.n(zVar.S());
            kotlin.jvm.internal.g0.m(n6);
            y3.g b6 = d6.b(new t.a(n6.d(name), null, zVar.f45661o, 2, null));
            if (b6 == null) {
                return null;
            }
            n nVar = new n(kVar, zVar.S(), b6, null, 8, null);
            kVar.a().e().a(nVar);
            return nVar;
        }
        if (!zVar.f45665s.invoke().contains(name)) {
            y3.n nVar2 = zVar.f45666t.invoke().get(name);
            if (nVar2 == null) {
                return null;
            }
            return kotlin.reflect.jvm.internal.impl.descriptors.impl.q.G0(kVar.e(), zVar.S(), name, kVar.e().e(new y(zVar)), kotlin.reflect.jvm.internal.impl.load.java.lazy.h.a(kVar, nVar2), kVar.a().t().a(nVar2));
        }
        List<kotlin.reflect.jvm.internal.impl.descriptors.d> j6 = kotlin.collections.f0.j();
        kVar.a().w().h(zVar.S(), name, j6, kVar);
        List b7 = kotlin.collections.f0.b(j6);
        int size = b7.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.d) kotlin.collections.f0.m5(b7);
        }
        throw new IllegalStateException(("Multiple classes with same name are generated: " + b7).toString());
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.e p1(y3.w wVar) {
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.e k12 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.e.k1(S(), kotlin.reflect.jvm.internal.impl.load.java.lazy.h.a(M(), wVar), wVar.getName(), M().a().t().a(wVar), true);
        kotlin.jvm.internal.g0.o(k12, "createJavaMethod(...)");
        k12.j1(null, P(), kotlin.collections.f0.J(), kotlin.collections.f0.J(), kotlin.collections.f0.J(), M().g().p(wVar.getType(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(TypeUsage.COMMON, false, false, null, 6, null)), Modality.Companion.a(false, false, true), kotlin.reflect.jvm.internal.impl.descriptors.r.f44948e, null);
        k12.n1(false, false);
        M().a().h().a(wVar, k12);
        return k12;
    }

    private final boolean s1(d1 d1Var) {
        kotlin.reflect.jvm.internal.impl.load.java.h hVar = kotlin.reflect.jvm.internal.impl.load.java.h.f45434o;
        kotlin.reflect.jvm.internal.impl.name.f name = d1Var.getName();
        kotlin.jvm.internal.g0.o(name, "getName(...)");
        if (!hVar.n(name)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.name.f name2 = d1Var.getName();
        kotlin.jvm.internal.g0.o(name2, "getName(...)");
        Set<d1> c12 = c1(name2);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = c12.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.y l6 = kotlin.reflect.jvm.internal.impl.load.java.h.l((d1) it.next());
            if (l6 != null) {
                arrayList.add(l6);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (f1(d1Var, (kotlin.reflect.jvm.internal.impl.descriptors.y) it2.next())) {
                return true;
            }
        }
        return false;
    }

    private final void t0(List<q1> list, kotlin.reflect.jvm.internal.impl.descriptors.j jVar, int i6, y3.r rVar, kotlin.reflect.jvm.internal.impl.types.t0 t0Var, kotlin.reflect.jvm.internal.impl.types.t0 t0Var2) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b6 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b();
        kotlin.reflect.jvm.internal.impl.name.f name = rVar.getName();
        kotlin.reflect.jvm.internal.impl.types.t0 n6 = j2.n(t0Var);
        kotlin.jvm.internal.g0.o(n6, "makeNotNullable(...)");
        list.add(new kotlin.reflect.jvm.internal.impl.descriptors.impl.u0(jVar, null, i6, b6, name, n6, rVar.K(), false, false, t0Var2 != null ? j2.n(t0Var2) : null, M().a().t().a(rVar)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    protected void C(@NotNull Collection<d1> result, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(result, "result");
        kotlin.jvm.internal.g0.p(name, "name");
        Set<d1> c12 = c1(name);
        if (!SpecialGenericSignatures.f45335a.k(name) && !kotlin.reflect.jvm.internal.impl.load.java.h.f45434o.n(name)) {
            if (!androidx.activity.k.a(c12) || !c12.isEmpty()) {
                Iterator<T> it = c12.iterator();
                while (it.hasNext()) {
                    if (((kotlin.reflect.jvm.internal.impl.descriptors.y) it.next()).isSuspend()) {
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : c12) {
                if (g1((d1) obj)) {
                    arrayList.add(obj);
                }
            }
            u0(result, name, arrayList, false);
            return;
        }
        kotlin.reflect.jvm.internal.impl.utils.k a6 = kotlin.reflect.jvm.internal.impl.utils.k.f47493c.a();
        Collection<? extends d1> d6 = kotlin.reflect.jvm.internal.impl.load.java.components.a.d(name, c12, kotlin.collections.f0.J(), S(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.v.f47070a, M().a().k().b());
        kotlin.jvm.internal.g0.o(d6, "resolveOverridesForNonStaticMembers(...)");
        v0(name, result, d6, result, new a(this));
        v0(name, result, d6, a6, new b(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : c12) {
            if (g1((d1) obj2)) {
                arrayList2.add(obj2);
            }
        }
        u0(result, name, kotlin.collections.f0.I4(arrayList2, a6), true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    protected void D(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> result) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(result, "result");
        if (this.f45661o.k()) {
            x0(name, result);
        }
        Set<kotlin.reflect.jvm.internal.impl.descriptors.w0> e12 = e1(name);
        if (e12.isEmpty()) {
            return;
        }
        k.b bVar = kotlin.reflect.jvm.internal.impl.utils.k.f47493c;
        kotlin.reflect.jvm.internal.impl.utils.k a6 = bVar.a();
        kotlin.reflect.jvm.internal.impl.utils.k a7 = bVar.a();
        w0(e12, result, a6, new w(this));
        w0(u1.x(e12, a6), a7, null, new x(this));
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> d6 = kotlin.reflect.jvm.internal.impl.load.java.components.a.d(name, u1.C(e12, a7), result, S(), M().a().c(), M().a().k().b());
        kotlin.jvm.internal.g0.o(d6, "resolveOverridesForNonStaticMembers(...)");
        result.addAll(d6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> E(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        if (this.f45661o.k()) {
            return b();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(O().invoke().d());
        Collection<kotlin.reflect.jvm.internal.impl.types.t0> i6 = S().o().i();
        kotlin.jvm.internal.g0.o(i6, "getSupertypes(...)");
        Iterator<T> it = i6.iterator();
        while (it.hasNext()) {
            kotlin.collections.f0.s0(linkedHashSet, ((kotlin.reflect.jvm.internal.impl.types.t0) it.next()).r().d());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    protected boolean W(@NotNull kotlin.reflect.jvm.internal.impl.load.java.descriptors.e eVar) {
        kotlin.jvm.internal.g0.p(eVar, "<this>");
        if (this.f45661o.k()) {
            return false;
        }
        return g1(eVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    protected t0.a Z(@NotNull y3.r method, @NotNull List<? extends kotlin.reflect.jvm.internal.impl.descriptors.j1> methodTypeParameters, @NotNull kotlin.reflect.jvm.internal.impl.types.t0 returnType, @NotNull List<? extends q1> valueParameters) {
        kotlin.jvm.internal.g0.p(method, "method");
        kotlin.jvm.internal.g0.p(methodTypeParameters, "methodTypeParameters");
        kotlin.jvm.internal.g0.p(returnType, "returnType");
        kotlin.jvm.internal.g0.p(valueParameters, "valueParameters");
        o.b b6 = M().a().s().b(method, S(), returnType, null, valueParameters, methodTypeParameters);
        kotlin.jvm.internal.g0.o(b6, "resolvePropagatedSignature(...)");
        kotlin.reflect.jvm.internal.impl.types.t0 d6 = b6.d();
        kotlin.jvm.internal.g0.o(d6, "getReturnType(...)");
        kotlin.reflect.jvm.internal.impl.types.t0 c6 = b6.c();
        List<q1> f6 = b6.f();
        kotlin.jvm.internal.g0.o(f6, "getValueParameters(...)");
        List<kotlin.reflect.jvm.internal.impl.descriptors.j1> e6 = b6.e();
        kotlin.jvm.internal.g0.o(e6, "getTypeParameters(...)");
        boolean g6 = b6.g();
        List<String> b7 = b6.b();
        kotlin.jvm.internal.g0.o(b7, "getErrors(...)");
        return new t0.a(d6, c6, f6, e6, g6, b7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0, kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        e(name, location);
        return super.a(name, location);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.storage.i<List<kotlin.reflect.jvm.internal.impl.descriptors.c>> b1() {
        return this.f45663q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0, kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        e(name, location);
        return super.c(name, location);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.d S() {
        return this.f45660n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        t3.a.a(M().a().l(), location, S(), name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f g(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.d> hVar;
        kotlin.reflect.jvm.internal.impl.descriptors.d invoke;
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        e(name, location);
        z zVar = (z) R();
        return (zVar == null || (hVar = zVar.f45667u) == null || (invoke = hVar.invoke(name)) == null) ? this.f45667u.invoke(name) : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    public String toString() {
        return "Lazy Java member scope for " + this.f45661o.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> w(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        return u1.C(this.f45664r.invoke(), this.f45666t.invoke().keySet());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet<kotlin.reflect.jvm.internal.impl.name.f> y(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        Collection<kotlin.reflect.jvm.internal.impl.types.t0> i6 = S().o().i();
        kotlin.jvm.internal.g0.o(i6, "getSupertypes(...)");
        LinkedHashSet<kotlin.reflect.jvm.internal.impl.name.f> linkedHashSet = new LinkedHashSet<>();
        Iterator<T> it = i6.iterator();
        while (it.hasNext()) {
            kotlin.collections.f0.s0(linkedHashSet, ((kotlin.reflect.jvm.internal.impl.types.t0) it.next()).r().b());
        }
        linkedHashSet.addAll(O().invoke().a());
        linkedHashSet.addAll(O().invoke().b());
        linkedHashSet.addAll(w(kindFilter, function1));
        linkedHashSet.addAll(M().a().w().d(S(), M()));
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    protected void z(@NotNull Collection<d1> result, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(result, "result");
        kotlin.jvm.internal.g0.p(name, "name");
        if (this.f45661o.A() && O().invoke().f(name) != null) {
            Collection<d1> collection = result;
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    if (((d1) it.next()).g().isEmpty()) {
                        break;
                    }
                }
            }
            y3.w f6 = O().invoke().f(name);
            kotlin.jvm.internal.g0.m(f6);
            result.add(p1(f6));
        }
        M().a().w().f(S(), name, result, M());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b A() {
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b(this.f45661o, u.f45649a);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.c H0() {
        kotlin.reflect.jvm.internal.impl.descriptors.d S = S();
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.b o12 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.b.o1(S, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), true, M().a().t().a(this.f45661o));
        kotlin.jvm.internal.g0.o(o12, "createJavaConstructor(...)");
        List<q1> N0 = N0(o12);
        o12.U0(false);
        o12.l1(N0, a1(S));
        o12.T0(false);
        o12.b1(S.s());
        return o12;
    }

    private final d1 J0(kotlin.reflect.jvm.internal.impl.descriptors.y yVar, Function1<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends d1>> function1) {
        Object obj;
        kotlin.reflect.jvm.internal.impl.name.f name = yVar.getName();
        kotlin.jvm.internal.g0.o(name, "getName(...)");
        Iterator<T> it = function1.invoke(name).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (f1((d1) obj, yVar)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        d1 d1Var = (d1) obj;
        if (d1Var == null) {
            return null;
        }
        y.a<? extends d1> n6 = d1Var.n();
        List<q1> g6 = yVar.g();
        kotlin.jvm.internal.g0.o(g6, "getValueParameters(...)");
        List<q1> list = g6;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((q1) it2.next()).getType());
        }
        List<q1> g7 = d1Var.g();
        kotlin.jvm.internal.g0.o(g7, "getValueParameters(...)");
        n6.n(kotlin.reflect.jvm.internal.impl.load.java.descriptors.h.a(arrayList, g7, yVar));
        n6.t();
        n6.g();
        n6.d(kotlin.reflect.jvm.internal.impl.load.java.descriptors.e.H, Boolean.TRUE);
        return n6.build();
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.f K0(kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var, Function1<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends d1>> function1) {
        d1 d1Var;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.m0 m0Var = null;
        if (!Q0(w0Var, function1)) {
            return null;
        }
        d1 X0 = X0(w0Var, function1);
        kotlin.jvm.internal.g0.m(X0);
        if (w0Var.C()) {
            d1Var = Y0(w0Var, function1);
            kotlin.jvm.internal.g0.m(d1Var);
        } else {
            d1Var = null;
        }
        if (d1Var != null) {
            d1Var.i();
            X0.i();
        }
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.d dVar = new kotlin.reflect.jvm.internal.impl.load.java.descriptors.d(S(), X0, d1Var, w0Var);
        kotlin.reflect.jvm.internal.impl.types.t0 returnType = X0.getReturnType();
        kotlin.jvm.internal.g0.m(returnType);
        dVar.X0(returnType, kotlin.collections.f0.J(), P(), null, kotlin.collections.f0.J());
        kotlin.reflect.jvm.internal.impl.descriptors.impl.l0 k6 = kotlin.reflect.jvm.internal.impl.resolve.h.k(dVar, X0.getAnnotations(), false, false, false, X0.getSource());
        k6.I0(X0);
        k6.L0(dVar.getType());
        kotlin.jvm.internal.g0.o(k6, "apply(...)");
        if (d1Var != null) {
            List<q1> g6 = d1Var.g();
            kotlin.jvm.internal.g0.o(g6, "getValueParameters(...)");
            q1 q1Var = (q1) kotlin.collections.f0.L2(g6);
            if (q1Var != null) {
                m0Var = kotlin.reflect.jvm.internal.impl.resolve.h.m(dVar, d1Var.getAnnotations(), q1Var.getAnnotations(), false, false, false, d1Var.getVisibility(), d1Var.getSource());
                m0Var.I0(d1Var);
            } else {
                throw new AssertionError("No parameter found for " + d1Var);
            }
        }
        dVar.Q0(k6, m0Var);
        return dVar;
    }

    private final d1 O0(d1 d1Var, kotlin.reflect.jvm.internal.impl.name.f fVar) {
        y.a<? extends d1> n6 = d1Var.n();
        n6.f(fVar);
        n6.t();
        n6.g();
        d1 build = n6.build();
        kotlin.jvm.internal.g0.m(build);
        return build;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlin.reflect.jvm.internal.impl.descriptors.d1 P0(kotlin.reflect.jvm.internal.impl.descriptors.d1 r6) {
        /*
            r5 = this;
            java.util.List r0 = r6.g()
            java.lang.String r1 = "getValueParameters(...)"
            kotlin.jvm.internal.g0.o(r0, r1)
            java.lang.Object r0 = kotlin.collections.f0.A3(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.q1 r0 = (kotlin.reflect.jvm.internal.impl.descriptors.q1) r0
            r2 = 0
            if (r0 == 0) goto L7d
            kotlin.reflect.jvm.internal.impl.types.t0 r3 = r0.getType()
            kotlin.reflect.jvm.internal.impl.types.w1 r3 = r3.I0()
            kotlin.reflect.jvm.internal.impl.descriptors.f r3 = r3.c()
            if (r3 == 0) goto L35
            kotlin.reflect.jvm.internal.impl.name.d r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.p(r3)
            if (r3 == 0) goto L35
            boolean r4 = r3.f()
            if (r4 == 0) goto L2d
            goto L2e
        L2d:
            r3 = r2
        L2e:
            if (r3 == 0) goto L35
            kotlin.reflect.jvm.internal.impl.name.c r3 = r3.m()
            goto L36
        L35:
            r3 = r2
        L36:
            kotlin.reflect.jvm.internal.impl.name.c r4 = kotlin.reflect.jvm.internal.impl.builtins.o.f44579w
            boolean r3 = kotlin.jvm.internal.g0.g(r3, r4)
            if (r3 == 0) goto L3f
            goto L40
        L3f:
            r0 = r2
        L40:
            if (r0 != 0) goto L43
            goto L7d
        L43:
            kotlin.reflect.jvm.internal.impl.descriptors.y$a r2 = r6.n()
            java.util.List r6 = r6.g()
            kotlin.jvm.internal.g0.o(r6, r1)
            r1 = 1
            java.util.List r6 = kotlin.collections.f0.h2(r6, r1)
            kotlin.reflect.jvm.internal.impl.descriptors.y$a r6 = r2.n(r6)
            kotlin.reflect.jvm.internal.impl.types.t0 r0 = r0.getType()
            java.util.List r0 = r0.G0()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            kotlin.reflect.jvm.internal.impl.types.c2 r0 = (kotlin.reflect.jvm.internal.impl.types.c2) r0
            kotlin.reflect.jvm.internal.impl.types.t0 r0 = r0.getType()
            kotlin.reflect.jvm.internal.impl.descriptors.y$a r6 = r6.h(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.y r6 = r6.build()
            kotlin.reflect.jvm.internal.impl.descriptors.d1 r6 = (kotlin.reflect.jvm.internal.impl.descriptors.d1) r6
            r0 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.impl.o0 r0 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.o0) r0
            if (r0 == 0) goto L7c
            r0.c1(r1)
        L7c:
            return r6
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.z.P0(kotlin.reflect.jvm.internal.impl.descriptors.d1):kotlin.reflect.jvm.internal.impl.descriptors.d1");
    }

    private final boolean Q0(kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var, Function1<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends d1>> function1) {
        if (d.a(w0Var)) {
            return false;
        }
        d1 X0 = X0(w0Var, function1);
        d1 Y0 = Y0(w0Var, function1);
        if (X0 == null) {
            return false;
        }
        if (!w0Var.C()) {
            return true;
        }
        if (Y0 == null || Y0.i() != X0.i()) {
            return false;
        }
        return true;
    }

    private final boolean U0(d1 d1Var) {
        d1 P0 = P0(d1Var);
        if (P0 == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.name.f name = d1Var.getName();
        kotlin.jvm.internal.g0.o(name, "getName(...)");
        Set<d1> c12 = c1(name);
        if (androidx.activity.k.a(c12) && c12.isEmpty()) {
            return false;
        }
        for (d1 d1Var2 : c12) {
            if (d1Var2.isSuspend() && R0(P0, d1Var2)) {
                return true;
            }
        }
        return false;
    }

    private final d1 W0(kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var, String str, Function1<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends d1>> function1) {
        d1 d1Var;
        boolean d6;
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(str);
        kotlin.jvm.internal.g0.o(h6, "identifier(...)");
        Iterator<T> it = function1.invoke(h6).iterator();
        do {
            d1Var = null;
            if (!it.hasNext()) {
                break;
            }
            d1 d1Var2 = (d1) it.next();
            if (d1Var2.g().size() == 0) {
                kotlin.reflect.jvm.internal.impl.types.checker.e eVar = kotlin.reflect.jvm.internal.impl.types.checker.e.f47168a;
                kotlin.reflect.jvm.internal.impl.types.t0 returnType = d1Var2.getReturnType();
                if (returnType == null) {
                    d6 = false;
                } else {
                    d6 = eVar.d(returnType, w0Var.getType());
                }
                if (d6) {
                    d1Var = d1Var2;
                }
            }
        } while (d1Var == null);
        return d1Var;
    }

    private final d1 X0(kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var, Function1<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends d1>> function1) {
        kotlin.reflect.jvm.internal.impl.descriptors.x0 x0Var;
        kotlin.reflect.jvm.internal.impl.descriptors.x0 getter = w0Var.getGetter();
        String str = null;
        if (getter != null) {
            x0Var = (kotlin.reflect.jvm.internal.impl.descriptors.x0) kotlin.reflect.jvm.internal.impl.load.java.r0.g(getter);
        } else {
            x0Var = null;
        }
        if (x0Var != null) {
            str = kotlin.reflect.jvm.internal.impl.load.java.l.f45498a.b(x0Var);
        }
        if (str != null && !kotlin.reflect.jvm.internal.impl.load.java.r0.l(S(), x0Var)) {
            return W0(w0Var, str, function1);
        }
        String b6 = w0Var.getName().b();
        kotlin.jvm.internal.g0.o(b6, "asString(...)");
        return W0(w0Var, kotlin.reflect.jvm.internal.impl.load.java.h0.b(b6), function1);
    }

    private final d1 Y0(kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var, Function1<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends d1>> function1) {
        d1 d1Var;
        kotlin.reflect.jvm.internal.impl.types.t0 returnType;
        String b6 = w0Var.getName().b();
        kotlin.jvm.internal.g0.o(b6, "asString(...)");
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(kotlin.reflect.jvm.internal.impl.load.java.h0.e(b6));
        kotlin.jvm.internal.g0.o(h6, "identifier(...)");
        Iterator<T> it = function1.invoke(h6).iterator();
        do {
            d1Var = null;
            if (!it.hasNext()) {
                break;
            }
            d1 d1Var2 = (d1) it.next();
            if (d1Var2.g().size() == 1 && (returnType = d1Var2.getReturnType()) != null && kotlin.reflect.jvm.internal.impl.builtins.j.D0(returnType)) {
                kotlin.reflect.jvm.internal.impl.types.checker.e eVar = kotlin.reflect.jvm.internal.impl.types.checker.e.f47168a;
                List<q1> g6 = d1Var2.g();
                kotlin.jvm.internal.g0.o(g6, "getValueParameters(...)");
                if (eVar.a(((q1) kotlin.collections.f0.m5(g6)).getType(), w0Var.getType())) {
                    d1Var = d1Var2;
                }
            }
        } while (d1Var == null);
        return d1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set Z0(kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar, z zVar) {
        return kotlin.collections.f0.f6(kVar.a().w().c(zVar.S(), kVar));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.s a1(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.s visibility = dVar.getVisibility();
        kotlin.jvm.internal.g0.o(visibility, "getVisibility(...)");
        if (kotlin.jvm.internal.g0.g(visibility, kotlin.reflect.jvm.internal.impl.load.java.x.f45856b)) {
            kotlin.reflect.jvm.internal.impl.descriptors.s PROTECTED_AND_PACKAGE = kotlin.reflect.jvm.internal.impl.load.java.x.f45857c;
            kotlin.jvm.internal.g0.o(PROTECTED_AND_PACKAGE, "PROTECTED_AND_PACKAGE");
            return PROTECTED_AND_PACKAGE;
        }
        return visibility;
    }

    private final Set<d1> c1(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        Collection<kotlin.reflect.jvm.internal.impl.types.t0> D0 = D0();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = D0.iterator();
        while (it.hasNext()) {
            kotlin.collections.f0.s0(linkedHashSet, ((kotlin.reflect.jvm.internal.impl.types.t0) it.next()).r().a(fVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    private final Set<kotlin.reflect.jvm.internal.impl.descriptors.w0> e1(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        Collection<kotlin.reflect.jvm.internal.impl.types.t0> D0 = D0();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = D0.iterator();
        while (it.hasNext()) {
            Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> c6 = ((kotlin.reflect.jvm.internal.impl.types.t0) it.next()).r().c(fVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(c6, 10));
            Iterator<T> it2 = c6.iterator();
            while (it2.hasNext()) {
                arrayList2.add((kotlin.reflect.jvm.internal.impl.descriptors.w0) it2.next());
            }
            kotlin.collections.f0.s0(arrayList, arrayList2);
        }
        return kotlin.collections.f0.f6(arrayList);
    }

    private final boolean g1(d1 d1Var) {
        kotlin.reflect.jvm.internal.impl.name.f name = d1Var.getName();
        kotlin.jvm.internal.g0.o(name, "getName(...)");
        List<kotlin.reflect.jvm.internal.impl.name.f> a6 = kotlin.reflect.jvm.internal.impl.load.java.n0.a(name);
        if (!(a6 instanceof Collection) || !a6.isEmpty()) {
            Iterator<T> it = a6.iterator();
            while (it.hasNext()) {
                Set<kotlin.reflect.jvm.internal.impl.descriptors.w0> e12 = e1((kotlin.reflect.jvm.internal.impl.name.f) it.next());
                if (!androidx.activity.k.a(e12) || !e12.isEmpty()) {
                    for (kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var : e12) {
                        if (Q0(w0Var, new v(d1Var, this))) {
                            if (!w0Var.C()) {
                                String b6 = d1Var.getName().b();
                                kotlin.jvm.internal.g0.o(b6, "asString(...)");
                                if (!kotlin.reflect.jvm.internal.impl.load.java.h0.d(b6)) {
                                }
                            }
                            return false;
                        }
                    }
                }
            }
        }
        if (S0(d1Var) || s1(d1Var) || U0(d1Var)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set k1(z zVar) {
        return u1.C(zVar.b(), zVar.d());
    }

    private final d1 l1(d1 d1Var, Function1<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends d1>> function1, Collection<? extends d1> collection) {
        d1 J0;
        kotlin.reflect.jvm.internal.impl.descriptors.y l6 = kotlin.reflect.jvm.internal.impl.load.java.h.l(d1Var);
        if (l6 != null && (J0 = J0(l6, function1)) != null) {
            if (!g1(J0)) {
                J0 = null;
            }
            if (J0 != null) {
                return I0(J0, l6, collection);
            }
        }
        return null;
    }

    private final d1 m1(d1 d1Var, Function1<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends d1>> function1, kotlin.reflect.jvm.internal.impl.name.f fVar, Collection<? extends d1> collection) {
        d1 d1Var2 = (d1) kotlin.reflect.jvm.internal.impl.load.java.r0.g(d1Var);
        if (d1Var2 == null) {
            return null;
        }
        String e6 = kotlin.reflect.jvm.internal.impl.load.java.r0.e(d1Var2);
        kotlin.jvm.internal.g0.m(e6);
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(e6);
        kotlin.jvm.internal.g0.o(h6, "identifier(...)");
        Iterator<? extends d1> it = function1.invoke(h6).iterator();
        while (it.hasNext()) {
            d1 O0 = O0(it.next(), fVar);
            if (T0(d1Var2, O0)) {
                return I0(O0, d1Var2, collection);
            }
        }
        return null;
    }

    private final d1 n1(d1 d1Var, Function1<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends d1>> function1) {
        if (!d1Var.isSuspend()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.f name = d1Var.getName();
        kotlin.jvm.internal.g0.o(name, "getName(...)");
        Iterator<T> it = function1.invoke(name).iterator();
        while (it.hasNext()) {
            d1 P0 = P0((d1) it.next());
            if (P0 == null || !R0(P0, d1Var)) {
                P0 = null;
            }
            if (P0 != null) {
                return P0;
            }
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.b o1(y3.k kVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.d S = S();
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.b o12 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.b.o1(S, kotlin.reflect.jvm.internal.impl.load.java.lazy.h.a(M(), kVar), false, M().a().t().a(kVar));
        kotlin.jvm.internal.g0.o(o12, "createJavaConstructor(...)");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.k h6 = kotlin.reflect.jvm.internal.impl.load.java.lazy.c.h(M(), o12, kVar, S.t().size());
        t0.b e02 = e0(h6, o12, kVar.g());
        List<kotlin.reflect.jvm.internal.impl.descriptors.j1> t5 = S.t();
        kotlin.jvm.internal.g0.o(t5, "getDeclaredTypeParameters(...)");
        List<kotlin.reflect.jvm.internal.impl.descriptors.j1> list = t5;
        List<y3.y> typeParameters = kVar.getTypeParameters();
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.j1 a6 = h6.f().a((y3.y) it.next());
            kotlin.jvm.internal.g0.m(a6);
            arrayList.add(a6);
        }
        o12.m1(e02.a(), kotlin.reflect.jvm.internal.impl.load.java.s0.d(kVar.getVisibility()), kotlin.collections.f0.I4(list, arrayList));
        o12.T0(false);
        o12.U0(e02.b());
        o12.b1(S.s());
        h6.a().h().b(kVar, o12);
        return o12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<d1> q1(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        Collection<y3.r> e6 = O().invoke().e(fVar);
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(e6, 10));
        Iterator<T> it = e6.iterator();
        while (it.hasNext()) {
            arrayList.add(a0((y3.r) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<d1> r1(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        Set<d1> c12 = c1(fVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : c12) {
            d1 d1Var = (d1) obj;
            if (!kotlin.reflect.jvm.internal.impl.load.java.r0.d(d1Var) && kotlin.reflect.jvm.internal.impl.load.java.h.l(d1Var) == null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final void u0(Collection<d1> collection, kotlin.reflect.jvm.internal.impl.name.f fVar, Collection<? extends d1> collection2, boolean z5) {
        Collection<? extends d1> d6 = kotlin.reflect.jvm.internal.impl.load.java.components.a.d(fVar, collection2, collection, S(), M().a().c(), M().a().k().b());
        kotlin.jvm.internal.g0.o(d6, "resolveOverridesForNonStaticMembers(...)");
        if (!z5) {
            collection.addAll(d6);
            return;
        }
        Collection<? extends d1> collection3 = d6;
        List I4 = kotlin.collections.f0.I4(collection, collection3);
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(collection3, 10));
        for (d1 d1Var : collection3) {
            d1 d1Var2 = (d1) kotlin.reflect.jvm.internal.impl.load.java.r0.j(d1Var);
            if (d1Var2 == null) {
                kotlin.jvm.internal.g0.m(d1Var);
            } else {
                kotlin.jvm.internal.g0.m(d1Var);
                d1Var = I0(d1Var, d1Var2, I4);
            }
            arrayList.add(d1Var);
        }
        collection.addAll(arrayList);
    }

    private final void v0(kotlin.reflect.jvm.internal.impl.name.f fVar, Collection<? extends d1> collection, Collection<? extends d1> collection2, Collection<d1> collection3, Function1<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends d1>> function1) {
        for (d1 d1Var : collection2) {
            kotlin.reflect.jvm.internal.impl.utils.a.a(collection3, m1(d1Var, function1, fVar, collection));
            kotlin.reflect.jvm.internal.impl.utils.a.a(collection3, l1(d1Var, function1, collection));
            kotlin.reflect.jvm.internal.impl.utils.a.a(collection3, n1(d1Var, function1));
        }
    }

    private final void w0(Set<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> set, Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> collection, Set<kotlin.reflect.jvm.internal.impl.descriptors.w0> set2, Function1<? super kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends d1>> function1) {
        for (kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var : set) {
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.f K0 = K0(w0Var, function1);
            if (K0 != null) {
                collection.add(K0);
                if (set2 != null) {
                    set2.add(w0Var);
                    return;
                }
                return;
            }
        }
    }

    private final void x0(kotlin.reflect.jvm.internal.impl.name.f fVar, Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> collection) {
        y3.r rVar = (y3.r) kotlin.collections.f0.n5(O().invoke().e(fVar));
        if (rVar == null) {
            return;
        }
        collection.add(M0(this, rVar, null, Modality.FINAL, 2, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @Nullable
    protected kotlin.reflect.jvm.internal.impl.descriptors.z0 P() {
        return kotlin.reflect.jvm.internal.impl.resolve.i.l(S());
    }
}
