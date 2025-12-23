package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingQueue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@CanIgnoreReturnValue
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract BlockingQueue<E> delegate();

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i6) {
        return delegate().drainTo(collection, i6);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return delegate().drainTo(collection);
    }

    protected ForwardingBlockingQueue() {
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e6, long j6, TimeUnit timeUnit) throws InterruptedException {
        return delegate().offer(e6, j6, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j6, TimeUnit timeUnit) throws InterruptedException {
        return delegate().poll(j6, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e6) throws InterruptedException {
        delegate().put(e6);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return delegate().take();
    }
}
