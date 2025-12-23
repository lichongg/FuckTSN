package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.logging.Level;
import javax.annotation.Nonnull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzo extends zzd {
    private static final zzn zza = new zzn(null);

    @Nonnull
    @Deprecated
    public static zzo zzh(String str) {
        return new zzo(zzch.zzd("com/google/mediapipe/framework/Graph".replace('/', '.')));
    }

    zzo(zzbd zzbdVar) {
        super(zzbdVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzd
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzk zza(Level level) {
        boolean zzf = zzf(level);
        zzch.zzn(zzd(), level, zzf);
        if (!zzf) {
            return zza;
        }
        return new zzl(this, level, false);
    }
}
