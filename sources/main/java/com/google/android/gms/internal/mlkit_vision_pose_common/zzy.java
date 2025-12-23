package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzy extends zzbn {
    final /* synthetic */ zzae zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzy(zzae zzaeVar, Map map) {
        super(map);
        this.zza = zzaeVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return this.zzb.keySet().containsAll(collection);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        return this == obj || this.zzb.keySet().equals(obj);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zzb.keySet().hashCode();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzbn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzx(this, this.zzb.entrySet().iterator());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzbn, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        int i6;
        Collection collection = (Collection) this.zzb.remove(obj);
        if (collection == null) {
            return false;
        }
        int size = collection.size();
        collection.clear();
        zzae zzaeVar = this.zza;
        i6 = zzaeVar.zzb;
        zzaeVar.zzb = i6 - size;
        return size > 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzbn, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        zzbi.zza(iterator());
    }
}
