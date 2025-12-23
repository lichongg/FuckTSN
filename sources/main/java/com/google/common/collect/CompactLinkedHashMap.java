package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;
    private transient int firstEntry;
    private transient int lastEntry;

    @VisibleForTesting
    @MonotonicNonNullDecl
    transient long[] links;

    CompactLinkedHashMap() {
        this(3);
    }

    private void setSucceeds(int i6, int i7) {
        if (i6 == -2) {
            this.firstEntry = i7;
        } else {
            setSuccessor(i6, i7);
        }
        if (i7 == -2) {
            this.lastEntry = i6;
        } else {
            setPredecessor(i7, i6);
        }
    }

    CompactLinkedHashMap(int i6) {
        this(i6, 1.0f, false);
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i6) {
        return new CompactLinkedHashMap<>(i6);
    }

    private int getPredecessor(int i6) {
        return (int) (this.links[i6] >>> 32);
    }

    private void setPredecessor(int i6, int i7) {
        long[] jArr = this.links;
        jArr[i6] = (jArr[i6] & 4294967295L) | (i7 << 32);
    }

    private void setSuccessor(int i6, int i7) {
        long[] jArr = this.links;
        jArr[i6] = (jArr[i6] & (-4294967296L)) | (i7 & 4294967295L);
    }

    @Override // com.google.common.collect.CompactHashMap
    void accessEntry(int i6) {
        if (this.accessOrder) {
            setSucceeds(getPredecessor(i6), getSuccessor(i6));
            setSucceeds(this.lastEntry, i6);
            setSucceeds(i6, -2);
            this.modCount++;
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.common.collect.CompactHashMap
    int getSuccessor(int i6) {
        return (int) this.links[i6];
    }

    CompactLinkedHashMap(int i6, float f6, boolean z5) {
        super(i6, f6);
        this.accessOrder = z5;
    }

    @Override // com.google.common.collect.CompactHashMap
    int adjustAfterRemove(int i6, int i7) {
        if (i6 >= size()) {
            return i7;
        }
        return i6;
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    void init(int i6, float f6) {
        super.init(i6, f6);
        this.firstEntry = -2;
        this.lastEntry = -2;
        long[] jArr = new long[i6];
        this.links = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.CompactHashMap
    void insertEntry(int i6, K k6, V v5, int i7) {
        super.insertEntry(i6, k6, v5, i7);
        setSucceeds(this.lastEntry, i6);
        setSucceeds(i6, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    void moveLastEntry(int i6) {
        int size = size() - 1;
        setSucceeds(getPredecessor(i6), getSuccessor(i6));
        if (i6 < size) {
            setSucceeds(getPredecessor(size), i6);
            setSucceeds(i6, getSuccessor(size));
        }
        super.moveLastEntry(i6);
    }

    @Override // com.google.common.collect.CompactHashMap
    void resizeEntries(int i6) {
        super.resizeEntries(i6);
        this.links = Arrays.copyOf(this.links, i6);
    }
}
