package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOperator;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CompletableLift extends Completable {
    final CompletableOperator onLift;
    final CompletableSource source;

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        try {
            this.source.subscribe(this.onLift.apply(completableObserver));
        } catch (NullPointerException e6) {
            throw e6;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    public CompletableLift(CompletableSource completableSource, CompletableOperator completableOperator) {
        this.source = completableSource;
        this.onLift = completableOperator;
    }
}
