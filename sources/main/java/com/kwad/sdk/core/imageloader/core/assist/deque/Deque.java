package com.kwad.sdk.core.imageloader.core.assist.deque;

import java.util.Iterator;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface Deque<E> extends Queue<E> {
    @Override // java.util.Queue, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean add(E e6);

    void addFirst(E e6);

    void addLast(E e6);

    @Override // java.util.Collection, java.util.concurrent.BlockingQueue
    boolean contains(Object obj);

    Iterator<E> descendingIterator();

    @Override // java.util.Queue
    E element();

    E getFirst();

    E getLast();

    @Override // java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    boolean offer(E e6);

    boolean offerFirst(E e6);

    boolean offerLast(E e6);

    @Override // java.util.Queue
    E peek();

    E peekFirst();

    E peekLast();

    @Override // java.util.Queue
    E poll();

    E pollFirst();

    E pollLast();

    E pop();

    void push(E e6);

    @Override // java.util.Queue
    E remove();

    @Override // java.util.Collection, java.util.concurrent.BlockingQueue
    boolean remove(Object obj);

    E removeFirst();

    boolean removeFirstOccurrence(Object obj);

    E removeLast();

    boolean removeLastOccurrence(Object obj);

    @Override // java.util.Collection
    int size();
}
