package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.d1;
import kotlin.collections.u1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.n1;
import kotlin.reflect.jvm.internal.impl.descriptors.o1;
import kotlin.reflect.jvm.internal.impl.descriptors.v1;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.e2;
import kotlin.reflect.jvm.internal.impl.types.t1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLazyJavaClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaClassDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,322:1\n1761#2,3:323\n1761#2,3:326\n1056#2:334\n1563#2:336\n1634#2,3:337\n1152#3:329\n1321#3:330\n1322#3:332\n1153#3:333\n1#4:331\n1#4:335\n*S KotlinDebug\n*F\n+ 1 LazyJavaClassDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassDescriptor\n*L\n185#1:323,3\n188#1:326,3\n202#1:334\n151#1:336\n151#1:337,3\n200#1:329\n200#1:330\n200#1:332\n200#1:333\n200#1:331\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n extends kotlin.reflect.jvm.internal.impl.descriptors.impl.j implements kotlin.reflect.jvm.internal.impl.load.java.descriptors.c {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.k f45596j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final y3.g f45597k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f45598l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.k f45599m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final kotlin.s f45600n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final ClassKind f45601o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private final Modality f45602p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final v1 f45603q;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f45604r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private final b f45605s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private final z f45606t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private final c1<z> f45607u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.g f45608v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    private final z0 f45609w;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f45610x;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i<List<j1>> f45611y;

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    public static final a f45595z = new a(null);

    @NotNull
    private static final Set<String> A = u1.u("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nLazyJavaClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaClassDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassDescriptor$LazyJavaClassTypeConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,322:1\n1563#2:323\n1634#2,3:324\n1563#2:327\n1634#2,3:328\n1563#2:331\n1634#2,3:332\n*S KotlinDebug\n*F\n+ 1 LazyJavaClassDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassDescriptor$LazyJavaClassTypeConstructor\n*L\n254#1:323\n254#1:324,3\n280#1:327\n280#1:328,3\n285#1:331\n285#1:332,3\n*E\n"})
    final class b extends kotlin.reflect.jvm.internal.impl.types.b {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.storage.i<List<j1>> f45612d;

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        public boolean d() {
            return true;
        }

        public b() {
            super(n.this.f45599m.e());
            this.f45612d = n.this.f45599m.e().e(new o(n.this));
        }

        private final kotlin.reflect.jvm.internal.impl.name.c L() {
            String a6;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations = n.this.getAnnotations();
            kotlin.reflect.jvm.internal.impl.name.c PURELY_IMPLEMENTS_ANNOTATION = kotlin.reflect.jvm.internal.impl.load.java.i0.f45463r;
            kotlin.jvm.internal.g0.o(PURELY_IMPLEMENTS_ANNOTATION, "PURELY_IMPLEMENTS_ANNOTATION");
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c b6 = annotations.b(PURELY_IMPLEMENTS_ANNOTATION);
            if (b6 == null) {
                return null;
            }
            Object n52 = kotlin.collections.f0.n5(b6.a().values());
            kotlin.reflect.jvm.internal.impl.resolve.constants.y yVar = n52 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.y ? (kotlin.reflect.jvm.internal.impl.resolve.constants.y) n52 : null;
            if (yVar == null || (a6 = yVar.a()) == null || !kotlin.reflect.jvm.internal.impl.name.e.e(a6)) {
                return null;
            }
            return new kotlin.reflect.jvm.internal.impl.name.c(a6);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.b, kotlin.reflect.jvm.internal.impl.types.w, kotlin.reflect.jvm.internal.impl.types.w1
        @NotNull
        /* renamed from: I */
        public kotlin.reflect.jvm.internal.impl.descriptors.d c() {
            return n.this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        @NotNull
        public List<j1> getParameters() {
            return this.f45612d.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q
        @NotNull
        protected Collection<kotlin.reflect.jvm.internal.impl.types.t0> r() {
            Collection<y3.j> i6 = n.this.N0().i();
            ArrayList arrayList = new ArrayList(i6.size());
            ArrayList<y3.x> arrayList2 = new ArrayList(0);
            kotlin.reflect.jvm.internal.impl.types.t0 K = K();
            Iterator<y3.j> it = i6.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                y3.j next = it.next();
                kotlin.reflect.jvm.internal.impl.types.t0 q5 = n.this.f45599m.a().r().q(n.this.f45599m.g().p(next, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(TypeUsage.SUPERTYPE, false, false, null, 7, null)), n.this.f45599m);
                if (q5.I0().c() instanceof k0.b) {
                    arrayList2.add(next);
                }
                if (!kotlin.jvm.internal.g0.g(q5.I0(), K != null ? K.I0() : null) && !kotlin.reflect.jvm.internal.impl.builtins.j.c0(q5)) {
                    arrayList.add(q5);
                }
            }
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = n.this.f45598l;
            kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, dVar != null ? kotlin.reflect.jvm.internal.impl.builtins.jvm.x.a(dVar, n.this).c().p(dVar.s(), Variance.INVARIANT) : null);
            kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, K);
            if (!arrayList2.isEmpty()) {
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.v c6 = n.this.f45599m.a().c();
                kotlin.reflect.jvm.internal.impl.descriptors.d c7 = c();
                ArrayList arrayList3 = new ArrayList(kotlin.collections.f0.d0(arrayList2, 10));
                for (y3.x xVar : arrayList2) {
                    kotlin.jvm.internal.g0.n(xVar, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    arrayList3.add(((y3.j) xVar).t());
                }
                c6.b(c7, arrayList3);
            }
            return !arrayList.isEmpty() ? kotlin.collections.f0.a6(arrayList) : kotlin.collections.f0.l(n.this.f45599m.d().p().i());
        }

        @NotNull
        public String toString() {
            String b6 = n.this.getName().b();
            kotlin.jvm.internal.g0.o(b6, "asString(...)");
            return b6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q
        @NotNull
        protected h1 v() {
            return n.this.f45599m.a().v();
        }

        private final kotlin.reflect.jvm.internal.impl.types.t0 K() {
            kotlin.reflect.jvm.internal.impl.name.c cVar;
            ArrayList arrayList;
            kotlin.reflect.jvm.internal.impl.name.c L = L();
            if (L == null || L.c() || !L.h(kotlin.reflect.jvm.internal.impl.builtins.o.A)) {
                L = null;
            }
            if (L == null) {
                cVar = kotlin.reflect.jvm.internal.impl.load.java.q.f45732a.b(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o(n.this));
                if (cVar == null) {
                    return null;
                }
            } else {
                cVar = L;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.d B = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.B(n.this.f45599m.d(), cVar, NoLookupLocation.FROM_JAVA_LOADER);
            if (B == null) {
                return null;
            }
            int size = B.o().getParameters().size();
            List<j1> parameters = n.this.o().getParameters();
            kotlin.jvm.internal.g0.o(parameters, "getParameters(...)");
            int size2 = parameters.size();
            if (size2 == size) {
                List<j1> list = parameters;
                arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new e2(Variance.INVARIANT, ((j1) it.next()).s()));
                }
            } else {
                if (size2 != 1 || size <= 1 || L != null) {
                    return null;
                }
                e2 e2Var = new e2(Variance.INVARIANT, ((j1) kotlin.collections.f0.m5(parameters)).s());
                kotlin.ranges.m mVar = new kotlin.ranges.m(1, size);
                ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(mVar, 10));
                Iterator<Integer> it2 = mVar.iterator();
                while (it2.hasNext()) {
                    ((d1) it2).nextInt();
                    arrayList2.add(e2Var);
                }
                arrayList = arrayList2;
            }
            return kotlin.reflect.jvm.internal.impl.types.w0.h(t1.f47332b.k(), B, arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List M(n nVar) {
            return n1.g(nVar);
        }
    }

    public /* synthetic */ n(kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2, y3.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar, int i6, kotlin.jvm.internal.v vVar) {
        this(kVar, kVar2, gVar, (i6 & 8) != 0 ? null : dVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public o1<e1> g0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean i0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean l0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean q0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d s0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean u() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean v() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean w() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.c z() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k outerContext, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration, @NotNull y3.g jClass, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        super(outerContext.e(), containingDeclaration, jClass.getName(), outerContext.a().t().a(jClass), false);
        Modality modality;
        kotlin.jvm.internal.g0.p(outerContext, "outerContext");
        kotlin.jvm.internal.g0.p(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.g0.p(jClass, "jClass");
        this.f45596j = outerContext;
        this.f45597k = jClass;
        this.f45598l = dVar;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.k f6 = kotlin.reflect.jvm.internal.impl.load.java.lazy.c.f(outerContext, this, jClass, 0, 4, null);
        this.f45599m = f6;
        f6.a().h().c(jClass, this);
        jClass.w();
        this.f45600n = kotlin.t.c(new k(this));
        this.f45601o = jClass.k() ? ClassKind.ANNOTATION_CLASS : jClass.I() ? ClassKind.INTERFACE : jClass.E() ? ClassKind.ENUM_CLASS : ClassKind.CLASS;
        if (jClass.k() || jClass.E()) {
            modality = Modality.FINAL;
        } else {
            modality = Modality.Companion.a(jClass.m(), jClass.m() || jClass.isAbstract() || jClass.I(), !jClass.isFinal());
        }
        this.f45602p = modality;
        this.f45603q = jClass.getVisibility();
        this.f45604r = (jClass.h() == null || jClass.L()) ? false : true;
        this.f45605s = new b();
        z zVar = new z(f6, this, jClass, dVar != null, null, 16, null);
        this.f45606t = zVar;
        this.f45607u = c1.f44676e.a(this, f6.e(), f6.a().k().c(), new l(this));
        this.f45608v = new kotlin.reflect.jvm.internal.impl.resolve.scopes.g(zVar);
        this.f45609w = new z0(f6, jClass, this);
        this.f45610x = kotlin.reflect.jvm.internal.impl.load.java.lazy.h.a(f6, jClass);
        this.f45611y = f6.e().e(new m(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List L0(n nVar) {
        List<y3.y> typeParameters = nVar.f45597k.getTypeParameters();
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(typeParameters, 10));
        for (y3.y yVar : typeParameters) {
            j1 a6 = nVar.f45599m.f().a(yVar);
            if (a6 == null) {
                throw new AssertionError("Parameter " + yVar + " surely belongs to class " + nVar.f45597k + ", so it must be resolved");
            }
            arrayList.add(a6);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z S0(n nVar, kotlin.reflect.jvm.internal.impl.types.checker.g it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return new z(nVar.f45599m, nVar, nVar.f45597k, nVar.f45598l != null, nVar.f45606t);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k G() {
        return this.f45608v;
    }

    @NotNull
    public final n K0(@NotNull kotlin.reflect.jvm.internal.impl.load.java.components.j javaResolverCache, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.jvm.internal.g0.p(javaResolverCache, "javaResolverCache");
        kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar = this.f45599m;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.k m6 = kotlin.reflect.jvm.internal.impl.load.java.lazy.c.m(kVar, kVar.a().x(javaResolverCache));
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = b();
        kotlin.jvm.internal.g0.o(b6, "getContainingDeclaration(...)");
        return new n(m6, b6, this.f45597k, dVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.c> f() {
        return this.f45606t.b1().invoke();
    }

    @NotNull
    public final y3.g N0() {
        return this.f45597k;
    }

    @Nullable
    public final List<y3.a> O0() {
        return (List) this.f45600n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z
    @NotNull
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public z o0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f45607u.c(kotlinTypeRefiner);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        return this.f45610x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.c0, kotlin.reflect.jvm.internal.impl.descriptors.o
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        if (!kotlin.jvm.internal.g0.g(this.f45603q, kotlin.reflect.jvm.internal.impl.descriptors.r.f44944a) || this.f45597k.h() != null) {
            return kotlin.reflect.jvm.internal.impl.load.java.s0.d(this.f45603q);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = kotlin.reflect.jvm.internal.impl.load.java.x.f45855a;
        kotlin.jvm.internal.g0.m(sVar);
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public ClassKind h() {
        return this.f45601o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.c0
    @NotNull
    public Modality i() {
        return this.f45602p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    public boolean k() {
        return this.f45604r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public w1 o() {
        return this.f45605s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k r0() {
        return this.f45609w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<j1> t() {
        return this.f45611y.invoke();
    }

    @NotNull
    public String toString() {
        return "Lazy Java class " + kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.p(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List R0(n nVar) {
        kotlin.reflect.jvm.internal.impl.name.b n6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.n(nVar);
        if (n6 != null) {
            return nVar.f45596j.a().f().a(n6);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public z H() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k H = super.H();
        kotlin.jvm.internal.g0.n(H, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
        return (z) H;
    }
}
