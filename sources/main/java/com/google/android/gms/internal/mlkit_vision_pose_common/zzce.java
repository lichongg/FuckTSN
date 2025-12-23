package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzce extends AbstractList implements RandomAccess, Serializable {
    final int[] zza;
    final int zzb;
    final int zzc;

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzce)) {
            return super.equals(obj);
        }
        zzce zzceVar = (zzce) obj;
        int i6 = this.zzc - this.zzb;
        if (zzceVar.zzc - zzceVar.zzb != i6) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (this.zza[this.zzb + i7] != zzceVar.zza[zzceVar.zzb + i7]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object obj) {
        return (obj instanceof Integer) && zzcf.zza(this.zza, ((Integer) obj).intValue(), this.zzb, this.zzc) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i6) {
        zzq.zza(i6, this.zzc - this.zzb, "index");
        return Integer.valueOf(this.zza[this.zzb + i6]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i6 = 1;
        for (int i7 = this.zzb; i7 < this.zzc; i7++) {
            i6 = (i6 * 31) + this.zza[i7];
        }
        return i6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        int zza;
        if (!(obj instanceof Integer) || (zza = zzcf.zza(this.zza, ((Integer) obj).intValue(), this.zzb, this.zzc)) < 0) {
            return -1;
        }
        return zza - this.zzb;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.zza;
            int intValue = ((Integer) obj).intValue();
            int i6 = this.zzb;
            int i7 = this.zzc - 1;
            while (true) {
                if (i7 < i6) {
                    i7 = -1;
                    break;
                }
                if (iArr[i7] == intValue) {
                    break;
                }
                i7--;
            }
            if (i7 >= 0) {
                return i7 - this.zzb;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i6, Object obj) {
        Integer num = (Integer) obj;
        zzq.zza(i6, this.zzc - this.zzb, "index");
        int[] iArr = this.zza;
        int i7 = this.zzb + i6;
        int i8 = iArr[i7];
        num.getClass();
        iArr[i7] = num.intValue();
        return Integer.valueOf(i8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc - this.zzb;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i6, int i7) {
        zzq.zzc(i6, i7, this.zzc - this.zzb);
        if (i6 == i7) {
            return Collections.EMPTY_LIST;
        }
        int[] iArr = this.zza;
        int i8 = this.zzb;
        return new zzce(iArr, i8 + i6, i7 + i8);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder((this.zzc - this.zzb) * 5);
        sb.append('[');
        sb.append(this.zza[this.zzb]);
        int i6 = this.zzb;
        while (true) {
            i6++;
            if (i6 >= this.zzc) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.zza[i6]);
        }
    }

    zzce(int[] iArr, int i6, int i7) {
        this.zza = iArr;
        this.zzb = i6;
        this.zzc = i7;
    }
}
