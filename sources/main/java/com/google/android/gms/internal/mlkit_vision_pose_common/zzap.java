package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zzap implements Iterator {
    int zzb;
    int zzc;
    int zzd;
    final /* synthetic */ zzat zze;

    abstract Object zza(int i6);

    /* synthetic */ zzap(zzat zzatVar, zzao zzaoVar) {
        int i6;
        this.zze = zzatVar;
        i6 = zzatVar.zzf;
        this.zzb = i6;
        this.zzc = zzatVar.zze();
        this.zzd = -1;
    }

    private final void zzb() {
        int i6;
        i6 = this.zze.zzf;
        if (i6 != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        zzb();
        if (hasNext()) {
            int i6 = this.zzc;
            this.zzd = i6;
            Object zza = zza(i6);
            this.zzc = this.zze.zzf(this.zzc);
            return zza;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z5;
        zzb();
        if (this.zzd >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        zzq.zze(z5, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        int i6 = this.zzd;
        zzat zzatVar = this.zze;
        zzatVar.remove(zzat.zzg(zzatVar, i6));
        this.zzc--;
        this.zzd = -1;
    }
}
