package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhj extends zzkr implements zzlx {
    private static final zzhj zzb;
    private static volatile zzme zzd;
    private int zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private float zzj;
    private long zzk;
    private byte zzl = 2;

    static {
        zzhj zzhjVar = new zzhj();
        zzb = zzhjVar;
        zzkr.zzE(zzhj.class, zzhjVar);
    }

    public static zzme zzg() {
        return (zzme) zzb.zzb(7, null, null);
    }

    public final float zza() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        zzme zzmeVar;
        int i7 = i6 - 1;
        if (i7 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0004\u0001ᔁ\u0000\u0002ᔁ\u0001\u0003ᔁ\u0002\u0004ᔁ\u0003\u0005ခ\u0004\u0006ဂ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i7 == 3) {
            return new zzhj();
        }
        zzhh zzhhVar = null;
        if (i7 == 4) {
            return new zzhi(zzhhVar);
        }
        if (i7 == 5) {
            return zzb;
        }
        if (i7 != 6) {
            this.zzl = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzme zzmeVar2 = zzd;
        if (zzmeVar2 != null) {
            return zzmeVar2;
        }
        synchronized (zzhj.class) {
            try {
                zzmeVar = zzd;
                if (zzmeVar == null) {
                    zzmeVar = new zzkl(zzb);
                    zzd = zzmeVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzmeVar;
    }

    public final float zzc() {
        return this.zzi;
    }

    public final float zzd() {
        return this.zzf;
    }

    public final float zze() {
        return this.zzg;
    }

    private zzhj() {
    }
}
