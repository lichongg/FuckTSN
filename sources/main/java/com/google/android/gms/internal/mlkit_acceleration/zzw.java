package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzw extends zzad {
    final /* synthetic */ zzx zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzw(zzx zzxVar, zzaf zzafVar, CharSequence charSequence) {
        super(zzafVar, charSequence);
        this.zza = zzxVar;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzad
    final int zzc(int i6) {
        return i6 + 1;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzad
    final int zzd(int i6) {
        String zza;
        CharSequence charSequence = ((zzad) this).zzb;
        int length = charSequence.length();
        if (i6 >= 0 && i6 <= length) {
            while (i6 < length) {
                if (this.zza.zza.zza(charSequence.charAt(i6))) {
                    return i6;
                }
                i6++;
            }
            return -1;
        }
        if (i6 < 0) {
            zza = zzag.zza("%s (%s) must not be negative", "index", Integer.valueOf(i6));
        } else {
            if (length < 0) {
                throw new IllegalArgumentException("negative size: " + length);
            }
            zza = zzag.zza("%s (%s) must not be greater than size (%s)", "index", Integer.valueOf(i6), Integer.valueOf(length));
        }
        throw new IndexOutOfBoundsException(zza);
    }
}
