package io.netty.util.collection;

import io.netty.util.collection.IntObjectMap;
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
public class IntObjectHashMap<V> implements IntObjectMap<V> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_CAPACITY = 8;
    public static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final Object NULL_VALUE = new Object();
    private final Iterable<IntObjectMap.PrimitiveEntry<V>> entries;
    private final Set<Map.Entry<Integer, V>> entrySet;
    private final Set<Integer> keySet;
    private int[] keys;
    private final float loadFactor;
    private int mask;
    private int maxSize;
    private int size;
    private V[] values;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class EntrySet extends AbstractSet<Map.Entry<Integer, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Integer, V>> iterator() {
            return new MapIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IntObjectHashMap.this.size();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class KeySet extends AbstractSet<Integer> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            IntObjectHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return IntObjectHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() { // from class: io.netty.util.collection.IntObjectHashMap.KeySet.1
                private final Iterator<Map.Entry<Integer, V>> iter;

                {
                    this.iter = IntObjectHashMap.this.entrySet.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.iter.hasNext();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.Iterator
                public Integer next() {
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
            return IntObjectHashMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            Iterator<IntObjectMap.PrimitiveEntry<V>> it = IntObjectHashMap.this.entries().iterator();
            boolean z5 = false;
            while (it.hasNext()) {
                if (!collection.contains(Integer.valueOf(it.next().key()))) {
                    it.remove();
                    z5 = true;
                }
            }
            return z5;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IntObjectHashMap.this.size();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class MapEntry implements Map.Entry<Integer, V> {
        private final int entryIndex;

        MapEntry(int i6) {
            this.entryIndex = i6;
        }

        private void verifyExists() {
            if (IntObjectHashMap.this.values[this.entryIndex] == null) {
                throw new IllegalStateException("The map entry has been removed");
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public Integer getKey() {
            verifyExists();
            return Integer.valueOf(IntObjectHashMap.this.keys[this.entryIndex]);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            verifyExists();
            return (V) IntObjectHashMap.toExternal(IntObjectHashMap.this.values[this.entryIndex]);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            verifyExists();
            V v6 = (V) IntObjectHashMap.toExternal(IntObjectHashMap.this.values[this.entryIndex]);
            IntObjectHashMap.this.values[this.entryIndex] = IntObjectHashMap.toInternal(v5);
            return v6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class MapIterator implements Iterator<Map.Entry<Integer, V>> {
        private final IntObjectHashMap<V>.PrimitiveIterator iter;

        private MapIterator() {
            this.iter = new PrimitiveIterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<Integer, V> next() {
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
    private final class PrimitiveIterator implements Iterator<IntObjectMap.PrimitiveEntry<V>>, IntObjectMap.PrimitiveEntry<V> {
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
                if (i6 == IntObjectHashMap.this.values.length) {
                    return;
                }
            } while (IntObjectHashMap.this.values[this.nextIndex] == null);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextIndex == -1) {
                scanNext();
            }
            return this.nextIndex != IntObjectHashMap.this.values.length;
        }

        @Override // io.netty.util.collection.IntObjectMap.PrimitiveEntry
        public int key() {
            return IntObjectHashMap.this.keys[this.entryIndex];
        }

        @Override // java.util.Iterator
        public IntObjectMap.PrimitiveEntry<V> next() {
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
            if (IntObjectHashMap.this.removeAt(i6)) {
                this.nextIndex = this.prevIndex;
            }
            this.prevIndex = -1;
        }

        @Override // io.netty.util.collection.IntObjectMap.PrimitiveEntry
        public void setValue(V v5) {
            IntObjectHashMap.this.values[this.entryIndex] = IntObjectHashMap.toInternal(v5);
        }

        @Override // io.netty.util.collection.IntObjectMap.PrimitiveEntry
        public V value() {
            return (V) IntObjectHashMap.toExternal(IntObjectHashMap.this.values[this.entryIndex]);
        }
    }

    public IntObjectHashMap() {
        this(8, 0.5f);
    }

    private static int hashCode(int i6) {
        return i6;
    }

    @Override // io.netty.util.collection.IntObjectMap
    public boolean containsKey(int i6) {
        return indexOf(i6) >= 0;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntObjectMap)) {
            return false;
        }
        IntObjectMap intObjectMap = (IntObjectMap) obj;
        if (this.size != intObjectMap.size()) {
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
                Object obj2 = intObjectMap.get(this.keys[i6]);
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

    @Override // io.netty.util.collection.IntObjectMap
    public V get(int i6) {
        int indexOf = indexOf(i6);
        if (indexOf == -1) {
            return null;
        }
        return (V) toExternal(this.values[indexOf]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Integer num, Object obj) {
        return put2(num, (Integer) obj);
    }

    @Override // io.netty.util.collection.IntObjectMap
    public V remove(int i6) {
        int indexOf = indexOf(i6);
        if (indexOf == -1) {
            return null;
        }
        V v5 = this.values[indexOf];
        removeAt(indexOf);
        return (V) toExternal(v5);
    }

    public IntObjectHashMap(int i6) {
        this(i6, 0.5f);
    }

    private int calcMaxSize(int i6) {
        return Math.min(i6 - 1, (int) (i6 * this.loadFactor));
    }

    private void growSize() {
        int i6 = this.size + 1;
        this.size = i6;
        if (i6 > this.maxSize) {
            int[] iArr = this.keys;
            if (iArr.length != Integer.MAX_VALUE) {
                rehash(iArr.length << 1);
                return;
            }
            throw new IllegalStateException("Max capacity reached at size=" + this.size);
        }
    }

    private int objectToKey(Object obj) {
        return ((Integer) obj).intValue();
    }

    private int probeNext(int i6) {
        return (i6 + 1) & this.mask;
    }

    private void rehash(int i6) {
        V[] vArr;
        int[] iArr = this.keys;
        V[] vArr2 = this.values;
        this.keys = new int[i6];
        this.values = (V[]) new Object[i6];
        this.maxSize = calcMaxSize(i6);
        this.mask = i6 - 1;
        for (int i7 = 0; i7 < vArr2.length; i7++) {
            V v5 = vArr2[i7];
            if (v5 != null) {
                int i8 = iArr[i7];
                int hashIndex = hashIndex(i8);
                while (true) {
                    vArr = this.values;
                    if (vArr[hashIndex] == null) {
                        break;
                    } else {
                        hashIndex = probeNext(hashIndex);
                    }
                }
                this.keys[hashIndex] = i8;
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
            int i8 = this.keys[probeNext];
            int hashIndex = hashIndex(i8);
            if ((probeNext < hashIndex && (hashIndex <= i7 || i7 <= probeNext)) || (hashIndex <= i7 && i7 <= probeNext)) {
                int[] iArr = this.keys;
                iArr[i7] = i8;
                V[] vArr = this.values;
                vArr[i7] = v5;
                iArr[probeNext] = 0;
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
        Arrays.fill(this.keys, 0);
        Arrays.fill(this.values, (Object) null);
        this.size = 0;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return containsKey(objectToKey(obj));
    }

    @Override // io.netty.util.collection.IntObjectMap
    public Iterable<IntObjectMap.PrimitiveEntry<V>> entries() {
        return this.entries;
    }

    @Override // java.util.Map
    public Set<Map.Entry<Integer, V>> entrySet() {
        return this.entrySet;
    }

    @Override // java.util.Map
    public int hashCode() {
        int i6 = this.size;
        for (int i7 : this.keys) {
            i6 ^= hashCode(i7);
        }
        return i6;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.Map
    public Set<Integer> keySet() {
        return this.keySet;
    }

    @Override // io.netty.util.collection.IntObjectMap
    public V put(int i6, V v5) {
        int hashIndex = hashIndex(i6);
        int i7 = hashIndex;
        do {
            Object[] objArr = this.values;
            Object obj = objArr[i7];
            if (obj == null) {
                this.keys[i7] = i6;
                objArr[i7] = toInternal(v5);
                growSize();
                return null;
            }
            if (this.keys[i7] == i6) {
                objArr[i7] = toInternal(v5);
                return (V) toExternal(obj);
            }
            i7 = probeNext(i7);
        } while (i7 != hashIndex);
        throw new IllegalStateException("Unable to insert");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Integer, ? extends V> map) {
        if (!(map instanceof IntObjectHashMap)) {
            for (Map.Entry<? extends Integer, ? extends V> entry : map.entrySet()) {
                put2(entry.getKey(), (Integer) entry.getValue());
            }
            return;
        }
        IntObjectHashMap intObjectHashMap = (IntObjectHashMap) map;
        int i6 = 0;
        while (true) {
            V[] vArr = intObjectHashMap.values;
            if (i6 >= vArr.length) {
                return;
            }
            V v5 = vArr[i6];
            if (v5 != null) {
                put(intObjectHashMap.keys[i6], (int) v5);
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
        return new AbstractCollection<V>() { // from class: io.netty.util.collection.IntObjectHashMap.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<V> iterator() {
                return new Iterator<V>() { // from class: io.netty.util.collection.IntObjectHashMap.2.1
                    final IntObjectHashMap<V>.PrimitiveIterator iter;

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
                return IntObjectHashMap.this.size;
            }
        };
    }

    public IntObjectHashMap(int i6, float f6) {
        this.keySet = new KeySet();
        this.entrySet = new EntrySet();
        this.entries = new Iterable<IntObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.IntObjectHashMap.1
            @Override // java.lang.Iterable
            public Iterator<IntObjectMap.PrimitiveEntry<V>> iterator() {
                return new PrimitiveIterator();
            }
        };
        if (f6 > 0.0f && f6 <= 1.0f) {
            this.loadFactor = f6;
            int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(i6);
            this.mask = safeFindNextPositivePowerOfTwo - 1;
            this.keys = new int[safeFindNextPositivePowerOfTwo];
            this.values = (V[]) new Object[safeFindNextPositivePowerOfTwo];
            this.maxSize = calcMaxSize(safeFindNextPositivePowerOfTwo);
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and <= 1");
    }

    private int hashIndex(int i6) {
        return hashCode(i6) & this.mask;
    }

    private int indexOf(int i6) {
        int hashIndex = hashIndex(i6);
        int i7 = hashIndex;
        while (this.values[i7] != null) {
            if (i6 == this.keys[i7]) {
                return i7;
            }
            i7 = probeNext(i7);
            if (i7 == hashIndex) {
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

    protected String keyToString(int i6) {
        return Integer.toString(i6);
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
    public V put2(Integer num, V v5) {
        return put(objectToKey(num), (int) v5);
    }
}
