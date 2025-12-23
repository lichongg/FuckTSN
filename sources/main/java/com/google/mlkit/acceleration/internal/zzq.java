package com.google.mlkit.acceleration.internal;

import com.google.android.gms.internal.mlkit_acceleration.zzdv;
import com.google.android.gms.internal.mlkit_acceleration.zzfb;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzq extends zzdv implements zzfb {
    private static final zzq zzb;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private String zzg = "";
    private int zzh;
    private float zzi;
    private int zzj;

    static {
        zzq zzqVar = new zzq();
        zzb = zzqVar;
        zzdv.zzK(zzq.class, zzqVar);
    }

    public static zzp zzd() {
        return (zzp) zzb.zzy();
    }

    static /* synthetic */ void zzh(zzq zzqVar, boolean z5) {
        zzqVar.zzd |= 1;
        zzqVar.zze = z5;
    }

    static /* synthetic */ void zzi(zzq zzqVar, float f6) {
        zzqVar.zzd |= 16;
        zzqVar.zzi = f6;
    }

    static /* synthetic */ void zzj(zzq zzqVar, int i6) {
        zzqVar.zzd |= 32;
        zzqVar.zzj = i6;
    }

    static /* synthetic */ void zzm(zzq zzqVar, int i6) {
        zzqVar.zzd |= 8;
        zzqVar.zzh = i6;
    }

    public final float zza() {
        return this.zzi;
    }

    public final int zzb() {
        return this.zzj;
    }

    public final int zzc() {
        return this.zzh;
    }

    public final String zzf() {
        return this.zzg;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final boolean zzn() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzdv
    protected final Object zzo(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzdv.zzH(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005ခ\u0004\u0006င\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i7 == 3) {
            return new zzq();
        }
        zzo zzoVar = null;
        if (i7 == 4) {
            return new zzp(zzoVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    private zzq() {
    }

    static /* synthetic */ void zzk(zzq zzqVar, String str) {
        str.getClass();
        zzqVar.zzd |= 2;
        zzqVar.zzf = str;
    }

    static /* synthetic */ void zzl(zzq zzqVar, String str) {
        str.getClass();
        zzqVar.zzd |= 4;
        zzqVar.zzg = str;
    }
}
