package com.alibaba.fastjson.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class IdentityHashMap<K, V> {
    private final Entry<K, V>[] buckets;
    private final int indexMask;

    public IdentityHashMap() {
        this(1024);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static final class Entry<K, V> {
        public final int hashCode;
        public final K key;
        public final Entry<K, V> next;
        public V value;

        public Entry(K k6, V v5, int i6, Entry<K, V> entry) {
            this.key = k6;
            this.value = v5;
            this.next = entry;
            this.hashCode = i6;
        }
    }

    public IdentityHashMap(int i6) {
        this.indexMask = i6 - 1;
        this.buckets = new Entry[i6];
    }

    public Class findClass(String str) {
        for (Entry<K, V> entry : this.buckets) {
            if (entry != null) {
                for (Entry<K, V> entry2 = entry; entry2 != null; entry2 = entry2.next) {
                    K k6 = entry.key;
                    if (k6 instanceof Class) {
                        Class cls = (Class) k6;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
            }
        }
        return null;
    }

    public final V get(K k6) {
        for (Entry<K, V> entry = this.buckets[System.identityHashCode(k6) & this.indexMask]; entry != null; entry = entry.next) {
            if (k6 == entry.key) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean put(K k6, V v5) {
        int identityHashCode = System.identityHashCode(k6);
        int i6 = this.indexMask & identityHashCode;
        for (Entry<K, V> entry = this.buckets[i6]; entry != null; entry = entry.next) {
            if (k6 == entry.key) {
                entry.value = v5;
                return true;
            }
        }
        this.buckets[i6] = new Entry<>(k6, v5, identityHashCode, this.buckets[i6]);
        return false;
    }
}
