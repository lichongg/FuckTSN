package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class Response<T extends Result> {
    private Result zza;

    public Response() {
    }

    protected Response(@NonNull T t5) {
        this.zza = t5;
    }

    @NonNull
    protected T getResult() {
        return (T) this.zza;
    }

    public void setResult(@NonNull T t5) {
        this.zza = t5;
    }
}
