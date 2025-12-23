package com.google.android.gms.internal.mlkit_common;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzh {
    public static final zzh zza;
    private final boolean zzb;
    private final boolean zzc = false;
    private final zzaf zzd;

    static {
        zze zzeVar = null;
        zzf zzfVar = new zzf(zzeVar);
        zzfVar.zzb();
        zza = zzfVar.zzd();
        zzf zzfVar2 = new zzf(zzeVar);
        zzfVar2.zzb();
        zzfVar2.zza(new zzd());
        zzfVar2.zzd();
        zzf zzfVar3 = new zzf(zzeVar);
        zzfVar3.zzc();
        zzfVar3.zzd();
    }

    static /* bridge */ /* synthetic */ boolean zza(zzh zzhVar) {
        boolean z5 = zzhVar.zzc;
        return false;
    }

    static /* bridge */ /* synthetic */ int zzc(zzh zzhVar, Context context, zzj zzjVar) {
        zzaf zzafVar = zzhVar.zzd;
        int size = zzafVar.size();
        int i6 = 0;
        while (i6 < size) {
            int zza2 = ((zzk) zzafVar.get(i6)).zza(context, zzjVar, zzhVar.zzb) - 1;
            i6++;
            if (zza2 == 1) {
                return 2;
            }
        }
        return 3;
    }

    /* synthetic */ zzh(boolean z5, boolean z6, zzaf zzafVar, zzg zzgVar) {
        this.zzb = z5;
        this.zzd = zzafVar;
    }
}
