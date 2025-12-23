package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzcw extends zzcy {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    /* synthetic */ zzcw(InputStream inputStream, int i6, zzcv zzcvVar) {
        super(null);
        this.zzl = Integer.MAX_VALUE;
        byte[] bArr = zzeb.zzd;
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    final long zzs() throws IOException {
        long j6 = 0;
        for (int i6 = 0; i6 < 64; i6 += 7) {
            j6 |= (r3 & Byte.MAX_VALUE) << i6;
            if ((zza() & 128) == 0) {
                return j6;
            }
        }
        throw zzed.zze();
    }

    private final List zzI(int i6) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i6 > 0) {
            int min = Math.min(i6, 4096);
            byte[] bArr = new byte[min];
            int i7 = 0;
            while (i7 < min) {
                int read = this.zze.read(bArr, i7, min - i7);
                if (read == -1) {
                    throw zzed.zzj();
                }
                this.zzk += read;
                i7 += read;
            }
            i6 -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzJ() {
        int i6 = this.zzg + this.zzh;
        this.zzg = i6;
        int i7 = this.zzk + i6;
        int i8 = this.zzl;
        if (i7 <= i8) {
            this.zzh = 0;
            return;
        }
        int i9 = i7 - i8;
        this.zzh = i9;
        this.zzg = i6 - i9;
    }

    private final boolean zzL(int i6) throws IOException {
        int i7 = this.zzi;
        int i8 = i7 + i6;
        int i9 = this.zzg;
        if (i8 <= i9) {
            throw new IllegalStateException("refillBuffer() called when " + i6 + " bytes were already available in buffer");
        }
        int i10 = this.zzk;
        if (i6 > (Integer.MAX_VALUE - i10) - i7 || i10 + i7 + i6 > this.zzl) {
            return false;
        }
        if (i7 > 0) {
            if (i9 > i7) {
                byte[] bArr = this.zzf;
                System.arraycopy(bArr, i7, bArr, 0, i9 - i7);
            }
            i10 = this.zzk + i7;
            this.zzk = i10;
            i9 = this.zzg - i7;
            this.zzg = i9;
            this.zzi = 0;
        }
        try {
            int read = this.zze.read(this.zzf, i9, Math.min(4096 - i9, (Integer.MAX_VALUE - i10) - i9));
            if (read == 0 || read < -1 || read > 4096) {
                throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
            }
            if (read <= 0) {
                return false;
            }
            this.zzg += read;
            zzJ();
            if (this.zzg >= i6) {
                return true;
            }
            return zzL(i6);
        } catch (zzed e6) {
            e6.zzk();
            throw e6;
        }
    }

    private final byte[] zzN(int i6) throws IOException {
        if (i6 == 0) {
            return zzeb.zzd;
        }
        if (i6 < 0) {
            throw zzed.zzf();
        }
        int i7 = this.zzk;
        int i8 = this.zzi;
        int i9 = i7 + i8 + i6;
        if ((-2147483647) + i9 > 0) {
            throw zzed.zzi();
        }
        int i10 = this.zzl;
        if (i9 > i10) {
            zzB((i10 - i7) - i8);
            throw zzed.zzj();
        }
        int i11 = this.zzg - i8;
        int i12 = i6 - i11;
        if (i12 >= 4096) {
            try {
                if (i12 > this.zze.available()) {
                    return null;
                }
            } catch (zzed e6) {
                e6.zzk();
                throw e6;
            }
        }
        byte[] bArr = new byte[i6];
        System.arraycopy(this.zzf, this.zzi, bArr, 0, i11);
        this.zzk += this.zzg;
        this.zzi = 0;
        this.zzg = 0;
        while (i11 < i6) {
            try {
                int read = this.zze.read(bArr, i11, i6 - i11);
                if (read == -1) {
                    throw zzed.zzj();
                }
                this.zzk += read;
                i11 += read;
            } catch (zzed e7) {
                e7.zzk();
                throw e7;
            }
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final void zzA(int i6) {
        this.zzl = i6;
        zzJ();
    }

    public final void zzB(int i6) throws IOException {
        int i7 = this.zzg;
        int i8 = this.zzi;
        int i9 = i7 - i8;
        if (i6 <= i9 && i6 >= 0) {
            this.zzi = i8 + i6;
            return;
        }
        if (i6 < 0) {
            throw zzed.zzf();
        }
        int i10 = this.zzk;
        int i11 = i10 + i8;
        int i12 = this.zzl;
        if (i11 + i6 > i12) {
            zzB((i12 - i10) - i8);
            throw zzed.zzj();
        }
        this.zzk = i11;
        this.zzg = 0;
        this.zzi = 0;
        while (i9 < i6) {
            try {
                long j6 = i6 - i9;
                try {
                    long skip = this.zze.skip(j6);
                    if (skip < 0 || skip > j6) {
                        throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                    }
                    if (skip == 0) {
                        break;
                    } else {
                        i9 += (int) skip;
                    }
                } catch (zzed e6) {
                    e6.zzk();
                    throw e6;
                }
            } catch (Throwable th) {
                this.zzk += i9;
                zzJ();
                throw th;
            }
        }
        this.zzk += i9;
        zzJ();
        if (i9 >= i6) {
            return;
        }
        int i13 = this.zzg;
        int i14 = i13 - this.zzi;
        this.zzi = i13;
        zzK(1);
        while (true) {
            int i15 = i6 - i14;
            int i16 = this.zzg;
            if (i15 <= i16) {
                this.zzi = i15;
                return;
            } else {
                i14 += i16;
                this.zzi = i16;
                zzK(1);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final boolean zzC() throws IOException {
        return this.zzi == this.zzg && !zzL(1);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final boolean zzE(int i6) throws IOException {
        int zzm;
        int i7 = i6 & 7;
        int i8 = 0;
        if (i7 == 0) {
            if (this.zzg - this.zzi < 10) {
                while (i8 < 10) {
                    if (zza() < 0) {
                        i8++;
                    }
                }
                throw zzed.zze();
            }
            while (i8 < 10) {
                byte[] bArr = this.zzf;
                int i9 = this.zzi;
                this.zzi = i9 + 1;
                if (bArr[i9] < 0) {
                    i8++;
                }
            }
            throw zzed.zze();
            return true;
        }
        if (i7 == 1) {
            zzB(8);
            return true;
        }
        if (i7 == 2) {
            zzB(zzj());
            return true;
        }
        if (i7 != 3) {
            if (i7 == 4) {
                return false;
            }
            if (i7 != 5) {
                throw zzed.zza();
            }
            zzB(4);
            return true;
        }
        do {
            zzm = zzm();
            if (zzm == 0) {
                break;
            }
        } while (zzE(zzm));
        zzz(((i6 >>> 3) << 3) | 4);
        return true;
    }

    public final byte zza() throws IOException {
        if (this.zzi == this.zzg) {
            zzK(1);
        }
        byte[] bArr = this.zzf;
        int i6 = this.zzi;
        this.zzi = i6 + 1;
        return bArr[i6];
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final int zzd() {
        return this.zzk + this.zzi;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final int zze(int i6) throws zzed {
        if (i6 < 0) {
            throw zzed.zzf();
        }
        int i7 = this.zzk + this.zzi;
        int i8 = this.zzl;
        int i9 = i6 + i7;
        if (i9 > i8) {
            throw zzed.zzj();
        }
        this.zzl = i9;
        zzJ();
        return i8;
    }

    public final int zzi() throws IOException {
        int i6 = this.zzi;
        if (this.zzg - i6 < 4) {
            zzK(4);
            i6 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i6 + 4;
        int i7 = bArr[i6] & 255;
        int i8 = bArr[i6 + 1] & 255;
        int i9 = bArr[i6 + 2] & 255;
        return ((bArr[i6 + 3] & 255) << 24) | (i8 << 8) | i7 | (i9 << 16);
    }

    public final int zzj() throws IOException {
        int i6;
        int i7 = this.zzi;
        int i8 = this.zzg;
        if (i8 != i7) {
            byte[] bArr = this.zzf;
            int i9 = i7 + 1;
            byte b6 = bArr[i7];
            if (b6 >= 0) {
                this.zzi = i9;
                return b6;
            }
            if (i8 - i9 >= 9) {
                int i10 = i7 + 2;
                int i11 = (bArr[i9] << 7) ^ b6;
                if (i11 < 0) {
                    i6 = i11 ^ (-128);
                } else {
                    int i12 = i7 + 3;
                    int i13 = (bArr[i10] << 14) ^ i11;
                    if (i13 >= 0) {
                        i6 = i13 ^ 16256;
                    } else {
                        int i14 = i7 + 4;
                        int i15 = i13 ^ (bArr[i12] << 21);
                        if (i15 < 0) {
                            i6 = (-2080896) ^ i15;
                        } else {
                            i12 = i7 + 5;
                            byte b7 = bArr[i14];
                            int i16 = (i15 ^ (b7 << 28)) ^ 266354560;
                            if (b7 < 0) {
                                i14 = i7 + 6;
                                if (bArr[i12] < 0) {
                                    i12 = i7 + 7;
                                    if (bArr[i14] < 0) {
                                        i14 = i7 + 8;
                                        if (bArr[i12] < 0) {
                                            i12 = i7 + 9;
                                            if (bArr[i14] < 0) {
                                                int i17 = i7 + 10;
                                                if (bArr[i12] >= 0) {
                                                    i10 = i17;
                                                    i6 = i16;
                                                }
                                            }
                                        }
                                    }
                                }
                                i6 = i16;
                            }
                            i6 = i16;
                        }
                        i10 = i14;
                    }
                    i10 = i12;
                }
                this.zzi = i10;
                return i6;
            }
        }
        return (int) zzs();
    }

    public final long zzq() throws IOException {
        int i6 = this.zzi;
        if (this.zzg - i6 < 8) {
            zzK(8);
            i6 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i6 + 8;
        long j6 = bArr[i6];
        long j7 = bArr[i6 + 2];
        long j8 = bArr[i6 + 3];
        return ((bArr[i6 + 6] & 255) << 48) | (j6 & 255) | ((bArr[i6 + 1] & 255) << 8) | ((j7 & 255) << 16) | ((j8 & 255) << 24) | ((bArr[i6 + 4] & 255) << 32) | ((bArr[i6 + 5] & 255) << 40) | ((bArr[i6 + 7] & 255) << 56);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b7, code lost:
    
        if (r2[r5] >= 0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzr() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 196
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_acceleration.zzcw.zzr():long");
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final void zzz(int i6) throws zzed {
        if (this.zzj != i6) {
            throw zzed.zzb();
        }
    }

    private final void zzK(int i6) throws IOException {
        if (!zzL(i6)) {
            if (i6 > (Integer.MAX_VALUE - this.zzk) - this.zzi) {
                throw zzed.zzi();
            }
            throw zzed.zzj();
        }
    }

    private final byte[] zzM(int i6, boolean z5) throws IOException {
        byte[] zzN = zzN(i6);
        if (zzN != null) {
            return zzN;
        }
        int i7 = this.zzi;
        int i8 = this.zzg;
        int i9 = i8 - i7;
        this.zzk += i8;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzI = zzI(i6 - i9);
        byte[] bArr = new byte[i6];
        System.arraycopy(this.zzf, i7, bArr, 0, i9);
        for (byte[] bArr2 : zzI) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i9, length);
            i9 += length;
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final boolean zzD() throws IOException {
        if (zzr() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final int zzf() throws IOException {
        return zzj();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final int zzg() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final int zzh() throws IOException {
        return zzj();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final int zzk() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final int zzl() throws IOException {
        return zzcy.zzF(zzj());
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzj = 0;
            return 0;
        }
        int zzj = zzj();
        this.zzj = zzj;
        if ((zzj >>> 3) != 0) {
            return zzj;
        }
        throw zzed.zzc();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final int zzn() throws IOException {
        return zzj();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final long zzo() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final long zzp() throws IOException {
        return zzr();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final long zzt() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final long zzu() throws IOException {
        return zzcy.zzG(zzr());
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final long zzv() throws IOException {
        return zzr();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final zzcs zzw() throws IOException {
        int zzj = zzj();
        int i6 = this.zzg;
        int i7 = this.zzi;
        if (zzj <= i6 - i7 && zzj > 0) {
            zzcs zzl = zzcs.zzl(this.zzf, i7, zzj);
            this.zzi += zzj;
            return zzl;
        }
        if (zzj != 0) {
            byte[] zzN = zzN(zzj);
            if (zzN != null) {
                return zzcs.zzl(zzN, 0, zzN.length);
            }
            int i8 = this.zzi;
            int i9 = this.zzg;
            int i10 = i9 - i8;
            this.zzk += i9;
            this.zzi = 0;
            this.zzg = 0;
            List<byte[]> zzI = zzI(zzj - i10);
            byte[] bArr = new byte[zzj];
            System.arraycopy(this.zzf, i8, bArr, 0, i10);
            for (byte[] bArr2 : zzI) {
                int length = bArr2.length;
                System.arraycopy(bArr2, 0, bArr, i10, length);
                i10 += length;
            }
            return new zzcp(bArr);
        }
        return zzcs.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final String zzx() throws IOException {
        int zzj = zzj();
        if (zzj > 0) {
            int i6 = this.zzg;
            int i7 = this.zzi;
            if (zzj <= i6 - i7) {
                String str = new String(this.zzf, i7, zzj, zzeb.zzb);
                this.zzi += zzj;
                return str;
            }
        }
        if (zzj == 0) {
            return "";
        }
        if (zzj <= this.zzg) {
            zzK(zzj);
            String str2 = new String(this.zzf, this.zzi, zzj, zzeb.zzb);
            this.zzi += zzj;
            return str2;
        }
        return new String(zzM(zzj, false), zzeb.zzb);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final String zzy() throws IOException {
        byte[] zzM;
        int zzj = zzj();
        int i6 = this.zzi;
        int i7 = this.zzg;
        if (zzj <= i7 - i6 && zzj > 0) {
            zzM = this.zzf;
            this.zzi = i6 + zzj;
        } else {
            if (zzj == 0) {
                return "";
            }
            i6 = 0;
            if (zzj <= i7) {
                zzK(zzj);
                zzM = this.zzf;
                this.zzi = zzj;
            } else {
                zzM = zzM(zzj, false);
            }
        }
        return zzgs.zzd(zzM, i6, zzj);
    }
}
