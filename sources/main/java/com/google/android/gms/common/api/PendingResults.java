package com.google.android.gms.common.api;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class PendingResults {
    @NonNull
    public static PendingResult<Status> canceledPendingResult() {
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.cancel();
        return statusPendingResult;
    }

    @NonNull
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(@NonNull R r5) {
        Preconditions.checkNotNull(r5, "Result must not be null");
        zah zahVar = new zah(null);
        zahVar.setResult(r5);
        return new OptionalPendingResultImpl(zahVar);
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result> PendingResult<R> immediateFailedResult(@NonNull R r5, @NonNull GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(r5, "Result must not be null");
        Preconditions.checkArgument(!r5.getStatus().isSuccess(), "Status code must not be SUCCESS");
        zag zagVar = new zag(googleApiClient, r5);
        zagVar.setResult(r5);
        return zagVar;
    }

    private PendingResults() {
    }

    @NonNull
    public static <R extends Result> PendingResult<R> canceledPendingResult(@NonNull R r5) {
        Preconditions.checkNotNull(r5, "Result must not be null");
        Preconditions.checkArgument(r5.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        zaf zafVar = new zaf(r5);
        zafVar.cancel();
        return zafVar;
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(@NonNull R r5, @NonNull GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(r5, "Result must not be null");
        zah zahVar = new zah(googleApiClient);
        zahVar.setResult(r5);
        return new OptionalPendingResultImpl(zahVar);
    }

    @NonNull
    public static PendingResult<Status> immediatePendingResult(@NonNull Status status) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(Looper.getMainLooper());
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }

    @NonNull
    @KeepForSdk
    public static PendingResult<Status> immediatePendingResult(@NonNull Status status, @NonNull GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }
}
