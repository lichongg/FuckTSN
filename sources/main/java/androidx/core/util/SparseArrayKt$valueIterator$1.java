package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class SparseArrayKt$valueIterator$1<T> implements Iterator<T>, m3.a {
    final /* synthetic */ SparseArray<T> $this_valueIterator;
    private int index;

    SparseArrayKt$valueIterator$1(SparseArray<T> sparseArray) {
        this.$this_valueIterator = sparseArray;
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
        SparseArray<T> sparseArray = this.$this_valueIterator;
        int i6 = this.index;
        this.index = i6 + 1;
        return sparseArray.valueAt(i6);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i6) {
        this.index = i6;
    }
}
