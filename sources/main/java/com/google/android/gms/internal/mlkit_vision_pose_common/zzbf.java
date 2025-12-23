package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzbf {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzbe zzc;

    public final zzbf zza(Object obj, Object obj2) {
        int i6 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i7 = i6 + i6;
        if (i7 > length) {
            this.zza = Arrays.copyOf(objArr, zzax.zza(length, i7));
        }
        zzaj.zzb(obj, obj2);
        Object[] objArr2 = this.zza;
        int i8 = this.zzb;
        int i9 = i8 + i8;
        objArr2[i9] = obj;
        objArr2[i9 + 1] = obj2;
        this.zzb = i8 + 1;
        return this;
    }

    public final zzbg zzb() {
        zzbe zzbeVar = this.zzc;
        if (zzbeVar != null) {
            throw zzbeVar.zza();
        }
        zzby zzh = zzby.zzh(this.zzb, this.zza, this);
        zzbe zzbeVar2 = this.zzc;
        if (zzbeVar2 == null) {
            return zzh;
        }
        throw zzbeVar2.zza();
    }
}
