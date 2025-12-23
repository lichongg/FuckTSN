package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAbstractTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeConstructor.kt\norg/jetbrains/kotlin/types/AbstractTypeConstructor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class q extends w {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i<b> f47316b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f47317c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements w1 {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.types.checker.g f47318a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final kotlin.s f47319b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ q f47320c;

        public a(@NotNull q qVar, kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.f47320c = qVar;
            this.f47318a = kotlinTypeRefiner;
            this.f47319b = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new p(this, qVar));
        }

        private final List<t0> f() {
            return (List) this.f47319b.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List h(a aVar, q qVar) {
            return kotlin.reflect.jvm.internal.impl.types.checker.h.b(aVar.f47318a, qVar.i());
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        @NotNull
        public w1 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.f47320c.a(kotlinTypeRefiner);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        @NotNull
        public kotlin.reflect.jvm.internal.impl.descriptors.f c() {
            return this.f47320c.c();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        public boolean d() {
            return this.f47320c.d();
        }

        public boolean equals(@Nullable Object obj) {
            return this.f47320c.equals(obj);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        @NotNull
        public List<kotlin.reflect.jvm.internal.impl.descriptors.j1> getParameters() {
            List<kotlin.reflect.jvm.internal.impl.descriptors.j1> parameters = this.f47320c.getParameters();
            kotlin.jvm.internal.g0.o(parameters, "getParameters(...)");
            return parameters;
        }

        public int hashCode() {
            return this.f47320c.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.j p() {
            kotlin.reflect.jvm.internal.impl.builtins.j p5 = this.f47320c.p();
            kotlin.jvm.internal.g0.o(p5, "getBuiltIns(...)");
            return p5;
        }

        @NotNull
        public String toString() {
            return this.f47320c.toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        @NotNull
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public List<t0> i() {
            return f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Collection<t0> f47321a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private List<? extends t0> f47322b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull Collection<? extends t0> allSupertypes) {
            kotlin.jvm.internal.g0.p(allSupertypes, "allSupertypes");
            this.f47321a = allSupertypes;
            this.f47322b = kotlin.collections.f0.l(kotlin.reflect.jvm.internal.impl.types.error.i.f47232a.l());
        }

        @NotNull
        public final Collection<t0> a() {
            return this.f47321a;
        }

        @NotNull
        public final List<t0> b() {
            return this.f47322b;
        }

        public final void c(@NotNull List<? extends t0> list) {
            kotlin.jvm.internal.g0.p(list, "<set-?>");
            this.f47322b = list;
        }
    }

    @NotNull
    protected abstract Collection<t0> r();

    @Nullable
    protected t0 s() {
        return null;
    }

    @NotNull
    protected abstract kotlin.reflect.jvm.internal.impl.descriptors.h1 v();

    public q(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager) {
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        this.f47316b = storageManager.b(new i(this), j.f47275a, new k(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b A(q qVar) {
        return new b(qVar.r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b B(boolean z5) {
        return new b(kotlin.collections.f0.l(kotlin.reflect.jvm.internal.impl.types.error.i.f47232a.l()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 C(q qVar, b supertypes) {
        kotlin.jvm.internal.g0.p(supertypes, "supertypes");
        List a6 = qVar.v().a(qVar, supertypes.a(), new l(qVar), new m(qVar));
        if (a6.isEmpty()) {
            t0 s5 = qVar.s();
            List l6 = s5 != null ? kotlin.collections.f0.l(s5) : null;
            if (l6 == null) {
                l6 = kotlin.collections.f0.J();
            }
            a6 = l6;
        }
        if (qVar.u()) {
            qVar.v().a(qVar, a6, new n(qVar), new o(qVar));
        }
        List<t0> list = a6 instanceof List ? (List) a6 : null;
        if (list == null) {
            list = kotlin.collections.f0.a6(a6);
        }
        supertypes.c(qVar.x(list));
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable D(q qVar, w1 it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return qVar.q(it, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 E(q qVar, t0 it) {
        kotlin.jvm.internal.g0.p(it, "it");
        qVar.z(it);
        return kotlin.n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable F(q qVar, w1 it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return qVar.q(it, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.n1 G(q qVar, t0 it) {
        kotlin.jvm.internal.g0.p(it, "it");
        qVar.y(it);
        return kotlin.n1.f44123a;
    }

    private final Collection<t0> q(w1 w1Var, boolean z5) {
        List I4;
        q qVar = w1Var instanceof q ? (q) w1Var : null;
        if (qVar != null && (I4 = kotlin.collections.f0.I4(qVar.f47316b.invoke().a(), qVar.t(z5))) != null) {
            return I4;
        }
        Collection<t0> i6 = w1Var.i();
        kotlin.jvm.internal.g0.o(i6, "getSupertypes(...)");
        return i6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public w1 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new a(this, kotlinTypeRefiner);
    }

    protected boolean u() {
        return this.f47317c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public List<t0> i() {
        return this.f47316b.invoke().b();
    }

    @NotNull
    protected List<t0> x(@NotNull List<t0> supertypes) {
        kotlin.jvm.internal.g0.p(supertypes, "supertypes");
        return supertypes;
    }

    protected void y(@NotNull t0 type) {
        kotlin.jvm.internal.g0.p(type, "type");
    }

    protected void z(@NotNull t0 type) {
        kotlin.jvm.internal.g0.p(type, "type");
    }

    @NotNull
    protected Collection<t0> t(boolean z5) {
        return kotlin.collections.f0.J();
    }
}
