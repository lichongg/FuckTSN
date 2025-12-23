package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzbd extends zzay implements List, RandomAccess {
    private static final zzcd zza = new zzbb(zzbt.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    public static zzbd zzh(Object obj) {
        Object[] objArr = {obj};
        if (obj != null) {
            return zzg(objArr, 1);
        }
        throw new NullPointerException("at index 0");
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        if (list instanceof RandomAccess) {
            for (int i6 = 0; i6 < size; i6++) {
                if (!zzp.zza(get(i6), list.get(i6))) {
                    return false;
                }
            }
            return true;
        }
        Iterator it = iterator();
        Iterator it2 = list.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !zzp.zza(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            if (obj.equals(get(i6))) {
                return i6;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzay, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzay
    /* renamed from: zzd */
    public final zzcc iterator() {
        return listIterator(0);
    }

    static zzbd zzg(Object[] objArr, int i6) {
        return i6 == 0 ? zzbt.zza : new zzbt(objArr, i6);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i6, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i6, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i6, Object obj) {
        throw new UnsupportedOperationException();
    }

    zzbd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzay, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i6 = 1;
        for (int i7 = 0; i7 < size; i7++) {
            i6 = (i6 * 31) + get(i7).hashCode();
        }
        return i6;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzay
    int zza(Object[] objArr, int i6) {
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            objArr[i7] = get(i7);
        }
        return size;
    }

    @Override // java.util.List
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public zzbd subList(int i6, int i7) {
        zzq.zzc(i6, i7, size());
        int i8 = i7 - i6;
        if (i8 == size()) {
            return this;
        }
        if (i8 == 0) {
            return zzbt.zza;
        }
        return new zzbc(this, i6, i8);
    }

    @Override // java.util.List
    /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzcd listIterator(int i6) {
        zzq.zzb(i6, size(), "index");
        if (isEmpty()) {
            return zza;
        }
        return new zzbb(this, i6);
    }
}
