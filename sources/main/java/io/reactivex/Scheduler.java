package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class PeriodicDirectTask implements Runnable, Disposable {
        volatile boolean disposed;
        final Runnable run;
        final Worker worker;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.disposed) {
                return;
            }
            try {
                this.run.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.worker.dispose();
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }

        PeriodicDirectTask(Runnable runnable, Worker worker) {
            this.run = runnable;
            this.worker = worker;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Worker implements Disposable {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class PeriodicTask implements Runnable {
            long count;
            final Runnable decoratedRun;
            long lastNowNanoseconds;
            final long periodInNanoseconds;
            final SequentialDisposable sd;
            long startInNanoseconds;

            PeriodicTask(long j6, Runnable runnable, long j7, SequentialDisposable sequentialDisposable, long j8) {
                this.decoratedRun = runnable;
                this.sd = sequentialDisposable;
                this.periodInNanoseconds = j8;
                this.lastNowNanoseconds = j7;
                this.startInNanoseconds = j6;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j6;
                this.decoratedRun.run();
                if (this.sd.isDisposed()) {
                    return;
                }
                Worker worker = Worker.this;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                long now = worker.now(timeUnit);
                long j7 = Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
                long j8 = now + j7;
                long j9 = this.lastNowNanoseconds;
                if (j8 >= j9) {
                    long j10 = this.periodInNanoseconds;
                    if (now < j9 + j10 + j7) {
                        long j11 = this.startInNanoseconds;
                        long j12 = this.count + 1;
                        this.count = j12;
                        j6 = j11 + (j12 * j10);
                        this.lastNowNanoseconds = now;
                        this.sd.replace(Worker.this.schedule(this, j6 - now, timeUnit));
                    }
                }
                long j13 = this.periodInNanoseconds;
                long j14 = now + j13;
                long j15 = this.count + 1;
                this.count = j15;
                this.startInNanoseconds = j14 - (j13 * j15);
                j6 = j14;
                this.lastNowNanoseconds = now;
                this.sd.replace(Worker.this.schedule(this, j6 - now, timeUnit));
            }
        }

        public Disposable schedule(Runnable runnable) {
            return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract Disposable schedule(Runnable runnable, long j6, TimeUnit timeUnit);

        public Disposable schedulePeriodically(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            long nanos = timeUnit.toNanos(j7);
            long now = now(TimeUnit.NANOSECONDS);
            Disposable schedule = schedule(new PeriodicTask(now + timeUnit.toNanos(j6), onSchedule, now, sequentialDisposable2, nanos), j6, timeUnit);
            if (schedule == EmptyDisposable.INSTANCE) {
                return schedule;
            }
            sequentialDisposable.replace(schedule);
            return sequentialDisposable2;
        }

        public long now(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public abstract Worker createWorker();

    public Disposable scheduleDirect(Runnable runnable) {
        return scheduleDirect(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public static long clockDriftTolerance() {
        return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    }

    public Disposable scheduleDirect(Runnable runnable, long j6, TimeUnit timeUnit) {
        final Worker createWorker = createWorker();
        final Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        createWorker.schedule(new Runnable() { // from class: io.reactivex.Scheduler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    onSchedule.run();
                } finally {
                    createWorker.dispose();
                }
            }
        }, j6, timeUnit);
        return createWorker;
    }

    @Experimental
    public <S extends Scheduler & Disposable> S when(Function<Flowable<Flowable<Completable>>, Completable> function) {
        return new SchedulerWhen(function, this);
    }

    public long now(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.onSchedule(runnable), createWorker);
        Disposable schedulePeriodically = createWorker.schedulePeriodically(periodicDirectTask, j6, j7, timeUnit);
        if (schedulePeriodically == EmptyDisposable.INSTANCE) {
            return schedulePeriodically;
        }
        return periodicDirectTask;
    }

    public void shutdown() {
    }

    public void start() {
    }
}
