package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class PendingResultFacade<A extends Result, B extends Result> extends PendingResult<B> {
    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(@NonNull PendingResult.StatusListener statusListener) {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final B await() {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void cancel() {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final boolean isCanceled() {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(@NonNull ResultCallback<? super B> resultCallback) {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    @ResultIgnorabilityUnspecified
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super B, ? extends S> resultTransform) {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final B await(long j6, @NonNull TimeUnit timeUnit) {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(@NonNull ResultCallback<? super B> resultCallback, long j6, @NonNull TimeUnit timeUnit) {
        throw null;
    }
}
