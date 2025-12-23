package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzgy extends zzdv implements zzfb {
    private static final zzgy zzb;
    private int zzd;
    private int zzg;
    private String zze = "";
    private String zzf = "";
    private String zzh = "";

    static {
        zzgy zzgyVar = new zzgy();
        zzb = zzgyVar;
        zzdv.zzK(zzgy.class, zzgyVar);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdv
    protected final Object zzo(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzdv.zzH(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i7 == 3) {
            return new zzgy();
        }
        zzgw zzgwVar = null;
        if (i7 == 4) {
            return new zzgx(zzgwVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    private zzgy() {
    }
}
