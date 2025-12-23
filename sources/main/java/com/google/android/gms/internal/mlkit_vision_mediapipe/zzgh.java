package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzgh extends zzkr implements zzlx {
    private static final zzgh zzb;
    private int zzd;
    private zzgo zzg;
    private byte zzh = 2;
    private String zze = "";
    private String zzf = "";

    static {
        zzgh zzghVar = new zzgh();
        zzb = zzghVar;
        zzkr.zzE(zzgh.class, zzghVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001Ȉ\u0002Ȉ\u0003ᐉ\u0000", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i7 == 3) {
            return new zzgh();
        }
        zzgb zzgbVar = null;
        if (i7 == 4) {
            return new zzgg(zzgbVar);
        }
        if (i7 == 5) {
            return zzb;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    private zzgh() {
    }
}
