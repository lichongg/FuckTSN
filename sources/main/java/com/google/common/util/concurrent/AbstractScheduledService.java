package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class AbstractScheduledService implements Service {
    private static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
    private final AbstractService delegate = new ServiceDelegate();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Beta
    public static abstract class CustomScheduler extends Scheduler {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class ReschedulableCallable extends ForwardingFuture<Void> implements Callable<Void> {

            @NullableDecl
            @GuardedBy("lock")
            private Future<Void> currentFuture;
            private final ScheduledExecutorService executor;
            private final ReentrantLock lock = new ReentrantLock();
            private final AbstractService service;
            private final Runnable wrappedRunnable;

            ReschedulableCallable(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                this.wrappedRunnable = runnable;
                this.executor = scheduledExecutorService;
                this.service = abstractService;
            }

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                this.wrappedRunnable.run();
                reschedule();
                return null;
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean z5) {
                this.lock.lock();
                try {
                    return this.currentFuture.cancel(z5);
                } finally {
                    this.lock.unlock();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
            public Future<Void> delegate() {
                throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean isCancelled() {
                this.lock.lock();
                try {
                    return this.currentFuture.isCancelled();
                } finally {
                    this.lock.unlock();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
            /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void reschedule() {
                /*
                    r4 = this;
                    com.google.common.util.concurrent.AbstractScheduledService$CustomScheduler r0 = com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.this     // Catch: java.lang.Throwable -> L3c
                    com.google.common.util.concurrent.AbstractScheduledService$CustomScheduler$Schedule r0 = r0.getNextSchedule()     // Catch: java.lang.Throwable -> L3c
                    java.util.concurrent.locks.ReentrantLock r1 = r4.lock
                    r1.lock()
                    java.util.concurrent.Future<java.lang.Void> r1 = r4.currentFuture     // Catch: java.lang.Throwable -> L16
                    if (r1 == 0) goto L18
                    boolean r1 = r1.isCancelled()     // Catch: java.lang.Throwable -> L16
                    if (r1 != 0) goto L28
                    goto L18
                L16:
                    r0 = move-exception
                    goto L2f
                L18:
                    java.util.concurrent.ScheduledExecutorService r1 = r4.executor     // Catch: java.lang.Throwable -> L16
                    long r2 = com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.Schedule.access$800(r0)     // Catch: java.lang.Throwable -> L16
                    java.util.concurrent.TimeUnit r0 = com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.Schedule.access$900(r0)     // Catch: java.lang.Throwable -> L16
                    java.util.concurrent.ScheduledFuture r0 = r1.schedule(r4, r2, r0)     // Catch: java.lang.Throwable -> L16
                    r4.currentFuture = r0     // Catch: java.lang.Throwable -> L16
                L28:
                    java.util.concurrent.locks.ReentrantLock r0 = r4.lock
                    r0.unlock()
                    r0 = 0
                    goto L34
                L2f:
                    java.util.concurrent.locks.ReentrantLock r1 = r4.lock
                    r1.unlock()
                L34:
                    if (r0 == 0) goto L3b
                    com.google.common.util.concurrent.AbstractService r1 = r4.service
                    r1.notifyFailed(r0)
                L3b:
                    return
                L3c:
                    r0 = move-exception
                    com.google.common.util.concurrent.AbstractService r1 = r4.service
                    r1.notifyFailed(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractScheduledService.CustomScheduler.ReschedulableCallable.reschedule():void");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @Beta
        protected static final class Schedule {
            private final long delay;
            private final TimeUnit unit;

            public Schedule(long j6, TimeUnit timeUnit) {
                this.delay = j6;
                this.unit = (TimeUnit) Preconditions.checkNotNull(timeUnit);
            }
        }

        public CustomScheduler() {
            super();
        }

        protected abstract Schedule getNextSchedule() throws Exception;

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        final Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            ReschedulableCallable reschedulableCallable = new ReschedulableCallable(abstractService, scheduledExecutorService, runnable);
            reschedulableCallable.reschedule();
            return reschedulableCallable;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Scheduler {
        abstract Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable);

        private Scheduler() {
        }

        public static Scheduler newFixedDelaySchedule(final long j6, final long j7, final TimeUnit timeUnit) {
            boolean z5;
            Preconditions.checkNotNull(timeUnit);
            if (j7 > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "delay must be > 0, found %s", j7);
            return new Scheduler() { // from class: com.google.common.util.concurrent.AbstractScheduledService.Scheduler.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
                public Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return scheduledExecutorService.scheduleWithFixedDelay(runnable, j6, j7, timeUnit);
                }
            };
        }

        public static Scheduler newFixedRateSchedule(final long j6, final long j7, final TimeUnit timeUnit) {
            boolean z5;
            Preconditions.checkNotNull(timeUnit);
            if (j7 > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "period must be > 0, found %s", j7);
            return new Scheduler() { // from class: com.google.common.util.concurrent.AbstractScheduledService.Scheduler.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
                public Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return scheduledExecutorService.scheduleAtFixedRate(runnable, j6, j7, timeUnit);
                }
            };
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class ServiceDelegate extends AbstractService {

        @MonotonicNonNullDecl
        private volatile ScheduledExecutorService executorService;
        private final ReentrantLock lock;

        @MonotonicNonNullDecl
        private volatile Future<?> runningTask;
        private final Runnable task;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class Task implements Runnable {
            Task() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ServiceDelegate.this.lock.lock();
                try {
                    if (!ServiceDelegate.this.runningTask.isCancelled()) {
                        AbstractScheduledService.this.runOneIteration();
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }

        private ServiceDelegate() {
            this.lock = new ReentrantLock();
            this.task = new Task();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStart() {
            this.executorService = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), new Supplier<String>() { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.1
                @Override // com.google.common.base.Supplier
                public String get() {
                    return AbstractScheduledService.this.serviceName() + " " + ServiceDelegate.this.state();
                }
            });
            this.executorService.execute(new Runnable() { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.2
                @Override // java.lang.Runnable
                public void run() {
                    ServiceDelegate.this.lock.lock();
                    try {
                        AbstractScheduledService.this.startUp();
                        ServiceDelegate serviceDelegate = ServiceDelegate.this;
                        serviceDelegate.runningTask = AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, ServiceDelegate.this.executorService, ServiceDelegate.this.task);
                        ServiceDelegate.this.notifyStarted();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStop() {
            this.runningTask.cancel(false);
            this.executorService.execute(new Runnable() { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ServiceDelegate.this.lock.lock();
                        try {
                            if (ServiceDelegate.this.state() != Service.State.STOPPING) {
                                return;
                            }
                            AbstractScheduledService.this.shutDown();
                            ServiceDelegate.this.lock.unlock();
                            ServiceDelegate.this.notifyStopped();
                        } finally {
                            ServiceDelegate.this.lock.unlock();
                        }
                    } catch (Throwable th) {
                        ServiceDelegate.this.notifyFailed(th);
                    }
                }
            });
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractScheduledService.this.toString();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    protected abstract void runOneIteration() throws Exception;

    protected abstract Scheduler scheduler();

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j6, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitRunning(j6, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j6, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitTerminated(j6, timeUnit);
    }

    protected ScheduledExecutorService executor() {
        final ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.google.common.util.concurrent.AbstractScheduledService.1ThreadFactoryImpl
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return MoreExecutors.newThread(AbstractScheduledService.this.serviceName(), runnable);
            }
        });
        addListener(new Service.Listener() { // from class: com.google.common.util.concurrent.AbstractScheduledService.1
            @Override // com.google.common.util.concurrent.Service.Listener
            public void failed(Service.State state, Throwable th) {
                newSingleThreadScheduledExecutor.shutdown();
            }

            @Override // com.google.common.util.concurrent.Service.Listener
            public void terminated(Service.State state) {
                newSingleThreadScheduledExecutor.shutdown();
            }
        }, MoreExecutors.directExecutor());
        return newSingleThreadScheduledExecutor;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    protected AbstractScheduledService() {
    }

    protected String serviceName() {
        return getClass().getSimpleName();
    }

    protected void shutDown() throws Exception {
    }

    protected void startUp() throws Exception {
    }
}
