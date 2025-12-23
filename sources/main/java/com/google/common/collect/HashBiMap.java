package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;
    private transient Set<Map.Entry<K, V>> entrySet;

    @NullableDecl
    private transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;

    @RetainedWith
    @MonotonicNonNullDecl
    private transient BiMap<V, K> inverse;
    private transient Set<K> keySet;
    transient K[] keys;

    @NullableDecl
    private transient int lastInInsertionOrder;
    transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    private transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    transient int size;
    private transient Set<V> valueSet;
    transient V[] values;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class EntryForKey extends AbstractMapEntry<K, V> {
        int index;

        @NullableDecl
        final K key;

        EntryForKey(int i6) {
            this.key = HashBiMap.this.keys[i6];
            this.index = i6;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        void updateIndex() {
            int i6 = this.index;
            if (i6 != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i6 <= hashBiMap.size && Objects.equal(hashBiMap.keys[i6], this.key)) {
                    return;
                }
            }
            this.index = HashBiMap.this.findEntryByKey(this.key);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        @NullableDecl
        public V getValue() {
            updateIndex();
            int i6 = this.index;
            if (i6 == -1) {
                return null;
            }
            return HashBiMap.this.values[i6];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V setValue(V v5) {
            updateIndex();
            int i6 = this.index;
            if (i6 == -1) {
                return (V) HashBiMap.this.put(this.key, v5);
            }
            V v6 = HashBiMap.this.values[i6];
            if (!Objects.equal(v6, v5)) {
                HashBiMap.this.replaceValueInEntry(this.index, v5, false);
                return v6;
            }
            return v5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class EntryForValue<K, V> extends AbstractMapEntry<V, K> {
        final HashBiMap<K, V> biMap;
        int index;
        final V value;

        private void updateIndex() {
            int i6 = this.index;
            if (i6 != -1) {
                HashBiMap<K, V> hashBiMap = this.biMap;
                if (i6 <= hashBiMap.size && Objects.equal(this.value, hashBiMap.values[i6])) {
                    return;
                }
            }
            this.index = this.biMap.findEntryByValue(this.value);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getKey() {
            return this.value;
        }

        EntryForValue(HashBiMap<K, V> hashBiMap, int i6) {
            this.biMap = hashBiMap;
            this.value = hashBiMap.values[i6];
            this.index = i6;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K getValue() {
            updateIndex();
            int i6 = this.index;
            if (i6 == -1) {
                return null;
            }
            return this.biMap.keys[i6];
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public K setValue(K k6) {
            updateIndex();
            int i6 = this.index;
            if (i6 == -1) {
                return this.biMap.putInverse(this.value, k6, false);
            }
            K k7 = this.biMap.keys[i6];
            if (!Objects.equal(k7, k6)) {
                this.biMap.replaceKeyInEntry(this.index, k6, false);
                return k7;
            }
            return k6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class EntrySet extends View<K, V, Map.Entry<K, V>> {
        EntrySet() {
            super(HashBiMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int findEntryByKey = HashBiMap.this.findEntryByKey(key);
                if (findEntryByKey != -1 && Objects.equal(value, HashBiMap.this.values[findEntryByKey])) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.HashBiMap.View
        public Map.Entry<K, V> forEntry(int i6) {
            return new EntryForKey(i6);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int smearedHash = Hashing.smearedHash(key);
            int findEntryByKey = HashBiMap.this.findEntryByKey(key, smearedHash);
            if (findEntryByKey == -1 || !Objects.equal(value, HashBiMap.this.values[findEntryByKey])) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
        private final HashBiMap<K, V> forward;
        private transient Set<Map.Entry<V, K>> inverseEntrySet;

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return this.forward.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@NullableDecl Object obj) {
            return this.forward.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.inverseEntrySet;
            if (set != null) {
                return set;
            }
            InverseEntrySet inverseEntrySet = new InverseEntrySet(this.forward);
            this.inverseEntrySet = inverseEntrySet;
            return inverseEntrySet;
        }

        @Override // com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        @NullableDecl
        public K forcePut(@NullableDecl V v5, @NullableDecl K k6) {
            return this.forward.putInverse(v5, k6, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @NullableDecl
        public K get(@NullableDecl Object obj) {
            return this.forward.getInverse(obj);
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        @CanIgnoreReturnValue
        @NullableDecl
        public K put(@NullableDecl V v5, @NullableDecl K k6) {
            return this.forward.putInverse(v5, k6, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CanIgnoreReturnValue
        @NullableDecl
        public K remove(@NullableDecl Object obj) {
            return this.forward.removeInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> values() {
            return this.forward.keySet();
        }

        Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        @GwtIncompatible("serialization")
        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            ((HashBiMap) this.forward).inverse = this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class InverseEntrySet<K, V> extends View<K, V, Map.Entry<V, K>> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int findEntryByValue = this.biMap.findEntryByValue(key);
                if (findEntryByValue != -1 && Objects.equal(this.biMap.keys[findEntryByValue], value)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.HashBiMap.View
        public Map.Entry<V, K> forEntry(int i6) {
            return new EntryForValue(this.biMap, i6);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int smearedHash = Hashing.smearedHash(key);
            int findEntryByValue = this.biMap.findEntryByValue(key, smearedHash);
            if (findEntryByValue == -1 || !Objects.equal(this.biMap.keys[findEntryByValue], value)) {
                return false;
            }
            this.biMap.removeEntryValueHashKnown(findEntryByValue, smearedHash);
            return true;
        }

        InverseEntrySet(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class KeySet extends View<K, V, K> {
        KeySet() {
            super(HashBiMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.HashBiMap.View
        K forEntry(int i6) {
            return HashBiMap.this.keys[i6];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int smearedHash = Hashing.smearedHash(obj);
            int findEntryByKey = HashBiMap.this.findEntryByKey(obj, smearedHash);
            if (findEntryByKey != -1) {
                HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, smearedHash);
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class ValueSet extends View<K, V, V> {
        ValueSet() {
            super(HashBiMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // com.google.common.collect.HashBiMap.View
        V forEntry(int i6) {
            return HashBiMap.this.values[i6];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            int smearedHash = Hashing.smearedHash(obj);
            int findEntryByValue = HashBiMap.this.findEntryByValue(obj, smearedHash);
            if (findEntryByValue != -1) {
                HashBiMap.this.removeEntryValueHashKnown(findEntryByValue, smearedHash);
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class View<K, V, T> extends AbstractSet<T> {
        final HashBiMap<K, V> biMap;

        abstract T forEntry(int i6);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.biMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            return new Iterator<T>() { // from class: com.google.common.collect.HashBiMap.View.1
                private int expectedModCount;
                private int index;
                private int indexToRemove = -1;
                private int remaining;

                {
                    this.index = ((HashBiMap) View.this.biMap).firstInInsertionOrder;
                    HashBiMap<K, V> hashBiMap = View.this.biMap;
                    this.expectedModCount = hashBiMap.modCount;
                    this.remaining = hashBiMap.size;
                }

                private void checkForComodification() {
                    if (View.this.biMap.modCount != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    checkForComodification();
                    if (this.index != -2 && this.remaining > 0) {
                        return true;
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public T next() {
                    if (hasNext()) {
                        T t5 = (T) View.this.forEntry(this.index);
                        this.indexToRemove = this.index;
                        this.index = ((HashBiMap) View.this.biMap).nextInInsertionOrder[this.index];
                        this.remaining--;
                        return t5;
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public void remove() {
                    boolean z5;
                    checkForComodification();
                    if (this.indexToRemove != -1) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    CollectPreconditions.checkRemove(z5);
                    View.this.biMap.removeEntry(this.indexToRemove);
                    int i6 = this.index;
                    HashBiMap<K, V> hashBiMap = View.this.biMap;
                    if (i6 == hashBiMap.size) {
                        this.index = this.indexToRemove;
                    }
                    this.indexToRemove = -1;
                    this.expectedModCount = hashBiMap.modCount;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.biMap.size;
        }

        View(HashBiMap<K, V> hashBiMap) {
            this.biMap = hashBiMap;
        }
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    private void deleteFromTableKToV(int i6, int i7) {
        Preconditions.checkArgument(i6 != -1);
        int bucket = bucket(i7);
        int[] iArr = this.hashTableKToV;
        int i8 = iArr[bucket];
        if (i8 == i6) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i6];
            iArr2[i6] = -1;
            return;
        }
        int i9 = this.nextInBucketKToV[i8];
        while (true) {
            int i10 = i8;
            i8 = i9;
            if (i8 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.keys[i6]);
            }
            if (i8 == i6) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i10] = iArr3[i6];
                iArr3[i6] = -1;
                return;
            }
            i9 = this.nextInBucketKToV[i8];
        }
    }

    private void deleteFromTableVToK(int i6, int i7) {
        Preconditions.checkArgument(i6 != -1);
        int bucket = bucket(i7);
        int[] iArr = this.hashTableVToK;
        int i8 = iArr[bucket];
        if (i8 == i6) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i6];
            iArr2[i6] = -1;
            return;
        }
        int i9 = this.nextInBucketVToK[i8];
        while (true) {
            int i10 = i8;
            i8 = i9;
            if (i8 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.values[i6]);
            }
            if (i8 == i6) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i10] = iArr3[i6];
                iArr3[i6] = -1;
                return;
            }
            i9 = this.nextInBucketVToK[i8];
        }
    }

    private static int[] expandAndFillWithAbsent(int[] iArr, int i6) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i6);
        Arrays.fill(copyOf, length, i6, -1);
        return copyOf;
    }

    private void insertIntoTableKToV(int i6, int i7) {
        Preconditions.checkArgument(i6 != -1);
        int bucket = bucket(i7);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i6] = iArr2[bucket];
        iArr2[bucket] = i6;
    }

    private void insertIntoTableVToK(int i6, int i7) {
        Preconditions.checkArgument(i6 != -1);
        int bucket = bucket(i7);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i6] = iArr2[bucket];
        iArr2[bucket] = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceKeyInEntry(int i6, @NullableDecl K k6, boolean z5) {
        int i7;
        Preconditions.checkArgument(i6 != -1);
        int smearedHash = Hashing.smearedHash(k6);
        int findEntryByKey = findEntryByKey(k6, smearedHash);
        int i8 = this.lastInInsertionOrder;
        if (findEntryByKey == -1) {
            i7 = -2;
        } else {
            if (!z5) {
                throw new IllegalArgumentException("Key already present in map: " + k6);
            }
            i8 = this.prevInInsertionOrder[findEntryByKey];
            i7 = this.nextInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, smearedHash);
            if (i6 == this.size) {
                i6 = findEntryByKey;
            }
        }
        if (i8 == i6) {
            i8 = this.prevInInsertionOrder[i6];
        } else if (i8 == this.size) {
            i8 = findEntryByKey;
        }
        if (i7 == i6) {
            findEntryByKey = this.nextInInsertionOrder[i6];
        } else if (i7 != this.size) {
            findEntryByKey = i7;
        }
        setSucceeds(this.prevInInsertionOrder[i6], this.nextInInsertionOrder[i6]);
        deleteFromTableKToV(i6, Hashing.smearedHash(this.keys[i6]));
        this.keys[i6] = k6;
        insertIntoTableKToV(i6, Hashing.smearedHash(k6));
        setSucceeds(i8, i6);
        setSucceeds(i6, findEntryByKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceValueInEntry(int i6, @NullableDecl V v5, boolean z5) {
        Preconditions.checkArgument(i6 != -1);
        int smearedHash = Hashing.smearedHash(v5);
        int findEntryByValue = findEntryByValue(v5, smearedHash);
        if (findEntryByValue != -1) {
            if (!z5) {
                throw new IllegalArgumentException("Value already present in map: " + v5);
            }
            removeEntryValueHashKnown(findEntryByValue, smearedHash);
            if (i6 == this.size) {
                i6 = findEntryByValue;
            }
        }
        deleteFromTableVToK(i6, Hashing.smearedHash(this.values[i6]));
        this.values[i6] = v5;
        insertIntoTableVToK(i6, smearedHash);
    }

    private void setSucceeds(int i6, int i7) {
        if (i6 == -2) {
            this.firstInInsertionOrder = i7;
        } else {
            this.nextInInsertionOrder[i6] = i7;
        }
        if (i7 == -2) {
            this.lastInInsertionOrder = i6;
        } else {
            this.prevInInsertionOrder[i7] = i6;
        }
    }

    int findEntryByKey(@NullableDecl Object obj) {
        return findEntryByKey(obj, Hashing.smearedHash(obj));
    }

    int findEntryByValue(@NullableDecl Object obj) {
        return findEntryByValue(obj, Hashing.smearedHash(obj));
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @NullableDecl
    public V forcePut(@NullableDecl K k6, @NullableDecl V v5) {
        return put(k6, v5, true);
    }

    @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V put(@NullableDecl K k6, @NullableDecl V v5) {
        return put(k6, v5, false);
    }

    void removeEntry(int i6) {
        removeEntryKeyHashKnown(i6, Hashing.smearedHash(this.keys[i6]));
    }

    private int bucket(int i6) {
        return i6 & (this.hashTableKToV.length - 1);
    }

    public static <K, V> HashBiMap<K, V> create(int i6) {
        return new HashBiMap<>(i6);
    }

    private static int[] createFilledWithAbsent(int i6) {
        int[] iArr = new int[i6];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void ensureCapacity(int i6) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i6) {
            int expandedCapacity = ImmutableCollection.Builder.expandedCapacity(iArr.length, i6);
            this.keys = (K[]) Arrays.copyOf(this.keys, expandedCapacity);
            this.values = (V[]) Arrays.copyOf(this.values, expandedCapacity);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, expandedCapacity);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, expandedCapacity);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, expandedCapacity);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, expandedCapacity);
        }
        if (this.hashTableKToV.length < i6) {
            int closedTableSize = Hashing.closedTableSize(i6, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(closedTableSize);
            this.hashTableVToK = createFilledWithAbsent(closedTableSize);
            for (int i7 = 0; i7 < this.size; i7++) {
                int bucket = bucket(Hashing.smearedHash(this.keys[i7]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i7] = iArr3[bucket];
                iArr3[bucket] = i7;
                int bucket2 = bucket(Hashing.smearedHash(this.values[i7]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i7] = iArr5[bucket2];
                iArr5[bucket2] = i7;
            }
        }
    }

    private void moveEntryToIndex(int i6, int i7) {
        int i8;
        int i9;
        if (i6 == i7) {
            return;
        }
        int i10 = this.prevInInsertionOrder[i6];
        int i11 = this.nextInInsertionOrder[i6];
        setSucceeds(i10, i7);
        setSucceeds(i7, i11);
        K[] kArr = this.keys;
        K k6 = kArr[i6];
        V[] vArr = this.values;
        V v5 = vArr[i6];
        kArr[i7] = k6;
        vArr[i7] = v5;
        int bucket = bucket(Hashing.smearedHash(k6));
        int[] iArr = this.hashTableKToV;
        int i12 = iArr[bucket];
        if (i12 == i6) {
            iArr[bucket] = i7;
        } else {
            int i13 = this.nextInBucketKToV[i12];
            while (true) {
                i8 = i12;
                i12 = i13;
                if (i12 == i6) {
                    break;
                } else {
                    i13 = this.nextInBucketKToV[i12];
                }
            }
            this.nextInBucketKToV[i8] = i7;
        }
        int[] iArr2 = this.nextInBucketKToV;
        iArr2[i7] = iArr2[i6];
        iArr2[i6] = -1;
        int bucket2 = bucket(Hashing.smearedHash(v5));
        int[] iArr3 = this.hashTableVToK;
        int i14 = iArr3[bucket2];
        if (i14 == i6) {
            iArr3[bucket2] = i7;
        } else {
            int i15 = this.nextInBucketVToK[i14];
            while (true) {
                i9 = i14;
                i14 = i15;
                if (i14 == i6) {
                    break;
                } else {
                    i15 = this.nextInBucketVToK[i14];
                }
            }
            this.nextInBucketVToK[i9] = i7;
        }
        int[] iArr4 = this.nextInBucketVToK;
        iArr4[i7] = iArr4[i6];
        iArr4[i6] = -1;
    }

    private void removeEntry(int i6, int i7, int i8) {
        Preconditions.checkArgument(i6 != -1);
        deleteFromTableKToV(i6, i7);
        deleteFromTableVToK(i6, i8);
        setSucceeds(this.prevInInsertionOrder[i6], this.nextInInsertionOrder[i6]);
        moveEntryToIndex(this.size - 1, i6);
        K[] kArr = this.keys;
        int i9 = this.size;
        kArr[i9 - 1] = null;
        this.values[i9 - 1] = null;
        this.size = i9 - 1;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    int findEntryByKey(@NullableDecl Object obj, int i6) {
        return findEntry(obj, i6, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    int findEntryByValue(@NullableDecl Object obj, int i6) {
        return findEntry(obj, i6, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    void init(int i6) {
        CollectPreconditions.checkNonnegative(i6, "expectedSize");
        int closedTableSize = Hashing.closedTableSize(i6, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[i6];
        this.values = (V[]) new Object[i6];
        this.hashTableKToV = createFilledWithAbsent(closedTableSize);
        this.hashTableVToK = createFilledWithAbsent(closedTableSize);
        this.nextInBucketKToV = createFilledWithAbsent(i6);
        this.nextInBucketVToK = createFilledWithAbsent(i6);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i6);
        this.nextInInsertionOrder = createFilledWithAbsent(i6);
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        BiMap<V, K> biMap = this.inverse;
        if (biMap != null) {
            return biMap;
        }
        Inverse inverse = new Inverse(this);
        this.inverse = inverse;
        return inverse;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    @NullableDecl
    V put(@NullableDecl K k6, @NullableDecl V v5, boolean z5) {
        int smearedHash = Hashing.smearedHash(k6);
        int findEntryByKey = findEntryByKey(k6, smearedHash);
        if (findEntryByKey != -1) {
            V v6 = this.values[findEntryByKey];
            if (Objects.equal(v6, v5)) {
                return v5;
            }
            replaceValueInEntry(findEntryByKey, v5, z5);
            return v6;
        }
        int smearedHash2 = Hashing.smearedHash(v5);
        int findEntryByValue = findEntryByValue(v5, smearedHash2);
        if (!z5) {
            Preconditions.checkArgument(findEntryByValue == -1, "Value already present: %s", v5);
        } else if (findEntryByValue != -1) {
            removeEntryValueHashKnown(findEntryByValue, smearedHash2);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i6 = this.size;
        kArr[i6] = k6;
        this.values[i6] = v5;
        insertIntoTableKToV(i6, smearedHash);
        insertIntoTableVToK(this.size, smearedHash2);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    void removeEntryKeyHashKnown(int i6, int i7) {
        removeEntry(i6, i7, Hashing.smearedHash(this.values[i6]));
    }

    void removeEntryValueHashKnown(int i6, int i7) {
        removeEntry(i6, Hashing.smearedHash(this.keys[i6]), i7);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        ValueSet valueSet = new ValueSet();
        this.valueSet = valueSet;
        return valueSet;
    }

    private HashBiMap(int i6) {
        init(i6);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        init(16);
        Serialization.populateMap(this, objectInputStream, readCount);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap(this, objectOutputStream);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (findEntryByKey(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        if (findEntryByValue(obj) != -1) {
            return true;
        }
        return false;
    }

    int findEntry(@NullableDecl Object obj, int i6, int[] iArr, int[] iArr2, Object[] objArr) {
        int i7 = iArr[bucket(i6)];
        while (i7 != -1) {
            if (Objects.equal(objArr[i7], obj)) {
                return i7;
            }
            i7 = iArr2[i7];
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        int findEntryByKey = findEntryByKey(obj);
        if (findEntryByKey == -1) {
            return null;
        }
        return this.values[findEntryByKey];
    }

    @NullableDecl
    K getInverse(@NullableDecl Object obj) {
        int findEntryByValue = findEntryByValue(obj);
        if (findEntryByValue == -1) {
            return null;
        }
        return this.keys[findEntryByValue];
    }

    @NullableDecl
    K putInverse(@NullableDecl V v5, @NullableDecl K k6, boolean z5) {
        boolean z6;
        int i6;
        int smearedHash = Hashing.smearedHash(v5);
        int findEntryByValue = findEntryByValue(v5, smearedHash);
        if (findEntryByValue != -1) {
            K k7 = this.keys[findEntryByValue];
            if (Objects.equal(k7, k6)) {
                return k6;
            }
            replaceKeyInEntry(findEntryByValue, k6, z5);
            return k7;
        }
        int i7 = this.lastInInsertionOrder;
        int smearedHash2 = Hashing.smearedHash(k6);
        int findEntryByKey = findEntryByKey(k6, smearedHash2);
        if (z5) {
            if (findEntryByKey != -1) {
                i7 = this.prevInInsertionOrder[findEntryByKey];
                removeEntryKeyHashKnown(findEntryByKey, smearedHash2);
            }
        } else {
            if (findEntryByKey == -1) {
                z6 = true;
            } else {
                z6 = false;
            }
            Preconditions.checkArgument(z6, "Key already present: %s", k6);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i8 = this.size;
        kArr[i8] = k6;
        this.values[i8] = v5;
        insertIntoTableKToV(i8, smearedHash2);
        insertIntoTableVToK(this.size, smearedHash);
        if (i7 == -2) {
            i6 = this.firstInInsertionOrder;
        } else {
            i6 = this.nextInInsertionOrder[i7];
        }
        setSucceeds(i7, this.size);
        setSucceeds(this.size, i6);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int findEntryByKey = findEntryByKey(obj, smearedHash);
        if (findEntryByKey == -1) {
            return null;
        }
        V v5 = this.values[findEntryByKey];
        removeEntryKeyHashKnown(findEntryByKey, smearedHash);
        return v5;
    }

    @NullableDecl
    K removeInverse(@NullableDecl Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int findEntryByValue = findEntryByValue(obj, smearedHash);
        if (findEntryByValue == -1) {
            return null;
        }
        K k6 = this.keys[findEntryByValue];
        removeEntryValueHashKnown(findEntryByValue, smearedHash);
        return k6;
    }
}
