package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.u1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJvmPackageScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmPackageScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/JvmPackageScope\n+ 2 scopeUtils.kt\norg/jetbrains/kotlin/util/collectionUtils/ScopeUtilsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,109:1\n92#2,14:110\n60#2,5:124\n60#2,5:129\n60#2,5:134\n10557#3,5:139\n10557#3,5:144\n1617#4,9:149\n1869#4:158\n1870#4:160\n1626#4:161\n1#5:159\n37#6:162\n36#6,3:163\n*S KotlinDebug\n*F\n+ 1 JvmPackageScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/JvmPackageScope\n*L\n58#1:110,14\n63#1:124,5\n68#1:129,5\n74#1:134,5\n76#1:139,5\n80#1:144,5\n46#1:149,9\n46#1:158\n46#1:160\n46#1:161\n46#1:159\n49#1:162\n49#1:163,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f implements kotlin.reflect.jvm.internal.impl.resolve.scopes.k {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f45554f = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(f.class, "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0))};

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.k f45555b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final d0 f45556c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final g0 f45557d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f45558e;

    public f(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6, @NotNull y3.u jPackage, @NotNull d0 packageFragment) {
        kotlin.jvm.internal.g0.p(c6, "c");
        kotlin.jvm.internal.g0.p(jPackage, "jPackage");
        kotlin.jvm.internal.g0.p(packageFragment, "packageFragment");
        this.f45555b = c6;
        this.f45556c = packageFragment;
        this.f45557d = new g0(c6, jPackage, packageFragment);
        this.f45558e = c6.e().e(new e(this));
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.k[] k() {
        return (kotlin.reflect.jvm.internal.impl.resolve.scopes.k[]) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f45558e, this, f45554f[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.k[] l(f fVar) {
        Collection<kotlin.reflect.jvm.internal.impl.load.kotlin.x> values = fVar.f45556c.J0().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.k c6 = fVar.f45555b.a().b().c(fVar.f45556c, (kotlin.reflect.jvm.internal.impl.load.kotlin.x) it.next());
            if (c6 != null) {
                arrayList.add(c6);
            }
        }
        return (kotlin.reflect.jvm.internal.impl.resolve.scopes.k[]) g4.a.b(arrayList).toArray(new kotlin.reflect.jvm.internal.impl.resolve.scopes.k[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        e(name, location);
        g0 g0Var = this.f45557d;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k[] k6 = k();
        Collection<? extends d1> a6 = g0Var.a(name, location);
        int length = k6.length;
        int i6 = 0;
        Collection collection = a6;
        while (i6 < length) {
            Collection a7 = g4.a.a(collection, k6[i6].a(name, location));
            i6++;
            collection = a7;
        }
        return collection == null ? u1.k() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        e(name, location);
        g0 g0Var = this.f45557d;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k[] k6 = k();
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> c6 = g0Var.c(name, location);
        int length = k6.length;
        int i6 = 0;
        Collection collection = c6;
        while (i6 < length) {
            Collection a6 = g4.a.a(collection, k6[i6].c(name, location));
            i6++;
            collection = a6;
        }
        return collection == null ? u1.k() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        t3.a.b(this.f45555b.a().l(), location, this.f45556c, name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f g(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(location, "location");
        e(name, location);
        kotlin.reflect.jvm.internal.impl.descriptors.d g6 = this.f45557d.g(name, location);
        if (g6 != null) {
            return g6;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar = null;
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar : k()) {
            kotlin.reflect.jvm.internal.impl.descriptors.f g7 = kVar.g(name, location);
            if (g7 != null) {
                if (!(g7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) || !((kotlin.reflect.jvm.internal.impl.descriptors.c0) g7).q0()) {
                    return g7;
                }
                if (fVar == null) {
                    fVar = g7;
                }
            }
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        kotlin.jvm.internal.g0.p(kindFilter, "kindFilter");
        kotlin.jvm.internal.g0.p(nameFilter, "nameFilter");
        g0 g0Var = this.f45557d;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k[] k6 = k();
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h6 = g0Var.h(kindFilter, nameFilter);
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar : k6) {
            h6 = g4.a.a(h6, kVar.h(kindFilter, nameFilter));
        }
        return h6 == null ? u1.k() : h6;
    }

    @NotNull
    public final g0 j() {
        return this.f45557d;
    }

    @NotNull
    public String toString() {
        return "scope for " + this.f45556c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k[] k6 = k();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar : k6) {
            kotlin.collections.f0.s0(linkedHashSet, kVar.b());
        }
        linkedHashSet.addAll(this.f45557d.b());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k[] k6 = k();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar : k6) {
            kotlin.collections.f0.s0(linkedHashSet, kVar.d());
        }
        linkedHashSet.addAll(this.f45557d.d());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public Set<kotlin.reflect.jvm.internal.impl.name.f> f() {
        Set<kotlin.reflect.jvm.internal.impl.name.f> a6 = kotlin.reflect.jvm.internal.impl.resolve.scopes.m.a(kotlin.collections.n.K5(k()));
        if (a6 != null) {
            a6.addAll(this.f45557d.f());
            return a6;
        }
        return null;
    }
}
