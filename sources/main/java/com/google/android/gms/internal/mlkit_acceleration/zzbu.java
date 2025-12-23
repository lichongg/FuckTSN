package com.google.android.gms.internal.mlkit_acceleration;

import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzbu {
    static void zza(Map map, zzhv zzhvVar) {
        for (int i6 = 0; i6 < zzhvVar.zzf(); i6++) {
            zzb(zzhvVar.zzh(i6), map);
        }
    }

    private static void zzb(zzhx zzhxVar, Map map) {
        if (map.containsKey(zzhxVar.zzh())) {
            String str = (String) map.get(zzhxVar.zzh());
            ArrayList<zzhw> arrayList = new ArrayList();
            if (zzhxVar.zzf() == 0) {
                zzhw zzj = zzhxVar.zzj(str);
                if (zzj != null) {
                    arrayList.add(zzj);
                }
            } else {
                for (int i6 = 0; i6 < zzhxVar.zzg(); i6++) {
                    zzhw zzi = zzhxVar.zzi(i6);
                    if (zzhxVar.zzf() == 1) {
                        if (str.compareTo(zzi.zzh()) < 0) {
                        }
                        arrayList.add(zzi);
                    } else {
                        if (str.compareTo(zzi.zzh()) > 0) {
                        }
                        arrayList.add(zzi);
                    }
                }
            }
            for (zzhw zzhwVar : arrayList) {
                for (int i7 = 0; i7 < zzhwVar.zzg(); i7++) {
                    zzhu zzi2 = zzhwVar.zzi(i7);
                    map.put(zzi2.zzg(), zzi2.zzf());
                }
                for (int i8 = 0; i8 < zzhwVar.zzf(); i8++) {
                    zzb(zzhwVar.zzj(i8), map);
                }
            }
        }
    }
}
