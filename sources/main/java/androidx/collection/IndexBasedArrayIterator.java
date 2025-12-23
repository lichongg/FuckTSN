package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.SourceDebugExtension;
import m3.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nIndexBasedArrayIterator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IndexBasedArrayIterator.kt\nandroidx/collection/IndexBasedArrayIterator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class IndexBasedArrayIterator<T> implements Iterator<T>, d {
    private boolean canRemove;
    private int index;
    private int size;

    protected abstract T elementAt(int i6);

    protected abstract void removeAt(int i6);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.size;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.canRemove) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i6 = this.index - 1;
        this.index = i6;
        removeAt(i6);
        this.size--;
        this.canRemove = false;
    }

    public IndexBasedArrayIterator(int i6) {
        this.size = i6;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            T elementAt = elementAt(this.index);
            this.index++;
            this.canRemove = true;
            return elementAt;
        }
        throw new NoSuchElementException();
    }
}
