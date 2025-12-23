package com.google.android.gms.internal.mlkit_acceleration;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzdp extends zzcd implements RandomAccess, zzea, zzfh {
    private static final zzdp zza = new zzdp(new float[0], 0, false);
    private float[] zzb;
    private int zzc;

    zzdp() {
        this(new float[10], 0, true);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i6, Object obj) {
        int i7;
        float floatValue = ((Float) obj).floatValue();
        zza();
        if (i6 < 0 || i6 > (i7 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i6));
        }
        int i8 = i6 + 1;
        float[] fArr = this.zzb;
        if (i7 < fArr.length) {
            System.arraycopy(fArr, i6, fArr, i8, i7 - i6);
        } else {
            float[] fArr2 = new float[((i7 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i6);
            System.arraycopy(this.zzb, i6, fArr2, i8, this.zzc - i6);
            this.zzb = fArr2;
        }
        this.zzb[i6] = floatValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdp)) {
            return super.equals(obj);
        }
        zzdp zzdpVar = (zzdp) obj;
        if (this.zzc != zzdpVar.zzc) {
            return false;
        }
        float[] fArr = zzdpVar.zzb;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            if (Float.floatToIntBits(this.zzb[i6]) != Float.floatToIntBits(fArr[i6])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i6 = 1;
        for (int i7 = 0; i7 < this.zzc; i7++) {
            i6 = (i6 * 31) + Float.floatToIntBits(this.zzb[i7]);
        }
        return i6;
    }

    private zzdp(float[] fArr, int i6, boolean z5) {
        super(z5);
        this.zzb = fArr;
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
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int i6 = this.zzc;
        for (int i7 = 0; i7 < i6; i7++) {
            if (this.zzb[i7] == floatValue) {
                return i7;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i6, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zza();
        zzg(i6);
        float[] fArr = this.zzb;
        float f6 = fArr[i6];
        fArr[i6] = floatValue;
        return Float.valueOf(f6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzea
    public final /* bridge */ /* synthetic */ zzea zzd(int i6) {
        if (i6 >= this.zzc) {
            return new zzdp(Arrays.copyOf(this.zzb, i6), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzeb.zzd;
        collection.getClass();
        if (!(collection instanceof zzdp)) {
            return super.addAll(collection);
        }
        zzdp zzdpVar = (zzdp) collection;
        int i6 = zzdpVar.zzc;
        if (i6 == 0) {
            return false;
        }
        int i7 = this.zzc;
        if (Integer.MAX_VALUE - i7 >= i6) {
            int i8 = i7 + i6;
            float[] fArr = this.zzb;
            if (i8 > fArr.length) {
                this.zzb = Arrays.copyOf(fArr, i8);
            }
            System.arraycopy(zzdpVar.zzb, 0, this.zzb, this.zzc, zzdpVar.zzc);
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
        return Float.valueOf(this.zzb[i6]);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i6) {
        zza();
        zzg(i6);
        float[] fArr = this.zzb;
        float f6 = fArr[i6];
        if (i6 < this.zzc - 1) {
            System.arraycopy(fArr, i6 + 1, fArr, i6, (r2 - i6) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f6);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i6, int i7) {
        zza();
        if (i7 >= i6) {
            float[] fArr = this.zzb;
            System.arraycopy(fArr, i7, fArr, i6, this.zzc - i7);
            this.zzc -= i7 - i6;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final void zze(float f6) {
        zza();
        int i6 = this.zzc;
        float[] fArr = this.zzb;
        if (i6 == fArr.length) {
            float[] fArr2 = new float[((i6 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i6);
            this.zzb = fArr2;
        }
        float[] fArr3 = this.zzb;
        int i7 = this.zzc;
        this.zzc = i7 + 1;
        fArr3[i7] = f6;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcd, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Float) obj).floatValue());
        return true;
    }
}
