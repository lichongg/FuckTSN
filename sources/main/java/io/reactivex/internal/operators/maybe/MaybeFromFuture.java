package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class MaybeFromFuture<T> extends Maybe<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public MaybeFromFuture(Future<? extends T> future, long j6, TimeUnit timeUnit) {
        this.future = future;
        this.timeout = j6;
        this.unit = timeUnit;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        T t5;
        Disposable empty = Disposables.empty();
        maybeObserver.onSubscribe(empty);
        if (!empty.isDisposed()) {
            try {
                long j6 = this.timeout;
                if (j6 <= 0) {
                    t5 = this.future.get();
                } else {
                    t5 = this.future.get(j6, this.unit);
                }
                if (!empty.isDisposed()) {
                    if (t5 == null) {
                        maybeObserver.onComplete();
                    } else {
                        maybeObserver.onSuccess(t5);
                    }
                }
            } catch (InterruptedException e6) {
                if (!empty.isDisposed()) {
                    maybeObserver.onError(e6);
                }
            } catch (ExecutionException e7) {
                if (!empty.isDisposed()) {
                    maybeObserver.onError(e7.getCause());
                }
            } catch (TimeoutException e8) {
                if (!empty.isDisposed()) {
                    maybeObserver.onError(e8);
                }
            }
        }
    }
}
