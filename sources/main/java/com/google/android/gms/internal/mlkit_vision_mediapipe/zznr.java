package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zznr extends zzkr implements zzlx {
    private static final zznr zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzfh zzg;
    private byte zzh = 2;

    static {
        zznr zznrVar = new zznr();
        zzb = zznrVar;
        zzkr.zzE(zznr.class, zznrVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001င\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i7 == 3) {
            return new zznr();
        }
        zznp zznpVar = null;
        if (i7 == 4) {
            return new zznq(zznpVar);
        }
        if (i7 == 5) {
            return zzb;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    private zznr() {
    }
}
