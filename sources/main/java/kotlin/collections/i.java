package kotlin.collections;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.1")
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class i<K, V> extends AbstractMap<K, V> implements Map<K, V>, m3.g {
    public abstract Set<Map.Entry<K, V>> a();

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public abstract V put(K k6, V v5);

    protected i() {
    }

    public /* bridge */ Set<Object> c() {
        return super.keySet();
    }

    public /* bridge */ int d() {
        return super.size();
    }

    public /* bridge */ Collection<Object> e() {
        return super.values();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return (Set<K>) c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) e();
    }
}
