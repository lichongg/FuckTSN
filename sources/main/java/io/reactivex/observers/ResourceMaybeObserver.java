package io.reactivex.observers;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class ResourceMaybeObserver<T> implements MaybeObserver<T>, Disposable {

    /* renamed from: s, reason: collision with root package name */
    private final AtomicReference<Disposable> f43425s = new AtomicReference<>();
    private final ListCompositeDisposable resources = new ListCompositeDisposable();

    public final void add(Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "resource is null");
        this.resources.add(disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (DisposableHelper.dispose(this.f43425s)) {
            this.resources.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f43425s.get());
    }

    @Override // io.reactivex.MaybeObserver
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this.f43425s, disposable)) {
            onStart();
        }
    }

    protected void onStart() {
    }
}
