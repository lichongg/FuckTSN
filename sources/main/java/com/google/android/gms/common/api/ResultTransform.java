package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zacp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ResultTransform<R extends Result, S extends Result> {
    @Nullable
    @WorkerThread
    public abstract PendingResult<S> onSuccess(@NonNull R r5);

    @NonNull
    public final PendingResult<S> createFailedResult(@NonNull Status status) {
        return new zacp(status);
    }

    @NonNull
    public Status onFailure(@NonNull Status status) {
        return status;
    }
}
