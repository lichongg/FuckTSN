package io.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class ReferenceMap<K, V> implements Map<K, V> {
    private final Map<K, Reference<V>> delegate;

    abstract Reference<V> fold(V v5);

    private V unfold(Reference<V> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    @Override // java.util.Map
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.delegate.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return unfold(this.delegate.get(obj));
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.delegate.keySet();
    }

    @Override // java.util.Map
    public V put(K k6, V v5) {
        return unfold(this.delegate.put(k6, fold(v5)));
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return unfold(this.delegate.remove(obj));
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    protected ReferenceMap(Map<K, Reference<V>> map) {
        this.delegate = map;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            this.delegate.put(entry.getKey(), fold(entry.getValue()));
        }
    }
}
