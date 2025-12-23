package kotlin.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "LocksKt")
@SourceDebugExtension({"SMAP\nLocks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Locks.kt\nkotlin/concurrent/LocksKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n1#2:75\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {
    @InlineOnly
    private static final <T> T a(ReentrantReadWriteLock reentrantReadWriteLock, Function0<? extends T> action) {
        g0.p(reentrantReadWriteLock, "<this>");
        g0.p(action, "action");
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            return action.invoke();
        } finally {
            d0.d(1);
            readLock.unlock();
            d0.c(1);
        }
    }

    @InlineOnly
    private static final <T> T b(Lock lock, Function0<? extends T> action) {
        g0.p(lock, "<this>");
        g0.p(action, "action");
        lock.lock();
        try {
            return action.invoke();
        } finally {
            d0.d(1);
            lock.unlock();
            d0.c(1);
        }
    }

    @InlineOnly
    private static final <T> T c(ReentrantReadWriteLock reentrantReadWriteLock, Function0<? extends T> action) {
        g0.p(reentrantReadWriteLock, "<this>");
        g0.p(action, "action");
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i6 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i7 = 0; i7 < readHoldCount; i7++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            return action.invoke();
        } finally {
            d0.d(1);
            while (i6 < readHoldCount) {
                readLock.lock();
                i6++;
            }
            writeLock.unlock();
            d0.c(1);
        }
    }
}
