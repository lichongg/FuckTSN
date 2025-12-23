package com.acse.ottn.io.reactivex;

import com.acse.ottn.io.reactivex.annotations.NonNull;
import com.acse.ottn.io.reactivex.disposables.Disposable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface Observer<T> {
    void onComplete();

    void onError(@NonNull Throwable th);

    void onNext(@NonNull T t5);

    void onSubscribe(@NonNull Disposable disposable);
}
