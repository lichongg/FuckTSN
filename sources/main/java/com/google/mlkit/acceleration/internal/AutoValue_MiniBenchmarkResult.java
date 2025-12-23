package com.google.mlkit.acceleration.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class AutoValue_MiniBenchmarkResult extends MiniBenchmarkResult {
    private final boolean zza;
    private final int zzb;
    private final float zzc;
    private final int zzd;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MiniBenchmarkResult) {
            MiniBenchmarkResult miniBenchmarkResult = (MiniBenchmarkResult) obj;
            if (this.zza == miniBenchmarkResult.zza() && this.zzb == miniBenchmarkResult.getStabilityStatus() && Float.floatToIntBits(this.zzc) == Float.floatToIntBits(miniBenchmarkResult.getCorrectnessScore()) && this.zzd == miniBenchmarkResult.getRunLatencyMs()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((((true != this.zza ? 1237 : 1231) ^ 1000003) * 1000003) ^ this.zzb) * 1000003) ^ Float.floatToIntBits(this.zzc)) * 1000003) ^ this.zzd;
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkResult
    @KeepForSdk
    public float getCorrectnessScore() {
        return this.zzc;
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkResult
    @KeepForSdk
    public int getRunLatencyMs() {
        return this.zzd;
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkResult
    @KeepForSdk
    public int getStabilityStatus() {
        return this.zzb;
    }

    public final String toString() {
        return "MiniBenchmarkResult{logged=" + this.zza + ", stabilityStatus=" + this.zzb + ", correctnessScore=" + this.zzc + ", runLatencyMs=" + this.zzd + "}";
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkResult
    public final boolean zza() {
        return this.zza;
    }

    /* synthetic */ AutoValue_MiniBenchmarkResult(boolean z5, int i6, float f6, int i7, zzc zzcVar) {
        this.zza = z5;
        this.zzb = i6;
        this.zzc = f6;
        this.zzd = i7;
    }
}
