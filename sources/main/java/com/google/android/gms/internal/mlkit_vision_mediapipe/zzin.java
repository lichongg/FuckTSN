package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzin extends zzkr implements zzlx {
    private static final zzin zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzkv zzg = zzkr.zzw();
    private zzkw zzh = zzkr.zzx();

    static {
        zzin zzinVar = new zzin();
        zzb = zzinVar;
        zzkr.zzE(zzin.class, zzinVar);
    }

    public static zzin zze() {
        return zzb;
    }

    public final int zza(int i6) {
        return this.zzh.zze(i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003\u0013\u0004\u001d", new Object[]{"zzd", "zze", zzim.zza, "zzf", zzil.zza, "zzg", "zzh"});
        }
        if (i7 == 3) {
            return new zzin();
        }
        zzij zzijVar = null;
        if (i7 == 4) {
            return new zzik(zzijVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzc() {
        return this.zzh.size();
    }

    private zzin() {
    }
}
