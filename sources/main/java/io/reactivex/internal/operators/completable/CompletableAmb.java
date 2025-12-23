package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CompletableAmb extends Completable {
    private final CompletableSource[] sources;
    private final Iterable<? extends CompletableSource> sourcesIterable;

    @Override // io.reactivex.Completable
    public void subscribeActual(final CompletableObserver completableObserver) {
        int length;
        CompletableSource[] completableSourceArr = this.sources;
        if (completableSourceArr == null) {
            completableSourceArr = new CompletableSource[8];
            try {
                length = 0;
                for (CompletableSource completableSource : this.sourcesIterable) {
                    if (completableSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), completableObserver);
                        return;
                    }
                    if (length == completableSourceArr.length) {
                        CompletableSource[] completableSourceArr2 = new CompletableSource[(length >> 2) + length];
                        System.arraycopy(completableSourceArr, 0, completableSourceArr2, 0, length);
                        completableSourceArr = completableSourceArr2;
                    }
                    int i6 = length + 1;
                    completableSourceArr[length] = completableSource;
                    length = i6;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, completableObserver);
                return;
            }
        } else {
            length = completableSourceArr.length;
        }
        final CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        CompletableObserver completableObserver2 = new CompletableObserver() { // from class: io.reactivex.internal.operators.completable.CompletableAmb.1
            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    compositeDisposable.dispose();
                    completableObserver.onComplete();
                }
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th2) {
                if (!atomicBoolean.compareAndSet(false, true)) {
                    RxJavaPlugins.onError(th2);
                } else {
                    compositeDisposable.dispose();
                    completableObserver.onError(th2);
                }
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                compositeDisposable.add(disposable);
            }
        };
        for (int i7 = 0; i7 < length; i7++) {
            CompletableSource completableSource2 = completableSourceArr[i7];
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (completableSource2 == null) {
                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                if (!atomicBoolean.compareAndSet(false, true)) {
                    RxJavaPlugins.onError(nullPointerException);
                    return;
                } else {
                    compositeDisposable.dispose();
                    completableObserver.onError(nullPointerException);
                    return;
                }
            }
            completableSource2.subscribe(completableObserver2);
        }
        if (length == 0) {
            completableObserver.onComplete();
        }
    }

    public CompletableAmb(CompletableSource[] completableSourceArr, Iterable<? extends CompletableSource> iterable) {
        this.sources = completableSourceArr;
        this.sourcesIterable = iterable;
    }
}
