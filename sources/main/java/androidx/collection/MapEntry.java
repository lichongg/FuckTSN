package androidx.collection;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class MapEntry<K, V> implements Map.Entry<K, V>, m3.a {
    private final K key;
    private final V value;

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public MapEntry(K k6, V v5) {
        this.key = k6;
        this.value = v5;
    }
}
