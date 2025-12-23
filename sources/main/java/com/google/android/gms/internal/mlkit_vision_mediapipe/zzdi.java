package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzdi extends AbstractSet {
    final int zza;
    final /* synthetic */ zzdj zzb;

    zzdi(zzdj zzdjVar, int i6) {
        this.zzb = zzdjVar;
        this.zza = i6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Object[] objArr;
        int i6 = this.zza;
        objArr = this.zzb.zzb;
        return Arrays.binarySearch(objArr, zzb(), zza(), obj, i6 == -1 ? zzdj.zza : zzdl.zza) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzdh(this);
    }

    final int zza() {
        int[] iArr;
        int i6 = this.zza;
        iArr = this.zzb.zzc;
        return iArr[i6 + 1];
    }

    final int zzb() {
        int[] iArr;
        int i6 = this.zza;
        if (i6 == -1) {
            return 0;
        }
        iArr = this.zzb.zzc;
        return iArr[i6];
    }

    final Object zzc(int i6) {
        Object[] objArr;
        objArr = this.zzb.zzb;
        return objArr[zzb() + i6];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return zza() - zzb();
    }
}
