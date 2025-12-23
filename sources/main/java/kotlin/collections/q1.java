package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MutableMapWithDefaultImpl\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,111:1\n348#2,6:112\n*S KotlinDebug\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MutableMapWithDefaultImpl\n*L\n108#1:112,6\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class q1<K, V> implements p1<K, V> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<K, V> f43674a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<K, V> f43675b;

    /* JADX WARN: Multi-variable type inference failed */
    public q1(@NotNull Map<K, V> map, @NotNull Function1<? super K, ? extends V> function1) {
        kotlin.jvm.internal.g0.p(map, "map");
        kotlin.jvm.internal.g0.p(function1, "default");
        this.f43674a = map;
        this.f43675b = function1;
    }

    @Override // kotlin.collections.p1, kotlin.collections.g1
    @NotNull
    public Map<K, V> getMap() {
        return this.f43674a;
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> from) {
        kotlin.jvm.internal.g0.p(from, "from");
        getMap().putAll(from);
    }

    @NotNull
    public Set<Map.Entry<K, V>> a() {
        return getMap().entrySet();
    }

    @NotNull
    public Set<K> c() {
        return getMap().keySet();
    }

    @Override // java.util.Map
    public void clear() {
        getMap().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return getMap().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return getMap().containsValue(obj);
    }

    public int d() {
        return getMap().size();
    }

    @NotNull
    public Collection<V> e() {
        return getMap().values();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return a();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        return getMap().equals(obj);
    }

    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        return getMap().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return getMap().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return c();
    }

    @Override // java.util.Map
    @Nullable
    public V put(K k6, V v5) {
        return getMap().put(k6, v5);
    }

    @Override // java.util.Map
    @Nullable
    public V remove(Object obj) {
        return getMap().remove(obj);
    }

    @Override // kotlin.collections.g1
    public V s(K k6) {
        Map<K, V> map = getMap();
        V v5 = map.get(k6);
        if (v5 == null && !map.containsKey(k6)) {
            return this.f43675b.invoke(k6);
        }
        return v5;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @NotNull
    public String toString() {
        return getMap().toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return e();
    }
}
