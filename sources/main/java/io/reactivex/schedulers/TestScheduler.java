package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class TestScheduler extends Scheduler {
    long counter;
    final Queue<TimedRunnable> queue = new PriorityBlockingQueue(11);
    volatile long time;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class TestWorker extends Scheduler.Worker {
        volatile boolean disposed;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            long nanos = TestScheduler.this.time + timeUnit.toNanos(j6);
            TestScheduler testScheduler = TestScheduler.this;
            long j7 = testScheduler.counter;
            testScheduler.counter = 1 + j7;
            final TimedRunnable timedRunnable = new TimedRunnable(this, nanos, runnable, j7);
            TestScheduler.this.queue.add(timedRunnable);
            return Disposables.fromRunnable(new Runnable() { // from class: io.reactivex.schedulers.TestScheduler.TestWorker.1
                @Override // java.lang.Runnable
                public void run() {
                    TestScheduler.this.queue.remove(timedRunnable);
                }
            });
        }

        TestWorker() {
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Scheduler.Worker
        public long now(TimeUnit timeUnit) {
            return TestScheduler.this.now(timeUnit);
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler testScheduler = TestScheduler.this;
            long j6 = testScheduler.counter;
            testScheduler.counter = 1 + j6;
            final TimedRunnable timedRunnable = new TimedRunnable(this, 0L, runnable, j6);
            TestScheduler.this.queue.add(timedRunnable);
            return Disposables.fromRunnable(new Runnable() { // from class: io.reactivex.schedulers.TestScheduler.TestWorker.2
                @Override // java.lang.Runnable
                public void run() {
                    TestScheduler.this.queue.remove(timedRunnable);
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class TimedRunnable implements Comparable<TimedRunnable> {
        final long count;
        final Runnable run;
        final TestWorker scheduler;
        final long time;

        @Override // java.lang.Comparable
        public int compareTo(TimedRunnable timedRunnable) {
            long j6 = this.time;
            long j7 = timedRunnable.time;
            return j6 == j7 ? ObjectHelper.compare(this.count, timedRunnable.count) : ObjectHelper.compare(j6, j7);
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", Long.valueOf(this.time), this.run.toString());
        }

        TimedRunnable(TestWorker testWorker, long j6, Runnable runnable, long j7) {
            this.time = j6;
            this.run = runnable;
            this.scheduler = testWorker;
            this.count = j7;
        }
    }

    public void triggerActions() {
        triggerActions(this.time);
    }

    private void triggerActions(long j6) {
        while (!this.queue.isEmpty()) {
            TimedRunnable peek = this.queue.peek();
            long j7 = peek.time;
            if (j7 > j6) {
                break;
            }
            if (j7 == 0) {
                j7 = this.time;
            }
            this.time = j7;
            this.queue.remove();
            if (!peek.scheduler.disposed) {
                peek.run.run();
            }
        }
        this.time = j6;
    }

    public void advanceTimeBy(long j6, TimeUnit timeUnit) {
        advanceTimeTo(this.time + timeUnit.toNanos(j6), TimeUnit.NANOSECONDS);
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new TestWorker();
    }

    @Override // io.reactivex.Scheduler
    public long now(TimeUnit timeUnit) {
        return timeUnit.convert(this.time, TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j6, TimeUnit timeUnit) {
        triggerActions(timeUnit.toNanos(j6));
    }
}
