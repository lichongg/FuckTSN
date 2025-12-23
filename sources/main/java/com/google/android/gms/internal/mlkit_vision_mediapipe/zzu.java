package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzu extends zzbh {
    private Object[] zza = new Object[8];
    private int zzb = 0;

    private final int zzh(zzai zzaiVar) {
        for (int i6 = 0; i6 < this.zzb; i6++) {
            if (this.zza[i6 + i6].equals(zzaiVar)) {
                return i6;
            }
        }
        return -1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Metadata{");
        for (int i6 = 0; i6 < this.zzb; i6++) {
            sb.append(" '");
            sb.append(zzb(i6));
            sb.append("': ");
            sb.append(zzd(i6));
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbh
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbh
    public final zzai zzb(int i6) {
        if (i6 < this.zzb) {
            return (zzai) this.zza[i6 + i6];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbh
    public final Object zzd(int i6) {
        if (i6 < this.zzb) {
            return this.zza[i6 + i6 + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    zzu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzbh
    @NullableDecl
    public final Object zzc(zzai zzaiVar) {
        int zzh = zzh(zzaiVar);
        if (zzh != -1) {
            return zzaiVar.zze(this.zza[zzh + zzh + 1]);
        }
        return null;
    }

    final void zze(zzai zzaiVar, Object obj) {
        int zzh;
        if (!zzaiVar.zzi() && (zzh = zzh(zzaiVar)) != -1) {
            zzdy.zza(obj, "metadata value");
            this.zza[zzh + zzh + 1] = obj;
            return;
        }
        int i6 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (i6 + i6 > length) {
            this.zza = Arrays.copyOf(objArr, length + length);
        }
        Object[] objArr2 = this.zza;
        int i7 = this.zzb;
        zzdy.zza(zzaiVar, "metadata key");
        objArr2[i7 + i7] = zzaiVar;
        Object[] objArr3 = this.zza;
        int i8 = this.zzb;
        zzdy.zza(obj, "metadata value");
        objArr3[i8 + i8 + 1] = obj;
        this.zzb++;
    }

    final void zzf(zzai zzaiVar) {
        int i6;
        int zzh = zzh(zzaiVar);
        if (zzh >= 0) {
            int i7 = zzh + zzh;
            int i8 = i7 + 2;
            while (true) {
                i6 = this.zzb;
                if (i8 >= i6 + i6) {
                    break;
                }
                Object obj = this.zza[i8];
                if (!obj.equals(zzaiVar)) {
                    Object[] objArr = this.zza;
                    objArr[i7] = obj;
                    objArr[i7 + 1] = objArr[i8 + 1];
                    i7 += 2;
                }
                i8 += 2;
            }
            this.zzb = i6 - ((i8 - i7) >> 1);
            while (i7 < i8) {
                this.zza[i7] = null;
                i7++;
            }
        }
    }
}
