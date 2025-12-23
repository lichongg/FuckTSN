package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zzae extends zzag implements Serializable {
    private transient Map zza;
    private transient int zzb;

    abstract Collection zza();

    Collection zzb(Object obj, Collection collection) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void zzk(zzae zzaeVar, Object obj) {
        Object obj2;
        Map map = zzaeVar.zza;
        map.getClass();
        try {
            obj2 = map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzaeVar.zzb -= size;
        }
    }

    public final Collection zze(Object obj) {
        Collection collection = (Collection) this.zza.get(obj);
        if (collection == null) {
            collection = zza();
        }
        return zzb(obj, collection);
    }

    final List zzf(Object obj, List list, @CheckForNull zzab zzabVar) {
        return list instanceof RandomAccess ? new zzz(this, obj, list, zzabVar) : new zzad(this, obj, list, zzabVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzag
    final Map zzh() {
        return new zzw(this, this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzag
    final Set zzi() {
        return new zzy(this, this.zza);
    }

    public final void zzl() {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzag, com.google.android.gms.internal.mlkit_vision_pose_common.zzbr
    public final boolean zzm(Object obj, Object obj2) {
        Collection collection = (Collection) this.zza.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.zzb++;
            return true;
        }
        Collection zza = zza();
        if (!zza.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.zzb++;
        this.zza.put(obj, zza);
        return true;
    }

    protected zzae(Map map) {
        if (map.isEmpty()) {
            this.zza = map;
            return;
        }
        throw new IllegalArgumentException();
    }
}
