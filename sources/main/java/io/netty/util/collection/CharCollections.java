package io.netty.util.collection;

import io.netty.util.collection.CharObjectMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class CharCollections {
    private static final CharObjectMap<Object> EMPTY_MAP = new EmptyMap(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.util.collection.CharCollections$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class EmptyMap implements CharObjectMap<Object> {
        private EmptyMap() {
        }

        @Override // io.netty.util.collection.CharObjectMap
        public boolean containsKey(char c6) {
            return false;
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return false;
        }

        @Override // io.netty.util.collection.CharObjectMap
        public Object get(char c6) {
            return null;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // io.netty.util.collection.CharObjectMap
        public Object remove(char c6) {
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

        @Override // io.netty.util.collection.CharObjectMap
        public Iterable<CharObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Character, Object>> entrySet() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.Map
        public Object get(Object obj) {
            return null;
        }

        @Override // java.util.Map
        public Set<Character> keySet() {
            return Collections.EMPTY_SET;
        }

        @Override // io.netty.util.collection.CharObjectMap
        public Object put(char c6, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ?> map) {
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
        public Object put(Character ch, Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void clear() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class UnmodifiableMap<V> implements CharObjectMap<V> {
        private Iterable<CharObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Character, V>> entrySet;
        private Set<Character> keySet;
        private final CharObjectMap<V> map;
        private Collection<V> values;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class EntryImpl implements CharObjectMap.PrimitiveEntry<V> {
            private final CharObjectMap.PrimitiveEntry<V> entry;

            EntryImpl(CharObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
            public char key() {
                return this.entry.key();
            }

            @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
            public void setValue(V v5) {
                throw new UnsupportedOperationException("setValue");
            }

            @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class IteratorImpl implements Iterator<CharObjectMap.PrimitiveEntry<V>> {
            final Iterator<CharObjectMap.PrimitiveEntry<V>> iter;

            IteratorImpl(Iterator<CharObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public CharObjectMap.PrimitiveEntry<V> next() {
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

        @Override // io.netty.util.collection.CharObjectMap
        public boolean containsKey(char c6) {
            return this.map.containsKey(c6);
        }

        @Override // io.netty.util.collection.CharObjectMap
        public V get(char c6) {
            return this.map.get(c6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public /* bridge */ /* synthetic */ Object put(Character ch, Object obj) {
            return put2(ch, (Character) obj);
        }

        @Override // io.netty.util.collection.CharObjectMap
        public V remove(char c6) {
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

        @Override // io.netty.util.collection.CharObjectMap
        public Iterable<CharObjectMap.PrimitiveEntry<V>> entries() {
            if (this.entries == null) {
                this.entries = new Iterable<CharObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.CharCollections.UnmodifiableMap.1
                    @Override // java.lang.Iterable
                    public Iterator<CharObjectMap.PrimitiveEntry<V>> iterator() {
                        UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                        return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                    }
                };
            }
            return this.entries;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Character, V>> entrySet() {
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
        public Set<Character> keySet() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.map.keySet());
            }
            return this.keySet;
        }

        @Override // io.netty.util.collection.CharObjectMap
        public V put(char c6, V v5) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ? extends V> map) {
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

        UnmodifiableMap(CharObjectMap<V> charObjectMap) {
            this.map = charObjectMap;
        }

        /* renamed from: put, reason: avoid collision after fix types in other method */
        public V put2(Character ch, V v5) {
            throw new UnsupportedOperationException("put");
        }
    }

    public static <V> CharObjectMap<V> emptyMap() {
        return (CharObjectMap<V>) EMPTY_MAP;
    }

    public static <V> CharObjectMap<V> unmodifiableMap(CharObjectMap<V> charObjectMap) {
        return new UnmodifiableMap(charObjectMap);
    }

    private CharCollections() {
    }
}
