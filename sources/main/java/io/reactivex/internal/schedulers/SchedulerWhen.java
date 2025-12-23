package io.reactivex.internal.schedulers;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Experimental
/* loaded from: D:\Downloads\app\classes8.dex */
public class SchedulerWhen extends Scheduler implements Disposable {
    private final Scheduler actualScheduler;
    private Disposable disposable;
    private final FlowableProcessor<Flowable<Completable>> workerProcessor;
    static final Disposable SUBSCRIBED = new Disposable() { // from class: io.reactivex.internal.schedulers.SchedulerWhen.3
        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return false;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }
    };
    static final Disposable DISPOSED = Disposables.disposed();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class DelayedAction extends ScheduledAction {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.schedule(new OnCompletedAction(this.action, completableObserver), this.delayTime, this.unit);
        }

        DelayedAction(Runnable runnable, long j6, TimeUnit timeUnit) {
            this.action = runnable;
            this.delayTime = j6;
            this.unit = timeUnit;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.schedule(new OnCompletedAction(this.action, completableObserver));
        }

        ImmediateAction(Runnable runnable) {
            this.action = runnable;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class OnCompletedAction implements Runnable {
        private Runnable action;
        private CompletableObserver actionCompletable;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.run();
            } finally {
                this.actionCompletable.onComplete();
            }
        }

        OnCompletedAction(Runnable runnable, CompletableObserver completableObserver) {
            this.action = runnable;
            this.actionCompletable = completableObserver;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class ScheduledAction extends AtomicReference<Disposable> implements Disposable {
        protected abstract Disposable callActual(Scheduler.Worker worker, CompletableObserver completableObserver);

        ScheduledAction() {
            super(SchedulerWhen.SUBSCRIBED);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable disposable;
            Disposable disposable2 = SchedulerWhen.DISPOSED;
            do {
                disposable = get();
                if (disposable == SchedulerWhen.DISPOSED) {
                    return;
                }
            } while (!compareAndSet(disposable, disposable2));
            if (disposable != SchedulerWhen.SUBSCRIBED) {
                disposable.dispose();
            }
        }

        void call(Scheduler.Worker worker, CompletableObserver completableObserver) {
            Disposable disposable;
            Disposable disposable2 = get();
            if (disposable2 != SchedulerWhen.DISPOSED && disposable2 == (disposable = SchedulerWhen.SUBSCRIBED)) {
                Disposable callActual = callActual(worker, completableObserver);
                if (!compareAndSet(disposable, callActual)) {
                    callActual.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get().isDisposed();
        }
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        final Scheduler.Worker createWorker = this.actualScheduler.createWorker();
        final FlowableProcessor<T> serialized = UnicastProcessor.create().toSerialized();
        Flowable<Completable> map = serialized.map(new Function<ScheduledAction, Completable>() { // from class: io.reactivex.internal.schedulers.SchedulerWhen.1
            @Override // io.reactivex.functions.Function
            public Completable apply(final ScheduledAction scheduledAction) {
                return new Completable() { // from class: io.reactivex.internal.schedulers.SchedulerWhen.1.1
                    @Override // io.reactivex.Completable
                    protected void subscribeActual(CompletableObserver completableObserver) {
                        completableObserver.onSubscribe(scheduledAction);
                        scheduledAction.call(createWorker, completableObserver);
                    }
                };
            }
        });
        Scheduler.Worker worker = new Scheduler.Worker() { // from class: io.reactivex.internal.schedulers.SchedulerWhen.2
            private final AtomicBoolean unsubscribed = new AtomicBoolean();

            @Override // io.reactivex.Scheduler.Worker
            public Disposable schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
                DelayedAction delayedAction = new DelayedAction(runnable, j6, timeUnit);
                serialized.onNext(delayedAction);
                return delayedAction;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                if (this.unsubscribed.compareAndSet(false, true)) {
                    createWorker.dispose();
                    serialized.onComplete();
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return this.unsubscribed.get();
            }

            @Override // io.reactivex.Scheduler.Worker
            public Disposable schedule(Runnable runnable) {
                ImmediateAction immediateAction = new ImmediateAction(runnable);
                serialized.onNext(immediateAction);
                return immediateAction;
            }
        };
        this.workerProcessor.onNext(map);
        return worker;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.disposable.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.disposable.isDisposed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SchedulerWhen(Function<Flowable<Flowable<Completable>>, Completable> function, Scheduler scheduler) {
        this.actualScheduler = scheduler;
        FlowableProcessor serialized = UnicastProcessor.create().toSerialized();
        this.workerProcessor = serialized;
        try {
            this.disposable = ((Completable) function.apply(serialized)).subscribe();
        } catch (Throwable th) {
            Exceptions.propagate(th);
        }
    }
}
