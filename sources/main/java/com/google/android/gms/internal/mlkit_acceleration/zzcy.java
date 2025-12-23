package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzcy {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzcz zzc;

    public abstract void zzA(int i6);

    public abstract boolean zzC() throws IOException;

    public abstract boolean zzD() throws IOException;

    public abstract boolean zzE(int i6) throws IOException;

    public abstract double zzb() throws IOException;

    public abstract float zzc() throws IOException;

    public abstract int zzd();

    public abstract int zze(int i6) throws zzed;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzk() throws IOException;

    public abstract int zzl() throws IOException;

    public abstract int zzm() throws IOException;

    public abstract int zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract long zzt() throws IOException;

    public abstract long zzu() throws IOException;

    public abstract long zzv() throws IOException;

    public abstract zzcs zzw() throws IOException;

    public abstract String zzx() throws IOException;

    public abstract String zzy() throws IOException;

    public abstract void zzz(int i6) throws zzed;

    public static int zzF(int i6) {
        return (i6 >>> 1) ^ (-(i6 & 1));
    }

    public static long zzG(long j6) {
        return (j6 >>> 1) ^ (-(1 & j6));
    }

    static zzcy zzH(byte[] bArr, int i6, int i7, boolean z5) {
        zzcu zzcuVar = new zzcu(bArr, 0, 0, false, null);
        try {
            zzcuVar.zze(0);
            return zzcuVar;
        } catch (zzed e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    /* synthetic */ zzcy(zzcx zzcxVar) {
    }
}
