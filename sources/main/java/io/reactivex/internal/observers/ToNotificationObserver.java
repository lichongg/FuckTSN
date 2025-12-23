package io.reactivex.internal.observers;

import io.reactivex.Notification;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ToNotificationObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -7420197867343208289L;
    final Consumer<? super Notification<Object>> consumer;

    @Override // io.reactivex.Observer
    public void onComplete() {
        try {
            this.consumer.accept(Notification.createOnComplete());
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        try {
            this.consumer.accept(Notification.createOnError(th));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t5) {
        if (t5 == null) {
            get().dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        try {
            this.consumer.accept(Notification.createOnNext(t5));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            get().dispose();
            onError(th);
        }
    }

    public ToNotificationObserver(Consumer<? super Notification<Object>> consumer) {
        this.consumer = consumer;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
