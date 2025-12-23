package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzft extends zzkn implements zzlx {
    private static final zzft zzd;
    private int zze;
    private boolean zzf;
    private byte zzg = 2;

    static {
        zzft zzftVar = new zzft();
        zzd = zzftVar;
        zzkr.zzE(zzft.class, zzftVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i7 == 2) {
            return zzkr.zzB(zzd, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"zze", "zzf"});
        }
        if (i7 == 3) {
            return new zzft();
        }
        zzfr zzfrVar = null;
        if (i7 == 4) {
            return new zzfs(zzfrVar);
        }
        if (i7 == 5) {
            return zzd;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    private zzft() {
    }
}
