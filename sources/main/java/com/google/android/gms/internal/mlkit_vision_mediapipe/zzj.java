package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.logging.Level;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzj extends zzv implements zzaf {
    protected zzj(Level level, boolean z5) {
        super(level, false);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzv
    protected final zzdu zza() {
        return zzds.zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzv
    protected final boolean zzb(@NullableDecl zzaa zzaaVar) {
        zzbh zzh = zzh();
        int zza = zzh.zza();
        int i6 = 0;
        while (true) {
            if (i6 >= zza) {
                break;
            }
            if (zzh.zzb(i6).zzf() == "eye3tag") {
                if (zzh.zzc(zzt.zza) == null) {
                    zzai zzaiVar = zzt.zzi;
                    if (zzh.zzc(zzaiVar) == null) {
                        zzl(zzaiVar, zzat.SMALL);
                    }
                }
            } else {
                i6++;
            }
        }
        return super.zzb(zzaaVar);
    }
}
