package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzac extends zzz {
    public zzac() {
        super(4);
    }

    public final zzaf zzc() {
        this.zzc = true;
        return zzaf.zzg(this.zza, this.zzb);
    }

    public final zzac zzb(Object obj) {
        obj.getClass();
        int i6 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i6) {
            this.zza = Arrays.copyOf(objArr, zzaa.zza(length, i6));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i7 = this.zzb;
        this.zzb = i7 + 1;
        objArr2[i7] = obj;
        return this;
    }
}
