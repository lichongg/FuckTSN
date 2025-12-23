package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    private static final float DEFAULT_LOAD_FACTOR = 1.0f;
    private static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;

    @MonotonicNonNullDecl
    transient Object[] elements;

    @MonotonicNonNullDecl
    private transient long[] entries;
    transient float loadFactor;
    transient int modCount;
    private transient int size;

    @MonotonicNonNullDecl
    private transient int[] table;
    private transient int threshold;

    CompactHashSet() {
        init(3, 1.0f);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
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
        this.elements = new Object[i6];
        this.entries = newEntries(i6);
        this.threshold = Math.max(1, (int) (closedTableSize * f6));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj) {
        return remove(obj, Hashing.smearedHash(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return Arrays.copyOf(this.elements, this.size);
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i6) {
        return new CompactHashSet<>(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getHash(long j6) {
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

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public boolean remove(Object obj, int i6) {
        int hashTableMask = hashTableMask() & i6;
        int i7 = this.table[hashTableMask];
        if (i7 == -1) {
            return false;
        }
        int i8 = -1;
        while (true) {
            if (getHash(this.entries[i7]) == i6 && Objects.equal(obj, this.elements[i7])) {
                if (i8 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i7]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i8] = swapNext(jArr[i8], getNext(jArr[i7]));
                }
                moveEntry(i7);
                this.size--;
                this.modCount++;
                return true;
            }
            int next = getNext(this.entries[i7]);
            if (next == -1) {
                return false;
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean add(@NullableDecl E e6) {
        long[] jArr = this.entries;
        Object[] objArr = this.elements;
        int smearedHash = Hashing.smearedHash(e6);
        int hashTableMask = hashTableMask() & smearedHash;
        int i6 = this.size;
        int[] iArr = this.table;
        int i7 = iArr[hashTableMask];
        if (i7 == -1) {
            iArr[hashTableMask] = i6;
        } else {
            while (true) {
                long j6 = jArr[i7];
                if (getHash(j6) == smearedHash && Objects.equal(e6, objArr[i7])) {
                    return false;
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
        insertEntry(i6, e6, smearedHash);
        this.size = i8;
        if (i6 >= this.threshold) {
            resizeTable(this.table.length * 2);
        }
        this.modCount++;
        return true;
    }

    int adjustAfterRemove(int i6, int i7) {
        return i6 - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.modCount++;
        Arrays.fill(this.elements, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    int getSuccessor(int i6) {
        int i7 = i6 + 1;
        if (i7 < this.size) {
            return i7;
        }
        return -1;
    }

    void insertEntry(int i6, E e6, int i7) {
        this.entries[i6] = (i7 << 32) | 4294967295L;
        this.elements[i6] = e6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new Iterator<E>() { // from class: com.google.common.collect.CompactHashSet.1
            int expectedModCount;
            int index;
            int indexToRemove = -1;

            {
                this.expectedModCount = CompactHashSet.this.modCount;
                this.index = CompactHashSet.this.firstEntryIndex();
            }

            private void checkForConcurrentModification() {
                if (CompactHashSet.this.modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index >= 0;
            }

            @Override // java.util.Iterator
            public E next() {
                checkForConcurrentModification();
                if (hasNext()) {
                    int i6 = this.index;
                    this.indexToRemove = i6;
                    CompactHashSet compactHashSet = CompactHashSet.this;
                    E e6 = (E) compactHashSet.elements[i6];
                    this.index = compactHashSet.getSuccessor(i6);
                    return e6;
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
                CompactHashSet compactHashSet = CompactHashSet.this;
                compactHashSet.remove(compactHashSet.elements[this.indexToRemove], CompactHashSet.getHash(compactHashSet.entries[this.indexToRemove]));
                this.index = CompactHashSet.this.adjustAfterRemove(this.index, this.indexToRemove);
                this.indexToRemove = -1;
            }
        };
    }

    void resizeEntries(int i6) {
        this.elements = Arrays.copyOf(this.elements, i6);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i6);
        if (i6 > length) {
            Arrays.fill(copyOf, length, i6, -1L);
        }
        this.entries = copyOf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        return (T[]) ObjectArrays.toArrayImpl(this.elements, 0, this.size, tArr);
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

    CompactHashSet(int i6) {
        init(i6, 1.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(3, 1.0f);
        int readInt = objectInputStream.readInt();
        while (true) {
            readInt--;
            if (readInt >= 0) {
                add(objectInputStream.readObject());
            } else {
                return;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int i6 = this.table[hashTableMask() & smearedHash];
        while (i6 != -1) {
            long j6 = this.entries[i6];
            if (getHash(j6) == smearedHash && Objects.equal(obj, this.elements[i6])) {
                return true;
            }
            i6 = getNext(j6);
        }
        return false;
    }

    int firstEntryIndex() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    void moveEntry(int i6) {
        int size = size() - 1;
        if (i6 < size) {
            Object[] objArr = this.elements;
            objArr[i6] = objArr[size];
            objArr[size] = null;
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
            this.elements[i6] = null;
            this.entries[i6] = -1;
        }
    }

    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    private static long swapNext(long j6, int i6) {
        return (j6 & HASH_MASK) | (4294967295L & i6);
    }
}
