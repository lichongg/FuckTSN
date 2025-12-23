package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzes extends zzkr implements zzlx {
    private static final zzes zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        zzes zzesVar = new zzes();
        zzb = zzesVar;
        zzkr.zzE(zzes.class, zzesVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i7 == 3) {
            return new zzes();
        }
        zzef zzefVar = null;
        if (i7 == 4) {
            return new zzer(zzefVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    private zzes() {
    }
}
