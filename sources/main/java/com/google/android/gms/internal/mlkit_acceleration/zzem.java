package com.google.android.gms.internal.mlkit_acceleration;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzem extends zzeo {
    /* synthetic */ zzem(zzel zzelVar) {
        super(null);
    }

    private zzem() {
        super(null);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzeo
    final List zza(Object obj, long j6) {
        int i6;
        zzea zzeaVar = (zzea) zzgn.zzf(obj, j6);
        if (!zzeaVar.zzc()) {
            int size = zzeaVar.size();
            if (size == 0) {
                i6 = 10;
            } else {
                i6 = size + size;
            }
            zzea zzd = zzeaVar.zzd(i6);
            zzgn.zzs(obj, j6, zzd);
            return zzd;
        }
        return zzeaVar;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzeo
    final void zzb(Object obj, long j6) {
        ((zzea) zzgn.zzf(obj, j6)).zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzeo
    final void zzc(Object obj, Object obj2, long j6) {
        zzea zzeaVar = (zzea) zzgn.zzf(obj, j6);
        zzea zzeaVar2 = (zzea) zzgn.zzf(obj2, j6);
        int size = zzeaVar.size();
        int size2 = zzeaVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzeaVar.zzc()) {
                zzeaVar = zzeaVar.zzd(size2 + size);
            }
            zzeaVar.addAll(zzeaVar2);
        }
        if (size > 0) {
            zzeaVar2 = zzeaVar;
        }
        zzgn.zzs(obj, j6, zzeaVar2);
    }
}
