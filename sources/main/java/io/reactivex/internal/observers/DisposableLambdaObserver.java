package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {
    final Observer<? super T> actual;
    final Action onDispose;
    final Consumer<? super Disposable> onSubscribe;

    /* renamed from: s, reason: collision with root package name */
    Disposable f43125s;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        try {
            this.onDispose.run();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
        this.f43125s.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.f43125s.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t5) {
        this.actual.onNext(t5);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        try {
            this.onSubscribe.accept(disposable);
            if (DisposableHelper.validate(this.f43125s, disposable)) {
                this.f43125s = disposable;
                this.actual.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            disposable.dispose();
            RxJavaPlugins.onError(th);
            EmptyDisposable.error(th, this.actual);
        }
    }

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.actual = observer;
        this.onSubscribe = consumer;
        this.onDispose = action;
    }
}
