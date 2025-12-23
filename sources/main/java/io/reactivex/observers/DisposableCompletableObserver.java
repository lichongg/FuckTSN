package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class DisposableCompletableObserver implements CompletableObserver, Disposable {

    /* renamed from: s, reason: collision with root package name */
    final AtomicReference<Disposable> f43420s = new AtomicReference<>();

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f43420s);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f43420s.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.CompletableObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this.f43420s, disposable)) {
            onStart();
        }
    }

    protected void onStart() {
    }
}
