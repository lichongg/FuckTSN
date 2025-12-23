package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.i1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.s1;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.c;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.j2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLazyJavaScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,408:1\n1491#2:409\n1516#2,3:410\n1519#2,3:420\n1563#2:423\n1634#2,3:424\n1563#2:427\n1634#2,3:428\n382#3,7:413\n*S KotlinDebug\n*F\n+ 1 LazyJavaScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaScope\n*L\n129#1:409\n129#1:410,3\n129#1:420,3\n165#1:423\n165#1:424,3\n212#1:427\n212#1:428,3\n129#1:413,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class t0 extends kotlin.reflect.jvm.internal.impl.resolve.scopes.l {

    /* renamed from: m, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f45629m = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(t0.class, "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(t0.class, "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(t0.class, "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;", 0))};

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.k f45630b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final t0 f45631c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.k>> f45632d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i<c> f45633e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, Collection<d1>> f45634f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.w0> f45635g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, Collection<d1>> f45636h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f45637i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f45638j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f45639k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, List<kotlin.reflect.jvm.internal.impl.descriptors.w0>> f45640l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.types.t0 f45641a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final kotlin.reflect.jvm.internal.impl.types.t0 f45642b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private final List<q1> f45643c;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private final List<j1> f45644d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f45645e;

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        private final List<String> f45646f;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.g0.g(this.f45641a, aVar.f45641a) && kotlin.jvm.internal.g0.g(this.f45642b, aVar.f45642b) && kotlin.jvm.internal.g0.g(this.f45643c, aVar.f45643c) && kotlin.jvm.internal.g0.g(this.f45644d, aVar.f45644d) && this.f45645e == aVar.f45645e && kotlin.jvm.internal.g0.g(this.f45646f, aVar.f45646f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 returnType, @Nullable kotlin.reflect.jvm.internal.impl.types.t0 t0Var, @NotNull List<? extends q1> valueParameters, @NotNull List<? extends j1> typeParameters, boolean z5, @NotNull List<String> errors) {
            kotlin.jvm.internal.g0.p(returnType, "returnType");
            kotlin.jvm.internal.g0.p(valueParameters, "valueParameters");
            kotlin.jvm.internal.g0.p(typeParameters, "typeParameters");
            kotlin.jvm.internal.g0.p(errors, "errors");
            this.f45641a = returnType;
            this.f45642b = t0Var;
            this.f45643c = valueParameters;
            this.f45644d = typeParameters;
            this.f45645e = z5;
            this.f45646f = errors;
        }

        @NotNull
        public final List<String> a() {
            return this.f45646f;
        }

        public final boolean b() {
            return this.f45645e;
        }

        @Nullable
        public final kotlin.reflect.jvm.internal.impl.types.t0 c() {
            return this.f45642b;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.types.t0 d() {
            return this.f45641a;
        }

        @NotNull
        public final List<j1> e() {
            return this.f45644d;
        }

        @NotNull
        public final List<q1> f() {
            return this.f45643c;
        }

        public int hashCode() {
            int hashCode = this.f45641a.hashCode() * 31;
            kotlin.reflect.jvm.internal.impl.types.t0 t0Var = this.f45642b;
            return ((((((((hashCode + (t0Var == null ? 0 : t0Var.hashCode())) * 31) + this.f45643c.hashCode()) * 31) + this.f45644d.hashCode()) * 31) + kotlin.reflect.jvm.internal.impl.km.f.a(this.f45645e)) * 31) + this.f45646f.hashCode();
        }

        @NotNull
        public String toString() {
            return "MethodSignatureData(returnType=" + this.f45641a + ", receiverType=" + this.f45642b + ", valueParameters=" + this.f45643c + ", typeParameters=" + this.f45644d + ", hasStableParameterNames=" + this.f45645e + ", errors=" + this.f45646f + ')';
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final List<q1> f45647a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f45648b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull List<? extends q1> descriptors, boolean z5) {
            kotlin.jvm.internal.g0.p(descriptors, "descriptors");
            this.f45647a = descriptors;
            this.f45648b = z5;
        }

        @NotNull
        public final List<q1> a() {
            return this.f45647a;
        }

        public final boolean b() {
            return this.f45648b;
        }
    }

    public /* synthetic */ t0(kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar, t0 t0Var, int i6, kotlin.jvm.internal.v vVar) {
        this(kVar, (i6 & 2) != 0 ? null : t0Var);
    }

    @NotNull
    protected abstract c A();

    protected abstract void C(@NotNull Collection<d1> collection, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

    protected abstract void D(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> collection);

    @NotNull
    protected abstract Set<kotlin.reflect.jvm.internal.impl.name.f> E(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, @Nullable Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1);

    @Nullable
    protected abstract kotlin.reflect.jvm.internal.impl.descriptors.z0 P();

    @NotNull
    protected abstract kotlin.reflect.jvm.internal.impl.descriptors.k S();

    @NotNull
    protected abstract a Z(@NotNull y3.r rVar, @NotNull List<? extends j1> list, @NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var, @NotNull List<? extends q1> list2);

    @NotNull
    protected abstract Set<kotlin.reflect.jvm.internal.impl.name.f> w(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, @Nullable Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1);

    @NotNull
    protected abstract Set<kotlin.reflect.jvm.internal.impl.name.f> y(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, @Nullable Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1);

    public t0(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6, @Nullable t0 t0Var) {
        kotlin.jvm.internal.g0.p(c6, "c");
        this.f45630b = c6;
        this.f45631c = t0Var;
        this.f45632d = c6.e().a(new h0(this), kotlin.collections.f0.J());
        this.f45633e = c6.e().e(new k0(this));
        this.f45634f = c6.e().i(new l0(this));
        this.f45635g = c6.e().c(new m0(this));
        this.f45636h = c6.e().i(new n0(this));
        this.f45637i = c6.e().e(new o0(this));
        this.f45638j = c6.e().e(new p0(this));
        this.f45639k = c6.e().e(new q0(this));
        this.f45640l = c6.e().i(new r0(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.w0 G(t0 t0Var, kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        t0 t0Var2 = t0Var.f45631c;
        if (t0Var2 != null) {
            return t0Var2.f45635g.invoke(name);
        }
        y3.n c6 = t0Var.f45633e.invoke().c(name);
        if (c6 == null || c6.H()) {
            return null;
        }
        return t0Var.b0(c6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection H(t0 t0Var, kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        t0 t0Var2 = t0Var.f45631c;
        if (t0Var2 != null) {
            return t0Var2.f45634f.invoke(name);
        }
        ArrayList arrayList = new ArrayList();
        for (y3.r rVar : t0Var.f45633e.invoke().e(name)) {
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.e a02 = t0Var.a0(rVar);
            if (t0Var.W(a02)) {
                t0Var.f45630b.a().h().a(rVar, a02);
                arrayList.add(a02);
            }
        }
        t0Var.z(arrayList, name);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set J(t0 t0Var) {
        return t0Var.y(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46758v, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection K(t0 t0Var, kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        LinkedHashSet linkedHashSet = new LinkedHashSet(t0Var.f45634f.invoke(name));
        t0Var.f0(linkedHashSet);
        t0Var.C(linkedHashSet, name);
        return kotlin.collections.f0.a6(t0Var.f45630b.a().r().p(t0Var.f45630b, linkedHashSet));
    }

    private final Set<kotlin.reflect.jvm.internal.impl.name.f> N() {
        return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f45639k, this, f45629m[2]);
    }

    private final Set<kotlin.reflect.jvm.internal.impl.name.f> Q() {
        return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f45637i, this, f45629m[0]);
    }

    private final Set<kotlin.reflect.jvm.internal.impl.name.f> T() {
        return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f45638j, this, f45629m[1]);
    }

    private final kotlin.reflect.jvm.internal.impl.types.t0 U(y3.n nVar) {
        kotlin.reflect.jvm.internal.impl.types.t0 p5 = this.f45630b.g().p(nVar.getType(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(TypeUsage.COMMON, false, false, null, 7, null));
        if ((!kotlin.reflect.jvm.internal.impl.builtins.j.t0(p5) && !kotlin.reflect.jvm.internal.impl.builtins.j.w0(p5)) || !V(nVar) || !nVar.x()) {
            return p5;
        }
        kotlin.reflect.jvm.internal.impl.types.t0 n6 = j2.n(p5);
        kotlin.jvm.internal.g0.o(n6, "makeNotNullable(...)");
        return n6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List X(t0 t0Var, kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        ArrayList arrayList = new ArrayList();
        kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, t0Var.f45635g.invoke(name));
        t0Var.D(name, arrayList);
        return kotlin.reflect.jvm.internal.impl.resolve.i.t(t0Var.S()) ? kotlin.collections.f0.a6(arrayList) : kotlin.collections.f0.a6(t0Var.f45630b.a().r().p(t0Var.f45630b, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set Y(t0 t0Var) {
        return t0Var.E(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46759w, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, kotlin.reflect.jvm.internal.impl.descriptors.impl.k0] */
    /* JADX WARN: Type inference failed for: r1v15, types: [T, kotlin.reflect.jvm.internal.impl.descriptors.impl.k0] */
    private final kotlin.reflect.jvm.internal.impl.descriptors.w0 b0(y3.n nVar) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? F = F(nVar);
        objectRef.element = F;
        F.R0(null, null, null, null);
        ((kotlin.reflect.jvm.internal.impl.descriptors.impl.k0) objectRef.element).X0(U(nVar), kotlin.collections.f0.J(), P(), null, kotlin.collections.f0.J());
        kotlin.reflect.jvm.internal.impl.descriptors.k S = S();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = S instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) S : null;
        if (dVar != null) {
            objectRef.element = this.f45630b.a().w().b(dVar, (kotlin.reflect.jvm.internal.impl.descriptors.impl.k0) objectRef.element, this.f45630b);
        }
        T t5 = objectRef.element;
        if (kotlin.reflect.jvm.internal.impl.resolve.i.K((s1) t5, ((kotlin.reflect.jvm.internal.impl.descriptors.impl.k0) t5).getType())) {
            ((kotlin.reflect.jvm.internal.impl.descriptors.impl.k0) objectRef.element).H0(new i0(this, nVar, objectRef));
        }
        this.f45630b.a().h().e(nVar, (kotlin.reflect.jvm.internal.impl.descriptors.w0) objectRef.element);
        return (kotlin.reflect.jvm.internal.impl.descriptors.w0) objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.storage.j c0(t0 t0Var, y3.n nVar, Ref.ObjectRef objectRef) {
        return t0Var.f45630b.e().g(new j0(t0Var, nVar, objectRef));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.constants.g d0(t0 t0Var, y3.n nVar, Ref.ObjectRef objectRef) {
        return t0Var.f45630b.a().g().a(nVar, (kotlin.reflect.jvm.internal.impl.descriptors.w0) objectRef.element);
    }

    private final void f0(Set<d1> set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String c6 = kotlin.reflect.jvm.internal.impl.load.kotlin.c0.c((d1) obj, false, false, 2, null);
            Object obj2 = linkedHashMap.get(c6);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(c6, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                List list2 = list;
                Collection<? extends d1> b6 = kotlin.reflect.jvm.internal.impl.resolve.p.b(list2, s0.f45626a);
                set.removeAll(list2);
                set.addAll(b6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.a g0(d1 selectMostSpecificInEachOverridableGroup) {
        kotlin.jvm.internal.g0.p(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection u(t0 t0Var) {
        return t0Var.x(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46751o, kotlin.reflect.jvm.internal.impl.resolve.scopes.k.f46777a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set v(t0 t0Var) {
        return t0Var.w(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46756t, null);
    }

    @NotNull
    protected final kotlin.reflect.jvm.internal.impl.types.t0 B(@NotNull y3.r method, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6) {
        kotlin.jvm.internal.g0.p(method, "method");
        kotlin.jvm.internal.g0.p(c6, "c");
        return c6.g().p(method.getReturnType(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(TypeUsage.COMMON, method.y().k(), false, null, 6, null));
    }

    @NotNull
    protected final kotlin.reflect.jvm.internal.impl.storage.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.k>> L() {
        return this.f45632d;
    }

    @NotNull
    protected final kotlin.reflect.jvm.internal.impl.load.java.lazy.k M() {
        return this.f45630b;
    }

    @NotNull
    protected final kotlin.reflect.jvm.internal.impl.storage.i<c> O() {
        return this.f45633e;
    }

    @Nullable
    protected final t0 R() {
        return this.f45631c;
    }

    protected boolean W(@NotNull kotlin.reflect.jvm.internal.impl.load.java.descriptors.e eVar) {
        kotlin.jvm.internal.g0.p(eVar, "<this>");
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        return !b().contains(name) ? kotlin.collections.f0.J() : this.f45636h.invoke(name);
    }

    @NotNull
    protected final kotlin.reflect.jvm.internal.impl.load.java.descriptors.e a0(@NotNull y3.r method) {
        kotlin.jvm.internal.g0.p(method, "method");
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.e k12 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.e.k1(S(), kotlin.reflect.jvm.internal.impl.load.java.lazy.h.a(this.f45630b, method), method.getName(), this.f45630b.a().t().a(method), this.f45633e.invoke().f(method.getName()) != null && method.g().isEmpty());
        kotlin.jvm.internal.g0.o(k12, "createJavaMethod(...)");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.k i6 = kotlin.reflect.jvm.internal.impl.load.java.lazy.c.i(this.f45630b, k12, method, 0, 4, null);
        List<y3.y> typeParameters = method.getTypeParameters();
        List<? extends j1> arrayList = new ArrayList<>(kotlin.collections.f0.d0(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            j1 a6 = i6.f().a((y3.y) it.next());
            kotlin.jvm.internal.g0.m(a6);
            arrayList.add(a6);
        }
        b e02 = e0(i6, k12, method.g());
        a Z = Z(method, arrayList, B(method, i6), e02.a());
        kotlin.reflect.jvm.internal.impl.types.t0 c6 = Z.c();
        k12.j1(c6 != null ? kotlin.reflect.jvm.internal.impl.resolve.h.i(k12, c6, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b()) : null, P(), kotlin.collections.f0.J(), Z.e(), Z.f(), Z.d(), Modality.Companion.a(false, method.isAbstract(), !method.isFinal()), kotlin.reflect.jvm.internal.impl.load.java.s0.d(method.getVisibility()), Z.c() != null ? i1.k(kotlin.o0.a(kotlin.reflect.jvm.internal.impl.load.java.descriptors.e.G, kotlin.collections.f0.G2(e02.a()))) : i1.z());
        k12.n1(Z.b(), e02.b());
        if (!Z.a().isEmpty()) {
            i6.a().s().a(k12, Z.a());
        }
        return k12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        return !d().contains(name) ? kotlin.collections.f0.J() : this.f45640l.invoke(name);
    }

    @NotNull
    protected final b e0(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.y yVar, @NotNull List<? extends y3.b0> jValueParameters) {
        Pair a6;
        kotlin.reflect.jvm.internal.impl.name.f name;
        kotlin.jvm.internal.g0.p(c6, "c");
        kotlin.reflect.jvm.internal.impl.descriptors.y function = yVar;
        kotlin.jvm.internal.g0.p(function, "function");
        kotlin.jvm.internal.g0.p(jValueParameters, "jValueParameters");
        Iterable<kotlin.collections.a1> m6 = kotlin.collections.f0.m6(jValueParameters);
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(m6, 10));
        boolean z5 = false;
        for (kotlin.collections.a1 a1Var : m6) {
            int a7 = a1Var.a();
            y3.b0 b0Var = (y3.b0) a1Var.b();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g a8 = kotlin.reflect.jvm.internal.impl.load.java.lazy.h.a(c6, b0Var);
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a b6 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(TypeUsage.COMMON, false, false, null, 7, null);
            if (b0Var.a()) {
                y3.x type = b0Var.getType();
                y3.f fVar = type instanceof y3.f ? (y3.f) type : null;
                if (fVar == null) {
                    throw new AssertionError("Vararg parameter should be an array: " + b0Var);
                }
                kotlin.reflect.jvm.internal.impl.types.t0 l6 = c6.g().l(fVar, b6, true);
                a6 = kotlin.o0.a(l6, c6.d().p().k(l6));
            } else {
                a6 = kotlin.o0.a(c6.g().p(b0Var.getType(), b6), null);
            }
            kotlin.reflect.jvm.internal.impl.types.t0 t0Var = (kotlin.reflect.jvm.internal.impl.types.t0) a6.component1();
            kotlin.reflect.jvm.internal.impl.types.t0 t0Var2 = (kotlin.reflect.jvm.internal.impl.types.t0) a6.component2();
            if (kotlin.jvm.internal.g0.g(function.getName().b(), "equals") && jValueParameters.size() == 1 && kotlin.jvm.internal.g0.g(c6.d().p().J(), t0Var)) {
                name = kotlin.reflect.jvm.internal.impl.name.f.h("other");
            } else {
                name = b0Var.getName();
                if (name == null) {
                    z5 = true;
                }
                if (name == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('p');
                    sb.append(a7);
                    name = kotlin.reflect.jvm.internal.impl.name.f.h(sb.toString());
                    kotlin.jvm.internal.g0.o(name, "identifier(...)");
                }
            }
            boolean z6 = z5;
            kotlin.jvm.internal.g0.m(name);
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.impl.u0(function, null, a7, a8, name, t0Var, false, false, false, t0Var2, c6.a().t().a(b0Var)));
            function = yVar;
            z5 = z6;
        }
        return new b(kotlin.collections.f0.a6(arrayList), z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        kotlin.jvm.internal.g0.p(nameFilter, "nameFilter");
        return this.f45632d.invoke();
    }

    @NotNull
    public String toString() {
        return "Lazy scope for " + S();
    }

    @NotNull
    protected final List<kotlin.reflect.jvm.internal.impl.descriptors.k> x(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        kotlin.jvm.internal.g0.p(nameFilter, "nameFilter");
        NoLookupLocation noLookupLocation = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46739c.c())) {
            for (kotlin.reflect.jvm.internal.impl.name.f fVar : w(kindFilter, nameFilter)) {
                if (nameFilter.invoke(fVar).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.a.a(linkedHashSet, g(fVar, noLookupLocation));
                }
            }
        }
        if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46739c.d()) && !kindFilter.l().contains(c.a.f46736a)) {
            for (kotlin.reflect.jvm.internal.impl.name.f fVar2 : y(kindFilter, nameFilter)) {
                if (nameFilter.invoke(fVar2).booleanValue()) {
                    linkedHashSet.addAll(a(fVar2, noLookupLocation));
                }
            }
        }
        if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46739c.i()) && !kindFilter.l().contains(c.a.f46736a)) {
            for (kotlin.reflect.jvm.internal.impl.name.f fVar3 : E(kindFilter, nameFilter)) {
                if (nameFilter.invoke(fVar3).booleanValue()) {
                    linkedHashSet.addAll(c(fVar3, noLookupLocation));
                }
            }
        }
        return kotlin.collections.f0.a6(linkedHashSet);
    }

    protected void z(@NotNull Collection<d1> result, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(result, "result");
        kotlin.jvm.internal.g0.p(name, "name");
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.impl.k0 F(y3.n nVar) {
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.f b12 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.f.b1(S(), kotlin.reflect.jvm.internal.impl.load.java.lazy.h.a(this.f45630b, nVar), Modality.FINAL, kotlin.reflect.jvm.internal.impl.load.java.s0.d(nVar.getVisibility()), !nVar.isFinal(), nVar.getName(), this.f45630b.a().t().a(nVar), V(nVar));
        kotlin.jvm.internal.g0.o(b12, "create(...)");
        return b12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c I(t0 t0Var) {
        return t0Var.A();
    }

    private final boolean V(y3.n nVar) {
        if (nVar.isFinal() && nVar.L()) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        return Q();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        return T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> f() {
        return N();
    }
}
