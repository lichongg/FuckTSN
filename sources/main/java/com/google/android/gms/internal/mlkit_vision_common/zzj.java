package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class zzj extends zzk {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    private final void zzb(int i6) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length >= i6) {
            if (this.zzc) {
                this.zza = (Object[]) objArr.clone();
                this.zzc = false;
                return;
            }
            return;
        }
        int i7 = length + (length >> 1) + 1;
        if (i7 < i6) {
            int highestOneBit = Integer.highestOneBit(i6 - 1);
            i7 = highestOneBit + highestOneBit;
        }
        if (i7 < 0) {
            i7 = Integer.MAX_VALUE;
        }
        this.zza = Arrays.copyOf(objArr, i7);
        this.zzc = false;
    }

    zzj(int i6) {
    }

    public final zzj zza(Object obj) {
        obj.getClass();
        zzb(this.zzb + 1);
        Object[] objArr = this.zza;
        int i6 = this.zzb;
        this.zzb = i6 + 1;
        objArr[i6] = obj;
        return this;
    }
}
