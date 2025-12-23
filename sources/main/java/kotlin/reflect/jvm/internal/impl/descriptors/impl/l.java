package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCompositePackageFragmentProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompositePackageFragmentProvider.kt\norg/jetbrains/kotlin/descriptors/impl/CompositePackageFragmentProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n1740#2,3:64\n*S KotlinDebug\n*F\n+ 1 CompositePackageFragmentProvider.kt\norg/jetbrains/kotlin/descriptors/impl/CompositePackageFragmentProvider\n*L\n51#1:64,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l implements kotlin.reflect.jvm.internal.impl.descriptors.r0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<kotlin.reflect.jvm.internal.impl.descriptors.m0> f44803a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f44804b;

    /* JADX WARN: Multi-variable type inference failed */
    public l(@NotNull List<? extends kotlin.reflect.jvm.internal.impl.descriptors.m0> providers, @NotNull String debugName) {
        kotlin.jvm.internal.g0.p(providers, "providers");
        kotlin.jvm.internal.g0.p(debugName, "debugName");
        this.f44803a = providers;
        this.f44804b = debugName;
        providers.size();
        kotlin.collections.f0.f6(providers).size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.l0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.m0> it = this.f44803a.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.q0.a(it.next(), fqName, arrayList);
        }
        return kotlin.collections.f0.a6(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r0
    public void b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.l0> packageFragments) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        kotlin.jvm.internal.g0.p(packageFragments, "packageFragments");
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.m0> it = this.f44803a.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.q0.a(it.next(), fqName, packageFragments);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r0
    public boolean c(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        List<kotlin.reflect.jvm.internal.impl.descriptors.m0> list = this.f44803a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!kotlin.reflect.jvm.internal.impl.descriptors.q0.b((kotlin.reflect.jvm.internal.impl.descriptors.m0) it.next(), fqName)) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.name.c> q(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        kotlin.jvm.internal.g0.p(nameFilter, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.m0> it = this.f44803a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().q(fqName, nameFilter));
        }
        return hashSet;
    }

    @NotNull
    public String toString() {
        return this.f44804b;
    }
}
