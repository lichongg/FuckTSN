package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class TransformedResult<R extends Result> {
    public abstract void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks);

    @NonNull
    @ResultIgnorabilityUnspecified
    public abstract <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform);
}
