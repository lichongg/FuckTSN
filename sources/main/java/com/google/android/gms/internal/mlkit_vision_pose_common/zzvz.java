package com.google.android.gms.internal.mlkit_vision_pose_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzvz extends zzwd {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzwd) {
            zzwd zzwdVar = (zzwd) obj;
            if (this.zza.equals(zzwdVar.zzb()) && this.zzb == zzwdVar.zzc() && this.zzc == zzwdVar.zza()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.zza + ", enableFirelog=" + this.zzb + ", firelogEventType=" + this.zzc + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzwd
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzwd
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzwd
    public final boolean zzc() {
        return this.zzb;
    }

    /* synthetic */ zzvz(String str, boolean z5, int i6, zzvy zzvyVar) {
        this.zza = str;
        this.zzb = z5;
        this.zzc = i6;
    }
}
