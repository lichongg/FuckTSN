package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: D:\Downloads\app\classes5.dex */
class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = new RegularImmutableList(new Object[0], 0);

    @VisibleForTesting
    final transient Object[] array;
    private final transient int size;

    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i6) {
        System.arraycopy(this.array, 0, objArr, i6, this.size);
        return i6 + this.size;
    }

    @Override // java.util.List
    public E get(int i6) {
        Preconditions.checkElementIndex(i6, this.size);
        return (E) this.array[i6];
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object[] internalArray() {
        return this.array;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayEnd() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    RegularImmutableList(Object[] objArr, int i6) {
        this.array = objArr;
        this.size = i6;
    }
}
