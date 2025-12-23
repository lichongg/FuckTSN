package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzfk extends zzkr implements zzlx {
    private static final zzfk zzb;
    private int zzd;
    private float zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;

    static {
        zzfk zzfkVar = new zzfk();
        zzb = zzfkVar;
        zzkr.zzE(zzfk.class, zzfkVar);
    }

    public final float zza() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i7 == 3) {
            return new zzfk();
        }
        zzfi zzfiVar = null;
        if (i7 == 4) {
            return new zzfj(zzfiVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    public final float zzc() {
        return this.zze;
    }

    public final float zzd() {
        return this.zzf;
    }

    public final float zze() {
        return this.zzg;
    }

    private zzfk() {
    }
}
