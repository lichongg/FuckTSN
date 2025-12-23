package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ObserverFullArbiter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FullArbiterObserver<T> implements Observer<T> {
    final ObserverFullArbiter<T> arbiter;

    /* renamed from: s, reason: collision with root package name */
    Disposable f43126s;

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.arbiter.onComplete(this.f43126s);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.arbiter.onError(th, this.f43126s);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t5) {
        this.arbiter.onNext(t5, this.f43126s);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f43126s, disposable)) {
            this.f43126s = disposable;
            this.arbiter.setDisposable(disposable);
        }
    }

    public FullArbiterObserver(ObserverFullArbiter<T> observerFullArbiter) {
        this.arbiter = observerFullArbiter;
    }
}
