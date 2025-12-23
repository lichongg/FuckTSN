package io.netty.util.internal;

import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ReadOnlyIterator<T> implements Iterator<T> {
    private final Iterator<? extends T> iterator;

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("read-only");
    }

    public ReadOnlyIterator(Iterator<? extends T> it) {
        if (it != null) {
            this.iterator = it;
            return;
        }
        throw new NullPointerException("iterator");
    }
}
