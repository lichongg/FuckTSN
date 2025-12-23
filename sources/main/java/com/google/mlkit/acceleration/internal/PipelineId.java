package com.google.mlkit.acceleration.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class PipelineId {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static abstract class Builder {
        @NonNull
        @KeepForSdk
        public abstract PipelineId build();

        @NonNull
        @KeepForSdk
        public abstract Builder setClientLibraryName(@NonNull String str);

        @NonNull
        @KeepForSdk
        public abstract Builder setClientLibraryVersion(@NonNull String str);

        @NonNull
        @KeepForSdk
        public abstract Builder setName(@NonNull String str);

        @NonNull
        @KeepForSdk
        public abstract Builder setNamespace(@NonNull String str);
    }

    @NonNull
    @KeepForSdk
    public abstract String getClientLibraryName();

    @NonNull
    @KeepForSdk
    public abstract String getClientLibraryVersion();

    @NonNull
    @KeepForSdk
    public abstract String getName();

    @NonNull
    @KeepForSdk
    public abstract String getNamespace();

    @NonNull
    @KeepForSdk
    public static Builder builder() {
        return new zzd();
    }
}
