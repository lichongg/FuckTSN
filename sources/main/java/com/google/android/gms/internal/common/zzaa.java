package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class zzaa extends zzab {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    zzaa(int i6) {
    }

    @CanIgnoreReturnValue
    public final zzaa zza(Object obj) {
        obj.getClass();
        int i6 = this.zzb;
        int i7 = i6 + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i7) {
            int i8 = length + (length >> 1) + 1;
            if (i8 < i7) {
                int highestOneBit = Integer.highestOneBit(i6);
                i8 = highestOneBit + highestOneBit;
            }
            if (i8 < 0) {
                i8 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i8);
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i9 = this.zzb;
        this.zzb = i9 + 1;
        objArr2[i9] = obj;
        return this;
    }
}
