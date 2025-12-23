package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzjo implements Iterable, Serializable {
    public static final zzjo zzb = new zzjn(zzkz.zzb);
    private int zza = 0;

    public abstract boolean equals(Object obj);

    public abstract byte zza(int i6);

    abstract byte zzb(int i6);

    public abstract int zzd();

    protected abstract int zze(int i6, int i7, int i8);

    public abstract zzjo zzf(int i6, int i7);

    abstract void zzg(zzjg zzjgVar) throws IOException;

    static {
        int i6 = zziz.zza;
    }

    static int zzh(int i6, int i7, int i8) {
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

    public static zzjo zzj(byte[] bArr, int i6, int i7) {
        zzh(i6, i6 + i7, bArr.length);
        byte[] bArr2 = new byte[i7];
        System.arraycopy(bArr, i6, bArr2, 0, i7);
        return new zzjn(bArr2);
    }

    public final int hashCode() {
        int i6 = this.zza;
        if (i6 == 0) {
            int zzd = zzd();
            i6 = zze(zzd, 0, zzd);
            if (i6 == 0) {
                i6 = 1;
            }
            this.zza = i6;
        }
        return i6;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzjh(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzd()), zzd() <= 50 ? zzmu.zza(this) : zzmu.zza(zzf(0, 47)).concat("..."));
    }

    protected final int zzi() {
        return this.zza;
    }

    zzjo() {
    }
}
