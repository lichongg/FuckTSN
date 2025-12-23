package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzgw extends zzkr implements zzlx {
    private static final zzgw zzb;
    private int zzd;
    private zzgy zzj;
    private byte zzk = 2;
    private String zze = "";
    private zzky zzf = zzkr.zzz();
    private zzky zzg = zzkr.zzz();
    private zzky zzh = zzkr.zzz();
    private zzky zzi = zzkr.zzz();

    static {
        zzgw zzgwVar = new zzgw();
        zzb = zzgwVar;
        zzkr.zzE(zzgw.class, zzgwVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0006\u0000\u0001\u0001ϫ\u0006\u0000\u0004\u0001\u0001ဈ\u0000\u0002\u001a\u0003\u001a\u0004ᐉ\u0001Ϫ\u001aϫ\u001a", new Object[]{"zzd", "zze", "zzf", "zzh", "zzj", "zzg", "zzi"});
        }
        if (i7 == 3) {
            return new zzgw();
        }
        zzgu zzguVar = null;
        if (i7 == 4) {
            return new zzgv(zzguVar);
        }
        if (i7 == 5) {
            return zzb;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    private zzgw() {
    }
}
