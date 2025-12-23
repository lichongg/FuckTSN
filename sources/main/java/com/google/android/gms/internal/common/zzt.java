package com.google.android.gms.internal.common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzt extends zzw {
    final /* synthetic */ zzu zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzt(zzu zzuVar, zzx zzxVar, CharSequence charSequence) {
        super(zzxVar, charSequence);
        this.zza = zzuVar;
    }

    @Override // com.google.android.gms.internal.common.zzw
    final int zzc(int i6) {
        return i6 + 1;
    }

    @Override // com.google.android.gms.internal.common.zzw
    final int zzd(int i6) {
        CharSequence charSequence = ((zzw) this).zzb;
        int length = charSequence.length();
        zzs.zzb(i6, length, "index");
        while (i6 < length) {
            zzu zzuVar = this.zza;
            if (zzuVar.zza.zza(charSequence.charAt(i6))) {
                return i6;
            }
            i6++;
        }
        return -1;
    }
}
