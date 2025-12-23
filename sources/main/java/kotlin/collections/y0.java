package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nGroupingJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupingJVM.kt\nkotlin/collections/GroupingKt__GroupingJVMKt\n+ 2 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n143#2:53\n80#2,4:54\n85#2:59\n1#3:58\n1869#4,2:60\n*S KotlinDebug\n*F\n+ 1 GroupingJVM.kt\nkotlin/collections/GroupingKt__GroupingJVMKt\n*L\n22#1:53\n22#1:54,4\n22#1:59\n48#1:60,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class y0 {
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K> Map<K, Integer> a(@NotNull w0<T, ? extends K> w0Var) {
        kotlin.jvm.internal.g0.p(w0Var, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> b6 = w0Var.b();
        while (b6.hasNext()) {
            K a6 = w0Var.a(b6.next());
            Object obj = linkedHashMap.get(a6);
            if (obj == null && !linkedHashMap.containsKey(a6)) {
                obj = new Ref.IntRef();
            }
            Ref.IntRef intRef = (Ref.IntRef) obj;
            intRef.element++;
            linkedHashMap.put(a6, intRef);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            kotlin.jvm.internal.g0.n(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace>");
            kotlin.jvm.internal.u0.m(entry).setValue(Integer.valueOf(((Ref.IntRef) entry.getValue()).element));
        }
        return kotlin.jvm.internal.u0.k(linkedHashMap);
    }

    @PublishedApi
    @InlineOnly
    private static final <K, V, R> Map<K, R> b(Map<K, V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> f6) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(f6, "f");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            kotlin.jvm.internal.g0.n(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace>");
            kotlin.jvm.internal.u0.m(entry).setValue(f6.invoke(entry));
        }
        return kotlin.jvm.internal.u0.k(map);
    }
}
