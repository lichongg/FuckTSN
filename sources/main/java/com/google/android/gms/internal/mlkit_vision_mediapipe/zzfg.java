package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzfg extends zzkr implements zzlx {
    private static final zzfg zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private byte zzh = 2;

    static {
        zzfg zzfgVar = new zzfg();
        zzb = zzfgVar;
        zzkr.zzE(zzfg.class, zzfgVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔄ\u0000\u0002ᔄ\u0001\u0003ᔄ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i7 == 3) {
            return new zzfg();
        }
        zzfd zzfdVar = null;
        if (i7 == 4) {
            return new zzff(zzfdVar);
        }
        if (i7 == 5) {
            return zzb;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    private zzfg() {
    }
}
