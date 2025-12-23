package androidx.collection;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class SparseArrayKt$valueIterator$1<T> implements Iterator<T>, m3.a {
    final /* synthetic */ SparseArrayCompat<T> $this_valueIterator;
    private int index;

    SparseArrayKt$valueIterator$1(SparseArrayCompat<T> sparseArrayCompat) {
        this.$this_valueIterator = sparseArrayCompat;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_valueIterator.size();
    }

    @Override // java.util.Iterator
    public T next() {
        SparseArrayCompat<T> sparseArrayCompat = this.$this_valueIterator;
        int i6 = this.index;
        this.index = i6 + 1;
        return sparseArrayCompat.valueAt(i6);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i6) {
        this.index = i6;
    }
}
