package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSealedClassInheritorsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SealedClassInheritorsProvider.kt\norg/jetbrains/kotlin/resolve/CliSealedClassInheritorsProvider\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n183#2,2:87\n1056#3:89\n*S KotlinDebug\n*F\n+ 1 SealedClassInheritorsProvider.kt\norg/jetbrains/kotlin/resolve/CliSealedClassInheritorsProvider\n*L\n73#1:87,2\n82#1:89\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a extends s {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f46650a = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 SealedClassInheritorsProvider.kt\norg/jetbrains/kotlin/resolve/CliSealedClassInheritorsProvider\n*L\n1#1,328:1\n82#2:329\n*E\n"})
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.a$a, reason: collision with other inner class name */
    public static final class C0911a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            return kotlin.comparisons.a.l(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o((kotlin.reflect.jvm.internal.impl.descriptors.d) t5).a(), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o((kotlin.reflect.jvm.internal.impl.descriptors.d) t6).a());
        }
    }

    private static final void b(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, LinkedHashSet<kotlin.reflect.jvm.internal.impl.descriptors.d> linkedHashSet, kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar, boolean z5) {
        for (kotlin.reflect.jvm.internal.impl.descriptors.k kVar2 : n.a.a(kVar, kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f46756t, null, 2, null)) {
            if (kVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) kVar2;
                if (dVar2.q0()) {
                    kotlin.reflect.jvm.internal.impl.name.f name = dVar2.getName();
                    g0.o(name, "getName(...)");
                    kotlin.reflect.jvm.internal.impl.descriptors.f g6 = kVar.g(name, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
                    dVar2 = g6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) g6 : g6 instanceof i1 ? ((i1) g6).m() : null;
                }
                if (dVar2 != null) {
                    if (i.z(dVar2, dVar)) {
                        linkedHashSet.add(dVar2);
                    }
                    if (z5) {
                        kotlin.reflect.jvm.internal.impl.resolve.scopes.k G = dVar2.G();
                        g0.o(G, "getUnsubstitutedInnerClassesScope(...)");
                        b(dVar, linkedHashSet, G, z5);
                    }
                }
            }
        }
    }

    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d sealedClass, boolean z5) {
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar;
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar2;
        g0.p(sealedClass, "sealedClass");
        if (sealedClass.i() != Modality.SEALED) {
            return f0.J();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z5) {
            Iterator<kotlin.reflect.jvm.internal.impl.descriptors.k> it = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.u(sealedClass).iterator();
            while (true) {
                if (!it.hasNext()) {
                    kVar = null;
                    break;
                }
                kVar = it.next();
                if (kVar instanceof l0) {
                    break;
                }
            }
            kVar2 = kVar;
        } else {
            kVar2 = sealedClass.b();
        }
        if (kVar2 instanceof l0) {
            b(sealedClass, linkedHashSet, ((l0) kVar2).r(), z5);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k G = sealedClass.G();
        g0.o(G, "getUnsubstitutedInnerClassesScope(...)");
        b(sealedClass, linkedHashSet, G, true);
        return f0.z5(linkedHashSet, new C0911a());
    }

    private a() {
    }
}
