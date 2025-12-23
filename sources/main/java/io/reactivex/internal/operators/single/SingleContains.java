package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SingleContains<T> extends Single<Boolean> {
    final BiPredicate<Object, Object> comparer;
    final SingleSource<T> source;
    final Object value;

    @Override // io.reactivex.Single
    protected void subscribeActual(final SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe(new SingleObserver<T>() { // from class: io.reactivex.internal.operators.single.SingleContains.1
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
                    SingleContains singleContains = SingleContains.this;
                    singleObserver.onSuccess(Boolean.valueOf(singleContains.comparer.test(t5, singleContains.value)));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    singleObserver.onError(th);
                }
            }
        });
    }

    public SingleContains(SingleSource<T> singleSource, Object obj, BiPredicate<Object, Object> biPredicate) {
        this.source = singleSource;
        this.value = obj;
        this.comparer = biPredicate;
    }
}
