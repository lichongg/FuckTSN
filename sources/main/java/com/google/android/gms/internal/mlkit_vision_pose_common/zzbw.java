package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbw extends zzbh {
    private final transient zzbg zza;
    private final transient zzbd zzb;

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzay, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzbh, com.google.android.gms.internal.mlkit_vision_pose_common.zzay, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzay
    final int zza(Object[] objArr, int i6) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzbh, com.google.android.gms.internal.mlkit_vision_pose_common.zzay
    /* renamed from: zzd */
    public final zzcc iterator() {
        return this.zzb.listIterator(0);
    }

    zzbw(zzbg zzbgVar, zzbd zzbdVar) {
        this.zza = zzbgVar;
        this.zzb = zzbdVar;
    }
}
