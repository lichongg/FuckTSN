package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: D:\Downloads\app\classes5.dex */
class ObjectCountHashMap<K> {
    static final float DEFAULT_LOAD_FACTOR = 1.0f;
    static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;

    @VisibleForTesting
    transient long[] entries;
    transient Object[] keys;
    private transient float loadFactor;
    transient int modCount;
    transient int size;
    private transient int[] table;
    private transient int threshold;
    transient int[] values;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class MapEntry extends Multisets.AbstractEntry<K> {

        @NullableDecl
        final K key;
        int lastKnownIndex;

        MapEntry(int i6) {
            this.key = (K) ObjectCountHashMap.this.keys[i6];
            this.lastKnownIndex = i6;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public K getElement() {
            return this.key;
        }

        void updateLastKnownIndex() {
            int i6 = this.lastKnownIndex;
            if (i6 == -1 || i6 >= ObjectCountHashMap.this.size() || !Objects.equal(this.key, ObjectCountHashMap.this.keys[this.lastKnownIndex])) {
                this.lastKnownIndex = ObjectCountHashMap.this.indexOf(this.key);
            }
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            updateLastKnownIndex();
            int i6 = this.lastKnownIndex;
            if (i6 == -1) {
                return 0;
            }
            return ObjectCountHashMap.this.values[i6];
        }

        @CanIgnoreReturnValue
        public int setCount(int i6) {
            updateLastKnownIndex();
            int i7 = this.lastKnownIndex;
            if (i7 == -1) {
                ObjectCountHashMap.this.put(this.key, i6);
                return 0;
            }
            int[] iArr = ObjectCountHashMap.this.values;
            int i8 = iArr[i7];
            iArr[i7] = i6;
            return i8;
        }
    }

    ObjectCountHashMap() {
        init(3, 1.0f);
    }

    private static int getNext(long j6) {
        return (int) j6;
    }

    void init(int i6, float f6) {
        Preconditions.checkArgument(i6 >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(f6 > 0.0f, "Illegal load factor");
        int closedTableSize = Hashing.closedTableSize(i6, f6);
        this.table = newTable(closedTableSize);
        this.loadFactor = f6;
        this.keys = new Object[i6];
        this.values = new int[i6];
        this.entries = newEntries(i6);
        this.threshold = Math.max(1, (int) (closedTableSize * f6));
    }

    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj) {
        return remove(obj, Hashing.smearedHash(obj));
    }

    public static <K> ObjectCountHashMap<K> create() {
        return new ObjectCountHashMap<>();
    }

    public static <K> ObjectCountHashMap<K> createWithExpectedSize(int i6) {
        return new ObjectCountHashMap<>(i6);
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

    private int remove(@NullableDecl Object obj, int i6) {
        int hashTableMask = hashTableMask() & i6;
        int i7 = this.table[hashTableMask];
        if (i7 == -1) {
            return 0;
        }
        int i8 = -1;
        while (true) {
            if (getHash(this.entries[i7]) == i6 && Objects.equal(obj, this.keys[i7])) {
                int i9 = this.values[i7];
                if (i8 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i7]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i8] = swapNext(jArr[i8], getNext(jArr[i7]));
                }
                moveLastEntry(i7);
                this.size--;
                this.modCount++;
                return i9;
            }
            int next = getNext(this.entries[i7]);
            if (next == -1) {
                return 0;
            }
            i8 = i7;
            i7 = next;
        }
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

    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, 0);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    void ensureCapacity(int i6) {
        if (i6 > this.entries.length) {
            resizeEntries(i6);
        }
        if (i6 >= this.threshold) {
            resizeTable(Math.max(2, Integer.highestOneBit(i6 - 1) << 1));
        }
    }

    int firstIndex() {
        return this.size == 0 ? -1 : 0;
    }

    Multiset.Entry<K> getEntry(int i6) {
        Preconditions.checkElementIndex(i6, this.size);
        return new MapEntry(i6);
    }

