package com.acse.ottn.io.reactivex;

import com.acse.ottn.io.reactivex.annotations.NonNull;
import rx.e;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface ObservableOnSubscribe<T> extends e.a<T> {
    @Override // rx.functions.b
    /* bridge */ /* synthetic */ void call(Object obj);

    void call(l<? super T> lVar);

    void subscribe(@NonNull ObservableEmitter<T> observableEmitter) throws Exception;
}
