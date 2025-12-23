package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzjx implements zznj {
    private final zzjw zza;

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zze(int i6, List list) throws IOException {
        for (int i7 = 0; i7 < list.size(); i7++) {
            this.zza.zze(i6, (zzjo) list.get(i7));
        }
    }

    public static zzjx zza(zzjw zzjwVar) {
        zzjx zzjxVar = zzjwVar.zza;
        return zzjxVar != null ? zzjxVar : new zzjx(zzjwVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzA(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzll)) {
            if (!z5) {
                while (i7 < list.size()) {
                    this.zza.zzh(i6, ((Long) list.get(i7)).longValue());
                    i7++;
                }
                return;
            }
            this.zza.zzr(i6, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                ((Long) list.get(i9)).getClass();
                i8 += 8;
            }
            this.zza.zzt(i8);
            while (i7 < list.size()) {
                this.zza.zzi(((Long) list.get(i7)).longValue());
                i7++;
            }
            return;
        }
        zzll zzllVar = (zzll) list;
        if (!z5) {
            while (i7 < zzllVar.size()) {
                this.zza.zzh(i6, zzllVar.zza(i7));
                i7++;
            }
            return;
        }
        this.zza.zzr(i6, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < zzllVar.size(); i11++) {
            zzllVar.zza(i11);
            i10 += 8;
        }
        this.zza.zzt(i10);
        while (i7 < zzllVar.size()) {
            this.zza.zzi(zzllVar.zza(i7));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzB(int i6, int i7) throws IOException {
        this.zza.zzs(i6, (i7 >> 31) ^ (i7 + i7));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzC(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzks)) {
            if (!z5) {
                while (i7 < list.size()) {
                    zzjw zzjwVar = this.zza;
                    int intValue = ((Integer) list.get(i7)).intValue();
                    zzjwVar.zzs(i6, (intValue >> 31) ^ (intValue + intValue));
                    i7++;
                }
                return;
            }
            this.zza.zzr(i6, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                int intValue2 = ((Integer) list.get(i9)).intValue();
                i8 += zzjw.zzz((intValue2 >> 31) ^ (intValue2 + intValue2));
            }
            this.zza.zzt(i8);
            while (i7 < list.size()) {
                zzjw zzjwVar2 = this.zza;
                int intValue3 = ((Integer) list.get(i7)).intValue();
                zzjwVar2.zzt((intValue3 >> 31) ^ (intValue3 + intValue3));
                i7++;
            }
            return;
        }
        zzks zzksVar = (zzks) list;
        if (!z5) {
            while (i7 < zzksVar.size()) {
                zzjw zzjwVar3 = this.zza;
                int zze = zzksVar.zze(i7);
                zzjwVar3.zzs(i6, (zze >> 31) ^ (zze + zze));
                i7++;
            }
            return;
        }
        this.zza.zzr(i6, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < zzksVar.size(); i11++) {
            int zze2 = zzksVar.zze(i11);
            i10 += zzjw.zzz((zze2 >> 31) ^ (zze2 + zze2));
        }
        this.zza.zzt(i10);
        while (i7 < zzksVar.size()) {
            zzjw zzjwVar4 = this.zza;
            int zze3 = zzksVar.zze(i7);
            zzjwVar4.zzt((zze3 >> 31) ^ (zze3 + zze3));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzD(int i6, long j6) throws IOException {
        this.zza.zzu(i6, (j6 >> 63) ^ (j6 + j6));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzE(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzll)) {
            if (!z5) {
                while (i7 < list.size()) {
                    zzjw zzjwVar = this.zza;
                    long longValue = ((Long) list.get(i7)).longValue();
                    zzjwVar.zzu(i6, (longValue >> 63) ^ (longValue + longValue));
                    i7++;
                }
                return;
            }
            this.zza.zzr(i6, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                long longValue2 = ((Long) list.get(i9)).longValue();
                i8 += zzjw.zzA((longValue2 >> 63) ^ (longValue2 + longValue2));
            }
            this.zza.zzt(i8);
            while (i7 < list.size()) {
                zzjw zzjwVar2 = this.zza;
                long longValue3 = ((Long) list.get(i7)).longValue();
                zzjwVar2.zzv((longValue3 >> 63) ^ (longValue3 + longValue3));
                i7++;
            }
            return;
        }
        zzll zzllVar = (zzll) list;
        if (!z5) {
            while (i7 < zzllVar.size()) {
                zzjw zzjwVar3 = this.zza;
                long zza = zzllVar.zza(i7);
                zzjwVar3.zzu(i6, (zza >> 63) ^ (zza + zza));
                i7++;
            }
            return;
        }
        this.zza.zzr(i6, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < zzllVar.size(); i11++) {
            long zza2 = zzllVar.zza(i11);
            i10 += zzjw.zzA((zza2 >> 63) ^ (zza2 + zza2));
        }
        this.zza.zzt(i10);
        while (i7 < zzllVar.size()) {
            zzjw zzjwVar4 = this.zza;
            long zza3 = zzllVar.zza(i7);
            zzjwVar4.zzv((zza3 >> 63) ^ (zza3 + zza3));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    @Deprecated
    public final void zzF(int i6) throws IOException {
        this.zza.zzr(i6, 3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzG(int i6, String str) throws IOException {
        this.zza.zzp(i6, str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzH(int i6, List list) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzli)) {
            while (i7 < list.size()) {
                this.zza.zzp(i6, (String) list.get(i7));
                i7++;
            }
            return;
        }
        zzli zzliVar = (zzli) list;
        while (i7 < list.size()) {
            Object zza = zzliVar.zza();
            if (zza instanceof String) {
                this.zza.zzp(i6, (String) zza);
            } else {
                this.zza.zze(i6, (zzjo) zza);
            }
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzI(int i6, int i7) throws IOException {
        this.zza.zzs(i6, i7);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzJ(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzks)) {
            if (!z5) {
                while (i7 < list.size()) {
                    this.zza.zzs(i6, ((Integer) list.get(i7)).intValue());
                    i7++;
                }
                return;
            }
            this.zza.zzr(i6, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += zzjw.zzz(((Integer) list.get(i9)).intValue());
            }
            this.zza.zzt(i8);
            while (i7 < list.size()) {
                this.zza.zzt(((Integer) list.get(i7)).intValue());
                i7++;
            }
            return;
        }
        zzks zzksVar = (zzks) list;
        if (!z5) {
            while (i7 < zzksVar.size()) {
                this.zza.zzs(i6, zzksVar.zze(i7));
                i7++;
            }
            return;
        }
        this.zza.zzr(i6, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < zzksVar.size(); i11++) {
            i10 += zzjw.zzz(zzksVar.zze(i11));
        }
        this.zza.zzt(i10);
        while (i7 < zzksVar.size()) {
            this.zza.zzt(zzksVar.zze(i7));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzK(int i6, long j6) throws IOException {
        this.zza.zzu(i6, j6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzL(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzll)) {
            if (!z5) {
                while (i7 < list.size()) {
                    this.zza.zzu(i6, ((Long) list.get(i7)).longValue());
                    i7++;
                }
                return;
            }
            this.zza.zzr(i6, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += zzjw.zzA(((Long) list.get(i9)).longValue());
            }
            this.zza.zzt(i8);
            while (i7 < list.size()) {
                this.zza.zzv(((Long) list.get(i7)).longValue());
                i7++;
            }
            return;
        }
        zzll zzllVar = (zzll) list;
        if (!z5) {
            while (i7 < zzllVar.size()) {
                this.zza.zzu(i6, zzllVar.zza(i7));
                i7++;
            }
            return;
        }
        this.zza.zzr(i6, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < zzllVar.size(); i11++) {
            i10 += zzjw.zzA(zzllVar.zza(i11));
        }
        this.zza.zzt(i10);
        while (i7 < zzllVar.size()) {
            this.zza.zzv(zzllVar.zza(i7));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzb(int i6, boolean z5) throws IOException {
        this.zza.zzd(i6, z5);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzc(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzjf)) {
            if (!z5) {
                while (i7 < list.size()) {
                    this.zza.zzd(i6, ((Boolean) list.get(i7)).booleanValue());
                    i7++;
                }
                return;
            }
            this.zza.zzr(i6, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                ((Boolean) list.get(i9)).getClass();
                i8++;
            }
            this.zza.zzt(i8);
            while (i7 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i7)).booleanValue() ? (byte) 1 : (byte) 0);
                i7++;
            }
            return;
        }
        zzjf zzjfVar = (zzjf) list;
        if (!z5) {
            while (i7 < zzjfVar.size()) {
                this.zza.zzd(i6, zzjfVar.zzf(i7));
                i7++;
            }
            return;
        }
        this.zza.zzr(i6, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < zzjfVar.size(); i11++) {
            zzjfVar.zzf(i11);
            i10++;
        }
        this.zza.zzt(i10);
        while (i7 < zzjfVar.size()) {
            this.zza.zzb(zzjfVar.zzf(i7) ? (byte) 1 : (byte) 0);
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzd(int i6, zzjo zzjoVar) throws IOException {
        this.zza.zze(i6, zzjoVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzf(int i6, double d6) throws IOException {
        this.zza.zzh(i6, Double.doubleToRawLongBits(d6));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzg(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzjy)) {
            if (!z5) {
                while (i7 < list.size()) {
                    this.zza.zzh(i6, Double.doubleToRawLongBits(((Double) list.get(i7)).doubleValue()));
                    i7++;
                }
                return;
            }
            this.zza.zzr(i6, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                ((Double) list.get(i9)).getClass();
                i8 += 8;
            }
            this.zza.zzt(i8);
            while (i7 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i7)).doubleValue()));
                i7++;
            }
            return;
        }
        zzjy zzjyVar = (zzjy) list;
        if (!z5) {
            while (i7 < zzjyVar.size()) {
                this.zza.zzh(i6, Double.doubleToRawLongBits(zzjyVar.zze(i7)));
                i7++;
            }
            return;
        }
        this.zza.zzr(i6, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < zzjyVar.size(); i11++) {
            zzjyVar.zze(i11);
            i10 += 8;
        }
        this.zza.zzt(i10);
        while (i7 < zzjyVar.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(zzjyVar.zze(i7)));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    @Deprecated
    public final void zzh(int i6) throws IOException {
        this.zza.zzr(i6, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzi(int i6, int i7) throws IOException {
        this.zza.zzj(i6, i7);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzj(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzks)) {
            if (!z5) {
                while (i7 < list.size()) {
                    this.zza.zzj(i6, ((Integer) list.get(i7)).intValue());
                    i7++;
                }
                return;
            }
            this.zza.zzr(i6, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += zzjw.zzA(((Integer) list.get(i9)).intValue());
            }
            this.zza.zzt(i8);
            while (i7 < list.size()) {
                this.zza.zzk(((Integer) list.get(i7)).intValue());
                i7++;
            }
            return;
        }
        zzks zzksVar = (zzks) list;
        if (!z5) {
            while (i7 < zzksVar.size()) {
                this.zza.zzj(i6, zzksVar.zze(i7));
                i7++;
            }
            return;
        }
        this.zza.zzr(i6, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < zzksVar.size(); i11++) {
            i10 += zzjw.zzA(zzksVar.zze(i11));
        }
        this.zza.zzt(i10);
        while (i7 < zzksVar.size()) {
            this.zza.zzk(zzksVar.zze(i7));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzk(int i6, int i7) throws IOException {
        this.zza.zzf(i6, i7);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzl(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzks)) {
            if (!z5) {
                while (i7 < list.size()) {
                    this.zza.zzf(i6, ((Integer) list.get(i7)).intValue());
                    i7++;
                }
                return;
            }
            this.zza.zzr(i6, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                ((Integer) list.get(i9)).getClass();
                i8 += 4;
            }
            this.zza.zzt(i8);
            while (i7 < list.size()) {
                this.zza.zzg(((Integer) list.get(i7)).intValue());
                i7++;
            }
            return;
        }
        zzks zzksVar = (zzks) list;
        if (!z5) {
            while (i7 < zzksVar.size()) {
                this.zza.zzf(i6, zzksVar.zze(i7));
                i7++;
            }
            return;
        }
        this.zza.zzr(i6, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < zzksVar.size(); i11++) {
            zzksVar.zze(i11);
            i10 += 4;
        }
        this.zza.zzt(i10);
        while (i7 < zzksVar.size()) {
            this.zza.zzg(zzksVar.zze(i7));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzm(int i6, long j6) throws IOException {
        this.zza.zzh(i6, j6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzn(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzll)) {
            if (!z5) {
                while (i7 < list.size()) {
                    this.zza.zzh(i6, ((Long) list.get(i7)).longValue());
                    i7++;
                }
                return;
            }
            this.zza.zzr(i6, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                ((Long) list.get(i9)).getClass();
                i8 += 8;
            }
            this.zza.zzt(i8);
            while (i7 < list.size()) {
                this.zza.zzi(((Long) list.get(i7)).longValue());
                i7++;
            }
            return;
        }
        zzll zzllVar = (zzll) list;
        if (!z5) {
            while (i7 < zzllVar.size()) {
                this.zza.zzh(i6, zzllVar.zza(i7));
                i7++;
            }
            return;
        }
        this.zza.zzr(i6, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < zzllVar.size(); i11++) {
            zzllVar.zza(i11);
            i10 += 8;
        }
        this.zza.zzt(i10);
        while (i7 < zzllVar.size()) {
            this.zza.zzi(zzllVar.zza(i7));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzo(int i6, float f6) throws IOException {
        this.zza.zzf(i6, Float.floatToRawIntBits(f6));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzp(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzki)) {
            if (!z5) {
                while (i7 < list.size()) {
                    this.zza.zzf(i6, Float.floatToRawIntBits(((Float) list.get(i7)).floatValue()));
                    i7++;
                }
                return;
            }
            this.zza.zzr(i6, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                ((Float) list.get(i9)).getClass();
                i8 += 4;
            }
            this.zza.zzt(i8);
            while (i7 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i7)).floatValue()));
                i7++;
            }
            return;
        }
        zzki zzkiVar = (zzki) list;
        if (!z5) {
            while (i7 < zzkiVar.size()) {
                this.zza.zzf(i6, Float.floatToRawIntBits(zzkiVar.zze(i7)));
                i7++;
            }
            return;
        }
        this.zza.zzr(i6, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < zzkiVar.size(); i11++) {
            zzkiVar.zze(i11);
            i10 += 4;
        }
        this.zza.zzt(i10);
        while (i7 < zzkiVar.size()) {
            this.zza.zzg(Float.floatToRawIntBits(zzkiVar.zze(i7)));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzq(int i6, Object obj, zzmi zzmiVar) throws IOException {
        zzjw zzjwVar = this.zza;
        zzjwVar.zzr(i6, 3);
        zzmiVar.zzi((zzlw) obj, zzjwVar.zza);
        zzjwVar.zzr(i6, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzr(int i6, int i7) throws IOException {
        this.zza.zzj(i6, i7);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzs(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzks)) {
            if (!z5) {
                while (i7 < list.size()) {
                    this.zza.zzj(i6, ((Integer) list.get(i7)).intValue());
                    i7++;
                }
                return;
            }
            this.zza.zzr(i6, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += zzjw.zzA(((Integer) list.get(i9)).intValue());
            }
            this.zza.zzt(i8);
            while (i7 < list.size()) {
                this.zza.zzk(((Integer) list.get(i7)).intValue());
                i7++;
            }
            return;
        }
        zzks zzksVar = (zzks) list;
        if (!z5) {
            while (i7 < zzksVar.size()) {
                this.zza.zzj(i6, zzksVar.zze(i7));
                i7++;
            }
            return;
        }
        this.zza.zzr(i6, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < zzksVar.size(); i11++) {
            i10 += zzjw.zzA(zzksVar.zze(i11));
        }
        this.zza.zzt(i10);
        while (i7 < zzksVar.size()) {
            this.zza.zzk(zzksVar.zze(i7));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzt(int i6, long j6) throws IOException {
        this.zza.zzu(i6, j6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzu(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzll)) {
            if (!z5) {
                while (i7 < list.size()) {
                    this.zza.zzu(i6, ((Long) list.get(i7)).longValue());
                    i7++;
                }
                return;
            }
            this.zza.zzr(i6, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += zzjw.zzA(((Long) list.get(i9)).longValue());
            }
            this.zza.zzt(i8);
            while (i7 < list.size()) {
                this.zza.zzv(((Long) list.get(i7)).longValue());
                i7++;
            }
            return;
        }
        zzll zzllVar = (zzll) list;
        if (!z5) {
            while (i7 < zzllVar.size()) {
                this.zza.zzu(i6, zzllVar.zza(i7));
                i7++;
            }
            return;
        }
        this.zza.zzr(i6, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < zzllVar.size(); i11++) {
            i10 += zzjw.zzA(zzllVar.zza(i11));
        }
        this.zza.zzt(i10);
        while (i7 < zzllVar.size()) {
            this.zza.zzv(zzllVar.zza(i7));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzv(int i6, Object obj, zzmi zzmiVar) throws IOException {
        this.zza.zzm(i6, (zzlw) obj, zzmiVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzw(int i6, Object obj) throws IOException {
        if (obj instanceof zzjo) {
            this.zza.zzo(i6, (zzjo) obj);
        } else {
            this.zza.zzn(i6, (zzlw) obj);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzx(int i6, int i7) throws IOException {
        this.zza.zzf(i6, i7);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzy(int i6, List list, boolean z5) throws IOException {
        int i7 = 0;
        if (!(list instanceof zzks)) {
            if (!z5) {
                while (i7 < list.size()) {
                    this.zza.zzf(i6, ((Integer) list.get(i7)).intValue());
                    i7++;
                }
                return;
            }
            this.zza.zzr(i6, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                ((Integer) list.get(i9)).getClass();
                i8 += 4;
            }
            this.zza.zzt(i8);
            while (i7 < list.size()) {
                this.zza.zzg(((Integer) list.get(i7)).intValue());
                i7++;
            }
            return;
        }
        zzks zzksVar = (zzks) list;
        if (!z5) {
            while (i7 < zzksVar.size()) {
                this.zza.zzf(i6, zzksVar.zze(i7));
                i7++;
            }
            return;
        }
        this.zza.zzr(i6, 2);
        int i10 = 0;
        for (int i11 = 0; i11 < zzksVar.size(); i11++) {
            zzksVar.zze(i11);
            i10 += 4;
        }
        this.zza.zzt(i10);
        while (i7 < zzksVar.size()) {
            this.zza.zzg(zzksVar.zze(i7));
            i7++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zznj
    public final void zzz(int i6, long j6) throws IOException {
        this.zza.zzh(i6, j6);
    }

    private zzjx(zzjw zzjwVar) {
        byte[] bArr = zzkz.zzb;
        this.zza = zzjwVar;
        zzjwVar.zza = this;
    }
}
