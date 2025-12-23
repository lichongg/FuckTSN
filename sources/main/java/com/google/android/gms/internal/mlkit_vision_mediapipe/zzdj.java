package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzdj extends AbstractMap {
    private static final Comparator zza = new zzdg();
    private final Object[] zzb;
    private final int[] zzc;
    private final Set zzd;
    private Integer zze;
    private String zzf;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_mediapipe.zzdj, java.util.AbstractMap] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    zzdj(zzdj zzdjVar, zzdj zzdjVar2) {
        int i6;
        Object obj;
        Comparator comparator;
        Object[] objArr;
        zzdj abstractMap = new AbstractMap();
        abstractMap.zzd = new zzdi(abstractMap, -1);
        abstractMap.zze = null;
        abstractMap.zzf = null;
        int size = zzdjVar.size() + zzdjVar2.size();
        int i7 = zzdjVar.zzc[zzdjVar.size()] + zzdjVar2.zzc[zzdjVar2.size()];
        int i8 = size + 1;
        Object[] objArr2 = new Object[i7];
        int[] iArr = new int[i8];
        int i9 = 0;
        iArr[0] = size;
        Map.Entry zze = zzdjVar.zze(0);
        Map.Entry zze2 = zzdjVar2.zze(0);
        int i10 = 0;
        int i11 = 0;
        int i12 = size;
        Map.Entry entry = zze;
        int i13 = 0;
        while (true) {
            if (entry == null && zze2 == null) {
                break;
            }
            int i14 = i13 + 1;
            int i15 = entry == null ? 1 : zze2 == null ? -1 : 0;
            if (i15 == 0 && (i15 = ((String) entry.getKey()).compareTo((String) zze2.getKey())) == 0) {
                int i16 = i11 + 1;
                int i17 = i10 + 1;
                objArr2[i13] = abstractMap.zzf((String) entry.getKey(), i13);
                zzdi zzdiVar = (zzdi) entry.getValue();
                zzdi zzdiVar2 = (zzdi) zze2.getValue();
                int i18 = 0;
                int i19 = 0;
                abstractMap = abstractMap;
                while (true) {
                    if (i18 >= zzdiVar.zza() - zzdiVar.zzb() && i19 >= zzdiVar2.zza() - zzdiVar2.zzb()) {
                        break;
                    }
                    int i20 = i18 == zzdiVar.zza() - zzdiVar.zzb() ? 1 : i19 == zzdiVar2.zza() - zzdiVar2.zzb() ? -1 : 0;
                    if (i20 == 0) {
                        comparator = zzdl.zza;
                        i20 = comparator.compare(zzdiVar.zzc(i18), zzdiVar2.zzc(i19));
                    }
                    if (i20 < 0) {
                        i6 = i18 + 1;
                        obj = zzdiVar.zzc(i18);
                    } else {
                        int i21 = i19 + 1;
                        Object zzc = zzdiVar2.zzc(i19);
                        i19 = i21;
                        i6 = i20 == 0 ? i18 + 1 : i18;
                        obj = zzc;
                    }
                    objArr2[i12] = obj;
                    i18 = i6;
                    i12++;
                    abstractMap = this;
                }
                iArr[i14] = i12;
                entry = zzdjVar.zze(i17);
                zze2 = zzdjVar2.zze(i16);
                i11 = i16;
                i10 = i17;
                i13 = i14;
                i9 = 0;
            } else {
                if (i15 < 0) {
                    i10++;
                    i12 = zzd(entry, i13, i12, objArr2, iArr);
                    entry = zzdjVar.zze(i10);
                } else {
                    Map.Entry entry2 = entry;
                    i11++;
                    int zzd = zzd(zze2, i13, i12, objArr2, iArr);
                    zze2 = zzdjVar2.zze(i11);
                    i12 = zzd;
                    entry = entry2;
                }
                i13 = i14;
                i9 = 0;
                abstractMap = this;
            }
        }
        int i22 = iArr[i9];
        int i23 = i22 - i13;
        if (i23 != 0) {
            for (int i24 = 0; i24 <= i13; i24++) {
                iArr[i24] = iArr[i24] - i23;
            }
            int i25 = iArr[i13];
            int i26 = i25 - i13;
            if (zzg(i7, i25)) {
                objArr = new Object[i25];
                System.arraycopy(objArr2, i9, objArr, i9, i13);
            } else {
                objArr = objArr2;
            }
            System.arraycopy(objArr2, i22, objArr, i13, i26);
            objArr2 = objArr;
        }
        abstractMap.zzb = objArr2;
        int i27 = iArr[i9] + 1;
        abstractMap.zzc = zzg(i8, i27) ? Arrays.copyOf(iArr, i27) : iArr;
    }

    private final Map.Entry zze(int i6) {
        if (i6 < this.zzc[0]) {
            return (Map.Entry) this.zzb[i6];
        }
        return null;
    }

    private final Map.Entry zzf(String str, int i6) {
        return new AbstractMap.SimpleImmutableEntry(str, new zzdi(this, i6));
    }

    private static boolean zzg(int i6, int i7) {
        return i6 > 16 && i6 * 9 > i7 * 10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return this.zzd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        if (this.zze == null) {
            this.zze = Integer.valueOf(super.hashCode());
        }
        return this.zze.intValue();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        if (this.zzf == null) {
            this.zzf = super.toString();
        }
        return this.zzf;
    }

    private final int zzd(Map.Entry entry, int i6, int i7, Object[] objArr, int[] iArr) {
        zzdi zzdiVar = (zzdi) entry.getValue();
        int zza2 = zzdiVar.zza() - zzdiVar.zzb();
        System.arraycopy(zzdiVar.zzb.zzb, zzdiVar.zzb(), objArr, i7, zza2);
        objArr[i6] = zzf((String) entry.getKey(), i6);
        int i8 = i7 + zza2;
        iArr[i6 + 1] = i8;
        return i8;
    }

    zzdj(List list) {
        this.zzd = new zzdi(this, -1);
        this.zze = null;
        this.zzf = null;
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            int size = list.size();
            Object[] objArr = new Object[size];
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                int[] iArr = {0};
                this.zzb = zzg(size, 0) ? Arrays.copyOf(objArr, 0) : objArr;
                this.zzc = iArr;
                return;
            }
            zzdf.zza((zzdf) it2.next());
            throw null;
        }
        zzdf.zza((zzdf) it.next());
        throw null;
    }
}
