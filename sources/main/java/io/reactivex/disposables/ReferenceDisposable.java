package io.reactivex.disposables;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    private static final long serialVersionUID = 6537757548749041217L;

    protected abstract void onDisposed(T t5);

    ReferenceDisposable(T t5) {
        super(ObjectHelper.requireNonNull(t5, "value is null"));
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        T andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            onDisposed(andSet);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == null) {
            return true;
        }
        return false;
    }
}
