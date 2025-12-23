package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzdd extends zzci {
    private static final Logger zzb = Logger.getLogger(zzdd.class.getName());
    private static final boolean zzc = zzgn.zzx();
    zzde zza;

    private zzdd() {
    }

    public abstract int zza();

    public abstract void zzb(byte b6) throws IOException;

    public abstract void zzd(int i6, boolean z5) throws IOException;

    public abstract void zze(int i6, zzcs zzcsVar) throws IOException;

    public abstract void zzf(int i6, int i7) throws IOException;

    public abstract void zzg(int i6) throws IOException;

    public abstract void zzh(int i6, long j6) throws IOException;

    public abstract void zzi(long j6) throws IOException;

    public abstract void zzj(int i6, int i7) throws IOException;

    public abstract void zzk(int i6) throws IOException;

    public abstract void zzl(byte[] bArr, int i6, int i7) throws IOException;

    public abstract void zzm(int i6, String str) throws IOException;

    public abstract void zzo(int i6, int i7) throws IOException;

    public abstract void zzp(int i6, int i7) throws IOException;

    public abstract void zzq(int i6) throws IOException;

    public abstract void zzr(int i6, long j6) throws IOException;

    public abstract void zzs(long j6) throws IOException;

    /* synthetic */ zzdd(zzdc zzdcVar) {
    }

    @Deprecated
    static int zzt(int i6, zzfa zzfaVar, zzfm zzfmVar) {
        int zzw = zzw(i6 << 3);
        return zzw + zzw + ((zzcc) zzfaVar).zzt(zzfmVar);
    }

    static int zzu(zzfa zzfaVar, zzfm zzfmVar) {
        int zzt = ((zzcc) zzfaVar).zzt(zzfmVar);
        return zzw(zzt) + zzt;
    }

    public static zzdd zzy(byte[] bArr, int i6, int i7) {
        return new zzda(bArr, 0, i7);
    }

    final void zzA(String str, zzgr zzgrVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzgrVar);
        byte[] bytes = str.getBytes(zzeb.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e6) {
            throw new zzdb(e6);
        }
    }

    public static int zzv(String str) {
        int length;
        try {
            length = zzgs.zzc(str);
        } catch (zzgr unused) {
            length = str.getBytes(zzeb.zzb).length;
        }
        return zzw(length) + length;
    }

    public static int zzw(int i6) {
        return (352 - (Integer.numberOfLeadingZeros(i6) * 9)) >>> 6;
    }

    public static int zzx(long j6) {
        return (640 - (Long.numberOfLeadingZeros(j6) * 9)) >>> 6;
    }

    public final void zzz() {
        if (zza() == 0) {
        } else {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }
}
