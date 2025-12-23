package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nPackageFragmentProviderImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PackageFragmentProviderImpl.kt\norg/jetbrains/kotlin/descriptors/PackageFragmentProviderImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,42:1\n865#2,2:43\n2746#2,3:45\n774#2:48\n865#2,2:49\n*S KotlinDebug\n*F\n+ 1 PackageFragmentProviderImpl.kt\norg/jetbrains/kotlin/descriptors/PackageFragmentProviderImpl\n*L\n26#1:43,2\n30#1:45,3\n34#1:48\n34#1:49,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p0 implements r0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Collection<l0> f44943a;

    /* JADX WARN: Multi-variable type inference failed */
    public p0(@NotNull Collection<? extends l0> packageFragments) {
        kotlin.jvm.internal.g0.p(packageFragments, "packageFragments");
        this.f44943a = packageFragments;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.c f(l0 it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return it.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(kotlin.reflect.jvm.internal.impl.name.c cVar, kotlin.reflect.jvm.internal.impl.name.c it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return !it.c() && kotlin.jvm.internal.g0.g(it.d(), cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m0
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    @NotNull
    public List<l0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        Collection<l0> collection = this.f44943a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (kotlin.jvm.internal.g0.g(((l0) obj).d(), fqName)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r0
    public void b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull Collection<l0> packageFragments) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        kotlin.jvm.internal.g0.p(packageFragments, "packageFragments");
        for (Object obj : this.f44943a) {
            if (kotlin.jvm.internal.g0.g(((l0) obj).d(), fqName)) {
                packageFragments.add(obj);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r0
    public boolean c(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        Collection<l0> collection = this.f44943a;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.g0.g(((l0) it.next()).d(), fqName)) {
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
        return kotlin.sequences.p.I3(kotlin.sequences.p.P0(kotlin.sequences.p.N1(kotlin.collections.f0.E1(this.f44943a), n0.f44940a), new o0(fqName)));
    }
}
