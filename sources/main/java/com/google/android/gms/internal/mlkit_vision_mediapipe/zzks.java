package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzks extends zziy implements RandomAccess, zzkw {
    private static final zzks zza = new zzks(new int[0], 0, false);
    private int[] zzb;
    private int zzc;

    zzks() {
        this(new int[10], 0, true);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i6, Object obj) {
        int i7;
        int intValue = ((Integer) obj).intValue();
        zzM();
        if (i6 < 0 || i6 > (i7 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzh(i6));
        }
        int i8 = i6 + 1;
        int[] iArr = this.zzb;
        if (i7 < iArr.length) {
            System.arraycopy(iArr, i6, iArr, i8, i7 - i6);
        } else {
            int[] iArr2 = new int[((i7 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            System.arraycopy(this.zzb, i6, iArr2, i8, this.zzc - i6);
            this.zzb = iArr2;
        }
        this.zzb[i6] = intValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzks)) {
            return super.equals(obj);
        }
        zzks zzksVar = (zzks) obj;
        if (this.zzc != zzksVar.zzc) {
            return false;
        }
        int[] iArr = zzksVar.zzb;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            if (this.zzb[i6] != iArr[i6]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i6 = 1;
        for (int i7 = 0; i7 < this.zzc; i7++) {
            i6 = (i6 * 31) + this.zzb[i7];
        }
        return i6;
    }

    private zzks(int[] iArr, int i6, boolean z5) {
        super(z5);
        this.zzb = iArr;
        this.zzc = i6;
    }

    public static zzks zzf() {
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
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i6 = this.zzc;
        for (int i7 = 0; i7 < i6; i7++) {
            if (this.zzb[i7] == intValue) {
                return i7;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i6, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzM();
        zzi(i6);
        int[] iArr = this.zzb;
        int i7 = iArr[i6];
        iArr[i6] = intValue;
        return Integer.valueOf(i7);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzky
    public final /* bridge */ /* synthetic */ zzky zzd(int i6) {
        if (i6 >= this.zzc) {
            return new zzks(Arrays.copyOf(this.zzb, i6), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzM();
        byte[] bArr = zzkz.zzb;
        collection.getClass();
        if (!(collection instanceof zzks)) {
            return super.addAll(collection);
        }
        zzks zzksVar = (zzks) collection;
        int i6 = zzksVar.zzc;
        if (i6 == 0) {
            return false;
        }
        int i7 = this.zzc;
        if (Integer.MAX_VALUE - i7 >= i6) {
            int i8 = i7 + i6;
            int[] iArr = this.zzb;
            if (i8 > iArr.length) {
                this.zzb = Arrays.copyOf(iArr, i8);
            }
            System.arraycopy(zzksVar.zzb, 0, this.zzb, this.zzc, zzksVar.zzc);
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
        return Integer.valueOf(this.zzb[i6]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i6) {
        zzM();
        zzi(i6);
        int[] iArr = this.zzb;
        int i7 = iArr[i6];
        if (i6 < this.zzc - 1) {
            System.arraycopy(iArr, i6 + 1, iArr, i6, (r2 - i6) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i7);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i6, int i7) {
        zzM();
        if (i7 >= i6) {
            int[] iArr = this.zzb;
            System.arraycopy(iArr, i7, iArr, i6, this.zzc - i7);
            this.zzc -= i7 - i6;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkw
    public final int zze(int i6) {
        zzi(i6);
        return this.zzb[i6];
    }

    public final void zzg(int i6) {
        zzM();
        int i7 = this.zzc;
        int[] iArr = this.zzb;
        if (i7 == iArr.length) {
            int[] iArr2 = new int[((i7 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i7);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i8 = this.zzc;
        this.zzc = i8 + 1;
        iArr3[i8] = i6;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Integer) obj).intValue());
        return true;
    }
}
