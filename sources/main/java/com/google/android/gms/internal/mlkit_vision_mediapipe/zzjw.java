package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzjw extends zzjg {
    private static final Logger zzb = Logger.getLogger(zzjw.class.getName());
    private static final boolean zzc = zznd.zzx();
    zzjx zza;

    private zzjw() {
        throw null;
    }

    public abstract int zza();

    public abstract void zzb(byte b6) throws IOException;

    public abstract void zzd(int i6, boolean z5) throws IOException;

    public abstract void zze(int i6, zzjo zzjoVar) throws IOException;

    public abstract void zzf(int i6, int i7) throws IOException;

    public abstract void zzg(int i6) throws IOException;

    public abstract void zzh(int i6, long j6) throws IOException;

    public abstract void zzi(long j6) throws IOException;

    public abstract void zzj(int i6, int i7) throws IOException;

    public abstract void zzk(int i6) throws IOException;

    public abstract void zzl(byte[] bArr, int i6, int i7) throws IOException;

    abstract void zzm(int i6, zzlw zzlwVar, zzmi zzmiVar) throws IOException;

    public abstract void zzn(int i6, zzlw zzlwVar) throws IOException;

    public abstract void zzo(int i6, zzjo zzjoVar) throws IOException;

    public abstract void zzp(int i6, String str) throws IOException;

    public abstract void zzr(int i6, int i7) throws IOException;

    public abstract void zzs(int i6, int i7) throws IOException;

    public abstract void zzt(int i6) throws IOException;

    public abstract void zzu(int i6, long j6) throws IOException;

    public abstract void zzv(long j6) throws IOException;

    /* synthetic */ zzjw(zzjv zzjvVar) {
    }

    @Deprecated
    static int zzw(int i6, zzlw zzlwVar, zzmi zzmiVar) {
        int zzz = zzz(i6 << 3);
        return zzz + zzz + ((zziv) zzlwVar).zzi(zzmiVar);
    }

    static int zzx(zzlw zzlwVar, zzmi zzmiVar) {
        int zzi = ((zziv) zzlwVar).zzi(zzmiVar);
        return zzz(zzi) + zzi;
    }

    final void zzC(String str, zznf zznfVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zznfVar);
        byte[] bytes = str.getBytes(zzkz.zza);
        try {
            int length = bytes.length;
            zzt(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e6) {
            throw new zzju(e6);
        }
    }

    public static int zzA(long j6) {
        return (640 - (Long.numberOfLeadingZeros(j6) * 9)) >>> 6;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = zzng.zzc(str);
        } catch (zznf unused) {
            length = str.getBytes(zzkz.zza).length;
        }
        return zzz(length) + length;
    }

    public static int zzz(int i6) {
        return (352 - (Integer.numberOfLeadingZeros(i6) * 9)) >>> 6;
    }

    public final void zzB() {
        if (zza() == 0) {
        } else {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }
}
