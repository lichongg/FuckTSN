package com.acse.ottn.io.reactivex.functions;

import rx.functions.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface Function<T, R> extends p<T, R> {
    R apply(T t5);

    @Override // rx.functions.p
    R call(T t5);
}
