package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class LimitQueue<E> extends ConcurrentLinkedQueue<E> {
    private static final String TAG = "LimitQueue";
    private static final long serialVersionUID = -4636313759149307798L;
    private boolean deduplication;
    private int limit;

    public LimitQueue(int i6) {
        this.deduplication = false;
        this.limit = i6;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e6) {
        if (this.deduplication) {
            super.remove(e6);
        }
        if (super.size() >= this.limit) {
            super.poll();
        }
        return super.add(e6);
    }

    public int getLimit() {
        return this.limit;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public boolean offer(E e6) {
        if (this.deduplication) {
            super.remove(e6);
        }
        if (super.size() >= this.limit) {
            super.poll();
        }
        return super.offer(e6);
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.size() > this.limit) {
            return false;
        }
        if (this.deduplication) {
            super.removeAll(collection);
        }
        for (int size = (collection.size() + super.size()) - this.limit; size > 0; size--) {
            super.poll();
        }
        return super.addAll(collection);
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        super.clear();
    }

    public E get(int i6) {
        Iterator<E> it = iterator();
        E e6 = null;
        for (int i7 = 0; i7 <= i6 && it.hasNext(); i7++) {
            e6 = it.next();
        }
        return e6;
    }

    public E peekLast() {
        Iterator<E> it = iterator();
        E e6 = null;
        while (it.hasNext()) {
            e6 = it.next();
        }
        return e6;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public E poll() {
        return (E) super.poll();
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        try {
            return (E) super.remove();
        } catch (NoSuchElementException unused) {
            Logger.w(TAG, "remove failed, limitQueue is empty");
            return null;
        }
    }

    public LimitQueue(int i6, boolean z5) {
        this.limit = i6;
        this.deduplication = z5;
    }

    public LimitQueue(Collection<? extends E> collection, boolean z5) {
        this(collection.size(), z5);
        addAll(collection);
    }
}
