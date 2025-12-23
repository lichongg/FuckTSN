package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -8612022020200669122L;
    final Observer<? super T> actual;
    final AtomicReference<Disposable> subscription = new AtomicReference<>();

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.subscription);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.subscription.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.Observer
    public void onNext(T t5) {
        this.actual.onNext(t5);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this.subscription, disposable)) {
            this.actual.onSubscribe(this);
        }
    }

    public ObserverResourceWrapper(Observer<? super T> observer) {
        this.actual = observer;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        dispose();
        this.actual.onComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        dispose();
        this.actual.onError(th);
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }
}
