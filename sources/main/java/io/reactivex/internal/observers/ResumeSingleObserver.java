package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ResumeSingleObserver<T> implements SingleObserver<T> {
    final SingleObserver<? super T> actual;
    final AtomicReference<Disposable> parent;

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.parent, disposable);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t5) {
        this.actual.onSuccess(t5);
    }

    public ResumeSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super T> singleObserver) {
        this.parent = atomicReference;
        this.actual = singleObserver;
    }
}
