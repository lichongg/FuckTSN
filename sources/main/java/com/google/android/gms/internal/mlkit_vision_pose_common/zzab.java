package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class zzab extends AbstractCollection {
    final Object zza;
    Collection zzb;

    @CheckForNull
    final zzab zzc;

    @CheckForNull
    final Collection zzd;
    final /* synthetic */ zzae zze;

    zzab(zzae zzaeVar, Object obj, @CheckForNull Collection collection, zzab zzabVar) {
        this.zze = zzaeVar;
        this.zza = obj;
        this.zzb = collection;
        this.zzc = zzabVar;
        this.zzd = zzabVar == null ? null : zzabVar.zzb;
    }

    @Override // java.util.Collection
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        zzb();
        return this.zzb.equals(obj);
    }

    final void zza() {
        Map map;
        zzab zzabVar = this.zzc;
        if (zzabVar != null) {
            zzabVar.zza();
            return;
        }
        zzae zzaeVar = this.zze;
        Object obj = this.zza;
        map = zzaeVar.zza;
        map.put(obj, this.zzb);
    }

    final void zzb() {
        Map map;
        zzab zzabVar = this.zzc;
        if (zzabVar != null) {
            zzabVar.zzb();
            zzab zzabVar2 = this.zzc;
            if (zzabVar2.zzb != this.zzd) {
                throw new ConcurrentModificationException();
            }
            return;
        }
        if (this.zzb.isEmpty()) {
            zzae zzaeVar = this.zze;
            Object obj = this.zza;
            map = zzaeVar.zza;
            Collection collection = (Collection) map.get(obj);
            if (collection != null) {
                this.zzb = collection;
            }
        }
    }

    final void zzc() {
        Map map;
        zzab zzabVar = this.zzc;
        if (zzabVar != null) {
            zzabVar.zzc();
        } else if (this.zzb.isEmpty()) {
            zzae zzaeVar = this.zze;
            Object obj = this.zza;
            map = zzaeVar.zza;
            map.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        int i6;
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        boolean add = this.zzb.add(obj);
        if (add) {
            zzae zzaeVar = this.zze;
            i6 = zzaeVar.zzb;
            zzaeVar.zzb = i6 + 1;
            if (isEmpty) {
                zza();
                return true;
            }
        }
        return add;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        int i6;
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.zzb.addAll(collection);
        if (addAll) {
            int size2 = this.zzb.size();
            zzae zzaeVar = this.zze;
            i6 = zzaeVar.zzb;
            zzaeVar.zzb = i6 + (size2 - size);
            if (size == 0) {
                zza();
                return true;
            }
            return addAll;
        }
        return addAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int i6;
        int size = size();
        if (size == 0) {
            return;
        }
        this.zzb.clear();
        zzae zzaeVar = this.zze;
        i6 = zzaeVar.zzb;
        zzaeVar.zzb = i6 - size;
        zzc();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        zzb();
        return this.zzb.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        zzb();
        return this.zzb.containsAll(collection);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        zzb();
        return this.zzb.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzb();
        return new zzaa(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(@CheckForNull Object obj) {
        int i6;
        zzb();
        boolean remove = this.zzb.remove(obj);
        if (remove) {
            zzae zzaeVar = this.zze;
            i6 = zzaeVar.zzb;
            zzaeVar.zzb = i6 - 1;
            zzc();
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        int i6;
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.zzb.removeAll(collection);
        if (removeAll) {
            int size2 = this.zzb.size();
            zzae zzaeVar = this.zze;
            int i7 = size2 - size;
            i6 = zzaeVar.zzb;
            zzaeVar.zzb = i6 + i7;
            zzc();
        }
        return removeAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        int i6;
        collection.getClass();
        int size = size();
        boolean retainAll = this.zzb.retainAll(collection);
        if (retainAll) {
            int size2 = this.zzb.size();
            zzae zzaeVar = this.zze;
            int i7 = size2 - size;
            i6 = zzaeVar.zzb;
            zzaeVar.zzb = i6 + i7;
            zzc();
        }
        return retainAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        zzb();
        return this.zzb.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        zzb();
        return this.zzb.toString();
    }
}
