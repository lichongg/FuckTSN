package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhq extends zzdv implements zzfb {
    private static final zzhq zzb;
    private int zzd;
    private String zze = "";
    private int zzf;

    static {
        zzhq zzhqVar = new zzhq();
        zzb = zzhqVar;
        zzdv.zzK(zzhq.class, zzhqVar);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdv
    protected final Object zzo(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzdv.zzH(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", "zzf", zzhb.zza});
        }
        if (i7 == 3) {
            return new zzhq();
        }
        zzho zzhoVar = null;
        if (i7 == 4) {
            return new zzhp(zzhoVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    private zzhq() {
    }
}
