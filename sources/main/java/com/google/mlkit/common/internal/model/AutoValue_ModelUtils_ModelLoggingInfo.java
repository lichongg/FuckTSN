package com.google.mlkit.common.internal.model;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.internal.model.ModelUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class AutoValue_ModelUtils_ModelLoggingInfo extends ModelUtils.ModelLoggingInfo {
    private final long zza;
    private final String zzb;
    private final boolean zzc;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ModelUtils.ModelLoggingInfo) {
            ModelUtils.ModelLoggingInfo modelLoggingInfo = (ModelUtils.ModelLoggingInfo) obj;
            if (this.zza == modelLoggingInfo.getSize() && this.zzb.equals(modelLoggingInfo.getHash()) && this.zzc == modelLoggingInfo.isManifestModel()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public String getHash() {
        return this.zzb;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public long getSize() {
        return this.zza;
    }

    public final int hashCode() {
        long j6 = this.zza;
        return ((this.zzb.hashCode() ^ ((((int) (j6 ^ (j6 >>> 32))) ^ 1000003) * 1000003)) * 1000003) ^ (true != this.zzc ? 1237 : 1231);
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public boolean isManifestModel() {
        return this.zzc;
    }

    public final String toString() {
        return "ModelLoggingInfo{size=" + this.zza + ", hash=" + this.zzb + ", manifestModel=" + this.zzc + "}";
    }

    AutoValue_ModelUtils_ModelLoggingInfo(long j6, String str, boolean z5) {
        this.zza = j6;
        this.zzb = str;
        this.zzc = z5;
    }
}
