package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CompletableToSingle<T> extends Single<T> {
    final T completionValue;
    final Callable<? extends T> completionValueSupplier;
    final CompletableSource source;

    @Override // io.reactivex.Single
    protected void subscribeActual(final SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new CompletableObserver() { // from class: io.reactivex.internal.operators.completable.CompletableToSingle.1
            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                T call;
                CompletableToSingle completableToSingle = CompletableToSingle.this;
                Callable<? extends T> callable = completableToSingle.completionValueSupplier;
                if (callable != null) {
                    try {
                        call = callable.call();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        singleObserver.onError(th);
                        return;
                    }
                } else {
                    call = completableToSingle.completionValue;
                }
                if (call == null) {
                    singleObserver.onError(new NullPointerException("The value supplied is null"));
                } else {
                    singleObserver.onSuccess(call);
                }
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                singleObserver.onError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                singleObserver.onSubscribe(disposable);
            }
        });
    }

    public CompletableToSingle(CompletableSource completableSource, Callable<? extends T> callable, T t5) {
        this.source = completableSource;
        this.completionValue = t5;
        this.completionValueSupplier = callable;
    }
}
