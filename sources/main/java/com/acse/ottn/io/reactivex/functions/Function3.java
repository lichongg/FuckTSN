package com.acse.ottn.io.reactivex.functions;

import com.acse.ottn.io.reactivex.annotations.NonNull;
import rx.functions.r;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface Function3<T1, T2, T3, R> extends r<T1, T2, T3, R> {
    @NonNull
    R apply(@NonNull T1 t12, @NonNull T2 t22, @NonNull T3 t32) throws Exception;

    @Override // rx.functions.r
    R call(T1 t12, T2 t22, T3 t32);
}
