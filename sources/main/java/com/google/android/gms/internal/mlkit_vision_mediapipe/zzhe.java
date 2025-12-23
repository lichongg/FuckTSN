package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhe extends zzkr implements zzlx {
    private static final zzhe zzb;
    private int zzd;
    private zzgo zzf;
    private byte zzg = 2;
    private String zze = "DefaultInputStreamHandler";

    static {
        zzhe zzheVar = new zzhe();
        zzb = zzheVar;
        zzkr.zzE(zzhe.class, zzheVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0003ᐉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i7 == 3) {
            return new zzhe();
        }
        zzhc zzhcVar = null;
        if (i7 == 4) {
            return new zzhd(zzhcVar);
        }
        if (i7 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    private zzhe() {
    }
}
