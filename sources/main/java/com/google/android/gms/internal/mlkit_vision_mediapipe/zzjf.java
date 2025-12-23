package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzjf extends zziy implements RandomAccess, zzky {
    private boolean[] zza;
    private int zzb;

    zzjf() {
        this(new boolean[10], 0, true);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i6, Object obj) {
        int i7;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzM();
        if (i6 < 0 || i6 > (i7 = this.zzb)) {
            throw new IndexOutOfBoundsException(zzg(i6));
        }
        int i8 = i6 + 1;
        boolean[] zArr = this.zza;
        if (i7 < zArr.length) {
            System.arraycopy(zArr, i6, zArr, i8, i7 - i6);
        } else {
            boolean[] zArr2 = new boolean[((i7 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i6);
            System.arraycopy(this.zza, i6, zArr2, i8, this.zzb - i6);
            this.zza = zArr2;
        }
        this.zza[i6] = booleanValue;
        this.zzb++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjf)) {
            return super.equals(obj);
        }
        zzjf zzjfVar = (zzjf) obj;
        if (this.zzb != zzjfVar.zzb) {
            return false;
        }
        boolean[] zArr = zzjfVar.zza;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            if (this.zza[i6] != zArr[i6]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i6 = 1;
        for (int i7 = 0; i7 < this.zzb; i7++) {
            i6 = (i6 * 31) + zzkz.zza(this.zza[i7]);
        }
        return i6;
    }

    static {
        new zzjf(new boolean[0], 0, false);
    }

    private zzjf(boolean[] zArr, int i6, boolean z5) {
        super(z5);
        this.zza = zArr;
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
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            if (this.zza[i7] == booleanValue) {
                return i7;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i6, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzM();
        zzh(i6);
        boolean[] zArr = this.zza;
        boolean z5 = zArr[i6];
        zArr[i6] = booleanValue;
        return Boolean.valueOf(z5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzky
    public final /* bridge */ /* synthetic */ zzky zzd(int i6) {
        if (i6 >= this.zzb) {
            return new zzjf(Arrays.copyOf(this.zza, i6), this.zzb, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzM();
        byte[] bArr = zzkz.zzb;
        collection.getClass();
        if (!(collection instanceof zzjf)) {
            return super.addAll(collection);
        }
        zzjf zzjfVar = (zzjf) collection;
        int i6 = zzjfVar.zzb;
        if (i6 == 0) {
            return false;
        }
        int i7 = this.zzb;
        if (Integer.MAX_VALUE - i7 >= i6) {
            int i8 = i7 + i6;
            boolean[] zArr = this.zza;
            if (i8 > zArr.length) {
                this.zza = Arrays.copyOf(zArr, i8);
            }
            System.arraycopy(zzjfVar.zza, 0, this.zza, this.zzb, zzjfVar.zzb);
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
        return Boolean.valueOf(this.zza[i6]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i6) {
        zzM();
        zzh(i6);
        boolean[] zArr = this.zza;
        boolean z5 = zArr[i6];
        if (i6 < this.zzb - 1) {
            System.arraycopy(zArr, i6 + 1, zArr, i6, (r2 - i6) - 1);
        }
        this.zzb--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z5);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i6, int i7) {
        zzM();
        if (i7 >= i6) {
            boolean[] zArr = this.zza;
            System.arraycopy(zArr, i7, zArr, i6, this.zzb - i7);
            this.zzb -= i7 - i6;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final void zze(boolean z5) {
        zzM();
        int i6 = this.zzb;
        boolean[] zArr = this.zza;
        if (i6 == zArr.length) {
            boolean[] zArr2 = new boolean[((i6 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i6);
            this.zza = zArr2;
        }
        boolean[] zArr3 = this.zza;
        int i7 = this.zzb;
        this.zzb = i7 + 1;
        zArr3[i7] = z5;
    }

    public final boolean zzf(int i6) {
        zzh(i6);
        return this.zza[i6];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }
}
