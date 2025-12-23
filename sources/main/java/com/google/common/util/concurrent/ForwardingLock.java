package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class ForwardingLock implements Lock {
    abstract Lock delegate();

    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock() {
        return delegate().tryLock();
    }

    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock(long j6, TimeUnit timeUnit) throws InterruptedException {
        return delegate().tryLock(j6, timeUnit);
    }

    ForwardingLock() {
    }

    @Override // java.util.concurrent.locks.Lock
    public void lock() {
        delegate().lock();
    }

    @Override // java.util.concurrent.locks.Lock
    public void lockInterruptibly() throws InterruptedException {
        delegate().lockInterruptibly();
    }

    @Override // java.util.concurrent.locks.Lock
    public Condition newCondition() {
        return delegate().newCondition();
    }

    @Override // java.util.concurrent.locks.Lock
    public void unlock() {
        delegate().unlock();
    }
}
