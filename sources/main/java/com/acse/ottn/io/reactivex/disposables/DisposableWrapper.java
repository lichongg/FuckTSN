package com.acse.ottn.io.reactivex.disposables;

import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DisposableWrapper implements Disposable {
    m subscription;

    @Override // com.acse.ottn.io.reactivex.disposables.Disposable
    public void dispose() {
        this.subscription.unsubscribe();
    }

    @Override // com.acse.ottn.io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.subscription.isUnsubscribed();
    }

    public DisposableWrapper(m mVar) {
        this.subscription = mVar;
    }
}
