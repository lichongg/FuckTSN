package com.google.android.gms.internal.mlkit_acceleration;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzfj extends zzcd implements RandomAccess {
    private static final zzfj zza = new zzfj(new Object[0], 0, false);
    private Object[] zzb;
    private int zzc;

    zzfj() {
        this(new Object[10], 0, true);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final void add(int i6, Object obj) {
        int i7;
        zza();
        if (i6 < 0 || i6 > (i7 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i6));
        }
        int i8 = i6 + 1;
        Object[] objArr = this.zzb;
        if (i7 < objArr.length) {
            System.arraycopy(objArr, i6, objArr, i8, i7 - i6);
        } else {
            Object[] objArr2 = new Object[((i7 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i6);
            System.arraycopy(this.zzb, i6, objArr2, i8, this.zzc - i6);
            this.zzb = objArr2;
        }
        this.zzb[i6] = obj;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    private zzfj(Object[] objArr, int i6, boolean z5) {
        super(z5);
        this.zzb = objArr;
        this.zzc = i6;
    }

    public static zzfj zze() {
        return zza;
    }

    private final String zzf(int i6) {
        return "Index:" + i6 + ", Size:" + this.zzc;
    }

    private final void zzg(int i6) {
        if (i6 < 0 || i6 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i6));
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzea
    public final /* bridge */ /* synthetic */ zzea zzd(int i6) {
        if (i6 >= this.zzc) {
            return new zzfj(Arrays.copyOf(this.zzb, i6), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i6) {
        zzg(i6);
        return this.zzb[i6];
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final Object remove(int i6) {
        zza();
        zzg(i6);
        Object[] objArr = this.zzb;
        Object obj = objArr[i6];
        if (i6 < this.zzc - 1) {
            System.arraycopy(objArr, i6 + 1, objArr, i6, (r2 - i6) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final Object set(int i6, Object obj) {
        zza();
        zzg(i6);
        Object[] objArr = this.zzb;
        Object obj2 = objArr[i6];
        objArr[i6] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zza();
        int i6 = this.zzc;
        Object[] objArr = this.zzb;
        if (i6 == objArr.length) {
            this.zzb = Arrays.copyOf(objArr, ((i6 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.zzb;
        int i7 = this.zzc;
        this.zzc = i7 + 1;
        objArr2[i7] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