    K getKey(int i6) {
        Preconditions.checkElementIndex(i6, this.size);
        return (K) this.keys[i6];
    }

    int getValue(int i6) {
        Preconditions.checkElementIndex(i6, this.size);
        return this.values[i6];
    }

    void insertEntry(int i6, @NullableDecl K k6, int i7, int i8) {
        this.entries[i6] = (i8 << 32) | 4294967295L;
        this.keys[i6] = k6;
        this.values[i6] = i7;
    }

    int nextIndex(int i6) {
        int i7 = i6 + 1;
        if (i7 < this.size) {
            return i7;
        }
        return -1;
    }

    int nextIndexAfterRemove(int i6, int i7) {
        return i6 - 1;
    }

    @CanIgnoreReturnValue
    public int put(@NullableDecl K k6, int i6) {
        CollectPreconditions.checkPositive(i6, "count");
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        int smearedHash = Hashing.smearedHash(k6);
        int hashTableMask = hashTableMask() & smearedHash;
        int i7 = this.size;
        int[] iArr2 = this.table;
        int i8 = iArr2[hashTableMask];
        if (i8 == -1) {
            iArr2[hashTableMask] = i7;
        } else {
            while (true) {
                long j6 = jArr[i8];
                if (getHash(j6) == smearedHash && Objects.equal(k6, objArr[i8])) {
                    int i9 = iArr[i8];
                    iArr[i8] = i6;
                    return i9;
                }
                int next = getNext(j6);
                if (next == -1) {
                    jArr[i8] = swapNext(j6, i7);
                    break;
                }
                i8 = next;
            }
        }
        if (i7 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i10 = i7 + 1;
        resizeMeMaybe(i10);
        insertEntry(i7, k6, i6, smearedHash);
        this.size = i10;
        if (i7 >= this.threshold) {
            resizeTable(this.table.length * 2);
        }
        this.modCount++;
        return 0;
    }

    @CanIgnoreReturnValue
    int removeEntry(int i6) {
        return remove(this.keys[i6], getHash(this.entries[i6]));
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

    void setValue(int i6, int i7) {
        Preconditions.checkElementIndex(i6, this.size);
        this.values[i6] = i7;
    }

    int size() {
        return this.size;
    }

    ObjectCountHashMap(ObjectCountHashMap<? extends K> objectCountHashMap) {
        init(objectCountHashMap.size(), 1.0f);
        int firstIndex = objectCountHashMap.firstIndex();
        while (firstIndex != -1) {
            put(objectCountHashMap.getKey(firstIndex), objectCountHashMap.getValue(firstIndex));
            firstIndex = objectCountHashMap.nextIndex(firstIndex);
        }
    }

    public boolean containsKey(@NullableDecl Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public int get(@NullableDecl Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return 0;
        }
        return this.values[indexOf];
    }

    int indexOf(@NullableDecl Object obj) {
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

    void moveLastEntry(int i6) {
        int size = size() - 1;
        if (i6 < size) {
            Object[] objArr = this.keys;
            objArr[i6] = objArr[size];
            int[] iArr = this.values;
            iArr[i6] = iArr[size];
            objArr[size] = null;
            iArr[size] = 0;
            long[] jArr = this.entries;
            long j6 = jArr[size];
            jArr[i6] = j6;
            jArr[size] = -1;
            int hash = getHash(j6) & hashTableMask();
            int[] iArr2 = this.table;
            int i7 = iArr2[hash];
            if (i7 == size) {
                iArr2[hash] = i6;
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
            this.values[i6] = 0;
            this.entries[i6] = -1;
        }
    }

    private static long swapNext(long j6, int i6) {
        return (j6 & HASH_MASK) | (4294967295L & i6);
    }

    ObjectCountHashMap(int i6) {
        this(i6, 1.0f);
    }

    ObjectCountHashMap(int i6, float f6) {
        init(i6, f6);
    }
}
