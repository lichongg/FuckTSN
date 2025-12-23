package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzdr extends zzde {
    private static final zzcv zzd(zzdu zzduVar, int i6) throws IOException {
        int i7 = i6 - 1;
        if (i7 == 5) {
            return new zzdb(zzduVar.zze());
        }
        if (i7 == 6) {
            return new zzdb(new zzdg(zzduVar.zze()));
        }
        if (i7 == 7) {
            return new zzdb(Boolean.valueOf(zzduVar.zzm()));
        }
        if (i7 != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(zzdv.zza(i6)));
        }
        zzduVar.zzj();
        return zzcx.zza;
    }

    private static final zzcv zze(zzdu zzduVar, int i6) throws IOException {
        int i7 = i6 - 1;
        if (i7 == 0) {
            zzduVar.zzf();
            return new zzcu();
        }
        if (i7 != 2) {
            return null;
        }
        zzduVar.zzg();
        return new zzcy();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzde
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final void zzb(zzdw zzdwVar, zzcv zzcvVar) throws IOException {
        if (zzcvVar == null || (zzcvVar instanceof zzcx)) {
            zzdwVar.zzf();
            return;
        }
        if (zzcvVar instanceof zzdb) {
            zzdb zzdbVar = (zzdb) zzcvVar;
            if (zzdbVar.zzj()) {
                zzdwVar.zzg(zzdbVar.zzd());
                return;
            } else if (zzdbVar.zzi()) {
                zzdwVar.zzi(zzdbVar.zzh());
                return;
            } else {
                zzdwVar.zzh(zzdbVar.zze());
                return;
            }
        }
        if (zzcvVar instanceof zzcu) {
            zzdwVar.zza();
            Iterator it = ((zzcu) zzcvVar).iterator();
            while (it.hasNext()) {
                zzb(zzdwVar, (zzcv) it.next());
            }
            zzdwVar.zzc();
            return;
        }
        if (!(zzcvVar instanceof zzcy)) {
            throw new IllegalArgumentException("Couldn't write ".concat(String.valueOf(zzcvVar.getClass())));
        }
        zzdwVar.zzb();
        for (Map.Entry entry : zzcvVar.zzb().zzd()) {
            zzdwVar.zze((String) entry.getKey());
            zzb(zzdwVar, (zzcv) entry.getValue());
        }
        zzdwVar.zzd();
    }

    zzdr() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzde
    public final /* bridge */ /* synthetic */ Object zza(zzdu zzduVar) throws IOException {
        String str;
        zzcv zzcvVar;
        int zzn = zzduVar.zzn();
        zzcv zze = zze(zzduVar, zzn);
        if (zze == null) {
            return zzd(zzduVar, zzn);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (zzduVar.zzl()) {
                if (zze instanceof zzcy) {
                    str = zzduVar.zzd();
                } else {
                    str = null;
                }
                int zzn2 = zzduVar.zzn();
                zzcv zze2 = zze(zzduVar, zzn2);
                if (zze2 == null) {
                    zzcvVar = zzd(zzduVar, zzn2);
                } else {
                    zzcvVar = zze2;
                }
                if (zze instanceof zzcu) {
                    ((zzcu) zze).zza(zzcvVar);
                } else {
                    ((zzcy) zze).zze(str, zzcvVar);
                }
                if (zze2 != null) {
                    arrayDeque.addLast(zze);
                    zze = zzcvVar;
                }
            } else {
                if (zze instanceof zzcu) {
                    zzduVar.zzh();
                } else {
                    zzduVar.zzi();
                }
                if (!arrayDeque.isEmpty()) {
                    zze = (zzcv) arrayDeque.removeLast();
                } else {
                    return zze;
                }
            }
        }
    }
}
