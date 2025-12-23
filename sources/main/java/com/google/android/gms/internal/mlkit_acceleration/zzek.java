package com.google.android.gms.internal.mlkit_acceleration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzek extends zzeo {
    private static final Class zza = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    /* synthetic */ zzek(zzej zzejVar) {
        super(null);
    }

    private zzek() {
        super(null);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzeo
    final List zza(Object obj, long j6) {
        return zzf(obj, j6, 10);
    }

    private static List zzf(Object obj, long j6, int i6) {
        List arrayList;
        List list = (List) zzgn.zzf(obj, j6);
        if (list.isEmpty()) {
            if (list instanceof zzei) {
                arrayList = new zzeh(i6);
            } else if ((list instanceof zzfh) && (list instanceof zzea)) {
                arrayList = ((zzea) list).zzd(i6);
            } else {
                arrayList = new ArrayList(i6);
            }
            zzgn.zzs(obj, j6, arrayList);
            return arrayList;
        }
        if (zza.isAssignableFrom(list.getClass())) {
            ArrayList arrayList2 = new ArrayList(list.size() + i6);
            arrayList2.addAll(list);
            zzgn.zzs(obj, j6, arrayList2);
            return arrayList2;
        }
        if (list instanceof zzgi) {
            zzeh zzehVar = new zzeh(list.size() + i6);
            zzehVar.addAll(zzehVar.size(), (zzgi) list);
            zzgn.zzs(obj, j6, zzehVar);
            return zzehVar;
        }
        if ((list instanceof zzfh) && (list instanceof zzea)) {
            zzea zzeaVar = (zzea) list;
            if (!zzeaVar.zzc()) {
                zzea zzd = zzeaVar.zzd(list.size() + i6);
                zzgn.zzs(obj, j6, zzd);
                return zzd;
            }
        }
        return list;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzeo
    final void zzb(Object obj, long j6) {
        Object unmodifiableList;
        List list = (List) zzgn.zzf(obj, j6);
        if (list instanceof zzei) {
            unmodifiableList = ((zzei) list).zze();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if ((list instanceof zzfh) && (list instanceof zzea)) {
                zzea zzeaVar = (zzea) list;
                if (zzeaVar.zzc()) {
                    zzeaVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        } else {
            return;
        }
        zzgn.zzs(obj, j6, unmodifiableList);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzeo
    final void zzc(Object obj, Object obj2, long j6) {
        List list = (List) zzgn.zzf(obj2, j6);
        List zzf = zzf(obj, j6, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzgn.zzs(obj, j6, list);
    }
}
