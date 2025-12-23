package io.reactivex.disposables;

import java.util.concurrent.Future;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class FutureDisposable extends ReferenceDisposable<Future<?>> {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(Future<?> future) {
        future.cancel(this.allowInterrupt);
    }

    FutureDisposable(Future<?> future, boolean z5) {
        super(future);
        this.allowInterrupt = z5;
    }
}
