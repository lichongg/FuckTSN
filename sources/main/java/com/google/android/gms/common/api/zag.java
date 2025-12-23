package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zag<R extends Result> extends BasePendingResult<R> {
    private final Result zae;

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final R createFailedResult(Status status) {
        return (R) this.zae;
    }

    public zag(GoogleApiClient googleApiClient, Result result) {
        super(googleApiClient);
        this.zae = result;
    }
}
