package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.m2;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAbstractTypeAliasDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeAliasDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/AbstractTypeAliasDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,129:1\n1617#2,9:130\n1869#2:139\n1870#2:141\n1626#2:142\n1#3:140\n*S KotlinDebug\n*F\n+ 1 AbstractTypeAliasDescriptor.kt\norg/jetbrains/kotlin/descriptors/impl/AbstractTypeAliasDescriptor\n*L\n69#1:130,9\n69#1:139\n69#1:141\n69#1:142\n69#1:140\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class g extends n implements i1 {

    /* renamed from: j, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f44719j = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(g.class, "constructors", "getConstructors()Ljava/util/Collection;", 0))};

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.n f44720e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.s f44721f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f44722g;

    /* renamed from: h, reason: collision with root package name */
    private List<? extends j1> f44723h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final a f44724i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements w1 {
        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        public boolean d() {
            return true;
        }

        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        public w1 a(kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public i1 c() {
            return g.this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        public List<j1> getParameters() {
            return g.this.M0();
        }

        public String toString() {
            return "[typealias " + c().getName().b() + ']';
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        public Collection<kotlin.reflect.jvm.internal.impl.types.t0> i() {
            Collection<kotlin.reflect.jvm.internal.impl.types.t0> i6 = c().y0().I0().i();
            kotlin.jvm.internal.g0.o(i6, "getSupertypes(...)");
            return i6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        public kotlin.reflect.jvm.internal.impl.builtins.j p() {
            return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(c());
        }
    }

    @NotNull
    protected abstract List<j1> M0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean i0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean q0() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull e1 sourceElement, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s visibilityImpl) {
        super(containingDeclaration, annotations, name, sourceElement);
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(sourceElement, "sourceElement");
        kotlin.jvm.internal.g0.p(visibilityImpl, "visibilityImpl");
        this.f44720e = storageManager;
        this.f44721f = visibilityImpl;
        this.f44722g = storageManager.e(new d(this));
        this.f44724i = new a();
    }

    public final void N0(@NotNull List<? extends j1> declaredTypeParameters) {
        kotlin.jvm.internal.g0.p(declaredTypeParameters, "declaredTypeParameters");
        this.f44723h = declaredTypeParameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R W(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> visitor, D d6) {
        kotlin.jvm.internal.g0.p(visitor, "visitor");
        return visitor.i(this, d6);
    }

    @NotNull
    protected final kotlin.reflect.jvm.internal.impl.storage.n d0() {
        return this.f44720e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0, kotlin.reflect.jvm.internal.impl.descriptors.o
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        return this.f44721f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    @NotNull
    public Modality i() {
        return Modality.FINAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public w1 o() {
        return this.f44724i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<j1> t() {
        List list = this.f44723h;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.g0.S("declaredTypeParametersImpl");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m
    @NotNull
    public String toString() {
        return "typealias " + getName().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.e1 I0(g gVar, kotlin.reflect.jvm.internal.impl.types.checker.g gVar2) {
        kotlin.reflect.jvm.internal.impl.descriptors.f f6 = gVar2.f(gVar);
        if (f6 != null) {
            return f6.s();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection J0(g gVar) {
        return gVar.L0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean O0(g gVar, m2 m2Var) {
        boolean z5;
        kotlin.jvm.internal.g0.m(m2Var);
        if (!kotlin.reflect.jvm.internal.impl.types.x0.a(m2Var)) {
            kotlin.reflect.jvm.internal.impl.descriptors.f c6 = m2Var.I0().c();
            if ((c6 instanceof j1) && !kotlin.jvm.internal.g0.g(((j1) c6).b(), gVar)) {
                z5 = true;
                return Boolean.valueOf(z5);
            }
        }
        z5 = false;
        return Boolean.valueOf(z5);
    }

    @NotNull
    protected final kotlin.reflect.jvm.internal.impl.types.e1 H0() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar;
        kotlin.reflect.jvm.internal.impl.descriptors.d m6 = m();
        if (m6 == null || (kVar = m6.H()) == null) {
            kVar = k.c.f46780b;
        }
        kotlin.reflect.jvm.internal.impl.types.e1 u5 = j2.u(this, kVar, new f(this));
        kotlin.jvm.internal.g0.o(u5, "makeUnsubstitutedType(...)");
        return u5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.n
    @NotNull
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public i1 a() {
        kotlin.reflect.jvm.internal.impl.descriptors.n a6 = super.a();
        kotlin.jvm.internal.g0.n(a6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
        return (i1) a6;
    }

    @NotNull
    public final Collection<q0> L0() {
        kotlin.reflect.jvm.internal.impl.descriptors.d m6 = m();
        if (m6 == null) {
            return kotlin.collections.f0.J();
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> f6 = m6.f();
        kotlin.jvm.internal.g0.o(f6, "getConstructors(...)");
        ArrayList arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.c cVar : f6) {
            s0.a aVar = s0.I;
            kotlin.reflect.jvm.internal.impl.storage.n nVar = this.f44720e;
            kotlin.jvm.internal.g0.m(cVar);
            q0 b6 = aVar.b(nVar, this, cVar);
            if (b6 != null) {
                arrayList.add(b6);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    public boolean k() {
        return j2.c(y0(), new e(this));
    }
}
