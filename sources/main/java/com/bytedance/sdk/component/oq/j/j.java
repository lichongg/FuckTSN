package com.bytedance.sdk.component.oq.j;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j<T> implements BlockingQueue<T> {

    /* renamed from: j, reason: collision with root package name */
    private final BlockingQueue<T> f26624j;

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        return this.f26624j.drainTo(collection);
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean offer(T t5) {
        return this.f26624j.offer(t5);
    }

    @Override // java.util.concurrent.BlockingQueue
    public T poll(long j6, TimeUnit timeUnit) throws InterruptedException {
        try {
            return this.f26624j.poll(j6, timeUnit);
        } catch (IllegalMonitorStateException unused) {
            return null;
        }
    }

    @Override // java.util.Queue
    public T remove() {
        return this.f26624j.remove();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return new Object[0];
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection
    public boolean add(T t5) {
        return this.f26624j.add(t5);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        return this.f26624j.addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        this.f26624j.clear();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean contains(Object obj) {
        return this.f26624j.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.f26624j.containsAll(collection);
    }

    public int cw() {
        return this.f26624j.size();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i6) {
        return this.f26624j.drainTo(collection, i6);
    }

    @Override // java.util.Queue
    public T element() {
        return this.f26624j.element();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f26624j.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f26624j.iterator();
    }

    public final String j() {
        return this.f26624j.getClass().getName();
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(T t5, long j6, TimeUnit timeUnit) throws InterruptedException {
        return this.f26624j.offer(t5, j6, timeUnit);
    }

    @Override // java.util.Queue
    public T peek() {
        return this.f26624j.peek();
    }

    @Override // java.util.Queue
    public T poll() {
        return this.f26624j.poll();
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(T t5) throws InterruptedException {
        this.f26624j.put(t5);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.f26624j.remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean remove(Object obj) {
        return this.f26624j.remove(obj);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.f26624j.removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.f26624j.retainAll(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public T take() throws InterruptedException {
        return this.f26624j.take();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    public final BlockingQueue xt() {
        return this.f26624j;
    }

    public j(BlockingQueue blockingQueue) {
        if (blockingQueue == null) {
            this.f26624j = new SynchronousQueue();
        } else {
            this.f26624j = blockingQueue;
        }
    }

    @Override // java.util.Collection
    public final int size() {
        return cw();
    }
}
