package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.BuilderInference;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMaps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,814:1\n413#1:824\n424#1:829\n521#1,6:834\n546#1,6:840\n1#2:815\n1252#3,4:816\n1252#3,4:820\n1252#3,4:825\n1252#3,4:830\n*S KotlinDebug\n*F\n+ 1 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n463#1:824\n478#1:829\n536#1:834,6\n561#1:840,6\n413#1:816,4\n424#1:820,4\n463#1:825,4\n478#1:830,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class l1 extends k1 {
    @NotNull
    public static final <K, V> Map<K, V> A(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @InlineOnly
    private static final <K, V> void A0(Map<K, V> map, K k6, V v5) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        map.put(k6, v5);
    }

    @NotNull
    public static final <K, V> Map<K, V> B(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super K, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke(entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public static <K, V> Map<K, V> B0(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return k0(C0(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return z();
        }
        if (size != 1) {
            return C0(iterable, new LinkedHashMap(k1.j(collection.size())));
        }
        return k1.k((Pair) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
    }

    @NotNull
    public static final <K, V> Map<K, V> C(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M C0(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable, @NotNull M destination) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        w0(destination, iterable);
        return destination;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M D(@NotNull Map<? extends K, ? extends V> map, @NotNull M destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static <K, V> Map<K, V> D0(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? J0(map) : k1.o(map) : z();
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M E(@NotNull Map<? extends K, ? extends V> map, @NotNull M destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M E0(@NotNull Map<? extends K, ? extends V> map, @NotNull M destination) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        destination.putAll(map);
        return destination;
    }

    @NotNull
    public static final <K, V> Map<K, V> F(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super V, Boolean> predicate) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke(entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> F0(@NotNull kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> mVar) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        return k0(G0(mVar, new LinkedHashMap()));
    }

    @InlineOnly
    private static final <K, V> V G(Map<? extends K, ? extends V> map, K k6) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return map.get(k6);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M G0(@NotNull kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> mVar, @NotNull M destination) {
        kotlin.jvm.internal.g0.p(mVar, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        x0(destination, mVar);
        return destination;
    }

    @InlineOnly
    private static final <K, V> V H(Map<K, ? extends V> map, K k6, Function0<? extends V> defaultValue) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        V v5 = map.get(k6);
        return v5 == null ? defaultValue.invoke() : v5;
    }

    @NotNull
    public static final <K, V> Map<K, V> H0(@NotNull Pair<? extends K, ? extends V>[] pairArr) {
        kotlin.jvm.internal.g0.p(pairArr, "<this>");
        int length = pairArr.length;
        return length != 0 ? length != 1 ? I0(pairArr, new LinkedHashMap(k1.j(pairArr.length))) : k1.k(pairArr[0]) : z();
    }

    public static final <K, V> V I(@NotNull Map<K, ? extends V> map, K k6, @NotNull Function0<? extends V> defaultValue) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        V v5 = map.get(k6);
        return (v5 != null || map.containsKey(k6)) ? v5 : defaultValue.invoke();
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M I0(@NotNull Pair<? extends K, ? extends V>[] pairArr, @NotNull M destination) {
        kotlin.jvm.internal.g0.p(pairArr, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        y0(destination, pairArr);
        return destination;
    }

    public static final <K, V> V J(@NotNull Map<K, V> map, K k6, @NotNull Function0<? extends V> defaultValue) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        V v5 = map.get(k6);
        if (v5 != null) {
            return v5;
        }
        V invoke = defaultValue.invoke();
        map.put(k6, invoke);
        return invoke;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static <K, V> Map<K, V> J0(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return new LinkedHashMap(map);
    }

    @SinceKotlin(version = "1.1")
    public static <K, V> V K(@NotNull Map<K, ? extends V> map, K k6) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return (V) j1.a(map, k6);
    }

    @InlineOnly
    private static final <K, V> Pair<K, V> K0(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.g0.p(entry, "<this>");
        return new Pair<>(entry.getKey(), entry.getValue());
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> HashMap<K, V> L() {
        return new HashMap<>();
    }

    @NotNull
    public static <K, V> HashMap<K, V> M(@NotNull Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(k1.j(pairs.length));
        y0(hashMap, pairs);
        return hashMap;
    }

    /* JADX WARN: Incorrect types in method signature: <M::Ljava/util/Map<**>;:TR;R:Ljava/lang/Object;>(TM;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object N(Map map, Function0 defaultValue) {
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return map.isEmpty() ? defaultValue.invoke() : map;
    }

    @InlineOnly
    private static final <K, V> boolean O(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return !map.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <K, V> boolean P(Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    @InlineOnly
    private static final <K, V> Iterator<Map.Entry<K, V>> Q(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return map.entrySet().iterator();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> LinkedHashMap<K, V> R() {
        return new LinkedHashMap<>();
    }

    @NotNull
    public static final <K, V> LinkedHashMap<K, V> S(@NotNull Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        return (LinkedHashMap) I0(pairs, new LinkedHashMap(k1.j(pairs.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, R> Map<R, V> T(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(k1.j(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(transform.invoke(entry), entry.getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, R, M extends Map<? super R, ? super V>> M U(@NotNull Map<? extends K, ? extends V> map, @NotNull M destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            destination.put(transform.invoke(entry), entry.getValue());
        }
        return destination;
    }

    @NotNull
    public static <K, V> Map<K, V> W(@NotNull Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        return pairs.length > 0 ? I0(pairs, new LinkedHashMap(k1.j(pairs.length))) : z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, R> Map<K, R> X(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(k1.j(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(entry.getKey(), transform.invoke(entry));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, R, M extends Map<? super K, ? super R>> M Y(@NotNull Map<? extends K, ? extends V> map, @NotNull M destination, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(destination, "destination");
        kotlin.jvm.internal.g0.p(transform, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            destination.put(entry.getKey(), transform.invoke(entry));
        }
        return destination;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K, V> Map<K, V> Z(@NotNull Map<? extends K, ? extends V> map, @NotNull Iterable<? extends K> keys) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(keys, "keys");
        Map J0 = J0(map);
        m0.J0(J0.keySet(), keys);
        return k0(J0);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K, V> Map<K, V> a0(@NotNull Map<? extends K, ? extends V> map, K k6) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        Map J0 = J0(map);
        J0.remove(k6);
        return k0(J0);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K, V> Map<K, V> b0(@NotNull Map<? extends K, ? extends V> map, @NotNull kotlin.sequences.m<? extends K> keys) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(keys, "keys");
        Map J0 = J0(map);
        m0.L0(J0.keySet(), keys);
        return k0(J0);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K, V> Map<K, V> c0(@NotNull Map<? extends K, ? extends V> map, @NotNull K[] keys) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(keys, "keys");
        Map J0 = J0(map);
        m0.M0(J0.keySet(), keys);
        return k0(J0);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void d0(Map<K, V> map, Iterable<? extends K> keys) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(keys, "keys");
        m0.J0(map.keySet(), keys);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void e0(Map<K, V> map, K k6) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        map.remove(k6);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void f0(Map<K, V> map, kotlin.sequences.m<? extends K> keys) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(keys, "keys");
        m0.L0(map.keySet(), keys);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> void g0(Map<K, V> map, K[] keys) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(keys, "keys");
        m0.M0(map.keySet(), keys);
    }

    @InlineOnly
    @JvmName(name = "mutableIterator")
    private static final <K, V> Iterator<Map.Entry<K, V>> h0(Map<K, V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return map.entrySet().iterator();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <K, V> Map<K, V> i0() {
        return new LinkedHashMap();
    }

    @NotNull
    public static <K, V> Map<K, V> j0(@NotNull Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(k1.j(pairs.length));
        y0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> k0(@NotNull Map<K, ? extends V> map) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : k1.o(map) : z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <K, V> Map<K, V> l0(Map<K, ? extends V> map) {
        return map == 0 ? z() : map;
    }

    @NotNull
    public static final <K, V> Map<K, V> m0(@NotNull Map<? extends K, ? extends V> map, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        if (map.isEmpty()) {
            return B0(pairs);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        w0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @NotNull
    public static <K, V> Map<K, V> n0(@NotNull Map<? extends K, ? extends V> map, @NotNull Map<? extends K, ? extends V> map2) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> o0(@NotNull Map<? extends K, ? extends V> map, @NotNull Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(pair, "pair");
        if (map.isEmpty()) {
            return k1.k(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.getFirst(), pair.getSecond());
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> p0(@NotNull Map<? extends K, ? extends V> map, @NotNull kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        x0(linkedHashMap, pairs);
        return k0(linkedHashMap);
    }

    @NotNull
    public static final <K, V> Map<K, V> q0(@NotNull Map<? extends K, ? extends V> map, @NotNull Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        if (map.isEmpty()) {
            return H0(pairs);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        y0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @InlineOnly
    private static final <K, V> void r0(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        w0(map, pairs);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final <K, V> Map<K, V> s(int i6, @BuilderInference Function1<? super Map<K, V>, kotlin.n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        Map h6 = k1.h(i6);
        builderAction.invoke(h6);
        return k1.d(h6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <K, V> void s0(Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(map2, "map");
        map.putAll(map2);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @InlineOnly
    private static final <K, V> Map<K, V> t(@BuilderInference Function1<? super Map<K, V>, kotlin.n1> builderAction) {
        kotlin.jvm.internal.g0.p(builderAction, "builderAction");
        Map g6 = k1.g();
        builderAction.invoke(g6);
        return k1.d(g6);
    }

    @InlineOnly
    private static final <K, V> void t0(Map<? super K, ? super V> map, Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(pair, "pair");
        map.put(pair.getFirst(), pair.getSecond());
    }

    @InlineOnly
    private static final <K, V> K u(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.g0.p(entry, "<this>");
        return entry.getKey();
    }

    @InlineOnly
    private static final <K, V> void u0(Map<? super K, ? super V> map, kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        x0(map, pairs);
    }

    @InlineOnly
    private static final <K, V> V v(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.g0.p(entry, "<this>");
        return entry.getValue();
    }

    @InlineOnly
    private static final <K, V> void v0(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        y0(map, pairs);
    }

    @InlineOnly
    private static final <K, V> boolean w(Map<? extends K, ? extends V> map, K k6) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return map.containsKey(k6);
    }

    public static final <K, V> void w0(@NotNull Map<? super K, ? super V> map, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    @InlineOnly
    private static final <K> boolean x(Map<? extends K, ?> map, K k6) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return map.containsKey(k6);
    }

    public static final <K, V> void x0(@NotNull Map<? super K, ? super V> map, @NotNull kotlin.sequences.m<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    @InlineOnly
    private static final <K, V> boolean y(Map<K, ? extends V> map, V v5) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return map.containsValue(v5);
    }

    public static final <K, V> void y0(@NotNull Map<? super K, ? super V> map, @NotNull Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        kotlin.jvm.internal.g0.p(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    @NotNull
    public static <K, V> Map<K, V> z() {
        u0 u0Var = u0.f43697a;
        kotlin.jvm.internal.g0.n(u0Var, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return u0Var;
    }

    @InlineOnly
    private static final <K, V> V z0(Map<? extends K, V> map, K k6) {
        kotlin.jvm.internal.g0.p(map, "<this>");
        return (V) kotlin.jvm.internal.u0.k(map).remove(k6);
    }

    @InlineOnly
    private static final <K, V> Map<K, V> V() {
        return z();
    }
}
