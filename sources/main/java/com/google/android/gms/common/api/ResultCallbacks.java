package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(@NonNull Status status);

    public abstract void onSuccess(@NonNull R r5);

    @Override // com.google.android.gms.common.api.ResultCallback
    @KeepForSdk
    public final void onResult(@NonNull R r5) {
        Status status = r5.getStatus();
        if (status.isSuccess()) {
            onSuccess(r5);
            return;
        }
        onFailure(status);
        if (r5 instanceof Releasable) {
            try {
                ((Releasable) r5).release();
            } catch (RuntimeException unused) {
                "Unable to release ".concat(String.valueOf(r5));
            }
        }
    }
}
