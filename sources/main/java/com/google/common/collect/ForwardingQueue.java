package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract Queue<E> delegate();

    protected ForwardingQueue() {
    }

    @Override // java.util.Queue
    public E element() {
        return delegate().element();
    }

    @CanIgnoreReturnValue
    public boolean offer(E e6) {
        return delegate().offer(e6);
    }

    @Override // java.util.Queue
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E remove() {
        return delegate().remove();
    }

    protected boolean standardOffer(E e6) {
        try {
            return add(e6);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    protected E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    protected E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
