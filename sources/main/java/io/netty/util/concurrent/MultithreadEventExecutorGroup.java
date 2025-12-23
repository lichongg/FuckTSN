package io.netty.util.concurrent;

import io.netty.util.concurrent.EventExecutorChooserFactory;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class MultithreadEventExecutorGroup extends AbstractEventExecutorGroup {
    private final EventExecutor[] children;
    private final EventExecutorChooserFactory.EventExecutorChooser chooser;
    private final Set<EventExecutor> readonlyChildren;
    private final AtomicInteger terminatedChildren;
    private final Promise<?> terminationFuture;

    protected MultithreadEventExecutorGroup(int i6, ThreadFactory threadFactory, Object... objArr) {
        this(i6, threadFactory == null ? null : new ThreadPerTaskExecutor(threadFactory), objArr);
    }

    protected abstract EventExecutor newChild(Executor executor, Object... objArr) throws Exception;

    protected MultithreadEventExecutorGroup(int i6, Executor executor, Object... objArr) {
        this(i6, executor, DefaultEventExecutorChooserFactory.INSTANCE, objArr);
    }

    public final int executorCount() {
        return this.children.length;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        for (EventExecutor eventExecutor : this.children) {
            if (!eventExecutor.isShutdown()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        for (EventExecutor eventExecutor : this.children) {
            if (!eventExecutor.isShuttingDown()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        for (EventExecutor eventExecutor : this.children) {
            if (!eventExecutor.isTerminated()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    public Iterator<EventExecutor> iterator() {
        return this.readonlyChildren.iterator();
    }

    protected ThreadFactory newDefaultThreadFactory() {
        return new DefaultThreadFactory(getClass());
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public EventExecutor next() {
        return this.chooser.next();
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutorGroup, io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    @Deprecated
    public void shutdown() {
        for (EventExecutor eventExecutor : this.children) {
            eventExecutor.shutdown();
        }
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j6, long j7, TimeUnit timeUnit) {
        for (EventExecutor eventExecutor : this.children) {
            eventExecutor.shutdownGracefully(j6, j7, timeUnit);
        }
        return terminationFuture();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    protected MultithreadEventExecutorGroup(int i6, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, Object... objArr) {
        this.terminatedChildren = new AtomicInteger();
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        int i7 = 0;
        if (i6 > 0) {
            executor = executor == null ? new ThreadPerTaskExecutor(newDefaultThreadFactory()) : executor;
            this.children = new EventExecutor[i6];
            for (int i8 = 0; i8 < i6; i8++) {
                try {
                    try {
                        this.children[i8] = newChild(executor, objArr);
                    } catch (Exception e6) {
                        throw new IllegalStateException("failed to create a child event loop", e6);
                    }
                } catch (Throwable th) {
                    for (int i9 = 0; i9 < i8; i9++) {
                        this.children[i9].shutdownGracefully();
                    }
                    while (i7 < i8) {
                        EventExecutor eventExecutor = this.children[i7];
                        while (!eventExecutor.isTerminated()) {
                            try {
                                eventExecutor.awaitTermination(2147483647L, TimeUnit.SECONDS);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                throw th;
                            }
                        }
                        i7++;
                    }
                    throw th;
                }
            }
            this.chooser = eventExecutorChooserFactory.newChooser(this.children);
            FutureListener<Object> futureListener = new FutureListener<Object>() { // from class: io.netty.util.concurrent.MultithreadEventExecutorGroup.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<Object> future) throws Exception {
                    if (MultithreadEventExecutorGroup.this.terminatedChildren.incrementAndGet() == MultithreadEventExecutorGroup.this.children.length) {
                        MultithreadEventExecutorGroup.this.terminationFuture.setSuccess(null);
                    }
                }
            };
            EventExecutor[] eventExecutorArr = this.children;
            int length = eventExecutorArr.length;
            while (i7 < length) {
                eventExecutorArr[i7].terminationFuture().addListener(futureListener);
                i7++;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.children.length);
            Collections.addAll(linkedHashSet, this.children);
            this.readonlyChildren = Collections.unmodifiableSet(linkedHashSet);
            return;
        }
        throw new IllegalArgumentException(String.format("nThreads: %d (expected: > 0)", Integer.valueOf(i6)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j6, TimeUnit timeUnit) throws InterruptedException {
        long nanoTime;
        long nanoTime2 = System.nanoTime() + timeUnit.toNanos(j6);
        loop0: for (EventExecutor eventExecutor : this.children) {
            do {
                nanoTime = nanoTime2 - System.nanoTime();
                if (nanoTime <= 0) {
                    break loop0;
                }
            } while (!eventExecutor.awaitTermination(nanoTime, TimeUnit.NANOSECONDS));
        }
        return isTerminated();
    }
}
