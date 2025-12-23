package com.google.android.gms.internal.mlkit_acceleration;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzfv implements Iterator {
    final /* synthetic */ zzfz zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        List list;
        List list2;
        this.zzc = true;
        int i6 = this.zzb + 1;
        this.zzb = i6;
        list = this.zza.zzb;
        if (i6 >= list.size()) {
            return (Map.Entry) zza().next();
        }
        list2 = this.zza.zzb;
        return (Map.Entry) list2.get(this.zzb);
    }

    /* synthetic */ zzfv(zzfz zzfzVar, zzfu zzfuVar) {
        this.zza = zzfzVar;
    }

    private final Iterator zza() {
        Map map;
        if (this.zzd == null) {
            map = this.zza.zzc;
            this.zzd = map.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i6 = this.zzb + 1;
        list = this.zza.zzb;
        if (i6 < list.size()) {
            return true;
        }
        map = this.zza.zzc;
        return !map.isEmpty() && zza().hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzn();
        int i6 = this.zzb;
        list = this.zza.zzb;
        if (i6 >= list.size()) {
            zza().remove();
            return;
        }
        zzfz zzfzVar = this.zza;
        int i7 = this.zzb;
        this.zzb = i7 - 1;
        zzfzVar.zzl(i7);
    }
}
