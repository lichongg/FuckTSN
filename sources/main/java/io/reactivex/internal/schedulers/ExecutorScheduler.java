package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ExecutorScheduler extends Scheduler {
    static final Scheduler HELPER = Schedulers.single();
    final Executor executor;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {
        volatile boolean disposed;
        final Executor executor;
        final AtomicInteger wip = new AtomicInteger();
        final CompositeDisposable tasks = new CompositeDisposable();
        final MpscLinkedQueue<Runnable> queue = new MpscLinkedQueue<>();

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            BooleanRunnable booleanRunnable = new BooleanRunnable(RxJavaPlugins.onSchedule(runnable));
            this.queue.offer(booleanRunnable);
            if (this.wip.getAndIncrement() != 0) {
                return booleanRunnable;
            }
            try {
                this.executor.execute(this);
                return booleanRunnable;
            } catch (RejectedExecutionException e6) {
                this.disposed = true;
                this.queue.clear();
                RxJavaPlugins.onError(e6);
                return EmptyDisposable.INSTANCE;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                lazySet(true);
            }

            BooleanRunnable(Runnable runnable) {
                this.actual = runnable;
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                this.actual.run();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.tasks.dispose();
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public void run() {
            MpscLinkedQueue<Runnable> mpscLinkedQueue = this.queue;
            int i6 = 1;
            while (!this.disposed) {
                do {
                    Runnable poll = mpscLinkedQueue.poll();
                    if (poll != null) {
                        poll.run();
                    } else if (this.disposed) {
                        mpscLinkedQueue.clear();
                        return;
                    } else {
                        i6 = this.wip.addAndGet(-i6);
                        if (i6 == 0) {
                            return;
                        }
                    }
                } while (!this.disposed);
                mpscLinkedQueue.clear();
                return;
            }
            mpscLinkedQueue.clear();
        }

        public ExecutorWorker(Executor executor) {
            this.executor = executor;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
            if (j6 <= 0) {
                return schedule(runnable);
            }
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            final SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            final Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new Runnable() { // from class: io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.1
                @Override // java.lang.Runnable
                public void run() {
                    sequentialDisposable2.replace(ExecutorWorker.this.schedule(onSchedule));
                }
            }, this.tasks);
            this.tasks.add(scheduledRunnable);
            Executor executor = this.executor;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j6, timeUnit));
                } catch (RejectedExecutionException e6) {
                    this.disposed = true;
                    RxJavaPlugins.onError(e6);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new DisposeOnCancel(ExecutorScheduler.HELPER.scheduleDirect(scheduledRunnable, j6, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable runnable) {
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        try {
            Executor executor = this.executor;
            if (executor instanceof ExecutorService) {
                return Disposables.fromFuture(((ExecutorService) executor).submit(onSchedule));
            }
            ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(onSchedule);
            this.executor.execute(booleanRunnable);
            return booleanRunnable;
        } catch (RejectedExecutionException e6) {
            RxJavaPlugins.onError(e6);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new ExecutorWorker(this.executor);
    }

    @Override // io.reactivex.Scheduler
    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        if (!(this.executor instanceof ScheduledExecutorService)) {
            return super.schedulePeriodicallyDirect(runnable, j6, j7, timeUnit);
        }
        try {
            return Disposables.fromFuture(((ScheduledExecutorService) this.executor).scheduleAtFixedRate(RxJavaPlugins.onSchedule(runnable), j6, j7, timeUnit));
        } catch (RejectedExecutionException e6) {
            RxJavaPlugins.onError(e6);
            return EmptyDisposable.INSTANCE;
        }
    }

    public ExecutorScheduler(Executor executor) {
        this.executor = executor;
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable runnable, long j6, TimeUnit timeUnit) {
        final Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        Executor executor = this.executor;
        if (executor instanceof ScheduledExecutorService) {
            try {
                return Disposables.fromFuture(((ScheduledExecutorService) executor).schedule(onSchedule, j6, timeUnit));
            } catch (RejectedExecutionException e6) {
                RxJavaPlugins.onError(e6);
                return EmptyDisposable.INSTANCE;
            }
        }
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        final SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
        sequentialDisposable.replace(HELPER.scheduleDirect(new Runnable() { // from class: io.reactivex.internal.schedulers.ExecutorScheduler.1
            @Override // java.lang.Runnable
            public void run() {
                sequentialDisposable2.replace(ExecutorScheduler.this.scheduleDirect(onSchedule));
            }
        }, j6, timeUnit));
        return sequentialDisposable2;
    }
}
