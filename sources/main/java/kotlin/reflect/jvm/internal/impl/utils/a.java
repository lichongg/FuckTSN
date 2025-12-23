package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\ncollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 collections.kt\norg/jetbrains/kotlin/utils/CollectionsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,129:1\n1222#2,2:130\n1252#2,4:132\n1#3:136\n*S KotlinDebug\n*F\n+ 1 collections.kt\norg/jetbrains/kotlin/utils/CollectionsKt\n*L\n22#1:130,2\n22#1:132,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {
    private static final int b(int i6) {
        if (i6 < 3) {
            return 3;
        }
        return i6 + (i6 / 3) + 1;
    }

    public static final <T> void a(@NotNull Collection<T> collection, @Nullable T t5) {
        g0.p(collection, "<this>");
        if (t5 != null) {
            collection.add(t5);
        }
    }

    @NotNull
    public static final <T> List<T> c(@NotNull ArrayList<T> arrayList) {
        g0.p(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return f0.J();
        }
        if (size == 1) {
            return f0.l(f0.G2(arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    @NotNull
    public static final <K> Map<K, Integer> d(@NotNull Iterable<? extends K> iterable) {
        g0.p(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends K> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i6));
            i6++;
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> HashMap<K, V> e(int i6) {
        return new HashMap<>(b(i6));
    }

    @NotNull
    public static final <E> HashSet<E> f(int i6) {
        return new HashSet<>(b(i6));
    }

    @NotNull
    public static final <E> LinkedHashSet<E> g(int i6) {
        return new LinkedHashSet<>(b(i6));
    }
}
