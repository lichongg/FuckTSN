package kotlin.collections;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.builders.MapBuilder;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMapsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,157:1\n1#2:158\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class k1 extends j1 {

    /* renamed from: a, reason: collision with root package name */
    private static final int f43652a = 1073741824;

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <K, V> Map<K, V> d(@NotNull Map<K, V> builder) {
        kotlin.jvm.internal.g0.p(builder, "builder");
        return ((MapBuilder) builder).build();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <K, V> Map<K, V> e(int i6, Function1<? super Map<K, V>, kotlin.n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        Map h6 = h(i6);
        builderAction.invoke(h6);
        return d(h6);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <K, V> Map<K, V> f(Function1<? super Map<K, V>, kotlin.n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        Map g6 = g();
        builderAction.invoke(g6);
        return d(g6);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <K, V> Map<K, V> g() {
        return new MapBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <K, V> Map<K, V> h(int i6) {
        return new MapBuilder(i6);
    }

    public static final <K, V> V i(@NotNull ConcurrentMap<K, V> concurrentMap, K k6, @NotNull Function0<? extends V> defaultValue) {
        kotlin.jvm.internal.g0.p(concurrentMap, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        V v5 = concurrentMap.get(k6);
        if (v5 != null) {
            return v5;
        }
        V invoke = defaultValue.invoke();
        V putIfAbsent = concurrentMap.putIfAbsent(k6, invoke);
        return putIfAbsent == null ? invoke : putIfAbsent;
    }

    @PublishedApi
    public static int j(int i6) {
        if (i6 < 0) {
            return i6;
        }
        if (i6 < 3) {
            return i6 + 1;
        }
        if (i6 < 1073741824) {
            return (int) ((i6 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @NotNull
    public static <K, V> Map<K, V> k(@NotNull Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.g0.p(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        kotlin.jvm.internal.g0.o(singletonMap, "singletonMap(...)");
        return singletonMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static final <K, V> SortedMap<K, V> l(@NotNull Comparator<? super K> comparator, @NotNull Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        TreeMap treeMap = new TreeMap(comparator);
        l1.y0(treeMap, pairs);
        return treeMap;
    }

    @NotNull
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> m(@NotNull Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        TreeMap treeMap = new TreeMap();
        l1.y0(treeMap, pairs);
        return treeMap;
    }

    @InlineOnly
    private static final Properties n(Map<String, String> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    @NotNull
    public static final <K, V> Map<K, V> o(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.g0.o(singletonMap, "with(...)");
        return singletonMap;
    }

    @InlineOnly
    private static final <K, V> Map<K, V> p(Map<K, ? extends V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return o(map);
    }

    @NotNull
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> q(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return new TreeMap(map);
    }

    @NotNull
    public static <K, V> SortedMap<K, V> r(@NotNull Map<? extends K, ? extends V> map, @NotNull Comparator<? super K> comparator) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
