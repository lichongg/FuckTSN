package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzcs implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzcs zzb = new zzcp(zzeb.zzd);
    private static final zzcr zzd;
    private int zzc = 0;

    public abstract boolean equals(Object obj);

    public abstract byte zza(int i6);

    abstract byte zzb(int i6);

    public abstract int zzd();

    protected abstract int zze(int i6, int i7, int i8);

    public abstract zzcs zzf(int i6, int i7);

    protected abstract String zzg(Charset charset);

    abstract void zzh(zzci zzciVar) throws IOException;

    public abstract boolean zzi();

    static {
        int i6 = zzce.zza;
        zzd = new zzcr(null);
        zza = new zzck();
    }

    static int zzj(int i6, int i7, int i8) {
        int i9 = i7 - i6;
        if ((i6 | i7 | i9 | (i8 - i7)) >= 0) {
            return i9;
        }
        if (i6 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i6 + " < 0");
        }
        if (i7 < i6) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i6 + ", " + i7);
        }
        throw new IndexOutOfBoundsException("End index: " + i7 + " >= " + i8);
    }

    public static zzcs zzl(byte[] bArr, int i6, int i7) {
        zzj(i6, i6 + i7, bArr.length);
        byte[] bArr2 = new byte[i7];
        System.arraycopy(bArr, i6, bArr2, 0, i7);
        return new zzcp(bArr2);
    }

    public final int hashCode() {
        int i6 = this.zzc;
        if (i6 == 0) {
            int zzd2 = zzd();
            i6 = zze(zzd2, 0, zzd2);
            if (i6 == 0) {
                i6 = 1;
            }
            this.zzc = i6;
        }
        return i6;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzcj(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzd()), zzd() <= 50 ? zzgb.zza(this) : zzgb.zza(zzf(0, 47)).concat("..."));
    }

    protected final int zzk() {
        return this.zzc;
    }

    zzcs() {
    }

    public final String zzm(Charset charset) {
        if (zzd() == 0) {
            return "";
        }
        return zzg(charset);
    }
}
