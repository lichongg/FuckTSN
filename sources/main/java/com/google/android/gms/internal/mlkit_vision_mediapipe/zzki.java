package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzki extends zziy implements RandomAccess, zzkv {
    private static final zzki zza = new zzki(new float[0], 0, false);
    private float[] zzb;
    private int zzc;

    zzki() {
        this(new float[10], 0, true);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i6, Object obj) {
        int i7;
        float floatValue = ((Float) obj).floatValue();
        zzM();
        if (i6 < 0 || i6 > (i7 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzh(i6));
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

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzki)) {
            return super.equals(obj);
        }
        zzki zzkiVar = (zzki) obj;
        if (this.zzc != zzkiVar.zzc) {
            return false;
        }
        float[] fArr = zzkiVar.zzb;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            if (Float.floatToIntBits(this.zzb[i6]) != Float.floatToIntBits(fArr[i6])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i6 = 1;
        for (int i7 = 0; i7 < this.zzc; i7++) {
            i6 = (i6 * 31) + Float.floatToIntBits(this.zzb[i7]);
        }
        return i6;
    }

    private zzki(float[] fArr, int i6, boolean z5) {
        super(z5);
        this.zzb = fArr;
        this.zzc = i6;
    }

    public static zzki zzf() {
        return zza;
    }

    private final String zzh(int i6) {
        return "Index:" + i6 + ", Size:" + this.zzc;
    }

    private final void zzi(int i6) {
        if (i6 < 0 || i6 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzh(i6));
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

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i6, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzM();
        zzi(i6);
        float[] fArr = this.zzb;
        float f6 = fArr[i6];
        fArr[i6] = floatValue;
        return Float.valueOf(f6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzky
    public final /* bridge */ /* synthetic */ zzky zzd(int i6) {
        if (i6 >= this.zzc) {
            return new zzki(Arrays.copyOf(this.zzb, i6), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzM();
        byte[] bArr = zzkz.zzb;
        collection.getClass();
        if (!(collection instanceof zzki)) {
            return super.addAll(collection);
        }
        zzki zzkiVar = (zzki) collection;
        int i6 = zzkiVar.zzc;
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
            System.arraycopy(zzkiVar.zzb, 0, this.zzb, this.zzc, zzkiVar.zzc);
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
        zzi(i6);
        return Float.valueOf(this.zzb[i6]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i6) {
        zzM();
        zzi(i6);
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
        zzM();
        if (i7 >= i6) {
            float[] fArr = this.zzb;
            System.arraycopy(fArr, i7, fArr, i6, this.zzc - i7);
            this.zzc -= i7 - i6;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final float zze(int i6) {
        zzi(i6);
        return this.zzb[i6];
    }

    public final void zzg(float f6) {
        zzM();
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

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Float) obj).floatValue());
        return true;
    }
}
