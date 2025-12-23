package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n_Sets.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sets.kt\nkotlin/collections/SetsKt___SetsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n865#2,2:141\n855#2,2:143\n1#3:145\n*S KotlinDebug\n*F\n+ 1 _Sets.kt\nkotlin/collections/SetsKt___SetsKt\n*L\n29#1:141,2\n53#1:143,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class x1 extends w1 {
    @NotNull
    public static final <T> Set<T> A(@NotNull Set<? extends T> set, @NotNull T[] elements) {
        kotlin.jvm.internal.g0.p(set, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        m0.M0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @InlineOnly
    private static final <T> Set<T> B(Set<? extends T> set, T t5) {
        kotlin.jvm.internal.g0.p(set, "<this>");
        return y(set, t5);
    }

    @NotNull
    public static <T> Set<T> C(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> elements) {
        int size;
        kotlin.jvm.internal.g0.p(set, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        Integer e02 = i0.e0(elements);
        if (e02 != null) {
            size = set.size() + e02.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(k1.j(size));
        linkedHashSet.addAll(set);
        m0.s0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @NotNull
    public static <T> Set<T> D(@NotNull Set<? extends T> set, T t5) {
        kotlin.jvm.internal.g0.p(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(k1.j(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t5);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> E(@NotNull Set<? extends T> set, @NotNull kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.g0.p(set, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(k1.j(set.size() * 2));
        linkedHashSet.addAll(set);
        m0.t0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> F(@NotNull Set<? extends T> set, @NotNull T[] elements) {
        kotlin.jvm.internal.g0.p(set, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(k1.j(set.size() + elements.length));
        linkedHashSet.addAll(set);
        m0.u0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @InlineOnly
    private static final <T> Set<T> G(Set<? extends T> set, T t5) {
        kotlin.jvm.internal.g0.p(set, "<this>");
        return D(set, t5);
    }

    @NotNull
    public static <T> Set<T> x(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.g0.p(set, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        Collection<?> v02 = m0.v0(elements);
        if (v02.isEmpty()) {
            return r0.f6(set);
        }
        if (!(v02 instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(v02);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (T t5 : set) {
            if (!((Set) v02).contains(t5)) {
                linkedHashSet2.add(t5);
            }
        }
        return linkedHashSet2;
    }

    @NotNull
    public static <T> Set<T> y(@NotNull Set<? extends T> set, T t5) {
        kotlin.jvm.internal.g0.p(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(k1.j(set.size()));
        boolean z5 = false;
        for (T t6 : set) {
            boolean z6 = true;
            if (!z5 && kotlin.jvm.internal.g0.g(t6, t5)) {
                z5 = true;
                z6 = false;
            }
            if (z6) {
                linkedHashSet.add(t6);
            }
        }
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> z(@NotNull Set<? extends T> set, @NotNull kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.g0.p(set, "<this>");
        kotlin.jvm.internal.g0.p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        m0.L0(linkedHashSet, elements);
        return linkedHashSet;
    }
}
