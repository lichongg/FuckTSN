package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzfq extends zzkr implements zzlx {
    private static final zzfq zzb;
    private static volatile zzme zzd;
    private zzky zze = zzkr.zzz();

    static {
        zzfq zzfqVar = new zzfq();
        zzb = zzfqVar;
        zzkr.zzE(zzfq.class, zzfqVar);
    }

    public static zzme zzc() {
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
            return zzkr.zzB(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzfo.class});
        }
        if (i7 == 3) {
            return new zzfq();
        }
        zzfi zzfiVar = null;
        if (i7 == 4) {
            return new zzfp(zzfiVar);
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
        synchronized (zzfq.class) {
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

    public final List zzd() {
        return this.zze;
    }

    private zzfq() {
    }
}
