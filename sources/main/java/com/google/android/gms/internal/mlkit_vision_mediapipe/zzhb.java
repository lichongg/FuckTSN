package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhb extends zzkr implements zzlx {
    private static final zzhb zzb;
    private int zzd;
    private zzgo zzh;
    private byte zzi = 2;
    private String zze = "";
    private zzky zzf = zzkr.zzz();
    private zzky zzg = zzkr.zzz();

    static {
        zzhb zzhbVar = new zzhb();
        zzb = zzhbVar;
        zzkr.zzE(zzhb.class, zzhbVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0004\u0000\u0001\u0001Ϫ\u0004\u0000\u0002\u0001\u0001ဈ\u0000\u0002\u001a\u0003ᐉ\u0001Ϫ\u001a", new Object[]{"zzd", "zze", "zzf", "zzh", "zzg"});
        }
        if (i7 == 3) {
            return new zzhb();
        }
        zzgz zzgzVar = null;
        if (i7 == 4) {
            return new zzha(zzgzVar);
        }
        if (i7 == 5) {
            return zzb;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    private zzhb() {
    }
}
