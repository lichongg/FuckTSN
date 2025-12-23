package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Deque;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract Deque<E> delegate();

    protected ForwardingDeque() {
    }

    @Override // java.util.Deque
    public void addFirst(E e6) {
        delegate().addFirst(e6);
    }

    @Override // java.util.Deque
    public void addLast(E e6) {
        delegate().addLast(e6);
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.Deque
    public E getFirst() {
        return delegate().getFirst();
    }

    @Override // java.util.Deque
    public E getLast() {
        return delegate().getLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean offerFirst(E e6) {
        return delegate().offerFirst(e6);
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean offerLast(E e6) {
        return delegate().offerLast(e6);
    }

    @Override // java.util.Deque
    public E peekFirst() {
        return delegate().peekFirst();
    }

    @Override // java.util.Deque
    public E peekLast() {
        return delegate().peekLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E pollLast() {
        return delegate().pollLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E pop() {
        return delegate().pop();
    }

    @Override // java.util.Deque
    public void push(E e6) {
        delegate().push(e6);
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E removeFirst() {
        return delegate().removeFirst();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean removeFirstOccurrence(Object obj) {
        return delegate().removeFirstOccurrence(obj);
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E removeLast() {
        return delegate().removeLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean removeLastOccurrence(Object obj) {
        return delegate().removeLastOccurrence(obj);
    }
}
