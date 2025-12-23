package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CompletableDoOnEvent extends Completable {
    final Consumer<? super Throwable> onEvent;
    final CompletableSource source;

    @Override // io.reactivex.Completable
    protected void subscribeActual(final CompletableObserver completableObserver) {
        this.source.subscribe(new CompletableObserver() { // from class: io.reactivex.internal.operators.completable.CompletableDoOnEvent.1
            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                try {
                    CompletableDoOnEvent.this.onEvent.accept(null);
                    completableObserver.onComplete();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    completableObserver.onError(th);
                }
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                try {
                    CompletableDoOnEvent.this.onEvent.accept(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    th = new CompositeException(th, th2);
                }
                completableObserver.onError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                completableObserver.onSubscribe(disposable);
            }
        });
    }

    public CompletableDoOnEvent(CompletableSource completableSource, Consumer<? super Throwable> consumer) {
        this.source = completableSource;
        this.onEvent = consumer;
    }
}
