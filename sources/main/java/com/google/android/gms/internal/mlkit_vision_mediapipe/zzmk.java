package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzmk {
    public static final /* synthetic */ int zza = 0;
    private static final zzmw zzb;

    static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static {
        int i6 = zzmf.zza;
        zzb = new zzmy();
    }

    public static void zzA(int i6, List list, zznj zznjVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznjVar.zzC(i6, list, z5);
    }

    public static void zzB(int i6, List list, zznj zznjVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznjVar.zzE(i6, list, z5);
    }

    public static void zzC(int i6, List list, zznj zznjVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznjVar.zzJ(i6, list, z5);
    }

    public static void zzD(int i6, List list, zznj zznjVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznjVar.zzL(i6, list, z5);
    }

    static int zzh(int i6, Object obj, zzmi zzmiVar) {
        int i7 = i6 << 3;
        if (!(obj instanceof zzlh)) {
            return zzjw.zzz(i7) + zzjw.zzx((zzlw) obj, zzmiVar);
        }
        int zzz = zzjw.zzz(i7);
        int zza2 = ((zzlh) obj).zza();
        return zzz + zzjw.zzz(zza2) + zza2;
    }

    public static zzmw zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i6, int i7, Object obj2, zzmw zzmwVar) {
        Object obj3 = obj2;
        if (obj2 == null) {
            zzkr zzkrVar = (zzkr) obj;
            zzmx zzmxVar = zzkrVar.zzc;
            obj3 = zzmxVar;
            if (zzmxVar == zzmx.zzc()) {
                zzmx zzf = zzmx.zzf();
                zzkrVar.zzc = zzf;
                obj3 = zzf;
            }
        }
        ((zzmx) obj3).zzj(i6 << 3, Long.valueOf(i7));
        return obj3;
    }

    static void zzo(zzkc zzkcVar, Object obj, Object obj2) {
        zzkg zzkgVar = ((zzkn) obj2).zzb;
        if (zzkgVar.zza.isEmpty()) {
            return;
        }
        ((zzkn) obj).zzc().zzi(zzkgVar);
    }

    static void zzp(zzmw zzmwVar, Object obj, Object obj2) {
        zzkr zzkrVar = (zzkr) obj;
        zzmx zzmxVar = zzkrVar.zzc;
        zzmx zzmxVar2 = ((zzkr) obj2).zzc;
        if (!zzmx.zzc().equals(zzmxVar2)) {
            if (zzmx.zzc().equals(zzmxVar)) {
                zzmxVar = zzmx.zze(zzmxVar, zzmxVar2);
            } else {
                zzmxVar.zzd(zzmxVar2);
            }
        }
        zzkrVar.zzc = zzmxVar;
    }

    public static void zzq(int i6, List list, zznj zznjVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznjVar.zzc(i6, list, z5);
    }

    public static void zzr(int i6, List list, zznj zznjVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznjVar.zzg(i6, list, z5);
    }

    public static void zzs(int i6, List list, zznj zznjVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznjVar.zzj(i6, list, z5);
    }

    public static void zzt(int i6, List list, zznj zznjVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznjVar.zzl(i6, list, z5);
    }

    public static void zzu(int i6, List list, zznj zznjVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznjVar.zzn(i6, list, z5);
    }

    public static void zzv(int i6, List list, zznj zznjVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznjVar.zzp(i6, list, z5);
    }

    public static void zzw(int i6, List list, zznj zznjVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznjVar.zzs(i6, list, z5);
    }

    public static void zzx(int i6, List list, zznj zznjVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznjVar.zzu(i6, list, z5);
    }

    public static void zzy(int i6, List list, zznj zznjVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznjVar.zzy(i6, list, z5);
    }

    public static void zzz(int i6, List list, zznj zznjVar, boolean z5) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznjVar.zzA(i6, list, z5);
    }

    static int zza(List list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzks) {
            zzks zzksVar = (zzks) list;
            int i7 = 0;
            while (i6 < size) {
                i7 += zzjw.zzA(zzksVar.zze(i6));
                i6++;
            }
            return i7;
        }
        int i8 = 0;
        while (i6 < size) {
            i8 += zzjw.zzA(((Integer) list.get(i6)).intValue());
            i6++;
        }
        return i8;
    }

    static int zzb(int i6, List list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjw.zzz(i6 << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i6, List list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjw.zzz(i6 << 3) + 8);
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
        if (list instanceof zzks) {
            zzks zzksVar = (zzks) list;
            int i7 = 0;
            while (i6 < size) {
                i7 += zzjw.zzA(zzksVar.zze(i6));
                i6++;
            }
            return i7;
        }
        int i8 = 0;
        while (i6 < size) {
            i8 += zzjw.zzA(((Integer) list.get(i6)).intValue());
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
        if (list instanceof zzll) {
            zzll zzllVar = (zzll) list;
            int i7 = 0;
            while (i6 < size) {
                i7 += zzjw.zzA(zzllVar.zza(i6));
                i6++;
            }
            return i7;
        }
        int i8 = 0;
        while (i6 < size) {
            i8 += zzjw.zzA(((Long) list.get(i6)).longValue());
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
        if (list instanceof zzks) {
            zzks zzksVar = (zzks) list;
            int i7 = 0;
            while (i6 < size) {
                int zze = zzksVar.zze(i6);
                i7 += zzjw.zzz((zze >> 31) ^ (zze + zze));
                i6++;
            }
            return i7;
        }
        int i8 = 0;
        while (i6 < size) {
            int intValue = ((Integer) list.get(i6)).intValue();
            i8 += zzjw.zzz((intValue >> 31) ^ (intValue + intValue));
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
        if (list instanceof zzll) {
            zzll zzllVar = (zzll) list;
            int i7 = 0;
            while (i6 < size) {
                long zza2 = zzllVar.zza(i6);
                i7 += zzjw.zzA((zza2 >> 63) ^ (zza2 + zza2));
                i6++;
            }
            return i7;
        }
        int i8 = 0;
        while (i6 < size) {
            long longValue = ((Long) list.get(i6)).longValue();
            i8 += zzjw.zzA((longValue >> 63) ^ (longValue + longValue));
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
        if (list instanceof zzks) {
            zzks zzksVar = (zzks) list;
            int i7 = 0;
            while (i6 < size) {
                i7 += zzjw.zzz(zzksVar.zze(i6));
                i6++;
            }
            return i7;
        }
        int i8 = 0;
        while (i6 < size) {
            i8 += zzjw.zzz(((Integer) list.get(i6)).intValue());
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
        if (list instanceof zzll) {
            zzll zzllVar = (zzll) list;
            int i7 = 0;
            while (i6 < size) {
                i7 += zzjw.zzA(zzllVar.zza(i6));
                i6++;
            }
            return i7;
        }
        int i8 = 0;
        while (i6 < size) {
            i8 += zzjw.zzA(((Long) list.get(i6)).longValue());
            i6++;
        }
        return i8;
    }
}
