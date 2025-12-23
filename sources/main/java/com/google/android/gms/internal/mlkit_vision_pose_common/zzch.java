package com.google.android.gms.internal.mlkit_vision_pose_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzch implements zzcm {
    private final int zza;
    private final zzcl zzb;

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcm)) {
            return false;
        }
        zzcm zzcmVar = (zzcm) obj;
        return this.zza == zzcmVar.zza() && this.zzb.equals(zzcmVar.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return zzcm.class;
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzcm
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzcm
    public final zzcl zzb() {
        return this.zzb;
    }

    zzch(int i6, zzcl zzclVar) {
        this.zza = i6;
        this.zzb = zzclVar;
    }
}
