package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class DefaultObserver<T> implements Observer<T> {

    /* renamed from: s, reason: collision with root package name */
    private Disposable f43419s;

    protected final void cancel() {
        Disposable disposable = this.f43419s;
        this.f43419s = DisposableHelper.DISPOSED;
        disposable.dispose();
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f43419s, disposable)) {
            this.f43419s = disposable;
            onStart();
        }
    }

    protected void onStart() {
    }
}
