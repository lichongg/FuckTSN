package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzjy extends zziy implements RandomAccess, zzky {
    private double[] zza;
    private int zzb;

    zzjy() {
        this(new double[10], 0, true);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i6, Object obj) {
        int i7;
        double doubleValue = ((Double) obj).doubleValue();
        zzM();
        if (i6 < 0 || i6 > (i7 = this.zzb)) {
            throw new IndexOutOfBoundsException(zzg(i6));
        }
        int i8 = i6 + 1;
        double[] dArr = this.zza;
        if (i7 < dArr.length) {
            System.arraycopy(dArr, i6, dArr, i8, i7 - i6);
        } else {
            double[] dArr2 = new double[((i7 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i6);
            System.arraycopy(this.zza, i6, dArr2, i8, this.zzb - i6);
            this.zza = dArr2;
        }
        this.zza[i6] = doubleValue;
        this.zzb++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjy)) {
            return super.equals(obj);
        }
        zzjy zzjyVar = (zzjy) obj;
        if (this.zzb != zzjyVar.zzb) {
            return false;
        }
        double[] dArr = zzjyVar.zza;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            if (Double.doubleToLongBits(this.zza[i6]) != Double.doubleToLongBits(dArr[i6])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i6 = 1;
        for (int i7 = 0; i7 < this.zzb; i7++) {
            long doubleToLongBits = Double.doubleToLongBits(this.zza[i7]);
            byte[] bArr = zzkz.zzb;
            i6 = (i6 * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        }
        return i6;
    }

    static {
        new zzjy(new double[0], 0, false);
    }

    private zzjy(double[] dArr, int i6, boolean z5) {
        super(z5);
        this.zza = dArr;
        this.zzb = i6;
    }

    private final String zzg(int i6) {
        return "Index:" + i6 + ", Size:" + this.zzb;
    }

    private final void zzh(int i6) {
        if (i6 < 0 || i6 >= this.zzb) {
            throw new IndexOutOfBoundsException(zzg(i6));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            if (this.zza[i7] == doubleValue) {
                return i7;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i6, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzM();
        zzh(i6);
        double[] dArr = this.zza;
        double d6 = dArr[i6];
        dArr[i6] = doubleValue;
        return Double.valueOf(d6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzky
    public final /* bridge */ /* synthetic */ zzky zzd(int i6) {
        if (i6 >= this.zzb) {
            return new zzjy(Arrays.copyOf(this.zza, i6), this.zzb, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzM();
        byte[] bArr = zzkz.zzb;
        collection.getClass();
        if (!(collection instanceof zzjy)) {
            return super.addAll(collection);
        }
        zzjy zzjyVar = (zzjy) collection;
        int i6 = zzjyVar.zzb;
        if (i6 == 0) {
            return false;
        }
        int i7 = this.zzb;
        if (Integer.MAX_VALUE - i7 >= i6) {
            int i8 = i7 + i6;
            double[] dArr = this.zza;
            if (i8 > dArr.length) {
                this.zza = Arrays.copyOf(dArr, i8);
            }
            System.arraycopy(zzjyVar.zza, 0, this.zza, this.zzb, zzjyVar.zzb);
            this.zzb = i8;
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
        zzh(i6);
        return Double.valueOf(this.zza[i6]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i6) {
        zzM();
        zzh(i6);
        double[] dArr = this.zza;
        double d6 = dArr[i6];
        if (i6 < this.zzb - 1) {
            System.arraycopy(dArr, i6 + 1, dArr, i6, (r3 - i6) - 1);
        }
        this.zzb--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d6);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i6, int i7) {
        zzM();
        if (i7 >= i6) {
            double[] dArr = this.zza;
            System.arraycopy(dArr, i7, dArr, i6, this.zzb - i7);
            this.zzb -= i7 - i6;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final double zze(int i6) {
        zzh(i6);
        return this.zza[i6];
    }

    public final void zzf(double d6) {
        zzM();
        int i6 = this.zzb;
        double[] dArr = this.zza;
        if (i6 == dArr.length) {
            double[] dArr2 = new double[((i6 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i6);
            this.zza = dArr2;
        }
        double[] dArr3 = this.zza;
        int i7 = this.zzb;
        this.zzb = i7 + 1;
        dArr3[i7] = d6;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Double) obj).doubleValue());
        return true;
    }
}
