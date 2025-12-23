package com.google.mlkit.common.sdkinternal;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class ModelInfo {
    private final String zza;
    private final Uri zzb;
    private final String zzc;
    private final ModelType zzd;

    @NonNull
    @KeepForSdk
    public String getModelHash() {
        return this.zzc;
    }

    @NonNull
    @KeepForSdk
    public String getModelNameForPersist() {
        return this.zza;
    }

    @NonNull
    @KeepForSdk
    public ModelType getModelType() {
        return this.zzd;
    }

    @NonNull
    @KeepForSdk
    public Uri getModelUri() {
        return this.zzb;
    }

    @KeepForSdk
    public ModelInfo(@NonNull String str, @NonNull Uri uri, @NonNull String str2, @NonNull ModelType modelType) {
        this.zza = str;
        this.zzb = uri;
        this.zzc = str2;
        this.zzd = modelType;
    }
}
