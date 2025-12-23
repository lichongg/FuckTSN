package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzex extends zzkr implements zzlx {
    private static final zzex zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";

    static {
        zzex zzexVar = new zzex();
        zzb = zzexVar;
        zzkr.zzE(zzex.class, zzexVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i7 == 3) {
            return new zzex();
        }
        zzef zzefVar = null;
        if (i7 == 4) {
            return new zzew(zzefVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    private zzex() {
    }
}
