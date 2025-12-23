package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhk extends zzdv implements zzfb {
    private static final zzhk zzb;
    private int zzd;
    private zzhn zze;
    private zzea zzf = zzdv.zzE();
    private zzhe zzg;

    static {
        zzhk zzhkVar = new zzhk();
        zzb = zzhkVar;
        zzdv.zzK(zzhk.class, zzhkVar);
    }

    public final zzhe zza() {
        zzhe zzheVar = this.zzg;
        return zzheVar == null ? zzhe.zzb() : zzheVar;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdv
    protected final Object zzo(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzdv.zzH(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဉ\u0001", new Object[]{"zzd", "zze", "zzf", zzha.class, "zzg"});
        }
        if (i7 == 3) {
            return new zzhk();
        }
        zzhi zzhiVar = null;
        if (i7 == 4) {
            return new zzhj(zzhiVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    private zzhk() {
    }
}
