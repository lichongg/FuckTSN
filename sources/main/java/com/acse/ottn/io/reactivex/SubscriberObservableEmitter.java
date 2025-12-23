package com.acse.ottn.io.reactivex;

import com.acse.ottn.io.reactivex.disposables.Disposable;
import com.acse.ottn.io.reactivex.functions.Cancellable;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SubscriberObservableEmitter<T> implements ObservableEmitter<T>, Disposable {
    Disposable disposable;
    l<? super T> subscriber;

    @Override // com.acse.ottn.io.reactivex.disposables.Disposable
    public void dispose() {
        l<? super T> lVar = this.subscriber;
        if (lVar != null) {
            lVar.unsubscribe();
        }
        Disposable disposable = this.disposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // com.acse.ottn.io.reactivex.ObservableEmitter, com.acse.ottn.io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Disposable disposable = this.disposable;
        return disposable == null ? this.subscriber.isUnsubscribed() : disposable.isDisposed();
    }

    @Override // com.acse.ottn.io.reactivex.Emitter
    public void onComplete() {
        this.subscriber.onCompleted();
    }

    @Override // com.acse.ottn.io.reactivex.Emitter
    public void onError(Throwable th) {
        this.subscriber.onError(th);
    }

    @Override // com.acse.ottn.io.reactivex.Emitter
    public void onNext(T t5) {
        this.subscriber.onNext(t5);
    }

    @Override // com.acse.ottn.io.reactivex.ObservableEmitter
    public void setDisposable(Disposable disposable) {
        this.disposable = disposable;
    }

    @Override // com.acse.ottn.io.reactivex.ObservableEmitter
    public boolean tryOnError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (isDisposed()) {
            return false;
        }
        try {
            this.subscriber.onError(th);
            dispose();
            return true;
        } catch (Throwable th2) {
            dispose();
            throw th2;
        }
    }

    public SubscriberObservableEmitter(l<? super T> lVar) {
        this.subscriber = lVar;
    }

    @Override // com.acse.ottn.io.reactivex.ObservableEmitter
    public ObservableEmitter<T> serialize() {
        return this;
    }

    @Override // com.acse.ottn.io.reactivex.ObservableEmitter
    public void setCancellable(Cancellable cancellable) {
    }
}
