package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class StatusPendingResult extends BasePendingResult<Status> {
    @Deprecated
    public StatusPendingResult(@NonNull Looper looper) {
        super(looper);
    }

    @KeepForSdk
    public StatusPendingResult(@NonNull GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    @NonNull
    protected final /* bridge */ /* synthetic */ Status createFailedResult(@NonNull Status status) {
        return status;
    }
}
