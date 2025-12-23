package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: D:\Downloads\app\classes5.dex */
class ObjectCountLinkedHashMap<K> extends ObjectCountHashMap<K> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;

    @VisibleForTesting
    transient long[] links;

    ObjectCountLinkedHashMap() {
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

    ObjectCountLinkedHashMap(int i6) {
        this(i6, 1.0f);
    }

    public static <K> ObjectCountLinkedHashMap<K> create() {
        return new ObjectCountLinkedHashMap<>();
    }

    public static <K> ObjectCountLinkedHashMap<K> createWithExpectedSize(int i6) {
        return new ObjectCountLinkedHashMap<>(i6);
    }

    private int getPredecessor(int i6) {
        return (int) (this.links[i6] >>> 32);
    }

    private int getSuccessor(int i6) {
        return (int) this.links[i6];
    }

    private void setPredecessor(int i6, int i7) {
        long[] jArr = this.links;
        jArr[i6] = (jArr[i6] & 4294967295L) | (i7 << 32);
    }

    private void setSuccessor(int i6, int i7) {
        long[] jArr = this.links;
        jArr[i6] = (jArr[i6] & (-4294967296L)) | (i7 & 4294967295L);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    int firstIndex() {
        int i6 = this.firstEntry;
        if (i6 == -2) {
            return -1;
        }
        return i6;
    }

    ObjectCountLinkedHashMap(int i6, float f6) {
        super(i6, f6);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    void init(int i6, float f6) {
        super.init(i6, f6);
        this.firstEntry = -2;
        this.lastEntry = -2;
        long[] jArr = new long[i6];
        this.links = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    void insertEntry(int i6, K k6, int i7, int i8) {
        super.insertEntry(i6, k6, i7, i8);
        setSucceeds(this.lastEntry, i6);
        setSucceeds(i6, -2);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    void moveLastEntry(int i6) {
        int size = size() - 1;
        setSucceeds(getPredecessor(i6), getSuccessor(i6));
        if (i6 < size) {
            setSucceeds(getPredecessor(size), i6);
            setSucceeds(i6, getSuccessor(size));
        }
        super.moveLastEntry(i6);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    int nextIndex(int i6) {
        int successor = getSuccessor(i6);
        if (successor == -2) {
            return -1;
        }
        return successor;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    int nextIndexAfterRemove(int i6, int i7) {
        if (i6 == size()) {
            return i7;
        }
        return i6;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    void resizeEntries(int i6) {
        super.resizeEntries(i6);
        long[] jArr = this.links;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i6);
        this.links = copyOf;
        Arrays.fill(copyOf, length, i6, -1L);
    }

    ObjectCountLinkedHashMap(ObjectCountHashMap<K> objectCountHashMap) {
        init(objectCountHashMap.size(), 1.0f);
        int firstIndex = objectCountHashMap.firstIndex();
        while (firstIndex != -1) {
            put(objectCountHashMap.getKey(firstIndex), objectCountHashMap.getValue(firstIndex));
            firstIndex = objectCountHashMap.nextIndex(firstIndex);
        }
    }
}
