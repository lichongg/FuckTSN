package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zzdm implements Iterator {
    zzdn zza;
    zzdn zzb = null;
    int zzc;
    final /* synthetic */ zzdo zzd;

    zzdm(zzdo zzdoVar) {
        this.zzd = zzdoVar;
        this.zza = zzdoVar.zzd.zzd;
        this.zzc = zzdoVar.zzc;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza != this.zzd.zzd;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzdn zzdnVar = this.zzb;
        if (zzdnVar == null) {
            throw new IllegalStateException();
        }
        this.zzd.zze(zzdnVar, true);
        this.zzb = null;
        this.zzc = this.zzd.zzc;
    }

    final zzdn zza() {
        zzdo zzdoVar = this.zzd;
        zzdn zzdnVar = this.zza;
        if (zzdnVar == zzdoVar.zzd) {
            throw new NoSuchElementException();
        }
        if (zzdoVar.zzc != this.zzc) {
            throw new ConcurrentModificationException();
        }
        this.zza = zzdnVar.zzd;
        this.zzb = zzdnVar;
        return zzdnVar;
    }
}
