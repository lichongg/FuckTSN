package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.n;
import kotlin.reflect.jvm.internal.impl.types.f2;
import kotlin.reflect.jvm.internal.impl.types.h2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSubstitutingScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubstitutingScope.kt\norg/jetbrains/kotlin/resolve/scopes/SubstitutingScope\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 coreLib.kt\norg/jetbrains/kotlin/utils/CoreLibKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n382#2,3:112\n385#2,4:116\n19#3:115\n1#4:120\n*S KotlinDebug\n*F\n+ 1 SubstitutingScope.kt\norg/jetbrains/kotlin/resolve/scopes/SubstitutingScope\n*L\n52#1:112,3\n52#1:116,4\n54#1:115\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t implements k {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final k f46800b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.s f46801c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final h2 f46802d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private Map<kotlin.reflect.jvm.internal.impl.descriptors.k, kotlin.reflect.jvm.internal.impl.descriptors.k> f46803e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final kotlin.s f46804f;

    public t(@NotNull k workerScope, @NotNull h2 givenSubstitutor) {
        g0.p(workerScope, "workerScope");
        g0.p(givenSubstitutor, "givenSubstitutor");
        this.f46800b = workerScope;
        this.f46801c = kotlin.t.c(new r(givenSubstitutor));
        f2 j6 = givenSubstitutor.j();
        g0.o(j6, "getSubstitution(...)");
        this.f46802d = kotlin.reflect.jvm.internal.impl.resolve.calls.inference.e.h(j6, false, 1, null).c();
        this.f46804f = kotlin.t.c(new s(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection i(t tVar) {
        return tVar.m(n.a.a(tVar.f46800b, null, null, 3, null));
    }

    private final Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> l() {
        return (Collection) this.f46804f.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.k> Collection<D> m(Collection<? extends D> collection) {
        if (this.f46802d.k()) {
            return collection;
        }
        if (collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet g6 = kotlin.reflect.jvm.internal.impl.utils.a.g(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            g6.add(n((kotlin.reflect.jvm.internal.impl.descriptors.k) it.next()));
        }
        return g6;
    }

    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.k> D n(D d6) {
        if (this.f46802d.k()) {
            return d6;
        }
        if (this.f46803e == null) {
            this.f46803e = new HashMap();
        }
        Map<kotlin.reflect.jvm.internal.impl.descriptors.k, kotlin.reflect.jvm.internal.impl.descriptors.k> map = this.f46803e;
        g0.m(map);
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar = map.get(d6);
        if (kVar == null) {
            if (!(d6 instanceof g1)) {
                throw new IllegalStateException(("Unknown descriptor in scope: " + d6).toString());
            }
            kVar = ((g1) d6).c(this.f46802d);
            if (kVar == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d6 + " substitution fails");
            }
            map.put(d6, kVar);
        }
        D d7 = (D) kVar;
        g0.n(d7, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return d7;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<? extends d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        return m(this.f46800b.a(name, location));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        return this.f46800b.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<? extends w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        return m(this.f46800b.c(name, location));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        return this.f46800b.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public Set<kotlin.reflect.jvm.internal.impl.name.f> f() {
        return this.f46800b.f();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f g(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        kotlin.reflect.jvm.internal.impl.descriptors.f g6 = this.f46800b.g(name, location);
        if (g6 != null) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.f) n(g6);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h(@NotNull d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        g0.p(kindFilter, "kindFilter");
        g0.p(nameFilter, "nameFilter");
        return l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h2 o(h2 h2Var) {
        return h2Var.j().c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull u3.b bVar) {
        k.b.a(this, fVar, bVar);
    }
}
