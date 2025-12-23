package io.netty.util.concurrent;

import androidx.concurrent.futures.a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultPromise<V> extends AbstractFuture<V> implements Promise<V> {
    private final EventExecutor executor;
    private Object listeners;
    private boolean notifyingListeners;
    private volatile Object result;
    private short waiters;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultPromise.class);
    private static final InternalLogger rejectedExecutionLogger = InternalLoggerFactory.getInstance(DefaultPromise.class.getName() + ".rejectedExecution");
    private static final int MAX_LISTENER_STACK_DEPTH = Math.min(8, SystemPropertyUtil.getInt("io.netty.defaultPromise.maxListenerStackDepth", 8));
    private static final AtomicReferenceFieldUpdater<DefaultPromise, Object> RESULT_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultPromise.class, Object.class, "result");
    private static final Object SUCCESS = new Object();
    private static final Object UNCANCELLABLE = new Object();

    public DefaultPromise(EventExecutor eventExecutor) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
    }

    private synchronized boolean checkNotifyWaiters() {
        try {
            if (this.waiters > 0) {
                notifyAll();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.listeners != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListenersNow() {
        Object obj;
        synchronized (this) {
            if (!this.notifyingListeners && (obj = this.listeners) != null) {
                this.notifyingListeners = true;
                this.listeners = null;
                while (true) {
                    if (obj instanceof DefaultFutureListeners) {
                        notifyListeners0((DefaultFutureListeners) obj);
                    } else {
                        notifyListener0(this, (GenericFutureListener) obj);
                    }
                    synchronized (this) {
                        try {
                            obj = this.listeners;
                            if (obj == null) {
                                this.notifyingListeners = false;
                                return;
                            }
                            this.listeners = null;
                        } finally {
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyProgressiveListener0(ProgressiveFuture progressiveFuture, GenericProgressiveFutureListener genericProgressiveFutureListener, long j6, long j7) {
        try {
            genericProgressiveFutureListener.operationProgressed(progressiveFuture, j6, j7);
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                logger.warn("An exception was thrown by " + genericProgressiveFutureListener.getClass().getName() + ".operationProgressed()", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyProgressiveListeners0(ProgressiveFuture<?> progressiveFuture, GenericProgressiveFutureListener<?>[] genericProgressiveFutureListenerArr, long j6, long j7) {
        for (GenericProgressiveFutureListener<?> genericProgressiveFutureListener : genericProgressiveFutureListenerArr) {
            if (genericProgressiveFutureListener == null) {
                return;
            }
            notifyProgressiveListener0(progressiveFuture, genericProgressiveFutureListener, j6, j7);
        }
    }

    private synchronized Object progressiveListeners() {
        Object obj = this.listeners;
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof DefaultFutureListeners)) {
            if (obj instanceof GenericProgressiveFutureListener) {
                return obj;
            }
            return null;
        }
        DefaultFutureListeners defaultFutureListeners = (DefaultFutureListeners) obj;
        int progressiveSize = defaultFutureListeners.progressiveSize();
        if (progressiveSize == 0) {
            return null;
        }
        int i6 = 0;
        if (progressiveSize == 1) {
            GenericFutureListener<? extends Future<?>>[] listeners = defaultFutureListeners.listeners();
            int length = listeners.length;
            while (i6 < length) {
                GenericFutureListener<? extends Future<?>> genericFutureListener = listeners[i6];
                if (genericFutureListener instanceof GenericProgressiveFutureListener) {
                    return genericFutureListener;
                }
                i6++;
            }
            return null;
        }
        GenericFutureListener<? extends Future<?>>[] listeners2 = defaultFutureListeners.listeners();
        GenericProgressiveFutureListener[] genericProgressiveFutureListenerArr = new GenericProgressiveFutureListener[progressiveSize];
        int i7 = 0;
        while (i6 < progressiveSize) {
            GenericFutureListener<? extends Future<?>> genericFutureListener2 = listeners2[i7];
            if (genericFutureListener2 instanceof GenericProgressiveFutureListener) {
                int i8 = i6 + 1;
                genericProgressiveFutureListenerArr[i6] = (GenericProgressiveFutureListener) genericFutureListener2;
                i6 = i8;
            }
            i7++;
        }
        return genericProgressiveFutureListenerArr;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class CauseHolder {
        final Throwable cause;

        CauseHolder(Throwable th) {
            this.cause = th;
        }
    }

    private void addListener0(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        Object obj = this.listeners;
        if (obj == null) {
            this.listeners = genericFutureListener;
        } else if (obj instanceof DefaultFutureListeners) {
            ((DefaultFutureListeners) obj).add(genericFutureListener);
        } else {
            this.listeners = new DefaultFutureListeners((GenericFutureListener) obj, genericFutureListener);
        }
    }

    private void decWaiters() {
        this.waiters = (short) (this.waiters - 1);
    }

    private void incWaiters() {
        short s5 = this.waiters;
        if (s5 != Short.MAX_VALUE) {
            this.waiters = (short) (s5 + 1);
            return;
        }
        throw new IllegalStateException("too many waiters: " + this);
    }

    private static boolean isCancelled0(Object obj) {
        return (obj instanceof CauseHolder) && (((CauseHolder) obj).cause instanceof CancellationException);
    }

    private static boolean isDone0(Object obj) {
        return (obj == null || obj == UNCANCELLABLE) ? false : true;
    }

    protected static void notifyListener(EventExecutor eventExecutor, Future<?> future, GenericFutureListener<?> genericFutureListener) {
        ObjectUtil.checkNotNull(eventExecutor, "eventExecutor");
        ObjectUtil.checkNotNull(future, "future");
        ObjectUtil.checkNotNull(genericFutureListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        notifyListenerWithStackOverFlowProtection(eventExecutor, future, genericFutureListener);
    }

    private void removeListener0(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        Object obj = this.listeners;
        if (obj instanceof DefaultFutureListeners) {
            ((DefaultFutureListeners) obj).remove(genericFutureListener);
        } else if (obj == genericFutureListener) {
            this.listeners = null;
        }
    }

    private boolean setFailure0(Throwable th) {
        return setValue0(new CauseHolder((Throwable) ObjectUtil.checkNotNull(th, "cause")));
    }

    private boolean setSuccess0(V v5) {
        if (v5 == null) {
            v5 = (V) SUCCESS;
        }
        return setValue0(v5);
    }

    private boolean setValue0(Object obj) {
        AtomicReferenceFieldUpdater<DefaultPromise, Object> atomicReferenceFieldUpdater = RESULT_UPDATER;
        if (!a.a(atomicReferenceFieldUpdater, this, null, obj) && !a.a(atomicReferenceFieldUpdater, this, UNCANCELLABLE, obj)) {
            return false;
        }
        if (!checkNotifyWaiters()) {
            return true;
        }
        notifyListeners();
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        ObjectUtil.checkNotNull(genericFutureListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this) {
            addListener0(genericFutureListener);
        }
        if (isDone()) {
            notifyListeners();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        ObjectUtil.checkNotNull(genericFutureListenerArr, "listeners");
        synchronized (this) {
            try {
                for (GenericFutureListener<? extends Future<? super V>> genericFutureListener : genericFutureListenerArr) {
                    if (genericFutureListener == null) {
                        break;
                    }
                    addListener0(genericFutureListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (isDone()) {
            notifyListeners();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> await() throws InterruptedException {
        if (isDone()) {
            return this;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException(toString());
        }
        checkDeadLock();
        synchronized (this) {
            while (!isDone()) {
                try {
                    incWaiters();
                    try {
                        wait();
                        decWaiters();
                    } catch (Throwable th) {
                        decWaiters();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> awaitUninterruptibly() {
        boolean z5;
        if (!isDone()) {
            checkDeadLock();
            synchronized (this) {
                z5 = false;
                while (!isDone()) {
                    try {
                        incWaiters();
                        try {
                            wait();
                            decWaiters();
                        } catch (InterruptedException unused) {
                            decWaiters();
                            z5 = true;
                        } catch (Throwable th) {
                            decWaiters();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            if (z5) {
                Thread.currentThread().interrupt();
            }
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        AtomicReferenceFieldUpdater<DefaultPromise, Object> atomicReferenceFieldUpdater = RESULT_UPDATER;
        if (atomicReferenceFieldUpdater.get(this) != null || !a.a(atomicReferenceFieldUpdater, this, null, new CauseHolder(new CancellationException()))) {
            return false;
        }
        if (!checkNotifyWaiters()) {
            return true;
        }
        notifyListeners();
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        Object obj = this.result;
        if (obj instanceof CauseHolder) {
            return ((CauseHolder) obj).cause;
        }
        return null;
    }

    protected EventExecutor executor() {
        return this.executor;
    }

    @Override // io.netty.util.concurrent.Future
    public V getNow() {
        V v5 = (V) this.result;
        if ((v5 instanceof CauseHolder) || v5 == SUCCESS || v5 == UNCANCELLABLE) {
            return null;
        }
        return v5;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return this.result == null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return isCancelled0(this.result);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return isDone0(this.result);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        Object obj = this.result;
        return (obj == null || obj == UNCANCELLABLE || (obj instanceof CauseHolder)) ? false : true;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        ObjectUtil.checkNotNull(genericFutureListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this) {
            removeListener0(genericFutureListener);
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        ObjectUtil.checkNotNull(genericFutureListenerArr, "listeners");
        synchronized (this) {
            try {
                for (GenericFutureListener<? extends Future<? super V>> genericFutureListener : genericFutureListenerArr) {
                    if (genericFutureListener != null) {
                        removeListener0(genericFutureListener);
                    }
                }
            } finally {
            }
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Promise
    public boolean setUncancellable() {
        if (a.a(RESULT_UPDATER, this, null, UNCANCELLABLE)) {
            return true;
        }
        Object obj = this.result;
        return (isDone0(obj) && isCancelled0(obj)) ? false : true;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> sync() throws InterruptedException {
        await();
        rethrowIfFailed();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> syncUninterruptibly() {
        awaitUninterruptibly();
        rethrowIfFailed();
        return this;
    }

    protected StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('@');
        sb.append(Integer.toHexString(hashCode()));
        Object obj = this.result;
        if (obj == SUCCESS) {
            sb.append("(success)");
            return sb;
        }
        if (obj == UNCANCELLABLE) {
            sb.append("(uncancellable)");
            return sb;
        }
        if (obj instanceof CauseHolder) {
            sb.append("(failure: ");
            sb.append(((CauseHolder) obj).cause);
            sb.append(')');
            return sb;
        }
        if (obj == null) {
            sb.append("(incomplete)");
            return sb;
        }
        sb.append("(success: ");
        sb.append(obj);
        sb.append(')');
        return sb;
    }

    protected DefaultPromise() {
        this.executor = null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:62:0x008a
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private boolean await0(long r13, boolean r15) throws java.lang.InterruptedException {
        /*
            r12 = this;
            boolean r0 = r12.isDone()
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            r2 = 0
            int r0 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r0 > 0) goto L13
            boolean r13 = r12.isDone()
            return r13
        L13:
            if (r15 == 0) goto L26
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 != 0) goto L1c
            goto L26
        L1c:
            java.lang.InterruptedException r13 = new java.lang.InterruptedException
            java.lang.String r14 = r12.toString()
            r13.<init>(r14)
            throw r13
        L26:
            r12.checkDeadLock()
            long r4 = java.lang.System.nanoTime()
            r0 = 0
            r6 = r13
        L2f:
            monitor-enter(r12)     // Catch: java.lang.Throwable -> L88
            boolean r8 = r12.isDone()     // Catch: java.lang.Throwable -> L41
            if (r8 == 0) goto L44
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L40
            java.lang.Thread r13 = java.lang.Thread.currentThread()
            r13.interrupt()
        L40:
            return r1
        L41:
            r13 = move-exception
            r1 = r0
            goto L91
        L44:
            r12.incWaiters()     // Catch: java.lang.Throwable -> L41
            r8 = 1000000(0xf4240, double:4.940656E-318)
            long r10 = r6 / r8
            long r6 = r6 % r8
            int r7 = (int) r6     // Catch: java.lang.Throwable -> L55 java.lang.InterruptedException -> L57
            r12.wait(r10, r7)     // Catch: java.lang.Throwable -> L55 java.lang.InterruptedException -> L57
            r12.decWaiters()     // Catch: java.lang.Throwable -> L41
            goto L5e
        L55:
            r13 = move-exception
            goto L8d
        L57:
            r6 = move-exception
            if (r15 != 0) goto L8c
            r12.decWaiters()     // Catch: java.lang.Throwable -> L8a
            r0 = 1
        L5e:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L41
            boolean r6 = r12.isDone()     // Catch: java.lang.Throwable -> L88
            if (r6 == 0) goto L6f
            if (r0 == 0) goto L6e
            java.lang.Thread r13 = java.lang.Thread.currentThread()
            r13.interrupt()
        L6e:
            return r1
        L6f:
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L88
            long r6 = r6 - r4
            long r6 = r13 - r6
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 > 0) goto L2f
            boolean r13 = r12.isDone()     // Catch: java.lang.Throwable -> L88
            if (r0 == 0) goto L87
            java.lang.Thread r14 = java.lang.Thread.currentThread()
            r14.interrupt()
        L87:
            return r13
        L88:
            r13 = move-exception
            goto L95
        L8a:
            r13 = move-exception
            goto L91
        L8c:
            throw r6     // Catch: java.lang.Throwable -> L55
        L8d:
            r12.decWaiters()     // Catch: java.lang.Throwable -> L41
            throw r13     // Catch: java.lang.Throwable -> L41
        L91:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L8a
            throw r13     // Catch: java.lang.Throwable -> L93
        L93:
            r13 = move-exception
            r0 = r1
        L95:
            if (r0 == 0) goto L9e
            java.lang.Thread r14 = java.lang.Thread.currentThread()
            r14.interrupt()
        L9e:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.DefaultPromise.await0(long, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyListener0(Future future, GenericFutureListener genericFutureListener) {
        try {
            genericFutureListener.operationComplete(future);
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                logger.warn("An exception was thrown by " + genericFutureListener.getClass().getName() + ".operationComplete()", th);
            }
        }
    }

    private static void notifyListenerWithStackOverFlowProtection(EventExecutor eventExecutor, final Future<?> future, final GenericFutureListener<?> genericFutureListener) {
        InternalThreadLocalMap internalThreadLocalMap;
        int futureListenerStackDepth;
        if (eventExecutor.inEventLoop() && (futureListenerStackDepth = (internalThreadLocalMap = InternalThreadLocalMap.get()).futureListenerStackDepth()) < MAX_LISTENER_STACK_DEPTH) {
            internalThreadLocalMap.setFutureListenerStackDepth(futureListenerStackDepth + 1);
            try {
                notifyListener0(future, genericFutureListener);
                return;
            } finally {
                internalThreadLocalMap.setFutureListenerStackDepth(futureListenerStackDepth);
            }
        }
        safeExecute(eventExecutor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.2
            @Override // java.lang.Runnable
            public void run() {
                DefaultPromise.notifyListener0(Future.this, genericFutureListener);
            }
        });
    }

    private void notifyListeners() {
        InternalThreadLocalMap internalThreadLocalMap;
        int futureListenerStackDepth;
        EventExecutor executor = executor();
        if (executor.inEventLoop() && (futureListenerStackDepth = (internalThreadLocalMap = InternalThreadLocalMap.get()).futureListenerStackDepth()) < MAX_LISTENER_STACK_DEPTH) {
            internalThreadLocalMap.setFutureListenerStackDepth(futureListenerStackDepth + 1);
            try {
                notifyListenersNow();
                return;
            } finally {
                internalThreadLocalMap.setFutureListenerStackDepth(futureListenerStackDepth);
            }
        }
        safeExecute(executor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultPromise.this.notifyListenersNow();
            }
        });
    }

    private void notifyListeners0(DefaultFutureListeners defaultFutureListeners) {
        GenericFutureListener<? extends Future<?>>[] listeners = defaultFutureListeners.listeners();
        int size = defaultFutureListeners.size();
        for (int i6 = 0; i6 < size; i6++) {
            notifyListener0(this, listeners[i6]);
        }
    }

    private void rethrowIfFailed() {
        Throwable cause = cause();
        if (cause == null) {
            return;
        }
        PlatformDependent.throwException(cause);
    }

    private static void safeExecute(EventExecutor eventExecutor, Runnable runnable) {
        try {
            eventExecutor.execute(runnable);
        } catch (Throwable th) {
            rejectedExecutionLogger.error("Failed to submit a listener notification task. Event loop shut down?", th);
        }
    }

    protected void checkDeadLock() {
        EventExecutor executor = executor();
        if (executor != null && executor.inEventLoop()) {
            throw new BlockingOperationException(toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void notifyProgressiveListeners(final long j6, final long j7) {
        Object progressiveListeners = progressiveListeners();
        if (progressiveListeners == null) {
            return;
        }
        final ProgressiveFuture progressiveFuture = (ProgressiveFuture) this;
        EventExecutor executor = executor();
        if (executor.inEventLoop()) {
            if (progressiveListeners instanceof GenericProgressiveFutureListener[]) {
                notifyProgressiveListeners0(progressiveFuture, (GenericProgressiveFutureListener[]) progressiveListeners, j6, j7);
                return;
            } else {
                notifyProgressiveListener0(progressiveFuture, (GenericProgressiveFutureListener) progressiveListeners, j6, j7);
                return;
            }
        }
        if (progressiveListeners instanceof GenericProgressiveFutureListener[]) {
            final GenericProgressiveFutureListener[] genericProgressiveFutureListenerArr = (GenericProgressiveFutureListener[]) progressiveListeners;
            safeExecute(executor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.3
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyProgressiveListeners0(progressiveFuture, genericProgressiveFutureListenerArr, j6, j7);
                }
            });
        } else {
            final GenericProgressiveFutureListener genericProgressiveFutureListener = (GenericProgressiveFutureListener) progressiveListeners;
            safeExecute(executor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.4
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyProgressiveListener0(progressiveFuture, genericProgressiveFutureListener, j6, j7);
                }
            });
        }
    }

    public Promise<V> setFailure(Throwable th) {
        if (setFailure0(th)) {
            return this;
        }
        throw new IllegalStateException("complete already: " + this, th);
    }

    public Promise<V> setSuccess(V v5) {
        if (setSuccess0(v5)) {
            return this;
        }
        throw new IllegalStateException("complete already: " + this);
    }

    public String toString() {
        return toStringBuilder().toString();
    }

    public boolean tryFailure(Throwable th) {
        return setFailure0(th);
    }

    public boolean trySuccess(V v5) {
        return setSuccess0(v5);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j6, TimeUnit timeUnit) throws InterruptedException {
        return await0(timeUnit.toNanos(j6), true);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j6) throws InterruptedException {
        return await0(TimeUnit.MILLISECONDS.toNanos(j6), true);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j6, TimeUnit timeUnit) {
        try {
            return await0(timeUnit.toNanos(j6), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j6) {
        try {
            return await0(TimeUnit.MILLISECONDS.toNanos(j6), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }
}
