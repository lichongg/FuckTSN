package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzev extends zzkr implements zzlx {
    private static final zzev zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";

    static {
        zzev zzevVar = new zzev();
        zzb = zzevVar;
        zzkr.zzE(zzev.class, zzevVar);
    }

    public static zzeu zza() {
        return (zzeu) zzb.zzo();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i7 == 3) {
            return new zzev();
        }
        zzef zzefVar = null;
        if (i7 == 4) {
            return new zzeu(zzefVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    private zzev() {
    }

    static /* synthetic */ void zzd(zzev zzevVar, String str) {
        str.getClass();
        zzevVar.zzd |= 1;
        zzevVar.zze = str;
    }

    static /* synthetic */ void zze(zzev zzevVar, String str) {
        str.getClass();
        zzevVar.zzd |= 2;
        zzevVar.zzf = str;
    }
}
