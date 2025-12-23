package com.google.mlkit.acceleration.internal;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class AccelerationInfraException extends Exception {

    @KeepForSdk
    public static final int GET_GPU_INFO_ERROR = 2;

    @KeepForSdk
    public static final int STORAGE_ACCESS_ERROR = 1;
    private final int zza;
    private final int zzb;

    @VisibleForTesting
    public AccelerationInfraException(int i6, @Nullable Throwable th) {
        super("Acceleration infra failed with error " + i6, th);
        this.zza = i6;
        this.zzb = (i6 == 2 && (th instanceof com.google.android.gms.internal.mlkit_acceleration.zze)) ? ((com.google.android.gms.internal.mlkit_acceleration.zze) th).zza() : -1;
    }

    static AccelerationInfraException zza(Throwable th) {
        return new AccelerationInfraException(2, th);
    }

    @KeepForSdk
    public int getErrorCode() {
        return this.zzb;
    }

    @KeepForSdk
    public int getErrorType() {
        return this.zza;
    }
}
