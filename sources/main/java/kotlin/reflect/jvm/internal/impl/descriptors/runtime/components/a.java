package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.p;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n;
import kotlin.reflect.jvm.internal.impl.load.kotlin.w;
import kotlin.reflect.jvm.internal.impl.load.kotlin.x;
import kotlin.reflect.jvm.internal.impl.name.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nPackagePartScopeCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PackagePartScopeCache.kt\norg/jetbrains/kotlin/descriptors/runtime/components/PackagePartScopeCache\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n72#2,2:42\n1617#3,9:44\n1869#3:53\n1870#3:55\n1626#3:56\n1617#3,9:57\n1869#3:66\n1870#3:68\n1626#3:69\n1#4:54\n1#4:67\n1#4:70\n*S KotlinDebug\n*F\n+ 1 PackagePartScopeCache.kt\norg/jetbrains/kotlin/descriptors/runtime/components/PackagePartScopeCache\n*L\n21#1:42,2\n26#1:44,9\n26#1:53\n26#1:55\n26#1:56\n34#1:57,9\n34#1:66\n34#1:68\n34#1:69\n26#1:54\n34#1:67\n21#1:70\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final n f44961a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final g f44962b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final ConcurrentHashMap<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.resolve.scopes.k> f44963c;

    public a(@NotNull n resolver, @NotNull g kotlinClassFinder) {
        g0.p(resolver, "resolver");
        g0.p(kotlinClassFinder, "kotlinClassFinder");
        this.f44961a = resolver;
        this.f44962b = kotlinClassFinder;
        this.f44963c = new ConcurrentHashMap<>();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.k a(@NotNull f fileClass) {
        Collection l6;
        g0.p(fileClass, "fileClass");
        ConcurrentHashMap<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.resolve.scopes.k> concurrentHashMap = this.f44963c;
        kotlin.reflect.jvm.internal.impl.name.b c6 = fileClass.c();
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar = concurrentHashMap.get(c6);
        if (kVar == null) {
            kotlin.reflect.jvm.internal.impl.name.c f6 = fileClass.c().f();
            if (fileClass.e().c() == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                List<String> f7 = fileClass.e().f();
                l6 = new ArrayList();
                for (String str : f7) {
                    b.a aVar = kotlin.reflect.jvm.internal.impl.name.b.f46334d;
                    kotlin.reflect.jvm.internal.impl.name.c e6 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.d(str).e();
                    g0.o(e6, "getFqNameForTopLevelClassMaybeWithDollars(...)");
                    x a6 = w.a(this.f44962b, aVar.c(e6), this.f44961a.f().g().f());
                    if (a6 != null) {
                        l6.add(a6);
                    }
                }
            } else {
                l6 = f0.l(fileClass);
            }
            p pVar = new p(this.f44961a.f().q(), f6);
            ArrayList arrayList = new ArrayList();
            Iterator it = l6.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.resolve.scopes.k c7 = this.f44961a.c(pVar, (x) it.next());
                if (c7 != null) {
                    arrayList.add(c7);
                }
            }
            List a62 = f0.a6(arrayList);
            kotlin.reflect.jvm.internal.impl.resolve.scopes.k a7 = kotlin.reflect.jvm.internal.impl.resolve.scopes.b.f46733d.a("package " + f6 + " (" + fileClass + ')', a62);
            kotlin.reflect.jvm.internal.impl.resolve.scopes.k putIfAbsent = concurrentHashMap.putIfAbsent(c6, a7);
            kVar = putIfAbsent == null ? a7 : putIfAbsent;
        }
        g0.o(kVar, "getOrPut(...)");
        return kVar;
    }
}
