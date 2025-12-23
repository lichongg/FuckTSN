package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SingleFromCallable<T> extends Single<T> {
    final Callable<? extends T> callable;

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(EmptyDisposable.INSTANCE);
        try {
            T call = this.callable.call();
            if (call != null) {
                singleObserver.onSuccess(call);
            } else {
                singleObserver.onError(new NullPointerException("The callable returned a null value"));
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            singleObserver.onError(th);
        }
    }

    public SingleFromCallable(Callable<? extends T> callable) {
        this.callable = callable;
    }
}
