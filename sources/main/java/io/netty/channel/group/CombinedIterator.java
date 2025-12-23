package io.netty.channel.group;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class CombinedIterator<E> implements Iterator<E> {
    private Iterator<E> currentIterator;

    /* renamed from: i1, reason: collision with root package name */
    private final Iterator<E> f43058i1;

    /* renamed from: i2, reason: collision with root package name */
    private final Iterator<E> f43059i2;

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (!this.currentIterator.hasNext()) {
            if (this.currentIterator != this.f43058i1) {
                return false;
            }
            this.currentIterator = this.f43059i2;
        }
        return true;
    }

    @Override // java.util.Iterator
    public E next() {
        while (true) {
            try {
                return this.currentIterator.next();
            } catch (NoSuchElementException e6) {
                if (this.currentIterator != this.f43058i1) {
                    throw e6;
                }
                this.currentIterator = this.f43059i2;
            }
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        this.currentIterator.remove();
    }

    CombinedIterator(Iterator<E> it, Iterator<E> it2) {
        if (it != null) {
            if (it2 != null) {
                this.f43058i1 = it;
                this.f43059i2 = it2;
                this.currentIterator = it;
                return;
            }
            throw new NullPointerException("i2");
        }
        throw new NullPointerException("i1");
    }
}
