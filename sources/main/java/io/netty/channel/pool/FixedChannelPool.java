package io.netty.channel.pool;

import com.umeng.ccg.a;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FixedChannelPool extends SimpleChannelPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long acquireTimeoutNanos;
    private final AtomicInteger acquiredChannelCount;
    private boolean closed;
    private final EventExecutor executor;
    private final int maxConnections;
    private final int maxPendingAcquires;
    private int pendingAcquireCount;
    private final Queue<AcquireTask> pendingAcquireQueue;
    private final Runnable timeoutTask;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class AcquireListener implements FutureListener<Channel> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected boolean acquired;
        private final Promise<Channel> originalPromise;

        AcquireListener(Promise<Channel> promise) {
            this.originalPromise = promise;
        }

        public void acquired() {
            if (this.acquired) {
                return;
            }
            FixedChannelPool.this.acquiredChannelCount.incrementAndGet();
            this.acquired = true;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(Future<Channel> future) throws Exception {
            if (FixedChannelPool.this.closed) {
                if (future.isSuccess()) {
                    future.getNow().close();
                }
                this.originalPromise.setFailure(new IllegalStateException("FixedChannelPool was closed"));
            } else {
                if (future.isSuccess()) {
                    this.originalPromise.setSuccess(future.getNow());
                    return;
                }
                if (this.acquired) {
                    FixedChannelPool.this.decrementAndRunTaskQueue();
                } else {
                    FixedChannelPool.this.runTaskQueue();
                }
                this.originalPromise.setFailure(future.cause());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class AcquireTask extends AcquireListener {
        final long expireNanoTime;
        final Promise<Channel> promise;
        ScheduledFuture<?> timeoutFuture;

        AcquireTask(Promise<Channel> promise) {
            super(promise);
            this.expireNanoTime = System.nanoTime() + FixedChannelPool.this.acquireTimeoutNanos;
            this.promise = FixedChannelPool.this.executor.newPromise().addListener((GenericFutureListener) this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AcquireTimeoutAction {
        NEW,
        FAIL
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, int i6) {
        this(bootstrap, channelPoolHandler, i6, Integer.MAX_VALUE);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.channel.pool.FixedChannelPool$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction;

        static {
            int[] iArr = new int[AcquireTimeoutAction.values().length];
            $SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction = iArr;
            try {
                iArr[AcquireTimeoutAction.FAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction[AcquireTimeoutAction.NEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private abstract class TimeoutTask implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private TimeoutTask() {
        }

        public abstract void onTimeout(AcquireTask acquireTask);

        @Override // java.lang.Runnable
        public final void run() {
            long nanoTime = System.nanoTime();
            while (true) {
                AcquireTask acquireTask = (AcquireTask) FixedChannelPool.this.pendingAcquireQueue.peek();
                if (acquireTask != null && nanoTime - acquireTask.expireNanoTime >= 0) {
                    FixedChannelPool.this.pendingAcquireQueue.remove();
                    FixedChannelPool.access$806(FixedChannelPool.this);
                    onTimeout(acquireTask);
                } else {
                    return;
                }
            }
        }
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, int i6, int i7) {
        this(bootstrap, channelPoolHandler, ChannelHealthChecker.ACTIVE, null, -1L, i6, i7);
    }

    static /* synthetic */ int access$806(FixedChannelPool fixedChannelPool) {
        int i6 = fixedChannelPool.pendingAcquireCount - 1;
        fixedChannelPool.pendingAcquireCount = i6;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acquire0(Promise<Channel> promise) {
        if (this.closed) {
            promise.setFailure(new IllegalStateException("FixedChannelPool was closed"));
            return;
        }
        if (this.acquiredChannelCount.get() < this.maxConnections) {
            Promise<Channel> newPromise = this.executor.newPromise();
            AcquireListener acquireListener = new AcquireListener(promise);
            acquireListener.acquired();
            newPromise.addListener((GenericFutureListener<? extends Future<? super Channel>>) acquireListener);
            super.acquire(newPromise);
            return;
        }
        if (this.pendingAcquireCount >= this.maxPendingAcquires) {
            tooManyOutstanding(promise);
            return;
        }
        AcquireTask acquireTask = new AcquireTask(promise);
        if (!this.pendingAcquireQueue.offer(acquireTask)) {
            tooManyOutstanding(promise);
            return;
        }
        this.pendingAcquireCount++;
        Runnable runnable = this.timeoutTask;
        if (runnable != null) {
            acquireTask.timeoutFuture = this.executor.schedule(runnable, this.acquireTimeoutNanos, TimeUnit.NANOSECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Future<Void> close0() {
        if (this.closed) {
            return GlobalEventExecutor.INSTANCE.newSucceededFuture(null);
        }
        this.closed = true;
        while (true) {
            AcquireTask poll = this.pendingAcquireQueue.poll();
            if (poll == null) {
                this.acquiredChannelCount.set(0);
                this.pendingAcquireCount = 0;
                return GlobalEventExecutor.INSTANCE.submit((Callable) new Callable<Void>() { // from class: io.netty.channel.pool.FixedChannelPool.6
                    @Override // java.util.concurrent.Callable
                    public Void call() throws Exception {
                        FixedChannelPool.super.close();
                        return null;
                    }
                });
            }
            ScheduledFuture<?> scheduledFuture = poll.timeoutFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            poll.promise.setFailure(new ClosedChannelException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decrementAndRunTaskQueue() {
        this.acquiredChannelCount.decrementAndGet();
        runTaskQueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runTaskQueue() {
        AcquireTask poll;
        while (this.acquiredChannelCount.get() < this.maxConnections && (poll = this.pendingAcquireQueue.poll()) != null) {
            ScheduledFuture<?> scheduledFuture = poll.timeoutFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.pendingAcquireCount--;
            poll.acquired();
            super.acquire(poll.promise);
        }
    }

    private void tooManyOutstanding(Promise<?> promise) {
        promise.setFailure(new IllegalStateException("Too many outstanding acquire operations"));
    }

    @Override // io.netty.channel.pool.SimpleChannelPool, io.netty.channel.pool.ChannelPool
    public Future<Channel> acquire(final Promise<Channel> promise) {
        try {
            if (this.executor.inEventLoop()) {
                acquire0(promise);
                return promise;
            }
            this.executor.execute(new Runnable() { // from class: io.netty.channel.pool.FixedChannelPool.3
                @Override // java.lang.Runnable
                public void run() {
                    FixedChannelPool.this.acquire0(promise);
                }
            });
            return promise;
        } catch (Throwable th) {
            promise.setFailure(th);
            return promise;
        }
    }

    public int acquiredChannelCount() {
        return this.acquiredChannelCount.get();
    }

    public Future<Void> closeAsync() {
        if (this.executor.inEventLoop()) {
            return close0();
        }
        final Promise newPromise = this.executor.newPromise();
        this.executor.execute(new Runnable() { // from class: io.netty.channel.pool.FixedChannelPool.5
            @Override // java.lang.Runnable
            public void run() {
                FixedChannelPool.this.close0().addListener(new FutureListener<Void>() { // from class: io.netty.channel.pool.FixedChannelPool.5.1
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future<Void> future) throws Exception {
                        if (future.isSuccess()) {
                            newPromise.setSuccess(null);
                        } else {
                            newPromise.setFailure(future.cause());
                        }
                    }
                });
            }
        });
        return newPromise;
    }

    @Override // io.netty.channel.pool.SimpleChannelPool, io.netty.channel.pool.ChannelPool
    public Future<Void> release(final Channel channel, final Promise<Void> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        super.release(channel, this.executor.newPromise().addListener((GenericFutureListener) new FutureListener<Void>() { // from class: io.netty.channel.pool.FixedChannelPool.4
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Void> future) throws Exception {
                if (FixedChannelPool.this.closed) {
                    channel.close();
                    promise.setFailure(new IllegalStateException("FixedChannelPool was closed"));
                } else if (future.isSuccess()) {
                    FixedChannelPool.this.decrementAndRunTaskQueue();
                    promise.setSuccess(null);
                } else {
                    if (!(future.cause() instanceof IllegalArgumentException)) {
                        FixedChannelPool.this.decrementAndRunTaskQueue();
                    }
                    promise.setFailure(future.cause());
                }
            }
        }));
        return promise;
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, ChannelHealthChecker channelHealthChecker, AcquireTimeoutAction acquireTimeoutAction, long j6, int i6, int i7) {
        this(bootstrap, channelPoolHandler, channelHealthChecker, acquireTimeoutAction, j6, i6, i7, true);
    }

    @Override // io.netty.channel.pool.SimpleChannelPool, io.netty.channel.pool.ChannelPool, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            closeAsync().await();
        } catch (InterruptedException e6) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e6);
        }
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, ChannelHealthChecker channelHealthChecker, AcquireTimeoutAction acquireTimeoutAction, long j6, int i6, int i7, boolean z5) {
        this(bootstrap, channelPoolHandler, channelHealthChecker, acquireTimeoutAction, j6, i6, i7, z5, true);
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, ChannelHealthChecker channelHealthChecker, AcquireTimeoutAction acquireTimeoutAction, long j6, int i6, int i7, boolean z5, boolean z6) {
        super(bootstrap, channelPoolHandler, channelHealthChecker, z5, z6);
        this.pendingAcquireQueue = new ArrayDeque();
        this.acquiredChannelCount = new AtomicInteger();
        if (i6 < 1) {
            throw new IllegalArgumentException("maxConnections: " + i6 + " (expected: >= 1)");
        }
        if (i7 < 1) {
            throw new IllegalArgumentException("maxPendingAcquires: " + i7 + " (expected: >= 1)");
        }
        if (acquireTimeoutAction == null && j6 == -1) {
            this.timeoutTask = null;
            this.acquireTimeoutNanos = -1L;
        } else {
            if (acquireTimeoutAction == null && j6 != -1) {
                throw new NullPointerException(a.f41544t);
            }
            if (acquireTimeoutAction != null && j6 < 0) {
                throw new IllegalArgumentException("acquireTimeoutMillis: " + j6 + " (expected: >= 0)");
            }
            this.acquireTimeoutNanos = TimeUnit.MILLISECONDS.toNanos(j6);
            int i8 = AnonymousClass7.$SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction[acquireTimeoutAction.ordinal()];
            if (i8 == 1) {
                this.timeoutTask = new TimeoutTask() { // from class: io.netty.channel.pool.FixedChannelPool.1
                    @Override // io.netty.channel.pool.FixedChannelPool.TimeoutTask
                    public void onTimeout(AcquireTask acquireTask) {
                        acquireTask.promise.setFailure(new TimeoutException("Acquire operation took longer then configured maximum time") { // from class: io.netty.channel.pool.FixedChannelPool.1.1
                            @Override // java.lang.Throwable
                            public synchronized Throwable fillInStackTrace() {
                                return this;
                            }
                        });
                    }
                };
            } else if (i8 == 2) {
                this.timeoutTask = new TimeoutTask() { // from class: io.netty.channel.pool.FixedChannelPool.2
                    @Override // io.netty.channel.pool.FixedChannelPool.TimeoutTask
                    public void onTimeout(AcquireTask acquireTask) {
                        acquireTask.acquired();
                        FixedChannelPool.super.acquire(acquireTask.promise);
                    }
                };
            } else {
                throw new Error();
            }
        }
        this.executor = bootstrap.config().group().next();
        this.maxConnections = i6;
        this.maxPendingAcquires = i7;
    }
}
