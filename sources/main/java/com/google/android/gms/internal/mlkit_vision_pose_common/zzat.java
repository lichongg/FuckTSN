package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;
import kotlinx.coroutines.internal.a0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzat extends AbstractMap implements Serializable {
    private static final Object zzd = new Object();

    @CheckForNull
    transient int[] zza;

    @CheckForNull
    transient Object[] zzb;

    @CheckForNull
    transient Object[] zzc;

    @CheckForNull
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;

    @CheckForNull
    private transient Set zzh;

    @CheckForNull
    private transient Set zzi;

    @CheckForNull
    private transient Collection zzj;

    zzat() {
        zzp(3);
    }

    final void zzp(int i6) {
        this.zzf = zzcf.zzb(i6, 1, a0.f49221j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] zzA() {
        int[] iArr = this.zza;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] zzB() {
        Object[] objArr = this.zzb;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] zzC() {
        Object[] objArr = this.zzc;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    static /* synthetic */ Object zzi(zzat zzatVar) {
        Object obj = zzatVar.zze;
        Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzv() {
        return (1 << (this.zzf & 31)) - 1;
    }

    private final int zzx(int i6, int i7, int i8, int i9) {
        int i10 = i7 - 1;
        Object zzd2 = zzau.zzd(i7);
        if (i9 != 0) {
            zzau.zze(zzd2, i8 & i10, i9 + 1);
        }
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] zzA = zzA();
        for (int i11 = 0; i11 <= i6; i11++) {
            int zzc = zzau.zzc(obj, i11);
            while (zzc != 0) {
                int i12 = zzc - 1;
                int i13 = zzA[i12];
                int i14 = ((~i6) & i13) | i11;
                int i15 = i14 & i10;
                int zzc2 = zzau.zzc(zzd2, i15);
                zzau.zze(zzd2, i15, zzc);
                zzA[i12] = ((~i10) & i14) | (zzc2 & i10);
                zzc = i13 & i6;
            }
        }
        this.zze = zzd2;
        zzz(i10);
        return i10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zzi;
        if (set != null) {
            return set;
        }
        zzan zzanVar = new zzan(this);
        this.zzi = zzanVar;
        return zzanVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        zzaq zzaqVar = new zzaq(this);
        this.zzh = zzaqVar;
        return zzaqVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object put(Object obj, Object obj2) {
        int min;
        if (zzr()) {
            zzq.zze(zzr(), "Arrays already allocated");
            int i6 = this.zzf;
            int max = Math.max(i6 + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > highestOneBit && (highestOneBit = highestOneBit + highestOneBit) <= 0) {
                highestOneBit = 1073741824;
            }
            int max2 = Math.max(4, highestOneBit);
            this.zze = zzau.zzd(max2);
            zzz(max2 - 1);
            this.zza = new int[i6];
            this.zzb = new Object[i6];
            this.zzc = new Object[i6];
        }
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.put(obj, obj2);
        }
        int[] zzA = zzA();
        Object[] zzB = zzB();
        Object[] zzC = zzC();
        int i7 = this.zzg;
        int i8 = i7 + 1;
        int zzb = zzav.zzb(obj);
        int zzv = zzv();
        int i9 = zzb & zzv;
        Object obj3 = this.zze;
        Objects.requireNonNull(obj3);
        int zzc = zzau.zzc(obj3, i9);
        if (zzc != 0) {
            int i10 = ~zzv;
            int i11 = zzb & i10;
            int i12 = 0;
            while (true) {
                int i13 = zzc - 1;
                int i14 = zzA[i13];
                int i15 = i14 & i10;
                if (i15 == i11 && zzp.zza(obj, zzB[i13])) {
                    Object obj4 = zzC[i13];
                    zzC[i13] = obj2;
                    return obj4;
                }
                int i16 = i14 & zzv;
                i12++;
                if (i16 != 0) {
                    zzc = i16;
                } else {
                    if (i12 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzv() + 1, 1.0f);
                        int zze = zze();
                        while (zze >= 0) {
                            linkedHashMap.put(zzB()[zze], zzC()[zze]);
                            zze = zzf(zze);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzo();
                        return linkedHashMap.put(obj, obj2);
                    }
                    if (i8 > zzv) {
                        zzv = zzx(zzv, zzau.zza(zzv), zzb, i7);
                    } else {
                        zzA[i13] = (i8 & zzv) | i15;
                    }
                }
            }
        } else if (i8 > zzv) {
            zzv = zzx(zzv, zzau.zza(zzv), zzb, i7);
        } else {
            Object obj5 = this.zze;
            Objects.requireNonNull(obj5);
            zzau.zze(obj5, i9, i8);
        }
        int length = zzA().length;
        if (i8 > length && (min = Math.min(a0.f49221j, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.zza = Arrays.copyOf(zzA(), min);
            this.zzb = Arrays.copyOf(zzB(), min);
            this.zzc = Arrays.copyOf(zzC(), min);
        }
        zzA()[i7] = (~zzv) & zzb;
        zzB()[i7] = obj;
        zzC()[i7] = obj2;
        this.zzg = i8;
        zzo();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzas zzasVar = new zzas(this);
        this.zzj = zzasVar;
        return zzasVar;
    }

    final int zzf(int i6) {
        int i7 = i6 + 1;
        if (i7 < this.zzg) {
            return i7;
        }
        return -1;
    }

    @CheckForNull
    final Map zzl() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    final void zzo() {
        this.zzf += 32;
    }

    final void zzq(int i6, int i7) {
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] zzA = zzA();
        Object[] zzB = zzB();
        Object[] zzC = zzC();
        int size = size();
        int i8 = size - 1;
        if (i6 >= i8) {
            zzB[i6] = null;
            zzC[i6] = null;
            zzA[i6] = 0;
            return;
        }
        int i9 = i6 + 1;
        Object obj2 = zzB[i8];
        zzB[i6] = obj2;
        zzC[i6] = zzC[i8];
        zzB[i8] = null;
        zzC[i8] = null;
        zzA[i6] = zzA[i8];
        zzA[i8] = 0;
        int zzb = zzav.zzb(obj2) & i7;
        int zzc = zzau.zzc(obj, zzb);
        if (zzc == size) {
            zzau.zze(obj, zzb, i9);
            return;
        }
        while (true) {
            int i10 = zzc - 1;
            int i11 = zzA[i10];
            int i12 = i11 & i7;
            if (i12 == size) {
                zzA[i10] = (i11 & (~i7)) | (i7 & i9);
                return;
            }
            zzc = i12;
        }
    }

    final boolean zzr() {
        return this.zze == null;
    }

    zzat(int i6) {
        zzp(12);
    }

    static /* synthetic */ Object zzg(zzat zzatVar, int i6) {
        return zzatVar.zzB()[i6];
    }

    static /* synthetic */ Object zzj(zzat zzatVar, int i6) {
        return zzatVar.zzC()[i6];
    }

    static /* synthetic */ void zzn(zzat zzatVar, int i6, Object obj) {
        zzatVar.zzC()[i6] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzw(@CheckForNull Object obj) {
        if (zzr()) {
            return -1;
        }
        int zzb = zzav.zzb(obj);
        int zzv = zzv();
        Object obj2 = this.zze;
        Objects.requireNonNull(obj2);
        int zzc = zzau.zzc(obj2, zzb & zzv);
        if (zzc != 0) {
            int i6 = ~zzv;
            int i7 = zzb & i6;
            do {
                int i8 = zzc - 1;
                int i9 = zzA()[i8];
                if ((i9 & i6) == i7 && zzp.zza(obj, zzB()[i8])) {
                    return i8;
                }
                zzc = i9 & zzv;
            } while (zzc != 0);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzy(@CheckForNull Object obj) {
        if (!zzr()) {
            int zzv = zzv();
            Object obj2 = this.zze;
            Objects.requireNonNull(obj2);
            int zzb = zzau.zzb(obj, null, zzv, obj2, zzA(), zzB(), null);
            if (zzb != -1) {
                Object obj3 = zzC()[zzb];
                zzq(zzb, zzv);
                this.zzg--;
                zzo();
                return obj3;
            }
        }
        return zzd;
    }

    private final void zzz(int i6) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i6)) & 31) | (this.zzf & (-32));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzr()) {
            return;
        }
        zzo();
        Map zzl = zzl();
        if (zzl != null) {
            this.zzf = zzcf.zzb(size(), 3, a0.f49221j);
            zzl.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(zzB(), 0, this.zzg, (Object) null);
        Arrays.fill(zzC(), 0, this.zzg, (Object) null);
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(zzA(), 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.containsKey(obj);
        }
        if (zzw(obj) == -1) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl == null) {
            for (int i6 = 0; i6 < this.zzg; i6++) {
                if (zzp.zza(obj, zzC()[i6])) {
                    return true;
                }
            }
            return false;
        }
        return zzl.containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.get(obj);
        }
        int zzw = zzw(obj);
        if (zzw == -1) {
            return null;
        }
        return zzC()[zzw];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final Object remove(@CheckForNull Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.remove(obj);
        }
        Object zzy = zzy(obj);
        if (zzy == zzd) {
            return null;
        }
        return zzy;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.size();
        }
        return this.zzg;
    }

    final int zze() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }
}
