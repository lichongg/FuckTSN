package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhe extends zzdv implements zzfb {
    private static final zzhe zzb;
    private int zzd;
    private String zze = "";
    private zzea zzf = zzdv.zzE();
    private boolean zzg;

    static {
        zzhe zzheVar = new zzhe();
        zzb = zzheVar;
        zzdv.zzK(zzhe.class, zzheVar);
    }

    public static zzhe zzb() {
        return zzb;
    }

    public final String zzc() {
        return this.zze;
    }

    public final boolean zzd() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdv
    protected final Object zzo(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzdv.zzH(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzd", "zze", "zzf", zzhq.class, "zzg"});
        }
        if (i7 == 3) {
            return new zzhe();
        }
        zzhc zzhcVar = null;
        if (i7 == 4) {
            return new zzhd(zzhcVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    private zzhe() {
    }
}
