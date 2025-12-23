package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class ConstantObservable<T> implements Observable<T> {
    private static final ConstantObservable<Object> NULL_OBSERVABLE = new ConstantObservable<>(null);
    private static final String TAG = "ConstantObservable";
    private final ListenableFuture<T> mValueFuture;

    @NonNull
    public static <U> Observable<U> withValue(@Nullable U u5) {
        return u5 == null ? NULL_OBSERVABLE : new ConstantObservable(u5);
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(@NonNull Executor executor, @NonNull final Observable.Observer<? super T> observer) {
        this.mValueFuture.addListener(new Runnable() { // from class: androidx.camera.core.impl.p
            @Override // java.lang.Runnable
            public final void run() {
                ConstantObservable.a(ConstantObservable.this, observer);
            }
        }, executor);
    }

    @Override // androidx.camera.core.impl.Observable
    @NonNull
    public ListenableFuture<T> fetchData() {
        return this.mValueFuture;
    }

    private ConstantObservable(@Nullable T t5) {
        this.mValueFuture = Futures.immediateFuture(t5);
    }

    public static /* synthetic */ void a(ConstantObservable constantObservable, Observable.Observer observer) {
        constantObservable.getClass();
        try {
            observer.onNewData(constantObservable.mValueFuture.get());
        } catch (InterruptedException | ExecutionException e6) {
            observer.onError(e6);
        }
    }

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(@NonNull Observable.Observer<? super T> observer) {
    }
}
