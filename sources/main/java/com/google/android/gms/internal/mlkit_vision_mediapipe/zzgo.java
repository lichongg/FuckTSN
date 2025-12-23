package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzgo extends zzkn implements zzlx {
    private static final zzgo zzd;
    private byte zze = 2;

    static {
        zzgo zzgoVar = new zzgo();
        zzd = zzgoVar;
        zzkr.zzE(zzgo.class, zzgoVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return Byte.valueOf(this.zze);
        }
        zzgm zzgmVar = null;
        if (i7 == 2) {
            return zzkr.zzB(zzd, "\u0001\u0000", null);
        }
        if (i7 == 3) {
            return new zzgo();
        }
        if (i7 == 4) {
            return new zzgn(zzgmVar);
        }
        if (i7 == 5) {
            return zzd;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    private zzgo() {
    }
}
