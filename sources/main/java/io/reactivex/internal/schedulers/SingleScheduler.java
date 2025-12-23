package io.reactivex.internal.schedulers;

import androidx.camera.view.p;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SingleScheduler extends Scheduler {
    private static final String KEY_SINGLE_PRIORITY = "rx2.single-priority";
    static final ScheduledExecutorService SHUTDOWN;
    static final RxThreadFactory SINGLE_THREAD_FACTORY;
    private static final String THREAD_NAME_PREFIX = "RxSingleScheduler";
    final AtomicReference<ScheduledExecutorService> executor;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ScheduledWorker extends Scheduler.Worker {
        volatile boolean disposed;
        final ScheduledExecutorService executor;
        final CompositeDisposable tasks = new CompositeDisposable();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.tasks.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.onSchedule(runnable), this.tasks);
            this.tasks.add(scheduledRunnable);
            try {
                scheduledRunnable.setFuture(j6 <= 0 ? this.executor.submit((Callable) scheduledRunnable) : this.executor.schedule((Callable) scheduledRunnable, j6, timeUnit));
                return scheduledRunnable;
            } catch (RejectedExecutionException e6) {
                dispose();
                RxJavaPlugins.onError(e6);
                return EmptyDisposable.INSTANCE;
            }
        }

        ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.executor = scheduledExecutorService;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        SHUTDOWN = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        SINGLE_THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_SINGLE_PRIORITY, 5).intValue())));
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.executor.get();
            if (scheduledExecutorService != SHUTDOWN) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = createExecutor();
            }
        } while (!p.a(this.executor, scheduledExecutorService, scheduledExecutorService2));
    }

    static ScheduledExecutorService createExecutor() {
        return SchedulerPoolFactory.create(SINGLE_THREAD_FACTORY);
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new ScheduledWorker(this.executor.get());
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        ScheduledExecutorService andSet;
        ScheduledExecutorService scheduledExecutorService = this.executor.get();
        ScheduledExecutorService scheduledExecutorService2 = SHUTDOWN;
        if (scheduledExecutorService == scheduledExecutorService2 || (andSet = this.executor.getAndSet(scheduledExecutorService2)) == scheduledExecutorService2) {
            return;
        }
        andSet.shutdownNow();
    }

    public SingleScheduler() {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.executor = atomicReference;
        atomicReference.lazySet(createExecutor());
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable runnable, long j6, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        try {
            if (j6 <= 0) {
                schedule = this.executor.get().submit(onSchedule);
            } else {
                schedule = this.executor.get().schedule(onSchedule, j6, timeUnit);
            }
            return Disposables.fromFuture(schedule);
        } catch (RejectedExecutionException e6) {
            RxJavaPlugins.onError(e6);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        try {
            return Disposables.fromFuture(this.executor.get().scheduleAtFixedRate(RxJavaPlugins.onSchedule(runnable), j6, j7, timeUnit));
        } catch (RejectedExecutionException e6) {
            RxJavaPlugins.onError(e6);
            return EmptyDisposable.INSTANCE;
        }
    }
}
