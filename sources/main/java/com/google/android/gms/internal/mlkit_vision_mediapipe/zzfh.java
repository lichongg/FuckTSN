package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzfh extends zzkr implements zzlx {
    private static final zzfh zzb;
    private byte zze = 2;
    private zzky zzd = zzkr.zzz();

    static {
        zzfh zzfhVar = new zzfh();
        zzb = zzfhVar;
        zzkr.zzE(zzfh.class, zzfhVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return Byte.valueOf(this.zze);
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzd", zzfg.class});
        }
        if (i7 == 3) {
            return new zzfh();
        }
        zzfd zzfdVar = null;
        if (i7 == 4) {
            return new zzfe(zzfdVar);
        }
        if (i7 == 5) {
            return zzb;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    private zzfh() {
    }
}
