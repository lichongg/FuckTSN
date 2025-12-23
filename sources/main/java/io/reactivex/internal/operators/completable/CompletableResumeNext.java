package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CompletableResumeNext extends Completable {
    final Function<? super Throwable, ? extends CompletableSource> errorMapper;
    final CompletableSource source;

    @Override // io.reactivex.Completable
    protected void subscribeActual(final CompletableObserver completableObserver) {
        final SequentialDisposable sequentialDisposable = new SequentialDisposable();
        completableObserver.onSubscribe(sequentialDisposable);
        this.source.subscribe(new CompletableObserver() { // from class: io.reactivex.internal.operators.completable.CompletableResumeNext.1
            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                completableObserver.onComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                try {
                    CompletableSource apply = CompletableResumeNext.this.errorMapper.apply(th);
                    if (apply != null) {
                        apply.subscribe(new CompletableObserver() { // from class: io.reactivex.internal.operators.completable.CompletableResumeNext.1.1
                            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
                            public void onComplete() {
                                completableObserver.onComplete();
                            }

                            @Override // io.reactivex.CompletableObserver
                            public void onError(Throwable th2) {
                                completableObserver.onError(th2);
                            }

                            @Override // io.reactivex.CompletableObserver
                            public void onSubscribe(Disposable disposable) {
                                sequentialDisposable.update(disposable);
                            }
                        });
                        return;
                    }
                    NullPointerException nullPointerException = new NullPointerException("The CompletableConsumable returned is null");
                    nullPointerException.initCause(th);
                    completableObserver.onError(nullPointerException);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    completableObserver.onError(new CompositeException(th2, th));
                }
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                sequentialDisposable.update(disposable);
            }
        });
    }

    public CompletableResumeNext(CompletableSource completableSource, Function<? super Throwable, ? extends CompletableSource> function) {
        this.source = completableSource;
        this.errorMapper = function;
    }
}
