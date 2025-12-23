package io.reactivex;

import io.reactivex.disposables.Disposable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface Observer<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t5);

    void onSubscribe(Disposable disposable);
}
