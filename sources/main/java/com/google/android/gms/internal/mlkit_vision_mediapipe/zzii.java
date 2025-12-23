package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzii extends zzkr implements zzlx {
    private static final zzii zzb;
    private static volatile zzme zzd;
    private int zze;
    private zzin zzf;
    private zzof zzg;

    static {
        zzii zziiVar = new zzii();
        zzb = zziiVar;
        zzkr.zzE(zzii.class, zziiVar);
    }

    public static zzme zzd() {
        return (zzme) zzb.zzb(7, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        zzme zzmeVar;
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i7 == 3) {
            return new zzii();
        }
        zzig zzigVar = null;
        if (i7 == 4) {
            return new zzih(zzigVar);
        }
        if (i7 == 5) {
            return zzb;
        }
        if (i7 != 6) {
            return null;
        }
        zzme zzmeVar2 = zzd;
        if (zzmeVar2 != null) {
            return zzmeVar2;
        }
        synchronized (zzii.class) {
            try {
                zzmeVar = zzd;
                if (zzmeVar == null) {
                    zzmeVar = new zzkl(zzb);
                    zzd = zzmeVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzmeVar;
    }

    public final zzin zzc() {
        zzin zzinVar = this.zzf;
        return zzinVar == null ? zzin.zze() : zzinVar;
    }

    private zzii() {
    }
}
