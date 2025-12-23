package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzob extends zzkr implements zzlx {
    private static final zzob zzb;
    private int zzd;
    private int zze;
    private zznt zzf;
    private zzny zzg;
    private zznr zzh;
    private byte zzj = 2;
    private zzky zzi = zzkr.zzz();

    static {
        zzob zzobVar = new zzob();
        zzb = zzobVar;
        zzkr.zzE(zzob.class, zzobVar);
    }

    public static zzob zzg() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ᐉ\u0003\u0005\u001b", new Object[]{"zzd", "zze", zznv.zza, "zzf", "zzg", "zzh", "zzi", zzoa.class});
        }
        if (i7 == 3) {
            return new zzob();
        }
        zznp zznpVar = null;
        if (i7 == 4) {
            return new zznu(zznpVar);
        }
        if (i7 == 5) {
            return zzb;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final zznt zzc() {
        zznt zzntVar = this.zzf;
        return zzntVar == null ? zznt.zzI() : zzntVar;
    }

    public final zzny zze() {
        zzny zznyVar = this.zzg;
        return zznyVar == null ? zzny.zzI() : zznyVar;
    }

    public final int zzh() {
        int zza = zznw.zza(this.zze);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    private zzob() {
    }
}
