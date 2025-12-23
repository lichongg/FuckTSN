package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.n f44928a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final f0 f44929b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.c, l0> f44930c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.g<a, d> f44931d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.name.b f44932a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final List<Integer> f44933b;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.g0.g(this.f44932a, aVar.f44932a) && kotlin.jvm.internal.g0.g(this.f44933b, aVar.f44933b);
        }

        public a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @NotNull List<Integer> typeParametersCount) {
            kotlin.jvm.internal.g0.p(classId, "classId");
            kotlin.jvm.internal.g0.p(typeParametersCount, "typeParametersCount");
            this.f44932a = classId;
            this.f44933b = typeParametersCount;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b a() {
            return this.f44932a;
        }

        @NotNull
        public final List<Integer> b() {
            return this.f44933b;
        }

        public int hashCode() {
            return (this.f44932a.hashCode() * 31) + this.f44933b.hashCode();
        }

        @NotNull
        public String toString() {
            return "ClassRequest(classId=" + this.f44932a + ", typeParametersCount=" + this.f44933b + ')';
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nNotFoundClasses.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotFoundClasses.kt\norg/jetbrains/kotlin/descriptors/NotFoundClasses$MockClassDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n1563#2:101\n1634#2,3:102\n*S KotlinDebug\n*F\n+ 1 NotFoundClasses.kt\norg/jetbrains/kotlin/descriptors/NotFoundClasses$MockClassDescriptor\n*L\n55#1:101\n55#1:102,3\n*E\n"})
    public static final class b extends kotlin.reflect.jvm.internal.impl.descriptors.impl.j {

        /* renamed from: j, reason: collision with root package name */
        private final boolean f44934j;

        /* renamed from: k, reason: collision with root package name */
        @NotNull
        private final List<j1> f44935k;

        /* renamed from: l, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.types.v f44936l;

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        @Nullable
        public o1<kotlin.reflect.jvm.internal.impl.types.e1> g0() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
        public boolean i0() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.j, kotlin.reflect.jvm.internal.impl.descriptors.c0
        public boolean isExternal() {
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
        public d s0() {
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
        public c z() {
            return null;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull k container, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, boolean z5, int i6) {
            super(storageManager, container, name, e1.f44683a, false);
            kotlin.jvm.internal.g0.p(storageManager, "storageManager");
            kotlin.jvm.internal.g0.p(container, "container");
            kotlin.jvm.internal.g0.p(name, "name");
            this.f44934j = z5;
            kotlin.ranges.m W1 = kotlin.ranges.t.W1(0, i6);
            ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(W1, 10));
            Iterator<Integer> it = W1.iterator();
            while (it.hasNext()) {
                int nextInt = ((kotlin.collections.d1) it).nextInt();
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b6 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b();
                Variance variance = Variance.INVARIANT;
                StringBuilder sb = new StringBuilder();
                sb.append('T');
                sb.append(nextInt);
                arrayList.add(kotlin.reflect.jvm.internal.impl.descriptors.impl.t0.M0(this, b6, false, variance, kotlin.reflect.jvm.internal.impl.name.f.h(sb.toString()), nextInt, storageManager));
            }
            this.f44935k = arrayList;
            this.f44936l = new kotlin.reflect.jvm.internal.impl.types.v(this, n1.g(this), kotlin.collections.u1.f(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.s(this).p().i()), storageManager);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        @NotNull
        /* renamed from: F0, reason: merged with bridge method [inline-methods] */
        public k.c r0() {
            return k.c.f46780b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
        @NotNull
        /* renamed from: G0, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.types.v o() {
            return this.f44936l;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z
        @NotNull
        /* renamed from: H0, reason: merged with bridge method [inline-methods] */
        public k.c o0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            return k.c.f46780b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
        @NotNull
        public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
            return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.c0, kotlin.reflect.jvm.internal.impl.descriptors.o
        @NotNull
        public s getVisibility() {
            s PUBLIC = r.f44948e;
            kotlin.jvm.internal.g0.o(PUBLIC, "PUBLIC");
            return PUBLIC;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        @NotNull
        public ClassKind h() {
            return ClassKind.CLASS;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.c0
        @NotNull
        public Modality i() {
            return Modality.FINAL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
        public boolean k() {
            return this.f44934j;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
        @NotNull
        public List<j1> t() {
            return this.f44935k;
        }

        @NotNull
        public String toString() {
            return "class " + getName() + " (not found)";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
        @NotNull
        public Collection<c> f() {
            return kotlin.collections.u1.k();
        }
    }

    public k0(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull f0 module) {
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(module, "module");
        this.f44928a = storageManager;
        this.f44929b = module;
        this.f44930c = storageManager.i(new i0(this));
        this.f44931d = storageManager.i(new j0(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d c(k0 k0Var, a aVar) {
        l0 invoke;
        kotlin.jvm.internal.g0.p(aVar, "<destruct>");
        kotlin.reflect.jvm.internal.impl.name.b a6 = aVar.a();
        List<Integer> b6 = aVar.b();
        if (a6.i()) {
            throw new UnsupportedOperationException("Unresolved local class: " + a6);
        }
        kotlin.reflect.jvm.internal.impl.name.b e6 = a6.e();
        if (e6 == null || (invoke = k0Var.d(e6, kotlin.collections.f0.g2(b6, 1))) == null) {
            invoke = k0Var.f44930c.invoke(a6.f());
        }
        k kVar = invoke;
        boolean j6 = a6.j();
        kotlin.reflect.jvm.internal.impl.storage.n nVar = k0Var.f44928a;
        kotlin.reflect.jvm.internal.impl.name.f h6 = a6.h();
        Integer num = (Integer) kotlin.collections.f0.L2(b6);
        return new b(nVar, kVar, h6, j6, num != null ? num.intValue() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l0 e(k0 k0Var, kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        return new kotlin.reflect.jvm.internal.impl.descriptors.impl.p(k0Var.f44929b, fqName);
    }

    @NotNull
    public final d d(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @NotNull List<Integer> typeParametersCount) {
        kotlin.jvm.internal.g0.p(classId, "classId");
        kotlin.jvm.internal.g0.p(typeParametersCount, "typeParametersCount");
        return this.f44931d.invoke(new a(classId, typeParametersCount));
    }
}
