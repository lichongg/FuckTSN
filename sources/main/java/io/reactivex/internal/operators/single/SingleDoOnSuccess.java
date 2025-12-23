package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SingleDoOnSuccess<T> extends Single<T> {
    final Consumer<? super T> onSuccess;
    final SingleSource<T> source;

    @Override // io.reactivex.Single
    protected void subscribeActual(final SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new SingleObserver<T>() { // from class: io.reactivex.internal.operators.single.SingleDoOnSuccess.1
            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                singleObserver.onError(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                singleObserver.onSubscribe(disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(T t5) {
                try {
                    SingleDoOnSuccess.this.onSuccess.accept(t5);
                    singleObserver.onSuccess(t5);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    singleObserver.onError(th);
                }
            }
        });
    }

    public SingleDoOnSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.source = singleSource;
        this.onSuccess = consumer;
    }
}
