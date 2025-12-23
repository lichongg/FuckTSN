package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapsKt__MapWithDefaultKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,111:1\n348#2,6:112\n*S KotlinDebug\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapsKt__MapWithDefaultKt\n*L\n24#1:112,6\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class j1 {
    @PublishedApi
    @JvmName(name = "getOrImplicitDefaultNullable")
    public static final <K, V> V a(@NotNull Map<K, ? extends V> map, K k6) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        if (map instanceof g1) {
            return (V) ((g1) map).s(k6);
        }
        V v5 = map.get(k6);
        if (v5 != null || map.containsKey(k6)) {
            return v5;
        }
        throw new NoSuchElementException("Key " + k6 + " is missing in the map.");
    }

    @NotNull
    public static final <K, V> Map<K, V> b(@NotNull Map<K, ? extends V> map, @NotNull Function1<? super K, ? extends V> defaultValue) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return map instanceof g1 ? b(((g1) map).getMap(), defaultValue) : new h1(map, defaultValue);
    }

    @JvmName(name = "withDefaultMutable")
    @NotNull
    public static final <K, V> Map<K, V> c(@NotNull Map<K, V> map, @NotNull Function1<? super K, ? extends V> defaultValue) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return map instanceof p1 ? c(((p1) map).getMap(), defaultValue) : new q1(map, defaultValue);
    }
}
