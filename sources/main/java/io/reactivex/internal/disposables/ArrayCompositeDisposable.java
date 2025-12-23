package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<Disposable> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Disposable andSet;
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i6 = 0; i6 < length; i6++) {
                Disposable disposable = get(i6);
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (disposable != disposableHelper && (andSet = getAndSet(i6, disposableHelper)) != disposableHelper && andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get(0) == DisposableHelper.DISPOSED;
    }

    public ArrayCompositeDisposable(int i6) {
        super(i6);
    }

    public Disposable replaceResource(int i6, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = get(i6);
            if (disposable2 == DisposableHelper.DISPOSED) {
                disposable.dispose();
                return null;
            }
        } while (!compareAndSet(i6, disposable2, disposable));
        return disposable2;
    }

    public boolean setResource(int i6, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = get(i6);
            if (disposable2 == DisposableHelper.DISPOSED) {
                disposable.dispose();
                return false;
            }
        } while (!compareAndSet(i6, disposable2, disposable));
        if (disposable2 != null) {
            disposable2.dispose();
            return true;
        }
        return true;
    }
}
