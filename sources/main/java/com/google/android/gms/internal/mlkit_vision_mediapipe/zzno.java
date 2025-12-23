package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzno extends zzkr implements zzlx {
    private static final zzno zzb;
    private static volatile zzme zzd;
    private int zze;
    private zzob zzi;
    private long zzl;
    private long zzo;
    private byte zzp = 2;
    private zzky zzf = zzkr.zzz();
    private zzkw zzg = zzkr.zzx();
    private zzkv zzh = zzkr.zzw();
    private String zzj = "";
    private String zzk = "";
    private zzky zzm = zzkr.zzz();
    private zzky zzn = zzkr.zzz();

    static {
        zzno zznoVar = new zzno();
        zzb = zznoVar;
        zzkr.zzE(zzno.class, zznoVar);
    }

    public static zzme zzc() {
        return (zzme) zzb.zzb(7, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr
    protected final Object zzb(int i6, Object obj, Object obj2) {
        zzme zzmeVar;
        int i7 = i6 - 1;
        if (i7 == 0) {
            return Byte.valueOf(this.zzp);
        }
        if (i7 == 2) {
            return zzkr.zzB(zzb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0005\u0001\u0001\u001a\u0002'\u0003$\u0004ᐉ\u0000\u0005ဈ\u0001\u0006ဈ\u0002\u0007ဂ\u0003\b\u001b\t\u001a\nဂ\u0004", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zznm.class, "zzn", "zzo"});
        }
        if (i7 == 3) {
            return new zzno();
        }
        zznk zznkVar = null;
        if (i7 == 4) {
            return new zznn(zznkVar);
        }
        if (i7 == 5) {
            return zzb;
        }
        if (i7 != 6) {
            this.zzp = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzme zzmeVar2 = zzd;
        if (zzmeVar2 != null) {
            return zzmeVar2;
        }
        synchronized (zzno.class) {
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

    public final zzob zzf() {
        zzob zzobVar = this.zzi;
        return zzobVar == null ? zzob.zzg() : zzobVar;
    }

    private zzno() {
    }
}
