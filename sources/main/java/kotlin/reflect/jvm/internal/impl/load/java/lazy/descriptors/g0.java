package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.c;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.java.t;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.v;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLazyJavaPackageScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaPackageScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaPackageScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,188:1\n1634#2,3:189\n1625#2:192\n1869#2:193\n1870#2:195\n1626#2:196\n774#2:197\n865#2,2:198\n1#3:194\n1#3:200\n*S KotlinDebug\n*F\n+ 1 LazyJavaPackageScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaPackageScope\n*L\n159#1:189,3\n161#1:192\n161#1:193\n161#1:195\n161#1:196\n184#1:197\n184#1:198,2\n161#1:194\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g0 extends a1 {

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final y3.u f45562n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final d0 f45563o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.j<Set<String>> f45564p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.h<a, kotlin.reflect.jvm.internal.impl.descriptors.d> f45565q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.name.f f45566a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final y3.g f45567b;

        public a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @Nullable y3.g gVar) {
            kotlin.jvm.internal.g0.p(name, "name");
            this.f45566a = name;
            this.f45567b = gVar;
        }

        @Nullable
        public final y3.g a() {
            return this.f45567b;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.f b() {
            return this.f45566a;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.g0.g(this.f45566a, ((a) obj).f45566a);
        }

        public int hashCode() {
            return this.f45566a.hashCode();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class b {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            private final kotlin.reflect.jvm.internal.impl.descriptors.d f45568a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d descriptor) {
                super(null);
                kotlin.jvm.internal.g0.p(descriptor, "descriptor");
                this.f45568a = descriptor;
            }

            @NotNull
            public final kotlin.reflect.jvm.internal.impl.descriptors.d a() {
                return this.f45568a;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.g0$b$b, reason: collision with other inner class name */
        public static final class C0889b extends b {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C0889b f45569a = new C0889b();

            private C0889b() {
                super(null);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class c extends b {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final c f45570a = new c();

            private c() {
                super(null);
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.v vVar) {
            this();
        }

        private b() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6, @NotNull y3.u jPackage, @NotNull d0 ownerDescriptor) {
        super(c6);
        kotlin.jvm.internal.g0.p(c6, "c");
        kotlin.jvm.internal.g0.p(jPackage, "jPackage");
        kotlin.jvm.internal.g0.p(ownerDescriptor, "ownerDescriptor");
        this.f45562n = jPackage;
        this.f45563o = ownerDescriptor;
        this.f45564p = c6.e().g(new e0(c6, this));
        this.f45565q = c6.e().c(new f0(this, c6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.d j0(g0 g0Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar, a request) {
        kotlin.jvm.internal.g0.p(request, "request");
        kotlin.reflect.jvm.internal.impl.name.b bVar = new kotlin.reflect.jvm.internal.impl.name.b(g0Var.S().d(), request.b());
        v.a b6 = request.a() != null ? kVar.a().j().b(request.a(), g0Var.n0()) : kVar.a().j().a(bVar, g0Var.n0());
        kotlin.reflect.jvm.internal.impl.load.kotlin.x a6 = b6 != null ? b6.a() : null;
        kotlin.reflect.jvm.internal.impl.name.b c6 = a6 != null ? a6.c() : null;
        if (c6 != null && (c6.j() || c6.i())) {
            return null;
        }
        b q02 = g0Var.q0(a6);
        if (q02 instanceof b.a) {
            return ((b.a) q02).a();
        }
        if (q02 instanceof b.c) {
            return null;
        }
        if (!(q02 instanceof b.C0889b)) {
            throw new NoWhenBranchMatchedException();
        }
        y3.g a7 = request.a();
        if (a7 == null) {
            kotlin.reflect.jvm.internal.impl.load.java.t d6 = kVar.a().d();
            v.a.C0900a c0900a = b6 instanceof v.a.C0900a ? (v.a.C0900a) b6 : null;
            a7 = d6.b(new t.a(bVar, c0900a != null ? c0900a.b() : null, null, 4, null));
        }
        y3.g gVar = a7;
        if ((gVar != null ? gVar.w() : null) != LightClassOriginKind.BINARY) {
            kotlin.reflect.jvm.internal.impl.name.c d7 = gVar != null ? gVar.d() : null;
            if (d7 == null || d7.c() || !kotlin.jvm.internal.g0.g(d7.d(), g0Var.S().d())) {
                return null;
            }
            n nVar = new n(kVar, g0Var.S(), gVar, null, 8, null);
            kVar.a().e().a(nVar);
            return nVar;
        }
        throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + gVar + "\nClassId: " + bVar + "\nfindKotlinClass(JavaClass) = " + kotlin.reflect.jvm.internal.impl.load.kotlin.w.b(kVar.a().j(), gVar, g0Var.n0()) + "\nfindKotlinClass(ClassId) = " + kotlin.reflect.jvm.internal.impl.load.kotlin.w.a(kVar.a().j(), bVar, g0Var.n0()) + '\n');
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d k0(kotlin.reflect.jvm.internal.impl.name.f fVar, y3.g gVar) {
        if (!kotlin.reflect.jvm.internal.impl.name.h.f46355a.a(fVar)) {
            return null;
        }
        Set<String> invoke = this.f45564p.invoke();
        if (gVar != null || invoke == null || invoke.contains(fVar.b())) {
            return this.f45565q.invoke(new a(fVar, gVar));
        }
        return null;
    }

    private final b q0(kotlin.reflect.jvm.internal.impl.load.kotlin.x xVar) {
        if (xVar == null) {
            return b.C0889b.f45569a;
        }
        if (xVar.e().c() != KotlinClassHeader.Kind.CLASS) {
            return b.c.f45570a;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d n6 = M().a().b().n(xVar);
        return n6 != null ? new b.a(n6) : b.C0889b.f45569a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    protected c A() {
        return c.a.f45539a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    protected void C(@NotNull Collection<d1> result, @NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(result, "result");
        kotlin.jvm.internal.g0.p(name, "name");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> E(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        return u1.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0, kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        return kotlin.collections.f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0, kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        kotlin.jvm.internal.g0.p(nameFilter, "nameFilter");
        d.a aVar = kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46739c;
        if (!kindFilter.a(aVar.e() | aVar.c())) {
            return kotlin.collections.f0.J();
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> invoke = L().invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : invoke) {
            kotlin.reflect.jvm.internal.impl.descriptors.k kVar = (kotlin.reflect.jvm.internal.impl.descriptors.k) obj;
            if (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                kotlin.reflect.jvm.internal.impl.name.f name = ((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar).getName();
                kotlin.jvm.internal.g0.o(name, "getName(...)");
                if (nameFilter.invoke(name).booleanValue()) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.d l0(@NotNull y3.g javaClass) {
        kotlin.jvm.internal.g0.p(javaClass, "javaClass");
        return k0(javaClass.getName(), javaClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @Nullable
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.d g(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        return k0(name, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public d0 S() {
        return this.f45563o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> w(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        if (!kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46739c.e())) {
            return u1.k();
        }
        Set<String> invoke = this.f45564p.invoke();
        if (invoke != null) {
            HashSet hashSet = new HashSet();
            Iterator<T> it = invoke.iterator();
            while (it.hasNext()) {
                hashSet.add(kotlin.reflect.jvm.internal.impl.name.f.h((String) it.next()));
            }
            return hashSet;
        }
        y3.u uVar = this.f45562n;
        if (function1 == null) {
            function1 = kotlin.reflect.jvm.internal.impl.utils.i.k();
        }
        Collection<y3.g> G = uVar.G(function1);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (y3.g gVar : G) {
            kotlin.reflect.jvm.internal.impl.name.f name = gVar.w() == LightClassOriginKind.SOURCE ? null : gVar.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.t0
    @NotNull
    protected Set<kotlin.reflect.jvm.internal.impl.name.f> y(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @Nullable Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> function1) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        return u1.k();
    }

    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c n0() {
        return M().a().b().f().g().f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set p0(kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar, g0 g0Var) {
        return kVar.a().d().a(g0Var.S().d());
    }
}
