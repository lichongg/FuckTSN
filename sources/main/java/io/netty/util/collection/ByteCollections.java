package io.netty.util.collection;

import io.netty.util.collection.ByteObjectMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ByteCollections {
    private static final ByteObjectMap<Object> EMPTY_MAP = new EmptyMap(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.util.collection.ByteCollections$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class EmptyMap implements ByteObjectMap<Object> {
        private EmptyMap() {
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public boolean containsKey(byte b6) {
            return false;
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return false;
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public Object get(byte b6) {
            return null;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public Object remove(byte b6) {
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

        @Override // io.netty.util.collection.ByteObjectMap
        public Iterable<ByteObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Byte, Object>> entrySet() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.Map
        public Object get(Object obj) {
            return null;
        }

        @Override // java.util.Map
        public Set<Byte> keySet() {
            return Collections.EMPTY_SET;
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public Object put(byte b6, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ?> map) {
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
        public Object put(Byte b6, Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void clear() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class UnmodifiableMap<V> implements ByteObjectMap<V> {
        private Iterable<ByteObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Byte, V>> entrySet;
        private Set<Byte> keySet;
        private final ByteObjectMap<V> map;
        private Collection<V> values;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class EntryImpl implements ByteObjectMap.PrimitiveEntry<V> {
            private final ByteObjectMap.PrimitiveEntry<V> entry;

            EntryImpl(ByteObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            @Override // io.netty.util.collection.ByteObjectMap.PrimitiveEntry
            public byte key() {
                return this.entry.key();
            }

            @Override // io.netty.util.collection.ByteObjectMap.PrimitiveEntry
            public void setValue(V v5) {
                throw new UnsupportedOperationException("setValue");
            }

            @Override // io.netty.util.collection.ByteObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class IteratorImpl implements Iterator<ByteObjectMap.PrimitiveEntry<V>> {
            final Iterator<ByteObjectMap.PrimitiveEntry<V>> iter;

            IteratorImpl(Iterator<ByteObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public ByteObjectMap.PrimitiveEntry<V> next() {
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

        @Override // io.netty.util.collection.ByteObjectMap
        public boolean containsKey(byte b6) {
            return this.map.containsKey(b6);
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public V get(byte b6) {
            return this.map.get(b6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Object put(Byte b6, Object obj) {
            return put2(b6, (Byte) obj);
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public V remove(byte b6) {
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

        @Override // io.netty.util.collection.ByteObjectMap
        public Iterable<ByteObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<ByteObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.ByteCollections.UnmodifiableMap.1
                    @Override // java.lang.Iterable
                    public Iterator<ByteObjectMap.PrimitiveEntry<V>> iterator() {
                        UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                        return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Byte, V>> entrySet() {
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
        public Set<Byte> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        @Override // io.netty.util.collection.ByteObjectMap
        public V put(byte b6, V v5) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Byte, ? extends V> map) {
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

        UnmodifiableMap(ByteObjectMap<V> byteObjectMap) {
            this.map = byteObjectMap;
        }

        /* renamed from: put, reason: avoid collision after fix types in other method */
        public V put2(Byte b6, V v5) {
            throw new UnsupportedOperationException("put");
        }
    }

    public static <V> ByteObjectMap<V> emptyMap() {
        return (ByteObjectMap<V>) EMPTY_MAP;
    }

    public static <V> ByteObjectMap<V> unmodifiableMap(ByteObjectMap<V> byteObjectMap) {
        return new UnmodifiableMap(byteObjectMap);
    }

    private ByteCollections() {
    }
}
