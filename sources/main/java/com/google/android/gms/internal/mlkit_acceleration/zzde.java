package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzde implements zzgv {
    private final zzdd zza;

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzB(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!z5) {
            while (i7 < list.size()) {
                zzdd zzddVar = this.zza;
                int intValue = ((Integer) list.get(i7)).intValue();
                zzddVar.zzp(i6, (intValue >> 31) ^ (intValue + intValue));
                i7++;
            }
            return;
        }
        this.zza.zzo(i6, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            int intValue2 = ((Integer) list.get(i9)).intValue();
            i8 += zzdd.zzw((intValue2 >> 31) ^ (intValue2 + intValue2));
        }
        this.zza.zzq(i8);
        while (i7 < list.size()) {
            zzdd zzddVar2 = this.zza;
            int intValue3 = ((Integer) list.get(i7)).intValue();
            zzddVar2.zzq((intValue3 >> 31) ^ (intValue3 + intValue3));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzI(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!z5) {
            while (i7 < list.size()) {
                this.zza.zzp(i6, ((Integer) list.get(i7)).intValue());
                i7++;
            }
            return;
        }
        this.zza.zzo(i6, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            i8 += zzdd.zzw(((Integer) list.get(i9)).intValue());
        }
        this.zza.zzq(i8);
        while (i7 < list.size()) {
            this.zza.zzq(((Integer) list.get(i7)).intValue());
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzK(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!z5) {
            while (i7 < list.size()) {
                this.zza.zzr(i6, ((Long) list.get(i7)).longValue());
                i7++;
            }
            return;
        }
        this.zza.zzo(i6, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            i8 += zzdd.zzx(((Long) list.get(i9)).longValue());
        }
        this.zza.zzq(i8);
        while (i7 < list.size()) {
            this.zza.zzs(((Long) list.get(i7)).longValue());
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzc(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!z5) {
            while (i7 < list.size()) {
                this.zza.zzd(i6, ((Boolean) list.get(i7)).booleanValue());
                i7++;
            }
            return;
        }
        this.zza.zzo(i6, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            ((Boolean) list.get(i9)).getClass();
            i8++;
        }
        this.zza.zzq(i8);
        while (i7 < list.size()) {
            this.zza.zzb(((Boolean) list.get(i7)).booleanValue() ? (byte) 1 : (byte) 0);
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zze(int i6, List list) throws IOException {
        for (int i7 = 0; i7 < list.size(); i7++) {
            this.zza.zze(i6, (zzcs) list.get(i7));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzg(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!z5) {
            while (i7 < list.size()) {
                this.zza.zzh(i6, Double.doubleToRawLongBits(((Double) list.get(i7)).doubleValue()));
                i7++;
            }
            return;
        }
        this.zza.zzo(i6, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            ((Double) list.get(i9)).getClass();
            i8 += 8;
        }
        this.zza.zzq(i8);
        while (i7 < list.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i7)).doubleValue()));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzj(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!z5) {
            while (i7 < list.size()) {
                this.zza.zzj(i6, ((Integer) list.get(i7)).intValue());
                i7++;
            }
            return;
        }
        this.zza.zzo(i6, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            i8 += zzdd.zzx(((Integer) list.get(i9)).intValue());
        }
        this.zza.zzq(i8);
        while (i7 < list.size()) {
            this.zza.zzk(((Integer) list.get(i7)).intValue());
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzl(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!z5) {
            while (i7 < list.size()) {
                this.zza.zzf(i6, ((Integer) list.get(i7)).intValue());
                i7++;
            }
            return;
        }
        this.zza.zzo(i6, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            ((Integer) list.get(i9)).getClass();
            i8 += 4;
        }
        this.zza.zzq(i8);
        while (i7 < list.size()) {
            this.zza.zzg(((Integer) list.get(i7)).intValue());
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzn(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!z5) {
            while (i7 < list.size()) {
                this.zza.zzh(i6, ((Long) list.get(i7)).longValue());
                i7++;
            }
            return;
        }
        this.zza.zzo(i6, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            ((Long) list.get(i9)).getClass();
            i8 += 8;
        }
        this.zza.zzq(i8);
        while (i7 < list.size()) {
            this.zza.zzi(((Long) list.get(i7)).longValue());
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzp(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!z5) {
            while (i7 < list.size()) {
                this.zza.zzf(i6, Float.floatToRawIntBits(((Float) list.get(i7)).floatValue()));
                i7++;
            }
            return;
        }
        this.zza.zzo(i6, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            ((Float) list.get(i9)).getClass();
            i8 += 4;
        }
        this.zza.zzq(i8);
        while (i7 < list.size()) {
            this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i7)).floatValue()));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzs(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!z5) {
            while (i7 < list.size()) {
                this.zza.zzj(i6, ((Integer) list.get(i7)).intValue());
                i7++;
            }
            return;
        }
        this.zza.zzo(i6, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            i8 += zzdd.zzx(((Integer) list.get(i9)).intValue());
        }
        this.zza.zzq(i8);
        while (i7 < list.size()) {
            this.zza.zzk(((Integer) list.get(i7)).intValue());
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzu(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!z5) {
            while (i7 < list.size()) {
                this.zza.zzr(i6, ((Long) list.get(i7)).longValue());
                i7++;
            }
            return;
        }
        this.zza.zzo(i6, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            i8 += zzdd.zzx(((Long) list.get(i9)).longValue());
        }
        this.zza.zzq(i8);
        while (i7 < list.size()) {
            this.zza.zzs(((Long) list.get(i7)).longValue());
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzx(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!z5) {
            while (i7 < list.size()) {
                this.zza.zzf(i6, ((Integer) list.get(i7)).intValue());
                i7++;
            }
            return;
        }
        this.zza.zzo(i6, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            ((Integer) list.get(i9)).getClass();
            i8 += 4;
        }
        this.zza.zzq(i8);
        while (i7 < list.size()) {
            this.zza.zzg(((Integer) list.get(i7)).intValue());
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzz(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!z5) {
            while (i7 < list.size()) {
                this.zza.zzh(i6, ((Long) list.get(i7)).longValue());
                i7++;
            }
            return;
        }
        this.zza.zzo(i6, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            ((Long) list.get(i9)).getClass();
            i8 += 8;
        }
        this.zza.zzq(i8);
        while (i7 < list.size()) {
            this.zza.zzi(((Long) list.get(i7)).longValue());
            i7++;
        }
    }

    public static zzde zza(zzdd zzddVar) {
        zzde zzdeVar = zzddVar.zza;
        return zzdeVar != null ? zzdeVar : new zzde(zzddVar);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzA(int i6, int i7) throws IOException {
        this.zza.zzp(i6, (i7 >> 31) ^ (i7 + i7));
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzC(int i6, long j6) throws IOException {
        this.zza.zzr(i6, (j6 >> 63) ^ (j6 + j6));
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzD(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!z5) {
            while (i7 < list.size()) {
                zzdd zzddVar = this.zza;
                long longValue = ((Long) list.get(i7)).longValue();
                zzddVar.zzr(i6, (longValue >> 63) ^ (longValue + longValue));
                i7++;
            }
            return;
        }
        this.zza.zzo(i6, 2);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            long longValue2 = ((Long) list.get(i9)).longValue();
            i8 += zzdd.zzx((longValue2 >> 63) ^ (longValue2 + longValue2));
        }
        this.zza.zzq(i8);
        while (i7 < list.size()) {
            zzdd zzddVar2 = this.zza;
            long longValue3 = ((Long) list.get(i7)).longValue();
            zzddVar2.zzs((longValue3 >> 63) ^ (longValue3 + longValue3));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    @Deprecated
    public final void zzE(int i6) throws IOException {
        this.zza.zzo(i6, 3);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzF(int i6, String str) throws IOException {
        this.zza.zzm(i6, str);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzG(int i6, List list) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzei)) {
            while (i7 < list.size()) {
                this.zza.zzm(i6, (String) list.get(i7));
                i7++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        while (i7 < list.size()) {
            Object zzf = zzeiVar.zzf(i7);
            if (zzf instanceof String) {
                this.zza.zzm(i6, (String) zzf);
            } else {
                this.zza.zze(i6, (zzcs) zzf);
            }
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzH(int i6, int i7) throws IOException {
        this.zza.zzp(i6, i7);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzJ(int i6, long j6) throws IOException {
        this.zza.zzr(i6, j6);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzb(int i6, boolean z5) throws IOException {
        this.zza.zzd(i6, z5);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzd(int i6, zzcs zzcsVar) throws IOException {
        this.zza.zze(i6, zzcsVar);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzf(int i6, double d6) throws IOException {
        this.zza.zzh(i6, Double.doubleToRawLongBits(d6));
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    @Deprecated
    public final void zzh(int i6) throws IOException {
        this.zza.zzo(i6, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzi(int i6, int i7) throws IOException {
        this.zza.zzj(i6, i7);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzk(int i6, int i7) throws IOException {
        this.zza.zzf(i6, i7);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzm(int i6, long j6) throws IOException {
        this.zza.zzh(i6, j6);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzo(int i6, float f6) throws IOException {
        this.zza.zzf(i6, Float.floatToRawIntBits(f6));
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzq(int i6, Object obj, zzfm zzfmVar) throws IOException {
        zzdd zzddVar = this.zza;
        zzddVar.zzo(i6, 3);
        zzfmVar.zzj((zzfa) obj, zzddVar.zza);
        zzddVar.zzo(i6, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzr(int i6, int i7) throws IOException {
        this.zza.zzj(i6, i7);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzt(int i6, long j6) throws IOException {
        this.zza.zzr(i6, j6);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzv(int i6, Object obj, zzfm zzfmVar) throws IOException {
        zzfa zzfaVar = (zzfa) obj;
        zzda zzdaVar = (zzda) this.zza;
        zzdaVar.zzq((i6 << 3) | 2);
        zzdaVar.zzq(((zzcc) zzfaVar).zzt(zzfmVar));
        zzfmVar.zzj(zzfaVar, zzdaVar.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzw(int i6, int i7) throws IOException {
        this.zza.zzf(i6, i7);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgv
    public final void zzy(int i6, long j6) throws IOException {
        this.zza.zzh(i6, j6);
    }

    private zzde(zzdd zzddVar) {
        byte[] bArr = zzeb.zzd;
        this.zza = zzddVar;
        zzddVar.zza = this;
    }
}
