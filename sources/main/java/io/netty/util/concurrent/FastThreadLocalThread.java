package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FastThreadLocalThread extends Thread {
    private final boolean cleanupFastThreadLocals;
    private InternalThreadLocalMap threadLocalMap;

    public FastThreadLocalThread() {
        this.cleanupFastThreadLocals = false;
    }

    public boolean willCleanupFastThreadLocals() {
        return this.cleanupFastThreadLocals;
    }

    public static boolean willCleanupFastThreadLocals(Thread thread) {
        return (thread instanceof FastThreadLocalThread) && ((FastThreadLocalThread) thread).willCleanupFastThreadLocals();
    }

    public final void setThreadLocalMap(InternalThreadLocalMap internalThreadLocalMap) {
        this.threadLocalMap = internalThreadLocalMap;
    }

    public final InternalThreadLocalMap threadLocalMap() {
        return this.threadLocalMap;
    }

    public FastThreadLocalThread(Runnable runnable) {
        super(FastThreadLocalRunnable.wrap(runnable));
        this.cleanupFastThreadLocals = true;
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, FastThreadLocalRunnable.wrap(runnable));
        this.cleanupFastThreadLocals = true;
    }

    public FastThreadLocalThread(String str) {
        super(str);
        this.cleanupFastThreadLocals = false;
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
        this.cleanupFastThreadLocals = false;
    }

    public FastThreadLocalThread(Runnable runnable, String str) {
        super(FastThreadLocalRunnable.wrap(runnable), str);
        this.cleanupFastThreadLocals = true;
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, FastThreadLocalRunnable.wrap(runnable), str);
        this.cleanupFastThreadLocals = true;
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable, String str, long j6) {
        super(threadGroup, FastThreadLocalRunnable.wrap(runnable), str, j6);
        this.cleanupFastThreadLocals = true;
    }
}
