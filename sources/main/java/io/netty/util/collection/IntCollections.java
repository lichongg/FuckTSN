package io.netty.util.collection;

import io.netty.util.collection.IntObjectMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class IntCollections {
    private static final IntObjectMap<Object> EMPTY_MAP = new EmptyMap(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.util.collection.IntCollections$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class EmptyMap implements IntObjectMap<Object> {
        private EmptyMap() {
        }

        @Override // io.netty.util.collection.IntObjectMap
        public boolean containsKey(int i6) {
            return false;
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return false;
        }

        @Override // io.netty.util.collection.IntObjectMap
        public Object get(int i6) {
            return null;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // io.netty.util.collection.IntObjectMap
        public Object remove(int i6) {
            return null;
        }

        @Override // java.util.Map
        public int size() {
            return 0;
        }

        /* synthetic */ EmptyMap(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return false;
        }

        @Override // io.netty.util.collection.IntObjectMap
        public Iterable<IntObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Integer, Object>> entrySet() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.Map
        public Object get(Object obj) {
            return null;
        }

        @Override // java.util.Map
        public Set<Integer> keySet() {
            return Collections.EMPTY_SET;
        }

        @Override // io.netty.util.collection.IntObjectMap
        public Object put(int i6, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Integer, ?> map) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Object remove(Object obj) {
            return null;
        }

        @Override // java.util.Map
        public Collection<Object> values() {
            return Collections.EMPTY_LIST;
        }

        @Override // java.util.Map
        public Object put(Integer num, Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void clear() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class UnmodifiableMap<V> implements IntObjectMap<V> {
        private Iterable<IntObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Integer, V>> entrySet;
        private Set<Integer> keySet;
        private final IntObjectMap<V> map;
        private Collection<V> values;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class EntryImpl implements IntObjectMap.PrimitiveEntry<V> {
            private final IntObjectMap.PrimitiveEntry<V> entry;

            EntryImpl(IntObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            @Override // io.netty.util.collection.IntObjectMap.PrimitiveEntry
            public int key() {
                return this.entry.key();
            }

            @Override // io.netty.util.collection.IntObjectMap.PrimitiveEntry
            public void setValue(V v5) {
                throw new UnsupportedOperationException("setValue");
            }

            @Override // io.netty.util.collection.IntObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class IteratorImpl implements Iterator<IntObjectMap.PrimitiveEntry<V>> {
            final Iterator<IntObjectMap.PrimitiveEntry<V>> iter;

            IteratorImpl(Iterator<IntObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public IntObjectMap.PrimitiveEntry<V> next() {
                if (hasNext()) {
                    return new EntryImpl(this.iter.next());
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        }

        @Override // io.netty.util.collection.IntObjectMap
        public boolean containsKey(int i6) {
            return this.map.containsKey(i6);
        }

        @Override // io.netty.util.collection.IntObjectMap
        public V get(int i6) {
            return this.map.get(i6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Object put(Integer num, Object obj) {
            return put2(num, (Integer) obj);
        }

        @Override // io.netty.util.collection.IntObjectMap
        public V remove(int i6) {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("clear");
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // io.netty.util.collection.IntObjectMap
        public Iterable<IntObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<IntObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.IntCollections.UnmodifiableMap.1
                    @Override // java.lang.Iterable
                    public Iterator<IntObjectMap.PrimitiveEntry<V>> iterator() {
                        UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                        return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Integer, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = Collections.unmodifiableSet(this.map.entrySet());
            }
            return this.entrySet;
        }

        @Override // java.util.Map
        public V get(Object obj) {
            return this.map.get(obj);
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Map
        public Set<Integer> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        @Override // io.netty.util.collection.IntObjectMap
        public V put(int i6, V v5) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Integer, ? extends V> map) {
            throw new UnsupportedOperationException("putAll");
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Map
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            if (this.values == null) {
                this.values = Collections.unmodifiableCollection(this.map.values());
            }
            return this.values;
        }

        UnmodifiableMap(IntObjectMap<V> intObjectMap) {
            this.map = intObjectMap;
        }

        /* renamed from: put, reason: avoid collision after fix types in other method */
        public V put2(Integer num, V v5) {
            throw new UnsupportedOperationException("put");
        }
    }

    public static <V> IntObjectMap<V> emptyMap() {
        return (IntObjectMap<V>) EMPTY_MAP;
    }

    public static <V> IntObjectMap<V> unmodifiableMap(IntObjectMap<V> intObjectMap) {
        return new UnmodifiableMap(intObjectMap);
    }

    private IntCollections() {
    }
}
