package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nChainedMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChainedMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/ChainedMemberScope\n+ 2 scopeUtils.kt\norg/jetbrains/kotlin/util/collectionUtils/ScopeUtilsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,91:1\n92#2,14:92\n47#2,11:106\n47#2,11:117\n47#2,11:128\n10557#3,5:139\n10557#3,5:144\n13472#3,2:149\n*S KotlinDebug\n*F\n+ 1 ChainedMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/ChainedMemberScope\n*L\n35#1:92,14\n38#1:106,11\n41#1:117,11\n44#1:128,11\n46#1:139,5\n47#1:144,5\n51#1:149,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b implements k {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f46733d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f46734b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final k[] f46735c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nChainedMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChainedMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/ChainedMemberScope$Companion\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,91:1\n37#2:92\n36#2,3:93\n*S KotlinDebug\n*F\n+ 1 ChainedMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/ChainedMemberScope$Companion\n*L\n87#1:92\n87#1:93,3\n*E\n"})
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final k a(@NotNull String debugName, @NotNull Iterable<? extends k> scopes) {
            g0.p(debugName, "debugName");
            g0.p(scopes, "scopes");
            kotlin.reflect.jvm.internal.impl.utils.j jVar = new kotlin.reflect.jvm.internal.impl.utils.j();
            for (k kVar : scopes) {
                if (kVar != k.c.f46780b) {
                    if (kVar instanceof b) {
                        f0.u0(jVar, ((b) kVar).f46735c);
                    } else {
                        jVar.add(kVar);
                    }
                }
            }
            return b(debugName, jVar);
        }

        @NotNull
        public final k b(@NotNull String debugName, @NotNull List<? extends k> scopes) {
            g0.p(debugName, "debugName");
            g0.p(scopes, "scopes");
            int size = scopes.size();
            return size != 0 ? size != 1 ? new b(debugName, (k[]) scopes.toArray(new k[0]), null) : scopes.get(0) : k.c.f46780b;
        }
    }

    public /* synthetic */ b(String str, k[] kVarArr, kotlin.jvm.internal.v vVar) {
        this(str, kVarArr);
    }

    private b(String str, k[] kVarArr) {
        this.f46734b = str;
        this.f46735c = kVarArr;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        k[] kVarArr = this.f46735c;
        int length = kVarArr.length;
        if (length == 0) {
            return f0.J();
        }
        if (length == 1) {
            return kVarArr[0].a(name, location);
        }
        Collection<d1> collection = null;
        for (k kVar : kVarArr) {
            collection = g4.a.a(collection, kVar.a(name, location));
        }
        return collection == null ? u1.k() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        k[] kVarArr = this.f46735c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (k kVar : kVarArr) {
            f0.s0(linkedHashSet, kVar.b());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        k[] kVarArr = this.f46735c;
        int length = kVarArr.length;
        if (length == 0) {
            return f0.J();
        }
        if (length == 1) {
            return kVarArr[0].c(name, location);
        }
        Collection<w0> collection = null;
        for (k kVar : kVarArr) {
            collection = g4.a.a(collection, kVar.c(name, location));
        }
        return collection == null ? u1.k() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        k[] kVarArr = this.f46735c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (k kVar : kVarArr) {
            f0.s0(linkedHashSet, kVar.d());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        for (k kVar : this.f46735c) {
            kVar.e(name, location);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public Set<kotlin.reflect.jvm.internal.impl.name.f> f() {
        return m.a(kotlin.collections.n.K5(this.f46735c));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f g(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        g0.p(name, "name");
        g0.p(location, "location");
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar = null;
        for (k kVar : this.f46735c) {
            kotlin.reflect.jvm.internal.impl.descriptors.f g6 = kVar.g(name, location);
            if (g6 != null) {
                if (!(g6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) || !((c0) g6).q0()) {
                    return g6;
                }
                if (fVar == null) {
                    fVar = g6;
                }
            }
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h(@NotNull d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        g0.p(kindFilter, "kindFilter");
        g0.p(nameFilter, "nameFilter");
        k[] kVarArr = this.f46735c;
        int length = kVarArr.length;
        if (length == 0) {
            return f0.J();
        }
        if (length == 1) {
            return kVarArr[0].h(kindFilter, nameFilter);
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> collection = null;
        for (k kVar : kVarArr) {
            collection = g4.a.a(collection, kVar.h(kindFilter, nameFilter));
        }
        return collection == null ? u1.k() : collection;
    }

    @NotNull
    public String toString() {
        return this.f46734b;
    }
}
