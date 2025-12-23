package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {
    protected final Observer<? super R> actual;
    protected boolean done;
    protected QueueDisposable<T> qs;

    /* renamed from: s, reason: collision with root package name */
    protected Disposable f43121s;
    protected int sourceMode;

    protected boolean beforeDownstream() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r5) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.qs.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.f43121s.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f43121s.isDisposed();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.qs.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r5, R r6) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.actual.onComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
        } else {
            this.done = true;
            this.actual.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f43121s, disposable)) {
            this.f43121s = disposable;
            if (disposable instanceof QueueDisposable) {
                this.qs = (QueueDisposable) disposable;
            }
            if (beforeDownstream()) {
                this.actual.onSubscribe(this);
                afterDownstream();
            }
        }
    }

    protected final int transitiveBoundaryFusion(int i6) {
        QueueDisposable<T> queueDisposable = this.qs;
        if (queueDisposable == null || (i6 & 4) != 0) {
            return 0;
        }
        int requestFusion = queueDisposable.requestFusion(i6);
        if (requestFusion != 0) {
            this.sourceMode = requestFusion;
        }
        return requestFusion;
    }

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.actual = observer;
    }

    protected final void fail(Throwable th) {
        Exceptions.throwIfFatal(th);
        this.f43121s.dispose();
        onError(th);
    }

    protected void afterDownstream() {
    }
}
