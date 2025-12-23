package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzgt extends zzkn implements zzlx {
    private static final zzgt zzd;
    private byte zze = 2;

    static {
        zzgt zzgtVar = new zzgt();
        zzd = zzgtVar;
        zzkr.zzE(zzgt.class, zzgtVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return Byte.valueOf(this.zze);
        }
        zzgp zzgpVar = null;
        if (i7 == 2) {
            return zzkr.zzB(zzd, "\u0001\u0000", null);
        }
        if (i7 == 3) {
            return new zzgt();
        }
        if (i7 == 4) {
            return new zzgs(zzgpVar);
        }
        if (i7 == 5) {
            return zzd;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    private zzgt() {
    }
}
