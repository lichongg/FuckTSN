package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class zzaa implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzab zzc;

    zzaa(zzab zzabVar, Iterator it) {
        this.zzc = zzabVar;
        this.zzb = zzabVar.zzb;
        this.zza = it;
    }

    zzaa(zzab zzabVar) {
        this.zzc = zzabVar;
        Collection collection = zzabVar.zzb;
        this.zzb = collection;
        this.zza = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i6;
        this.zza.remove();
        zzae zzaeVar = this.zzc.zze;
        i6 = zzaeVar.zzb;
        zzaeVar.zzb = i6 - 1;
        this.zzc.zzc();
    }

    final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }
}
