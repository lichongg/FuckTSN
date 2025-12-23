package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.AbstractMap;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbu extends zzbd {
    final /* synthetic */ zzbv zza;

    zzbu(zzbv zzbvVar) {
        this.zza = zzbvVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i6) {
        int i7;
        Object[] objArr;
        Object[] objArr2;
        i7 = this.zza.zzc;
        zzq.zza(i6, i7, "index");
        objArr = this.zza.zzb;
        int i8 = i6 + i6;
        Object obj = objArr[i8];
        Objects.requireNonNull(obj);
        objArr2 = this.zza.zzb;
        Object obj2 = objArr2[i8 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i6;
        i6 = this.zza.zzc;
        return i6;
    }
}
