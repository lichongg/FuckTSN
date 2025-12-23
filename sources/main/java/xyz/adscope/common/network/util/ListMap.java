package xyz.adscope.common.network.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ListMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private Map<K, List<V>> f56730a;

    public void add(K k6, V v5) {
        try {
            if (!this.f56730a.containsKey(k6)) {
                this.f56730a.put(k6, new ArrayList());
            }
            List<V> list = this.f56730a.get(k6);
            if (list != null) {
                list.add(v5);
            }
        } catch (Throwable unused) {
        }
    }

    public void set(K k6, V v5) {
        this.f56730a.remove(k6);
        add((ListMap<K, V>) k6, (K) v5);
    }

    public void clear() {
        this.f56730a.clear();
    }

    public boolean containsKey(K k6) {
        return this.f56730a.containsKey(k6);
    }

    public Set<Map.Entry<K, List<V>>> entrySet() {
        return this.f56730a.entrySet();
    }

    public List<V> get(K k6) {
        return this.f56730a.get(k6);
    }

    public V getFirst(K k6) {
        List<V> list = this.f56730a.get(k6);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return this.f56730a.isEmpty();
    }

    public Set<K> keySet() {
        return this.f56730a.keySet();
    }

    public List<V> remove(K k6) {
        return this.f56730a.remove(k6);
    }

    public int size() {
        return this.f56730a.size();
    }

    public Map<K, List<V>> toMap() {
        return this.f56730a;
    }

    public ListMap(Map<K, List<V>> map) {
        this.f56730a = map;
    }

    public void set(K k6, List<V> list) {
        this.f56730a.put(k6, list);
    }

    public void add(K k6, List<V> list) {
        Iterator<V> it = list.iterator();
        while (it.hasNext()) {
            add((ListMap<K, V>) k6, (K) it.next());
        }
    }
}
