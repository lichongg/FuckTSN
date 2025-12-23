package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class zzad extends zzab implements List {
    final /* synthetic */ zzae zzf;

    @Override // java.util.List
    public final ListIterator listIterator() {
        zzb();
        return new zzac(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzad(zzae zzaeVar, Object obj, @CheckForNull List list, zzab zzabVar) {
        super(zzaeVar, obj, list, zzabVar);
        this.zzf = zzaeVar;
    }

    @Override // java.util.List
    public final void add(int i6, Object obj) {
        int i7;
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i6, obj);
        zzae zzaeVar = this.zzf;
        i7 = zzaeVar.zzb;
        zzaeVar.zzb = i7 + 1;
        if (isEmpty) {
            zza();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i6, Collection collection) {
        int i7;
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.zzb).addAll(i6, collection);
        if (addAll) {
            int size2 = this.zzb.size();
            zzae zzaeVar = this.zzf;
            i7 = zzaeVar.zzb;
            zzaeVar.zzb = i7 + (size2 - size);
            if (size == 0) {
                zza();
                return true;
            }
            return addAll;
        }
        return addAll;
    }

    @Override // java.util.List
    public final Object get(int i6) {
        zzb();
        return ((List) this.zzb).get(i6);
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        zzb();
        return ((List) this.zzb).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        zzb();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i6) {
        zzb();
        return new zzac(this, i6);
    }

    @Override // java.util.List
    public final Object remove(int i6) {
        int i7;
        zzb();
        Object remove = ((List) this.zzb).remove(i6);
        zzae zzaeVar = this.zzf;
        i7 = zzaeVar.zzb;
        zzaeVar.zzb = i7 - 1;
        zzc();
        return remove;
    }

    @Override // java.util.List
    public final Object set(int i6, Object obj) {
        zzb();
        return ((List) this.zzb).set(i6, obj);
    }

    @Override // java.util.List
    public final List subList(int i6, int i7) {
        zzb();
        List subList = ((List) this.zzb).subList(i6, i7);
        zzab zzabVar = this.zzc;
        if (zzabVar == null) {
            zzabVar = this;
        }
        return this.zzf.zzf(this.zza, subList, zzabVar);
    }
}
