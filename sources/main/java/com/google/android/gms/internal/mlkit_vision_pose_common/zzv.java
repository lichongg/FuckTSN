package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzv implements Iterator {
    final Iterator zza;

    @CheckForNull
    Collection zzb;
    final /* synthetic */ zzw zzc;

    zzv(zzw zzwVar) {
        this.zzc = zzwVar;
        this.zza = zzwVar.zza.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        Object key = entry.getKey();
        return new zzaz(key, this.zzc.zzb.zzb(key, (Collection) entry.getValue()));
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i6;
        zzq.zze(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzae zzaeVar = this.zzc.zzb;
        i6 = zzaeVar.zzb;
        zzaeVar.zzb = i6 - this.zzb.size();
        this.zzb.clear();
        this.zzb = null;
    }
}
