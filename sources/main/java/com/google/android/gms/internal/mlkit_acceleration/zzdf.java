package com.google.android.gms.internal.mlkit_acceleration;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzdf extends zzcd implements RandomAccess, zzea, zzfh {
    private static final zzdf zza = new zzdf(new double[0], 0, false);
    private double[] zzb;
    private int zzc;

    zzdf() {
        this(new double[10], 0, true);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i6, Object obj) {
        int i7;
        double doubleValue = ((Double) obj).doubleValue();
        zza();
        if (i6 < 0 || i6 > (i7 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i6));
        }
        int i8 = i6 + 1;
        double[] dArr = this.zzb;
        if (i7 < dArr.length) {
            System.arraycopy(dArr, i6, dArr, i8, i7 - i6);
        } else {
            double[] dArr2 = new double[((i7 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i6);
            System.arraycopy(this.zzb, i6, dArr2, i8, this.zzc - i6);
            this.zzb = dArr2;
        }
        this.zzb[i6] = doubleValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdf)) {
            return super.equals(obj);
        }
        zzdf zzdfVar = (zzdf) obj;
        if (this.zzc != zzdfVar.zzc) {
            return false;
        }
        double[] dArr = zzdfVar.zzb;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            if (Double.doubleToLongBits(this.zzb[i6]) != Double.doubleToLongBits(dArr[i6])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i6 = 1;
        for (int i7 = 0; i7 < this.zzc; i7++) {
            long doubleToLongBits = Double.doubleToLongBits(this.zzb[i7]);
            byte[] bArr = zzeb.zzd;
            i6 = (i6 * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        }
        return i6;
    }

    private zzdf(double[] dArr, int i6, boolean z5) {
        super(z5);
        this.zzb = dArr;
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
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int i6 = this.zzc;
        for (int i7 = 0; i7 < i6; i7++) {
            if (this.zzb[i7] == doubleValue) {
                return i7;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i6, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zza();
        zzg(i6);
        double[] dArr = this.zzb;
        double d6 = dArr[i6];
        dArr[i6] = doubleValue;
        return Double.valueOf(d6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzea
    public final /* bridge */ /* synthetic */ zzea zzd(int i6) {
        if (i6 >= this.zzc) {
            return new zzdf(Arrays.copyOf(this.zzb, i6), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzeb.zzd;
        collection.getClass();
        if (!(collection instanceof zzdf)) {
            return super.addAll(collection);
        }
        zzdf zzdfVar = (zzdf) collection;
        int i6 = zzdfVar.zzc;
        if (i6 == 0) {
            return false;
        }
        int i7 = this.zzc;
        if (Integer.MAX_VALUE - i7 >= i6) {
            int i8 = i7 + i6;
            double[] dArr = this.zzb;
            if (i8 > dArr.length) {
                this.zzb = Arrays.copyOf(dArr, i8);
            }
            System.arraycopy(zzdfVar.zzb, 0, this.zzb, this.zzc, zzdfVar.zzc);
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
        return Double.valueOf(this.zzb[i6]);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i6) {
        zza();
        zzg(i6);
        double[] dArr = this.zzb;
        double d6 = dArr[i6];
        if (i6 < this.zzc - 1) {
            System.arraycopy(dArr, i6 + 1, dArr, i6, (r3 - i6) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d6);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i6, int i7) {
        zza();
        if (i7 >= i6) {
            double[] dArr = this.zzb;
            System.arraycopy(dArr, i7, dArr, i6, this.zzc - i7);
            this.zzc -= i7 - i6;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final void zze(double d6) {
        zza();
        int i6 = this.zzc;
        double[] dArr = this.zzb;
        if (i6 == dArr.length) {
            double[] dArr2 = new double[((i6 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i6);
            this.zzb = dArr2;
        }
        double[] dArr3 = this.zzb;
        int i7 = this.zzc;
        this.zzc = i7 + 1;
        dArr3[i7] = d6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Double) obj).doubleValue());
        return true;
    }
}
