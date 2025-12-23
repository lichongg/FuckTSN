package com.google.android.gms.internal.mlkit_acceleration;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzch extends zzcd implements RandomAccess, zzea, zzfh {
    private static final zzch zza = new zzch(new boolean[0], 0, false);
    private boolean[] zzb;
    private int zzc;

    zzch() {
        this(new boolean[10], 0, true);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i6, Object obj) {
        int i7;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i6 < 0 || i6 > (i7 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i6));
        }
        int i8 = i6 + 1;
        boolean[] zArr = this.zzb;
        if (i7 < zArr.length) {
            System.arraycopy(zArr, i6, zArr, i8, i7 - i6);
        } else {
            boolean[] zArr2 = new boolean[((i7 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i6);
            System.arraycopy(this.zzb, i6, zArr2, i8, this.zzc - i6);
            this.zzb = zArr2;
        }
        this.zzb[i6] = booleanValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzch)) {
            return super.equals(obj);
        }
        zzch zzchVar = (zzch) obj;
        if (this.zzc != zzchVar.zzc) {
            return false;
        }
        boolean[] zArr = zzchVar.zzb;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            if (this.zzb[i6] != zArr[i6]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i6 = 1;
        for (int i7 = 0; i7 < this.zzc; i7++) {
            i6 = (i6 * 31) + zzeb.zza(this.zzb[i7]);
        }
        return i6;
    }

    private zzch(boolean[] zArr, int i6, boolean z5) {
        super(z5);
        this.zzb = zArr;
        this.zzc = i6;
    }

    private final String zzf(int i6) {
        return "Index:" + i6 + ", Size:" + this.zzc;
    }

    private final void zzg(int i6) {
        if (i6 < 0 || i6 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i6));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i6 = this.zzc;
        for (int i7 = 0; i7 < i6; i7++) {
            if (this.zzb[i7] == booleanValue) {
                return i7;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i6, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        zzg(i6);
        boolean[] zArr = this.zzb;
        boolean z5 = zArr[i6];
        zArr[i6] = booleanValue;
        return Boolean.valueOf(z5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzea
    public final /* bridge */ /* synthetic */ zzea zzd(int i6) {
        if (i6 >= this.zzc) {
            return new zzch(Arrays.copyOf(this.zzb, i6), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzeb.zzd;
        collection.getClass();
        if (!(collection instanceof zzch)) {
            return super.addAll(collection);
        }
        zzch zzchVar = (zzch) collection;
        int i6 = zzchVar.zzc;
        if (i6 == 0) {
            return false;
        }
        int i7 = this.zzc;
        if (Integer.MAX_VALUE - i7 >= i6) {
            int i8 = i7 + i6;
            boolean[] zArr = this.zzb;
            if (i8 > zArr.length) {
                this.zzb = Arrays.copyOf(zArr, i8);
            }
            System.arraycopy(zzchVar.zzb, 0, this.zzb, this.zzc, zzchVar.zzc);
            this.zzc = i8;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i6) {
        zzg(i6);
        return Boolean.valueOf(this.zzb[i6]);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i6) {
        zza();
        zzg(i6);
        boolean[] zArr = this.zzb;
        boolean z5 = zArr[i6];
        if (i6 < this.zzc - 1) {
            System.arraycopy(zArr, i6 + 1, zArr, i6, (r2 - i6) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z5);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i6, int i7) {
        zza();
        if (i7 >= i6) {
            boolean[] zArr = this.zzb;
            System.arraycopy(zArr, i7, zArr, i6, this.zzc - i7);
            this.zzc -= i7 - i6;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final void zze(boolean z5) {
        zza();
        int i6 = this.zzc;
        boolean[] zArr = this.zzb;
        if (i6 == zArr.length) {
            boolean[] zArr2 = new boolean[((i6 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i6);
            this.zzb = zArr2;
        }
        boolean[] zArr3 = this.zzb;
        int i7 = this.zzc;
        this.zzc = i7 + 1;
        zArr3[i7] = z5;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }
}
