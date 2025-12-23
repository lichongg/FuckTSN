package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class NonStickyEventExecutorGroup implements EventExecutorGroup {
    private final EventExecutorGroup group;
    private final int maxTaskExecutePerRun;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class NonStickyOrderedEventExecutor extends AbstractEventExecutor implements Runnable, OrderedEventExecutor {
        private static final int NONE = 0;
        private static final int RUNNING = 2;
        private static final int SUBMITTED = 1;
        private final EventExecutor executor;
        private final int maxTaskExecutePerRun;
        private final AtomicInteger state;
        private final Queue<Runnable> tasks;

        @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
        public boolean inEventLoop() {
            return false;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j6, TimeUnit timeUnit) throws InterruptedException {
            return this.executor.awaitTermination(j6, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (!this.tasks.offer(runnable)) {
                throw new RejectedExecutionException();
            }
            if (this.state.compareAndSet(0, 1)) {
                try {
                    this.executor.execute(this);
                } catch (Throwable th) {
                    this.tasks.remove(runnable);
                    PlatformDependent.throwException(th);
                }
            }
        }

        @Override // io.netty.util.concurrent.EventExecutor
        public boolean inEventLoop(Thread thread) {
            return false;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.executor.isShutdown();
        }

        @Override // io.netty.util.concurrent.EventExecutorGroup
        public boolean isShuttingDown() {
            return this.executor.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.executor.isTerminated();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i6;
            Runnable poll;
            if (!this.state.compareAndSet(1, 2)) {
                return;
            }
            while (true) {
                int i7 = 0;
                while (i7 < this.maxTaskExecutePerRun && (poll = this.tasks.poll()) != null) {
                    try {
                        AbstractEventExecutor.safeExecute(poll);
                        i7++;
                    } finally {
                        if (i7 == i6) {
                            try {
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
                if (i7 == this.maxTaskExecutePerRun) {
                    try {
                        this.state.set(1);
                        this.executor.execute(this);
                        return;
                    } catch (Throwable unused2) {
                        this.state.set(2);
                    }
                } else {
                    this.state.set(0);
                    if (this.tasks.peek() == null || !this.state.compareAndSet(0, 2)) {
                        return;
                    }
                }
            }
        }

        @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
        public void shutdown() {
            this.executor.shutdown();
        }

        @Override // io.netty.util.concurrent.EventExecutorGroup
        public Future<?> shutdownGracefully(long j6, long j7, TimeUnit timeUnit) {
            return this.executor.shutdownGracefully(j6, j7, timeUnit);
        }

        @Override // io.netty.util.concurrent.EventExecutorGroup
        public Future<?> terminationFuture() {
            return this.executor.terminationFuture();
        }

        NonStickyOrderedEventExecutor(EventExecutor eventExecutor, int i6) {
            super(eventExecutor);
            this.tasks = PlatformDependent.newMpscQueue();
            this.state = new AtomicInteger();
            this.executor = eventExecutor;
            this.maxTaskExecutePerRun = i6;
        }
    }

    public NonStickyEventExecutorGroup(EventExecutorGroup eventExecutorGroup) {
        this(eventExecutorGroup, 1024);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.group.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.group.invokeAny(collection);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully() {
        return this.group.shutdownGracefully();
    }

    public NonStickyEventExecutorGroup(EventExecutorGroup eventExecutorGroup, int i6) {
        this.group = verify(eventExecutorGroup);
        this.maxTaskExecutePerRun = ObjectUtil.checkPositive(i6, "maxTaskExecutePerRun");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NonStickyOrderedEventExecutor newExecutor(EventExecutor eventExecutor) {
        return new NonStickyOrderedEventExecutor(eventExecutor, this.maxTaskExecutePerRun);
    }

    private static EventExecutorGroup verify(EventExecutorGroup eventExecutorGroup) {
        for (EventExecutor eventExecutor : (EventExecutorGroup) ObjectUtil.checkNotNull(eventExecutorGroup, "group")) {
            if (eventExecutor instanceof OrderedEventExecutor) {
                throw new IllegalArgumentException("EventExecutorGroup " + eventExecutorGroup + " contains OrderedEventExecutors: " + eventExecutor);
            }
        }
        return eventExecutorGroup;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j6, TimeUnit timeUnit) throws InterruptedException {
        return this.group.awaitTermination(j6, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.group.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j6, TimeUnit timeUnit) throws InterruptedException {
        return this.group.invokeAll(collection, j6, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j6, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.group.invokeAny(collection, j6, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.group.isShutdown();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return this.group.isShuttingDown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.group.isTerminated();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    public Iterator<EventExecutor> iterator() {
        final Iterator<EventExecutor> it = this.group.iterator();
        return new Iterator<EventExecutor>() { // from class: io.netty.util.concurrent.NonStickyEventExecutorGroup.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public EventExecutor next() {
                return NonStickyEventExecutorGroup.this.newExecutor((EventExecutor) it.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                it.remove();
            }
        };
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public EventExecutor next() {
        return newExecutor(this.group.next());
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        return this.group.scheduleAtFixedRate(runnable, j6, j7, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        return this.group.scheduleWithFixedDelay(runnable, j6, j7, timeUnit);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    public void shutdown() {
        this.group.shutdown();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j6, long j7, TimeUnit timeUnit) {
        return this.group.shutdownGracefully(j6, j7, timeUnit);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public List<Runnable> shutdownNow() {
        return this.group.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ java.util.concurrent.Future submit(Runnable runnable, Object obj) {
        return submit(runnable, (Runnable) obj);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.group.terminationFuture();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        return this.group.schedule(runnable, j6, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j6, TimeUnit timeUnit) {
        return this.group.schedule((Callable) callable, j6, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.group.submit(runnable);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t5) {
        return this.group.submit(runnable, (Runnable) t5);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.group.submit((Callable) callable);
    }
}
