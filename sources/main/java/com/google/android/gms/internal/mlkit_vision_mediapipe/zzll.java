package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzll extends zziy implements RandomAccess, zzkx {
    private static final zzll zza = new zzll(new long[0], 0, false);
    private long[] zzb;
    private int zzc;

    zzll() {
        this(new long[10], 0, true);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i6, Object obj) {
        int i7;
        long longValue = ((Long) obj).longValue();
        zzM();
        if (i6 < 0 || i6 > (i7 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzg(i6));
        }
        int i8 = i6 + 1;
        long[] jArr = this.zzb;
        if (i7 < jArr.length) {
            System.arraycopy(jArr, i6, jArr, i8, i7 - i6);
        } else {
            long[] jArr2 = new long[((i7 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i6);
            System.arraycopy(this.zzb, i6, jArr2, i8, this.zzc - i6);
            this.zzb = jArr2;
        }
        this.zzb[i6] = longValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzll)) {
            return super.equals(obj);
        }
        zzll zzllVar = (zzll) obj;
        if (this.zzc != zzllVar.zzc) {
            return false;
        }
        long[] jArr = zzllVar.zzb;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            if (this.zzb[i6] != jArr[i6]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i6 = 1;
        for (int i7 = 0; i7 < this.zzc; i7++) {
            long j6 = this.zzb[i7];
            byte[] bArr = zzkz.zzb;
            i6 = (i6 * 31) + ((int) (j6 ^ (j6 >>> 32)));
        }
        return i6;
    }

    private zzll(long[] jArr, int i6, boolean z5) {
        super(z5);
        this.zzb = jArr;
        this.zzc = i6;
    }

    public static zzll zze() {
        return zza;
    }

    private final String zzg(int i6) {
        return "Index:" + i6 + ", Size:" + this.zzc;
    }

    private final void zzh(int i6) {
        if (i6 < 0 || i6 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzg(i6));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i6 = this.zzc;
        for (int i7 = 0; i7 < i6; i7++) {
            if (this.zzb[i7] == longValue) {
                return i7;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i6, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzM();
        zzh(i6);
        long[] jArr = this.zzb;
        long j6 = jArr[i6];
        jArr[i6] = longValue;
        return Long.valueOf(j6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzky
    public final /* bridge */ /* synthetic */ zzky zzd(int i6) {
        if (i6 >= this.zzc) {
            return new zzll(Arrays.copyOf(this.zzb, i6), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzM();
        byte[] bArr = zzkz.zzb;
        collection.getClass();
        if (!(collection instanceof zzll)) {
            return super.addAll(collection);
        }
        zzll zzllVar = (zzll) collection;
        int i6 = zzllVar.zzc;
        if (i6 == 0) {
            return false;
        }
        int i7 = this.zzc;
        if (Integer.MAX_VALUE - i7 >= i6) {
            int i8 = i7 + i6;
            long[] jArr = this.zzb;
            if (i8 > jArr.length) {
                this.zzb = Arrays.copyOf(jArr, i8);
            }
            System.arraycopy(zzllVar.zzb, 0, this.zzb, this.zzc, zzllVar.zzc);
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
        zzh(i6);
        return Long.valueOf(this.zzb[i6]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i6) {
        zzM();
        zzh(i6);
        long[] jArr = this.zzb;
        long j6 = jArr[i6];
        if (i6 < this.zzc - 1) {
            System.arraycopy(jArr, i6 + 1, jArr, i6, (r3 - i6) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j6);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i6, int i7) {
        zzM();
        if (i7 >= i6) {
            long[] jArr = this.zzb;
            System.arraycopy(jArr, i7, jArr, i6, this.zzc - i7);
            this.zzc -= i7 - i6;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkx
    public final long zza(int i6) {
        zzh(i6);
        return this.zzb[i6];
    }

    public final void zzf(long j6) {
        zzM();
        int i6 = this.zzc;
        long[] jArr = this.zzb;
        if (i6 == jArr.length) {
            long[] jArr2 = new long[((i6 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i6);
            this.zzb = jArr2;
        }
        long[] jArr3 = this.zzb;
        int i7 = this.zzc;
        this.zzc = i7 + 1;
        jArr3[i7] = j6;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziy, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Long) obj).longValue());
        return true;
    }
}
