package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzfm extends zzkr implements zzlx {
    private static final zzfm zzb;
    private zzky zzd = zzkr.zzz();

    static {
        zzfm zzfmVar = new zzfm();
        zzb = zzfmVar;
        zzkr.zzE(zzfm.class, zzfmVar);
    }

    public static zzfm zzc(byte[] bArr) throws zzlb {
        return (zzfm) zzkr.zzu(zzb, bArr);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzfk.class});
        }
        if (i7 == 3) {
            return new zzfm();
        }
        zzfi zzfiVar = null;
        if (i7 == 4) {
            return new zzfl(zzfiVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    public final List zzd() {
        return this.zzd;
    }

    private zzfm() {
    }
}
