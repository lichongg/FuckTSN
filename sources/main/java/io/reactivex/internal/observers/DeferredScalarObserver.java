package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements Observer<T> {
    private static final long serialVersionUID = -266195175408988651L;

    /* renamed from: s, reason: collision with root package name */
    protected Disposable f43124s;

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.value = null;
        error(th);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        T t5 = this.value;
        if (t5 == null) {
            complete();
        } else {
            this.value = null;
            complete(t5);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f43124s, disposable)) {
            this.f43124s = disposable;
            this.actual.onSubscribe(this);
        }
    }

    public DeferredScalarObserver(Observer<? super R> observer) {
        super(observer);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
    public void dispose() {
        super.dispose();
        this.f43124s.dispose();
    }
}
