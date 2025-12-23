package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzcu extends zzcy {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    /* synthetic */ zzcu(byte[] bArr, int i6, int i7, boolean z5, zzct zzctVar) {
        super(null);
        this.zzj = Integer.MAX_VALUE;
        this.zze = bArr;
        this.zzf = 0;
        this.zzh = 0;
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

    private final void zzI() {
        int i6 = this.zzf + this.zzg;
        this.zzf = i6;
        int i7 = this.zzj;
        if (i6 <= i7) {
            this.zzg = 0;
            return;
        }
        int i8 = i6 - i7;
        this.zzg = i8;
        this.zzf = i6 - i8;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final void zzA(int i6) {
        this.zzj = i6;
        zzI();
    }

    public final void zzB(int i6) throws IOException {
        if (i6 >= 0) {
            int i7 = this.zzf;
            int i8 = this.zzh;
            if (i6 <= i7 - i8) {
                this.zzh = i8 + i6;
                return;
            }
        }
        if (i6 >= 0) {
            throw zzed.zzj();
        }
        throw zzed.zzf();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final boolean zzC() throws IOException {
        return this.zzh == this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final boolean zzE(int i6) throws IOException {
        int zzm;
        int i7 = i6 & 7;
        int i8 = 0;
        if (i7 == 0) {
            if (this.zzf - this.zzh < 10) {
                while (i8 < 10) {
                    if (zza() < 0) {
                        i8++;
                    }
                }
                throw zzed.zze();
            }
            while (i8 < 10) {
                byte[] bArr = this.zze;
                int i9 = this.zzh;
                this.zzh = i9 + 1;
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
        int i6 = this.zzh;
        if (i6 == this.zzf) {
            throw zzed.zzj();
        }
        byte[] bArr = this.zze;
        this.zzh = i6 + 1;
        return bArr[i6];
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final int zzd() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final int zze(int i6) throws zzed {
        if (i6 < 0) {
            throw zzed.zzf();
        }
        int i7 = i6 + this.zzh;
        if (i7 < 0) {
            throw zzed.zzg();
        }
        int i8 = this.zzj;
        if (i7 > i8) {
            throw zzed.zzj();
        }
        this.zzj = i7;
        zzI();
        return i8;
    }

    public final int zzi() throws IOException {
        int i6 = this.zzh;
        if (this.zzf - i6 < 4) {
            throw zzed.zzj();
        }
        byte[] bArr = this.zze;
        this.zzh = i6 + 4;
        int i7 = bArr[i6] & 255;
        int i8 = bArr[i6 + 1] & 255;
        int i9 = bArr[i6 + 2] & 255;
        return ((bArr[i6 + 3] & 255) << 24) | (i8 << 8) | i7 | (i9 << 16);
    }

    public final int zzj() throws IOException {
        int i6;
        int i7 = this.zzh;
        int i8 = this.zzf;
        if (i8 != i7) {
            byte[] bArr = this.zze;
            int i9 = i7 + 1;
            byte b6 = bArr[i7];
            if (b6 >= 0) {
                this.zzh = i9;
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
                this.zzh = i10;
                return i6;
            }
        }
        return (int) zzs();
    }

    public final long zzq() throws IOException {
        int i6 = this.zzh;
        if (this.zzf - i6 < 8) {
            throw zzed.zzj();
        }
        byte[] bArr = this.zze;
        this.zzh = i6 + 8;
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_acceleration.zzcu.zzr():long");
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final void zzz(int i6) throws zzed {
        if (this.zzi != i6) {
            throw zzed.zzb();
        }
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
            this.zzi = 0;
            return 0;
        }
        int zzj = zzj();
        this.zzi = zzj;
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
        if (zzj > 0) {
            int i6 = this.zzf;
            int i7 = this.zzh;
            if (zzj <= i6 - i7) {
                zzcs zzl = zzcs.zzl(this.zze, i7, zzj);
                this.zzh += zzj;
                return zzl;
            }
        }
        if (zzj != 0) {
            if (zzj > 0) {
                int i8 = this.zzf;
                int i9 = this.zzh;
                if (zzj <= i8 - i9) {
                    int i10 = zzj + i9;
                    this.zzh = i10;
                    return new zzcp(Arrays.copyOfRange(this.zze, i9, i10));
                }
            }
            if (zzj <= 0) {
                throw zzed.zzf();
            }
            throw zzed.zzj();
        }
        return zzcs.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final String zzx() throws IOException {
        int zzj = zzj();
        if (zzj > 0) {
            int i6 = this.zzf;
            int i7 = this.zzh;
            if (zzj <= i6 - i7) {
                String str = new String(this.zze, i7, zzj, zzeb.zzb);
                this.zzh += zzj;
                return str;
            }
        }
        if (zzj == 0) {
            return "";
        }
        if (zzj < 0) {
            throw zzed.zzf();
        }
        throw zzed.zzj();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcy
    public final String zzy() throws IOException {
        int zzj = zzj();
        if (zzj > 0) {
            int i6 = this.zzf;
            int i7 = this.zzh;
            if (zzj <= i6 - i7) {
                String zzd = zzgs.zzd(this.zze, i7, zzj);
                this.zzh += zzj;
                return zzd;
            }
        }
        if (zzj == 0) {
            return "";
        }
        if (zzj <= 0) {
            throw zzed.zzf();
        }
        throw zzed.zzj();
    }
}
