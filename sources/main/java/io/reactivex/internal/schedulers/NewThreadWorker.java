package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class NewThreadWorker extends Scheduler.Worker implements Disposable {
    volatile boolean disposed;
    private final ScheduledExecutorService executor;

    @Override // io.reactivex.Scheduler.Worker
    public Disposable schedule(Runnable runnable) {
        return schedule(runnable, 0L, null);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.disposed) {
            return;
        }
        this.disposed = true;
        this.executor.shutdownNow();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.Scheduler.Worker
    public Disposable schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        return this.disposed ? EmptyDisposable.INSTANCE : scheduleActual(runnable, j6, timeUnit, null);
    }

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.executor = SchedulerPoolFactory.create(threadFactory);
    }

    public ScheduledRunnable scheduleActual(Runnable runnable, long j6, TimeUnit timeUnit, DisposableContainer disposableContainer) {
        Future<?> schedule;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.onSchedule(runnable), disposableContainer);
        if (disposableContainer != null && !disposableContainer.add(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            if (j6 <= 0) {
                schedule = this.executor.submit((Callable) scheduledRunnable);
            } else {
                schedule = this.executor.schedule((Callable) scheduledRunnable, j6, timeUnit);
            }
            scheduledRunnable.setFuture(schedule);
            return scheduledRunnable;
        } catch (RejectedExecutionException e6) {
            disposableContainer.remove(scheduledRunnable);
            RxJavaPlugins.onError(e6);
            return scheduledRunnable;
        }
    }

    public Disposable scheduleDirect(Runnable runnable, long j6, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        try {
            if (j6 <= 0) {
                schedule = this.executor.submit(onSchedule);
            } else {
                schedule = this.executor.schedule(onSchedule, j6, timeUnit);
            }
            return Disposables.fromFuture(schedule);
        } catch (RejectedExecutionException e6) {
            RxJavaPlugins.onError(e6);
            return EmptyDisposable.INSTANCE;
        }
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        try {
            return Disposables.fromFuture(this.executor.scheduleAtFixedRate(RxJavaPlugins.onSchedule(runnable), j6, j7, timeUnit));
        } catch (RejectedExecutionException e6) {
            RxJavaPlugins.onError(e6);
            return EmptyDisposable.INSTANCE;
        }
    }
}
