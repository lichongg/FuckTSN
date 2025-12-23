package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ImmediateThinScheduler extends Scheduler {
    static final Disposable DISPOSED;
    public static final Scheduler INSTANCE = new ImmediateThinScheduler();
    static final Scheduler.Worker WORKER = new ImmediateThinWorker();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ImmediateThinWorker extends Scheduler.Worker {
        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return false;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable) {
            runnable.run();
            return ImmediateThinScheduler.DISPOSED;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedulePeriodically(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }

        ImmediateThinWorker() {
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable runnable) {
        runnable.run();
        return DISPOSED;
    }

    static {
        Disposable empty = Disposables.empty();
        DISPOSED = empty;
        empty.dispose();
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return WORKER;
    }

    @Override // io.reactivex.Scheduler
    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    private ImmediateThinScheduler() {
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable runnable, long j6, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }
}
