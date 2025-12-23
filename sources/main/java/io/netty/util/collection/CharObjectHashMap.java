package io.netty.util.collection;

import io.netty.util.collection.CharObjectMap;
import io.netty.util.internal.MathUtil;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CharObjectHashMap<V> implements CharObjectMap<V> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_CAPACITY = 8;
    public static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final Object NULL_VALUE = new Object();
    private final Iterable<CharObjectMap.PrimitiveEntry<V>> entries;
    private final Set<Map.Entry<Character, V>> entrySet;
    private final Set<Character> keySet;
    private char[] keys;
    private final float loadFactor;
    private int mask;
    private int maxSize;
    private int size;
    private V[] values;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class EntrySet extends AbstractSet<Map.Entry<Character, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Character, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CharObjectHashMap.this.size();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class KeySet extends AbstractSet<Character> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CharObjectHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CharObjectHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Character> iterator() {
            return new Iterator<Character>() { // from class: io.netty.util.collection.CharObjectHashMap.KeySet.1
                private final Iterator<Map.Entry<Character, V>> iter;

                {
                    this.iter = CharObjectHashMap.this.entrySet.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.iter.hasNext();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.Iterator
                public Character next() {
                    return this.iter.next().getKey();
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.iter.remove();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return CharObjectHashMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            Iterator<CharObjectMap.PrimitiveEntry<V>> it = CharObjectHashMap.this.entries().iterator();
            boolean z5 = false;
            while (it.hasNext()) {
                if (!collection.contains(Character.valueOf(it.next().key()))) {
                    it.remove();
                    z5 = true;
                }
            }
            return z5;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CharObjectHashMap.this.size();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class MapEntry implements Map.Entry<Character, V> {
        private final int entryIndex;

        MapEntry(int i6) {
            this.entryIndex = i6;
        }

        private void verifyExists() {
            if (CharObjectHashMap.this.values[this.entryIndex] == null) {
                throw new IllegalStateException("The map entry has been removed");
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public Character getKey() {
            verifyExists();
            return Character.valueOf(CharObjectHashMap.this.keys[this.entryIndex]);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            verifyExists();
            return (V) CharObjectHashMap.toExternal(CharObjectHashMap.this.values[this.entryIndex]);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            verifyExists();
            V v6 = (V) CharObjectHashMap.toExternal(CharObjectHashMap.this.values[this.entryIndex]);
            CharObjectHashMap.this.values[this.entryIndex] = CharObjectHashMap.toInternal(v5);
            return v6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class MapIterator implements Iterator<Map.Entry<Character, V>> {
        private final CharObjectHashMap<V>.PrimitiveIterator iter;

        private MapIterator() {
            this.iter = new PrimitiveIterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<Character, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.iter.next();
            return new MapEntry(((PrimitiveIterator) this.iter).entryIndex);
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iter.remove();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class PrimitiveIterator implements Iterator<CharObjectMap.PrimitiveEntry<V>>, CharObjectMap.PrimitiveEntry<V> {
        private int entryIndex;
        private int nextIndex;
        private int prevIndex;

        private PrimitiveIterator() {
            this.prevIndex = -1;
            this.nextIndex = -1;
            this.entryIndex = -1;
        }

        private void scanNext() {
            do {
                int i6 = this.nextIndex + 1;
                this.nextIndex = i6;
                if (i6 == CharObjectHashMap.this.values.length) {
                    return;
                }
            } while (CharObjectHashMap.this.values[this.nextIndex] == null);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextIndex == -1) {
                scanNext();
            }
            return this.nextIndex != CharObjectHashMap.this.values.length;
        }

        @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
        public char key() {
            return CharObjectHashMap.this.keys[this.entryIndex];
        }

        @Override // java.util.Iterator
        public CharObjectMap.PrimitiveEntry<V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.prevIndex = this.nextIndex;
            scanNext();
            this.entryIndex = this.prevIndex;
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i6 = this.prevIndex;
            if (i6 == -1) {
                throw new IllegalStateException("next must be called before each remove.");
            }
            if (CharObjectHashMap.this.removeAt(i6)) {
                this.nextIndex = this.prevIndex;
            }
            this.prevIndex = -1;
        }

        @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
        public void setValue(V v5) {
            CharObjectHashMap.this.values[this.entryIndex] = CharObjectHashMap.toInternal(v5);
        }

        @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
        public V value() {
            return (V) CharObjectHashMap.toExternal(CharObjectHashMap.this.values[this.entryIndex]);
        }
    }

    public CharObjectHashMap() {
        this(8, 0.5f);
    }

    private static int hashCode(char c6) {
        return c6;
    }

    @Override // io.netty.util.collection.CharObjectMap
    public boolean containsKey(char c6) {
        return indexOf(c6) >= 0;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CharObjectMap)) {
            return false;
        }
        CharObjectMap charObjectMap = (CharObjectMap) obj;
        if (this.size != charObjectMap.size()) {
            return false;
        }
        int i6 = 0;
        while (true) {
            V[] vArr = this.values;
            if (i6 >= vArr.length) {
                return true;
            }
            V v5 = vArr[i6];
            if (v5 != null) {
                Object obj2 = charObjectMap.get(this.keys[i6]);
                if (v5 == NULL_VALUE) {
                    if (obj2 != null) {
                        return false;
                    }
                } else if (!v5.equals(obj2)) {
                    return false;
                }
            }
            i6++;
        }
    }

    @Override // io.netty.util.collection.CharObjectMap
    public V get(char c6) {
        int indexOf = indexOf(c6);
        if (indexOf == -1) {
            return null;
        }
        return (V) toExternal(this.values[indexOf]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Character ch, Object obj) {
        return put2(ch, (Character) obj);
    }

    @Override // io.netty.util.collection.CharObjectMap
    public V remove(char c6) {
        int indexOf = indexOf(c6);
        if (indexOf == -1) {
            return null;
        }
        V v5 = this.values[indexOf];
        removeAt(indexOf);
        return (V) toExternal(v5);
    }

    public CharObjectHashMap(int i6) {
        this(i6, 0.5f);
    }

    private int calcMaxSize(int i6) {
        return Math.min(i6 - 1, (int) (i6 * this.loadFactor));
    }

    private void growSize() {
        int i6 = this.size + 1;
        this.size = i6;
        if (i6 > this.maxSize) {
            char[] cArr = this.keys;
            if (cArr.length != Integer.MAX_VALUE) {
                rehash(cArr.length << 1);
                return;
            }
            throw new IllegalStateException("Max capacity reached at size=" + this.size);
        }
    }

    private char objectToKey(Object obj) {
        return ((Character) obj).charValue();
    }

    private int probeNext(int i6) {
        return (i6 + 1) & this.mask;
    }

    private void rehash(int i6) {
        V[] vArr;
        char[] cArr = this.keys;
        V[] vArr2 = this.values;
        this.keys = new char[i6];
        this.values = (V[]) new Object[i6];
        this.maxSize = calcMaxSize(i6);
        this.mask = i6 - 1;
        for (int i7 = 0; i7 < vArr2.length; i7++) {
            V v5 = vArr2[i7];
            if (v5 != null) {
                char c6 = cArr[i7];
                int hashIndex = hashIndex(c6);
                while (true) {
                    vArr = this.values;
                    if (vArr[hashIndex] == null) {
                        break;
                    } else {
                        hashIndex = probeNext(hashIndex);
                    }
                }
                this.keys[hashIndex] = c6;
                vArr[hashIndex] = v5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeAt(int i6) {
        this.size--;
        this.keys[i6] = 0;
        this.values[i6] = null;
        int probeNext = probeNext(i6);
        V v5 = this.values[probeNext];
        int i7 = i6;
        while (v5 != null) {
            char c6 = this.keys[probeNext];
            int hashIndex = hashIndex(c6);
            if ((probeNext < hashIndex && (hashIndex <= i7 || i7 <= probeNext)) || (hashIndex <= i7 && i7 <= probeNext)) {
                char[] cArr = this.keys;
                cArr[i7] = c6;
                V[] vArr = this.values;
                vArr[i7] = v5;
                cArr[probeNext] = 0;
                vArr[probeNext] = null;
                i7 = probeNext;
            }
            V[] vArr2 = this.values;
            probeNext = probeNext(probeNext);
            v5 = vArr2[probeNext];
        }
        return i7 != i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T toExternal(T t5) {
        if (t5 == NULL_VALUE) {
            return null;
        }
        return t5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T toInternal(T t5) {
        return t5 == null ? (T) NULL_VALUE : t5;
    }

    @Override // java.util.Map
    public void clear() {
        Arrays.fill(this.keys, (char) 0);
        Arrays.fill(this.values, (Object) null);
        this.size = 0;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return containsKey(objectToKey(obj));
    }

    @Override // io.netty.util.collection.CharObjectMap
    public Iterable<CharObjectMap.PrimitiveEntry<V>> entries() {
        return this.entries;
    }

    @Override // java.util.Map
    public Set<Map.Entry<Character, V>> entrySet() {
        return this.entrySet;
    }

    @Override // java.util.Map
    public int hashCode() {
        int i6 = this.size;
        for (char c6 : this.keys) {
            i6 ^= hashCode(c6);
        }
        return i6;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.Map
    public Set<Character> keySet() {
        return this.keySet;
    }

    @Override // io.netty.util.collection.CharObjectMap
    public V put(char c6, V v5) {
        int hashIndex = hashIndex(c6);
        int i6 = hashIndex;
        do {
            Object[] objArr = this.values;
            Object obj = objArr[i6];
            if (obj == null) {
                this.keys[i6] = c6;
                objArr[i6] = toInternal(v5);
                growSize();
                return null;
            }
            if (this.keys[i6] == c6) {
                objArr[i6] = toInternal(v5);
                return (V) toExternal(obj);
            }
            i6 = probeNext(i6);
        } while (i6 != hashIndex);
        throw new IllegalStateException("Unable to insert");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Character, ? extends V> map) {
        if (!(map instanceof CharObjectHashMap)) {
            for (Map.Entry<? extends Character, ? extends V> entry : map.entrySet()) {
                put2(entry.getKey(), (Character) entry.getValue());
            }
            return;
        }
        CharObjectHashMap charObjectHashMap = (CharObjectHashMap) map;
        int i6 = 0;
        while (true) {
            V[] vArr = charObjectHashMap.values;
            if (i6 >= vArr.length) {
                return;
            }
            V v5 = vArr[i6];
            if (v5 != null) {
                put(charObjectHashMap.keys[i6], (char) v5);
            }
            i6++;
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return new AbstractCollection<V>() { // from class: io.netty.util.collection.CharObjectHashMap.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<V> iterator() {
                return new Iterator<V>() { // from class: io.netty.util.collection.CharObjectHashMap.2.1
                    final CharObjectHashMap<V>.PrimitiveIterator iter;

                    {
                        this.iter = new PrimitiveIterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.iter.hasNext();
                    }

                    @Override // java.util.Iterator
                    public V next() {
                        return this.iter.next().value();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        this.iter.remove();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return CharObjectHashMap.this.size;
            }
        };
    }

    public CharObjectHashMap(int i6, float f6) {
        this.keySet = new KeySet();
        this.entrySet = new EntrySet();
        this.entries = new Iterable<CharObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.CharObjectHashMap.1
            @Override // java.lang.Iterable
            public Iterator<CharObjectMap.PrimitiveEntry<V>> iterator() {
                return new PrimitiveIterator();
            }
        };
        if (f6 > 0.0f && f6 <= 1.0f) {
            this.loadFactor = f6;
            int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(i6);
            this.mask = safeFindNextPositivePowerOfTwo - 1;
            this.keys = new char[safeFindNextPositivePowerOfTwo];
            this.values = (V[]) new Object[safeFindNextPositivePowerOfTwo];
            this.maxSize = calcMaxSize(safeFindNextPositivePowerOfTwo);
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and <= 1");
    }

    private int hashIndex(char c6) {
        return hashCode(c6) & this.mask;
    }

    private int indexOf(char c6) {
        int hashIndex = hashIndex(c6);
        int i6 = hashIndex;
        while (this.values[i6] != null) {
            if (c6 == this.keys[i6]) {
                return i6;
            }
            i6 = probeNext(i6);
            if (i6 == hashIndex) {
                return -1;
            }
        }
        return -1;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Object internal = toInternal(obj);
        for (V v5 : this.values) {
            if (v5 != null && v5.equals(internal)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return get(objectToKey(obj));
    }

    protected String keyToString(char c6) {
        return Character.toString(c6);
    }

    public String toString() {
        Object external;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 4);
        sb.append('{');
        boolean z5 = true;
        int i6 = 0;
        while (true) {
            V[] vArr = this.values;
            if (i6 < vArr.length) {
                V v5 = vArr[i6];
                if (v5 != null) {
                    if (!z5) {
                        sb.append(", ");
                    }
                    sb.append(keyToString(this.keys[i6]));
                    sb.append('=');
                    if (v5 == this) {
                        external = "(this Map)";
                    } else {
                        external = toExternal(v5);
                    }
                    sb.append(external);
                    z5 = false;
                }
                i6++;
            } else {
                sb.append('}');
                return sb.toString();
            }
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return remove(objectToKey(obj));
    }

    /* renamed from: put, reason: avoid collision after fix types in other method */
    public V put2(Character ch, V v5) {
        return put(objectToKey(ch), (char) v5);
    }
}
