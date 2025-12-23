package com.google.android.gms.internal.mlkit_vision_mediapipe;

import com.bykv.vk.component.ttvideo.player.C;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzga extends zzkr implements zzlx {
    private static final zzga zzb;
    private int zzd;
    private long zze;
    private long zzf = C.MICROS_PER_SECOND;
    private long zzg = 1;
    private zzkx zzh = zzkr.zzy();

    static {
        zzga zzgaVar = new zzga();
        zzb = zzgaVar;
        zzkr.zzE(zzga.class, zzgaVar);
    }

    public static zzga zzg() {
        return zzb;
    }

    public final int zza() {
        return this.zzh.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004\u0014", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i7 == 3) {
            return new zzga();
        }
        zzfu zzfuVar = null;
        if (i7 == 4) {
            return new zzfz(zzfuVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    public final long zzc(int i6) {
        return this.zzh.zza(0);
    }

    public final long zzd() {
        return this.zzg;
    }

    public final long zze() {
        return this.zze;
    }

    private zzga() {
    }
}
