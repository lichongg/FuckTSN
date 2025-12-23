package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zznt extends zzkr implements zzlx {
    private static final zznt zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zznt zzntVar = new zznt();
        zzb = zzntVar;
        zzkr.zzE(zznt.class, zzntVar);
    }

    public static zznt zzI() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i7 == 3) {
            return new zznt();
        }
        zznp zznpVar = null;
        if (i7 == 4) {
            return new zzns(zznpVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzc() {
        return this.zzh;
    }

    public final int zze() {
        return this.zzg;
    }

    public final int zzf() {
        return this.zze;
    }

    public final int zzg() {
        return this.zzf;
    }

    private zznt() {
    }
}
