package com.google.mlkit.acceleration.internal;

import com.google.mlkit.acceleration.internal.PipelineId;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzd extends PipelineId.Builder {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;

    @Override // com.google.mlkit.acceleration.internal.PipelineId.Builder
    public final PipelineId build() {
        String str;
        String str2;
        String str3;
        String str4 = this.zza;
        if (str4 != null && (str = this.zzb) != null && (str2 = this.zzc) != null && (str3 = this.zzd) != null) {
            return new AutoValue_PipelineId(str4, str, str2, str3, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" namespace");
        }
        if (this.zzb == null) {
            sb.append(" name");
        }
        if (this.zzc == null) {
            sb.append(" clientLibraryName");
        }
        if (this.zzd == null) {
            sb.append(" clientLibraryVersion");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.mlkit.acceleration.internal.PipelineId.Builder
    public final PipelineId.Builder setClientLibraryName(String str) {
        if (str == null) {
            throw new NullPointerException("Null clientLibraryName");
        }
        this.zzc = str;
        return this;
    }

    @Override // com.google.mlkit.acceleration.internal.PipelineId.Builder
    public final PipelineId.Builder setClientLibraryVersion(String str) {
        if (str == null) {
            throw new NullPointerException("Null clientLibraryVersion");
        }
        this.zzd = str;
        return this;
    }

    @Override // com.google.mlkit.acceleration.internal.PipelineId.Builder
    public final PipelineId.Builder setName(String str) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.zzb = str;
        return this;
    }

    @Override // com.google.mlkit.acceleration.internal.PipelineId.Builder
    public final PipelineId.Builder setNamespace(String str) {
        if (str == null) {
            throw new NullPointerException("Null namespace");
        }
        this.zza = str;
        return this;
    }

    zzd() {
    }
}
