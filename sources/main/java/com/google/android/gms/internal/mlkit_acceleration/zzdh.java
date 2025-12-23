package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzdh {
    private final Object zza;
    private final int zzb;

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdh)) {
            return false;
        }
        zzdh zzdhVar = (zzdh) obj;
        return this.zza == zzdhVar.zza && this.zzb == zzdhVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }

    zzdh(Object obj, int i6) {
        this.zza = obj;
        this.zzb = i6;
    }
}
