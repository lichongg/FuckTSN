package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final float DEFAULT_LOAD_FACTOR = 1.0f;
    static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient long[] entries;

    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> entrySetView;

    @MonotonicNonNullDecl
    private transient Set<K> keySetView;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient Object[] keys;
    transient float loadFactor;
    transient int modCount;
    private transient int size;

    @MonotonicNonNullDecl
    private transient int[] table;
    private transient int threshold;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient Object[] values;

    @MonotonicNonNullDecl
    private transient Collection<V> valuesView;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        EntrySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int indexOf = CompactHashMap.this.indexOf(entry.getKey());
                if (indexOf != -1 && Objects.equal(CompactHashMap.this.values[indexOf], entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int indexOf = CompactHashMap.this.indexOf(entry.getKey());
            if (indexOf == -1 || !Objects.equal(CompactHashMap.this.values[indexOf], entry.getValue())) {
                return false;
            }
            CompactHashMap.this.removeEntry(indexOf);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private abstract class Itr<T> implements Iterator<T> {
        int currentIndex;
        int expectedModCount;
        int indexToRemove;

        private Itr() {
            this.expectedModCount = CompactHashMap.this.modCount;
            this.currentIndex = CompactHashMap.this.firstEntryIndex();
            this.indexToRemove = -1;
        }

        abstract T getOutput(int i6);

        private void checkForConcurrentModification() {
            if (CompactHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.currentIndex >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            checkForConcurrentModification();
            if (hasNext()) {
                int i6 = this.currentIndex;
                this.indexToRemove = i6;
                T output = getOutput(i6);
                this.currentIndex = CompactHashMap.this.getSuccessor(this.currentIndex);
                return output;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z5;
            checkForConcurrentModification();
            if (this.indexToRemove >= 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            CollectPreconditions.checkRemove(z5);
            this.expectedModCount++;
            CompactHashMap.this.removeEntry(this.indexToRemove);
            this.currentIndex = CompactHashMap.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
            this.indexToRemove = -1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class KeySetView extends AbstractSet<K> {
        KeySetView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int indexOf = CompactHashMap.this.indexOf(obj);
            if (indexOf == -1) {
                return false;
            }
            CompactHashMap.this.removeEntry(indexOf);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class MapEntry extends AbstractMapEntry<K, V> {

        @NullableDecl
        private final K key;
        private int lastKnownIndex;

        MapEntry(int i6) {
            this.key = (K) CompactHashMap.this.keys[i6];
            this.lastKnownIndex = i6;
        }

        private void updateLastKnownIndex() {
            int i6 = this.lastKnownIndex;
            if (i6 == -1 || i6 >= CompactHashMap.this.size() || !Objects.equal(this.key, CompactHashMap.this.keys[this.lastKnownIndex])) {
                this.lastKnownIndex = CompactHashMap.this.indexOf(this.key);
            }
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            updateLastKnownIndex();
            int i6 = this.lastKnownIndex;
            if (i6 == -1) {
                return null;
            }
            return (V) CompactHashMap.this.values[i6];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V v5) {
            updateLastKnownIndex();
            int i6 = this.lastKnownIndex;
            if (i6 == -1) {
                CompactHashMap.this.put(this.key, v5);
                return null;
            }
            Object[] objArr = CompactHashMap.this.values;
            V v6 = (V) objArr[i6];
            objArr[i6] = v5;
            return v6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class ValuesView extends AbstractCollection<V> {
        ValuesView() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size;
        }
    }

    CompactHashMap() {
        init(3, 1.0f);
    }

    private static int getNext(long j6) {
        return (int) j6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        for (int i6 = 0; i6 < this.size; i6++) {
            if (Objects.equal(obj, this.values[i6])) {
                return true;
            }
        }
        return false;
    }

    void init(int i6, float f6) {
        Preconditions.checkArgument(i6 >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(f6 > 0.0f, "Illegal load factor");
        int closedTableSize = Hashing.closedTableSize(i6, f6);
        this.table = newTable(closedTableSize);
        this.loadFactor = f6;
        this.keys = new Object[i6];
        this.values = new Object[i6];
        this.entries = newEntries(i6);
        this.threshold = Math.max(1, (int) (closedTableSize * f6));
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        return remove(obj, Hashing.smearedHash(obj));
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i6) {
        return new CompactHashMap<>(i6);
    }

    private static int getHash(long j6) {
        return (int) (j6 >>> 32);
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    private static long[] newEntries(int i6) {
        long[] jArr = new long[i6];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] newTable(int i6) {
        int[] iArr = new int[i6];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    @NullableDecl
    private V remove(@NullableDecl Object obj, int i6) {
        int hashTableMask = hashTableMask() & i6;
        int i7 = this.table[hashTableMask];
        if (i7 == -1) {
            return null;
        }
        int i8 = -1;
        while (true) {
            if (getHash(this.entries[i7]) == i6 && Objects.equal(obj, this.keys[i7])) {
                V v5 = (V) this.values[i7];
                if (i8 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i7]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i8] = swapNext(jArr[i8], getNext(jArr[i7]));
                }
                moveLastEntry(i7);
                this.size--;
                this.modCount++;
                return v5;
            }
            int next = getNext(this.entries[i7]);
            if (next == -1) {
                return null;
            }
            i8 = i7;
            i7 = next;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public V removeEntry(int i6) {
        return remove(this.keys[i6], getHash(this.entries[i6]));
    }

    private void resizeMeMaybe(int i6) {
        int length = this.entries.length;
        if (i6 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                resizeEntries(max);
            }
        }
    }

    private void resizeTable(int i6) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i7 = ((int) (i6 * this.loadFactor)) + 1;
        int[] newTable = newTable(i6);
        long[] jArr = this.entries;
        int length = newTable.length - 1;
        for (int i8 = 0; i8 < this.size; i8++) {
            int hash = getHash(jArr[i8]);
            int i9 = hash & length;
            int i10 = newTable[i9];
            newTable[i9] = i8;
            jArr[i8] = (hash << 32) | (4294967295L & i10);
        }
        this.threshold = i7;
        this.table = newTable;
    }

    int adjustAfterRemove(int i6, int i7) {
        return i6 - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    Set<Map.Entry<K, V>> createEntrySet() {
        return new EntrySetView();
    }

    Set<K> createKeySet() {
        return new KeySetView();
    }

    Collection<V> createValues() {
        return new ValuesView();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySetView = createEntrySet;
        return createEntrySet;
    }

    Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() { // from class: com.google.common.collect.CompactHashMap.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.CompactHashMap.Itr
            public Map.Entry<K, V> getOutput(int i6) {
                return new MapEntry(i6);
            }
        };
    }

    int getSuccessor(int i6) {
        int i7 = i6 + 1;
        if (i7 < this.size) {
            return i7;
        }
        return -1;
    }

    void insertEntry(int i6, @NullableDecl K k6, @NullableDecl V v5, int i7) {
        this.entries[i6] = (i7 << 32) | 4294967295L;
        this.keys[i6] = k6;
        this.values[i6] = v5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.keySetView = createKeySet;
        return createKeySet;
    }

    Iterator<K> keySetIterator() {
        return new CompactHashMap<K, V>.Itr<K>() { // from class: com.google.common.collect.CompactHashMap.1
            @Override // com.google.common.collect.CompactHashMap.Itr
            K getOutput(int i6) {
                return (K) CompactHashMap.this.keys[i6];
            }
        };
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V put(@NullableDecl K k6, @NullableDecl V v5) {
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int smearedHash = Hashing.smearedHash(k6);
        int hashTableMask = hashTableMask() & smearedHash;
        int i6 = this.size;
        int[] iArr = this.table;
        int i7 = iArr[hashTableMask];
        if (i7 == -1) {
            iArr[hashTableMask] = i6;
        } else {
            while (true) {
                long j6 = jArr[i7];
                if (getHash(j6) == smearedHash && Objects.equal(k6, objArr[i7])) {
                    V v6 = (V) objArr2[i7];
                    objArr2[i7] = v5;
                    accessEntry(i7);
                    return v6;
                }
                int next = getNext(j6);
                if (next == -1) {
                    jArr[i7] = swapNext(j6, i6);
                    break;
                }
                i7 = next;
            }
        }
        if (i6 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i8 = i6 + 1;
        resizeMeMaybe(i8);
        insertEntry(i6, k6, v5, smearedHash);
        this.size = i8;
        if (i6 >= this.threshold) {
            resizeTable(this.table.length * 2);
        }
        this.modCount++;
        return null;
    }

    void resizeEntries(int i6) {
        this.keys = Arrays.copyOf(this.keys, i6);
        this.values = Arrays.copyOf(this.values, i6);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i6);
        if (i6 > length) {
            Arrays.fill(copyOf, length, i6, -1L);
        }
        this.entries = copyOf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public void trimToSize() {
        int i6 = this.size;
        if (i6 < this.entries.length) {
            resizeEntries(i6);
        }
        int max = Math.max(1, Integer.highestOneBit((int) (i6 / this.loadFactor)));
        if (max < 1073741824 && i6 / max > this.loadFactor) {
            max <<= 1;
        }
        if (max < this.table.length) {
            resizeTable(max);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.valuesView = createValues;
        return createValues;
    }

    Iterator<V> valuesIterator() {
        return new CompactHashMap<K, V>.Itr<V>() { // from class: com.google.common.collect.CompactHashMap.3
            @Override // com.google.common.collect.CompactHashMap.Itr
            V getOutput(int i6) {
                return (V) CompactHashMap.this.values[i6];
            }
        };
    }

    CompactHashMap(int i6) {
        this(i6, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOf(@NullableDecl Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int i6 = this.table[hashTableMask() & smearedHash];
        while (i6 != -1) {
            long j6 = this.entries[i6];
            if (getHash(j6) == smearedHash && Objects.equal(obj, this.keys[i6])) {
                return i6;
            }
            i6 = getNext(j6);
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(3, 1.0f);
        int readInt = objectInputStream.readInt();
        while (true) {
            readInt--;
            if (readInt >= 0) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            } else {
                return;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        for (int i6 = 0; i6 < this.size; i6++) {
            objectOutputStream.writeObject(this.keys[i6]);
            objectOutputStream.writeObject(this.values[i6]);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    int firstEntryIndex() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        int indexOf = indexOf(obj);
        accessEntry(indexOf);
        if (indexOf == -1) {
            return null;
        }
        return (V) this.values[indexOf];
    }

    void moveLastEntry(int i6) {
        int size = size() - 1;
        if (i6 < size) {
            Object[] objArr = this.keys;
            objArr[i6] = objArr[size];
            Object[] objArr2 = this.values;
            objArr2[i6] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            long[] jArr = this.entries;
            long j6 = jArr[size];
            jArr[i6] = j6;
            jArr[size] = -1;
            int hash = getHash(j6) & hashTableMask();
            int[] iArr = this.table;
            int i7 = iArr[hash];
            if (i7 == size) {
                iArr[hash] = i6;
                return;
            }
            while (true) {
                long j7 = this.entries[i7];
                int next = getNext(j7);
                if (next == size) {
                    this.entries[i7] = swapNext(j7, i6);
                    return;
                }
                i7 = next;
            }
        } else {
            this.keys[i6] = null;
            this.values[i6] = null;
            this.entries[i6] = -1;
        }
    }

    CompactHashMap(int i6, float f6) {
        init(i6, f6);
    }

    private static long swapNext(long j6, int i6) {
        return (j6 & HASH_MASK) | (4294967295L & i6);
    }

    void accessEntry(int i6) {
    }
}
