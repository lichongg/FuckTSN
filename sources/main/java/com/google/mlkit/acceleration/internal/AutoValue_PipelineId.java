package com.google.mlkit.acceleration.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class AutoValue_PipelineId extends PipelineId {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PipelineId) {
            PipelineId pipelineId = (PipelineId) obj;
            if (this.zza.equals(pipelineId.getNamespace()) && this.zzb.equals(pipelineId.getName()) && this.zzc.equals(pipelineId.getClientLibraryName()) && this.zzd.equals(pipelineId.getClientLibraryVersion())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.mlkit.acceleration.internal.PipelineId
    @KeepForSdk
    public String getClientLibraryName() {
        return this.zzc;
    }

    @Override // com.google.mlkit.acceleration.internal.PipelineId
    @KeepForSdk
    public String getClientLibraryVersion() {
        return this.zzd;
    }

    @Override // com.google.mlkit.acceleration.internal.PipelineId
    @KeepForSdk
    public String getName() {
        return this.zzb;
    }

    @Override // com.google.mlkit.acceleration.internal.PipelineId
    @KeepForSdk
    public String getNamespace() {
        return this.zza;
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode();
    }

    public final String toString() {
        return "PipelineId{namespace=" + this.zza + ", name=" + this.zzb + ", clientLibraryName=" + this.zzc + ", clientLibraryVersion=" + this.zzd + "}";
    }

    /* synthetic */ AutoValue_PipelineId(String str, String str2, String str3, String str4, zze zzeVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
    }
}
