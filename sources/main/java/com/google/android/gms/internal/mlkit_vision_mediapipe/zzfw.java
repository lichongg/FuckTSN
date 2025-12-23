package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzfw extends zzkr implements zzlx {
    private static final zzfw zzb;
    private int zzd;
    private long zzf;
    private long zzg;
    private zzga zzh;
    private zzga zzi;
    private zzga zzj;
    private String zze = "";
    private zzky zzk = zzkr.zzz();

    static {
        zzfw zzfwVar = new zzfw();
        zzb = zzfwVar;
        zzkr.zzE(zzfw.class, zzfwVar);
    }

    public static zzfw zzc(byte[] bArr) throws zzlb {
        return (zzfw) zzkr.zzu(zzb, bArr);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        int i7 = i6 - 1;
        if (i7 == 0) {
            return (byte) 1;
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzfy.class});
        }
        if (i7 == 3) {
            return new zzfw();
        }
        zzfu zzfuVar = null;
        if (i7 == 4) {
            return new zzfv(zzfuVar);
        }
        if (i7 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzga zzd() {
        zzga zzgaVar = this.zzh;
        return zzgaVar == null ? zzga.zzg() : zzgaVar;
    }

    public final String zze() {
        return this.zze;
    }

    private zzfw() {
    }
}
