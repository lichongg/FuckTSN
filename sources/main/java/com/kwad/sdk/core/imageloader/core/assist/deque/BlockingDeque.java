package com.kwad.sdk.core.imageloader.core.assist.deque;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface BlockingDeque<E> extends Deque<E>, BlockingQueue<E> {
    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean add(E e6);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    void addFirst(E e6);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    void addLast(E e6);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean contains(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    E element();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue, java.util.concurrent.BlockingQueue
    boolean offer(E e6);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e6, long j6, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean offerFirst(E e6);

    boolean offerFirst(E e6, long j6, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean offerLast(E e6);

    boolean offerLast(E e6, long j6, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    E peek();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j6, TimeUnit timeUnit);

    E pollFirst(long j6, TimeUnit timeUnit);

    E pollLast(long j6, TimeUnit timeUnit);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    void push(E e6);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e6);

    void putFirst(E e6);

    void putLast(E e6);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Queue
    E remove();

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean remove(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean removeFirstOccurrence(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    boolean removeLastOccurrence(Object obj);

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.Collection
    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take();

    E takeFirst();

    E takeLast();
}
