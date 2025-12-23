package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.u1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.i2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\ntypeEnhancementUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeEnhancementUtils.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/TypeEnhancementUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,73:1\n1#2:74\n1#2:85\n1#2:98\n1#2:111\n1617#3,9:75\n1869#3:84\n1870#3:86\n1626#3:87\n1617#3,9:88\n1869#3:97\n1870#3:99\n1626#3:100\n1617#3,9:101\n1869#3:110\n1870#3:112\n1626#3:113\n1761#3,3:114\n*S KotlinDebug\n*F\n+ 1 typeEnhancementUtils.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/TypeEnhancementUtilsKt\n*L\n43#1:85\n45#1:98\n47#1:111\n43#1:75,9\n43#1:84\n43#1:86\n43#1:87\n45#1:88,9\n45#1:97\n45#1:99\n45#1:100\n47#1:101,9\n47#1:110\n47#1:112\n47#1:113\n58#1:114,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p1 {
    @NotNull
    public static final h a(@NotNull h hVar, @NotNull Collection<h> superQualifiers, boolean z5, boolean z6, boolean z7) {
        NullabilityQualifier nullabilityQualifier;
        kotlin.jvm.internal.g0.p(hVar, "<this>");
        kotlin.jvm.internal.g0.p(superQualifiers, "superQualifiers");
        Collection<h> collection = superQualifiers;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            NullabilityQualifier b6 = b((h) it.next());
            if (b6 != null) {
                arrayList.add(b6);
            }
        }
        NullabilityQualifier f6 = f(kotlin.collections.f0.f6(arrayList), b(hVar), z5);
        if (f6 == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = collection.iterator();
            while (it2.hasNext()) {
                NullabilityQualifier f7 = ((h) it2.next()).f();
                if (f7 != null) {
                    arrayList2.add(f7);
                }
            }
            nullabilityQualifier = f(kotlin.collections.f0.f6(arrayList2), hVar.f(), z5);
        } else {
            nullabilityQualifier = f6;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it3 = collection.iterator();
        while (it3.hasNext()) {
            MutabilityQualifier e6 = ((h) it3.next()).e();
            if (e6 != null) {
                arrayList3.add(e6);
            }
        }
        MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) e(kotlin.collections.f0.f6(arrayList3), MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, hVar.e(), z5);
        if (nullabilityQualifier == null || z7 || (z6 && nullabilityQualifier == NullabilityQualifier.NULLABLE)) {
            nullabilityQualifier = null;
        }
        boolean z8 = false;
        boolean z9 = nullabilityQualifier != null && f6 == null;
        if (nullabilityQualifier == NullabilityQualifier.NOT_NULL) {
            if (!d(hVar, z9)) {
                if (!collection.isEmpty()) {
                    Iterator<T> it4 = collection.iterator();
                    while (it4.hasNext()) {
                        if (d((h) it4.next(), z9)) {
                        }
                    }
                }
            }
            z8 = true;
            break;
        }
        return new h(nullabilityQualifier, mutabilityQualifier, z8, z9);
    }

    public static final boolean c(@NotNull i2 i2Var, @NotNull e4.g type) {
        kotlin.jvm.internal.g0.p(i2Var, "<this>");
        kotlin.jvm.internal.g0.p(type, "type");
        kotlin.reflect.jvm.internal.impl.name.c ENHANCED_NULLABILITY_ANNOTATION = kotlin.reflect.jvm.internal.impl.load.java.i0.f45467v;
        kotlin.jvm.internal.g0.o(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        return i2Var.z0(type, ENHANCED_NULLABILITY_ANNOTATION);
    }

    private static final <T> T e(Set<? extends T> set, T t5, T t6, T t7, boolean z5) {
        Set<? extends T> f6;
        if (!z5) {
            if (t7 != null && (f6 = kotlin.collections.f0.f6(u1.D(set, t7))) != null) {
                set = f6;
            }
            return (T) kotlin.collections.f0.n5(set);
        }
        T t8 = set.contains(t5) ? t5 : set.contains(t6) ? t6 : null;
        if (kotlin.jvm.internal.g0.g(t8, t5) && kotlin.jvm.internal.g0.g(t7, t6)) {
            return null;
        }
        return t7 == null ? t8 : t7;
    }

    private static final NullabilityQualifier f(Set<? extends NullabilityQualifier> set, NullabilityQualifier nullabilityQualifier, boolean z5) {
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        return nullabilityQualifier == nullabilityQualifier2 ? nullabilityQualifier2 : (NullabilityQualifier) e(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z5);
    }

    private static final NullabilityQualifier b(h hVar) {
        if (hVar.g()) {
            return null;
        }
        return hVar.f();
    }

    private static final boolean d(h hVar, boolean z5) {
        if (hVar.g() == z5 && hVar.d()) {
            return true;
        }
        return false;
    }
}
