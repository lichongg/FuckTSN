package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzet extends zzkr implements zzlx {
    private static final zzet zzb;
    private int zzd;
    private boolean zze;
    private int zzf;
    private boolean zzg = true;
    private String zzh = "";
    private String zzi = "";
    private int zzj = 2;
    private String zzk = "";
    private int zzl = 2;
    private zzkw zzm = zzkr.zzx();
    private zzes zzn;

    static {
        zzet zzetVar = new zzet();
        zzb = zzetVar;
        zzkr.zzE(zzet.class, zzetVar);
    }

    public static zzen zza() {
        return (zzen) zzb.zzo();
    }

    static /* synthetic */ void zzd(zzet zzetVar, boolean z5) {
        zzetVar.zzd |= 4;
        zzetVar.zzg = z5;
    }

    static /* synthetic */ void zzg(zzet zzetVar, boolean z5) {
        zzetVar.zzd |= 1;
        zzetVar.zze = true;
    }

    static /* synthetic */ void zzh(zzet zzetVar, int i6) {
        zzetVar.zzf = i6 - 1;
        zzetVar.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0001\u0000\u0001ဇ\u0000\u0002ဈ\u0003\u0003ဇ\u0002\u0004᠌\u0001\u0005᠌\u0007\u0006ࠬ\u0007ဈ\u0004\bဈ\u0006\tဉ\b\n᠌\u0005", new Object[]{"zzd", "zze", "zzh", "zzg", "zzf", zzem.zza, "zzl", zzep.zza, "zzm", zzeq.zza, "zzi", "zzk", "zzn", "zzj", zzeo.zza});
        }
        if (i7 == 3) {
            return new zzet();
        }
        zzef zzefVar = null;
        if (i7 == 4) {
            return new zzen(zzefVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    private zzet() {
    }

    static /* synthetic */ void zze(zzet zzetVar, String str) {
        str.getClass();
        zzetVar.zzd |= 16;
        zzetVar.zzi = str;
    }

    static /* synthetic */ void zzf(zzet zzetVar, String str) {
        str.getClass();
        zzetVar.zzd |= 64;
        zzetVar.zzk = str;
    }
}
