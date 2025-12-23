package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzfc extends zzkr implements zzlx {
    private static final zzfc zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzfc zzfcVar = new zzfc();
        zzb = zzfcVar;
        zzkr.zzE(zzfc.class, zzfcVar);
    }

    public static zzeg zza() {
        return (zzeg) zzb.zzo();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"zze", "zzd", zzez.class, zzet.class, zzev.class, zzfb.class, zzel.class, zzex.class});
        }
        if (i7 == 3) {
            return new zzfc();
        }
        zzef zzefVar = null;
        if (i7 == 4) {
            return new zzeg(zzefVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    private zzfc() {
    }

    static /* synthetic */ void zzd(zzfc zzfcVar, zzet zzetVar) {
        zzetVar.getClass();
        zzfcVar.zze = zzetVar;
        zzfcVar.zzd = 2;
    }

    static /* synthetic */ void zze(zzfc zzfcVar, zzev zzevVar) {
        zzevVar.getClass();
        zzfcVar.zze = zzevVar;
        zzfcVar.zzd = 3;
    }
}
