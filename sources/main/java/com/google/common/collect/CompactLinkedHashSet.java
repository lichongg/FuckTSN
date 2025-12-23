package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;

    @MonotonicNonNullDecl
    private transient int[] predecessor;

    @MonotonicNonNullDecl
    private transient int[] successor;

    CompactLinkedHashSet() {
    }

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet<>();
    }

    private void succeeds(int i6, int i7) {
        if (i6 == -2) {
            this.firstEntry = i7;
        } else {
            this.successor[i6] = i7;
        }
        if (i7 == -2) {
            this.lastEntry = i6;
        } else {
            this.predecessor[i7] = i6;
        }
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    CompactLinkedHashSet(int i6) {
        super(i6);
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> collection) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int i6) {
        return new CompactLinkedHashSet<>(i6);
    }

    @Override // com.google.common.collect.CompactHashSet
    int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.common.collect.CompactHashSet
    int getSuccessor(int i6) {
        return this.successor[i6];
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) ObjectArrays.toArrayImpl(this, tArr);
    }

    @Override // com.google.common.collect.CompactHashSet
    int adjustAfterRemove(int i6, int i7) {
        if (i6 == size()) {
            return i7;
        }
        return i6;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
        Arrays.fill(this.predecessor, -1);
        Arrays.fill(this.successor, -1);
    }

    @Override // com.google.common.collect.CompactHashSet
    void init(int i6, float f6) {
        super.init(i6, f6);
        int[] iArr = new int[i6];
        this.predecessor = iArr;
        this.successor = new int[i6];
        Arrays.fill(iArr, -1);
        Arrays.fill(this.successor, -1);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.CompactHashSet
    void insertEntry(int i6, E e6, int i7) {
        super.insertEntry(i6, e6, i7);
        succeeds(this.lastEntry, i6);
        succeeds(i6, -2);
    }

    @Override // com.google.common.collect.CompactHashSet
    void moveEntry(int i6) {
        int size = size() - 1;
        super.moveEntry(i6);
        succeeds(this.predecessor[i6], this.successor[i6]);
        if (size != i6) {
            succeeds(this.predecessor[size], i6);
            succeeds(i6, this.successor[size]);
        }
        this.predecessor[size] = -1;
        this.successor[size] = -1;
    }

    @Override // com.google.common.collect.CompactHashSet
    void resizeEntries(int i6) {
        super.resizeEntries(i6);
        int[] iArr = this.predecessor;
        int length = iArr.length;
        this.predecessor = Arrays.copyOf(iArr, i6);
        this.successor = Arrays.copyOf(this.successor, i6);
        if (length < i6) {
            Arrays.fill(this.predecessor, length, i6, -1);
            Arrays.fill(this.successor, length, i6, -1);
        }
    }

    public static <E> CompactLinkedHashSet<E> create(E... eArr) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }
}
