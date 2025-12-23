package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SingleOnErrorReturn<T> extends Single<T> {
    final SingleSource<? extends T> source;
    final T value;
    final Function<? super Throwable, ? extends T> valueSupplier;

    @Override // io.reactivex.Single
    protected void subscribeActual(final SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new SingleObserver<T>() { // from class: io.reactivex.internal.operators.single.SingleOnErrorReturn.1
            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                T apply;
                SingleOnErrorReturn singleOnErrorReturn = SingleOnErrorReturn.this;
                Function<? super Throwable, ? extends T> function = singleOnErrorReturn.valueSupplier;
                if (function != null) {
                    try {
                        apply = function.apply(th);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        singleObserver.onError(new CompositeException(th, th2));
                        return;
                    }
                } else {
                    apply = singleOnErrorReturn.value;
                }
                if (apply != null) {
                    singleObserver.onSuccess(apply);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                singleObserver.onError(nullPointerException);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                singleObserver.onSubscribe(disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(T t5) {
                singleObserver.onSuccess(t5);
            }
        });
    }

    public SingleOnErrorReturn(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends T> function, T t5) {
        this.source = singleSource;
        this.valueSupplier = function;
        this.value = t5;
    }
}
