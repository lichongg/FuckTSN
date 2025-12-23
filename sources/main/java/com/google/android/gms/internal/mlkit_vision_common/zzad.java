package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzad implements zzai {
    private final int zza;
    private final zzah zzb;

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzai)) {
            return false;
        }
        zzai zzaiVar = (zzai) obj;
        return this.zza == zzaiVar.zza() && this.zzb.equals(zzaiVar.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return zzai.class;
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzai
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzai
    public final zzah zzb() {
        return this.zzb;
    }

    zzad(int i6, zzah zzahVar) {
        this.zza = i6;
        this.zzb = zzahVar;
    }
}
