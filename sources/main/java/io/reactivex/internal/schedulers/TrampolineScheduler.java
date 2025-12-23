package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class TrampolineScheduler extends Scheduler {
    private static final TrampolineScheduler INSTANCE = new TrampolineScheduler();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class SleepingRunnable implements Runnable {
        private final long execTime;
        private final Runnable run;
        private final TrampolineWorker worker;

        @Override // java.lang.Runnable
        public void run() {
            if (this.worker.disposed) {
                return;
            }
            long now = this.worker.now(TimeUnit.MILLISECONDS);
            long j6 = this.execTime;
            if (j6 > now) {
                long j7 = j6 - now;
                if (j7 > 0) {
                    try {
                        Thread.sleep(j7);
                    } catch (InterruptedException e6) {
                        Thread.currentThread().interrupt();
                        RxJavaPlugins.onError(e6);
                        return;
                    }
                }
            }
            if (this.worker.disposed) {
                return;
            }
            this.run.run();
        }

        SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j6) {
            this.run = runnable;
            this.worker = trampolineWorker;
            this.execTime = j6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TimedRunnable implements Comparable<TimedRunnable> {
        final int count;
        volatile boolean disposed;
        final long execTime;
        final Runnable run;

        @Override // java.lang.Comparable
        public int compareTo(TimedRunnable timedRunnable) {
            int compare = ObjectHelper.compare(this.execTime, timedRunnable.execTime);
            return compare == 0 ? ObjectHelper.compare(this.count, timedRunnable.count) : compare;
        }

        TimedRunnable(Runnable runnable, Long l6, int i6) {
            this.run = runnable;
            this.execTime = l6.longValue();
            this.count = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TrampolineWorker extends Scheduler.Worker implements Disposable {
        volatile boolean disposed;
        final PriorityBlockingQueue<TimedRunnable> queue = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger counter = new AtomicInteger();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable) {
            return enqueue(runnable, now(TimeUnit.MILLISECONDS));
        }

        Disposable enqueue(Runnable runnable, long j6) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            final TimedRunnable timedRunnable = new TimedRunnable(runnable, Long.valueOf(j6), this.counter.incrementAndGet());
            this.queue.add(timedRunnable);
            if (this.wip.getAndIncrement() != 0) {
                return Disposables.fromRunnable(new Runnable() { // from class: io.reactivex.internal.schedulers.TrampolineScheduler.TrampolineWorker.1
                    @Override // java.lang.Runnable
                    public void run() {
                        timedRunnable.disposed = true;
                        TrampolineWorker.this.queue.remove(timedRunnable);
                    }
                });
            }
            int i6 = 1;
            while (true) {
                TimedRunnable poll = this.queue.poll();
                if (poll == null) {
                    i6 = this.wip.addAndGet(-i6);
                    if (i6 == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.disposed) {
                    poll.run.run();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
            long now = now(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j6);
            return enqueue(new SleepingRunnable(runnable, this, now), now);
        }

        TrampolineWorker() {
        }
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable runnable) {
        runnable.run();
        return EmptyDisposable.INSTANCE;
    }

    public static TrampolineScheduler instance() {
        return INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new TrampolineWorker();
    }

    TrampolineScheduler() {
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable runnable, long j6, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j6);
            runnable.run();
        } catch (InterruptedException e6) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.onError(e6);
        }
        return EmptyDisposable.INSTANCE;
    }
}
