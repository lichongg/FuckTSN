package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableIntervalRange extends Observable<Long> {
    final long end;
    final long initialDelay;
    final long period;
    final Scheduler scheduler;
    final long start;
    final TimeUnit unit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        final Observer<? super Long> actual;
        long count;
        final long end;

        IntervalRangeObserver(Observer<? super Long> observer, long j6, long j7) {
            this.actual = observer;
            this.count = j6;
            this.end = j7;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!isDisposed()) {
                long j6 = this.count;
                this.actual.onNext(Long.valueOf(j6));
                if (j6 == this.end) {
                    DisposableHelper.dispose(this);
                    this.actual.onComplete();
                } else {
                    this.count = j6 + 1;
                }
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(observer, this.start, this.end);
        observer.onSubscribe(intervalRangeObserver);
        intervalRangeObserver.setResource(this.scheduler.schedulePeriodicallyDirect(intervalRangeObserver, this.initialDelay, this.period, this.unit));
    }

    public ObservableIntervalRange(long j6, long j7, long j8, long j9, TimeUnit timeUnit, Scheduler scheduler) {
        this.initialDelay = j8;
        this.period = j9;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.start = j6;
        this.end = j7;
    }
}
