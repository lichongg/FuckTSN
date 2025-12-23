package com.acse.ottn.io.reactivex.functions;

import com.acse.ottn.io.reactivex.annotations.NonNull;
import rx.functions.q;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface BiFunction<T1, T2, R> extends q<T1, T2, R> {
    @NonNull
    R apply(@NonNull T1 t12, @NonNull T2 t22) throws Exception;

    @Override // rx.functions.q
    R call(T1 t12, T2 t22);
}
