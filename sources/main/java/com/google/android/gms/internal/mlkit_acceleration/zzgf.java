package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzgf extends zzgd {
    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* synthetic */ Object zzg(Object obj) {
        ((zzge) obj).zzh();
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final boolean zzr(zzfl zzflVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* synthetic */ int zza(Object obj) {
        return ((zzge) obj).zza();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* synthetic */ int zzb(Object obj) {
        return ((zzge) obj).zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzdv zzdvVar = (zzdv) obj;
        zzge zzgeVar = zzdvVar.zzc;
        if (zzgeVar != zzge.zzc()) {
            return zzgeVar;
        }
        zzge zzf = zzge.zzf();
        zzdvVar.zzc = zzf;
        return zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* synthetic */ Object zzd(Object obj) {
        return ((zzdv) obj).zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* bridge */ /* synthetic */ void zzh(Object obj, int i6, int i7) {
        ((zzge) obj).zzj((i6 << 3) | 5, Integer.valueOf(i7));
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* bridge */ /* synthetic */ void zzi(Object obj, int i6, long j6) {
        ((zzge) obj).zzj((i6 << 3) | 1, Long.valueOf(j6));
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* bridge */ /* synthetic */ void zzj(Object obj, int i6, Object obj2) {
        ((zzge) obj).zzj((i6 << 3) | 3, obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* bridge */ /* synthetic */ void zzk(Object obj, int i6, zzcs zzcsVar) {
        ((zzge) obj).zzj((i6 << 3) | 2, zzcsVar);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* bridge */ /* synthetic */ void zzl(Object obj, int i6, long j6) {
        ((zzge) obj).zzj(i6 << 3, Long.valueOf(j6));
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final void zzm(Object obj) {
        ((zzdv) obj).zzc.zzh();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* synthetic */ void zzn(Object obj, Object obj2) {
        ((zzdv) obj).zzc = (zzge) obj2;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* synthetic */ void zzo(Object obj, Object obj2) {
        ((zzdv) obj).zzc = (zzge) obj2;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* synthetic */ void zzp(Object obj, zzgv zzgvVar) throws IOException {
        ((zzge) obj).zzk(zzgvVar);
    }

    zzgf() {
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (!zzge.zzc().equals(obj2)) {
            if (zzge.zzc().equals(obj)) {
                return zzge.zze((zzge) obj, (zzge) obj2);
            }
            ((zzge) obj).zzd((zzge) obj2);
        }
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgd
    final /* synthetic */ Object zzf() {
        return zzge.zzf();
    }
}
