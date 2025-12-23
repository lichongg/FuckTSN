package io.netty.util.collection;

import io.netty.util.collection.LongObjectMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class LongCollections {
    private static final LongObjectMap<Object> EMPTY_MAP = new EmptyMap(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.util.collection.LongCollections$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class EmptyMap implements LongObjectMap<Object> {
        private EmptyMap() {
        }

        @Override // io.netty.util.collection.LongObjectMap
        public boolean containsKey(long j6) {
            return false;
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return false;
        }

        @Override // io.netty.util.collection.LongObjectMap
        public Object get(long j6) {
            return null;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // io.netty.util.collection.LongObjectMap
        public Object remove(long j6) {
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

        @Override // io.netty.util.collection.LongObjectMap
        public Iterable<LongObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Long, Object>> entrySet() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.Map
        public Object get(Object obj) {
            return null;
        }

        @Override // java.util.Map
        public Set<Long> keySet() {
            return Collections.EMPTY_SET;
        }

        @Override // io.netty.util.collection.LongObjectMap
        public Object put(long j6, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ?> map) {
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
        public Object put(Long l6, Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void clear() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class UnmodifiableMap<V> implements LongObjectMap<V> {
        private Iterable<LongObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Long, V>> entrySet;
        private Set<Long> keySet;
        private final LongObjectMap<V> map;
        private Collection<V> values;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class EntryImpl implements LongObjectMap.PrimitiveEntry<V> {
            private final LongObjectMap.PrimitiveEntry<V> entry;

            EntryImpl(LongObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            @Override // io.netty.util.collection.LongObjectMap.PrimitiveEntry
            public long key() {
                return this.entry.key();
            }

            @Override // io.netty.util.collection.LongObjectMap.PrimitiveEntry
            public void setValue(V v5) {
                throw new UnsupportedOperationException("setValue");
            }

            @Override // io.netty.util.collection.LongObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class IteratorImpl implements Iterator<LongObjectMap.PrimitiveEntry<V>> {
            final Iterator<LongObjectMap.PrimitiveEntry<V>> iter;

            IteratorImpl(Iterator<LongObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public LongObjectMap.PrimitiveEntry<V> next() {
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

        @Override // io.netty.util.collection.LongObjectMap
        public boolean containsKey(long j6) {
            return this.map.containsKey(j6);
        }

        @Override // io.netty.util.collection.LongObjectMap
        public V get(long j6) {
            return this.map.get(j6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Object put(Long l6, Object obj) {
            return put2(l6, (Long) obj);
        }

        @Override // io.netty.util.collection.LongObjectMap
        public V remove(long j6) {
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

        @Override // io.netty.util.collection.LongObjectMap
        public Iterable<LongObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<LongObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.LongCollections.UnmodifiableMap.1
                    @Override // java.lang.Iterable
                    public Iterator<LongObjectMap.PrimitiveEntry<V>> iterator() {
                        UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                        return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Long, V>> entrySet() {
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
        public Set<Long> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        @Override // io.netty.util.collection.LongObjectMap
        public V put(long j6, V v5) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends V> map) {
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

        UnmodifiableMap(LongObjectMap<V> longObjectMap) {
            this.map = longObjectMap;
        }

        /* renamed from: put, reason: avoid collision after fix types in other method */
        public V put2(Long l6, V v5) {
            throw new UnsupportedOperationException("put");
        }
    }

    public static <V> LongObjectMap<V> emptyMap() {
        return (LongObjectMap<V>) EMPTY_MAP;
    }

    public static <V> LongObjectMap<V> unmodifiableMap(LongObjectMap<V> longObjectMap) {
        return new UnmodifiableMap(longObjectMap);
    }

    private LongCollections() {
    }
}
