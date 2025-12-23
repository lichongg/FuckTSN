package com.google.common.util.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class ForwardingCondition implements Condition {
    @Override // java.util.concurrent.locks.Condition
    public void await() throws InterruptedException {
        delegate().await();
    }

    abstract Condition delegate();

    @Override // java.util.concurrent.locks.Condition
    public boolean await(long j6, TimeUnit timeUnit) throws InterruptedException {
        return delegate().await(j6, timeUnit);
    }

    ForwardingCondition() {
    }

    @Override // java.util.concurrent.locks.Condition
    public long awaitNanos(long j6) throws InterruptedException {
        return delegate().awaitNanos(j6);
    }

    @Override // java.util.concurrent.locks.Condition
    public void awaitUninterruptibly() {
        delegate().awaitUninterruptibly();
    }

    @Override // java.util.concurrent.locks.Condition
    public boolean awaitUntil(Date date) throws InterruptedException {
        return delegate().awaitUntil(date);
    }

    @Override // java.util.concurrent.locks.Condition
    public void signal() {
        delegate().signal();
    }

    @Override // java.util.concurrent.locks.Condition
    public void signalAll() {
        delegate().signalAll();
    }
}
