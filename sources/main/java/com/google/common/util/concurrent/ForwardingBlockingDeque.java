package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingDeque;
import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ForwardingBlockingDeque<E> extends ForwardingDeque<E> implements BlockingDeque<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingDeque, com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract BlockingDeque<E> delegate();

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return delegate().drainTo(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i6) {
        return delegate().drainTo(collection, i6);
    }

    protected ForwardingBlockingDeque() {
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E e6, long j6, TimeUnit timeUnit) throws InterruptedException {
        return delegate().offer(e6, j6, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerFirst(E e6, long j6, TimeUnit timeUnit) throws InterruptedException {
        return delegate().offerFirst(e6, j6, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerLast(E e6, long j6, TimeUnit timeUnit) throws InterruptedException {
        return delegate().offerLast(e6, j6, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E poll(long j6, TimeUnit timeUnit) throws InterruptedException {
        return delegate().poll(j6, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public E pollFirst(long j6, TimeUnit timeUnit) throws InterruptedException {
        return delegate().pollFirst(j6, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public E pollLast(long j6, TimeUnit timeUnit) throws InterruptedException {
        return delegate().pollLast(j6, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E e6) throws InterruptedException {
        delegate().put(e6);
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putFirst(E e6) throws InterruptedException {
        delegate().putFirst(e6);
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putLast(E e6) throws InterruptedException {
        delegate().putLast(e6);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return delegate().take();
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeFirst() throws InterruptedException {
        return delegate().takeFirst();
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeLast() throws InterruptedException {
        return delegate().takeLast();
    }
}
