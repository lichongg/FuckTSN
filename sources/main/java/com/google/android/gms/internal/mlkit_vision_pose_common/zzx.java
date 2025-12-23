package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzx implements Iterator {

    @CheckForNull
    Map.Entry zza;
    final /* synthetic */ Iterator zzb;
    final /* synthetic */ zzy zzc;

    zzx(zzy zzyVar, Iterator it) {
        this.zzb = it;
        this.zzc = zzyVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry entry = (Map.Entry) this.zzb.next();
        this.zza = entry;
        return entry.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i6;
        zzq.zze(this.zza != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        zzae zzaeVar = this.zzc.zza;
        i6 = zzaeVar.zzb;
        zzaeVar.zzb = i6 - collection.size();
        collection.clear();
        this.zza = null;
    }
}
