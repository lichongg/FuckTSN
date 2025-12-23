package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzfo {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzgd zzc;
    private static final zzgd zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzgd zzgdVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzgdVar = (zzgd) cls2.getConstructor(null).newInstance(null);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzgdVar;
        zzd = new zzgf();
    }

    static boolean zzG(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzA(int i6, List list, zzgv zzgvVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgvVar.zzx(i6, list, z5);
    }

    public static void zzB(int i6, List list, zzgv zzgvVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgvVar.zzz(i6, list, z5);
    }

    public static void zzC(int i6, List list, zzgv zzgvVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgvVar.zzB(i6, list, z5);
    }

    public static void zzD(int i6, List list, zzgv zzgvVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgvVar.zzD(i6, list, z5);
    }

    public static void zzE(int i6, List list, zzgv zzgvVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgvVar.zzI(i6, list, z5);
    }

    public static void zzF(int i6, List list, zzgv zzgvVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgvVar.zzK(i6, list, z5);
    }

    static int zzh(int i6, Object obj, zzfm zzfmVar) {
        int i7 = i6 << 3;
        if (!(obj instanceof zzeg)) {
            return zzdd.zzw(i7) + zzdd.zzu((zzfa) obj, zzfmVar);
        }
        int zzw = zzdd.zzw(i7);
        int zza2 = ((zzeg) obj).zza();
        return zzw + zzdd.zzw(zza2) + zza2;
    }

    public static zzgd zzm() {
        return zzc;
    }

    public static zzgd zzn() {
        return zzd;
    }

    static Object zzo(Object obj, int i6, List list, zzdz zzdzVar, Object obj2, zzgd zzgdVar) {
        if (zzdzVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                if (!zzdzVar.zza(intValue)) {
                    obj2 = zzp(obj, i6, intValue, obj2, zzgdVar);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            Integer num = (Integer) list.get(i8);
            int intValue2 = num.intValue();
            if (zzdzVar.zza(intValue2)) {
                if (i8 != i7) {
                    list.set(i7, num);
                }
                i7++;
            } else {
                obj2 = zzp(obj, i6, intValue2, obj2, zzgdVar);
            }
        }
        if (i7 != size) {
            list.subList(i7, size).clear();
        }
        return obj2;
    }

    static Object zzp(Object obj, int i6, int i7, Object obj2, zzgd zzgdVar) {
        if (obj2 == null) {
            obj2 = zzgdVar.zzc(obj);
        }
        zzgdVar.zzl(obj2, i6, i7);
        return obj2;
    }

    public static void zzr(Class cls) {
        Class cls2;
        if (!zzdv.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzs(int i6, List list, zzgv zzgvVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgvVar.zzc(i6, list, z5);
    }

    public static void zzt(int i6, List list, zzgv zzgvVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgvVar.zzg(i6, list, z5);
    }

    public static void zzu(int i6, List list, zzgv zzgvVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgvVar.zzj(i6, list, z5);
    }

    public static void zzv(int i6, List list, zzgv zzgvVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgvVar.zzl(i6, list, z5);
    }

    public static void zzw(int i6, List list, zzgv zzgvVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgvVar.zzn(i6, list, z5);
    }

    public static void zzx(int i6, List list, zzgv zzgvVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgvVar.zzp(i6, list, z5);
    }

    public static void zzy(int i6, List list, zzgv zzgvVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgvVar.zzs(i6, list, z5);
    }

    public static void zzz(int i6, List list, zzgv zzgvVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzgvVar.zzu(i6, list, z5);
    }

    static int zza(List list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdw) {
            zzdw zzdwVar = (zzdw) list;
            int i7 = 0;
            while (i6 < size) {
                i7 += zzdd.zzx(zzdwVar.zze(i6));
                i6++;
            }
            return i7;
        }
        int i8 = 0;
        while (i6 < size) {
            i8 += zzdd.zzx(((Integer) list.get(i6)).intValue());
            i6++;
        }
        return i8;
    }

    static int zzb(int i6, List list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdd.zzw(i6 << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i6, List list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdd.zzw(i6 << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdw) {
            zzdw zzdwVar = (zzdw) list;
            int i7 = 0;
            while (i6 < size) {
                i7 += zzdd.zzx(zzdwVar.zze(i6));
                i6++;
            }
            return i7;
        }
        int i8 = 0;
        while (i6 < size) {
            i8 += zzdd.zzx(((Integer) list.get(i6)).intValue());
            i6++;
        }
        return i8;
    }

    static int zzg(List list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzep) {
            zzep zzepVar = (zzep) list;
            int i7 = 0;
            while (i6 < size) {
                i7 += zzdd.zzx(zzepVar.zze(i6));
                i6++;
            }
            return i7;
        }
        int i8 = 0;
        while (i6 < size) {
            i8 += zzdd.zzx(((Long) list.get(i6)).longValue());
            i6++;
        }
        return i8;
    }

    static int zzi(List list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdw) {
            zzdw zzdwVar = (zzdw) list;
            int i7 = 0;
            while (i6 < size) {
                int zze = zzdwVar.zze(i6);
                i7 += zzdd.zzw((zze >> 31) ^ (zze + zze));
                i6++;
            }
            return i7;
        }
        int i8 = 0;
        while (i6 < size) {
            int intValue = ((Integer) list.get(i6)).intValue();
            i8 += zzdd.zzw((intValue >> 31) ^ (intValue + intValue));
            i6++;
        }
        return i8;
    }

    static int zzj(List list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzep) {
            zzep zzepVar = (zzep) list;
            int i7 = 0;
            while (i6 < size) {
                long zze = zzepVar.zze(i6);
                i7 += zzdd.zzx((zze >> 63) ^ (zze + zze));
                i6++;
            }
            return i7;
        }
        int i8 = 0;
        while (i6 < size) {
            long longValue = ((Long) list.get(i6)).longValue();
            i8 += zzdd.zzx((longValue >> 63) ^ (longValue + longValue));
            i6++;
        }
        return i8;
    }

    static int zzk(List list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdw) {
            zzdw zzdwVar = (zzdw) list;
            int i7 = 0;
            while (i6 < size) {
                i7 += zzdd.zzw(zzdwVar.zze(i6));
                i6++;
            }
            return i7;
        }
        int i8 = 0;
        while (i6 < size) {
            i8 += zzdd.zzw(((Integer) list.get(i6)).intValue());
            i6++;
        }
        return i8;
    }

    static int zzl(List list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzep) {
            zzep zzepVar = (zzep) list;
            int i7 = 0;
            while (i6 < size) {
                i7 += zzdd.zzx(zzepVar.zze(i6));
                i6++;
            }
            return i7;
        }
        int i8 = 0;
        while (i6 < size) {
            i8 += zzdd.zzx(((Long) list.get(i6)).longValue());
            i6++;
        }
        return i8;
    }

    static void zzq(zzgd zzgdVar, Object obj, Object obj2) {
        zzgdVar.zzo(obj, zzgdVar.zze(zzgdVar.zzd(obj), zzgdVar.zzd(obj2)));
    }
}
