package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObservableRange extends Observable<Integer> {
    private final long end;
    private final int start;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        private static final long serialVersionUID = 396518478098735504L;
        final Observer<? super Integer> actual;
        final long end;
        boolean fused;
        long index;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i6) {
            if ((i6 & 1) == 0) {
                return 0;
            }
            this.fused = true;
            return 1;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Integer poll() throws Exception {
            long j6 = this.index;
            if (j6 != this.end) {
                this.index = 1 + j6;
                return Integer.valueOf((int) j6);
            }
            lazySet(1);
            return null;
        }

        void run() {
            if (this.fused) {
                return;
            }
            Observer<? super Integer> observer = this.actual;
            long j6 = this.end;
            for (long j7 = this.index; j7 != j6 && get() == 0; j7++) {
                observer.onNext(Integer.valueOf((int) j7));
            }
            if (get() == 0) {
                lazySet(1);
                observer.onComplete();
            }
        }

        RangeDisposable(Observer<? super Integer> observer, long j6, long j7) {
            this.actual = observer;
            this.index = j6;
            this.end = j7;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Integer> observer) {
        RangeDisposable rangeDisposable = new RangeDisposable(observer, this.start, this.end);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }

    public ObservableRange(int i6, int i7) {
        this.start = i6;
        this.end = i6 + i7;
    }
}
